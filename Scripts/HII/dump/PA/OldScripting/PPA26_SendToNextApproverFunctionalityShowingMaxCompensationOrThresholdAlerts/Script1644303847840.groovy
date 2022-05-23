import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import utils.Utilities
import core.AssertSteps


String Provider
String CompensationModel
String PayElement
String ServiceDate



HashMap<String,String> PayRequestData=new HashMap<String,String>()
HashMap<String,String> ContractAmountDetails=new HashMap<String,String>()

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	Provider=ProviderPayApprovals.getValue('Provider',i)
	CompensationModel=ProviderPayApprovals.getValue('CompensationModel',i)
	PayElement=ProviderPayApprovals.getValue('PayElement',i)
	ServiceDate=ProviderPayApprovals.getValue('ServiceDate',i)
}


/*
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.setProvider(Provider)

PayRequestData=ProviderPayApprovalsSteps.getGridDataForPayElementWithServiceDate(PayElement, ServiceDate)

println PayRequestData.get('Amount')
println PayRequestData.get('PayPeriod')
println PayRequestData.get('ApprovalStatus')
println PayRequestData.get('YTDAmounts')
println PayRequestData.get('ThresholdAmount')

*/

/*
ContractAmountDetails=ManageProviderContractSteps.getMaxCompensationAndThresholdAmount(Provider, CompensationModel, PayElement)

println ContractAmountDetails.get('ThresholdAmount')
*/

ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.setProvider(Provider)

PayRequestData=ProviderPayApprovalsSteps.getGridDataForPayElementWithServiceDate(PayElement, ServiceDate)

ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)

ProviderPayApprovalsSteps.clickSendtoNextApprover()

String actualMsg=ProviderPayApprovalsSteps.getMaxCompensationAndThresholdExceedAlertMessage()

String expectedMsg=HIIConstants.PPA_MaxThresholdLimitPopup_ThresholdLimitMessage(PayRequestData.get('ProviderName'), PayElement)

println actualMsg
println expectedMsg

AssertSteps.verifyActualResult(actualMsg.equals(expectedMsg), 'PASS', 'FAIL')

ProviderPayApprovalsSteps.clickCancel()

println ProviderPayApprovalsSteps.MaxCompensationAndThresholdExceedAlert_Popup_Displayed()

