import core.Browser
import pages.LoginPageSteps
import configs.HIIConstants
import internal.GlobalVariable
import pages.ProviderSetupSteps

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
ProviderSetupSteps.gotoProviderSetup()