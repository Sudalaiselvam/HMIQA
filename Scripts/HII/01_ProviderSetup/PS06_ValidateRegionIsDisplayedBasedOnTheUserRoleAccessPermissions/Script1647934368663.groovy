import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ProviderSetupSteps as ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Get expected list of Regions mapped to User'
Set<String> expectedRegions = new HashSet<String>()
expectedRegions = ManageUserInformationSteps.getRegionsList(UserName, UserRole)

'Step 04 : Log off Compensation Administrator'
HeaderPageSteps.logOff()

'Step 05 : Login with user data'
LoginPageSteps.Login(UserName, UserEncryptedPassword, UserRole)

'Step 06 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 07 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 08 : Verify Region List'
ProviderSetupSteps.verifyRegionList(expectedRegions)