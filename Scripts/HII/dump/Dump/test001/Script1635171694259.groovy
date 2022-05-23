import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import configs.HIIConstants

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)




