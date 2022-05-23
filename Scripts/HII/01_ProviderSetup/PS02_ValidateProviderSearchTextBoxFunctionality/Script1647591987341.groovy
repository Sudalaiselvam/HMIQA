import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Enter Test Data : Provider Search into Provider Search TextBox'
ProviderSetupSteps.setProviderSearch(ProviderSearch)

'Step 05 : Verify Provider Search Functionality'
ProviderSetupSteps.verifyProviderSearchFunctionality()