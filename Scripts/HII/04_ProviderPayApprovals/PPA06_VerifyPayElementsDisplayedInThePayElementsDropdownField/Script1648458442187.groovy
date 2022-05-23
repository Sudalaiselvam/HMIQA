import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.OrgCompModelsPayElementsSteps as OrgCompModelsPayElementsSteps
import pages.RoleUserWisePayElementsSteps as RoleUserWisePayElementsSteps
import pages.PayElementsSteps as PayElementsSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Expected list of Pay Elements'
Set<String> lstexpectedPayElements = new HashSet<String>()
lstexpectedPayElements = ProviderPayApprovalsSteps.getExpectedPayElements(HIIConstants.ROLE_CompensationAdministrator, Region, CompensationModel)

'Step 04 : Go to Provider Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 05 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 06 : Select Pay Cycle'
ProviderPayApprovalsSteps.selectPayCycle(PayCycle)

'Step 07 : Select Location'
ProviderPayApprovalsSteps.selectLocation(Location)

'Step 08 : Select Payroll Status'
ProviderPayApprovalsSteps.selectPayrollStatus(PayrollStatus)

'Step 09 : Select Year'
ProviderPayApprovalsSteps.selectYear(Year)

'Step 10 : Select Pay Period'
ProviderPayApprovalsSteps.selectPayPeriod(PayPeriod)

'Step 11 : Select Compensation Model'
ProviderPayApprovalsSteps.selectCompensationModel(CompensationModel)

'Step 12 : Verify Pay Element List'
ProviderPayApprovalsSteps.verifyPayElementList(lstexpectedPayElements)