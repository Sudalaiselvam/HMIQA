import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderSetupSteps
import pages.RegionPageSteps
import pages.CommonSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Verify Application Link Responses'
CommonSteps.verifyApplicationLinks()


