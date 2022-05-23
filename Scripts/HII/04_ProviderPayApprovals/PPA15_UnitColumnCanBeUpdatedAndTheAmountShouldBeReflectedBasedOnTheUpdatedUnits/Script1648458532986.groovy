import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 04 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 05 : Select Payroll Status'
ProviderPayApprovalsSteps.selectPayrollStatus(PayrollStatus)

'Step 06 : Click Get Details'
ProviderPayApprovalsSteps.clickGetDetails()

'Step 07 : Verify Grid Amount when Units Updated'
ProviderPayApprovalsSteps.verifyGridAmountWRTUnitsUpdate(ServiceDate, PayElement, Units)