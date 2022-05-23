import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.HeaderPageSteps
import pages.ProviderEMRDataPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03: Navigate to Provider EMR Data'
HeaderPageSteps.verifyNavigationToProviderEMRData()

ProviderEMRDataPageSteps.selectRegion(Region)
