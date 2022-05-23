import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderPayApprovalsSteps
import pages.GeneralSettingsSteps

'Step 1: Log in to the H2 Application with valid credentials'
Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD,HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	

'Step 2: Mouse hover on "Payments" Tab and Click on "Pay Approvals" Menu.'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 3: Enable the checkbox "show Inactive"  and click on Get Details button.'
ProviderPayApprovalsSteps.checkShowInactive()
//ProviderPayApprovalsSteps.setProvider(ProviderPayApprovals.getValue('Provider', i))
ProviderPayApprovalsSteps.selectPayrollStatus(ProviderPayApprovals.getValue('PayrollStatus',i))
ProviderPayApprovalsSteps.selectYear(ProviderPayApprovals.getValue('Year',i))
ProviderPayApprovalsSteps.clickGetDetails()

'Step 4: Verify Pay Requests created for "Inactive" Contracts'
ProviderPayApprovalsSteps.verifyPayRequestsCreatedForInactiveContracts()

}