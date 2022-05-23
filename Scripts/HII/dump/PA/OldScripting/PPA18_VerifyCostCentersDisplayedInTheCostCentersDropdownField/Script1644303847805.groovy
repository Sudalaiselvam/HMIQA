import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.CostCenterPageSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	List<String> lstexpectedCostCenters = new ArrayList<String>()
	
	lstexpectedCostCenters=CostCenterPageSteps.getCostCenterNameWRTRegionLocation(ProviderPayApprovals.getValue('Region', i), ProviderPayApprovals.getValue('Location', i))
	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region', i))

    ProviderPayApprovalsSteps.selectLocation(ProviderPayApprovals.getValue('Location', i))

   	ProviderPayApprovalsSteps.verifyCostCenterListDropdown(lstexpectedCostCenters)

	
}