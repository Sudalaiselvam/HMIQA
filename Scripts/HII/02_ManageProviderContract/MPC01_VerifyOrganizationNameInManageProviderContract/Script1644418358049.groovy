import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.OrganizationPageSteps

'Step 1: Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Get Organization Name from Organization Screen'
String expectedOrganizationName=OrganizationPageSteps.getOrganizationName()

'Step 4: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 5: Verify Organization Name'
ManageProviderContractSteps.verifyOrganization(expectedOrganizationName)



