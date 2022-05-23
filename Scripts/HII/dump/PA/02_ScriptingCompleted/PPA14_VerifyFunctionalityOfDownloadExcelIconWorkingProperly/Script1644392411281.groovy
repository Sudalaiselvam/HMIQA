import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	
	String Provider=ProviderPayApprovals.getValue('Provider',i)

'Step 3: Go to Provider Pay Approvals'	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 4: Enter Provider'	
	ProviderPayApprovalsSteps.setProvider(Provider)

'Step 5: Click and verify Excel exported successfully'	
	ProviderPayApprovalsSteps.verifyExportPayRequestsClickFunctionality()

	}