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

String ContractMaxCompensation
String expectedSuccessMSG
String expectedErrorMSG

'Step 03 : get Master Contract Max Compensation'
ContractMaxCompensation = ProviderPayRequestSteps.getMasterContractMaxCompensation(ProviderName, RequestDate, CompensationModel,HIIConstants.MaxCompensationDuration_AcrossMasterContracts)

'Step 04 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 05 : Set provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Get Expected Message'
if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate, CompensationModel, PayElement)) {
    expectedErrorMSG = (((('Pay Request already exists on service date ' + RequestDate) + ' for pay element ') + PayElement) +' , this request will not be raised')
} else {
    expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate) + ' for the Pay Element ') +  PayElement)
}

'Step 06 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

'Step 07 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

'Step 08 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

'Step 09 : Select Pay Element Value'
ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.CONTINUE_ON_FAILURE)

'Step 10 : Save Pay Request'
ProviderPayRequestSteps.savePayRequest_ContinueExceedingMaxCompensation_AcrossMasterContracts(RequestDate, PayElementValue,ContractMaxCompensation)

'Step 11 : Verify Pay Request Creation'
ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG, expectedErrorMSG)