import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
'Step 3: get expected list of Compensation list'
HashSet<String> expectedCompensationModels = new HashSet<String>()

expectedCompensationModels = ProviderPayRequestSteps.getExpectedCompensationModels(ProviderPayRequest.getValue('ProviderName', i), ProviderPayRequest.getValue('RequestDate', i))

'Step 4: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 5: Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName', i))

'Step 6: Select Request Date'
ProviderPayRequestSteps.selectRequestDate(ProviderPayRequest.getValue('RequestDate', i))

'Step 7: verify list of Compensation Models'
ProviderPayRequestSteps.verifyCompensationModelData(expectedCompensationModels)

}