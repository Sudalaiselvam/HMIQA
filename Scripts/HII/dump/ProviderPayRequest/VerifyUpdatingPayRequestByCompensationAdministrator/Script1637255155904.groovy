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

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    ProviderPayRequestSteps.gotoProviderPayRequest()

    ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName', i), FailureHandling.OPTIONAL)

    if (ProviderPayRequestSteps.verifyProviderPayRequestExists(ProviderPayRequest.getValue('RequestDate', i), ProviderPayRequest.getValue(
            'CompensationModel', i), ProviderPayRequest.getValue('PayElement', i))) {
        expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + ProviderPayRequest.getValue('RequestDate', 
            i)) + ' for the Pay Element ') + ProviderPayRequest.getValue('PayElement', i))
    }

    ProviderPayRequestSteps.editProviderPayRequest(ProviderPayRequest.getValue('RequestDate', i))

    ProviderPayRequestSteps.setPayElementValue(ProviderPayRequest.getValue('PayElementValue', i))

    ProviderPayRequestSteps.clickSave()

    ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG)
}