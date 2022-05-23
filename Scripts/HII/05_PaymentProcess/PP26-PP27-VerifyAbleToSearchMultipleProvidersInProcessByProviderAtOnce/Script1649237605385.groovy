import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

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

'Step 08 : Select All Locations'
PaymentProcessPageSteps.selectallLocations()

'Step 09: Check Process By Provider CheckBox and Select Multiple Providers'
List<String> lstProviders=new ArrayList<String>()
lstProviders.add(Physician1)
lstProviders.add(Physician2)
lstProviders.add(Physician3)
PaymentProcessPageSteps.verifyMultipleProviderInProcessByProvider(lstProviders)

PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

PaymentProcessPageSteps.verifyProvidersInGridPaymentProcess()