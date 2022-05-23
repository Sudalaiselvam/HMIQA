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

//String flagSetting=GeneralSettingsSteps.getAllowtoGroupContractPayElementsbasedonCostCenter()

ManageProviderContractSteps.gotoManageProviderContract()

ManageProviderContractSteps.clickADDCONTRACT()

ManageProviderContractSteps.setProvider(Provider)

'Step 7 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 8 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 9 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 11 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel('Comp Model 2')

'Step 12 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

ManageProviderContractSteps.setContractStartDate('01/01/2021')

ManageProviderContractSteps.setContractEndDate('12/31/2021')


ManageProviderContractSteps.selectContractTab_PayElement('CME')

//ManageProviderContractSteps.clickAddNewPayElements()



