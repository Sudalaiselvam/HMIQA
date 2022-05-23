import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps
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
	default:
			switch(PayPeriodBGColor) {
				case HIIConstants.Orange:
						Logger.logINFO('Select PayPeriod :'+PayPeriod+' is partially Processed')
						break
				case HIIConstants.White:
						Logger.logINFO('Selected PayPeriod :'+PayPeriod+' is not processed yet')
						break
			}
			
			'Step 08 : Select All Locations'
			PaymentProcessPageSteps.selectallLocations()
			
			'Step 09: Check Process By Provider CheckBox and Select Multiple Providers'
			List<String> lstProviders=new ArrayList<String>()
			lstProviders.add(Physician1)
			lstProviders.add(Physician2)
			lstProviders.add(Physician3)
			PaymentProcessPageSteps.verifyMultipleProviderInProcessByProvider(lstProviders)
			
			'Step 10 : Click Process Compensation'
			PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

			if(!PaymentProcessPageSteps.isLabelNoRecordsFoundDisplayed())
			{
				'Step 11 : Uncheck Valdiation Only CheckBox'
				PaymentProcessPageSteps.uncheckValidationOnly()
	
				'Step 12 : Click Send to Payroll'
				PaymentProcessPageSteps.clickSendToPayrollButton()
				
				'Step 13 : Verify Success Message'
				PaymentProcessPageSteps.verifySendToPayrollSuccessMessage()
				
				'Step 14 : Verify Payment Process Grid'
				PaymentProcessPageSteps.verifyProvidersInGridPaymentProcess()
				
				'Step 15 : Go to Payment Process'
				PaymentProcessPageSteps.gotoPaymentProcess()
				
				'Step 16 : Select Region'
				PaymentProcessPageSteps.selectRegion(Region)
				
				'Step 17 : Select Pay Cycle'
				PaymentProcessPageSteps.selectPayCycle(PayCycle)
				
				'Step 18 : Select Year'
				PaymentProcessPageSteps.selectYear(Year)
				
				'Step 19 : Select Pay Period'
				PaymentProcessPageSteps.selectPayPeriod(PayPeriod)
				
				'Step 20 : Select All Locations'
				PaymentProcessPageSteps.selectallLocations()
				
				'Step 21: Check Process By Provider CheckBox and Select Multiple Providers'
				PaymentProcessPageSteps.verifyMultipleProviderInProcessByProvider(lstProviders)
				
				'Step 22 : Click Process Compensation'
				PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
				
				'Step 23 : Verify Process Compensation Functionality after Send To Payroll'
				PaymentProcessPageSteps.verifyProcessCompensationFunctionalityAfterSendToPayrollForSelectedProviders()
			}else {
				Logger.logWARNING('Label No Records Found is Displayed, May be Send To Payroll processed for selected Providers')
			}
			break						
														
}









