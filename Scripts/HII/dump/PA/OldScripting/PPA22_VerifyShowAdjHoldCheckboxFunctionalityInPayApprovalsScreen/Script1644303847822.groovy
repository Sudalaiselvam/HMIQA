import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps




'Step 1: Log in to the H2 Application with valid credentials'
Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	
	String Provider=ProviderPayApprovals.getValue('Provider',i)
	String RequestDate=ProviderPayApprovals.getValue('RequestDate',i)
	String PayElement=ProviderPayApprovals.getValue('PayElement',i)
	double AdjHold=Double.parseDouble(ProviderPayApprovals.getValue('AdjHold',i))

String RequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, RequestDate, PayElement)

'Pre-Requisite 1: Flag should be enabled  "Allow Adj/Hold Amount in Provider Pay Approvals Screen" (General settings  --> Aplication settings)'
String flagSetting = GeneralSettingsSteps.getAllowAdjHoldAmountInProviderPayApprovalsScreen()

'Step 2: Mouse hover on "Payments" Tab and Click on "Pay Approvals" Menu.'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.verifyShowAdjHoldSetting(flagSetting)

ProviderPayApprovalsSteps.setProvider(Provider)

'Step 3: Enable the checkbox "Show Adj/Hold" and click on "Get Details"button.'
ProviderPayApprovalsSteps.checkShowAdjHold()

ProviderPayApprovalsSteps.clickGetDetails()

'Step 4: Set Adjustment Amount and Validate'
ProviderPayApprovalsSteps.setAdjHold(RequestDate,PayElement,AdjHold)

}