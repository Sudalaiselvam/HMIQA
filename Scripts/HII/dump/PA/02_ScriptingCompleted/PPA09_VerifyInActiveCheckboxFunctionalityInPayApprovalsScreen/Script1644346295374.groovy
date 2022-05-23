import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps

'Step 1: Log in to the H2 Application with valid credentials'
Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	String Provider=ProviderPayApprovals.getValue('Provider', i)
	
	'Step 2: Mouse hover on "Payments" Tab and Click on "Pay Approvals" Menu.'
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    'Step 3: Enable the checkbox "show Inactive"  and click on Get Details button.'
    ProviderPayApprovalsSteps.checkShowInactive()

    ProviderPayApprovalsSteps.setProvider(Provider)

    ProviderPayApprovalsSteps.clickGetDetails()

    'Step 4: Verify Pay Requests created for "Inactive" Contracts'
    ProviderPayApprovalsSteps.verifyPayRequestsCreatedForInactiveContracts()
}