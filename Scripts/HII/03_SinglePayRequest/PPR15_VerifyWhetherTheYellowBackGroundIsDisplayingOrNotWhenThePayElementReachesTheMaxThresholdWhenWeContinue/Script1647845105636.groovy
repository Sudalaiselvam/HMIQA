import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

String ContractPayElementThreshold
String expectedSuccessMSG
String expectedErrorMSG

'Step 03 : Get Pay Element Threshold'
ContractPayElementThreshold = ProviderPayRequestSteps.getPayElementThreshold(ProviderName,RequestDate,CompensationModel,PayElement)

'Step 04 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 05 : Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Get Expected Message'
if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate,CompensationModel,PayElement)) {
    expectedErrorMSG = (((('Pay Request already exists on service date ' + RequestDate) +' for pay element ') + PayElement) + ' , this request will not be raised')
} else {
    expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' +RequestDate) + ' for the Pay Element ') + PayElement)
}

'Step 06 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

'Step 07 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

'Step 08 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

'Step 09 : Select Pay Element Value'
ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.CONTINUE_ON_FAILURE)

'Step 10 : Select Pay Element Reason'
ProviderPayRequestSteps.selectPayElementReason(Reason, FailureHandling.OPTIONAL)

'Step 11 : Select Pay Element GL Account'
ProviderPayRequestSteps.setPayElementGLAccount(GLAccount, FailureHandling.OPTIONAL)

'Step 12 : Select Pay Element Location Cost Center'
ProviderPayRequestSteps.setPayElementLocationCostCenter(Location_CostCenter, FailureHandling.OPTIONAL)

'Step 13 : Select Pay Element Pay Date'
ProviderPayRequestSteps.selectPayElementPayDate(PayDate, FailureHandling.OPTIONAL)

'Step 14 : Select Pay Element Check Group'
ProviderPayRequestSteps.selectPayElementCheckGroup(Checkgroup, FailureHandling.OPTIONAL)

'Step 15 : Save pay Request after reaching Max Threshold'
ProviderPayRequestSteps.savePayRequest_reachingMaxThresholdContinue(RequestDate,CompensationModel,PayElement,PayElementValue, expectedSuccessMSG, expectedErrorMSG)