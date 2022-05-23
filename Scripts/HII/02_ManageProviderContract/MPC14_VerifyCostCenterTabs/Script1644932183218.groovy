import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps

'Step 1 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3 : Get General Setting - flag for AllowtoGroupContractPayElementsbasedonCostCenter'
String flagSetting=GeneralSettingsSteps.getAllowtoGroupContractPayElementsbasedonCostCenter()

'Step 4 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 5 : Click Add Contract'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 6 : Enter Provider'
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

'Step 13 : Verify CostCenter Tab and options based on Flag Setting'
ManageProviderContractSteps.verifyCostCenterTab_CostCenterDisplayed(flagSetting)


