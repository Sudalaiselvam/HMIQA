import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps
import pages.CommonSteps

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select PayCycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Process Status'
PaymentProcessPageSteps.selectProcessStatus(ProcessStatus)

'Step 07 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 08 : Select Payment Type'
PaymentProcessPageSteps.selectPaymentType(PaymentType)

'Step 09 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 10 : Select Location'
PaymentProcessPageSteps.selectLocation('Location-1')

'Step 11 : Verify Payment Process Grid Column Headings'
PaymentProcessPageSteps.verifyPaymentProcessGridColumnHeadings()
