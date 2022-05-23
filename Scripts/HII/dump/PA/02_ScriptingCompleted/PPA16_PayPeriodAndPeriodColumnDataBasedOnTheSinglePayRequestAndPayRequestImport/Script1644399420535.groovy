import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps



'Step 1: Log in to the H2 Application with valid credentials'
Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	String Provider = ProviderPayApprovals.getValue('Provider', i)
	
	String RequestDate = ProviderPayApprovals.getValue('ServiceDate', i)
	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.setProvider(Provider)

    ProviderPayApprovalsSteps.verifyPayPeriod(RequestDate)
	
	ProviderPayApprovalsSteps.verifyPeriod(RequestDate)
}