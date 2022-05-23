import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import core.Logger
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderPayApprovalsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {

	String Provider=ProviderPayApprovals.getValue('ProviderName', i)
	
	Logger.logINFO('Validating Provider Name Web Service Functionality for Provider:'+Provider)
	
	'Step 3: Verify whether Provider has Contract with Mark Complete Status'
	boolean blnContractMarkComplete=ManageProviderContractSteps.VerifyContractWithMarkCompleteStatus(Provider)
	
	'Step 4: Go to Provider Pay Request'
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()

	'Step 5: Enter Provider Name'
	ProviderPayApprovalsSteps.verifyProviderWebService(Provider, blnContractMarkComplete)
}