import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProcessBonusPageSteps
import pages.PaymentProcessPageSteps
import core.Logger

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Process Bonus'
ProcessBonusPageSteps.gotoProcessBonus()

'Step 04 : Select Fixed Payment Process Region'
ProcessBonusPageSteps.selectFixedPaymentProcessRegion(Region)

'Step 05 : Select Fixed Payment Process Pay Cycle'
ProcessBonusPageSteps.selectFixedPaymentProcessPayCycle(PayCycle)

'Step 06 : Get list of Pay Periods '
List<String> PayPeriodOptions=new ArrayList<String>()
PayPeriodOptions=ProcessBonusPageSteps.getFixedPaymentProcessPayPeriodOptions()

'Step 07 : Get default Pay Period'
String defaultPayPeriod
defaultPayPeriod=ProcessBonusPageSteps.getFixedPaymentProcessPayPeriodOption()
PayPeriodOptions.remove(defaultPayPeriod)

boolean blnAlert=true
boolean OptionalAlert

if(PayPeriodOptions.contains(PayPeriod)) {
	blnAlert=false
}else if(defaultPayPeriod.equals(PayPeriod)) {
	OptionalAlert=true
}


'Step 08 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 09 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 10 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 11 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 12 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 13 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)

if(PaymentProcessPageSteps.isProcessCompensationButtonDisplayed())
{
	'Step 14 : Click Process Compensation'
	PaymentProcessPageSteps.clickProcessCompensation()

	'Step 15 : Verify Process Compensation Alert Popup'
	PaymentProcessPageSteps.verifyProcessCompensationAlertPopup(blnAlert, OptionalAlert,AlertContinueCancel)
}else {
	Logger.logWARNING('Process Compensation Button is not displayed. For Selected PayPeriod, Location Payment may be Processed')
}

