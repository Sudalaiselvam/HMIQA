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
    
	String PayCycle=ProviderPayApprovals.getValue('PayCycle', i)
	String Year=ProviderPayApprovals.getValue('Year', i)
	String Region=ProviderPayApprovals.getValue('Region', i)
	String Location=ProviderPayApprovals.getValue('Location', i)
	String PayrollStatus=ProviderPayApprovals.getValue('PayrollStatus', i)
	
	List<String> expectedPayPeriod = new ArrayList<String>()

    expectedPayPeriod = PayCycleSetupPageSteps.getPayPeriodWRTPayCycle(PayCycle, Year)

    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(Region)

    ProviderPayApprovalsSteps.selectPayCycle(PayCycle)

    ProviderPayApprovalsSteps.selectLocation(Location)

    ProviderPayApprovalsSteps.selectPayrollStatus(PayrollStatus)

    ProviderPayApprovalsSteps.selectYear(Year)

    ProviderPayApprovalsSteps.verifyPayPeriodList(expectedPayPeriod)
}