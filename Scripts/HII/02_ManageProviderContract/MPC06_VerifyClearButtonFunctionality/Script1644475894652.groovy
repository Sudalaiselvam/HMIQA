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

'Step 4: Select Region'
ManageProviderContractSteps.selectRegion(Region)

'Step 5: Select Compensation Model'
ManageProviderContractSteps.selectCompensationModel(CompensationModel)

'Step 6: Enter Start Date'
ManageProviderContractSteps.setStartDate(StartDate)

'Step 7: Enter End Date'
ManageProviderContractSteps.setEndDate(EndDate)

'Step 8: Enter Provider'
ManageProviderContractSteps.setProviderID(ProviderID)

'Step 9: Enter Universal Search'
ManageProviderContractSteps.setUniversalSearch(UniversalSearch)

'Step 10: CLick Clear Button'
ManageProviderContractSteps.clickClear()

'Step 11: Verify Clear Button click functionality'
ManageProviderContractSteps.verifyClearButtonClickFunctionality()

