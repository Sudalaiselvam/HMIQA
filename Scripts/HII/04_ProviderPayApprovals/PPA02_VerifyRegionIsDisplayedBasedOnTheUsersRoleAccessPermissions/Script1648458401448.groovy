import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.HeaderPageSteps as HeaderPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Expecected list of Regions for User and Role to validate'
Set<String> expectedRegions = new HashSet<String>()
expectedRegions = ManageUserInformationSteps.getRegionsList(UserName, Role)

'Step 04 : Log off for user with Compensation Administrator'
HeaderPageSteps.logOff()

'Step 05 : Login with User Details'
LoginPageSteps.Login(UserName, EncryptedPassword, Role)

'Step 06 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 07 : Verify Regions List'
ProviderPayApprovalsSteps.verifyRegionList(expectedRegions)
