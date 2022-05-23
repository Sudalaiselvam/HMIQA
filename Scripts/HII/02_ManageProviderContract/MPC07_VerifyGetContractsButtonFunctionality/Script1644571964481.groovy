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

'Step 4: Enter Start Date'
ManageProviderContractSteps.setStartDate(StartDate)

'Step 5: Enter End Date'
ManageProviderContractSteps.setEndDate(EndDate)

'Step 6: CLick Get Contracts Button'
ManageProviderContractSteps.clickGetContracts()

'Step 7: Verify Get Contracts button functionality'
ManageProviderContractSteps.verifyGetContractsFunctionality(StartDate,EndDate)


