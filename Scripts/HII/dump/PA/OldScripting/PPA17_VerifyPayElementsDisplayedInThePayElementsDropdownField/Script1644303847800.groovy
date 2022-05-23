import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.OrgCompModelsPayElementsSteps as OrgCompModelsPayElementsSteps
import pages.RoleUserWisePayElementsSteps as RoleUserWisePayElementsSteps
import pages.PayElementsSteps as PayElementsSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	Set<String> lstexpectedPayElements = new HashSet<String>()

    lstexpectedPayElements = ProviderPayApprovalsSteps.getExpectedPayElements(HIIConstants.ROLE_CompensationAdministrator,ProviderPayApprovals.getValue('Region', i), ProviderPayApprovals.getValue('CompensationModel', i))
	
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region', i))
	
	ProviderPayApprovalsSteps.selectPayCycle(ProviderPayApprovals.getValue('PayCycle',i))
	
	ProviderPayApprovalsSteps.selectLocation(ProviderPayApprovals.getValue('Location',i))
	
	ProviderPayApprovalsSteps.selectPayrollStatus(ProviderPayApprovals.getValue('PayrollStatus',i))
	
	ProviderPayApprovalsSteps.selectYear(ProviderPayApprovals.getValue('Year',i))
	
	ProviderPayApprovalsSteps.selectPayPeriod(ProviderPayApprovals.getValue('PayPeriod',i))
	
    ProviderPayApprovalsSteps.selectCompensationModel(ProviderPayApprovals.getValue('CompensationModel', i))

    ProviderPayApprovalsSteps.verifyPayElementList(lstexpectedPayElements)
}