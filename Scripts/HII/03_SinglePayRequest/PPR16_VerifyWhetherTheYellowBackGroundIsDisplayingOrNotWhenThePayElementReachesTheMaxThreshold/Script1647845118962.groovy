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

'Step 03 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 04 : Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Step 05 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

'Step 06 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

'Step 07 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

'Step 08 : Verify Exceeded Pay Element Threshold Background Color'
ProviderPayRequestSteps.verifyExceededPayElementThresholdBackgroundColor()