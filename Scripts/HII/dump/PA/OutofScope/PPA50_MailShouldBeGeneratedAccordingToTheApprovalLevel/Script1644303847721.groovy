import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import configs.HIIConstants
import pages.ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps
import pages.HeaderPageSteps

'Step 1  Browse H2 URL Provide Valid Credentials and Click on Login button'
Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 2: Click on the Menu Payments --> Provider Pay request screen'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 3: Enter desired Provider name in the Web search'
'Select the provider'
ProviderPayRequestSteps.setProviderName(Provider)

'Step 4: Select the service date in "Provider Name" field'
ProviderPayRequestSteps.selectServiceStartDate(ServiceStartDate)

'Step 5: Click on the Pay elements dropdown'
'Select desired Pay element from the Pay element dropdown'
ProviderPayRequestSteps.selectPayElement(PayElement)

'Step 6: Enter Amount/Units'
ProviderPayRequestSteps.setPayElementValue(PayElementValue)

'Step 7: Click on Save Button'
ProviderPayRequestSteps.clickSave()

'Step : Log off'
HeaderPageSteps.logOff()

'Step 8: Check for the mail "Pay requests waiting your approval" in the mail box for Compensation Administrator role'

'Step 9: Login with Compensation Administrator role'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 10: Click on the menu Payments --> Provider Pay Approval screen'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 11: Enter the Provider name in the Web search'
'Select the provider in "Provider" Field'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 12: Select the Pay request record check box for "CME" pay element'
ProviderPayApprovalsSteps.selectPayElement(PayElement)

'Step 13: Click on "Send Next approver" button'
ProviderPayApprovalsSteps.clickSendtoNextApprover()

'Step : Log off'
HeaderPageSteps.logOff()

'Step 14: Check for the mail "Pay requests waiting your approval" in the mail box for Contract Approver role'

'Step 15: Login with Contract Approver role'
LoginPageSteps.Login(GlobalVariable.COMPAPPROVER_USER, GlobalVariable.COMPAPPROVER_PWD, HIIConstants.ROLE_CompApprover)

'Step 16: Click on the menu Payments --> Provider Pay Approval screen'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 17: Enter the Provider name in the Web search'
'Select the provider in "Provider" Field'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 18: Select the Pay request record check box for "CME" pay element'
ProviderPayApprovalsSteps.selectPayElement(PayElement)

'Step 19: Click on "Send Next approver" button'
ProviderPayApprovalsSteps.clickSendtoNextApprover()
