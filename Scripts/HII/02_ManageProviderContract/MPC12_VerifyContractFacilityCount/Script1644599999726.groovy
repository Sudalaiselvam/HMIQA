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

'Step 4: Enter Provider'
ManageProviderContractSteps.setProviderID(Provider)

'Step 5: Get Contract Facility Count from Grid'
long ContractFacilityCount=(ManageProviderContractSteps.getGridContractFacilityCount()).toLong()

'Step 6: Edit Provider Contract'
ManageProviderContractSteps.editProviderContract()

'Step 7: Verify Contract Facility Count with no of Cost Center tabs'
ManageProviderContractSteps.verifyContractFacilityCount(ContractFacilityCount)

