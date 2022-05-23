import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProcessBonusPageSteps
import pages.PaymentProcessPageSteps
import pages.ProviderSetupSteps
import pages.ManageProviderContractSteps
import pages.ProviderPayApprovalsSteps
import pages.ProviderSetupSteps

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

PaymentProcessPageSteps.checkProcessByProvider()

PaymentProcessPageSteps.setPhysicianName('PaymentProcess05')

PaymentProcessPageSteps.clickAdd()

'Step 09 : Click Process Compensation and Accept Alert If Popup'
PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

'Step 10 : Pick one record for Validation'
HashMap<String,String> PaymentProcess=new HashMap<String,String>()
PaymentProcess=PaymentProcessPageSteps.getRandomPaymentProcessRecordToValidate()
println PaymentProcess



String Provider=PaymentProcess.get('PayrollID')
String PayElement=PaymentProcess.get('PayElement').split('-')[0].trim()
String CostCenter=PaymentProcess.get('CostCenter')
String ActualGLAccNo=PaymentProcess.get('GLAccNo')
String ActualHIICCID=PaymentProcess.get('HIICCID')

/*if(PayElement.contains('Retro'))
	throw new Exception('Automation Scripting is not implemented for PayElement'+PayElement)
*/
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

println PayElement
println CostCenter
println 'From Pay Approval Screen'
'Step 19: Get Expected GLAccNo & HII CC ID'
HashMap<String,String> PayApprovalHIICCIDGLACCNo=new HashMap<String,String>()
PayApprovalHIICCIDGLACCNo=ProviderPayApprovalsSteps.getGridGLAccNoHIICCID(PayElement, CostCenter)
println PayApprovalHIICCIDGLACCNo



//List<HashMap> lsthmContractDetails=new ArrayList<>()
HashMap<String,String> hmContractDetails=new HashMap<>()

ManageProviderContractSteps.gotoManageProviderContract()
ManageProviderContractSteps.setProviderID(Provider)
ManageProviderContractSteps.editProviderContract()
List<String> lstCurrentYear = new ArrayList<String>()
lstCurrentYear = ManageProviderContractSteps.getCurrentYear()
for (String currentYear : lstCurrentYear) {
	
	ManageProviderContractSteps.selectCurrentYear(currentYear)
	List<String> lstCompModels = new ArrayList<String>()
	if (ManageProviderContractSteps.isCompensationModelTabsClickable()) {
		lstCompModels = ManageProviderContractSteps.getCompModelsTabs()
		for (String CompensationModel : lstCompModels) {
			
			ManageProviderContractSteps.selectCompensationModelTab(CompensationModel)
			List<String> lstCostCenters=new ArrayList<String>();
					lstCostCenters=ManageProviderContractSteps.getCostCenterTabName()
					for(String costCenter:lstCostCenters) {
						if(costCenter.endsWith(CostCenter)) {
							ManageProviderContractSteps.selectCostCentersByOffsetLocation(costCenter)
							List<String> lstPayElements=new ArrayList<String>()
							lstPayElements=ManageProviderContractSteps.getBaseSteps().getControlsName('lblPayElementDesc', 'ManageProviderContractPage')
							int index=0
							for(String cPayElement:lstPayElements)
							{
								if(cPayElement.startsWith(PayElement)) {
								index=lstPayElements.indexOf(cPayElement)
								String GLAccNo=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementGLAccNo',index,'ManageProviderContractPage')
								String HIICCID=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,'ManageProviderContractPage')
								
								
								hmContractDetails.put('CurrentYear', currentYear)
								hmContractDetails.put('CompensationModel', CompensationModel)
								hmContractDetails.put('CostCenter', costCenter)
								hmContractDetails.put('PayElement', cPayElement)
								hmContractDetails.put('GLAccNo', GLAccNo)
								hmContractDetails.put('HIICCID', HIICCID)
								//lsthmContractDetails.add(hmContractDetails)
								break
							}
							}
						
					}
					}
				
		}
	}
}

println hmContractDetails




HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)
println ProviderDetails



  
  
  
 


