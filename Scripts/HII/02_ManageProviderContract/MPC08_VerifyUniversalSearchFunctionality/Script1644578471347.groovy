import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER,GlobalVariable.COMPADMIN_PWD,HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 4: Enter Universal Search'
ManageProviderContractSteps.setUniversalSearch(UniversalSearch)

'Step 5: Click Search button'
ManageProviderContractSteps.clickSearch()

'Step 6: Verify Universal Search Functionality'
ManageProviderContractSteps.verifyUniversalSearchFunctionality(UniversalSearch)

