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

String Provider='100431'


List<HashMap> test1=new ArrayList<>()

ManageProviderContractSteps.gotoManageProviderContract()
ManageProviderContractSteps.setProviderID(Provider)
ManageProviderContractSteps.editProviderContract()
List<String> lstCurrentYear=new ArrayList<String>()
lstCurrentYear=ManageProviderContractSteps.getCurrentYear()
for(String currentYear:lstCurrentYear) {
	ManageProviderContractSteps.selectCurrentYear(currentYear)
	List<String> lstCompModels=new ArrayList<String>()
	
	ManageProviderContractSteps.isCompensationModelTabsClickable()
	lstCompModels=ManageProviderContractSteps.getCompModelsTabs()
	for(String CompModel:lstCompModels) {
		ManageProviderContractSteps.selectCompModelTab(CompModel)
		List<String> lstCostCenters=new ArrayList<String>()
		ManageProviderContractSteps.isCostCentersTabsClickable()
		lstCostCenters=ManageProviderContractSteps.getCostCenterTabsJSExecutor()
		for(String sCostCenter:lstCostCenters) {
			ManageProviderContractSteps.selectCostCenterTab(sCostCenter)
			List<String> lstPayElements=new ArrayList<String>()
			lstPayElements=ManageProviderContractSteps.getPayElements()
			int index=0
			for(String cPayElement:lstPayElements) {
				String sPayElement=cPayElement.split('-')[0].trim()
					index=lstPayElements.indexOf(cPayElement)
					String GLAccNo=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementGLAccNo',index,'ManageProviderContractPage')
					String HIICCID=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,'ManageProviderContractPage')
					
					HashMap<String,String> ContractDetails=new HashMap<String,String>()
					ContractDetails.put('CurrentYear',currentYear.trim())
					ContractDetails.put('CompensationModel',CompModel.trim())
					ContractDetails.put('CostCenter',sCostCenter.trim())
					ContractDetails.put('PayElement',sPayElement)
					ContractDetails.put('GLAccNo',GLAccNo)
					ContractDetails.put('HIICCID',HIICCID)
					test1.add(ContractDetails)
					//dContractDetails.add(ContractDetails)
				//println 'Current Year : '+currentYear.trim()+', Compensation Model : '+CompModel.trim()+', Cost Center : '+sCostCenter.trim()+', Pay Element :'+sPayElement+', GL Acc No: '+GLAccNo+' and HII CC ID : '+HIICCID
			}
		}
	}
}

for(HashMap<String,String> cDetails:test1)
println cDetails


