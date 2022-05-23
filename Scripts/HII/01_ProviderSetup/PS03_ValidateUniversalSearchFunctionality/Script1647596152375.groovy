import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Enter Universal Search'
ProviderSetupSteps.setUniversalSearch(UniversalSearch)

'Step 05 : Click Search'
ProviderSetupSteps.clickSearch()

'Step 06 : Verify Universal Search Functionality'
ProviderSetupSteps.verifyUniversalSearchFunctionality()