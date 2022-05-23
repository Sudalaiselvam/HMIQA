import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import utils.Utilities as Utilities
import core.AssertSteps as AssertSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Required Contract Details'
Double ContractMaxCompensation
Double PayElementThreshold
Double PayRequestCompensation
Double PayRequestAmount
Double PayRequestYTDAmount
Double PayRequestThreshold
String ContractPeriod
String ProviderName
String PayPeriod
HashMap<String, String> ContractAmountDetails = new HashMap<String, String>()
ContractAmountDetails = ManageProviderContractSteps.getMaxCompensationAndThresholdAmount(Provider, CompensationModel, PayElement)
ContractMaxCompensation = Double.parseDouble(ContractAmountDetails.get('MaxCompensation').replace(',', ''))
PayElementThreshold = Double.parseDouble(ContractAmountDetails.get('ThresholdAmount').replace(',', ''))
ContractPeriod = ContractAmountDetails.get('ContractPeriod')

'Step 04 : Get Required Pay Request Details'
PayRequestCompensation = ProviderPayRequestSteps.getCompensationForCompensationModel(Provider, CompensationModel, ServiceDate)

'Step 05 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 06 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 07 : Get Required Pay Request Data from Pa Approvals Grid'
HashMap<String, String> PayRequestData = new HashMap<String, String>()
PayRequestData = ProviderPayApprovalsSteps.getGridDataForPayElementWithServiceDate(PayElement, ServiceDate)

PayRequestYTDAmount = Double.parseDouble(PayRequestData.get('YTDAmounts').replace(',', ''))
ProviderName = PayRequestData.get('ProviderName')
PayPeriod = PayRequestData.get('PayPeriod')
String ExceedAmount
String ExpectedMessage

'Step 08 : Define Exceed Amount and expected Message'
if (PayRequestCompensation > ContractMaxCompensation) {
    ExceedAmount = Utilities.getDifferenceBTWValues(ContractMaxCompensation.toString(), PayRequestCompensation.toString())

    ExpectedMessage = HIIConstants.PPA_MaxThresholdLimitPopupMessage(ProviderName, PayElement, CompensationModel, ContractPeriod, 
        ExceedAmount)
} else if (PayRequestYTDAmount > PayElementThreshold) {
    ExceedAmount = Utilities.getDifferenceBTWValues(PayElementThreshold.toString(), PayRequestYTDAmount.toString())

    ExpectedMessage = HIIConstants.PPA_MaxThresholdLimitPopup_ThresholdLimitMessage(ProviderName, PayElement)
}

'Step 09 : Select Pay Element with Service Date'
ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)

'Step 10 : Click Send to Next Approver'
ProviderPayApprovalsSteps.clickSendtoNextApprover()

'Step 11: Verify Alert Message and Send to Next Approver functionality'
if (ExpectedMessage != null) {
    String actualMsg = ProviderPayApprovalsSteps.getMaxCompensationAndThresholdExceedAlertMessage()

    String AssertMsg = (('Actual:\n ' + actualMsg) + ' and Expected:\n') + ExpectedMessage

    AssertSteps.verifyActualResult(actualMsg.equals(ExpectedMessage), AssertMsg + ' : PASS', AssertMsg + ' : FAIL')

    ProviderPayApprovalsSteps.clickCancel()
} else {
    ProviderPayApprovalsSteps.verifySendtoNextApproverFunctionality()
}