import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps

'Step 01: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 04 : Enable the checkbox "show Inactive"'
ProviderPayApprovalsSteps.checkShowInactive()

'Step 05 : Set Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 06 : Click Get Details button'
ProviderPayApprovalsSteps.clickGetDetails()

'Step 07 : Verify Pay Requests created for "Inactive" Contracts'
ProviderPayApprovalsSteps.verifyPayRequestsCreatedForInactiveContracts()