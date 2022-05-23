import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.HeaderPageSteps as HeaderPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get List of Regions Mapped to  UserName -UserRole from Manage User Information screen'
Set<String> expectedRegions = new HashSet<String>()
expectedRegions = ManageUserInformationSteps.getRegionsList(UserName, Role)

'Step 04 : Log Off'
HeaderPageSteps.logOff()

'Step 05 : Login with UserName checking for Regions mapped'
LoginPageSteps.Login(UserName, EncryptedPassword, Role)

'Step 06 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 07 : Verify Regions List'
ManageProviderContractSteps.verifyRegionList(expectedRegions)

'Step 08 : Log Off'
HeaderPageSteps.logOff()