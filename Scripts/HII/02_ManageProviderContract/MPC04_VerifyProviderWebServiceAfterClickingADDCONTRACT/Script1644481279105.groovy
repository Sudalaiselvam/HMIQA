import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps


'Step 1: Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

boolean validProvider=ProviderSetupSteps.isProviderActive(Provider)

'Step 3: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 4: Click ADD CONTRACT option'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 5: Verify ADD CONTRACT option click functionality'
ManageProviderContractSteps.verifyADDCONTRACTClickFunctionality()

'Step 6: Enter Provider'
ManageProviderContractSteps.verifyProviderWebService(Provider, validProvider)

