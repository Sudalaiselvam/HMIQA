import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProcessBonusPageSteps as ProcessBonusPageSteps
import pages.PaymentProcessPageSteps as PaymentProcessPageSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

String Provider = '100431'

List<HashMap> lsthmContractDetails=new ArrayList<>()
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
						
						ManageProviderContractSteps.selectCostCentersByOffsetLocation(costCenter)
						List<String> lstPayElements=new ArrayList<String>()
						lstPayElements=ManageProviderContractSteps.getBaseSteps().getControlsName('lblPayElementDesc', 'ManageProviderContractPage')
						int index=0
						for(String cPayElement:lstPayElements)
						{
							index=lstPayElements.indexOf(cPayElement)
							String GLAccNo=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementGLAccNo',index,'ManageProviderContractPage')
							String HIICCID=ManageProviderContractSteps.getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,'ManageProviderContractPage')
							
							/*
							 * println currentYear println CompensationModel println costCenter println
							 * cPayElement
							 */
							
							HashMap<String,String> hmContractDetails=new HashMap<>()
							hmContractDetails.put('CurrentYear', currentYear)
							hmContractDetails.put('CompensationModel', CompensationModel)
							hmContractDetails.put('CostCenter', costCenter)
							hmContractDetails.put('PayElement', cPayElement)
							hmContractDetails.put('GLAccNo', GLAccNo)
							hmContractDetails.put('HIICCID', HIICCID)
							lsthmContractDetails.add(hmContractDetails)
						}
						
					}
				
        }
    }
}

for(HashMap<String,String> hmContractDetails:lsthmContractDetails)
	println hmContractDetails
