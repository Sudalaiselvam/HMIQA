import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.HeaderPageSteps as HeaderPageSteps
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import configs.HIIConstants as HIIConstants



Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)


ProviderPayRequestSteps.verifyProviderName(Provider)
