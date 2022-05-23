import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps
import pages.LocationPageSteps as LocationPageSteps
import pages.PayCycleSetupPageSteps as PayCycleSetupPageSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    List<String> expectedPayPeriod = new ArrayList<String>()

    expectedPayPeriod = PayCycleSetupPageSteps.getPayPeriodWRTPayCycle(ProviderPayApprovals.getValue('PayCycle', i), ProviderPayApprovals.getValue('Year', i))

    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region', i))

    ProviderPayApprovalsSteps.selectPayCycle(ProviderPayApprovals.getValue('PayCycle', i))

    ProviderPayApprovalsSteps.selectLocation(ProviderPayApprovals.getValue('Location', i))

    ProviderPayApprovalsSteps.selectPayrollStatus(ProviderPayApprovals.getValue('PayrollStatus', i))

    ProviderPayApprovalsSteps.selectYear(ProviderPayApprovals.getValue('Year', i))

    ProviderPayApprovalsSteps.verifyPayPeriodList(expectedPayPeriod)
}