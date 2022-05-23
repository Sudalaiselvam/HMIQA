import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Process Status'
PaymentProcessPageSteps.selectProcessStatus(ProcessStatus)

'Step 07 : Select Payment Type'
PaymentProcessPageSteps.selectPaymentType(PaymentType)

//PaymentProcessPageSteps.selectLocation(Location)

'Step 08 : Verify Test Data Pay Period is recently Processed Pay Period'
String PayPeriodRecentlyProcessed=PaymentProcessPageSteps.getPayPeriodIsRecentlyProcessed()
boolean blnRecentlyProcessed
if(PayPeriodRecentlyProcessed.equals(PayPeriod))
	blnRecentlyProcessed=true

'Step 09 : Select Year'		
PaymentProcessPageSteps.selectYear(Year)

'Step 10 : Select PayPeriod'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 11 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)

'Step 12 : Verify Delete option functionality'
PaymentProcessPageSteps.verifyDeleteOptionFunctionality(blnRecentlyProcessed)
