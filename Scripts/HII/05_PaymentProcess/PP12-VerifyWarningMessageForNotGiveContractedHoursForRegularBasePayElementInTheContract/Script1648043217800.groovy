import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.PaymentProcessPageSteps as PaymentProcessPageSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.LocationPageSteps as LocationPageSteps
import pages.ProviderSetupSteps as ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Get Expected list of Employed Providers having Regular Base Pay Element'
List<String> ExpectedProviders = new ArrayList<String>()
ExpectedProviders = PaymentProcessPageSteps.getExpectedProvidersForWarningMessageWRTRegularBasePayElement(Region, Location,Year)

'Step 04 : Navigate to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 05 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 06 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 07 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 08 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 09 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)

'Step 10 : Click Process Compensation and Accept Process Compensation Alert'
PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

'Step 11 : Verify Information Message'
PaymentProcessPageSteps.verifyInformationMessageIfProviderswithRegularBasePayElement(ExpectedProviders)