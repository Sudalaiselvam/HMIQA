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

'Step 3: Verify Provider exists from Provider Setup Screen'
if(ProviderSetupSteps.verifyProviderExists(Provider))
{

'Step 4: Go to Manage Provider Contract'
	ManageProviderContractSteps.gotoManageProviderContract()

'Step 5: Click ADD CONTRACT'	
	ManageProviderContractSteps.clickADDCONTRACT()

'Step 6: Enter Provider'	
	ManageProviderContractSteps.setProvider(Provider)
	
'Step 7: Verify Contract tabs displayed'
	boolean blnContracts=ManageProviderContractSteps.ContractTabsDisplayed()

'Step 8: Go to Manage Provider Contract'		
	ManageProviderContractSteps.gotoManageProviderContract()

'Step 9: Verify Provider ID Web Service'		
	ManageProviderContractSteps.verifyProviderIDWebService(Provider, blnContracts)

}
