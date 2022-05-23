import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps
import pages.LocationPageSteps as LocationPageSteps
import pages.PayCycleSetupPageSteps as PayCycleSetupPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get expected Pay Periods mapped to PayCyle & Year'
List<String> expectedPayPeriod = new ArrayList<String>()
expectedPayPeriod = PayCycleSetupPageSteps.getPayPeriodWRTPayCycle(PayCycle, Year)

'Step 04 : Go to Provider Pay Approvals'
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

'Step 10 : Verify Pay Period List'
ProviderPayApprovalsSteps.verifyPayPeriodList(expectedPayPeriod)