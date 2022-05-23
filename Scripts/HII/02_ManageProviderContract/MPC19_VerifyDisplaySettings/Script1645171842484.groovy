import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.CompModelPayElementSettingsPageSteps
import pages.ModelWiseProfileTypeSettingsPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Misc Profile Types mapped to Compensation Model'
List<String> lstMiscProfileTypes=new ArrayList<String>()
lstMiscProfileTypes=ModelWiseProfileTypeSettingsPageSteps.getMiscProfileTypesMappedToCompensationModel(MasterCompensationModel)

'Step 04 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 05 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 06 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 7 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 8 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 9 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 11 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 12 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 13 : Verify Display Settings list'
ManageProviderContractSteps.verifyDefaultDisplaySettings(lstMiscProfileTypes)
