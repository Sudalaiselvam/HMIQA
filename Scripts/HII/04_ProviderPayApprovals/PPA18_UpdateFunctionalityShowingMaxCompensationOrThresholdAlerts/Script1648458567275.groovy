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

'Step 03 : get required Contract details'
Double ContractMaxCompensation

Double PayElementThreshold

Double PayRequestCompensation

Double PayRequestAmount

Double PayRequestYTDAmount

Double PayRequestThreshold

String ContractPeriod

String ProviderName

String PayPeriod

String existingAmount

HashMap<String, String> ContractAmountDetails = new HashMap<String, String>()

ContractAmountDetails = ManageProviderContractSteps.getMaxCompensationAndThresholdAmount(Provider, CompensationModel, PayElement)

ContractMaxCompensation = Double.parseDouble(ContractAmountDetails.get('MaxCompensation').replace(',', ''))

PayElementThreshold = Double.parseDouble(ContractAmountDetails.get('ThresholdAmount').replace(',', ''))

ContractPeriod = ContractAmountDetails.get('ContractPeriod')

'Step 04 : Get required Pay Request Details'
PayRequestCompensation = ProviderPayRequestSteps.getCompensationForCompensationModel(Provider, CompensationModel, ServiceDate)

'Step 05 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 06 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 07 : get required PayApproval details from Grid'
HashMap<String, String> PayRequestData = new HashMap<String, String>()

PayRequestData = ProviderPayApprovalsSteps.getGridDataForPayElementWithServiceDate(PayElement, ServiceDate)

PayRequestYTDAmount = Double.parseDouble(PayRequestData.get('YTDAmounts').replace(',', ''))

ProviderName = PayRequestData.get('ProviderName')

PayPeriod = PayRequestData.get('PayPeriod')

existingAmount = PayRequestData.get('Amount')

'Step 08: define expected details as gathered information'
Double diffAmount = Double.parseDouble(updateAmount) - Double.parseDouble(existingAmount)

String ExceedAmount

String ExpectedMessage

if ((PayRequestCompensation + diffAmount) > ContractMaxCompensation) {
    ExceedAmount = Utilities.getDifferenceBTWValues(ContractMaxCompensation.toString(), PayRequestCompensation.toString())

    ExpectedMessage = HIIConstants.PPA_MaxThresholdLimitPopupMessage(ProviderName, PayElement, CompensationModel, ContractPeriod, 
        ExceedAmount)
} else if ((PayRequestYTDAmount + diffAmount) > PayElementThreshold) {
    ExceedAmount = Utilities.getDifferenceBTWValues(PayElementThreshold.toString(), PayRequestYTDAmount.toString())

    ExpectedMessage = HIIConstants.PPA_MaxThresholdLimitPopup_ThresholdLimitMessage(ProviderName, PayElement)
}

'Step 09 : select PayElement with Service Date'
ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)

'Step 10 : Update Amount for Pay Element with Service Date'
ProviderPayApprovalsSteps.updateAmountForPayElementWithServiceDate(PayElement, ServiceDate, updateAmount)

'Step 11 : Click Update'
ProviderPayApprovalsSteps.clickUpdate()

'Step 12 : Verify Update Functionality'
if (ExpectedMessage != null) {
    String actualMsg = ProviderPayApprovalsSteps.getMaxCompensationAndThresholdExceedAlertMessage()

    String AssertMsg = (('Actual:\n ' + actualMsg) + ' and Expected:\n') + ExpectedMessage

    AssertSteps.verifyActualResult(actualMsg.equals(ExpectedMessage), AssertMsg + ' : PASS', AssertMsg + ' : FAIL')

    ProviderPayApprovalsSteps.clickCancel()
} else {
    ProviderPayApprovalsSteps.verifyUpdateFunctionality()
}