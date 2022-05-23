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

String expectedSuccessMSG

'Step 03 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 04 : Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Step 05 : Verify Provider Pay Request Exists'
if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate, CompensationModel, PayElement)) {
    expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate) + ' for the Pay Element ') +PayElement)
}

'Step 06 : Edit Provider Pay Request'
ProviderPayRequestSteps.editProviderPayRequest(RequestDate)

'Step 07 : set Pay Element Value'
ProviderPayRequestSteps.setPayElementValue(PayElementValue)

'Step 08 : Click Save'
ProviderPayRequestSteps.clickSave()

'Step 09 : Verify Provider Pay Request Creation'
ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG)