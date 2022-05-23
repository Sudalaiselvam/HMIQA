import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.PayCycleMappingPageSteps

'Step 1 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3 : Get Provider Details'
HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)
String defaultRegion=ProviderDetails.get('Region')
String defaultLocation=ProviderDetails.get('Location')

'Step 4 : Get PayCycle '
String PayCycle=PayCycleMappingPageSteps.getPayCycleMappedtoRegionLocation(defaultRegion, defaultLocation)

'Step 5 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 6 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 7 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 8 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 9 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 10 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 11 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 12 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 13 : Verify Pay Cycle'
ManageProviderContractSteps.verifyPayCycle(PayCycle)

