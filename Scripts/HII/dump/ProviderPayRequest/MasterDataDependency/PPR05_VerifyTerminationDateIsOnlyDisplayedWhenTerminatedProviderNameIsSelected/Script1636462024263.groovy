import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: get expected Termination Date'
String expectedTerminationDate=null
expectedTerminationDate=ProviderPayRequestSteps.getExpectedTerminationDate(ProviderName)

println expectedTerminationDate

'Step 4: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 5: set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName)

'Step 6: verify Provider Termination Date'
ProviderPayRequestSteps.verifyProviderTerminationDate(expectedTerminationDate)

