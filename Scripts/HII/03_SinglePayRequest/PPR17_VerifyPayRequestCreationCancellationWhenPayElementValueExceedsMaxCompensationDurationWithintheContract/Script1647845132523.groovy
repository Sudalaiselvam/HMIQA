import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Master Contract Max Compensation'
String ContractMaxCompensation
ContractMaxCompensation = ProviderPayRequestSteps.getMasterContractMaxCompensation(ProviderName, RequestDate, CompensationModel,HIIConstants.MaxCompensationDuration_WithintheContract)

'Step 04 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 05 : Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Step 06 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

'Step 07 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

'Step 08 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

'Step 09 : Select Pay Element Value'
ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.CONTINUE_ON_FAILURE)

'Step 10 : Save Pay Request'
ProviderPayRequestSteps.savePayRequest_CancelExceedingMaxCompensation_WithintheContract(RequestDate, CompensationModel,PayElementValue, ContractMaxCompensation)