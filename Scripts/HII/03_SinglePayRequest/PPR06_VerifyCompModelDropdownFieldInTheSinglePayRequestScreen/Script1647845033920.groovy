import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: get expected list of Compensation list'
HashSet<String> expectedCompensationModels = new HashSet<String>()

expectedCompensationModels = ProviderPayRequestSteps.getExpectedCompensationModels(ProviderName,RequestDate)

'Step 4: Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 5: Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName)

'Step 6: Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate)

'Step 7: verify list of Compensation Models'
ProviderPayRequestSteps.verifyCompensationModelData(expectedCompensationModels)
