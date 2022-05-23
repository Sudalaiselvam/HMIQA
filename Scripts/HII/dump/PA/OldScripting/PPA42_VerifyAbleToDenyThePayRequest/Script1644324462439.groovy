import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ApprovalLevelSettingsForRolePageSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	
	String Provider=ProviderPayApprovals.getValue('Provider',i)
	String ServiceDate=ProviderPayApprovals.getValue('ServiceDate',i)
	String PayRequest_CompensationModel=ProviderPayApprovals.getValue('PayRequest_CompensationModel',i)
	
	String CompensationModel=ProviderPayApprovals.getValue('CompensationModel',i)
	String PayRequest_PayElement=ProviderPayApprovals.getValue('PayRequest_PayElement',i)
	String PayElement=ProviderPayApprovals.getValue('PayElement',i)
	String PayElementValue=ProviderPayApprovals.getValue('PayElementValue',i)
	
ProviderPayRequestSteps.createProviderRequestwithCurrentDate(Provider, ServiceDate, PayRequest_CompensationModel, PayRequest_PayElement, PayElementValue)

ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.setProvider(Provider)

ProviderPayApprovalsSteps.clickGetDetails()

//ProviderPayApprovalsSteps.verifySendtoNextApproverDisplayedWRTPayRequest(Provider)

ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)

ProviderPayApprovalsSteps.clickDeny()

ProviderPayApprovalsSteps.verifyDenyFunctionality()

}