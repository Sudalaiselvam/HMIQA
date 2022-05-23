import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 04 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 05 : Verify Pay Period'
ProviderPayApprovalsSteps.verifyPayPeriod(RequestDate)

'Step 06 : Verify Period'
ProviderPayApprovalsSteps.verifyPeriod(RequestDate)