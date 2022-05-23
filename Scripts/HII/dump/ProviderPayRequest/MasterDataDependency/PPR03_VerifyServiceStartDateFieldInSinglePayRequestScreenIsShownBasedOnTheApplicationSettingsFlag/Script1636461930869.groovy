import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 4: Verify Service Start Date'
ProviderPayRequestSteps.verifyServiceStartDate()