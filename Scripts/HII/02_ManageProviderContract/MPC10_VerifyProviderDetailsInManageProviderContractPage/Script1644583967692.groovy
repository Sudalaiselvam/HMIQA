import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderSetupSteps
import pages.ManageProviderContractSteps

'Step 1: Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Get details from Provider Setup Screen'
HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)

'Step 4: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()
	
'Step 5: Click Add Contract'
ManageProviderContractSteps.clickADDCONTRACT()
	
'Step 6: Enter Provider'
ManageProviderContractSteps.setProvider(Provider)
	
'Step 7: Verify Provider Details, captured from Provider Setup'
ManageProviderContractSteps.verifyProviderDetails(ProviderDetails)
	