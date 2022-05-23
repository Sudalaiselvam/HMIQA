import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps

'Step 1: Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 4: Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 5: Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 6: Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 7: Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 8: Verify Current Year Drop down list'
ManageProviderContractSteps.verifyCurrentYear()
