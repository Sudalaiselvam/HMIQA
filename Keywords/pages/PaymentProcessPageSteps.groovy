package pages

import core.BaseSteps
import core.ControlFactory
import org.openqa.selenium.WebElement
import configs.HIIConstants
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import core.AssertSteps
import core.Logger
import utils.DateTimeUtil
import utils.CommonUtilities
import utils.AlertUtiltities
import org.openqa.selenium.support.Color

/**
 * @author AnilKumarJanapareddy
 *
 */
public class PaymentProcessPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//To Navigate Payment Process Screen
	/**
	 * 
	 */
	public static void gotoPaymentProcess() {
		HeaderPageSteps.gotoHomePage()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuPaymentProcess', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		String PageHeader=getBaseSteps().getTextFromControl('pageHeader', pageName.Header)
		AssertSteps.verifyActualResult(PageHeader.equals(HIIConstants.PaymentProcess_PageHeader), ' - PASS', ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	private static final String ddlRegions='ddlRegions'
	private static final String ddlPayCycle='ddlPayCycle'
	private static final String ddlProcessStatus='ddlProcessStatus'
	private static final String ddlPaymentType='ddlPaymentType'
	private static final String ddlYear='ddlYear'
	private static final String ddlPayPeriod='ddlPayPeriod'
	private static final String ddlbtnLocations='ddlbtnLocations'
	private static final String ddloptLocations='ddloptLocations'
	private static final String ddllblLocations='ddllblLocations'
	private static final String ddllblLocationsSelectAll='ddllblLocationsSelectAll'
	private static final String btnFinanceReport='btnFinanceReport'
	private static final String btnProcessCompensation='btnProcessCompensation'
	private static final String chkProcessByProvider='chkProcessByProvider'
	private static final String txtPhysicianName='txtPhysicianName'
	private static final String txtPaymentProcessPhysicianName='txtPaymentProcessPhysicianName'
	private static final String btnAdd='btnAdd'
	private static final String grdPaymentProcess='grdPaymentProcess'
	private static final String lblErrMsg='lblErrMsg'
	private static final String msgSuccess='msgSuccess'
	private static final String msgError='msgError'
	private static final String btnDelete='btnDelete'
	private static final String msgInfo='msgInfo'
	private static final String pnlPopupPaymentsConfirm='pnlPopupPaymentsConfirm'
	private static final String lblPopupMsg='lblPopupMsg'
	private static final String btnPopupContinue='btnPopupContinue'
	private static final String btnPopupCancel='btnPopupCancel'
	private static final String lblProviders='lblProviders'
	private static final String chkValidationOnly='chkValidationOnly'
	private static final String btnSendToPayroll='btnSendToPayroll'
	private static final String lblNoRecordsFound='lblNoRecordsFound'


	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegions, Region, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayCycle(String PayCycle) {
		getBaseSteps().selectByVisibleText(ddlPayCycle, PayCycle, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectProcessStatus(String ProcessStatus) {
		getBaseSteps().selectByVisibleText(ddlProcessStatus, ProcessStatus, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPaymentType(String PaymentType) {
		getBaseSteps().selectByVisibleText(ddlPaymentType, PaymentType, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Year
	 */
	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayPeriod(String PayPeriod) {
		getBaseSteps().selectByVisibleText(ddlPayPeriod, PayPeriod, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static String getPayPeriodBackgroundColor(String PayPeriod) {
		return getBaseSteps().getOptionBackgroundColor(ddlPayPeriod, PayPeriod, pageName.PaymentProcess)
	}

	public static int getPayPeriodIndex(String PayPeriod) {
		List<String> PayPeriods=new ArrayList<>()
		PayPeriods=getBaseSteps().getlistControlDropdowm(ddlPayPeriod, pageName.PaymentProcess)
		return PayPeriods.indexOf(PayPeriod)
	}

	public static String getPayPeriodWithIndex(int Index) {
		List<String> PayPeriods=new ArrayList<>()
		PayPeriods=getBaseSteps().getlistControlDropdowm(ddlPayPeriod, pageName.PaymentProcess)
		return PayPeriods.get(Index)

	}

	public static String getSelectedYear() {
		return getBaseSteps().getselectedControlDropdowm(ddlYear, pageName.PaymentProcess)
	}

	public static String getSelectedPayPeriod() {
		return getBaseSteps().getselectedControlDropdowm(ddlPayPeriod, pageName.PaymentProcess)
	}

	public static void selectLocation(String Location) {
		getBaseSteps().clickToControl(ddlbtnLocations, pageName.PaymentProcess)
		getBaseSteps().clickLabelwithtext(ddllblLocations, Location, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectallLocations() {
		getBaseSteps().clickToControl(ddlbtnLocations, pageName.PaymentProcess)
		getBaseSteps().clickToControl(ddllblLocationsSelectAll, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static String getLocationBackgroundColor(String Location) {
		/*getBaseSteps().clickToControl(ddlbtnLocations, pageName.PaymentProcess)
		 return getBaseSteps().getControlBackgroundColorwithText(ddloptLocations, Location, pageName.PaymentProcess)
		 */
		getBaseSteps().clickToControl(ddlbtnLocations, pageName.PaymentProcess)
		HashMap<String,String> hpLocationsBgColor=new HashMap<String,String>();
		hpLocationsBgColor=getBaseSteps().getListOfWebElementsBackgroundColor(ddloptLocations, pageName.PaymentProcess)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return hpLocationsBgColor.get(Location)

	}

	public static void clickFinanceReport() {
		getBaseSteps().clickToControl(btnFinanceReport, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickProcessCompensation() {
		getBaseSteps().clickToControl(btnProcessCompensation, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static boolean isProcessCompensationButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnProcessCompensation, pageName.PaymentProcess)
	}

	public static void clickProcessCompensationAndAcceptAlertIfExists() {
		getBaseSteps().clickToControl(btnProcessCompensation, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading',30, pageName.CMN)
		if(isPopupDisplayed()) {
			clickPopupContinue()
			getBaseSteps().waitforLoadingComplete('imgLoading',30, pageName.CMN)
		}
	}

	public static void checkProcessByProvider() {
		getBaseSteps().ActiveCheckBox(chkProcessByProvider, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static boolean isProcessByProviderCheckboxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkProcessByProvider, pageName.PaymentProcess)
	}

	public static void uncheckProcessByProvider() {
		getBaseSteps().InactiveCheckBox(chkProcessByProvider, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void uncheckValidationOnly() {
		getBaseSteps().InactiveCheckBox(chkValidationOnly, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickSendToPayrollButton() {
		getBaseSteps().clickToControl(btnSendToPayroll, pageName.PaymentProcess)

		if(AlertUtiltities.isAlertDisplayed()) {
			AlertUtiltities.acceptAlert()
		}
	}

	public static boolean isSendToPayrollSuccessMessageDisplayed() {
		getBaseSteps().waitForControlDisplay(msgSuccess, 30, pageName.PaymentProcess)
		return getBaseSteps().WebElementDisplayed(msgSuccess, pageName.PaymentProcess)
	}

	public static String getSuccessMessage() {
		return getBaseSteps().getTextFromControl(msgSuccess, pageName.PaymentProcess).trim()
	}

	public static void verifySendToPayrollSuccessMessage() {
		AssertSteps.verifyActualResult(isSendToPayrollSuccessMessageDisplayed(), 'After Clicking Send To Payroll Success Message is Displayed- PASS', 'After Clicking Send To Payroll Success Message is not Displayed with waiting time of 30 seconds- FAIL', FailureHandling.STOP_ON_FAILURE)
		String ActualMsg=getSuccessMessage()
		String ExpectedMsg=HIIConstants.PaymentProcessSuccessMessage
		String AssertMsg='Success Message Validation, Expected: '+ExpectedMsg+' and Actual : '+ActualMsg

		AssertSteps.verifyActualResult(ActualMsg.equals(ExpectedMsg), AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static boolean isPhysicianNameDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtPhysicianName, pageName.PaymentProcess)
	}

	public static void setPhysicianName(String Physician) {
		getBaseSteps().setTextToControl(txtPhysicianName,Physician,pageName.PaymentProcess)
		try {
			getBaseSteps().waitForControlDisplay('lstProviderhints', pageName.CMN)
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			getBaseSteps().waitForProgressBarDisappear()
		}catch(Exception e) {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
		}
	}

	public static void setPaymentProcessPhysicianName(String Physician) {
		getBaseSteps().setTextToControl(txtPaymentProcessPhysicianName,Physician,pageName.PaymentProcess)
		try {
			getBaseSteps().waitForControlDisplay('lstProviderhints', pageName.CMN)
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			getBaseSteps().waitForProgressBarDisappear()
		}catch(Exception e) {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
		}
	}

	public static void verifyProviderWebService(String Provider,boolean validProvider) {
		getBaseSteps().setTextToControl(txtPhysicianName, Provider, pageName.PaymentProcess)

		if(validProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void clickAdd() {
		getBaseSteps().clickToControl(btnAdd, pageName.PaymentProcess)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static boolean gridPaymentProcessDisplayed() {
		return getBaseSteps().WebElementDisplayed(grdPaymentProcess, pageName.PaymentProcess)
	}

	public static List<String> gridPaymentProcessColumnHeadings() {
		List<String> colHeadings=new ArrayList<String>()
		colHeadings=getBaseSteps().getTableHeadings(grdPaymentProcess, pageName.PaymentProcess)
		return colHeadings
	}

	public static void verifyPaymentProcessGridColumnHeadings() {
		List<String> gridHeadings=new ArrayList<String>()
		getBaseSteps().waitForControlDisplay(grdPaymentProcess, pageName.PaymentProcess)
		if(PaymentProcessPageSteps.gridPaymentProcessDisplayed())
			gridHeadings=PaymentProcessPageSteps.gridPaymentProcessColumnHeadings()

		List<String> expGridHeadings=new ArrayList<String>()
		expGridHeadings=HIIConstants.PaymentProcessGridColumnHeadings()

		println gridHeadings
		println expGridHeadings

		for(String gridHeading:expGridHeadings)
			AssertSteps.verifyActualResult(gridHeadings.contains(gridHeading), gridHeading+' - heading contains in Payment Process Table', gridHeading+' - heading is expected in Payment Process Table', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifyPayPeriodBackgroundColor(String PayPeriod) {
		List<String> lstLocationsBgColor=new ArrayList<String>()
		HashMap<String,String> hmLocationBgColor=new HashMap<String,String>()
		boolean blnProcessed,blnPartiallyProcessed,blnNotProcessed
		getBaseSteps().clickToControl(ddlbtnLocations, pageName.PaymentProcess)

		lstLocationsBgColor=getBaseSteps().getListOfControlsBackgroundColor(ddloptLocations, pageName.PaymentProcess)
		if(lstLocationsBgColor.contains('White') && lstLocationsBgColor.contains('Gray')) {
			blnPartiallyProcessed=true
		}else if(lstLocationsBgColor.contains('Gray')) {
			blnProcessed=true
		}else if(lstLocationsBgColor.contains('White')) {
			blnNotProcessed=true
		}

		String expBgColor,actBgColor

		if(blnNotProcessed)
			expBgColor='White'
		if(blnProcessed)
			expBgColor='Gray'
		if(blnPartiallyProcessed)
			expBgColor='Golden Cream (Orange Color Family)'

		actBgColor=this.getPayPeriodBackgroundColor(PayPeriod)
		String AssertMSG='Expected Background Color for PayPeriod '+PayPeriod+' is '+expBgColor+' and Actual Background Color is '+actBgColor
		AssertSteps.verifyActualResult(actBgColor.equals(expBgColor),AssertMSG+' - PASS' , AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)

	}

	public static boolean isDeleteOptionDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnDelete, pageName.PaymentProcess)
	}

	public static boolean isProcessCompensationOptionDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnProcessCompensation, pageName.PaymentProcess)
	}

	public static void verifyDeleteOption(boolean blnRecentlyProcessed) {

		String AssertMSG
		if(blnRecentlyProcessed)
			AssertMSG='Pay Period :'+getSelectedPayPeriod()+' is recently Processed'
		else
			AssertMSG='Pay Period :'+getSelectedPayPeriod()+' is not recently Processed'

		if(isDeleteOptionDisplayed())
			AssertMSG=AssertMSG+'  and Delete Button is displayed'
		else
			AssertMSG=AssertMSG+'  and Delete Button is not displayed'
		AssertSteps.verifyActualResult(isDeleteOptionDisplayed().equals(blnRecentlyProcessed), AssertMSG+' with Deletion option  - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static String getPayPeriodIsRecentlyProcessed() {

		List<Integer> lstYear=new ArrayList<Integer>();
		List<String> lstPayPeriod=new ArrayList<String>();
		String bgColor
		lstYear=getBaseSteps().getIntegerListOfControlDropdownOptions(ddlYear, pageName.PaymentProcess)
		Comparator c=Collections.reverseOrder()
		Collections.sort(lstYear,c)
		for(Integer iYear:lstYear) {
			selectYear(iYear.toString())
			lstPayPeriod=getBaseSteps().getlistControlDropdowm(ddlPayPeriod, pageName.PaymentProcess)
			lstPayPeriod.remove('-Select-')
			Collections.sort(lstPayPeriod,c)
			for(String sPayPeriod:lstPayPeriod) {
				bgColor=this.getPayPeriodBackgroundColor(sPayPeriod)
				if(!bgColor.equals('White'))
					return sPayPeriod
			}
		}
	}

	public static void clickDelete() {
		getBaseSteps().clickToControl(btnDelete, pageName.PaymentProcess)
	}

	public static void verifyDeleteOptionFunctionality(boolean blnRecentlyProcessed) {
		verifyDeleteOption(blnRecentlyProcessed)

		if(isDeleteOptionDisplayed())
		{
			clickDelete()
			getBaseSteps().waitforLoadingComplete('imgLoading', 30, pageName.CMN)
			AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(lblErrMsg, pageName.PaymentProcess), 'Deleted Successfully Message Displayed - PASS', 'Deleted Successfully Message not Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void verifyProcessCompensationButtonDisplayed(boolean blnProcessCompensation=true) {
		String AssertMSG
		if(isProcessCompensationOptionDisplayed())
			AssertMSG='Process Compensation Button is displayed'
		else
			AssertMSG='Process Compensation Button is not displayed'
		AssertSteps.verifyActualResult(isProcessCompensationOptionDisplayed().equals(blnProcessCompensation), AssertMSG+'  - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)

	}

	public static boolean isInformationMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(msgInfo, pageName.PaymentProcess)
	}

	public static String getInformationMessage() {
		return getBaseSteps().getTextFromControl(msgInfo, pageName.PaymentProcess)
	}

	public static List<String> getListOfProvidersNotSetupforContractedHoursFromInformationMessage(){
		String infoMsg=getInformationMessage()
		List<String> lstProviders=new ArrayList<String>()
		lstProviders=infoMsg.substring(infoMsg.indexOf(': ')+1).trim().split('; ')
		return lstProviders

	}

	public static boolean isErrorMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(msgError, pageName.PaymentProcess)
	}

	public static String getErrorMessage() {
		return getBaseSteps().getTextFromControl(msgError, pageName.PaymentProcess)
	}

	public static List<String> getListOfProvidersforMaxCompensationFromErrorMessage(){
		List<String> lstProviders=new ArrayList<String>()
		if(isErrorMessageDisplayed())
		{
			String errorMsg=getErrorMessage()
			lstProviders=errorMsg.substring(errorMsg.indexOf(': ')+1).trim().split('; ')
		}
		return lstProviders

	}

	public static void verifyInformationMessageForProcessedLocation(String LocationBgColor) {
		switch(LocationBgColor) {
			case HIIConstants.White:
				break
			case HIIConstants.Gray:
				AssertSteps.verifyActualResult(isInformationMessageDisplayed(), 'For Processed Location, Information Message is displayed - PASS', 'For Processed Location, Information Message is not displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				AssertSteps.verifyActualResult(getInformationMessage().startsWith('Last Payroll Processed on'), 'Information Message - when recently processed information is displayed - PASS', 'Information Message - when recently processed information is not displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				break
		}

	}

	public static boolean isPopupDisplayed() {
		return getBaseSteps().WebElementDisplayed(pnlPopupPaymentsConfirm, pageName.PaymentProcess)
	}

	public static String getPopupMessage() {
		return getBaseSteps().getTextFromControl(lblPopupMsg, pageName.PaymentProcess)
	}

	public static void clickPopupContinue() {
		getBaseSteps().clickToControl(btnPopupContinue, pageName.PaymentProcess)
	}

	public static void clickPopupCancel() {
		getBaseSteps().clickToControl(btnPopupContinue, pageName.PaymentProcess)
	}

	public static void verifyProcessCompensationAlertMessageAndActionOnAlertPopup(String ContinueCancel) {
		//String alertMsg=getPopupMessage()
		//println alertMsg
		String alertMsg=getBaseSteps().getTextFromControl(lblPopupMsg, pageName.PaymentProcess)
		println alertMsg
		AssertSteps.verifyActualResult(alertMsg.equals(HIIConstants.PaymentProcessCompensationAlertMessage), 'Alert Message Validation - PASS', 'Alert Message Validation - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		switch(ContinueCancel) {
			case 'Continue':
				clickPopupContinue()
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
				AssertSteps.verifyActualResult(gridPaymentProcessDisplayed(), 'After Accepting Alert, Validating Grid Payment Process  - PASS', 'After Accepting Alert, Validating Grid Payment Process  - FAIL', FailureHandling.STOP_ON_FAILURE)
				break
			case 'Cancel':
				clickPopupCancel()
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
				AssertSteps.verifyActualResult(!gridPaymentProcessDisplayed(), 'After Accepting Alert, Validating Grid Payment Process  - PASS', 'After Accepting Alert, Validating Grid Payment Process  - FAIL', FailureHandling.STOP_ON_FAILURE)
				break
		}
	}

	public static void verifyProcessCompensationAlertPopup(boolean blnAlert,boolean OptionalAlert, String ContinueCancel) {
		if(OptionalAlert) {
			String PayPeriod=getSelectedPayPeriod()
			Logger.logINFO('Since Pay Period: '+PayPeriod+' is default option in Process Bonus / Fixed, Fixed Payments may be Processed or Not. Alert Popup will be displayed if its not processed (Do not option to check dependency in application)')
			if(isPopupDisplayed())
				verifyProcessCompensationAlertMessageAndActionOnAlertPopup(ContinueCancel)

		}else if(blnAlert) {
			AssertSteps.verifyActualResult(isPopupDisplayed(), 'Validating Process Compenation Alert Popup  - PASS', 'Validating Process Compenation Alert Popup  - FAIL', FailureHandling.STOP_ON_FAILURE)
			verifyProcessCompensationAlertMessageAndActionOnAlertPopup(ContinueCancel)

		}else {
			Logger.logINFO('Alert Message should not Popup')
			AssertSteps.verifyActualResult(!isPopupDisplayed(), 'Validating Process Compenation Alert Popup  - PASS', 'Validating Process Compenation Alert Popup  - FAIL', FailureHandling.STOP_ON_FAILURE)
		}

	}

	public static void verifyProcessCompensationAlertPopup(boolean blnAlert,boolean OptionalAlert) {
		if(OptionalAlert) {
			String PayPeriod=getSelectedPayPeriod()
			Logger.logINFO('Since Pay Period: '+PayPeriod+' is default option in Process Bonus / Fixed, Fixed Payments may be Processed or Not. Alert Popup will be displayed if its not processed (Do not option to check dependency in application)')
		}else if(blnAlert) {
			AssertSteps.verifyActualResult(isPopupDisplayed(), 'Validating Process Compenation Alert Popup  - PASS', 'Validating Process Compenation Alert Popup  - FAIL', FailureHandling.STOP_ON_FAILURE)

		}else {
			Logger.logINFO('Alert Message should not Popup')
			AssertSteps.verifyActualResult(!isPopupDisplayed(), 'Validating Process Compenation Alert Popup  - PASS', 'Validating Process Compenation Alert Popup  - FAIL', FailureHandling.STOP_ON_FAILURE)
		}

	}

	public static List<String> getExpectedProvidersForWarningMessageWRTRegularBasePayElement(String Region,String Location,String Year){
		List<String> ExpectedProviders=new ArrayList<String>()
		String LocationShortName=LocationPageSteps.getLocationShortNameWRTLocationName(Location)
		ManageProviderContractSteps.gotoManageProviderContract()
		ManageProviderContractSteps.selectRegion(Region)
		ManageProviderContractSteps.setStartDate('01/01/'+Year)
		ManageProviderContractSteps.clickGetContracts()
		Set<String> setProviders=new HashSet<String>()
		setProviders=ManageProviderContractSteps.getGridPayrollIDWithLocation(LocationShortName)
		HashMap<String,String> ProviderEmployeeType=new HashMap<String,String>()
		ProviderEmployeeType=ProviderSetupSteps.getSetOfProvidersAndEmployeeType(setProviders)
		println ProviderEmployeeType

		for(String Provider:ProviderEmployeeType.keySet()) {
			if(ProviderEmployeeType.get(Provider).equals('Employed')) {
				ManageProviderContractSteps.gotoManageProviderContract()
				ManageProviderContractSteps.setProviderID(Provider)
				ManageProviderContractSteps.editProviderContract()
				ManageProviderContractSteps.selectCurrentYear(Year)
				List<String> lstCompModels=new ArrayList<String>()
				lstCompModels=ManageProviderContractSteps.getCompModelsTabs()
				for(String CompModel:lstCompModels) {
					ManageProviderContractSteps.selectCompModelTab(CompModel)
					List<String> lstCostCenters=new ArrayList<String>()
					lstCostCenters=ManageProviderContractSteps.getCostCenterTabs()
					for(String CostCenter:lstCostCenters) {
						ManageProviderContractSteps.selectCostCenterTab(CostCenter)
						List<String> lstPayElements=new ArrayList<String>()
						lstPayElements=ManageProviderContractSteps.getPayElements()
						for(String PayElement:lstPayElements) {
							if(PayElement.startsWith('Regular Base Salary(Base Draw)'))
							{
								ExpectedProviders.add(Provider)
							}
						}
					}
				}

			}

		}

		return ExpectedProviders
	}

	public static List<String> getExpectedProvidersForErrorMessageWRTMaxCompensation(String Region,String Location,String Year,String PayCycle,String tdPayPeriod){
		List<String> ExpectedProviders=new ArrayList<String>()
		String LocationShortName=LocationPageSteps.getLocationShortNameWRTLocationName(Location)
		ManageProviderContractSteps.gotoManageProviderContract()
		ManageProviderContractSteps.selectRegion(Region)
		ManageProviderContractSteps.setStartDate('01/01/'+Year)
		ManageProviderContractSteps.clickGetContracts()
		Set<String> setProviders=new HashSet<String>()
		setProviders=ManageProviderContractSteps.getGridProviderWithLocation(LocationShortName)

		HashMap<String,String> ProviderMaxCompensation=new HashMap<String,String>()
		String MaxCompensation
		for(String Provider:setProviders) {
			ManageProviderContractSteps.gotoManageProviderContract()
			ManageProviderContractSteps.setProviderID(Provider)
			ManageProviderContractSteps.editProviderContract()
			ManageProviderContractSteps.selectCurrentYear(Year)
			List<String> lstCompModels=new ArrayList<String>()
			lstCompModels=ManageProviderContractSteps.getCompModelsTabs()
			for(String CompModel:lstCompModels) {
				ManageProviderContractSteps.selectCompModelTab(CompModel)
				MaxCompensation=ManageProviderContractSteps.getMaxCompensation()
				ProviderMaxCompensation.put(Provider, MaxCompensation)
			}
		}

		HashMap<String,String> expectedProviderPayPeriod=new HashMap<String,String>()
		for(String Provider:ProviderMaxCompensation.keySet())
		{

			Double MaxComp=ProviderMaxCompensation.get(Provider).replace(',', '').toDouble()
			ProviderPayApprovalsSteps.gotoProviderPayApprovals()
			ProviderPayApprovalsSteps.setProvider(Provider)
			ProviderPayApprovalsSteps.selectRegion(Region)
			ProviderPayApprovalsSteps.selectPayCycle(PayCycle)
			ProviderPayApprovalsSteps.selectLocation(Location)
			ProviderPayApprovalsSteps.selectPayrollStatusAsApproved()
			ProviderPayApprovalsSteps.selectYear(Year)
			ProviderPayApprovalsSteps.clickGetDetails()
			HashMap<String,String> PayPeriodAmount=new HashMap<String,String>()
			PayPeriodAmount=ProviderPayApprovalsSteps.getPayPeriodAmount()

			Double Compensation=0
			String maxPayPeriod
			for(String PayPeriod:PayPeriodAmount.keySet()) {
				Compensation=Compensation+PayPeriodAmount.get(PayPeriod).replace(',', '').toDouble()
				if(Compensation>=MaxComp) {
					maxPayPeriod=PayPeriod
					break
				}

			}
			expectedProviderPayPeriod.put(Provider, maxPayPeriod)
		}

		List<String> lstProviders=new ArrayList<String>()
		for(String Provider:expectedProviderPayPeriod.keySet())
		{
			if(!expectedProviderPayPeriod.get(Provider).equals(null)) {
				if(DateTimeUtil.verifyDateEqualsAfterDate(tdPayPeriod.split(' - ')[0], expectedProviderPayPeriod.get(Provider).split(' - ')[0]))
					lstProviders.add(Provider)
			}
		}
		return lstProviders
	}

	public static void verifyInformationMessageIfProviderswithRegularBasePayElement(Collection<String> ExpectedProviders) {
		if(ExpectedProviders.size()>0) {
			List<String> Providers=new ArrayList<String>()
			Providers=getListOfProvidersNotSetupforContractedHoursFromInformationMessage()
			for(String Provider:ExpectedProviders)
			{
				AssertSteps.verifyActualResult(Providers.contains(Provider), 'Provider : '+Provider+' mentioned in Information Message - PASS', 'Provider : '+Provider+' not mentioned in Information Message - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

			}
		}

	}

	public static List<String> getListofProvidersAddedForProcessing(){
		return getBaseSteps().getListTextFromControl(lblProviders, pageName.PaymentProcess)
	}

	public static List<String> getListofProviderNamesAddedForProcessing(){
		List<String> AddedProviders=new ArrayList<String>()
		List<String> AddedProviderNames=new ArrayList<String>()
		AddedProviders=getBaseSteps().getListTextFromControl(lblProviders, pageName.PaymentProcess)
		for(String Provider:AddedProviders) {
			AddedProviderNames.add(Provider.substring(0, Provider.indexOf('[')).trim())
		}
		return 	AddedProviderNames
	}

	public static void verifyMultipleProviderInProcessByProvider(Collection<String> lstProviders) {
		if(this.isProcessByProviderCheckboxDisplayed()) {
			PaymentProcessPageSteps.checkProcessByProvider()
			for(String Provider:lstProviders) {
				PaymentProcessPageSteps.setPhysicianName(Provider)
				PaymentProcessPageSteps.clickAdd()
			}
			List<String> AddedProviders=new ArrayList<String>()
			AddedProviders=getListofProvidersAddedForProcessing()
			for(String Provider:AddedProviders) {
				Provider=Provider.substring(Provider.indexOf('[')+1, Provider.indexOf(']'))
				AssertSteps.verifyActualResult(lstProviders.contains(Provider), 'Provider : '+Provider+'is successfully Added to List - PASS', 'Provider : '+Provider+'is Failed to Added into List - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
			}


		}else {
			Logger.logWARNING('Multiple Provider Selection is not possible, may be Processed for selected Pay Period or General Setting flag ')
		}
	}


	public static void verifyProvidersInGridPaymentProcess() {
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		List<String> AddedProviders=new ArrayList<String>()
		AddedProviders=getListofProviderNamesAddedForProcessing()
		List<String> grdProviders=new ArrayList<String>()
		grdProviders=getBaseSteps().getColumnTableText(grdPaymentProcess, 'Provider Name', pageName.PaymentProcess)
		for(String Provider:grdProviders) {
			AssertSteps.verifyActualResult(AddedProviders.contains(Provider), 'Provider : '+Provider+' contains in Added List of Providers - PASS','Provider : '+Provider+' does not contains in Added List of Providers- FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}


	public static boolean isProcessByProviderCheckBoxEnabled() {
		return getBaseSteps().WebElementEnabled(chkProcessByProvider, pageName.PaymentProcess)
	}

	public static boolean isPhysicianNameTextBoxEnabled() {
		return getBaseSteps().WebElementEnabled(txtPhysicianName, pageName.PaymentProcess)
	}

	public static void verifyProcessByProviderOptionsAfterClickingProcessCompensation() {
		AssertSteps.verifyActualResult(!isProcessByProviderCheckBoxEnabled(), 'Process By Provider CheckBox is Disabled - PASS', 'Process By Provider CheckBox is Enabled - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(!isPhysicianNameTextBoxEnabled(), 'Physician Name TextBox is Disabled- PASS', 'Physician Name TextBox is Enabled - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyErrorMessageIfProvidersExceedMaxCompensation(Collection<String> ExpectedProviders) {
		if(ExpectedProviders.size()>0) {
			List<String> Providers=new ArrayList<String>()
			Providers=getListOfProvidersforMaxCompensationFromErrorMessage()
			for(String Provider:ExpectedProviders)
			{
				AssertSteps.verifyActualResult(Providers.contains(Provider), 'Provider : '+Provider+' mentioned in Error Message - PASS', 'Provider : '+Provider+' not mentioned in Error Message - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

			}
		}

	}

	//Collection<String> ExpectedProviders
	public static void verifyCostCentersBackgroundColorForProvidersExceedMaxCompensation(ExpectedProviders) {
		int recordsCount=getBaseSteps().getRowTableCounts(grdPaymentProcess, pageName.PaymentProcess).toInteger()
		int i=2
		String bgColor,ProviderName
		while(i<=recordsCount) {
			bgColor=getBaseSteps().getCellTableBackgroundColor(grdPaymentProcess, i.toString(), 'Cost Center', pageName.PaymentProcess)
			ProviderName=getBaseSteps().getCellTableText(grdPaymentProcess, i.toString(), 'Provider Name', pageName.PaymentProcess)
			if(ExpectedProviders.contains(ProviderName))
				AssertSteps.verifyActualResult(bgColor.equals(HIIConstants.Brick), 'Cost Center Background Color is Brick Color for Provider'+ProviderName+' Exceeeded Max Compensation - PASS', 'Cost Center Background Color is not Brick Color for Provider'+ProviderName+' Exceeeded Max Compensation - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
			i++
		}

	}

	public static boolean isGridPaymentProcessDisplayed() {
		return getBaseSteps().WebElementDisplayed(grdPaymentProcess, pageName.PaymentProcess)
	}

	public static HashMap<String,String> getRandomPaymentProcessRecordToValidate(){
		HashMap<String,String> PaymentProcess=new HashMap<String,String>()
		int randomRecordIndex
		if(isGridPaymentProcessDisplayed())
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			int recordsCount=getBaseSteps().getRowTableCounts(grdPaymentProcess, pageName.PaymentProcess).toInteger()
			if(recordsCount!=2)
				randomRecordIndex=CommonUtilities.generateRandomInteger(recordsCount)
			else
				randomRecordIndex=2


			PaymentProcess.put('PayrollID', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'Payroll ID', pageName.PaymentProcess))
			PaymentProcess.put('ProviderName', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'Provider Name', pageName.PaymentProcess))
			PaymentProcess.put('Specialty', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'Specialty', pageName.PaymentProcess))
			PaymentProcess.put('PayElement', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'Pay Element', pageName.PaymentProcess))
			if(getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'GL AccNo', pageName.PaymentProcess).equals(''))
				PaymentProcess.put('GLAccNo', null)
			PaymentProcess.put('HIICCID', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'HII CCID', pageName.PaymentProcess))
			PaymentProcess.put('CostCenter', getBaseSteps().getCellTableText(grdPaymentProcess, randomRecordIndex.toString(), 'Cost Center', pageName.PaymentProcess))

		}

		return PaymentProcess


	}


	public static boolean isLabelNoRecordsFoundDisplayed() {
		return getBaseSteps().WebElementDisplayed(lblNoRecordsFound, pageName.PaymentProcess)
	}

	public static void verifyProcessCompensationFunctionalityAfterSendToPayrollForSelectedProviders() {
		AssertSteps.verifyActualResult(isLabelNoRecordsFoundDisplayed(), 'Label No Records Found is displayed - PASS', 'Label No Records Found is not displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static List<HashMap> getPaymentProcessDetails(){
		List<HashMap> PaymentProcessDetails=new ArrayList<>()
		CommonSteps.selectMaxPagesize()
		int recordsCount=getBaseSteps().getRowTableCounts(grdPaymentProcess, pageName.PaymentProcess).toInteger()
		int i=2
		while(i<=recordsCount) {
			HashMap<String,String> PaymentProcessDetail=new HashMap<>()
			String grdPayElement=getBaseSteps().getCellTableText(grdPaymentProcess, i.toString(), 'Pay Element', pageName.PaymentProcess)
			String grdCalculatedAmount=getBaseSteps().getCellTableText(grdPaymentProcess, i.toString(), 'Calculated Amount', pageName.PaymentProcess)
			//String grdbgColorCostCenter=getBaseSteps().getCellTableBackgroundColor(grdPaymentProcess, i.toString(), 'Cost Center', pageName.PaymentProcess)
			PaymentProcessDetail.put('PayElement', grdPayElement)
			PaymentProcessDetail.put('CalculatedAmount', grdCalculatedAmount)
			//PaymentProcessDetail.put('bgColorCostCenter', grdbgColorCostCenter)
			PaymentProcessDetails.add(PaymentProcessDetail)
			i++
		}
		return PaymentProcessDetails

	}

}
