import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 04 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 05 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 06 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 07 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 08 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 09 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 10 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 11 : Enter Contract Start Date'
ManageProviderContractSteps.setContractStartDate(ContractStartDate)

'Step 12 : Enter Contract End Date'
ManageProviderContractSteps.setContractEndDate(ContractEndDate)

'Step 13 : Select Pay Element'
ManageProviderContractSteps.selectContractTab_PayElement(PayElement)

'Step 14 : Verify Pay Element default Start Date'
ManageProviderContractSteps.verifyPayElementDefaultStartDate()

'Step 15 : Verify Pay Element default End Date'
ManageProviderContractSteps.verifyPayElementDefaultEndDate()





