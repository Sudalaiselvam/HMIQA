import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.PaymentProcessPageSteps as PaymentProcessPageSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.PayCycleMappingPageSteps
import pages.GeneralSettingsSteps



'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Allow Payments Processing By Provider General Settings'
String GSAllowPaymnetsProcessing=GeneralSettingsSteps.getAllowPaymentsProcessingByProvider(Region, Location)

'Get PayCycle Mapped to Region Location'
String PayCycleMapped=PayCycleMappingPageSteps.getPayCycleMappedtoRegionLocation(Region, Location)

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

'Step 08 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 09 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 10 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)

'Get Location Background Color'
String LocationBgColor = PaymentProcessPageSteps.getLocationBackgroundColor(Location)

if (LocationBgColor.equals(HIIConstants.White) && PayCycle.equals(PayCycleMapped) && GSAllowPaymnetsProcessing.equals(HIIConstants.Yes)) {
    
	'Get Provider Contract Mark Complete Status'
	//boolean blnContractMarkComplete = ManageProviderContractSteps.VerifyContractWithMarkCompleteStatus(Provider)
	
	List<String> lstLocations=new ArrayList<String>()
	lstLocations=ManageProviderContractSteps.getLocationsMappedtoMarkCompletedContract(Provider)
	
	boolean blnContractMarkComplete=lstLocations.contains(Location)
	'Step 11 : Check CheckBox Process By Provider'
	PaymentProcessPageSteps.checkProcessByProvider()

	'Step 12 : Verify Provider Web Service'
    PaymentProcessPageSteps.verifyProviderWebService(Provider, blnContractMarkComplete)
}

'Step 13 : Verify Process Compensation Button is displayed'
switch(LocationBgColor) {
	
	case HIIConstants.White:
		PaymentProcessPageSteps.verifyProcessCompensationButtonDisplayed()
		break
	case HIIConstants.Gray:
		PaymentProcessPageSteps.verifyProcessCompensationButtonDisplayed(false)
		'Step 14 : Verify Information Message is processed for Location'
		PaymentProcessPageSteps.verifyInformationMessageForProcessedLocation(LocationBgColor)
		break	
}
