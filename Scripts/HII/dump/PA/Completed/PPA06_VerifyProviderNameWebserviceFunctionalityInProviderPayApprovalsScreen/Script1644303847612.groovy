import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {

	'Step 3: Get ProviderName validity'
	boolean validProvider=false
	validProvider = ProviderPayApprovalsSteps.getContractProviderNameValidity(ProviderPayApprovals.getValue('ProviderName', i))

	'Step 4: Go to Provider Pay Request'
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()

	'Step 5: Enter Provider Name'
	ProviderPayApprovalsSteps.verifyProviderWebService(ProviderPayApprovals.getValue('ProviderName', i), validProvider)
}