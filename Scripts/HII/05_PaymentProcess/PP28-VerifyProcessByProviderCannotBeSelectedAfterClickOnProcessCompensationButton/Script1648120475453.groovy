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

'Step 09 : Check Process By Provider CheckBox'
PaymentProcessPageSteps.checkProcessByProvider()

'Step 10 : Enter Physician Name'
PaymentProcessPageSteps.setPhysicianName(Physician)

'Step 11 : Click Add Button'
PaymentProcessPageSteps.clickAdd()

'Step 12 : Click Process Compensation and accept Alert if Pop-up'
PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

'Step 13 : Verify Options after Processing Compensation'
PaymentProcessPageSteps.verifyProcessByProviderOptionsAfterClickingProcessCompensation()