import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProcessBonusPageSteps
import pages.PaymentProcessPageSteps
import pages.ProviderSetupSteps
import pages.ManageProviderContractSteps
import pages.ProviderPayApprovalsSteps
import pages.ProviderSetupSteps
import pages.GLAccountMaintenanceByPEPageSteps
import pages.CostCenterPageSteps
import pages.ProviderPayRequestSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()
  
'Step 04 : Select Region' 
PaymentProcessPageSteps.selectRegion(Region)
  
'Step 05 : Select Pay Cycle' 
PaymentProcessPageSteps.selectPayCycle(PayCycle)
  
'Step 06 : Select Year' 
PaymentProcessPageSteps.selectYear(Year)
  
'Step 07 : Select Pay Period'
 PaymentProcessPageSteps.selectPayPeriod(PayPeriod)
  
'Step 08 : Select All Location' 
PaymentProcessPageSteps.selectallLocations()
  
if(PaymentProcessPageSteps.isPhysicianNameDisplayed()) {
	  PaymentProcessPageSteps.checkProcessByProvider()
	  PaymentProcessPageSteps.setPhysicianName(Provider)
	  PaymentProcessPageSteps.clickAdd()
 }
  
'Step 09 : Click Process Compensation and Accept Alert If Popup'
if(PaymentProcessPageSteps.isProcessCompensationButtonDisplayed())
	PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)
  
'Step 10 : Pick one record for Validation' 
HashMap<String,String> PaymentProcess=new HashMap<String,String>()
PaymentProcess=PaymentProcessPageSteps.getRandomPaymentProcessRecordToValidate() 
println PaymentProcess
String actualPayElement=PaymentProcess.get('PayElement')
String actualCostCenter=PaymentProcess.get('CostCenter')
String actualHIICCID=PaymentProcess.get('HIICCID')
String actualGLAccNo=PaymentProcess.get('GLAccNo')


println actualHIICCID
println actualGLAccNo

String expectedHIICCID
String expectedGLAccNo

HashMap<String,String> PayRequestHIICCIDGLACCNo=new HashMap<String,String>()
PayRequestHIICCIDGLACCNo=ProviderPayRequestSteps.getGridGLAccNoHIICCID(Provider, actualPayElement, actualCostCenter)

println PayRequestHIICCIDGLACCNo

'Step 11 : Go to Provider Pay Approval '
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 12 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 13 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 14 : Select Pay Cycle'
ProviderPayApprovalsSteps.selectPayCycle(PayCycle)

'Step 15 : Select Payroll Status as Approved'
ProviderPayApprovalsSteps.selectPayrollStatusAsApproved()

'Step 16 : Select Year'
//ProviderPayApprovalsSteps.selectYear(Year)

'Step 17 : Select Pay Period'
//ProviderPayApprovalsSteps.selectPayPeriod(PayPeriod)

'Step 18: Click Get Details'
ProviderPayApprovalsSteps.clickGetDetails()

'Step 19: Get Expected GLAccNo & HII CC ID'
HashMap<String,String> PayApprovalHIICCIDGLACCNo=new HashMap<String,String>()
PayApprovalHIICCIDGLACCNo=ProviderPayApprovalsSteps.getGridGLAccNoHIICCID(actualPayElement, actualCostCenter)
String PPAGLAccNo=PayApprovalHIICCIDGLACCNo.get('GLAccNo')
String PPAHIICCID=PayApprovalHIICCIDGLACCNo.get('HIICCID')

if(!PPAGLAccNo.isEmpty())
	expectedGLAccNo=PPAGLAccNo
if(!PPAHIICCID.isEmpty())
	expectedHIICCID=PPAHIICCID


List<HashMap> lsthmContractDetails=new ArrayList<>()
ManageProviderContractSteps.gotoManageProviderContract()
ManageProviderContractSteps.setProviderID(Provider)
ManageProviderContractSteps.editProviderContract()
List<String> lstCurrentYear = new ArrayList<String>()
lstCurrentYear = ManageProviderContractSteps.getCurrentYear()
for (String currentYear : lstCurrentYear) {
	
	ManageProviderContractSteps.selectCurrentYear(currentYear)
	String PositionLevel=ManageProviderContractSteps.getPosition()
	String EmployeeType=ManageProviderContractSteps.getEmployeeType()
	
	List<String> lstCompModels = new ArrayList<String>()
	if (ManageProviderContractSteps.isCompensationModelTabsClickable()) {
		lstCompModels = ManageProviderContractSteps.getCompModelsTabs()
		for (String CompensationModel : lstCompModels) {
			
			String Location=ManageProviderContractSteps.getLocation()
			String Specialty=ManageProviderContractSteps.getSpecialty()
			
			ManageProviderContractSteps.selectCompensationModelTab(CompensationModel)
			List<String> lstCostCenters=new ArrayList<String>();
					lstCostCenters=ManageProviderContractSteps.getCostCenterTabName()
					for(String costCenter:lstCostCenters) {
						
						ManageProviderContractSteps.selectCostCentersByOffsetLocation(costCenter)
						List<String> lstPayElements=new ArrayList<String>()
						lstPayElements=ManageProviderContractSteps.getBaseSteps().getControlsName('lblPayElementDesc', 'ManageProviderContractPage')
						int index=0
						for(String cPayElement:lstPayElements)
						{
							index=lstPayElements.indexOf(cPayElement)
							String GLAccNo=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementGLAccNo',index,'ManageProviderContractPage')
							String HIICCID=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,'ManageProviderContractPage')
							
							HashMap<String,String> hmContractDetails=new HashMap<>()
							hmContractDetails.put('CurrentYear', currentYear)
							hmContractDetails.put('CompensationModel', CompensationModel)
							hmContractDetails.put('CostCenter', costCenter)
							hmContractDetails.put('PayElement', cPayElement)
							hmContractDetails.put('GLAccNo', GLAccNo)
							hmContractDetails.put('HIICCID', HIICCID)
							hmContractDetails.put('PositionLevel', PositionLevel)
							hmContractDetails.put('EmployeeType', EmployeeType)
							hmContractDetails.put('Location', Location)
							hmContractDetails.put('Specialty', Specialty)
							lsthmContractDetails.add(hmContractDetails)
						}
						
					}
				
		}
	}
}

String contractCostCenter,contractHIICCID='',contractGLAccNo='',contractLocation,contractSpecialty,contractCompModel,contractPositionLevel,contractEmployeeType
for(HashMap<String,String> hmContractDetails:lsthmContractDetails) {
	contractCostCenter=CostCenterPageSteps.getHIICCIDCostCenterShortNameforCostCenterName(actualCostCenter)
	
	if(hmContractDetails.get('PayElement').startsWith(actualPayElement) && hmContractDetails.get('CostCenter').equals(contractCostCenter))
	{
		contractHIICCID=CostCenterPageSteps.getHIICCIDforCostCenterName(actualCostCenter)
		contractGLAccNo=hmContractDetails.get('GLAccNo')
		contractLocation=hmContractDetails.get('Location')
		contractSpecialty=hmContractDetails.get('Specialty')
		contractCompModel=hmContractDetails.get('CompensationModel').substring(hmContractDetails.get('CompensationModel').lastIndexOf('-')+1).trim()
		contractPositionLevel=hmContractDetails.get('PositionLevel')
		contractEmployeeType=hmContractDetails.get('EmployeeType')
		break
		}
	}

	println expectedHIICCID
	println expectedGLAccNo
	println contractHIICCID
	println contractGLAccNo	

	/*
	 * if(expectedHIICCID.isEmpty() && !contractHIICCID.isEmpty())
	 * expectedHIICCID=contractHIICCID
	 * 
	 * if(expectedGLAccNo.isEmpty() && !contractGLAccNo.isEmpty())
	 * expectedGLAccNo=contractGLAccNo
	 * 
	 */	


String EffectiveFrom=PayPeriod.split('-')[0].trim()


GLAccountMaintenanceByPEPageSteps.openGLAccountMaintenanceByPE_newTab()

GLAccountMaintenanceByPEPageSteps.selectPayElement(PayElement)

GLAccountMaintenanceByPEPageSteps.selectRegion(Region)

GLAccountMaintenanceByPEPageSteps.selectLocation(Location)

GLAccountMaintenanceByPEPageSteps.clickShowDetails()

println GLAccountMaintenanceByPEPageSteps.getGridGLAccountNo(Region, contractLocation, contractHIICCID, contractSpecialty, contractCompModel, contractPositionLevel, contractEmployeeType, EffectiveFrom)