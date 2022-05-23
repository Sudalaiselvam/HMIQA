import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

String Provider='PayApproval06'

ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.setProvider(Provider)

ProviderPayApprovalsSteps.verifyExportPayRequestsClickFunctionality()
