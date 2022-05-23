import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.CompModelPayElementSettingsPageSteps
import pages.ModelWiseProfileTypeSettingsPageSteps
import pages.MiscellaneousProfileSettingsPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 04 : Enter Provider'
ManageProviderContractSteps.setProviderID(Provider)

'Step 05 : Edit Provider Contract'
ManageProviderContractSteps.editProviderContract()

'Step 06 : Select Compensation Model Contract Tab'
ManageProviderContractSteps.selectCompensationModelTab(MasterCompensationModel)

'Step 07 : Inactive Contract'
ManageProviderContractSteps.setContractInActive()

'Step 08 : Save Changes'
ManageProviderContractSteps.clickSave()
ManageProviderContractSteps.verifySuccessMessage()

'Step 09 : Delete Contract'
ManageProviderContractSteps.deleteContract()
ManageProviderContractSteps.verifySuccessMessage()



