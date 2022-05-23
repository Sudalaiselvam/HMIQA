import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderSetupSteps
import pages.GeneralSettingsSteps
import pages.PayElementColumnConfigurationPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get expected PayElement columns mapped to Compensation Model , Pay Element from Pay Element Column Configuration'
List<String> PayElementColumns=new ArrayList<String>()
PayElementColumns=PayElementColumnConfigurationPageSteps.getPayElementColumnsMappedToCompensationModelPayElement(MasterCompensationModel, PayElement)

'Step 04 : Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 05 : Click ADD CONTRACT'
ManageProviderContractSteps.clickADDCONTRACT()
  
'Step 06 : Enter Provider'
ManageProviderContractSteps.setProvider(Provider)
  
'Step 07 : Enter Master Contract Start Date'
ManageProviderContractSteps.setMasterContractStartDate(MasterContractStartDate)
  
'Step 08 : Enter Master Contract End Date'
ManageProviderContractSteps.setMasterContractEndDate(MasterContractEndDate)
  
'Step 09 : Click Add New Contract'
ManageProviderContractSteps.clickAddNewContract()
  
'Step 10 : Select Master Compensation Model'
ManageProviderContractSteps.selectCompModelPopup_MasterCompensationModel(MasterCompensationModel)
  
'Step 11 : Click Add Button'
ManageProviderContractSteps.clickCompModelPopup_AddButton()

'Step 12 : Enter Contract Start Date'  
ManageProviderContractSteps.setContractStartDate(ContractStartDate)

'Step 13 : Enter Contract End Date'  
ManageProviderContractSteps.setContractEndDate(ContractEndDate)

'Step 14 : Select PayElement'
ManageProviderContractSteps.selectContractTab_PayElement(PayElement)

'Step 15 : Verify Pay Element Column of Pay Element'
ManageProviderContractSteps.verifyPayElementColummnsOfPayElement(PayElement,PayElementColumns)



