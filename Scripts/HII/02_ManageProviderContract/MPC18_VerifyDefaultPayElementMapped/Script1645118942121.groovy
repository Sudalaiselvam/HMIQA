import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.CompModelPayElementSettingsPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Provider Details from Provider Setup'
HashMap<String,String> ProviderDetails=new HashMap<String,String>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)
String Region=ProviderDetails.get('Region')
String Specialty=ProviderDetails.get('PrimarySpecialty')
String CostCenter=ProviderDetails.get('PrimaryCostCenter')

'Step 04 : Get Default PayElement mapped'
List<String> PayElements=new ArrayList<String>()
PayElements=CompModelPayElementSettingsPageSteps.getDefaultPaymentMapped(Region, MasterCompensationModel, Specialty, CostCenter, ContractStartDate.split('/')[2])

'Step 05 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 06 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()

'Step 07 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)

'Step 08 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)

'Step 09 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)

'Step 10 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()

'Step 11 : Select Master Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)

'Step 12 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 13 : Enter Contract Start Date'
ManageProviderContractSteps.setContractStartDate(ContractStartDate)

'Step 14 : Enter Contract End Date'
ManageProviderContractSteps.setContractEndDate(ContractEndDate)

'Step 15 : Verify Default Pay Element'
ManageProviderContractSteps.verifyDefaultPayElement(PayElements)

