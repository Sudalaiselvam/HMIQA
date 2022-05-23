import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps
import pages.CommonSteps
import pages.LocationPageSteps
import pages.PayCycleMappingPageSteps
import configs.HIIConstants
import core.Logger

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, GlobalVariable.ROLE)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Get Pay Period BackGround Color'
String PayPeriodBGColor=PaymentProcessPageSteps.getPayPeriodBackgroundColor(PayPeriod)

'Step 07 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

switch(PayPeriodBGColor) {
	case HIIConstants.Gray:
							Logger.logWARNING('Selected PayPeriod :'+PayPeriod+' is completly Processed earlier')
							break
	case HIIConstants.Orange:
							Logger.logINFO('Select PayPeriod :'+PayPeriod+' is partially Processed')
							'Get Location Background Color'
							String LocationBGColor=PaymentProcessPageSteps.getLocationBackgroundColor(Location)
							
							'Step 08 : Select Location'
							PaymentProcessPageSteps.selectLocation(Location)
							switch(LocationBGColor) {
								case HIIConstants.White:
														Logger.logINFO('Selected Location :'+Location+' is not processed yet')
																						
														'Step 09 : Click Process Compensation'
														PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
								
														'Step 10 : Uncheck Valdiation Only CheckBox'
														PaymentProcessPageSteps.uncheckValidationOnly()
								
														'Step 11 : Click Send to Payroll'
														PaymentProcessPageSteps.clickSendToPayrollButton()
														
														'Step 12 : Verify Success Message'
														PaymentProcessPageSteps.verifySendToPayrollSuccessMessage()
														break
								case HIIConstants.Gray:
														Logger.logWARNING('Selected Location :'+Location+' is Processed earlier')
														break
							}
							break
	case HIIConstants.White:
							Logger.logINFO('Selected PayPeriod :'+PayPeriod+' is not processed yet')
	
							'Step 08 : Select Location'
							PaymentProcessPageSteps.selectLocation(Location)
	
							'Step 09 : Click Process Compensation'
							PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
	
							'Step 10 : Uncheck Valdiation Only CheckBox'
							PaymentProcessPageSteps.uncheckValidationOnly()
	
							'Step 11 : Click Send to Payroll'
							PaymentProcessPageSteps.clickSendToPayrollButton()
							
							'Step 12 : Verify Success Message'
							PaymentProcessPageSteps.verifySendToPayrollSuccessMessage()
							break
														
}









