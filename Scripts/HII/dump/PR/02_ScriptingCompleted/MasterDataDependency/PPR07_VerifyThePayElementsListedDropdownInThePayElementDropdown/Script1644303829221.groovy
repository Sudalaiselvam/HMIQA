import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.CostCenterPageSteps as CostCenterPageSteps
import pages.OrgCompModelsPayElementsSteps as OrgCompModelsPayElementsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    'Step 3: Get list of Universal expected PayElements'
    List<String> expectedPayElements = new ArrayList<String>()

    expectedPayElements = ProviderPayRequestSteps.getExpectedPayElements(ProviderPayRequest.getValue('ProviderName',i), ProviderPayRequest.getValue('RequestDate',i), ProviderPayRequest.getValue('CompensationModel',i))

    'Step 4: Navigate to Provider Pay Request'
    ProviderPayRequestSteps.gotoProviderPayRequest()

    'Step 5: Set Provider Name'
    ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName',i))

    'Step 6: select Request Date'
    ProviderPayRequestSteps.selectRequestDate(ProviderPayRequest.getValue('RequestDate',i))

    'Step 7: select Compensation Model'
    ProviderPayRequestSteps.selectCompensationModel(ProviderPayRequest.getValue('CompensationModel',i))

    'Step 8: verify PayElements dropdown list'
    ProviderPayRequestSteps.verifyPayElementsData(expectedPayElements)
}