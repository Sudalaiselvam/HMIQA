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

ContractMaxCompensation = ProviderPayRequestSteps.getMasterContractMaxCompensation(ProviderName, RequestDate, CompensationModel, 
    HIIConstants.MaxCompensationDuration_WithintheContract)

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate, CompensationModel, PayElement)) {
    expectedErrorMSG = (((('Pay Request already exists on service date ' + RequestDate) + ' for pay element ') + PayElement) + 
    ' , this request will not be raised')
} else {
    expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate) + ' for the Pay Element ') + 
    PayElement)
}

ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.CONTINUE_ON_FAILURE)

ProviderPayRequestSteps.savePayRequest_ContinueExceedingMaxCompensation_WithintheContract(RequestDate, CompensationModel, 
    PayElementValue, ContractMaxCompensation)

ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG, expectedErrorMSG)