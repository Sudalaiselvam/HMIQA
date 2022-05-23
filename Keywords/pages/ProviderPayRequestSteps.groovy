package pages
import core.BaseSteps
import core.ControlFactory
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import org.testng.SkipException
import testDataTypes.ContractCompModel
import testDataTypes.ContractCostCenter
import testDataTypes.ContractData
import testDataTypes.ContractPayElement
import testDataTypes.ContractYear
import testDataTypes.ProviderDetails
import testDataTypes.ProviderData
import testDataTypes.ProviderPayRequest
import configs.HIIConstants
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import core.AssertSteps
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import core.Logger
import bsh.This
import pages.PayElementsSteps
import pages.OrgCompModelsPayElementsSteps
import pages.CostCenterPageSteps as CostCenterPageSteps
import pages.RoleUserWisePayElementsSteps
import utils.DateTimeUtil

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ProviderPayRequestSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static String getTerminationDate() {
		getBaseSteps().getTextFromControl('lblTerminationDate', pageName.ProviderPayRequest)
	}

	//############## WebElement available from Provider Pay Request ############################
	private static String txtProviderName='txtProviderName'
	private static String txtServiceStartDate='txtServiceStartDate'
	private static String txtServiceEndDate='txtServiceEndDate'
	private static String ddlCompModel='ddlCompModel'
	private static String ddlPayElement='ddlPayElement'
	private static String txtPayElementValue='txtPayElementValue'
	private static String ddlPayElementReason='ddlPayElementReason'
	private static String txtGLAccount='txtGLAccount'
	private static String txtLocation_CostCenter='txtLocation_CostCenter'
	private static String txtPayDate='txtPayDate'
	private static String ddlCheckgroup='ddlCheckgroup'
	private static String lblYTDAmount='lblYTDAmount'
	private static String btnUploadFiles='btnUploadFiles'
	private static String btnSave='btnSave'
	private static String msgSuccess='msgSuccess'
	private static String msgError='msgError'
	private static String smryValidation='smryValidation'
	private static String grdPhysicianPayRequest='grdPhysicianPayRequest'
	private static String grdPhysicianPayRequestFreeze='grdPhysicianPayRequestFreeze'
	private static String lblThresholdAmount='lblThresholdAmount'
	private static String pnlMaxThresholdPopUp='pnlMaxThresholdPopUp'
	private static String pnllblPopUpInfo='pnllblPopUpInfo'
	private static String pnlbtnContinue='pnlbtnContinue'
	private static String pnlbtnCancel='pnlbtnCancel'

	//########################### PAY REQUEST METHODS ####################################

	//To Navigate Provider Pay Request Screen
	public static void gotoProviderPayRequest() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayRequest', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		verifyFields()
	}

	public static void openProviderPayRequest_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayment', 'mnuProviderPayRequest', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//To set Provider Name
	public static void setProviderName(String Provider,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(Provider!="")
		{
			getBaseSteps().setTextToControl('txtProviderName', Provider, pageName.ProviderPayRequest)
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, failureHandling)
			getBaseSteps().waitforLoadingComplete('imgLoading', 10, pageName.CMN)
		}else {
			getBaseSteps().inputDataMissing('Provider data is missing from Input Data',failureHandling)
		}
	}

	//To select Service StartDate
	public static void selectServiceStartDate(String ServiceStartDate,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(ServiceStartDate!="") {
			if(getBaseSteps().WebElementDisplayed(txtServiceStartDate, pageName.ProviderPayRequest))
				getBaseSteps().selectDate(txtServiceStartDate, ServiceStartDate, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('Service Start Date is not available from Input Data and it is optional', failureHandling)
		}

	}

	//To select Request Date
	public static void selectRequestDate(String RequestDate,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(RequestDate!="") {

			if(getBaseSteps().WebElementDisplayed('txtServiceStartDate', pageName.ProviderPayRequest)) {
				getBaseSteps().selectDate('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
			}else {
				getBaseSteps().chooseDate('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
			}

			getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		}else {
			getBaseSteps().inputDataMissing('Request Date is missing from Input Data',failureHandling)
		}

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//To select Compensation Model
	public static void selectCompensationModel(String CompensationModel,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(getBaseSteps().WebElementDisplayed(ddlCompModel, pageName.ProviderPayRequest))
			if(CompensationModel!="")
			{
				//if(!CompensationModel.equals(getBaseSteps().getselectedControlDropdowm(ddlCompModel, pageName.ProviderPayRequest)))
				try {
					getBaseSteps().selectByVisibleText(ddlCompModel, CompensationModel, pageName.ProviderPayRequest)
				}catch(Exception e)
				{
					getBaseSteps().selectByVisibleTextStartsWith(ddlCompModel, CompensationModel, pageName.ProviderPayRequest)
				}
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			}
			else
		{	getBaseSteps().inputDataMissing('Compensation Model is not available from Input Data, Compensation Model is with default option', failureHandling)

		}
	}

	//To select Pay Element
	public static void selectPayElement(String PayElement,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(PayElement!="")
		{
			try {
				getBaseSteps().selectByVisibleText(ddlPayElement, PayElement, pageName.ProviderPayRequest)
			}catch(Exception e) {
				getBaseSteps().selectByVisibleTextStartsWith(ddlPayElement, PayElement, pageName.ProviderPayRequest)
			}
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}else {
			getBaseSteps().inputDataMissing('Pay Element is missing from Input Data',failureHandling)
		}
	}

	//To set Pay Element Value
	public static void setPayElementValue(String PayElementValue,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(PayElementValue!="") {
			getBaseSteps().setTextToControl('txtPayElementValue', PayElementValue, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('PayElement Value is missing from Input Data',failureHandling)
		}
	}

	//To select Pay Element Reason
	public static void selectPayElementReason(String PayElementReason,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(PayElementReason!='') {
			getBaseSteps().selectByVisibleText(this.ddlPayElementReason, PayElementReason, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('Pay Element Reason is missing from Input Data', failureHandling)
		}
	}

	//To set Pay Element GL Account
	public static void setPayElementGLAccount(String GLAccount,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(GLAccount!='') {
			getBaseSteps().setTextToControl(this.txtGLAccount, GLAccount, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('GL Account is not available from Input Data', failureHandling)
		}
	}

	//To set Pay Element Location Cost Center
	public static void setPayElementLocationCostCenter(String LocationCostCenter,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(LocationCostCenter!='') {
			getBaseSteps().setTextToControl(this.txtLocation_CostCenter, LocationCostCenter, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('Location Cost Center is not available from Input Data', failureHandling)
		}
	}

	//To select Pay Element Pay Date
	public static void selectPayElementPayDate(String PayDate,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(PayDate!="") {
			getBaseSteps().selectDate(this.txtPayDate, PayDate, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('Pay Date is not available from Input Data and it is optional', failureHandling)
		}
	}

	//To select PayElementCheckGroup
	public static void selectPayElementCheckGroup(String CheckGroup,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		if(CheckGroup!='') {
			getBaseSteps().selectByVisibleText(this.ddlCheckgroup, CheckGroup, pageName.ProviderPayRequest)
		}else {
			getBaseSteps().inputDataMissing('Checkgroup is missing from Input Data', failureHandling)
		}
	}

	//To select PayElementUploadFile
	public static void setPayElementUploadFile(String FileName,FailureHandling failureHandling=FailureHandling.OPTIONAL) {

		getBaseSteps().clickToControl(btnUploadFiles, pageName.ProviderPayRequest)
		try {
			getBaseSteps().setTextToControl(btnUploadFiles, HIIConstants.PPR_SinglePayRequest_UploadFiles(FileName), pageName.ProviderPayRequest)
		}catch(Exception e) {
			getBaseSteps().StepOnFailure('Fail: Upload File', failureHandling)
		}

	}

	//To select PayElementUploadFile
	public static void setPayRequestImportUploadFile(String UploadFilepath,FailureHandling failureHandling=FailureHandling.OPTIONAL) {
		//getBaseSteps().setTextToControl(btnUploadFiles, UploadFilepath, pageName.ProviderPayRequest)
		getBaseSteps().clickToControl('import_ChooseFile', pageName.ProviderPayRequest)
		//getBaseSteps().setTextToControlJS(btnUploadFiles, UploadFilepath, pageName.ProviderPayRequest)
	}

	//To Click Save Button
	public static void clickSave() {
		getBaseSteps().clickToControl(btnSave, pageName.ProviderPayRequest)
	}

	//To upload file
	public static void setPayElementUploadFile() {

		getBaseSteps().setTextToControl(btnUploadFiles,'textpath',pageName.ProviderPayRequest)

	}

	//To check Provider Name displayed
	public static void verifyProviderNameDisplayed() {
		getBaseSteps().verifyControlDisplayed('txtProviderName', pageName.ProviderPayRequest,'Provider Name field displayed','Provider Name field not displayed')
	}

	//To verify Service Start Date displayed
	public static void verifyServiceStartDateDisplayed() {
		getBaseSteps().verifyControlDisplayed('txtServiceStartDate', pageName.ProviderPayRequest,'Service Start Date field displayed','Service Start Date field, not displayed')
	}

	//To verify Service End Date displayed
	public static void verifyServiceEndDateDisplayed() {
		getBaseSteps().verifyControlDisplayed('txtServiceEndDate', pageName.ProviderPayRequest,'Request Date field displayed','Request Date field, not displayed')
	}

	//To verify Compensation Model displayed
	public static void verifyCompModelDisplayed() {
		getBaseSteps().verifyControlDisplayed('ddlCompModel', pageName.ProviderPayRequest,'Compensation Model Drop down, displayed','Compensation Model Drop down, not displayed')
	}

	//To verify Pay Element displayed
	public static void verifyPayElementDisplayed() {
		getBaseSteps().verifyControlDisplayed('ddlPayElement', pageName.ProviderPayRequest,'PayElement drop down displayed','PayElement drop down not displayed')
	}

	//To verify Pay Element Value displayed
	public static void verifyPayElementValueDisplayed() {
		getBaseSteps().verifyControlDisplayed('txtPayElementValue', pageName.ProviderPayRequest,'PayElement value field displayed','PayElement value field not displayed')
	}

	//To verify Pay Element Reason displayed
	public static void verifyPayElementReasonDisplayed() {
		getBaseSteps().verifyControlDisplayed('ddlPayElementReason', pageName.ProviderPayRequest,'PayElement Reason drop down displayed','PayElement Reason drop down not displayed')
	}


	//########################### DEPENDENCY METHODS #######################################

	// To get Provider eligibility from Contract screen

	public static boolean getContractProviderNameValidity(String Provider) {

		boolean blnProvider=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData = ManageProviderContractSteps.getContractDetailsMarkCompleted(Provider)
		for(String currentYear:contractData.CurrentYear)
		{
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				if(contractCompModel.ContractStatus.equals('Checked'))
					blnProvider=true
			}
		}
		return blnProvider
	}

	//To get Request Date validity
	public static boolean getSingleRequestDateValidity(String Provider,String RequestDate) {

		boolean blnValidRequestDate=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		//contractData=getProviderContractData(Provider)
		contractData=ManageProviderContractSteps.getContractDetails(Provider)
		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					for(String payElement:contractCostCenter.lstPayElements) {
						contractPayElement=contractCostCenter.HMContractPayElement.get(payElement)
						if(contractPayElement.PayElementType.equals('Variable')) {
							if(AssertSteps.verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
								blnValidRequestDate=true
						}
					}
				}
			}
		}
		return blnValidRequestDate
	}

	//To select for multiple Request Dates
	public static void selectMultipleRequestDate(List<String> RequestDate) {

		String eStartEndDatesPS=GeneralSettingsSteps.getEnableStartandEndDatesforthePaymentsSetting()
		WebUI.delay(2)
		if(eStartEndDatesPS.equals(HIIConstants.No))
		{
			getBaseSteps().selectMultipleDates('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
			getBaseSteps().clickToControl('imgOrganization', pageName.CMN)

		}else {
			throw new SkipException('\' EnableStartandEndDatesforthePaymentsSetting \' is set as \'Yes\', can not set multiple request date')

		}
	}

	//To get expected Termination Date
	public static String getExpectedTerminationDate(String Provider) {


		ProviderPayRequest providerPayRequest

		providerPayRequest=getProviderData(Provider)

		String expectedTerminationDate= providerPayRequest.providerData.getTerminationDate()

		return expectedTerminationDate
	}

	//To Edit Pay Request
	public static void editProviderPayRequest(String RequestDate) {

		String ServiceDate
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				ServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				if(ServiceDate.equals(RequestDate)) {
					getBaseSteps().clickToCellTableImage(grdPhysicianPayRequest, (i+1).toString(), 'Edit', pageName.ProviderPayRequest)
				}
			}
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.ProviderPayRequest)

	}

	public static void editProviderPayRequest(String CompensationModel,String PayElement,String RequestDate) {

		String grdCompensationModel,grdPayElement,grdServiceDate
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdCompensationModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)

				if(grdCompensationModel.equals(CompensationModel) && grdPayElement.equals(PayElement) && grdServiceDate.equals(RequestDate)) {
					getBaseSteps().clickToCellTableImage(grdPhysicianPayRequest, (i+1).toString(), 'Edit', pageName.ProviderPayRequest)
				}
			}
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.ProviderPayRequest)

	}

	//To get list eligible Compensation Models
	public static Collection<String> getExpectedCompensationModels(String Provider,String RequestDate){

		ContractData contractData
		ContractYear contractYear
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		HashSet<String> expectedCompModel=new HashSet<String>()
		String sYear=RequestDate.split('/').getAt(2)

		//contractData = ProviderPayRequestSteps.getProviderContractData(Provider)
		contractData = ProviderPayRequestSteps.getProviderContractDataforYear(Provider, sYear)
		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					List<String> lstPayElement=new ArrayList<String>()
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					if(contractCostCenter.CompModel.endsWith(sYear)) {
						expectedCompModel.add(contractCostCenter.CompModel)

						for(String payElement:contractCostCenter.lstPayElements) {
							contractPayElement = contractCostCenter.HMContractPayElement.get(payElement)
							if (contractPayElement.PayElementType.equals('Variable')) {
								if(getBaseSteps().verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
									expectedCompModel.add(contractCostCenter.CompModel)
								//lstPayElement.add(payElement.split('-').getAt(0) +'~ '+contractPayElement.StartDate+'-'+contractPayElement.EndDate)
							}
						}
					}
				}
			}
		}
		return expectedCompModel
	}

	//To get list of expected Pay Elements
	public static List<String> getExpectedPayElements(String Provider,String RequestDate,String CompModel){

		List<String> expectedPayElements = new ArrayList<String>()

		List<String> lstUPayElements=new ArrayList<String>()
		lstUPayElements=getExpectedUniversalPayElements(CompModel)
		expectedPayElements.addAll(lstUPayElements)

		List<String> lstCPayElements=new ArrayList<String>()
		lstCPayElements=getExpectedPayElementsfromContract(Provider,RequestDate,CompModel)
		expectedPayElements.addAll(lstCPayElements)

		return expectedPayElements
	}

	//To get list of expected Pay Elements for which Pay Request Note is Mandatory
	public static List<String> getExpectedPayRequestNotePayElements(){

		List<String> lstNotePayElements=new ArrayList<String>()

		PayElementsSteps.openPayElements_newTab()
		PayElementsSteps.selectPayElementType('Variable')
		PayElementsSteps.selectLastPageSize()
		lstNotePayElements = PayElementsSteps.getCommentsRequiredPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		return lstNotePayElements
	}

	//To get list of expected Pay Elements for which Upload Files is Mandatory
	public static List<String> getExpectedUploadFilesPayElements(){

		List<String> lstAttachmentsPayElements=new ArrayList<String>()

		PayElementsSteps.openPayElements_newTab()
		PayElementsSteps.selectPayElementType('Variable')
		PayElementsSteps.selectLastPageSize()
		lstAttachmentsPayElements = PayElementsSteps.getAttachmentRequiredPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		return lstAttachmentsPayElements
	}

	//To get Pay Element Threshold from Contract Screen
	public static String getPayElementThreshold(String Provider,String RequestDate,String CompModel,String PayElement){

		ContractData contractData
		ContractYear contractYear
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		List<String> expectedPayElement=new ArrayList<String>()
		String cYear=RequestDate.split('/').getAt(2)
		String spayElement,PayElementThreshold

		//contractData = ProviderPayRequestSteps.getProviderContractDataforYear(Provider, cYear)
		contractData = ManageProviderContractSteps.getContractDetailsforYear(Provider, cYear)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					List<String> lstPayElement=new ArrayList<String>()
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					if(contractCostCenter.CompModel.endsWith(cYear)) {
						if(contractCostCenter.CompModel.equals(CompModel))
							for(String payElement:contractCostCenter.lstPayElements) {
								contractPayElement = contractCostCenter.HMContractPayElement.get(payElement)
								if (contractPayElement.PayElementType.equals('Variable')) {
									if(getBaseSteps().verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
									{
										spayElement=payElement.split('-').getAt(0) +'~ '+contractPayElement.StartDate+'-'+contractPayElement.EndDate
										if(spayElement.equals(PayElement)) {
											PayElementThreshold=contractPayElement.ThresholdAmount
											break
										}
									}
								}
							}
					}
				}
			}
		}

		DecimalFormat df=new DecimalFormat('0.00')
		return ('$' + df.format(Float.parseFloat(PayElementThreshold.replace(',', ''))))

	}



	//########################### ASSERTION METHODS #######################################

	//To check Provider Name Web Service functionality after entering Provider into Provider Name field
	public static void verifyProviderNameWebService(String Provider,boolean validProvider) {
		getBaseSteps().setTextToControl('txtProviderName', Provider, pageName.ProviderPayRequest)

		if(validProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		}
	}

	//To check Request Date functionality- error message when out of contract duration
	public static void verifySingleRequestDatefunctionality(String RequestDate,boolean RequestDateValidity) {

		selectRequestDate(RequestDate)

		//selectRequestDatewithoutMasterDatadpndcy(RequestDate)

		getBaseSteps().waitforLoadingComplete('imgLoading',20,pageName.ProviderPayRequest)

		if(RequestDateValidity) {
			getBaseSteps().verifyWebElementNotDisplayed('lblValidation', pageName.ProviderPayRequest, 'Request Date validation message is not displayed', 'Request Date validation message is displayed', FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyLabelWithTextDisplayed('lblValidation', HIIConstants.PPR_NoContractSelectedServiceDate, pageName.ProviderPayRequest, 'Request Data with expected validation message is displayed', 'Request Data with expected validation message is not displayed', FailureHandling.STOP_ON_FAILURE)
		}

	}

	//To verify Service Start Date
	public static void verifyServiceStartDate() {
		String eStartEndDatesPS=GeneralSettingsSteps.getEnableStartandEndDatesforthePaymentsSetting()

		if(eStartEndDatesPS.equals(HIIConstants.Yes)) {
			getBaseSteps().verifyWebElementDisplayed('txtServiceStartDate', pageName.ProviderPayRequest, 'Service Start Date is displayed as \' EnableStartandEndDatesforthePaymentsSetting \' is set as \'Yes\'', 'Service Start Date is not displayed even \' EnableStartandEndDatesforthePaymentsSetting \' is set as \'Yes\'', FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyWebElementNotDisplayed('txtServiceStartDate', pageName.ProviderPayRequest, 'Service Start Date is not displayed as \' EnableStartandEndDatesforthePaymentsSetting \' is set as \'No\'', 'Service Start Date is displayed even \' EnableStartandEndDatesforthePaymentsSetting \' is set as \'No\'', FailureHandling.STOP_ON_FAILURE)

		}

	}

	//To check Request Date functionality- error message when out of contract duration
	public static void verifyMultipleRequestDatefunctionality(List<String> RequestDates,boolean RequestDateValidity) {

		if(!getBaseSteps().WebElementDisplayed('txtServiceStartDate', pageName.ProviderPayRequest))
		{
			selectMultipleRequestDate(RequestDates)

			getBaseSteps().clickEscape()

			getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

			if(RequestDateValidity) {
				getBaseSteps().verifyWebElementNotDisplayed('lblValidation', pageName.ProviderPayRequest, 'Request Date validation message is not displayed', 'Request Date validation message is displayed', FailureHandling.STOP_ON_FAILURE)
			}else {
				getBaseSteps().verifyLabelWithTextDisplayed('lblValidation', HIIConstants.PPR_NoContractSelectedServiceDate, pageName.ProviderPayRequest, 'Request Data with expected validation message is displayed', 'Request Data with expected validation message is not displayed', FailureHandling.STOP_ON_FAILURE)
			}
		}else {
			if(RequestDateValidity)
				Logger.logWARNING('Enable Start and End Dates for Payments set as \" Yes \"')
			
			//getBaseSteps().inputDataMissing('Enable Start and End Dates for Payments May be set as \" Yes \"', FailureHandling.CONTINUE_ON_FAILURE)
		}

	}

	//To verify Provider Termination
	public static void verifyProviderTerminationDate(String expectedTerminationDate) {

		if(expectedTerminationDate!=null) {

			String actualTerminationDate=this.getTerminationDate()
			AssertSteps.verifyActualResult(expectedTerminationDate.equals(actualTerminationDate), 'Termination Date is expected', 'Termination Date is not as expected', FailureHandling.STOP_ON_FAILURE)

		}

	}

	//To Delete Pay Request
	public static void deleteProviderPayRequest(String RequestDate,String tdCompModel,String tdPayElement) {

		String grdServiceDate,grdCompModel,grdPayElement,grdStatus
		String CompModel=tdCompModel.split(' - ')[0]
		String PayElement=tdPayElement.split(' ~ ')[0]
		String ServiceDate,alertMSG,confirmationMSG
		boolean blnRequestDate=false
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {

				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Status', pageName.ProviderPayRequest)

				if(RequestDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement.split(' - ')[0]))
				{
					blnRequestDate=true

					getBaseSteps().clickToCellTableImage(grdPhysicianPayRequest, (i+1).toString(), 'Delete', pageName.ProviderPayRequest)
					if(WebUI.verifyAlertPresent(10)) {
						alertMSG=WebUI.getAlertText()
						WebUI.acceptAlert()
						AssertSteps.verifyActualResult(alertMSG.equals('Are you sure, do you want to delete the selected record?'), 'Expected Alert message displayed', 'Expected Alert message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(this.msgSuccess, pageName.ProviderPayRequest), 'Success Message displayed', 'Success Message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						confirmationMSG=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)
						if(grdStatus.equals('Level1ApprovalPending'))
							AssertSteps.verifyActualResult(confirmationMSG.equals('Deleted Record(s) Successfully.'), 'Delete Confirmation message displayed', 'Delete Confirmation message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						break
					}



				}
			}

			AssertSteps.verifyActualResult(blnRequestDate, 'Pay Request exist for Service Date:'+RequestDate, 'Pay Request does not exist for test data: Service Date: '+RequestDate, FailureHandling.CONTINUE_ON_FAILURE)


		}



	}

	//To verify Pay Request exists
	public static boolean verifyProviderPayRequestExists(String tdRequestDate,String tdCompModel,String tdPayElement) {
		boolean blnPayRequest=false
		String grdServiceDate,grdCompModel,grdPayElement,grdStatus
		String CompModel=tdCompModel.split(' - ')[0]
		String PayElement=tdPayElement.split(' ~ ')[0]

		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest))

		{
			if(getBaseSteps().WebElementDisplayed('ddlPageSize', pageName.CMN))
			{
				getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			}
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Status', pageName.ProviderPayRequest)

				if(tdRequestDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement.split(' - ')[0]) && grdStatus.equals('Level1ApprovalPending'))
				{
					blnPayRequest=true
					break
				}


			}
		}
		return blnPayRequest
	}

	public static boolean verifyProviderPayRequestForServiceDateWithApprovedStatusExists(String Provider,String CompensationModel,String PayElement,String ServiceDate) {
		boolean blnPayRequest=false
		String grdServiceDate,grdCompModel,grdPayElement,grdStatus
		String CompModel=CompensationModel.split(' - ')[0]
		String PRPayElement=PayElement.split(' ~ ')[0]

		openProviderPayRequest_newTab()
		setProviderName(Provider)
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest)) {
			if(getBaseSteps().WebElementDisplayed('ddlPageSize', pageName.CMN))
			{
				getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			}
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Status', pageName.ProviderPayRequest)
				if(ServiceDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement.split(' - ')[0]) && grdStatus.equals('Approved'))
				{
					blnPayRequest=true
					break
				}
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return blnPayRequest
	}

	public static String getProviderPayRequestStatusForServiceDateExists(String Provider,String CompensationModel,String PayElement,String ServiceDate) {
		boolean blnPayRequest=false
		String PayRequestStatus
		String grdServiceDate,grdCompModel,grdPayElement,grdStatus
		String CompModel=CompensationModel.split(' - ')[0]
		String PRPayElement=PayElement.split(' ~ ')[0]

		openProviderPayRequest_newTab()
		setProviderName(Provider)
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest)) {
			if(getBaseSteps().WebElementDisplayed('ddlPageSize', pageName.CMN))
			{
				getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			}
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Status', pageName.ProviderPayRequest)
				if(ServiceDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement.split(' - ')[0]))
				{
					blnPayRequest=true
					break
				}
			}
			if(blnPayRequest)
				PayRequestStatus=grdStatus
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return PayRequestStatus
	}

	// To Verify Pay Request Creation
	public static void verifyProviderPayRequestCreation(String expSuccessMSG='',String expErrorMSG='') {

		if(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayRequest)) {
			String successMsg
			successMsg=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)
			//AssertSteps.verifyActualResult(successMsg.equals(expSuccessMSG), 'Provider Pay Request created/updated successfully with message: '+successMsg, 'Provider Pay Request creation/updation failed with message:'+successMsg, FailureHandling.STOP_ON_FAILURE)
			AssertSteps.verifyActualResult(successMsg.contains(expSuccessMSG), 'Provider Pay Request created/updated successfully with message: '+successMsg, 'Provider Pay Request creation/updation failed with message:'+successMsg, FailureHandling.STOP_ON_FAILURE)
		}else if(getBaseSteps().WebElementDisplayed(msgError, pageName.ProviderPayRequest)) {
			String ErrorMsg
			ErrorMsg=getBaseSteps().getTextFromControl(msgError, pageName.ProviderPayRequest)
			AssertSteps.verifyActualResult(ErrorMsg.equals(expErrorMSG), 'Provider Pay Request created failed with expected Error message: '+ErrorMsg, 'Provider Pay Request creation failed with unexpected Error message:'+ErrorMsg, FailureHandling.STOP_ON_FAILURE)
		}else if(getBaseSteps().WebElementDisplayed(smryValidation, pageName.ProviderPayRequest)) {
			String actualSummary
			actualSummary=getValidationSummary()

			String strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
			String strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)
			String strAmount=getBaseSteps().getValueFromControl(this.txtPayElementValue, pageName.ProviderPayRequest)


			if(strProviderName=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Provider Name.'),  'Validation Summary contains Provider Name to be entered', 'Validation Summary does not contains Provider Name to be entered', FailureHandling.CONTINUE_ON_FAILURE)

			if(strRequestDate=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Select Service End Date.'),  'Validation Summary contains Request Date to be entered', 'Validation Summary does not contains Request Date to be entered', FailureHandling.CONTINUE_ON_FAILURE)
			else {

				String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
				if(strPayElement.equals('-Select Pay Element-'))
				{
					AssertSteps.verifyActualResult(actualSummary.contains('Please Select Pay Element'),  'Validation Summary contains Pay Element to be selected', 'Validation Summary does not contains Pay Element to be selected', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}

			if(strAmount=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Amount/Units.'), 'Validation Summary contains Amount/Units to be entered', 'Validation Summary does not contains Amount/Units to be entered', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	//To verify Compensation Model drop down values with list of expected of Compensation Model for select Service Date
	public static void verifyCompensationModelData(Collection<String> expectedCompensationModels) {

		List<String> lstCompModel=new ArrayList<String>()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.ProviderPayRequest)
		lstCompModel=getBaseSteps().getlistControlDropdowm('ddlCompModel', pageName.ProviderPayRequest)
		lstCompModel.remove('-Select Compensation-')
		for(String actualCompModel:lstCompModel) {
			AssertSteps.verifyActualResult(expectedCompensationModels.contains(actualCompModel), actualCompModel+': Compensation Model exist', actualCompModel+': Compensation Model does not exist', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	//To verify PayElements drop down list
	public static void verifyPayElementsData(List<String> expectedPayElements) {

		List<String> lstPayElements=new ArrayList<String>()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.ProviderPayRequest)
		lstPayElements=getBaseSteps().getlistControlDropdowm('ddlPayElement', pageName.ProviderPayRequest)

		lstPayElements.remove('-Select Pay Element-')
		for(String actualPayElement:lstPayElements) {
			AssertSteps.verifyActualResult(expectedPayElements.contains(actualPayElement), actualPayElement+': Pay Element exist', actualPayElement+': Pay Element does not exist', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	//To verify Summary expected to contain information about Pay Request Note as Mandatory for Pay Element
	public static void verifyValidationSummaryPayRequestNote(List<String> expectedNotePayElements) {
		String actualSummary
		actualSummary=getValidationSummary()

		String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
		String aPayElement=strPayElement.split(' ~ ').getAt(0)
		String strPayRequestNote=getBaseSteps().getValueFromControl('txaPayRequestNote', pageName.ProviderPayRequest)

		if(strPayRequestNote=="")
			if(strPayElement.equals('-Select Pay Element-')) {
				List<String> lstPayElements=new ArrayList<String>()
				lstPayElements=getBaseSteps().getlistControlDropdowm('ddlPayElement', pageName.ProviderPayRequest)
				lstPayElements.remove('-Select Pay Element-')
				for(String payElement:lstPayElements) {
					if(expectedNotePayElements.contains(payElement.split('~').getAt(0).trim()))
						AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Request Notes.'), 'Validation Summary contains Pay Request Note to be entered', 'Validation Summary does not contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}else{
				if(expectedNotePayElements.contains(aPayElement)) {
					AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Request Notes.'), 'Validation Summary contains Pay Request Note to be entered', 'Validation Summary does not contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}else {
					AssertSteps.verifyActualResult(!actualSummary.contains('Please Enter Request Notes.'), 'Validation Summary contains Pay Request Note is not Mandatory', 'Validation Summary contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}


	}

	//To verify Summary expected to contain information about Attachment as Mandatory for Pay Element
	public static void verifyValidationSummaryAttachmentRequired(List<String> expectedAttReqPayElements) {
		String actualSummary
		actualSummary=getValidationSummary()

		String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
		String aPayElement=strPayElement.split(' ~ ').getAt(0)
		String strPayRequestNote=getBaseSteps().getValueFromControl('txaPayRequestNote', pageName.ProviderPayRequest)

		if(strPayRequestNote=="")
			if(strPayElement.equals('-Select Pay Element-')) {
				List<String> lstPayElements=new ArrayList<String>()
				lstPayElements=getBaseSteps().getlistControlDropdowm('ddlPayElement', pageName.ProviderPayRequest)
				lstPayElements.remove('-Select Pay Element-')
				for(String payElement:lstPayElements) {
					if(expectedAttReqPayElements.contains(payElement.split('~').getAt(0).trim()))
						AssertSteps.verifyActualResult(actualSummary.contains('Please Select Attachment.'), 'Validation Summary contains Pay Request Note to be entered', 'Validation Summary does not contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}else{
				if(expectedAttReqPayElements.contains(aPayElement)) {
					AssertSteps.verifyActualResult(actualSummary.contains('Please Select Attachment.'), 'Validation Summary contains Pay Request Note to be entered', 'Validation Summary does not contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}else {
					AssertSteps.verifyActualResult(!actualSummary.contains('Please Select Attachment.'), 'Validation Summary contains Pay Request Note is not Mandatory', 'Validation Summary contains Pay Request Note to be entered', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}


	}

	//To verify Pay Pay Request Creation Success Message
	public static void verifyPayRequestCreationSuccessMessage(String RequestDate,String PayElement) {

		String expectedSuccessMessage=HIIConstants.PPR_PayRequestSuccessMessage(RequestDate, PayElement)
		String actualSuccessMessage=getSuccessMessage()
		AssertSteps.verifyActualResult(actualSuccessMessage.equals(expectedSuccessMessage), 'Success Message is as expected', 'Success Message is not as expected, Actual Message: '+actualSuccessMessage+',Expected Message: '+expectedSuccessMessage, FailureHandling.STOP_ON_FAILURE)

	}

	//To verify Pay Pay Request Creation Error Message
	public static void verifyPayRequestCreationErrorMessage(String RequestDate,String PayElement) {

		String expectedErrorMessage=HIIConstants.PPR_PayRequestErrorMessage(RequestDate, PayElement)
		String actualErrorMessage=getErrorMessage()
		AssertSteps.verifyActualResult(actualErrorMessage.equals(expectedErrorMessage), 'Error Message is as expected', 'Error Message is not as expected', FailureHandling.STOP_ON_FAILURE)

	}

	//To verify Max Threshold Validation
	public static void VerifyMaxThresholdValidation(String ContractPayElementThreshold) {

		Double PayElementAmount,ThresholdAmount

		PayElementAmount=getYTDAmount()+getAmount()

		if(getBaseSteps().WebElementDisplayed(lblThresholdAmount, pageName.ProviderPayRequest))
		{
			ThresholdAmount=getThresholdAmount()

			AssertSteps.verifyActualResult(Double.parseDouble(ContractPayElementThreshold.replace('$', '')).equals(ThresholdAmount), 'Threshold from Contract is same as in Threshold in Pay Request', 'Threshold from Contract is not same as in Threshold in Pay Request', FailureHandling.CONTINUE_ON_FAILURE)

			if(PayElementAmount>=ThresholdAmount)

			{

				String expectedThresholdMessage=HIIConstants.PPR_MaxThresholdLimitPopUpMessage(getPayElement(),getCompensationModel(), getProviderName())
				String actualThresholdMessage
				clickSave()
				AssertSteps.verifyActualResult(MaxThresholdPopUpDisplayed(), 'Max Threshold limit Pop Up displayed', 'Max Threshold limit Confirmation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
				actualThresholdMessage=getPopUpInformation()
				AssertSteps.verifyActualResult(actualThresholdMessage.equals(expectedThresholdMessage), 'Max Threshold Pop-Up Information is as expected', 'Max Threshold Pop-Up Information is not as expected \n Expected:'+expectedThresholdMessage+' \n Actual: '+actualThresholdMessage, FailureHandling.STOP_ON_FAILURE)

			}
		}else {
			if(ContractPayElementThreshold!=null)
				AssertSteps.verifyActualResult(false,'','Threshold Amount details should be displayed',FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static boolean ProviderPayRequestCreated(String ProviderName) {
		boolean blnPayRequest=false
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			if(rowCount>=2) {
				blnPayRequest=true
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return blnPayRequest

	}

	public static String getPayRequestStatus(String ProviderName,String ServiceDate,String PayElement) {
		String grdServiceDate,grdPayElement,grdStatus,sPayElement
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().setWindowsSize(75)

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayRequest)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Status', pageName.ProviderPayRequest)
					break
				}
				i++
			}

		}


		getBaseSteps().setWindowsSize(100)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return grdStatus
	}

	public static String getGridUploadedFilesName(String ProviderName,String ServiceDate,String PayElement) {
		String grdServiceDate,grdPayElement,grdUploadedFilesName,sPayElement
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			getBaseSteps().setWindowsSize(50)
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayRequest)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					grdUploadedFilesName=getBaseSteps().getCellTableImageName(grdPhysicianPayRequest, i.toString(), 'Uploaded Files', pageName.ProviderPayRequest)
				}
				i++
			}
			getBaseSteps().setWindowsSize(100)
		}else {
			Logger.setFailureHandling('Pay Request does not exist for Provider:'+ProviderName, FailureHandling.STOP_ON_FAILURE)
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return grdUploadedFilesName
	}

	public static String getGridUploadedFilesName(String ProviderName,String CompensationModel,String PayElement,String ServiceDate) {
		String grdServiceDate,grdPayElement,grdUploadedFilesName,sPayElement,grdCompModel
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			getBaseSteps().setWindowsSize(50)
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			int i=2
			while(i<=rowCount) {
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayRequest)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdCompModel.equals(CompensationModel) && grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					grdUploadedFilesName=getBaseSteps().getCellTableImageName(grdPhysicianPayRequest, i.toString(), 'Uploaded Files', pageName.ProviderPayRequest)
				}
				i++
			}
			getBaseSteps().setWindowsSize(100)
		}else {
			Logger.setFailureHandling('Pay Request does not exist for Provider:'+ProviderName, FailureHandling.STOP_ON_FAILURE)
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return grdUploadedFilesName
	}

	public static String getPayRequestData(String ProviderName,String ServiceDate,String PayElement,String getData) {
		String grdServiceDate,grdPayElement,grdStatus,grdAmount
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Pay Element', pageName.ProviderPayRequest)
				if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
					grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Status', pageName.ProviderPayRequest)
				}

			}else {
				for(int i=2;i<rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayRequest)
					if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
						grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Status', pageName.ProviderPayRequest)
						grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), '$ Amount', pageName.ProviderPayRequest)
						String grdUnits=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Units', pageName.ProviderPayRequest)
						String grdUnitFrequency=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Unit Frequency', pageName.ProviderPayRequest)
						break
					}
				}
			}

		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		switch(getData) {
			case 'Status': return grdStatus
				break
			case 'Amount': return
		}

		return grdStatus
	}

	public static void verifyPageNavigationtoProviderPayRequest() {
		getBaseSteps().verifyPageIsLoaded(HIIConstants.URL_ProviderPayRequest)
	}

	public static ProviderPayRequest getProviderNamePreRequisite(String Provider) {

		ProviderData providerData
		ProviderPayRequest providerPayRequest=new ProviderPayRequest()
		providerData=ProviderSetupSteps.getProviderData(Provider)

		providerPayRequest.blnProvider=false

		if(!providerData.employeeStatus.equals(HIIConstants.ES_OnboardingInProgress)) {

			ContractData contractData
			ContractCompModel contractCompModel
			ContractCostCenter contractCostCenter
			ContractPayElement contractPayElement
			ContractYear contractYear

			contractData = ManageProviderContractSteps.getContractDetails(Provider)
			for(String currentYear:contractData.CurrentYear)
			{
				contractYear=contractData.HMContractYear.get(currentYear)
				for(String compModel:contractYear.lstCompModel) {
					contractCompModel=contractYear.HMContractCompModel.get(compModel)
					if(contractCompModel.ContractStatus.equals('Checked'))
						providerPayRequest.blnProvider=true
				}

			}
		}

		return providerPayRequest

	}

	public static void setRequestDate(String RequestDate) {
		getBaseSteps().selectDate('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyProviderName(String Provider) {

		ProviderPayRequest providerPayRequest

		providerPayRequest=getProviderNamePreRequisite(Provider)


		gotoProviderPayRequest()

		getBaseSteps().setTextToControl('txtProviderName', Provider, pageName.ProviderPayRequest)

		if(providerPayRequest.blnProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		}


	}

	public static void verifyServiceEndDate(String Provider,String ServiceEndDate) {

		boolean blnValidContract=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData=getProviderContractData(Provider)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					for(String payElement:contractCostCenter.lstPayElements) {
						contractPayElement=contractCostCenter.HMContractPayElement.get(payElement)
						if(contractPayElement.PayElementType.equals('Variable')) {
							if(AssertSteps.verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, ServiceEndDate))
								blnValidContract=true
						}
					}
				}
			}
		}

		this.gotoProviderPayRequest()

		this.setProviderName(Provider)

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		this.setRequestDate(ServiceEndDate)

		getBaseSteps().clickEscape()

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		if(blnValidContract) {
			getBaseSteps().verifyWebElementNotDisplayed('lblValidation', pageName.ProviderPayRequest, 'Request Date validation message is not displayed', 'Request Date validation message is displayed', FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyLabelWithTextDisplayed('lblValidation', HIIConstants.PPR_NoContractSelectedServiceDate, pageName.ProviderPayRequest, 'Request Data with expected validation message is displayed', 'Request Data with expected validation message is not displayed', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static ProviderPayRequest getProviderData(String Provider) {

		ProviderData providerData

		ProviderPayRequest providerPayRequest=new ProviderPayRequest()

		providerData=ProviderSetupSteps.getProviderData(Provider)

		providerPayRequest.providerData=providerData

		return providerPayRequest


	}

	public static ContractData getProviderContractData(String Provider) {
		ProviderData providerData

		ContractData contractData

		ProviderPayRequest providerPayRequest=new ProviderPayRequest()

		providerData=ProviderSetupSteps.getProviderData(Provider)

		providerPayRequest.providerData=providerData

		if(!providerData.employeeStatus.equals(HIIConstants.ES_OnboardingInProgress)) {
			contractData = ManageProviderContractSteps.getContractDetails(Provider)
		}

		return contractData


	}

	public static ContractData getProviderContractDataforYear(String Provider,String cYear) {
		ProviderData providerData

		ContractData contractData

		ProviderPayRequest providerPayRequest=new ProviderPayRequest()

		providerData=ProviderSetupSteps.getProviderData(Provider)

		providerPayRequest.providerData=providerData

		if(!providerData.employeeStatus.equals(HIIConstants.ES_OnboardingInProgress)) {
			contractData = ManageProviderContractSteps.getContractDetailsforYear(Provider, cYear)
		}

		return contractData


	}

	public static void verifyTerminationDate(String Provider) {

		ProviderPayRequest providerPayRequest

		providerPayRequest=getProviderData(Provider)

		String expectedTerminationDate= providerPayRequest.providerData.getTerminationDate()

		gotoProviderPayRequest()

		setProviderName(Provider)

		String actualTerminationDate=this.getTerminationDate()

		AssertSteps.verifyActualResult(expectedTerminationDate.equals(actualTerminationDate), 'Termination Date is expected', 'Termination Date is not as expected', FailureHandling.STOP_ON_FAILURE)

	}

	public static void verifysingleRequestDate(String Provider,String RequestDate) {

		boolean blnValidContract=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData=getProviderContractData(Provider)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					for(String payElement:contractCostCenter.lstPayElements) {
						contractPayElement=contractCostCenter.HMContractPayElement.get(payElement)
						if(contractPayElement.PayElementType.equals('Variable')) {
							if(AssertSteps.verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
								blnValidContract=true
						}
					}
				}
			}
		}

		this.gotoProviderPayRequest()

		this.setProviderName(Provider)

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		selectRequestDate(RequestDate)

		getBaseSteps().clickEscape()

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		if(blnValidContract) {
			getBaseSteps().verifyWebElementNotDisplayed('lblValidation', pageName.ProviderPayRequest, 'Request Date validation message is not displayed', 'Request Date validation message is displayed', FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyLabelWithTextDisplayed('lblValidation', HIIConstants.PPR_NoContractSelectedServiceDate, pageName.ProviderPayRequest, 'Request Data with expected validation message is displayed', 'Request Data with expected validation message is not displayed', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void verifymultipleRequestDate(String Provider,List<String> RequestDates) {

		boolean blnValidContract=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData=getProviderContractData(Provider)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					for(String payElement:contractCostCenter.lstPayElements) {
						contractPayElement=contractCostCenter.HMContractPayElement.get(payElement)
						if(contractPayElement.PayElementType.equals('Variable')) {
							for(String RequestDate:RequestDates)
								if(AssertSteps.verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
									blnValidContract=true
						}
					}
				}
			}
		}

		this.gotoProviderPayRequest()

		this.setProviderName(Provider)

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		this.selectMultipleRequestDate(RequestDates)

		getBaseSteps().clickEscape()

		getBaseSteps().waitforLoadingComplete('imgLoading', 15,pageName.ProviderPayRequest)

		if(blnValidContract) {
			getBaseSteps().verifyWebElementNotDisplayed('lblValidation', pageName.ProviderPayRequest, 'Request Date validation message is not displayed', 'Request Date validation message is displayed', FailureHandling.STOP_ON_FAILURE)
		}else {
			getBaseSteps().verifyLabelWithTextDisplayed('lblValidation', HIIConstants.PPR_NoContractSelectedServiceDate, pageName.ProviderPayRequest, 'Request Data with expected validation message is displayed', 'Request Data with expected validation message is not displayed', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void verifyCompensationModel(String Provider,String RequestDate) {

		String sYear=RequestDate.split('/').getAt(2)

		List<String> expectedCompModel=new ArrayList<String>()

		HashMap<String,List<String>> expectedPayElement=new HashMap<String,List<String>>();
		ContractData contractData

		ContractCompModel contractCompModel

		ContractCostCenter contractCostCenter

		ContractPayElement contractPayElement

		ContractYear contractYear

		contractData = ProviderPayRequestSteps.getProviderContractData(Provider)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)

				for(String costCenter:contractCompModel.lstCostCenters) {
					List<String> lstPayElement=new ArrayList<String>()
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					if(contractCostCenter.CompModel.endsWith(sYear)) {
						expectedCompModel.add(contractCostCenter.CompModel)
						for(String payElement:contractCostCenter.lstPayElements) {
							contractPayElement = contractCostCenter.HMContractPayElement.get(payElement)
							if (contractPayElement.PayElementType.equals('Variable')) {
								lstPayElement.add(payElement.split('-').getAt(0) +'~ '+contractPayElement.StartDate+'-'+contractPayElement.EndDate)
							}
						}
						expectedPayElement.putAt(contractCostCenter.CompModel, lstPayElement)
					}
				}
			}

		}





		for(String CompModel:expectedCompModel)
		{

			for(String payElement:expectedPayElement.get(CompModel))
				println payElement

		}


		this.gotoProviderPayRequest()

		this.setProviderName(Provider)

		this.setRequestDate(RequestDate)


		List<String> lstCompModel=new ArrayList<String>()

		lstCompModel=getBaseSteps().getlistControlDropdowm('ddlCompModel', pageName.ProviderPayRequest)

		lstCompModel.remove('-Select Compensation-')

		for(String actualCompModel:lstCompModel) {


			AssertSteps.verifyActualResult(expectedCompModel.contains(actualCompModel), actualCompModel+': Compensation Model exist', actualCompModel+': Compensation Model does not exist', FailureHandling.CONTINUE_ON_FAILURE)

		}







	}

	public static void gotoProviderPayRequest_Provider() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayRequest', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		verifyFields_Provider()
	}

	//To verify Fields Displayed
	public static void verifyFields() {
		verifyProviderNameDisplayed()
		//verifyServiceStartDateDisplayed()
		verifyServiceEndDateDisplayed()
		verifyCompModelDisplayed()
		verifyPayElementDisplayed()
		verifyPayElementValueDisplayed()
		verifyPayElementReasonDisplayed()
	}

	public static void verifyFields_Provider() {
		verifyProviderNameDisplayed()
		//verifyServiceStartDateDisplayed()
		verifyServiceEndDateDisplayed()
		verifyPayElementDisplayed()
		verifyPayElementValueDisplayed()

	}

	//To select Request Date
	public static void selectRequestDatewithMasterDatadpndcy(String RequestDate) {

		String eStartEndDatesPS=GeneralSettingsSteps.getEnableStartandEndDatesforthePaymentsSetting()

		if(eStartEndDatesPS.equals(HIIConstants.Yes))
			getBaseSteps().selectDate('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
		else if(eStartEndDatesPS.equals(HIIConstants.No)) {
			getBaseSteps().chooseDate('txtRequestDate', RequestDate, pageName.ProviderPayRequest)
		}

		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
	}

	//To set Pay Request Note
	public static void setPayRequestNote(String PayRequestNote) {
		getBaseSteps().setTextToControl('txaPayRequestNote', PayRequestNote, pageName.ProviderPayRequest)
	}

	public static String getRequestDate() {
		return getBaseSteps().getValueFromControl(txtServiceEndDate, pageName.ProviderPayRequest)
	}

	public static String getCompensationModel() {
		return getBaseSteps().getselectedControlDropdowm(ddlCompModel, pageName.ProviderPayRequest)
	}

	public static String getPayElement() {
		return getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
	}

	public static void verifyDefaultCompensationModel(String expectedCompensationModel) {
		String defaultCompensationModel=getBaseSteps().getselectedControlDropdowm(ddlCompModel, pageName.ProviderPayRequest)
		AssertSteps.verifyActualResult(defaultCompensationModel.equals(expectedCompensationModel), 'Compensation Model default value is as expected', 'Compensation Model default value is not as expected', FailureHandling.CONTINUE_ON_FAILURE)
	}

	//To get list of expected Compensation Models list from dependencies screens
	public static List<String> getExpectedCompensationModels1(String Provider,String RequestDate){

		ContractData contractData
		ContractYear contractYear
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ArrayList<String> expectedCompModel=new ArrayList<String>()
		String sYear=RequestDate.split('/').getAt(2)

		//contractData = ProviderPayRequestSteps.getProviderContractData(Provider)
		contractData = ProviderPayRequestSteps.getProviderContractDataforYear(Provider, sYear)
		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					List<String> lstPayElement=new ArrayList<String>()
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					if(contractCostCenter.CompModel.endsWith(sYear)) {
						expectedCompModel.add(contractCostCenter.CompModel)
					}
				}
			}
		}
		return expectedCompModel
	}

	public static List<String> getExpectedPayElementsfromContract(String Provider,String RequestDate,String CompModel){




		ContractData contractData
		ContractYear contractYear
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		List<String> expectedPayElement=new ArrayList<String>()
		String cYear=RequestDate.split('/').getAt(2)

		contractData = ProviderPayRequestSteps.getProviderContractDataforYear(Provider, cYear)
		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					List<String> lstPayElement=new ArrayList<String>()
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					if(contractCostCenter.CompModel.endsWith(cYear)) {
						if(contractCostCenter.CompModel.equals(CompModel))
							for(String payElement:contractCostCenter.lstPayElements) {
								contractPayElement = contractCostCenter.HMContractPayElement.get(payElement)
								if (contractPayElement.PayElementType.equals('Variable')) {
									if(getBaseSteps().verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
										lstPayElement.add(payElement.split('-').getAt(0) +'~ '+contractPayElement.StartDate+'-'+contractPayElement.EndDate)
								}
							}
						expectedPayElement.addAll(lstPayElement)
					}
				}
			}
		}
		return expectedPayElement

	}

	public static List<String> getExpectedUniversalPayElements(String CompModel){

		String cModel = CompModel.split(' - ').getAt(0)
		String cc = CompModel.split(' - ').getAt(1)
		String Region = CostCenterPageSteps.getRegionforCostCenterName(cc.substring(0, cc.length() - 5))


		List<String> lstUPayElements=new ArrayList<String>()
		List<String> lstOCPayElements=new ArrayList<String>()
		List<String> lstfOCPayElements=new ArrayList<String>()
		List<String> lstRWPayElements=new ArrayList<String>()
		List<String> lstfPayElements=new ArrayList<String>()

		PayElementsSteps.openPayElements_newTab()
		PayElementsSteps.selectPayElementType('Variable')
		PayElementsSteps.selectLastPageSize()
		lstUPayElements=PayElementsSteps.getUniversalPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		OrgCompModelsPayElementsSteps.openOrgCompModelsPayElements_newTab()
		OrgCompModelsPayElementsSteps.selectRegion(Region)
		OrgCompModelsPayElementsSteps.selectCompensationModel(cModel)
		OrgCompModelsPayElementsSteps.clickShowDetails()
		OrgCompModelsPayElementsSteps.clickExpandAll()
		lstOCPayElements=OrgCompModelsPayElementsSteps.getCheckedPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		for(String fOCPayElement:lstOCPayElements) {
			if(lstUPayElements.contains(fOCPayElement)) {
				lstfOCPayElements.add(fOCPayElement)
			}
		}

		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		RoleUserWisePayElementsSteps.openRoleUserWisePayElements_newTab()
		RoleUserWisePayElementsSteps.clickRoleWisePayElements()
		RoleUserWisePayElementsSteps.selectRoleAsCompensationAdministrator()
		RoleUserWisePayElementsSteps.selectRegion(Region)
		RoleUserWisePayElementsSteps.selectCompensationModel(cModel)
		RoleUserWisePayElementsSteps.clickExpandAll()
		lstRWPayElements=RoleUserWisePayElementsSteps.getCheckedPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		for(String fPayElement:lstRWPayElements) {
			if(lstfOCPayElements.contains(fPayElement)) {
				lstfPayElements.add(fPayElement)
			}
		}

		return lstfPayElements




	}

	//To get Provider Name Validity
	public static boolean getProviderNameValidity(String Provider) {

		boolean blnProvider=false
		ProviderData providerData
		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		providerData=ProviderSetupSteps.getProviderData(Provider)
		if(!providerData.employeeStatus.equals(HIIConstants.ES_OnboardingInProgress)) {
			contractData = ManageProviderContractSteps.getContractDetailsMarkCompleted(Provider)
			for(String currentYear:contractData.CurrentYear)
			{
				contractYear=contractData.HMContractYear.get(currentYear)
				for(String compModel:contractYear.lstCompModel) {
					contractCompModel=contractYear.HMContractCompModel.get(compModel)
					if(contractCompModel.ContractStatus.equals('Checked'))
						blnProvider=true
				}
			}
		}
		return blnProvider
	}

	//To get multiple Request Date validity
	public static boolean getMultipleRequestDateValidity(String Provider,List<String> RequestDates) {

		boolean blnValidRequestDate=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData=getProviderContractData(Provider)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				for(String costCenter:contractCompModel.lstCostCenters) {
					contractCostCenter=contractCompModel.HMContractCostCenter.get(costCenter)
					for(String payElement:contractCostCenter.lstPayElements) {
						contractPayElement=contractCostCenter.HMContractPayElement.get(payElement)
						if(contractPayElement.PayElementType.equals('Variable')) {
							for(String RequestDate:RequestDates)
								if(AssertSteps.verifyDateInbetween(contractPayElement.StartDate, contractPayElement.EndDate, RequestDate))
									blnValidRequestDate=true
						}
					}
				}
			}
		}
		return blnValidRequestDate
	}


	public static List<String> getUniversalPayElements(String Region,String CompModel) {

		List<String> lstUPayElements=new ArrayList<String>()
		List<String> lstOCPayElements=new ArrayList<String>()
		List<String> lstfPayElements=new ArrayList<String>()

		PayElementsSteps.openPayElements_newTab()
		PayElementsSteps.selectPayElementType('Variable')
		PayElementsSteps.selectLastPageSize()
		lstUPayElements=PayElementsSteps.getUniversalPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		OrgCompModelsPayElementsSteps.openOrgCompModelsPayElements_newTab()
		OrgCompModelsPayElementsSteps.selectRegion(Region)
		OrgCompModelsPayElementsSteps.selectCompensationModel(CompModel)
		OrgCompModelsPayElementsSteps.clickShowDetails()
		OrgCompModelsPayElementsSteps.clickExpandAll()
		lstOCPayElements=OrgCompModelsPayElementsSteps.getCheckedPayElements()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		for(String fPayElements:lstOCPayElements) {
			if(lstUPayElements.contains(fPayElements)) {
				lstfPayElements.add(fPayElements)
			}
		}

		return lstfPayElements




	}

	public static void saveProviderPayRequest() {

		String strProviderName,strRequestDate,strPayElement,strAmount,actualSummary

		strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
		strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)
		if(strRequestDate!="")
			strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
		strAmount=getBaseSteps().getValueFromControl(this.txtPayElementValue, pageName.ProviderPayRequest)

		getBaseSteps().clickToControl(btnSave, pageName.ProviderPayRequest)

		if(getBaseSteps().WebElementDisplayed(smryValidation, pageName.ProviderPayRequest))
		{
			actualSummary=getBaseSteps().getTextFromControl(smryValidation, pageName.ProviderPayRequest)
			if(strProviderName=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Provider Name.'),  'Validation Summary contains Provider Name to be entered', 'Validation Summary does not contains Provider Name to be entered', FailureHandling.CONTINUE_ON_FAILURE)
			if(strRequestDate=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Select Service End Date.'),  'Validation Summary contains Request Date to be entered', 'Validation Summary does not contains Request Date to be entered', FailureHandling.CONTINUE_ON_FAILURE)
			else {
				if(strPayElement.equals('-Select Pay Element-'))
					AssertSteps.verifyActualResult(actualSummary.contains('Please Select Pay Element'),  'Validation Summary contains Pay Element to be selected', 'Validation Summary does not contains Pay Element to be selected', FailureHandling.CONTINUE_ON_FAILURE)
			}
			if(strAmount=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Amount/Units.'), 'Validation Summary contains Amount/Units to be entered', 'Validation Summary does not contains Amount/Units to be entered', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static String getValidationSummary() {
		if(getBaseSteps().WebElementDisplayed(smryValidation, pageName.ProviderPayRequest))
			return getBaseSteps().getTextFromControl(smryValidation, pageName.ProviderPayRequest)
	}

	public static void verifyValidationSummary(String expectedSummary) {

		println expectedSummary

		String actualSummary=getValidationSummary()

		println actualSummary
		AssertSteps.verifyActualResult(actualSummary.contains(expectedSummary), 'Validation Summary is as expected', 'Validation Summary message is not as expected', FailureHandling.STOP_ON_FAILURE)


	}

	public static void verifyValidationSummary() {

		String actualSummary
		actualSummary=getValidationSummary()

		String strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
		String strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)
		String strAmount


		if(strProviderName=="")
			AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Provider Name.'),  'Validation Summary contains Provider Name to be entered', 'Validation Summary does not contains Provider Name to be entered', FailureHandling.CONTINUE_ON_FAILURE)

		if(strRequestDate=="")
			AssertSteps.verifyActualResult(actualSummary.contains('Please Select Service End Date.'),  'Validation Summary contains Request Date to be entered', 'Validation Summary does not contains Request Date to be entered', FailureHandling.CONTINUE_ON_FAILURE)
		else {

			String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
			if(strPayElement.equals('-Select Pay Element-'))
			{
				AssertSteps.verifyActualResult(actualSummary.contains('Please Select Pay Element'),  'Validation Summary contains Pay Element to be selected', 'Validation Summary does not contains Pay Element to be selected', FailureHandling.CONTINUE_ON_FAILURE)
			}
		}

		if(strAmount=="")
			AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Amount/Units.'), 'Validation Summary contains Amount/Units to be entered', 'Validation Summary does not contains Amount/Units to be entered', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifySuccessMessage(String expectedSuccess) {

		if(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayRequest)) {
			String successMsg
			successMsg=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)

			println expectedSuccess
			println successMsg

			AssertSteps.verifyActualResult(successMsg.equals(expectedSuccess), 'Provider Pay Request created successfully with message: '+successMsg, 'Provider Pay Request creation failed with message:'+successMsg, FailureHandling.STOP_ON_FAILURE)
		}else {


			String actualSummary
			actualSummary=getValidationSummary()

			String strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
			String strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)
			String strAmount


			if(strProviderName=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Provider Name.'),  'Validation Summary contains Provider Name to be entered', 'Validation Summary does not contains Provider Name to be entered', FailureHandling.CONTINUE_ON_FAILURE)

			if(strRequestDate=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Select Service End Date.'),  'Validation Summary contains Request Date to be entered', 'Validation Summary does not contains Request Date to be entered', FailureHandling.CONTINUE_ON_FAILURE)
			else {

				String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
				if(strPayElement.equals('-Select Pay Element-'))
				{
					AssertSteps.verifyActualResult(actualSummary.contains('Please Select Pay Element'),  'Validation Summary contains Pay Element to be selected', 'Validation Summary does not contains Pay Element to be selected', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}

			if(strAmount=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Amount/Units.'), 'Validation Summary contains Amount/Units to be entered', 'Validation Summary does not contains Amount/Units to be entered', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static String getExpectedValidationSummary() {
		String expectedSummary=""
		String strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
		String strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)

		println strProviderName
		println strRequestDate
		if(strProviderName=="")
			expectedSummary='Please Enter Provider Name.'
		if(strRequestDate=="")
			if(expectedSummary!="")
				expectedSummary='\n'+ 'Please Select Service End Date.'
			else if(expectedSummary=="")
				expectedSummary='Please Select Service End Date.'

		return 	expectedSummary
	}

	public static void enterProviderPayRequestDetails(String ProviderName,String ServiceStartDate="",String RequestDate,String CompensationModel,String PayElement,String Amount,String Reason,String GLAccount) {
	}

	public static ProviderDetails getProviderPayRequestDetails() {

		ProviderDetails provider=new ProviderDetails()
		ProviderPayRequest providerPayRequest=new ProviderPayRequest()

		HashMap<Integer,ProviderPayRequest> hmPayRequest=new HashMap<Integer,ProviderPayRequest>()

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				hmPayRequest.put(i, getProviderPayRequestGridDetails(i))
			}
			provider.PayRequestDetails=hmPayRequest
		}

		return provider

	}

	public static ProviderPayRequest getProviderPayRequestGridDetails(Integer rowIndex) {

		ProviderPayRequest providerPayRequest=new ProviderPayRequest()

		providerPayRequest.ServiceStartDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (rowIndex+1).toString(), 'Service Start Date', pageName.ProviderPayRequest)
		providerPayRequest.ServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (rowIndex+1).toString(), 'Service Date', pageName.ProviderPayRequest)
		providerPayRequest.PayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (rowIndex+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
		providerPayRequest.PayElementValue=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (rowIndex+1).toString(), '$ Amount', pageName.ProviderPayRequest)
		providerPayRequest.Status=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (rowIndex+1).toString(), 'Status', pageName.ProviderPayRequest)

		return providerPayRequest

	}

	public static void deleteProviderPayRequest(String RequestDate) {

		String ServiceDate,alertMSG,confirmationMSG
		boolean blnRequestDate=false
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {
				ServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				if(ServiceDate.equals(RequestDate)) {
					blnRequestDate=true

					getBaseSteps().clickToCellTableImage(grdPhysicianPayRequest, (i+1).toString(), 'Delete', pageName.ProviderPayRequest)
					//AssertSteps.verifyActualResult(WebUI.verifyAlertPresent(10), 'Pay Request deletion confirmation alert is displayed', 'Pay Request deletion confirmation alert is not displayed', FailureHandling.STOP_ON_FAILURE)
					if(WebUI.verifyAlertPresent(10)) {
						alertMSG=WebUI.getAlertText()
						//
						WebUI.acceptAlert()
						AssertSteps.verifyActualResult(alertMSG.equals('Are you sure, do you want to delete the selected record?'), 'Expected Alert message displayed', 'Expected Alert message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(this.msgSuccess, pageName.ProviderPayRequest), 'Success Message displayed', 'Success Message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						confirmationMSG=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)
						AssertSteps.verifyActualResult(confirmationMSG.equals('Deleted Record(s) Successfully.'), 'Delete Confirmation message displayed', 'Delete Confirmation message not displayed', FailureHandling.CONTINUE_ON_FAILURE)
						break
					}



				}
			}

			AssertSteps.verifyActualResult(blnRequestDate, 'Pay Request exist for Service Date:'+RequestDate, 'Pay Request does not exist for test data: Service Date: '+RequestDate, FailureHandling.STOP_ON_FAILURE)


		}



	}

	public static void PayRequestGridFunctionalities() {

		ProviderDetails provider=new ProviderDetails()

		provider=getProviderPayRequestDetails()

		println provider.PayRequestDetails.size()
		for(int i=1;i<=provider.PayRequestDetails.size();i++)
			for(ProviderPayRequest providerPayRequest:provider.PayRequestDetails.get(i))
		{
			println providerPayRequest.ServiceStartDate
			println providerPayRequest.ServiceDate
			println providerPayRequest.PayElement
			println providerPayRequest.PayElementValue
			println providerPayRequest.Status
		}
	}

	public static void verifyMaxPayRequestBackgroundColor(String tdRequestDate,String tdCompModel,String tdPayElement,String tdPayElementValue) {
		boolean blnPayRequest=false
		String bcPayElementValue
		String grdServiceDate,grdCompModel,grdPayElement,grdAmount
		String CompModel=tdCompModel.split(' - ')[0]
		String PayElement=tdPayElement.split(' ~ ')[0]

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {
			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)
			bcPayElementValue=getBaseSteps().getCellTableTextBackgroundColor(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			if(tdRequestDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement) && Double.parseDouble(tdPayElementValue).equals(Double.parseDouble(grdAmount)))
			{
				AssertSteps.verifyActualResult(bcPayElementValue.equals('yellow'), 'Max Threshold limit PayElement Background Color is expected', 'Max Threshold limit PayElement Background Color is not expected', FailureHandling.CONTINUE_ON_FAILURE)

				break
			}


		}
	}

	public static String getPayRequestYTD(String tdRequestDate,String  tdCompModel,String tdPayElement) {

		String grdServiceDate,grdCompModel,grdPayElement,grdAmount,grdYear

		String Year=tdRequestDate.split('/')[2]
		String CompModel=tdCompModel.split(' - ')[0]
		String PayElement=tdPayElement.split(' ~ ')[0]

		Float YTD=0


		try {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}catch(Exception e) {

		}
		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {

			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			grdYear=grdServiceDate.split('/')[2]
			if(Year.equals(grdYear) && CompModel.equals(grdCompModel) && PayElement.equals(grdPayElement))
				YTD=YTD+Float.parseFloat(grdAmount)

		}

		DecimalFormat df=new DecimalFormat('0.00')
		return (df.format(YTD))

	}

	public static HashMap<String,String> getGridYTDAmount(String ProviderName,String CompensationModel,String PayElement,String ServiceDate) {

		String grdCompModel,grdPayElement,grdServiceDate,grdYTDAmount,grdStatus
		String YTDAmount
		HashMap<String,String> PayRequestDetails=new HashMap<String,String>()
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {

				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdYTDAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'YTD Amount', pageName.ProviderPayRequest)
				grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Status', pageName.ProviderPayRequest)
				if(grdCompModel.equals(CompensationModel) && grdPayElement.equals(PayElement) && grdServiceDate.equals(ServiceDate))
				{
					PayRequestDetails.put('Status', grdStatus)
					YTDAmount=(grdYTDAmount.replace('$', '')).replace(',', '')
					PayRequestDetails.put('YTDAmount', YTDAmount)
					break
				}
			}
		}
		return PayRequestDetails

	}


	public static HashMap<String,String> getGridGLAccNoHIICCID(String ProviderName,String PayElement,String CostCenter){
		String grdCostCenter,grdPayElement,grdGLAccNo,grdHIICCID,grdStatus
		String YTDAmount
		HashMap<String,String> PayRequestDetails=new HashMap<String,String>()
		PayRequestDetails.put('GLAccNo', '')
		PayRequestDetails.put('HIICCID', '')
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
			for(int i=1;i<Integer.parseInt(noofRequests);i++) {

				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdCostCenter=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Cost Center ID', pageName.ProviderPayRequest)
				grdGLAccNo=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'GL Account', pageName.ProviderPayRequest)
				grdHIICCID=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Location_Cost Center', pageName.ProviderPayRequest)
				if(grdPayElement.equals(PayElement) && grdCostCenter.endsWith(CostCenter))
				{
					PayRequestDetails.put('GLAccNo', grdGLAccNo)
					PayRequestDetails.put('HIICCID', grdHIICCID)
					break
				}
			}
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return PayRequestDetails

	}

	public static void verifyPayRequestYTD(String expectedYTD) {
		String actualYTD
		if(getBaseSteps().WebElementDisplayed(lblYTDAmount, pageName.ProviderPayRequest))
			actualYTD=getBaseSteps().getTextFromControl(this.lblYTDAmount, pageName.ProviderPayRequest)
		AssertSteps.verifyActualResult(actualYTD.equals('$'+expectedYTD), 'YTD is as expected', 'YTD is not as expected', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static Double getYTDAmount() {

		String YTDAmount=getBaseSteps().getTextFromControl(lblYTDAmount, pageName.ProviderPayRequest)

		return Double.parseDouble(YTDAmount.replace('$', ''))
	}

	public static Double getAmount() {

		String Amount=getBaseSteps().getValueFromControl(txtPayElementValue, pageName.ProviderPayRequest)

		return Double.parseDouble(Amount)
	}

	public static Double getThresholdAmount() {

		if(verifyThresholdAmountDisplayed())
		{
			String ThresholdAmount= getBaseSteps().getTextFromControl(this.lblThresholdAmount, pageName.ProviderPayRequest)
			return Double.parseDouble(ThresholdAmount.replace('$', ''))
		}

	}

	public static boolean verifyThresholdAmountDisplayed() {
		return getBaseSteps().WebElementDisplayed(lblThresholdAmount, pageName.ProviderPayRequest)
	}

	public static void verifyThresholdAmount(String expectedThresholdAmount) {
		AssertSteps.verifyActualResult(getThresholdAmount().equals(expectedThresholdAmount), 'Threshold Amount is as expected', 'Threshold Amount is not as expected', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static String getProviderName() {
		return getBaseSteps().getValueFromControl(txtProviderName, pageName.ProviderPayRequest)
	}

	public static void savePayRequest_reachingMaxThresholdContinue(String RequestDate,String CompensationModel,String PayElement,String PayElementValue,String expSuccessMSG='',String expErrorMSG='') {
		Double PayElementAmount,ThresholdAmount

		PayElementAmount=getYTDAmount()+getAmount()

		if(getBaseSteps().WebElementDisplayed(lblThresholdAmount, pageName.ProviderPayRequest))
		{
			ThresholdAmount=getThresholdAmount()

			if(PayElementAmount>ThresholdAmount)

			{
				clickSave()
				AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(this.pnlMaxThresholdPopUp, pageName.ProviderPayRequest), 'Max Threshold limit Pop Up displayed', 'Max Threshold limit Confirmation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
				getBaseSteps().clickToControl(this.pnlbtnContinue, pageName.ProviderPayRequest)

				verifyProviderPayRequestCreation_maxThresholdLimitation(RequestDate,CompensationModel,PayElement,PayElementValue,expSuccessMSG,expErrorMSG)



			}
		}
	}

	public static void verifyProviderPayRequestCreation_maxThresholdLimitation(String RequestDate,String CompensationModel,String PayElement,String PayElementValue,String expSuccessMSG='',String expErrorMSG='') {
		if(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayRequest)) {
			String successMsg
			successMsg=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)
			AssertSteps.verifyActualResult(successMsg.equals(expSuccessMSG), 'Provider Pay Request created successfully with message: '+successMsg, 'Provider Pay Request creation failed with message:'+successMsg, FailureHandling.STOP_ON_FAILURE)
			verifyMaxPayRequestBackgroundColor(RequestDate,CompensationModel,PayElement,PayElementValue)
		}else if(getBaseSteps().WebElementDisplayed(msgError, pageName.ProviderPayRequest)) {
			String ErrorMsg
			ErrorMsg=getBaseSteps().getTextFromControl(msgError, pageName.ProviderPayRequest)
			AssertSteps.verifyActualResult(ErrorMsg.equals(expErrorMSG), 'Provider Pay Request created failed with expected Error message: '+ErrorMsg, 'Provider Pay Request creation failed with unexpected Error message:'+ErrorMsg, FailureHandling.STOP_ON_FAILURE)
		}else if(getBaseSteps().WebElementDisplayed(smryValidation, pageName.ProviderPayRequest)) {
			String actualSummary
			actualSummary=getValidationSummary()

			String strProviderName=getBaseSteps().getValueFromControl(this.txtProviderName, pageName.ProviderPayRequest)
			String strRequestDate=getBaseSteps().getValueFromControl(this.txtServiceEndDate, pageName.ProviderPayRequest)
			String strAmount=getBaseSteps().getValueFromControl(this.txtPayElementValue, pageName.ProviderPayRequest)


			if(strProviderName=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Provider Name.'),  'Validation Summary contains Provider Name to be entered', 'Validation Summary does not contains Provider Name to be entered', FailureHandling.CONTINUE_ON_FAILURE)

			if(strRequestDate=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Select Service End Date.'),  'Validation Summary contains Request Date to be entered', 'Validation Summary does not contains Request Date to be entered', FailureHandling.CONTINUE_ON_FAILURE)
			else {

				String strPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)
				if(strPayElement.equals('-Select Pay Element-'))
				{
					AssertSteps.verifyActualResult(actualSummary.contains('Please Select Pay Element'),  'Validation Summary contains Pay Element to be selected', 'Validation Summary does not contains Pay Element to be selected', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}

			if(strAmount=="")
				AssertSteps.verifyActualResult(actualSummary.contains('Please Enter Amount/Units.'), 'Validation Summary contains Amount/Units to be entered', 'Validation Summary does not contains Amount/Units to be entered', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void savePayRequest_reachingMaxThresholdCancel() {
		Double PayElementAmount,ThresholdAmount

		PayElementAmount=getYTDAmount()+getAmount()

		if(getBaseSteps().WebElementDisplayed(lblThresholdAmount, pageName.ProviderPayRequest))
		{
			ThresholdAmount=getThresholdAmount()

			if(PayElementAmount>ThresholdAmount)

			{
				clickSave()
				AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(this.pnlMaxThresholdPopUp, pageName.ProviderPayRequest), 'Max Threshold limit Pop Up displayed', 'Max Threshold limit Confirmation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
				getBaseSteps().clickToControl(this.pnlbtnCancel, pageName.ProviderPayRequest)

			}
		}
	}

	public static Object getPayElementAmountfromGrid() {

		String RequestDate,CompensationModel,PayElement
		String grdServiceDate,grdCompModel,grdPayElement,grdAmount

		RequestDate=this.getRequestDate()
		CompensationModel=this.getCompensationModel()
		PayElement=this.getPayElement()

		String CompModel=CompensationModel.split(' - ')[0]
		String sPayElement=PayElement.split(' ~ ')[0]


		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {
			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)


			if(RequestDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && sPayElement.equals(grdPayElement))
			{
				grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

				break
			}
		}
		return grdAmount
	}

	public static String getPayElementAmountBackgroundColor() {

		String RequestDate,CompensationModel,PayElement
		String grdServiceDate,grdCompModel,grdPayElement,bcPayElementValue

		RequestDate=this.getRequestDate()
		CompensationModel=this.getCompensationModel()
		PayElement=this.getPayElement()

		String CompModel=CompensationModel.split(' - ')[0]
		String sPayElement=PayElement.split(' ~ ')[0]


		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {
			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)


			if(RequestDate.equals(grdServiceDate) && CompModel.equals(grdCompModel) && sPayElement.equals(grdPayElement))
			{
				bcPayElementValue=getBaseSteps().getCellTableTextBackgroundColor(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)
				break
			}
		}
		return bcPayElementValue
	}

	public static void verifyExceededPayElementThresholdBackgroundColor() {

		def sCompensationModel=getBaseSteps().getselectedControlDropdowm(ddlCompModel, pageName.ProviderPayRequest)
		def sPayElement=getBaseSteps().getselectedControlDropdowm(ddlPayElement, pageName.ProviderPayRequest)

		if(getBaseSteps().WebElementDisplayed(this.lblThresholdAmount, pageName.ProviderPayRequest))
		{
			def dThresholdAmount=getThresholdAmount()
			def fCompensationModel=sCompensationModel.split(' - ')[0]
			def fPayElement=sPayElement.split(' ~ ')[0]
			String grdServiceDate,grdCompModel,grdPayElement,grdsYTDAmount,bcPayElementValue
			Double grddYTDAmount

			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

			String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)

			for(int i=1;i<Integer.parseInt(noofRequests);i++) {

				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Pay Element', pageName.ProviderPayRequest)
				grdsYTDAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'YTD Amount', pageName.ProviderPayRequest)
				grddYTDAmount=Double.parseDouble((grdsYTDAmount.replace('$', '')).replace(',', ''))
				bcPayElementValue=getBaseSteps().getCellTableTextBackgroundColor(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)
				if(grddYTDAmount>dThresholdAmount) {
					AssertSteps.verifyActualResult(bcPayElementValue.equals('yellow'), 'Exceeded Threshold limit PayElements Background Color is yellow', 'Exceeded Threshold limit PayElement Background Color is not expected', FailureHandling.CONTINUE_ON_FAILURE)
				}else {
					AssertSteps.verifyActualResult(bcPayElementValue.equals(''), 'No Background Color of PayElements for not exceeded Threshold', 'Background Color of PayElements for not exceeded Threshold', FailureHandling.CONTINUE_ON_FAILURE)
				}

			}
		}
	}

	public static String getMasterContractMaxCompensation(String Provider,String RequestDate,String CompModel,String MaxCompensationDuration){

		ContractData contractData
		ContractYear contractYear
		ContractCompModel contractCompModel
		String cYear=RequestDate.split('/').getAt(2)
		String ContractMaxCompensation
		DecimalFormat df=new DecimalFormat('0.00')
		contractData = ManageProviderContractSteps.getContractDetailsforYear(Provider, cYear)

		for(String currentYear:contractData.CurrentYear) {
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel= contractYear.HMContractCompModel.get(compModel)
				if((contractCompModel.ContractMaxCompensationDuration).equals(MaxCompensationDuration))
				{
					ContractMaxCompensation=contractCompModel.ContractMaxCompensation
					return (df.format(Float.parseFloat(ContractMaxCompensation.replace(',', ''))))
				}
			}
		}





	}

	public static Double getCompensationForCompensationModel(String Provider,String CompensationModel,String RequestDate) {
		Double Compensation=0
		String grdCompModel,grdServiceDate,grdAmount
		openProviderPayRequest_newTab()
		setProviderName(Provider)
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			Double noofRequests=Double.parseDouble(getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest))
			println noofRequests
			int i=2
			while(i<=noofRequests) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
				grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Comp Model', pageName.ProviderPayRequest)
				grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), '$ Amount', pageName.ProviderPayRequest)
				if(DateTimeUtil.verifyChecktDateTillCompareDate(RequestDate, grdServiceDate) && grdCompModel.equals(CompensationModel)) {
					Compensation=Compensation+Double.parseDouble(grdAmount.replace(',', ''))
					println Compensation
				}
				i++
			}
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return Compensation
	}

	public static void savePayRequest_ContinueExceedingMaxCompensation_WithintheContract(String RequestDate,String CompensationModel,String Amount,Object MaxCompensation) {



		String grdServiceDate,grdCompModel,grdAmount,grdYear
		Double Compensation=0

		String Year=RequestDate.split('/')[2]
		String CompModel=CompensationModel.split(' - ')[0]


		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {

			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			grdYear=grdServiceDate.split('/')[2]


			if(Year.equals(grdYear) && CompModel.equals(grdCompModel))
				Compensation=Compensation+Double.parseDouble(grdAmount)

		}

		Double NewCompensation=Compensation+Double.parseDouble(Amount)

		String sProviderName=getProviderName()
		String sRequestDate=getRequestDate()
		String sCompModel=getCompensationModel()
		String sPayElement=getPayElement()



		if(NewCompensation>Double.parseDouble(MaxCompensation)) {
			String expectedCompModelLimitPopUP=HIIConstants.PPR_MaxCompLimitPopUpMessage(sPayElement, sProviderName, Math.abs(NewCompensation-Double.parseDouble(MaxCompensation)))
			String actualCompModelLimitPopUP
			clickSave()
			AssertSteps.verifyActualResult(MaxThresholdPopUpDisplayed(), 'Max Compensation Pop Up displayed', 'Max Compensation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
			actualCompModelLimitPopUP=getPopUpInformation()
			AssertSteps.verifyActualResult(actualCompModelLimitPopUP.equals(expectedCompModelLimitPopUP), 'Max Comp Model Limit Information is as expected', 'Max Comp Model Limit Information is not as expected \n Expected:'+expectedCompModelLimitPopUP+' \n Actual: '+actualCompModelLimitPopUP, FailureHandling.STOP_ON_FAILURE)
			continuePopUp()
			/*verifyPayRequestCreationSuccessMessage(sRequestDate,sPayElement)
			 if(this.verifyThresholdAmountDisplayed())
			 {
			 //Double ThresholdAmount=this.getThresholdAmount()
			 verifyMaxPayRequestBackgroundColor(sRequestDate, sCompModel, sPayElement, Amount)
			 }
			 AssertSteps.verifyActualResult(verifyProviderPayRequestExists(sRequestDate, sCompModel, sPayElement), 'Pay Request Created ', 'Pay Request not created', FailureHandling.STOP_ON_FAILURE)*/
		}
	}

	public static void savePayRequest_ContinueExceedingMaxCompensation_AcrossMasterContracts(String RequestDate,Object Amount,Object MaxCompensation) {
		String grdServiceDate,grdCompModel,grdAmount,grdYear
		Double Compensation=0

		String Year=RequestDate.split('/')[2]

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {

			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			grdYear=grdServiceDate.split('/')[2]


			if(Double.parseDouble(grdYear)<=Double.parseDouble(Year))
				Compensation=Compensation+Double.parseDouble(grdAmount)

		}

		Double NewCompensation=Compensation+Double.parseDouble(Amount)

		String sProviderName=getProviderName()
		String sRequestDate=getRequestDate()
		String sCompModel=getCompensationModel()
		String sPayElement=getPayElement()

		if(NewCompensation>Double.parseDouble(MaxCompensation)) {
			String expectedCompModelLimitPopUP=HIIConstants.PPR_MaxCompLimitPopUpMessage(getPayElement(), getProviderName(), Math.abs(NewCompensation-Double.parseDouble(MaxCompensation)))
			String actualCompModelLimitPopUP
			clickSave()
			AssertSteps.verifyActualResult(MaxThresholdPopUpDisplayed(), 'Max Compensation Pop Up displayed', 'Max Compensation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
			actualCompModelLimitPopUP=getPopUpInformation()
			AssertSteps.verifyActualResult(actualCompModelLimitPopUP.equals(expectedCompModelLimitPopUP), 'Max Comp Model Limit Information is as expected', 'Max Comp Model Limit Information is not as expected \n Expected:'+expectedCompModelLimitPopUP+' \n Actual: '+actualCompModelLimitPopUP, FailureHandling.STOP_ON_FAILURE)
			continuePopUp()
			/*verifyPayRequestCreationSuccessMessage(sRequestDate,sPayElement)
			 if(this.verifyThresholdAmountDisplayed())
			 verifyMaxPayRequestBackgroundColor(sRequestDate, sCompModel, sPayElement, Amount)
			 AssertSteps.verifyActualResult(verifyProviderPayRequestExists(sRequestDate, sCompModel, sPayElement), 'Pay Request Created ', 'Pay Request not created', FailureHandling.STOP_ON_FAILURE)*/
		}
	}

	public static void savePayRequest_CancelExceedingMaxCompensation_WithintheContract(String RequestDate,String CompensationModel,String Amount,Object MaxCompensation) {


		String grdServiceDate,grdCompModel,grdAmount,grdYear
		Double Compensation=0

		String Year=RequestDate.split('/')[2]
		String CompModel=CompensationModel.split(' - ')[0]

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {

			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdCompModel=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Comp Model', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			grdYear=grdServiceDate.split('/')[2]


			if(Year.equals(grdYear) && CompModel.equals(grdCompModel))
				Compensation=Compensation+Double.parseDouble(grdAmount)

		}

		Double NewCompensation=Compensation+Double.parseDouble(Amount)

		String sProviderName=getProviderName()
		String sRequestDate=getRequestDate()
		String sCompModel=getCompensationModel()
		String sPayElement=getPayElement()



		if(NewCompensation>Double.parseDouble(MaxCompensation)) {
			String expectedCompModelLimitPopUP=HIIConstants.PPR_MaxCompLimitPopUpMessage(sPayElement, sProviderName, Math.abs(NewCompensation-Double.parseDouble(MaxCompensation)))
			String actualCompModelLimitPopUP
			clickSave()
			AssertSteps.verifyActualResult(MaxThresholdPopUpDisplayed(), 'Max Compensation Pop Up displayed', 'Max Compensation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
			actualCompModelLimitPopUP=getPopUpInformation()
			AssertSteps.verifyActualResult(actualCompModelLimitPopUP.equals(expectedCompModelLimitPopUP), 'Max Comp Model Limit Information is as expected', 'Max Comp Model Limit Information is not as expected \n Expected:'+expectedCompModelLimitPopUP+' \n Actual: '+actualCompModelLimitPopUP, FailureHandling.STOP_ON_FAILURE)
			cancelPopUp()
			AssertSteps.verifyActualResult(!verifyProviderPayRequestExists(sRequestDate, sCompModel, sPayElement), 'Pay Request not Created', 'Pay Request created', FailureHandling.STOP_ON_FAILURE)
		}

	}

	public static void savePayRequest_CancelExceedingMaxCompensation_AcrossMasterContracts(String RequestDate,Object Amount,Object MaxCompensation) {
		String grdServiceDate,grdCompModel,grdAmount,grdYear
		Double Compensation=0

		String Year=RequestDate.split('/')[2]

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		String noofRequests=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayRequest)
		for(int i=1;i<Integer.parseInt(noofRequests);i++) {

			grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), 'Service Date', pageName.ProviderPayRequest)
			grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, (i+1).toString(), '$ Amount', pageName.ProviderPayRequest)

			grdYear=grdServiceDate.split('/')[2]


			if(Double.parseDouble(grdYear)<=Double.parseDouble(Year))
				Compensation=Compensation+Double.parseDouble(grdAmount)

		}

		Double NewCompensation=Compensation+Double.parseDouble(Amount)

		String sProviderName=getProviderName()
		String sRequestDate=getRequestDate()
		String sCompModel=getCompensationModel()
		String sPayElement=getPayElement()

		if(NewCompensation>Double.parseDouble(MaxCompensation)) {
			String expectedCompModelLimitPopUP=HIIConstants.PPR_MaxCompLimitPopUpMessage(sPayElement, sProviderName, Math.abs(NewCompensation-Double.parseDouble(MaxCompensation)))
			String actualCompModelLimitPopUP
			clickSave()
			AssertSteps.verifyActualResult(MaxThresholdPopUpDisplayed(), 'Max Compensation Pop Up displayed', 'Max Compensation Pop Up Should display', FailureHandling.STOP_ON_FAILURE)
			actualCompModelLimitPopUP=getPopUpInformation()
			AssertSteps.verifyActualResult(actualCompModelLimitPopUP.equals(expectedCompModelLimitPopUP), 'Max Comp Model Limit Information is as expected', 'Max Comp Model Limit Information is not as expected \n Expected:'+expectedCompModelLimitPopUP+' \n Actual: '+actualCompModelLimitPopUP, FailureHandling.STOP_ON_FAILURE)
			cancelPopUp()
			AssertSteps.verifyActualResult(!verifyProviderPayRequestExists(sRequestDate, sCompModel, sPayElement), 'Pay Request not Created', 'Pay Request created', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static boolean MaxThresholdPopUpDisplayed() {
		return getBaseSteps().WebElementDisplayed(this.pnlMaxThresholdPopUp, pageName.ProviderPayRequest)
	}

	public static String getPopUpInformation() {
		if(MaxThresholdPopUpDisplayed())
			return getBaseSteps().getTextFromControl(pnllblPopUpInfo, pageName.ProviderPayRequest)
	}

	public static void cancelPopUp() {
		if(MaxThresholdPopUpDisplayed()) {
			getBaseSteps().clickToControl(pnlbtnCancel, pageName.ProviderPayRequest)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}
	}

	public static void continuePopUp() {
		if(MaxThresholdPopUpDisplayed()) {
			getBaseSteps().clickToControl(pnlbtnContinue, pageName.ProviderPayRequest)
		}
	}

	public static String getSuccessMessage() {
		if(SuccessMessageDisplayed())
			return getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayRequest)
	}

	public static boolean SuccessMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayRequest)
	}

	public static String getErrorMessage() {
		if(ErrorMessageDisplayed())
			return getBaseSteps().getTextFromControl(msgError, pageName.ProviderPayRequest)
	}

	public static boolean ErrorMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(msgError, pageName.ProviderPayRequest)
	}

	public static void gotoPayRequestImport() {
		getBaseSteps().clickToControl('tabPayRequestImport', pageName.ProviderPayRequest)
	}


	public static void createProviderRequestwithCurrentDate(String ProviderName,String RequestDate='',String CompensationModel='',String PayElement,String PayElementValue) {

		String expectedErrorMSG,expectedSuccessMSG

		if(RequestDate=='')
		{
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDateTime now = LocalDateTime.now();
			RequestDate=dtf.format(now)
		}

		openProviderPayRequest_newTab()

		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		selectRequestDate(RequestDate)

		getBaseSteps().waitforLoadingComplete('imgLoading',40, pageName.CMN)

		if(CompensationModel=='') {
			CompensationModel=this.getCompensationModel()
		}

		if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate, CompensationModel, PayElement)) {
			expectedErrorMSG = (((('Pay Request already exists on service date ' +RequestDate+ ' for pay element ') + PayElement)) + ' , this request will not be raised')
		} else {
			//expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate+ ' for the Pay Element ')) + PayElement)
			expectedSuccessMSG = 'Pay Request inserted/updated successfully'
		}



		selectCompensationModel(CompensationModel)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		selectPayElement(PayElement)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		setPayElementValue(PayElementValue)

		saveProviderPayRequest()
		verifyProviderPayRequestCreation(expectedSuccessMSG,expectedErrorMSG)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}



	public static HashMap<String,String> getPayRequestDetailsWRTPayElement(String ProviderName,String PayElement) {
		HashMap<String,String> PayRequestDetails=new HashMap<>()
		String grdServiceDate,grdPayElement,grdStatus,sPayElement
		openProviderPayRequest_newTab()
		setProviderName(ProviderName)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().setWindowsSize(75)

		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayRequest))
			int i=2
			while(i<=rowCount) {

				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayRequest)
				sPayElement=grdPayElement.split(' - ')[0]
				if(sPayElement.equals(PayElement)) {
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayRequest)
					grdStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Status', pageName.ProviderPayRequest)
					PayRequestDetails.put(grdServiceDate, grdStatus)
				}
				i++
			}

		}


		getBaseSteps().setWindowsSize(100)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return PayRequestDetails
	}




}
