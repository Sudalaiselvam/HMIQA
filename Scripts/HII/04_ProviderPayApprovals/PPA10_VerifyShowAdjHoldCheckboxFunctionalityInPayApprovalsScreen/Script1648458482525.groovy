import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 01 : Log in to the H2 Application with valid credentials'
Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Pre-Requisite 1: Flag should be enabled  "Allow Adj/Hold Amount in Provider Pay Approvals Screen" (General settings  --> Aplication settings)'
String RequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, RequestDate, PayElement)
String flagSetting = GeneralSettingsSteps.getAllowAdjHoldAmountInProviderPayApprovalsScreen()

'Step 02 : Mouse hover on "Payments" Tab and Click on "Pay Approvals" Menu.'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 03 : verify Show Adj Hold Setting'
ProviderPayApprovalsSteps.verifyShowAdjHoldSetting(flagSetting)

'Step 04 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 05 : Enable the checkbox "Show Adj/Hold" and click on "Get Details"button.'
ProviderPayApprovalsSteps.checkShowAdjHold()
ProviderPayApprovalsSteps.clickGetDetails()

'Step 06 : Set Adjustment Amount and Validate'
ProviderPayApprovalsSteps.setAdjHold(RequestDate, PayElement, AdjHold.toDouble())