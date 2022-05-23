import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

ProviderPayRequestSteps.verifyServiceEndDate(Provider,ServiceEndDate)



