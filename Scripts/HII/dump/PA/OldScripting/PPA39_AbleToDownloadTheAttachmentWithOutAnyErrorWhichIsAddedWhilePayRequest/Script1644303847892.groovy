import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    'Test Data'
    String Provider = ProviderPayApprovals.getValue('Provider', i)

    String RequestDate = ProviderPayApprovals.getValue('RequestDate', i)

    String PayElement = ProviderPayApprovals.getValue('PayElement', i)

    String FileName = ProviderPayRequestSteps.getGridUploadedFilesName(Provider, RequestDate, PayElement)

    if (FileName != '') {
        ProviderPayApprovalsSteps.gotoProviderPayApprovals()

        ProviderPayApprovalsSteps.setProvider(Provider)

        ProviderPayApprovalsSteps.verifyRequestorFileClickFunctionality(PayElement, RequestDate, FileName)
    }
}