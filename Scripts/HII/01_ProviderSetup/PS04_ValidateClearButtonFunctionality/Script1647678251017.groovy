import core.Browser
import pages.LoginPageSteps
import configs.HIIConstants
import internal.GlobalVariable
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Enter Provider Search into Provider Search TextBox'
ProviderSetupSteps.setProviderSearch(ProviderSearch)

'Step 05 : Click Search Clear Button'
ProviderSetupSteps.clickSearchClear()

'Step 06 : Verify Search Clear Functionality'
ProviderSetupSteps.verifySearchClearFunctionality()

'Step 07 : Enter Universal Search into Universal Search TextBox'
ProviderSetupSteps.setUniversalSearch(UniversalSearch)

'Step 08 : Click Search Clear Button'
ProviderSetupSteps.clickSearchClear()

'Step 09 : Verify Search Clear Functionality'
ProviderSetupSteps.verifySearchClearFunctionality()