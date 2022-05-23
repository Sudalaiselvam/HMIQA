import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.CostCenterPageSteps

String Provider='PaymentProcess05'
String actualPayElement='APP supervision pay'
String actualCostCenter='Cost Center-1123'

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

List<HashMap> lsthmContractDetails=new ArrayList<>()
ManageProviderContractSteps.gotoManageProviderContract()
ManageProviderContractSteps.setProviderID(Provider)
ManageProviderContractSteps.editProviderContract()
List<String> lstCurrentYear = new ArrayList<String>()
lstCurrentYear = ManageProviderContractSteps.getCurrentYear()

String PositionLevel
String EmployeeType
String Location
String Specialty

for (String currentYear : lstCurrentYear) {
	
	ManageProviderContractSteps.selectCurrentYear(currentYear)
	PositionLevel=ManageProviderContractSteps.getPosition()
	
	
	EmployeeType=ManageProviderContractSteps.getEmployeeType()
	
	List<String> lstCompModels = new ArrayList<String>()
	if (ManageProviderContractSteps.isCompensationModelTabsClickable()) {
		lstCompModels = ManageProviderContractSteps.getCompModelsTabs()
		for (String CompensationModel : lstCompModels) {
			
			Location=ManageProviderContractSteps.getLocation()
			
			Specialty=ManageProviderContractSteps.getSpecialty()
			
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
							
							println PositionLevel
							println EmployeeType
							println Location
							println Specialty
							
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

String contractCostCenter,contractHIICCID='',contractGLAccNo='',contractLocation,contractSpecialty,contractCompModel,contractPositionLevel,contractEmployeeType,hmPayElement,hmCostCenter
contractCostCenter=CostCenterPageSteps.getHIICCIDCostCenterShortNameforCostCenterName(actualCostCenter)
contractHIICCID=CostCenterPageSteps.getHIICCIDforCostCenterName(actualCostCenter)
for(HashMap<String,String> hmContractDetails:lsthmContractDetails) {
	
	println hmContractDetails
	hmPayElement=hmContractDetails.get('PayElement').split('-')[0].trim()
	hmCostCenter=hmContractDetails.get('CostCenter').trim()
	println hmPayElement
	println actualPayElement
	println hmCostCenter
	println contractCostCenter
	
	println hmPayElement.equals(actualPayElement)
	println hmCostCenter.equals(contractCostCenter)	
	if(hmPayElement.equals(actualPayElement) && hmCostCenter.equals(contractCostCenter)) {
		println 'Inside'
		contractGLAccNo=hmContractDetails.get('GLAccNo')
		contractLocation=hmContractDetails.get('Location')
		contractSpecialty=hmContractDetails.get('Specialty')
		contractCompModel=hmContractDetails.get('CompensationModel').substring(hmContractDetails.get('CompensationModel').lastIndexOf('-')+1).trim()
		contractPositionLevel=hmContractDetails.get('PositionLevel')
		contractEmployeeType=hmContractDetails.get('EmployeeType')
	}
	
			
	if(hmPayElement.equals(actualPayElement) && hmCostCenter.equals(contractCostCenter))
	{
		contractGLAccNo=hmContractDetails.get('GLAccNo')
		contractLocation=hmContractDetails.get('Location')
		contractSpecialty=hmContractDetails.get('Specialty')
		contractCompModel=hmContractDetails.get('CompensationModel').substring(hmContractDetails.get('CompensationModel').lastIndexOf('-')+1).trim()
		contractPositionLevel=hmContractDetails.get('PositionLevel')
		contractEmployeeType=hmContractDetails.get('EmployeeType')
		break
		}
	}

	println contractLocation
	println contractSpecialty
	println contractPositionLevel
	println contractEmployeeType
	println contractCompModel
	println contractHIICCID
	println contractGLAccNo