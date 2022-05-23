import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    
	'Step 3: Get ProviderName validity'
    boolean validProvider=false
    validProvider = ProviderPayRequestSteps.getContractProviderNameValidity(ProviderPayRequest.getValue('ProviderName', i))
	
    'Step 4: Go to Provider Pay Request'
    ProviderPayRequestSteps.gotoProviderPayRequest()

    'Step 5: Enter Provider Name'
    ProviderPayRequestSteps.verifyProviderNameWebService(ProviderPayRequest.getValue('ProviderName', i), validProvider)

	}