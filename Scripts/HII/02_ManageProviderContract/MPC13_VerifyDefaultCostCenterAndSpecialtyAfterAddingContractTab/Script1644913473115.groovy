import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps

'Step 1 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 2 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3 : get Provider Details'
HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)

String defaultRegion=ProviderDetails.get('Region')
String defaultLocation=ProviderDetails.get('Location')
String defaultCostCenter=ProviderDetails.get('PrimaryCostCenter')
String defaultSpecialty=ProviderDetails.get('PrimarySpecialty')

'Step 4 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 5 : Click ADD CONTRACT '
ManageProviderContractSteps.clickADDCONTRACT()

'Step 6 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 7 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 8 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 9 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 10 : Verify Region deafult value  '
ManageProviderContractSteps.verifyDefaultMasterRegionValidation(defaultRegion)

'Step 11 : Select Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 12 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 13 : Verify Contract Tab '
ManageProviderContractSteps.verifyContractTabAfterSelectingCompensationModel(defaultRegion,defaultLocation,MasterCompensationModel)

'Step 14 : verify Default Cost Center'
ManageProviderContractSteps.verifyDefaultCostCenter(defaultCostCenter)

'Step 15: verify Default Specialty'
ManageProviderContractSteps.verifyDefaultSpecialty(defaultSpecialty)



