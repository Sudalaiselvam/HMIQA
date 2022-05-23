import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.PaymentProcessPageSteps as PaymentProcessPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import utils.DateTimeUtil as DateTimeUtil

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)


'Pre-Requisite: Get Expected Providers exceeded Max Compensation'
List<String> lstExpectedProvider = new ArrayList<String>()
lstExpectedProvider = PaymentProcessPageSteps.getExpectedProvidersForErrorMessageWRTMaxCompensation(Region, Location, Year,PayCycle, PayPeriod)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'

PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 07 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 08 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)

'Step 09 : Click Process Compensation'
PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

'Step 10 : Verify Error Message When Providers exceed Max Compensation'
PaymentProcessPageSteps.verifyErrorMessageIfProvidersExceedMaxCompensation(lstExpectedProvider)

'Step 11 : Verify Cost Center Background Color for Providers Exceeded Max Compensation'
PaymentProcessPageSteps.verifyCostCentersBackgroundColorForProvidersExceedMaxCompensation(lstExpectedProvider)