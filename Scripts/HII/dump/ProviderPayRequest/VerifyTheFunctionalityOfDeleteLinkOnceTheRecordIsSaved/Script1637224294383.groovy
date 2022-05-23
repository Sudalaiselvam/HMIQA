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

ProviderPayRequestSteps.gotoProviderPayRequest()

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName', i), FailureHandling.OPTIONAL)

    ProviderPayRequestSteps.deleteProviderPayRequest(ProviderPayRequest.getValue('RequestDate', i), ProviderPayRequest.getValue(
            'CompensationModel', i), ProviderPayRequest.getValue('PayElement', i))
}