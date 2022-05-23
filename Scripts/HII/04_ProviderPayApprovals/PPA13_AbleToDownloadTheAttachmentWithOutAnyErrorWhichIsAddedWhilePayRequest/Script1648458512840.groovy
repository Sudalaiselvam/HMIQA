import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Verify and get File Name from Pay Request screen for the Pay Request'
String FileName = ProviderPayRequestSteps.getGridUploadedFilesName(Provider, CompensationModel, PayElement, ServiceDate)

if (FileName != '') {
    'Step 4: Navigate to Provider Pay Approval'
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    'Step 5: Enter Provider'
    ProviderPayApprovalsSteps.setProvider(Provider)

    'Step 6: Verify file click functionality'
    ProviderPayApprovalsSteps.verifyRequestorFileClickFunctionality(PayElement, ServiceDate, FileName)
}