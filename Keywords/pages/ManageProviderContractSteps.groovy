package pages

import configs.HIIConstants
import core.BaseSteps
import core.Browser
import core.ControlFactory
import core.HMException
import java.awt.Robot
import java.text.DecimalFormat
import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.Point
import org.openqa.selenium.interactions.Actions
import org.testng.SkipException
import testDataTypes.ContractData
import testDataTypes.ContractCompModel
import testDataTypes.ContractCostCenter
import testDataTypes.ContractPayElement
import testDataTypes.ContractYear
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import pages.CostCenterPageSteps
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import bsh.This
import utils.Utilities
import utils.DateTimeUtil
import utils.CommonUtilities
import utils.ExcelUtilities
import core.AssertSteps
import core.Logger

public class ManageProviderContractSteps {

	protected static BaseSteps getBaseSteps() {
		return new BaseSteps(new ControlFactory());
	}

	private static final String lblOrganization='lblOrganization'
	private static final String ddlRegion='ddlRegion'
	private static final String ddlCompensationModel='ddlCompensationModel'
	private static final String txtStartDate='txtStartDate'
	private static final String txtEndDate='txtEndDate'
	private static final String txtProviderID='txtProviderID'
	private static final String btnGetContracts='btnGetContracts'
	private static final String btnClear='btnClear'
	private static final String lblTotalFacilityCount='lblTotalFacilityCount'
	private static final String imgExportContractDetails='imgExportContractDetails'
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnSearch='btnSearch'
	private static final String ddlMasterContract='ddlMasterContract'
	private static final String ddlCurrentYear='ddlCurrentYear'
	private static final String btnADDCONTRACT='btnADDCONTRACT'
	private static final String txtProviderName='txtProviderName'
	private static final String tabCostCenters='tabCostCenters'
	private static final String txtMasterContractStartDate='txtMasterContractStartDate'
	private static final String txtMasterContractEndDate='txtMasterContractEndDate'
	private static final String chkContractMarkComplete='chkContractMarkComplete'
	private static final String txtContractStartDate='txtContractStartDate'
	private static final String txtContractEndDate='txtContractEndDate'
	private static final String grdContractDetails='grdContractDetails'
	private static final String tabContracts='tabContracts'
	private static final String lblPosition='lblPosition'
	private static final String lblPayrollID='lblPayrollID'
	private static final String lblEmployeeType='lblEmployeeType'
	private static final String lblTerminationDate='lblTerminationDate'
	private static final String iAddNewContract='iAddNewContract'
	private static final String pnlMasterContract='pnlMasterContract'
	private static final String ddlMasterRegion='ddlMasterRegion'
	private static final String ddlbtnMasterCompensationModel='ddlbtnMasterCompensationModel'
	private static final String ddllblMasterCompensationModel='ddllblMasterCompensationModel'
	private static final String btnpnlMasterContractAdd='btnpnlMasterContractAdd'
	private static final String btnpnlMasterContractClose='btnpnlMasterContractClose'
	private static final String ddlbtnPayElements='ddlbtnPayElements'
	private static final String ddllblPayElements='ddllblPayElements'
	private static final String btnAddNewPayElements='btnAddNewPayElements'
	private static final String lblContractStartEndDate='lblContractStartEndDate'
	private static final String ddltxtPayElements='ddltxtPayElements'
	private static final String ddlbtnCostCenter='ddlbtnCostCenter'
	private static final String ddlSpecialty='ddlSpecialty'
	private static final String ddlbtnCostCenterTab='ddlbtnCostCenterTab'
	private static final String ddllblCostCenterTab='ddllblCostCenterTab'
	private static final String lblPayCycle='lblPayCycle'
	private static final String lblPayElementDesc='lblPayElementDesc'
	private static final String txtPayElementStartDate='txtPayElementStartDate'
	private static final String txtPayElementEndDate='txtPayElementEndDate'
	private static final String lblPayElementType='lblPayElementType'
	private static final String ddlPayElementPayFrequency='ddlPayElementPayFrequency'
	private static final String ddlPayElementAmountType='ddlPayElementAmountType'
	private static final String txtPayElementAnnAmountRate='txtPayElementAnnAmountRate'
	private static final String ddlPayElementUnit='ddlPayElementUnit'
	private static final String txtPayElementThresholdUnits='txtPayElementThresholdUnits'
	private static final String txtPayElementThresholdAmount='txtPayElementThresholdAmount'
	private static final String ddlPayElementThresholdFrequency='ddlPayElementThresholdFrequency'
	private static final String btnPayElementDelete='btnPayElementDelete'
	private static final String lblPayElementColumns='lblPayElementColumns'
	private static final String ddlbtnDisplaySettings='ddlbtnDisplaySettings'
	private static final String ddllblDisplaySettings='ddllblDisplaySettings'
	private static final String ddlDisplaySettingsSelectAll='ddlDisplaySettingsSelectAll'
	private static final String optDisplaySettings='optDisplaySettings'
	private static final String optDisplaySettings_ddlProfile='optDisplaySettings_ddlProfile'
	private static final String lnkFTECategory='lnkFTECategory'
	private static final String popupFTECategory='popupFTECategory'
	private static final String ddlFTECategory='ddlFTECategory'
	private static final String txtFTECategoryStartDate='txtFTECategoryStartDate'
	private static final String txtFTECategoryEndDate='txtFTECategoryEndDate'
	private static final String txtFTE='txtFTE'
	private static final String btnFTECategoryAdd='btnFTECategoryAdd'
	private static final String btnFTECategoryUpdate='btnFTECategoryUpdate'
	private static final String btnFTECategoryClear='btnFTECategoryClear'
	private static final String grdFTECategory='grdFTECategory'
	private static final String btnFTECategoryApply='btnFTECategoryApply'
	private static final String btnFTECategoryCancel='btnFTECategoryCancel'
	private static final String msgFTECategory='msgFTECategory'
	private static final String btnSaveContract='btnSaveContract'
	private static final String chkContractActive='chkContractActive'
	private static final String btnDeleteContract='btnDeleteContract'
	private static final String msgContractValidation='msgContractValidation'
	private static final String popupDeleteContract='popupDeleteContract'
	private static final String btnDeleteContractYes='btnDeleteContractYes'
	private static final String lblLocation='lblLocation'
	private static final String lblCostCenter='lblCostCenter'
	private static final String lnkCostCenter='lnkCostCenter'
	private static boolean blnProvider=false

	public static void gotoManageProviderContract() {
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract',pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void openManageProviderContract_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuProvider', 'mnuManageProviderContract', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/*---------------------------------------------------------------------------------------------------------------------------
	 MANAGE PROVIDER CONTRACT - SET METHODS
	 -----------------------------------------------------------------------------------------------------------------------------*/

	//To get Organization Name
	public static String getOrganization() {
		return getBaseSteps().getTextFromControl(lblOrganization, pageName.ManageProviderContract)
	}

	//To get Regions list
	public static List<String> getRegionList() {
		List<String> Regions=getBaseSteps().getlistControlDropdowm(ddlRegion, pageName.ProviderPayApprovals)
		Regions.remove('-ALL-')
		return Regions
	}

	//Click ADD CONTRACT option
	public static void clickADDCONTRACT() {
		getBaseSteps().clickToControl(btnADDCONTRACT, pageName.ManageProviderContract)
	}

	// is Provider text box displayed
	public static boolean isProviderTextBoxDisplayed() {
		getBaseSteps().waitForControlDisplay(txtProviderName, pageName.ManageProviderContract)
		return getBaseSteps().WebElementDisplayed(txtProviderName, pageName.ManageProviderContract)
	}

	//Enter Provider
	public static void setProvider(String ProviderName) {
		getBaseSteps().setTextToControl(txtProviderName,ProviderName,pageName.ManageProviderContract)
		try {
			getBaseSteps().waitForControlDisplay('lstContractProviderhints', pageName.CMN)
			getBaseSteps().verifyProviderHintsDisplayed('lstContractProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			blnProvider=true
			getBaseSteps().waitForProgressBarDisappear()
		}catch(Exception e) {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstContractProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			blnProvider=false
		}
	}

	//To get TotalFacility Count
	public static String getTotalFacilityCount() {
		return getBaseSteps().getTextFromControl(lblTotalFacilityCount, pageName.ManageProviderContract)
	}

	//Click Export Contract Details
	public static void clickExportContractDetails() {
		getBaseSteps().clickToControl(imgExportContractDetails, pageName.ManageProviderContract)
	}

	//Select Region
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Select Compensation Model
	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Enter Start Date
	public static void setStartDate(String StartDate) {
		getBaseSteps().selectDate(txtStartDate, StartDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Enter End Date
	public static void setEndDate(String EndDate) {
		getBaseSteps().selectDate(txtEndDate, EndDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Enter Provider ID
	public static void setProviderID( String Provider) {
		getBaseSteps().setTextToControl('txtProviderID',Provider,pageName.ManageProviderContract)
		try {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			blnProvider=true
			getBaseSteps().waitForProgressBarDisappear()
		}catch(Exception e) {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
			blnProvider=false
		}
	}

	//Enter Universal Search
	public static void setUniversalSearch(String UniversalSearch) {
		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.ManageProviderContract)
	}

	//Click Get Contracts
	public static void clickGetContracts() {
		getBaseSteps().clickToControl(btnGetContracts, pageName.ManageProviderContract)
	}

	//Click Clear
	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Click Search
	public static void clickSearch() {
		getBaseSteps().clickToControl(btnSearch, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Get Selected Region
	public static String getRegion() {
		return getBaseSteps().getselectedControlDropdowm(ddlRegion, pageName.ManageProviderContract)
	}

	//Get Selected Compensation Model
	public static String getCompensationModel() {
		return getBaseSteps().getselectedControlDropdowm(ddlCompensationModel, pageName.ManageProviderContract)
	}

	//get start date
	public static String getStartDate() {
		return getBaseSteps().getTextFromControl(txtStartDate, pageName.ManageProviderContract)
	}

	//get End Date
	public static String getEndDate() {
		return getBaseSteps().getTextFromControl(txtEndDate, pageName.ManageProviderContract)
	}

	//Get ProviderID
	public static String getProviderID() {
		return getBaseSteps().getTextFromControl(txtProviderID, pageName.ManageProviderContract)
	}

	//Get Universal Search
	public static String getUniversalSearch() {
		return getBaseSteps().getTextFromControl(txtUniversalSearch, pageName.ManageProviderContract)
	}

	//Get Master Contract Start Date
	public static String getMasterContractStartDate() {
		return getBaseSteps().getValueFromControl(txtMasterContractStartDate,pageName.ManageProviderContract)
	}

	//Get Master Contract End Date
	public static String getMasterContractEndDate() {
		return getBaseSteps().getValueFromControl(txtMasterContractEndDate,pageName.ManageProviderContract)
	}

	//Get Contract Start Date
	public static String getContractStartDate() {
		return getBaseSteps().getValueFromControl(txtContractStartDate,pageName.ManageProviderContract)
	}

	//Get Contract End Date
	public static String getContractEndDate() {
		return getBaseSteps().getValueFromControl(txtContractEndDate,pageName.ManageProviderContract)
	}

	//Get Mark Complete Status
	public static boolean getContractMarkCompleteStatus() {
		return getBaseSteps().isChecked('chkContractMarkComplete',pageName.ManageProviderContract)
	}

	//return true if contract tab exists
	public static boolean ContractTabsDisplayed() {
		return getBaseSteps().WebElementDisplayed(tabContracts, pageName.ManageProviderContract)
	}

	//return Position from Contract Screen
	public static String getPosition() {
		return getBaseSteps().getTextFromControl(lblPosition, pageName.ManageProviderContract)
	}

	//return Payroll ID from Contract Screen
	public static String getPayrollID() {
		return getBaseSteps().getTextFromControl(lblPayrollID, pageName.ManageProviderContract)
	}

	//return Employee Type from Contract Screen
	public static String getEmployeeType() {
		return getBaseSteps().getTextFromControl(lblEmployeeType, pageName.ManageProviderContract)
	}

	public static String getLocation() {
		Thread.sleep(500)
		String Location
		getBaseSteps().waitForControlDisplay(lblLocation, pageName.ManageProviderContract)
		getBaseSteps().waitForControlClickable(lblLocation, pageName.ManageProviderContract)
		Location=getBaseSteps().getTextFromControl(lblLocation, pageName.ManageProviderContract)
		return Location

	}

	public static String getSpecialty() {
		return getBaseSteps().getselectedControlDropdowm(ddlSpecialty, pageName.ManageProviderContract)
	}

	//return Termination Date from Contract Screen
	public static String getTerminationDate() {
		return getBaseSteps().getTextFromControl(lblTerminationDate, pageName.ManageProviderContract)
	}

	//Enter Master Contract Start Date
	public static void setMasterContractStartDate(String MasterContractStartDate) {
		getBaseSteps().selectDate(txtMasterContractStartDate, MasterContractStartDate, pageName.ManageProviderContract)
	}

	//Enter Master Contract End Date
	public static void setMasterContractEndDate(String MasterContractEndDate) {
		getBaseSteps().selectDate(txtMasterContractEndDate, MasterContractEndDate, pageName.ManageProviderContract)
	}

	//Get Provider Contract Details
	public static HashMap<String,String> getGridProviderContractDetails(){

		getBaseSteps().setWindowsSize(80)
		HashMap<String,String> ContractDetails=new HashMap<String,String>()

		String VendorID=getBaseSteps().getCellTableText(grdContractDetails, 'Provider/ Clock/ Vendor ID', pageName.ManageProviderContract)
		String PayrollID=getBaseSteps().getCellTableText(grdContractDetails, 'Payroll ID', pageName.ManageProviderContract)
		String Provider=getBaseSteps().getCellTableText(grdContractDetails, 'Provider', pageName.ManageProviderContract)
		String Position=getBaseSteps().getCellTableText(grdContractDetails, 'Position', pageName.ManageProviderContract)
		String Region=getBaseSteps().getCellTableText(grdContractDetails, 'Region', pageName.ManageProviderContract)
		String Location=getBaseSteps().getCellTableText(grdContractDetails, 'Location', pageName.ManageProviderContract)
		String CostCenter=getBaseSteps().getCellTableText(grdContractDetails, 'Cost Center', pageName.ManageProviderContract)
		String Specialty=getBaseSteps().getCellTableText(grdContractDetails, 'Specialty', pageName.ManageProviderContract)
		String CompensationModel=getBaseSteps().getCellTableText(grdContractDetails, 'Compensation Model', pageName.ManageProviderContract)
		String MasterContractPeriod=getBaseSteps().getCellTableText(grdContractDetails, 'Master Contract Period (Guaranteed End Date)', pageName.ManageProviderContract)
		String ContractFacilityCount=getBaseSteps().getCellTableText(grdContractDetails, 'Contract Facility Count', pageName.ManageProviderContract)
		String PayCycle=getBaseSteps().getCellTableText(grdContractDetails, 'Pay Cycle', pageName.ManageProviderContract)
		String TermDate=getBaseSteps().getCellTableText(grdContractDetails, 'Term. Date', pageName.ManageProviderContract)

		ContractDetails.put('VendorID', VendorID)
		ContractDetails.put('PayrollID', PayrollID)
		ContractDetails.put('Provider', Provider)
		ContractDetails.put('Position', Position)
		ContractDetails.put('Region', Region)
		ContractDetails.put('Location', Location)
		ContractDetails.put('CostCenter', CostCenter)
		ContractDetails.put('Specialty', Specialty)
		ContractDetails.put('CompensationModel', CompensationModel)
		ContractDetails.put('MasterContractPeriod', MasterContractPeriod)
		ContractDetails.put('ContractFacilityCount', ContractFacilityCount)
		ContractDetails.put('PayCycle', PayCycle)
		ContractDetails.put('TermDate', TermDate)
		getBaseSteps().setWindowsSize(100)
		return  ContractDetails


	}

	public static Set<String> getGridPayrollIDWithLocation(String Location){
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Set<String> setProviders=new HashSet<String>()
		setProviders.addAll(getBaseSteps().getColumnTableDpdcy(grdContractDetails, 'Payroll ID', 'Location', Location, pageName.ManageProviderContract))
		return setProviders
	}

	public static Set<String> getGridProviderWithLocation(String Location){
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Set<String> setProviders=new HashSet<String>()
		setProviders.addAll(getBaseSteps().getColumnTableDpdcy(grdContractDetails, 'Provider', 'Location', Location, pageName.ManageProviderContract))
		return setProviders
	}


	//Get Contract Facility Count
	public static String getGridContractFacilityCount() {
		HashMap<String,String> ContractDetails=new HashMap<String,String>()
		ContractDetails=getGridProviderContractDetails()
		return ContractDetails.get('ContractFacilityCount')
	}

	//Click Add New Contract
	public static void clickAddNewContract() {
		getBaseSteps().clickToControl(iAddNewContract, pageName.ManageProviderContract)
	}

	//verify Comp Model Pop up Displayed
	public static boolean AddCompModelPopupDisplayed() {
		return getBaseSteps().WebElementDisplayed(pnlMasterContract, pageName.ManageProviderContract)
	}

	public static String getCompModelPopup_MasterRegion() {
		return getBaseSteps().getselectedControlDropdowm(ddlMasterRegion, pageName.ManageProviderContract)
	}

	public static void selectCompModelPopup_MasterRegion(String MasterRegion) {
		getBaseSteps().selectByVisibleText(ddlMasterRegion, MasterRegion, pageName.ManageProviderContract)
	}

	public static void selectCompModelPopup_MasterCompensationModel(String MasterCompensationModel) {
		getBaseSteps().clickToControl(ddlbtnMasterCompensationModel, pageName.ManageProviderContract)
		getBaseSteps().clickLabelwithtext(ddllblMasterCompensationModel, MasterCompensationModel, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectMultipleCompModelPopup_MasterCompensationModel(List<String> lstMasterCompensationModel) {
		getBaseSteps().clickToControl(ddlbtnMasterCompensationModel, pageName.ManageProviderContract)
		for(String MasterCompensationModel:lstMasterCompensationModel)
			getBaseSteps().clickLabelwithtext(ddllblMasterCompensationModel, MasterCompensationModel, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickCompModelPopup_AddButton() {
		getBaseSteps().clickToControl(btnpnlMasterContractAdd, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

	}

	public static void waitForContractTabDisplayed(){
		getBaseSteps().waitForControlClickable(tabContracts, pageName.ManageProviderContract)
	}

	public static void clickCompModelPopup_CloseButton() {
		getBaseSteps().clickToControl(btnpnlMasterContractClose, pageName.ManageProviderContract)
	}


	public static void selectPayElement(String PayElement) {

		getBaseSteps().scrollDown()
		getBaseSteps().clickToControl(ddlbtnPayElements, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		getBaseSteps().setTextToControl(ddltxtPayElements, PayElement, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		getBaseSteps().clickLabelStartswithtextJS(ddllblPayElements, PayElement, pageName.ManageProviderContract)

	}

	public static void selectGroupCostCenter(String CostCenter) {

		getBaseSteps().scrollDown()
		getBaseSteps().clickToControl(this.ddlbtnCostCenterTab, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		getBaseSteps().clickLabelEndswithtextJS(this.ddllblCostCenterTab, CostCenter, pageName.ManageProviderContract)

	}


	public static void selectContractTab_PayElement(String PayElement) {
		List<String> lstPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		for(String cPayElement:lstPayElements)
			if(!(cPayElement.split(' - ')[0]).equals(PayElement))
		{
			selectPayElement(PayElement)
			clickAddNewPayElements()
		}

	}

	public static void selectGroupCostCenterPayElement(String CostCenter,String PayElement) {

		selectGroupCostCenter(CostCenter)
		List<String> lstPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		for(String cPayElement:lstPayElements)
			if(!(cPayElement.split(' - ')[0]).equals(PayElement))
		{
			selectPayElement(PayElement)
			clickAddNewPayElements()
		}
		/*List<String> lstContractTabs=new ArrayList<String>()
		 lstContractTabs=getCostCenterTabName()
		 for(String costCenter:lstContractTabs) {
		 getBaseSteps().scrollDown()
		 if(costCenter.equals(CostCenter)) {
		 getBaseSteps().selectTabFromControl(tabCostCenters, costCenter, pageName.ManageProviderContract)
		 List<String> lstPayElements=new ArrayList<String>()
		 lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		 for(String cPayElement:lstPayElements)
		 if(!(cPayElement.split(' - ')[0]).equals(PayElement))
		 {
		 selectPayElement(PayElement)
		 clickAddNewPayElements()
		 }
		 }
		 }*/
	}

	public static void selectContractTabMultipleCostCenters(HashMap<String,String> CostCenterPayElement) {
		//selectGroupCostCenterPayElement(CostCenterPayElement.get('CostCenter1'),CostCenterPayElement.get('CostCenter1PayElement1'))
		selectContractTab_PayElement(CostCenterPayElement.get('CostCenter1PayElement1'))
		selectGroupCostCenter(CostCenterPayElement.get('CostCenter2'))
		selectContractTab_PayElement(CostCenterPayElement.get('CostCenter2PayElement1'))
		//selectGroupCostCenterPayElement(CostCenterPayElement.get('CostCenter2'),CostCenterPayElement.get('CostCenter2PayElement1'))
	}

	public static void clickAddNewPayElements() {
		getBaseSteps().scrollDown()
		getBaseSteps().clickToControl(btnAddNewPayElements, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setPayElementStartDate(int index=0,String StartDate) {
		getBaseSteps().scrollDown()
		println StartDate
		//getBaseSteps().selectDate(txtPayElementStartDate, StartDate, pageName.ManageProviderContract)
		getBaseSteps().setTextToControl(txtPayElementStartDate, StartDate, pageName.ManageProviderContract)
		Thread.sleep(300)
		getBaseSteps().clickEscape()
	}

	public static void setPayElementEndDate(int index=0,String EndDate) {
		getBaseSteps().scrollDown()
		println EndDate
		//getBaseSteps().selectDate(txtPayElementEndDate, EndDate, pageName.ManageProviderContract)
		getBaseSteps().setTextToControl(txtPayElementEndDate, EndDate, pageName.ManageProviderContract)
		Thread.sleep(300)
		getBaseSteps().clickEscape()
	}

	public static String getPayElementStartDate() {
		return getBaseSteps().getValueFromControl(txtPayElementStartDate,pageName.ManageProviderContract)
	}

	public static String getPayElementEndDate() {
		return getBaseSteps().getValueFromControl(txtPayElementEndDate,pageName.ManageProviderContract)
	}


	public static void selectPayElementPayFrequency(int index=0,String PayFrequency) {
		getBaseSteps().scrollDown()
		getBaseSteps().selectByVisibleText(ddlPayElementPayFrequency, PayFrequency, pageName.ManageProviderContract)
	}

	public static void selectPayElementAmountType(int index=0,String AmountType) {
		getBaseSteps().scrollDown()
		getBaseSteps().selectByVisibleText(ddlPayElementAmountType, AmountType, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', 05,pageName.CMN)
	}

	public static void setPayElementAnnAmountRate(int index=0,String AnnAmountRate) {
		getBaseSteps().scrollDown()
		getBaseSteps().setTextToControl(txtPayElementAnnAmountRate, AnnAmountRate, pageName.ManageProviderContract)
	}

	public static void selectPayElementUnit(int index=0,String Unit) {
		getBaseSteps().scrollDown()
		getBaseSteps().selectByVisibleText(ddlPayElementUnit, Unit, pageName.ManageProviderContract)
	}

	public static void setPayElementThresholdUnits(int index=0,String ThresholdUnitsAmount) {
		getBaseSteps().scrollDown()
		getBaseSteps().setTextToControl(txtPayElementThresholdUnits, ThresholdUnitsAmount, pageName.ManageProviderContract)
	}

	public static void setPayElementThresholdAmount(int index=0,String ThresholdUnitsAmount) {
		getBaseSteps().scrollDown()
		getBaseSteps().setTextToControl(txtPayElementThresholdAmount, ThresholdUnitsAmount, pageName.ManageProviderContract)
	}

	public static void selectPayElementThresholdFrequency(int index=0,String ThresholdFrequency) {
		getBaseSteps().scrollDown()
		getBaseSteps().selectByVisibleText(ddlPayElementThresholdFrequency, ThresholdFrequency, pageName.ManageProviderContract)
	}

	public static void deletePayElement() {
		getBaseSteps().scrollDown()
		getBaseSteps().clickToControl(btnPayElementDelete, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}


	public static void setPayElement(String PayElement,String StartDate,String EndDate,String PayFrequency,String AmountType,String AnnAmountRate='',String Unit='',String ThresholdUnitsAmount,String ThresholdFrequency) {
		//deletePayElement()
		List<String> lstPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		for(String cPayElement:lstPayElements)
			if(!(cPayElement.split(' - ')[0]).equals(PayElement))
		{
			selectPayElement(PayElement)
			clickAddNewPayElements()
		}

		setPayElementStartDate(StartDate)
		setPayElementEndDate(EndDate)
		selectPayElementPayFrequency(PayFrequency)
		selectPayElementAmountType(AmountType)

		switch(AmountType){
			case'Rate':
				setPayElementAnnAmountRate(AnnAmountRate)
				selectPayElementUnit(Unit)
				setPayElementThresholdUnits(ThresholdUnitsAmount)
				break
			case'Amount':
				setPayElementThresholdAmount(ThresholdUnitsAmount)
				break
			case 'Custom':
				break
		}

		selectPayElementThresholdFrequency(ThresholdFrequency)
	}

	//Enter Contract Start Date
	public static void setContractStartDate(String ContractStartDate) {
		getBaseSteps().setTextToControl(txtContractStartDate, ContractStartDate, pageName.ManageProviderContract)
		Thread.sleep(300)
		getBaseSteps().clickEscape()
		getBaseSteps().clickToControl(lblContractStartEndDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Enter Master Contract End Date
	public static void setContractEndDate(String ContractEndDate) {

		getBaseSteps().setTextToControl(txtContractEndDate, ContractEndDate, pageName.ManageProviderContract)
		Thread.sleep(300)
		getBaseSteps().clickEscape()
		getBaseSteps().clickToControl(lblContractStartEndDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//Get Cost Center drop down value
	public static void getCostCenter() {
		getBaseSteps().getselectedControlDropdowm(this.ddlbtnCostCenter, pageName.ManageProviderContract)
	}

	// Get Pay Cycle
	public static String getPayCycle() {
		return getBaseSteps().getTextFromControl(lblPayCycle, pageName.ManageProviderContract)
	}

	// Set Mark Complete status
	public static void setMarkComplete(String MarkComplete) {
		getBaseSteps().setCheckBox(chkContractMarkComplete, MarkComplete, pageName.ManageProviderContract)
	}

	public static List<String> getPayElementColumnName(){
		return getBaseSteps().getControlsName(lblPayElementColumns, pageName.ManageProviderContract)
	}

	public static List<String> getPayElementColumnsOfPayElement(String PayElement){
		List<String> lstPayElements=new ArrayList<String>()
		List<String> ContractPayElementColumns=new ArrayList<String>()
		lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		for(String cPayElement:lstPayElements)
			if((cPayElement.split(' - ')[0]).equals(PayElement))
		{
			ContractPayElementColumns=ManageProviderContractSteps.getPayElementColumnName()

		}

		return ContractPayElementColumns
	}

	public static List<String> getDisplaySettings(){
		List<String> lstDisplaySettings=new ArrayList<String>()
		getBaseSteps().clickToControl(ddlbtnDisplaySettings, pageName.ManageProviderContract)
		lstDisplaySettings=getBaseSteps().getListTextFromControl(ddllblDisplaySettings, pageName.ManageProviderContract)
		return lstDisplaySettings
	}

	public static void selectAllDisplaySettings() {
		getBaseSteps().clickToControl(ddlbtnDisplaySettings, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(getBaseSteps().WebElementDisplayed(ddlDisplaySettingsSelectAll, pageName.ManageProviderContract))
		{
			getBaseSteps().clickToControl(ddlDisplaySettingsSelectAll, pageName.ManageProviderContract)
			getBaseSteps().clickEscape()
		}
	}

	public static List<String> getSelectedDisplaySettings(){
		List<String> lstSelectedDisplaySettings=new ArrayList<String>()
		lstSelectedDisplaySettings=getBaseSteps().getListTextFromControl(optDisplaySettings, pageName.ManageProviderContract)
		return lstSelectedDisplaySettings

	}

	public static List<String> getDisplaySettingProfiles(){
		List<String> lstProfiles=new ArrayList<String>()
		lstProfiles=getBaseSteps().getlistControlDropdowm(optDisplaySettings_ddlProfile, pageName.ManageProviderContract)
		lstProfiles.remove('-Add New Profile-')
		return lstProfiles
	}

	public static Collection<String> getProfilesOfDisplaySettings(String DisplaySetting){
		List<String> lstDisplaySettings=new ArrayList<String>()
		lstDisplaySettings=getSelectedDisplaySettings()
		Set<String> lstProfiles=new HashSet<String>()
		for(int i=0;i<=lstDisplaySettings.size();i++) {
			if(lstDisplaySettings.get(i).equals(DisplaySetting)) {
				lstProfiles=getBaseSteps().getControlDropdownUniqueListWithIndex(optDisplaySettings_ddlProfile, i.toString(), pageName.ManageProviderContract)
				lstProfiles.remove('-Add New Profile-')
				break
			}
		}
		/*for(String cDisplaySetting:lstDisplaySettings) 
		 if(cDisplaySetting.equals(DisplaySetting))
		 {
		 lstProfiles=getDisplaySettingProfiles()
		 }*/
		return 	lstProfiles
	}

	public static void setProfileOfDisplaySettings(String DisplaySetting,String Profile){
		List<String> lstDisplaySettings=new ArrayList<String>()
		lstDisplaySettings=getSelectedDisplaySettings()
		Set<String> lstProfiles=new HashSet<String>()
		for(int i=0;i<=lstDisplaySettings.size();i++) {
			if(lstDisplaySettings.get(i).equals(DisplaySetting)) {
				getBaseSteps().selectByVisibleText(optDisplaySettings_ddlProfile, Profile, pageName.ManageProviderContract)
				break
			}
		}
	}

	public static void clickFTECateogy() {
		getBaseSteps().waitForControlClickable(lnkFTECategory, pageName.ManageProviderContract)
		getBaseSteps().clickToControl(lnkFTECategory, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		AssertSteps.verifyActualResult(popupFTECategoryDisplayed(), 'FTE Category Popup Displayed - PASS', 'FTE Category Popup is not Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static boolean popupFTECategoryDisplayed() {
		return getBaseSteps().WebElementDisplayed(popupFTECategory, pageName.ManageProviderContract)
	}

	public static void setFTEDetailsAndVerify(HashMap<String,String> FTEDetails) {

		selectFTECategory(FTEDetails.get('FTECategory'))
		setFTECategoryStartDate(FTEDetails.get('StartDate'))
		setFTECategoryEndDate(FTEDetails.get('EndDate'))
		setFTE(FTEDetails.get('FTE'))

		if(clickFTECategoryAdd())
		{
			clickFTECategoryApply()
			verifyFTECategoryDetails(FTEDetails)

		}
	}

	public static void updateFTEDetailsAndVerify(HashMap<String,String> FTEDetails) {
		String rowcount=getBaseSteps().getRowTableCounts(grdFTECategory, pageName.ManageProviderContract)
		int i=2
		String FTECategoryDesc
		while(i<=rowcount.toInteger()) {
			FTECategoryDesc=getBaseSteps().getCellTableText(grdFTECategory,i.toString(), 'FTE Category Desc', pageName.ManageProviderContract)
			if(FTECategoryDesc.equals(FTEDetails.get('FTECategory'))) {
				getBaseSteps().clickTableLink(grdFTECategory, i.toString(), 'Edit', pageName.ManageProviderContract)
				setFTECategoryStartDate(FTEDetails.get('StartDate'))
				setFTECategoryEndDate(FTEDetails.get('EndDate'))
				setFTE(FTEDetails.get('FTE'))
				if(clickFTECategoryUpdate())
				{
					clickFTECategoryApply()
					verifyFTECategoryDetails(FTEDetails)
				}
			}
			i++
		}

	}


	public static void selectFTECategory(String FTECategory) {
		getBaseSteps().selectByVisibleText(ddlFTECategory, FTECategory, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setFTECategoryStartDate(String StartDate) {
		getBaseSteps().selectDate(txtFTECategoryStartDate, StartDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setFTECategoryEndDate(String EndDate) {
		getBaseSteps().selectDate(txtFTECategoryEndDate, EndDate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setFTE(String FTE) {
		getBaseSteps().setTextToControl(txtFTE, FTE, pageName.ManageProviderContract)
	}

	public static String getFTE() {
		return getBaseSteps().getValueFromControl(txtFTE, pageName.ManageProviderContract)
	}

	public static boolean clickFTECategoryAdd() {
		boolean blnADDFTE=true
		Double FTE=getFTE().toDouble()
		getBaseSteps().clickToControl(btnFTECategoryAdd, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(FTE>1)
		{
			boolean blnFTEValidation=getBaseSteps().WebElementDisplayed(msgFTECategory, pageName.ManageProviderContract)
			AssertSteps.verifyActualResult(blnFTEValidation, 'Validation Error Message Displayed when FTE is greater than 1 - PASS', 'Validation Error Message should Display when FTE is greater than 1 -FAIL', FailureHandling.STOP_ON_FAILURE)
			blnADDFTE=false
		}
		return blnADDFTE
	}

	public static boolean clickFTECategoryUpdate() {
		boolean blnADDFTE=true
		Double FTE=getFTE().toDouble()
		getBaseSteps().clickToControl(btnFTECategoryUpdate, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(FTE>1)
		{
			boolean blnFTEValidation=getBaseSteps().WebElementDisplayed(msgFTECategory, pageName.ManageProviderContract)
			AssertSteps.verifyActualResult(blnFTEValidation, 'Validation Error Message Displayed when FTE is greater than 1 - PASS', 'Validation Error Message should Display when FTE is greater than 1 -FAIL', FailureHandling.STOP_ON_FAILURE)
			blnADDFTE=false
		}
		return blnADDFTE
	}

	public static void clickFTECategoryClear() {
		getBaseSteps().clickToControl(btnFTECategoryClear, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickFTECategoryApply() {
		getBaseSteps().clickToControl(btnFTECategoryApply, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickFTECategoryCancel() {
		getBaseSteps().clickToControl(btnFTECategoryCancel, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static HashMap<String,String> getFTECategoryDetails() {
		HashMap<String,String> FTEDetails=new HashMap<String,String>()

		getBaseSteps().waitForControlDisplay(grdFTECategory, pageName.ManageProviderContract)
		if(getBaseSteps().WebElementDisplayed(grdFTECategory, pageName.ManageProviderContract)) {
			String FTECategoryDesc=getBaseSteps().getCellTableText(grdFTECategory, 'FTE Category Desc', pageName.ManageProviderContract)
			String FTECategoryStartDate=getBaseSteps().getCellTableText(grdFTECategory, 'Start Date', pageName.ManageProviderContract)
			String FTECategoryEndDate=getBaseSteps().getCellTableText(grdFTECategory, 'End Date', pageName.ManageProviderContract)
			String ContractFTEValue=getBaseSteps().getCellTableText(grdFTECategory, 'Contract FTE Value', pageName.ManageProviderContract)

			FTEDetails.put('FTECategory', FTECategoryDesc)
			FTEDetails.put('StartDate', FTECategoryStartDate)
			FTEDetails.put('EndDate', FTECategoryEndDate)
			FTEDetails.put('FTE', ContractFTEValue)
		}
		return FTEDetails
	}

	public static void clickSave() {
		getBaseSteps().scrollDown()
		//getBaseSteps().waitForControlClickable(btnSaveContract, pageName.ManageProviderContract)
		getBaseSteps().clickToControl(btnSaveContract, pageName.ManageProviderContract)
		if(WebUI.waitForAlert(20))
			WebUI.acceptAlert()

	}

	public static void setContractActive() {
		getBaseSteps().ActiveCheckBox(chkContractActive, pageName.ManageProviderContract)
	}

	public static void setContractInActive() {
		getBaseSteps().InactiveCheckBox(chkContractActive, pageName.ManageProviderContract)
		if(WebUI.waitForAlert(10))
			WebUI.acceptAlert()
	}

	public static void deleteContract() {
		getBaseSteps().clickToControl(btnDeleteContract, pageName.ManageProviderContract)
		getBaseSteps().verifyWebElementDisplayed(popupDeleteContract, pageName.ManageProviderContract)
		getBaseSteps().clickToControl(btnDeleteContractYes, pageName.ManageProviderContract)
	}

	/************************************************************************************************************************************************************/
	//DEPENDENCY METHODS

	//Verify Organization Name with expected Organization Name
	public static void verifyOrganization(String Organization) {
		String actualOrganization=getOrganization()
		String AssertMSG='Validation of Organization Name Expected: '+Organization+' and Actual: '+actualOrganization
		AssertSteps.verifyActualResult(actualOrganization.equals(Organization), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	//Verify Region drop down values with expected Regions List
	public static void verifyRegionList(Collection<String> expectedRegions,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualRegions=getRegionList()
		for(String eRegion:expectedRegions)
		{
			AssertSteps.verifyActualResult(actualRegions.contains(eRegion), 'Region : '+eRegion+' contains in Region dropdown', 'Region : '+eRegion+' does not contain in Region dropdown', failureHandling)
		}
	}

	//Verify ADD CONTRACT option click functionality
	public static void verifyADDCONTRACTClickFunctionality() {
		String AssertMsg='Provider Text Box display after clicking ADD CONTRACT option'
		AssertSteps.verifyActualResult(isProviderTextBoxDisplayed(), AssertMsg+' : PASS', AssertMsg+' : FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	//Verify Provider Name Web Service functionality after entering Provider into Provider Name field
	public static void verifyProviderWebService(String Provider,boolean validProvider) {
		getBaseSteps().setTextToControl(txtProviderName, Provider, pageName.ManageProviderContract)

		if(validProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstContractProviderhints',pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstContractProviderhints',pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	//Verify Export Contract details click functionality
	public static void verifyExportContractDetailsClickFunctionality() {
		if(Utilities.checkFileExists(HIIConstants.ProviderContractDetailsExcel)) {
			Utilities.deleteFile(HIIConstants.ProviderContractDetailsExcel)
		}
		clickExportContractDetails()

		Utilities.waitForFileDownloaded(HIIConstants.ProviderContractDetailsExcel, 5000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.ProviderContractDetailsExcel), 'Provider Contract Details Excel File:'+HIIConstants.ProviderContractDetailsExcel+' exported successfully', 'Provider Contract Details Excel File:'+HIIConstants.ProviderContractDetailsExcel+' export failed', FailureHandling.STOP_ON_FAILURE)
	}

	//Verify Total Facility Count with Excel File exported
	public static void verifyTotalFacilityCount(String TotalFacilityCount) {
		Double ExcelTotalFacilityCount=ExcelUtilities.getSumofColumn(HIIConstants.ProviderContractDetailsExcel, 'Contract Facility Count')
		String AssertMSG='Total Facility Count value Validation Expected:'+ExcelTotalFacilityCount+' and Actual: '+TotalFacilityCount
		AssertSteps.verifyActualResult(ExcelTotalFacilityCount==Double.parseDouble(TotalFacilityCount), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	//Verify Clear button functionality
	public static void verifyClearButtonClickFunctionality() {
		String Region=getRegion()
		AssertSteps.verifyActualResult(Region.equals('-ALL-'), 'Region drop down is reset to default value : ALL', 'Region Drop down is not reset to default, which is with value: '+Region, FailureHandling.CONTINUE_ON_FAILURE)
		String CompensationModel=getCompensationModel()
		AssertSteps.verifyActualResult(CompensationModel.equals('-Select Model-'), 'Compensation Model drop down is reset to default value : Select Model', 'Compensation Model Drop down is not reset to default, which is with value: '+CompensationModel, FailureHandling.CONTINUE_ON_FAILURE)
		String StartDate=getStartDate()
		AssertSteps.verifyActualResult(StartDate.equals(''), 'Start Date is reset to default value', 'Start Date is not reset to default, which is with value: '+StartDate, FailureHandling.CONTINUE_ON_FAILURE)
		String EndDate=getEndDate()
		AssertSteps.verifyActualResult(EndDate.equals(''), 'End Date is reset to default value', 'End Date is not reset to default, which is with value: '+EndDate, FailureHandling.CONTINUE_ON_FAILURE)
		String ProviderID=getProviderID()
		AssertSteps.verifyActualResult(ProviderID.equals(''), 'Provider ID is reset to default value', 'Provider ID is not reset to default, which is with value: '+ProviderID, FailureHandling.CONTINUE_ON_FAILURE)
		String UniversalSearch=getUniversalSearch()
		AssertSteps.verifyActualResult(UniversalSearch.equals(''), 'Universal Search is reset to default value', 'Universal Search is not reset to default, which is with value: '+UniversalSearch, FailureHandling.CONTINUE_ON_FAILURE)

	}

	//Verify Get Contracts functionality after selecting Start Date & End Date
	public static void verifyGetContractsFunctionality(String StartDate,String EndDate) {

		boolean blnGetContract
		String StartYear=StartDate.split('/')[2]

		ManageProviderContractSteps.editProviderContract()

		ManageProviderContractSteps.selectCurrentYear(StartYear)

		long duration=DateTimeUtil.getNoOfDaysBetweenTwoDates(StartDate, EndDate)

		String ContractStartDate=getContractStartDate()
		String ContractEndDate=getContractEndDate()

		if(DateTimeUtil.verifyDateInbetween(ContractStartDate, ContractEndDate, StartDate))
			blnGetContract=true
		else
		if(EndDate!=null || EndDate!='')
			if(ContractStartDate.equals(StartDate) && ContractEndDate.equals(EndDate))
				blnGetContract=true

		String AssertMSG='Get Contracts functionality with Start Date:'+StartDate+' and End Date:'+EndDate
		AssertSteps.verifyActualResult(blnGetContract, AssertMSG+' : PASS', AssertMSG+' : FAIL', FailureHandling.STOP_ON_FAILURE)

	}

	//Verify Universal Search functionality
	public static void verifyUniversalSearchFunctionality(String UniversalSearch) {
		boolean blnUniversalSearch
		if(getBaseSteps().WebElementDisplayed(grdContractDetails, pageName.ManageProviderContract)) {
			String VendorID=getBaseSteps().getCellTableText(grdContractDetails, 'Provider/ Clock/ Vendor ID', pageName.ManageProviderContract)
			String PayrollID=getBaseSteps().getCellTableText(grdContractDetails, 'Payroll ID', pageName.ManageProviderContract)
			String Provider=getBaseSteps().getCellTableText(grdContractDetails, 'Provider', pageName.ManageProviderContract)
			String Position=getBaseSteps().getCellTableText(grdContractDetails, 'Position', pageName.ManageProviderContract)
			String Region=getBaseSteps().getCellTableText(grdContractDetails, 'Region', pageName.ManageProviderContract)
			String CostCenter=getBaseSteps().getCellTableText(grdContractDetails, 'Cost Center', pageName.ManageProviderContract)
			String Specialty=getBaseSteps().getCellTableText(grdContractDetails, 'Specialty', pageName.ManageProviderContract)
			String CompensationModel=getBaseSteps().getCellTableText(grdContractDetails, 'Compensation Model', pageName.ManageProviderContract)
			String MasterContractPeriod=getBaseSteps().getCellTableText(grdContractDetails, 'Master Contract Period (Guaranteed End Date)', pageName.ManageProviderContract)
			String ContractFacilityCount=getBaseSteps().getCellTableText(grdContractDetails, 'Contract Facility Count', pageName.ManageProviderContract)
			String PayCycle=getBaseSteps().getCellTableText(grdContractDetails, 'Pay Cycle', pageName.ManageProviderContract)
			String TermDate=getBaseSteps().getCellTableText(grdContractDetails, 'Term. Date', pageName.ManageProviderContract)

			if(VendorID.contains(UniversalSearch) || PayrollID.contains(UniversalSearch) || Provider.contains(UniversalSearch) || Position.contains(UniversalSearch) || Region.contains(UniversalSearch) || CostCenter.contains(UniversalSearch) || Specialty.contains(UniversalSearch) || CompensationModel.contains(UniversalSearch) || MasterContractPeriod.contains(UniversalSearch) || ContractFacilityCount.contains(UniversalSearch) || PayCycle.contains(UniversalSearch) || TermDate..contains(UniversalSearch))
				blnUniversalSearch=true

			String AssertMSG='Universal Search functionality with Data:'+UniversalSearch
			AssertSteps.verifyActualResult(blnUniversalSearch, AssertMSG+' : PASS', AssertMSG+' : FAIL', FailureHandling.STOP_ON_FAILURE)
		}else {
			Logger.logWARNING('Universal Search with data : '+UniversalSearch+' does not exist in Contract Details')
		}
	}

	//Verify Provider Name Web Service functionality after entering Provider into Provider Name field
	public static void verifyProviderIDWebService(String Provider,boolean validProvider) {
		getBaseSteps().setTextToControl(txtProviderID, Provider, pageName.ManageProviderContract)

		if(validProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void verifyProviderDetails(HashMap<String,String> ProviderDetails) {

		String PositionLevel= ProviderDetails.get('PositionLevel')
		String PayrollID= ProviderDetails.get('PayrollID')
		String EmployeeType= ProviderDetails.get('EmployeeType')
		String EmployeeStatus=ProviderDetails.get('EmployeeStatus')
		String CPosition=this.getPosition()
		String CPayrollID=this.getPayrollID()
		String CEmployeeType=this.getEmployeeType()
		String TerminationDate
		String CTerminationDate
		String AssertMSG
		AssertMSG='Position Level validation Expected : '+PositionLevel+' and Actual : '+CPosition
		AssertSteps.verifyActualResult(PositionLevel.equals(CPosition), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertMSG='PayrollID validation Expected : '+PayrollID+' and Actual : '+CPayrollID
		AssertSteps.verifyActualResult(PayrollID.equals(CPayrollID), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertMSG='Employee Type Level validation Expected : '+EmployeeType+' and Actual : '+CEmployeeType
		AssertSteps.verifyActualResult(EmployeeType.equals(CEmployeeType), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		if(EmployeeStatus.equals('Terminated'))
		{
			TerminationDate=ProviderDetails.get('TerminationDate')
			CTerminationDate=this.getTerminationDate()
			AssertMSG='Termination Date validation Expected : '+TerminationDate+' and Actual : '+CTerminationDate
			AssertSteps.verifyActualResult(TerminationDate.equals(CTerminationDate), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}

	}

	public static void verifyCurrentYear() {

		String MasterContractStartDate=this.getMasterContractStartDate()
		String MasterContractEndDate=this.getMasterContractEndDate()

		List<String> lstYear=DateTimeUtil.getYearsBetweenTwoDates(MasterContractStartDate, MasterContractEndDate)
		println lstYear
		List<String> ClstYear=this.getCurrentYear()
		println ClstYear
		for(String Year:ClstYear) {
			AssertSteps.verifyActualResult(lstYear.contains(Year), 'Year :'+Year+' contains in CurrentYear drop down - PASS', 'Year :'+Year+' does not contain in CurrentYear drop down - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}

	}

	public static void verifyContractFacilityCount(long ContractFacilityCount) {
		List<String> lstCostCenterTab=new ArrayList<String>()
		lstCostCenterTab=getCostCenterTabName()
		long count=lstCostCenterTab.size()
		String AssertMSG='Contract Facility Count validation Expected : '+ContractFacilityCount+' and Actual : '+count
		AssertSteps.verifyActualResult(ContractFacilityCount==count, AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyContractTabAfterSelectingCompensationModel(String MasterRegion,String defaultLocation,String MasterCompensationModel) {
		boolean blnContractTab,blnContractTabCreated
		String AssertMSG
		String expectedTabName=MasterRegion+'-'+defaultLocation+'-'+MasterCompensationModel
		AssertMSG='Creation of new Contract Tab'
		getBaseSteps().waitForControlDisplay(tabContracts, pageName.ManageProviderContract)
		blnContractTab=ContractTabsDisplayed()
		AssertSteps.verifyActualResult(blnContractTab, AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
		AssertMSG='Creation of new Contract Tab Name with :'+expectedTabName
		if(blnContractTab) {
			List<String> lstContractTabs=new ArrayList<String>()
			lstContractTabs=getContractTabName()
			for(String ContractTab:lstContractTabs) {
				if(ContractTab.equals(expectedTabName))
					blnContractTabCreated=true
			}
		}
		AssertSteps.verifyActualResult(blnContractTabCreated, AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyDefaultMasterRegionValidation(String defaultRegion) {
		String MasterRegion=ManageProviderContractSteps.getCompModelPopup_MasterRegion()
		String AssertMSG='Region drop down default value validation Expected : '+defaultRegion+' and Actual : '+MasterRegion
		AssertSteps.verifyActualResult(MasterRegion.equals(defaultRegion), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyDefaultCostCenter(String DefaultCostCenter) {
		String CostCenter
		getBaseSteps().waitForControlClickable(ddlbtnCostCenter, pageName.ManageProviderContract)
		int i=1
		while(i<=10) {
			CostCenter=getBaseSteps().getTitleFromControl(ddlbtnCostCenter, pageName.ManageProviderContract)
			if(!CostCenter.equals('-Select Cost Center-')) {
				break
			}
			Thread.sleep(500)
			i++
		}

		String AssertMSG='Cost Center drop down default value validation Expected : '+DefaultCostCenter+' and Actual : '+CostCenter
		AssertSteps.verifyActualResult(CostCenter.endsWith(DefaultCostCenter), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyDefaultSpecialty(String DefaultSpecialty) {
		String Specialty=getBaseSteps().getselectedControlDropdowm(ddlSpecialty, pageName.ManageProviderContract)
		String AssertMSG='Specialty drop down default value validation Expected : '+DefaultSpecialty+' and Actual : '+Specialty
		AssertSteps.verifyActualResult(Specialty.equals(DefaultSpecialty), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyCostCenterTab_CostCenterDisplayed(String flagSetting) {

		getBaseSteps().waitForControlDisplay(tabContracts, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		boolean blnexpectedCostCenter
		if(flagSetting.equals('Yes'))
			blnexpectedCostCenter=true

		if(blnexpectedCostCenter)
			getBaseSteps().waitForControlClickable(ddlbtnCostCenterTab, pageName.ManageProviderContract)

		boolean blnCostCenter=getBaseSteps().WebElementDisplayed(ddlbtnCostCenterTab, pageName.ManageProviderContract)
		boolean blnCostCenterTab=getBaseSteps().WebElementDisplayed(tabCostCenters, pageName.ManageProviderContract)
		String AssertMSG='Allow To Group Contract PayElements based on CostCenter - Flag Setting: '+flagSetting+'  And Cost Center drop down is displayed : '+blnCostCenter+' and Cost Center Tab is displayed : '+blnCostCenterTab
		AssertSteps.verifyActualResult((blnCostCenter.equals(blnexpectedCostCenter)&&blnCostCenterTab.equals(blnexpectedCostCenter)), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifyPayCycle(String defaultPayCycle) {
		String PayCycle=getPayCycle()
		String AssertMSG='Pay Cycle default value validation with Expected:'+defaultPayCycle+' and Actual: '+PayCycle
		AssertSteps.verifyActualResult(PayCycle.equals(defaultPayCycle), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifyPayElementDefaultStartDate() {
		String ContractStartDate=getContractStartDate()
		String PayElementStartDate=getPayElementStartDate()
		String AssertMSG='Pay Element Start Date Default value validation - Expected (Contract Start Date) :'+ContractStartDate+' and Actual :'+PayElementStartDate
		AssertSteps.verifyActualResult(ContractStartDate.equals(PayElementStartDate), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyPayElementDefaultEndDate() {
		String ContractEndDate=getContractEndDate()
		String PayElementEndDate=getPayElementEndDate()
		String AssertMSG='Pay Element End Date Default value validation - Expected (Contract End Date) :'+ContractEndDate+' and Actual :'+PayElementEndDate
		AssertSteps.verifyActualResult(ContractEndDate.equals(PayElementEndDate), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyPayElementColummnsOfPayElement(String PayElement,List<String> expectedPayElementColumns) {
		List<String> lstPayElementColumns=new ArrayList<String>()
		lstPayElementColumns=getPayElementColumnsOfPayElement(PayElement)
		for(String PayElementColumn:expectedPayElementColumns)
			AssertSteps.verifyActualResult(lstPayElementColumns.contains(PayElementColumn), 'Pay Element Column Name : '+PayElementColumn+' contains in Pay Element Column list - PASS','Pay Element Column Name : '+PayElementColumn+' does not contain in Pay Element Column list - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static void verifyDefaultPayElement(List<String> PayElement) {
		List<String> lstPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getControlsName(lblPayElementDesc, pageName.ManageProviderContract)
		for(String cPayElement:lstPayElements)
		{
			String DefaultPayElement=cPayElement.split(' - ')[0]
			AssertSteps.verifyActualResult(PayElement.contains(DefaultPayElement), DefaultPayElement+' is in expected list of Deafult PayElement - PASS', DefaultPayElement+' is not in expected list of Deafult PayElement - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void verifyDefaultDisplaySettings(List<String> MiscProfileTypeSettings) {
		List<String> lstDisplaySettings=new ArrayList<String>()
		lstDisplaySettings=getDisplaySettings()
		for(String DisplaySetting:lstDisplaySettings)
		{

			AssertSteps.verifyActualResult(MiscProfileTypeSettings.contains(DisplaySetting), DisplaySetting+' is in expected list of Default Display Settings - PASS', DisplaySetting+' is not in expected list of Default Display Settings - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void verifyDisplaySettingsDefaultProfiles(HashMap<String,String> ProviderDetails) {
		String PrimarySpecialty=ProviderDetails.get('PrimarySpecialty')
		String Region=ProviderDetails.get('Region')
		String PositionLevel=ProviderDetails.get('PositionLevel')
		String Location=ProviderDetails.get('Location')
		String CostCenter=ProviderDetails.get('PrimaryCostCenter')

		List<String> lstSelectedDisplaySettings=new ArrayList<String>()
		lstSelectedDisplaySettings=getSelectedDisplaySettings()

		List<String> lstProfiles=new ArrayList<String>()
		Set<String> lstDisplaySettingsProfiles=new HashSet<String>()
		for(String DisplaySetting:lstSelectedDisplaySettings) {

			lstProfiles=MiscellaneousProfileSettingsPageSteps.getLookupValue(DisplaySetting, PrimarySpecialty, Region, PositionLevel, Location, CostCenter)
			lstDisplaySettingsProfiles=getProfilesOfDisplaySettings(DisplaySetting)

			for(String Profile:lstProfiles)
				AssertSteps.verifyActualResult(lstDisplaySettingsProfiles.contains(Profile), Profile+' from  Miscellaneous Profile Settings contains in Contract Screen of Display Setting '+DisplaySetting+' - PASS', Profile+' from  Miscellaneous Profile Settings does not contain in Contract Screen of Display Setting '+DisplaySetting+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

			for(String Profile:lstDisplaySettingsProfiles)
				AssertSteps.verifyActualResult(lstProfiles.contains(Profile), Profile+' from  Contract Screen of Display Setting '+DisplaySetting+' contains in Miscellaneous Profile Settings list - PASS', Profile+' from  Contract Screen of Display Setting '+DisplaySetting+' does not contain in Miscellaneous Profile Settings list - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}


	}

	public static void verifyMultipleCompensationModelTabs(String Region,String Location,List<String> lstMasterCompensationModel) {
		boolean blnContractTab,blnContractTabCreated
		String AssertMSG
		List<String> lstNewContractTabs=new ArrayList<String>()
		for(String MasterCompensationModel:lstMasterCompensationModel)
			lstNewContractTabs.add(Region+'-'+Location+'-'+MasterCompensationModel)
		AssertMSG='Creation of new Contract Tab'
		getBaseSteps().waitForControlDisplay(tabContracts, pageName.ManageProviderContract)
		blnContractTab=ContractTabsDisplayed()
		AssertSteps.verifyActualResult(blnContractTab, AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)

		if(blnContractTab) {
			List<String> lstContractTabs=new ArrayList<String>()
			lstContractTabs=getContractTabName()
			for(String ContractTab:lstNewContractTabs) {
				AssertMSG='Creation of new Contract Tab Name with :'+ContractTab
				AssertSteps.verifyActualResult(lstContractTabs.contains(ContractTab), AssertMSG+' - PASS', AssertMSG+' - FAIL', FailureHandling.STOP_ON_FAILURE)
			}

		}

	}

	public static void verifyFTECategoryDetails(HashMap<String,String> expectedFTEDetails) {
		boolean blnFTEValidation
		clickFTECateogy()
		HashMap<String,String> ActualFTEDetails=new HashMap<String,String>()
		ActualFTEDetails=getFTECategoryDetails()
		clickFTECategoryCancel()

		if(ActualFTEDetails.get('FTECategory').equals(expectedFTEDetails.get('FTECategory')) && ActualFTEDetails.get('StartDate').equals(expectedFTEDetails.get('StartDate')) && ActualFTEDetails.get('EndDate').equals(expectedFTEDetails.get('EndDate')) && ActualFTEDetails.get('FTE').toDouble()==expectedFTEDetails.get('FTE').toDouble())
			blnFTEValidation=true
		AssertSteps.verifyActualResult(blnFTEValidation, 'Expected : '+expectedFTEDetails+' and Actual : '+ActualFTEDetails+'Entered FTE Details are updated - PASS', 'Expected : '+expectedFTEDetails+' and Actual : '+ActualFTEDetails+'Entered FTE Details are not updated - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyGroupCostCenterTabs(List<String> lstExpectedGroupCostCenters) {
		getBaseSteps().waitForControlDisplay(tabContracts, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		boolean blnCostCenterTab=getBaseSteps().WebElementDisplayed(tabCostCenters, pageName.ManageProviderContract)

		List<String> lstContractTabs=new ArrayList<String>()
		lstContractTabs=getCostCenterTabName()

		println lstExpectedGroupCostCenters
		println lstContractTabs
		AssertSteps.verifyActualResult(lstContractTabs.equals(lstExpectedGroupCostCenters),' - PASS', ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifySuccessMessage() {
		boolean blnConfirmation=getBaseSteps().WebElementDisplayed(msgContractValidation, pageName.ManageProviderContract)
		AssertSteps.verifyActualResult(blnConfirmation, 'Confirmation Message is displayed - PASS', 'Confirmation Message is not displayed -FAIL ', FailureHandling.STOP_ON_FAILURE)
		println getBaseSteps().getTextFromControl(msgContractValidation, pageName.ManageProviderContract)
	}
	/***********************************************************************************************************************************************************/	
	public static void setRegion(String Region) {}

	public static void setCompensationModel(String CompensationModel) {}






	public static List<String> getContractTabName(){
		List<String> lstCompModel=new ArrayList<String>()
		lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)
		return lstCompModel
	}

	public static List<String> getCostCenterTabName(){
		List<String> lstCostCenters=new ArrayList<String>()
		getBaseSteps().scrollDown()
		lstCostCenters=getBaseSteps().getTabsNameFromControl(tabCostCenters,pageName.ManageProviderContract)
		return lstCostCenters
	}









	public static void selectMasterContract(String MasterContract) {
		getBaseSteps().selectByVisibleText(ddlMasterContract, MasterContract, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}




	/*---------------------------------------------------------------------------------------------------------------------------*/	







	public static void verifyManageProviderContractPageLoaded() {
		getBaseSteps().verifyPageIsLoaded(HIIConstants.URL_ProviderContract,"Manage Provider Contract page is not launched")
	}

	/*public static void setProviderID( String Provider) {
	 getBaseSteps().setTextToControl('txtProviderID',Provider,pageName.ManageProviderContract)
	 //getBaseSteps().verifyControlDisplayed('lstProviderhints',pageName.CMN)
	 try {
	 getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
	 //getBaseSteps().clickToControl('lstProviderhints',pageName.CMN)
	 blnProvider=true
	 getBaseSteps().waitForProgressBarDisappear()
	 }catch(Exception e) {
	 getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.OPTIONAL)
	 blnProvider=false
	 }
	 }*/

	public static void editProviderContract() {
		getBaseSteps().waitForControlDisplay('lnkEditContract',10,pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForControlClickable('lnkEditContract', pageName.ManageProviderContract)
		getBaseSteps().clickToControl('lnkEditContract',pageName.ManageProviderContract)
		getBaseSteps().waitForControlDisplay('txtMasterContractStartDate',15,pageName.ManageProviderContract)
		getBaseSteps().waitForProgressBarDisappear()
	}

	public static List<String> getMasterContracts(){
		List<String> lstMasterContracts=new ArrayList<String>()
		lstMasterContracts=getBaseSteps().getlistControlDropdowm('ddlMasterContract', pageName.ManageProviderContract)
		lstMasterContracts.remove('-Select-')
		return lstMasterContracts
	}

	public static List<String> getCurrentYear(){
		List<String> lstCurrentYear=new ArrayList<String>()
		lstCurrentYear=getBaseSteps().getlistControlDropdowm(ddlCurrentYear, pageName.ManageProviderContract)
		return lstCurrentYear
	}

	public static ContractData getContractDetails( String Provider) {

		ContractData contractData=new ContractData()
		ContractYear contractYear=new ContractYear()

		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract',pageName.Header)

		setProviderID(Provider)

		if(blnProvider) {

			editProviderContract()



			contractData.setMasterContractStartDate(getBaseSteps().getValueFromControl('txtMasterContractStartDate',pageName.ManageProviderContract))
			contractData.setMasterContractEndDate(getBaseSteps().getValueFromControl('txtMasterContractEndDate',pageName.ManageProviderContract))


			List<String> lstCurrentYear=new ArrayList<String>()

			lstCurrentYear=getBaseSteps().getlistControlDropdowm('ddlCurrentYear', pageName.ManageProviderContract)

			HashMap<String, ContractYear> hmContractYear=new HashMap<String, ContractYear>();
			HashMap<String, ContractCompModel> hmContratCompModel=new HashMap<String, ContractCompModel>();

			for(String currentYear:lstCurrentYear) {
				getBaseSteps().scrollUp()
				getBaseSteps().selectByVisibleText('ddlCurrentYear', currentYear, pageName.ManageProviderContract)

				/*getBaseSteps().waitForControlDisplay('tabContracts', 10, pageName.ManageProviderContract)
				 contractData.CurrentYear.add(currentYear)
				 contractYear.lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)
				 for(String CompModel:contractYear.lstCompModel) {
				 getBaseSteps().scrollUp()
				 getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
				 hmContratCompModel.put(CompModel,getContractCompModel(currentYear,CompModel))
				 }
				 contractYear.HMContractCompModel=hmContratCompModel
				 hmContractYear.put(currentYear, contractYear)*/


				try {
					getBaseSteps().waitForControlDisplay('tabContracts', 10, pageName.ManageProviderContract)
					//	println 'Contract tabs exists for selected year: '+currentYear
					try {
						contractData.CurrentYear.add(currentYear)
						//	contractYear.lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)

						/*contractData.hmYearCModel.put(currentYear, contractYear.lstCompModel)
						 for(String CompModel:contractYear.lstCompModel) {
						 getBaseSteps().scrollUp()
						 getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
						 //hmContratCompModel.put(CompModel,getContractCompModel(CompModel))
						 hmContratCompModel.put(CompModel,getContractCompModel(currentYear,CompModel))
						 }
						 contractYear.HMContractCompModel=hmContratCompModel*/

						//hmContractYear.put(currentYear, contractYear)
						hmContractYear.put(currentYear, getContractYear())
					}catch(Exception e) {}
				}catch(Exception e) {
					//println 'Contract tabs does not exist for selected year: '+currentYear
				}



			}

			contractData.HMContractYear=hmContractYear

		}

		return contractData
	}

	public static ContractData getContractDetailsMarkCompleted( String Provider) {

		ContractData contractData=new ContractData()
		ContractYear contractYear=new ContractYear()
		openManageProviderContract_newTab()
		//getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract',pageName.Header)
		setProviderID(Provider)
		if(blnProvider) {
			editProviderContract()
			contractData.setMasterContractStartDate(getBaseSteps().getValueFromControl('txtMasterContractStartDate',pageName.ManageProviderContract))
			contractData.setMasterContractEndDate(getBaseSteps().getValueFromControl('txtMasterContractEndDate',pageName.ManageProviderContract))
			List<String> lstCurrentYear=new ArrayList<String>()
			lstCurrentYear=getBaseSteps().getlistControlDropdowm('ddlCurrentYear', pageName.ManageProviderContract)
			HashMap<String, ContractYear> hmContractYear=new HashMap<String, ContractYear>();
			HashMap<String, ContractCompModel> hmContratCompModel=new HashMap<String, ContractCompModel>();
			for(String currentYear:lstCurrentYear) {
				getBaseSteps().scrollUp()
				getBaseSteps().selectByVisibleText('ddlCurrentYear', currentYear, pageName.ManageProviderContract)
				Thread.sleep(10)
				if(getBaseSteps().WebElementDisplayed('tabContracts', pageName.ManageProviderContract)) {
					contractData.CurrentYear.add(currentYear)
					hmContractYear.put(currentYear, getContractYearMarkCompleted())
				}

				/*try {
				 getBaseSteps().waitForControlDisplay('tabContracts', 10, pageName.ManageProviderContract)
				 try {
				 contractData.CurrentYear.add(currentYear)
				 hmContractYear.put(currentYear, getContractYearMarkCompleted())
				 }catch(Exception e) {}
				 }catch(Exception e) {
				 }*/
			}
			contractData.HMContractYear=hmContractYear
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return contractData
	}

	public static ContractData getContractDetailsforYear(String Provider,String cYear) {

		ContractData contractData=new ContractData()
		ContractYear contractYear=new ContractYear()

		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract',pageName.Header)
		setProviderID(Provider)

		if(blnProvider) {
			editProviderContract()
			contractData.setMasterContractStartDate(getBaseSteps().getValueFromControl('txtMasterContractStartDate',pageName.ManageProviderContract))
			contractData.setMasterContractEndDate(getBaseSteps().getValueFromControl('txtMasterContractEndDate',pageName.ManageProviderContract))
			getBaseSteps().selectByVisibleText('ddlCurrentYear', cYear, pageName.ManageProviderContract)
			List<String> lstCurrentYear=new ArrayList<String>()
			lstCurrentYear.add(cYear)
			HashMap<String, ContractYear> hmContractYear=new HashMap<String, ContractYear>();
			HashMap<String, ContractCompModel> hmContratCompModel=new HashMap<String, ContractCompModel>();

			for(String currentYear:lstCurrentYear) {
				getBaseSteps().scrollUp()
				getBaseSteps().selectByVisibleText('ddlCurrentYear', currentYear, pageName.ManageProviderContract)
				try {
					getBaseSteps().waitForControlDisplay('tabContracts', 10, pageName.ManageProviderContract)
					try {
						contractData.CurrentYear.add(currentYear)
						hmContractYear.put(currentYear, getContractYear())
					}catch(Exception e) {}
				}catch(Exception e) {
				}
			}
			contractData.HMContractYear=hmContractYear
		}
		return contractData
	}

	public static boolean isCompensationModelTabsClickable() {
		return getBaseSteps().isControlClickable('tabContracts', pageName.ManageProviderContract)
	}

	public static void isCostCentersTabsClickable() {
		getBaseSteps().isControlClickable('tabCostCenters', pageName.ManageProviderContract)
	}


	public static List<String> getCompModelsTabs(){
		getBaseSteps().scrollUp()
		return getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)
	}

	public static void selectCompModelTab(String CompModel) {
		getBaseSteps().scrollUp()
		getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static ContractYear getContractYear() {

		ContractYear contractYear=new ContractYear()
		String xCompModel
		List<String> lstCompModel=new ArrayList<String>()
		lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)
		HashMap<String, ContractCompModel> hmContratCompModel=new HashMap<String, ContractCompModel>();

		for(String CompModel:lstCompModel) {

			getBaseSteps().scrollUp()
			getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
			xCompModel=new ArrayDeque<>(Arrays.asList(CompModel.split("-"))).getLast();
			contractYear.lstCompModel.add(xCompModel)
			hmContratCompModel.put(xCompModel,getContractCompModel(CompModel))
		}
		contractYear.HMContractCompModel=hmContratCompModel
		return contractYear
	}

	private static ContractYear getContractYearMarkCompleted() {

		ContractYear contractYear=new ContractYear()
		String xCompModel
		List<String> lstCompModel=new ArrayList<String>()
		lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)
		HashMap<String, ContractCompModel> hmContratCompModel=new HashMap<String, ContractCompModel>();

		for(String CompModel:lstCompModel) {

			getBaseSteps().scrollUp()
			getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
			xCompModel=new ArrayDeque<>(Arrays.asList(CompModel.split("-"))).getLast();
			contractYear.lstCompModel.add(xCompModel)
			hmContratCompModel.put(xCompModel,getContractCompModelMarkCompleted(CompModel))
		}
		contractYear.HMContractCompModel=hmContratCompModel
		return contractYear
	}

	private static ContractCompModel getContractCompModel(String cYear,String CompModel) {

		ContractCompModel contractCompModel=new ContractCompModel()

		contractCompModel.CompModel=new ArrayDeque<>(Arrays.asList(CompModel.split("-"))).getLast();

		contractCompModel.ContractStatus=getBaseSteps().isChecked('chkContractMarkComplete',pageName.ManageProviderContract)
		contractCompModel.ContractStartDate=getBaseSteps().getValueFromControl('txtContractStartDate',pageName.ManageProviderContract)
		contractCompModel.ContractEndDate=getBaseSteps().getValueFromControl('txtContractEndDate', pageName.ManageProviderContract)

		contractCompModel.noofCostCenters= getBaseSteps().getTabsCountFromControl('tabCostCenters', pageName.ManageProviderContract)
		contractCompModel.lstCostCenters=getBaseSteps().getTabsNameFromControl('tabCostCenters', pageName.ManageProviderContract)

		try {
			contractCompModel.ContractMaxCompensationDuration=getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
			//println getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
		}catch(Exception e) {}


		String CostCenter
		HashMap<String,ContractCostCenter> hmContractCostCenter=new HashMap<String,ContractCostCenter>();
		for(int i=0;i<contractCompModel.noofCostCenters;i++) {
			CostCenter=(contractCompModel.lstCostCenters).get(i)


			/*String CCID=(CostCenter.split('-')).get(0)
			 hmRL=CostCenterPageSteps.getRegionLocationforHIICCID(CCID)
			 println CCID
			 println hmRL.get('Region')
			 println hmRL.get('Location')*/


			getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
			getBaseSteps().scrollDown()
			getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, pageName.ManageProviderContract)
			hmContractCostCenter.put(CostCenter, getContractCostCenter(cYear,contractCompModel.CompModel,CostCenter))
		}
		contractCompModel.HMContractCostCenter=hmContractCostCenter

		return contractCompModel
	}

	private static ContractCompModel getContractCompModel(String CompModel) {

		ContractCompModel contractCompModel=new ContractCompModel()

		contractCompModel.CompModel=new ArrayDeque<>(Arrays.asList(CompModel.split("-"))).getLast();

		contractCompModel.ContractStatus=getBaseSteps().isChecked('chkContractMarkComplete',pageName.ManageProviderContract)
		contractCompModel.ContractStartDate=getBaseSteps().getValueFromControl('txtContractStartDate',pageName.ManageProviderContract)
		contractCompModel.ContractEndDate=getBaseSteps().getValueFromControl('txtContractEndDate', pageName.ManageProviderContract)
		contractCompModel.ContractMaxCompensation=getBaseSteps().getValueFromControl('txtContractMaxCompensation', pageName.ManageProviderContract)
		contractCompModel.noofCostCenters= getBaseSteps().getTabsCountFromControl('tabCostCenters', pageName.ManageProviderContract)
		contractCompModel.lstCostCenters=getBaseSteps().getTabsNameFromControl('tabCostCenters', pageName.ManageProviderContract)


		if(getBaseSteps().WebElementDisplayed('ddlMaxCompensationDuration', pageName.ManageProviderContract))
			contractCompModel.ContractMaxCompensationDuration=getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)

		/*try {
		 contractCompModel.ContractMaxCompensationDuration=getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
		 //println getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
		 }catch(Exception e) {}
		 */

		String CostCenter
		HashMap<String,ContractCostCenter> hmContractCostCenter=new HashMap<String,ContractCostCenter>();
		for(int i=0;i<contractCompModel.noofCostCenters;i++) {
			CostCenter=(contractCompModel.lstCostCenters).get(i)


			/*String CCID=(CostCenter.split('-')).get(0)
			 hmRL=CostCenterPageSteps.getRegionLocationforHIICCID(CCID)
			 println CCID
			 println hmRL.get('Region')
			 println hmRL.get('Location')*/


			getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
			getBaseSteps().scrollDown()
			getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, pageName.ManageProviderContract)
			hmContractCostCenter.put(CostCenter, getContractCostCenter(contractCompModel.CompModel,CostCenter))
		}
		contractCompModel.HMContractCostCenter=hmContractCostCenter

		return contractCompModel
	}

	private static ContractCompModel getContractCompModelMarkCompleted(String CompModel) {

		ContractCompModel contractCompModel=new ContractCompModel()

		contractCompModel.CompModel=new ArrayDeque<>(Arrays.asList(CompModel.split("-"))).getLast();

		contractCompModel.ContractStatus=getBaseSteps().isChecked('chkContractMarkComplete',pageName.ManageProviderContract)
		contractCompModel.ContractStartDate=getBaseSteps().getValueFromControl('txtContractStartDate',pageName.ManageProviderContract)
		contractCompModel.ContractEndDate=getBaseSteps().getValueFromControl('txtContractEndDate', pageName.ManageProviderContract)
		contractCompModel.Location=getBaseSteps().getTextFromControl(lblLocation, pageName.ManageProviderContract)

		return contractCompModel
	}

	public static List<String> getCostCenterTabs() {
		getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		return getBaseSteps().getTabsNameFromControl('tabCostCenters', pageName.ManageProviderContract)
	}

	public static List<String> getCostCenterTabsJSExecutor() {
		getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
		return getBaseSteps().getTabsNameFromControlJSExecutor('tabCostCenters', pageName.ManageProviderContract)
	}

	public static void selectCostCenterTab(String CostCenter) {
		getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
		getBaseSteps().scrollDown()
		getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCostCenterTabJSExecutor(String CostCenter) {
		//getBaseSteps().scrollIntoView('tabCostCenters', pageName.ManageProviderContract)
		getBaseSteps().selectTabFromControlJSExecutor('tabCostCenters', CostCenter, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static ContractCompModel getContractCompModel() {
		ContractCompModel contractCompModel=new ContractCompModel()


		contractCompModel.ContractStatus=getBaseSteps().isChecked('chkContractMarkComplete',pageName.ManageProviderContract)
		contractCompModel.ContractStartDate=getBaseSteps().getValueFromControl('txtContractStartDate',pageName.ManageProviderContract)
		contractCompModel.ContractEndDate=getBaseSteps().getValueFromControl('txtContractEndDate', pageName.ManageProviderContract)

		contractCompModel.noofCostCenters= getBaseSteps().getTabsCountFromControl('tabCostCenters', pageName.ManageProviderContract)
		contractCompModel.lstCostCenters=getBaseSteps().getTabsNameFromControl('tabCostCenters', pageName.ManageProviderContract)

		try {
			contractCompModel.ContractMaxCompensationDuration=getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
			//println getBaseSteps().getselectedControlDropdowm('ddlMaxCompensationDuration', pageName.ManageProviderContract)
		}catch(Exception e) {}


		String CostCenter
		HashMap<String,ContractCostCenter> hmContractCostCenter=new HashMap<String,ContractCostCenter>();
		for(int i=0;i<contractCompModel.noofCostCenters;i++) {
			CostCenter=(contractCompModel.lstCostCenters).get(i)


			/*String CCID=(CostCenter.split('-')).get(0)
			 hmRL=CostCenterPageSteps.getRegionLocationforHIICCID(CCID)
			 println CCID
			 println hmRL.get('Region')
			 println hmRL.get('Location')*/


			getBaseSteps().waitForControlDisplay('tabCostCenters', 15, pageName.ManageProviderContract)
			getBaseSteps().scrollDown()
			getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, pageName.ManageProviderContract)
			hmContractCostCenter.put(CostCenter, getContractCostCenter(CostCenter))
		}
		contractCompModel.HMContractCostCenter=hmContractCostCenter

		return contractCompModel
	}

	public static List<String> getPayElements(){
		return getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
	}

	private static ContractCostCenter getContractCostCenter(String cYear,String CompModel,String CostCenter) {

		ContractCostCenter contractCostCenter=new ContractCostCenter()
		HashMap<String,String> hmRL=new HashMap<String,String>()

		hmRL=CostCenterPageSteps.getRegionLocationforHIICCID(CostCenter.split('-').getAt(0))
		//println hmRL.get('Region')
		//println hmRL.get('Location')

		contractCostCenter.CostCenter=hmRL.get('CostCenter')
		contractCostCenter.CostCenterRegion=hmRL.get('Region')
		contractCostCenter.CostCenterLocation=hmRL.get('Location')
		contractCostCenter.AllowPEoutsideCD=GeneralSettingsSteps.getAllowPayElementsDatesoutsideContractDates(hmRL.get('Region'),hmRL.get('Location'))
		WebUI.delay(3)

		//	println CompModel +"-"+contractCostCenter.CostCenter+'-'+cYear
		contractCostCenter.CompModel=CompModel +"-"+contractCostCenter.CostCenter+'-'+cYear

		contractCostCenter.noofPayElements=getBaseSteps().getCountofControl('lblPayElementDesc',pageName.ManageProviderContract)
		contractCostCenter.lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
		String PayElement
		HashMap<String, ContractPayElement> hmContractPayElement=new HashMap<String, ContractPayElement>();

		for(int i=0;i<contractCostCenter.noofPayElements;i++){
			PayElement=getBaseSteps().getTextControls('lblPayElementDesc',i,pageName.ManageProviderContract)
			//println PayElement
			hmContractPayElement.put(PayElement,getContractPayElement(i))
		}
		contractCostCenter.HMContractPayElement=hmContractPayElement
		return contractCostCenter
	}

	private static ContractCostCenter getContractCostCenter(String CompModel,String CostCenter) {

		ContractCostCenter contractCostCenter=new ContractCostCenter()
		HashMap<String,String> hmRL=new HashMap<String,String>()

		hmRL=CostCenterPageSteps.getRegionLocationforHIICCID(CostCenter.split('-').getAt(0))
		//println hmRL.get('Region')
		//println hmRL.get('Location')

		contractCostCenter.CostCenter=hmRL.get('CostCenter')
		contractCostCenter.CostCenterRegion=hmRL.get('Region')
		contractCostCenter.CostCenterLocation=hmRL.get('Location')
		//contractCostCenter.AllowPEoutsideCD=GeneralSettingsSteps.getAllowPayElementsDatesoutsideContractDates(hmRL.get('Region'),hmRL.get('Location'))
		WebUI.delay(3)
		contractCostCenter.CompModel=CompModel +" - "+contractCostCenter.CostCenter+'-'+getBaseSteps().getselectedControlDropdowm('ddlCurrentYear', pageName.ManageProviderContract)

		contractCostCenter.noofPayElements=getBaseSteps().getCountofControl('lblPayElementDesc',pageName.ManageProviderContract)
		contractCostCenter.lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
		String PayElement
		HashMap<String, ContractPayElement> hmContractPayElement=new HashMap<String, ContractPayElement>();

		for(int i=0;i<contractCostCenter.noofPayElements;i++){
			PayElement=getBaseSteps().getTextControls('lblPayElementDesc',i,pageName.ManageProviderContract)
			//println PayElement
			hmContractPayElement.put(PayElement,getContractPayElement(i))
		}
		contractCostCenter.HMContractPayElement=hmContractPayElement
		return contractCostCenter
	}

	private static ContractCostCenter getContractCostCenter() {
		ContractCostCenter contractCostCenter=new ContractCostCenter()

		contractCostCenter.noofPayElements=getBaseSteps().getCountofControl('lblPayElementDesc',pageName.ManageProviderContract)
		contractCostCenter.lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
		String PayElement
		HashMap<String, ContractPayElement> hmContractPayElement=new HashMap<String, ContractPayElement>();

		for(int i=0;i<contractCostCenter.noofPayElements;i++){
			PayElement=getBaseSteps().getTextControls('lblPayElementDesc',i,pageName.ManageProviderContract)
			//	println PayElement
			hmContractPayElement.put(PayElement,getContractPayElement(i))
		}
		contractCostCenter.HMContractPayElement=hmContractPayElement
		return contractCostCenter
	}

	private static ContractPayElement getContractPayElement(int index) {
		ContractPayElement contractPayElement=new ContractPayElement()

		contractPayElement.StartDate=getBaseSteps().getValueControls('txtPayElementStartDate',index,pageName.ManageProviderContract)
		contractPayElement.EndDate=getBaseSteps().getValueControls('txtPayElementEndDate',index,pageName.ManageProviderContract)
		contractPayElement.PayElementType=getBaseSteps().getTextControls('lblPayElementType',index,pageName.ManageProviderContract)
		contractPayElement.PayFrequency=getBaseSteps().getSelectedDropDownControls('ddlPayElementPayFrequency',index,pageName.ManageProviderContract)
		contractPayElement.AmountType=getBaseSteps().getSelectedDropDownControls('ddlPayElementAmountType',index,pageName.ManageProviderContract)
		switch(contractPayElement.AmountType){
			case'Rate':contractPayElement.AmountRate=getBaseSteps().getValueControls('txtPayElementAnnAmountRate',index,pageName.ManageProviderContract)
				contractPayElement.Unit=getBaseSteps().getSelectedDropDownControls('ddlPayElementUnit',index,pageName.ManageProviderContract)
				contractPayElement.ThresholdUnits=getBaseSteps().getValueControls('txtPayElementThresholdUnits',index,pageName.ManageProviderContract)
				break
			case'Amount':contractPayElement.ThresholdAmount=getBaseSteps().getValueControls('txtPayElementThresholdAmount',index,pageName.ManageProviderContract)
				break
		}
		contractPayElement.ThresholdFrequency=getBaseSteps().getSelectedDropDownControls('ddlPayElementThresholdFrequency',index,pageName.ManageProviderContract)
		contractPayElement.GLAccNo=getBaseSteps().getValueControls('txtPayElementGLAccNo',index,pageName.ManageProviderContract)
		contractPayElement.LocationCostCenter=getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,pageName.ManageProviderContract)
		contractPayElement.Active=getBaseSteps().isCheckedControls('chkPayElementActive',index,pageName.ManageProviderContract)

		return contractPayElement
	}

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

	public static void selectCurrentYear(String contractYear) {
		getBaseSteps().scrollUp()
		getBaseSteps().selectByVisibleText('ddlCurrentYear', contractYear, pageName.ManageProviderContract)
		getBaseSteps().waitforLoadingComplete('imgLoading',30, pageName.CMN)
	}

	public static void selectCompensationModelTab(String CompensationModel) {
		List<String> lstCompModel=new ArrayList<String>()
		lstCompModel=getBaseSteps().getTabsNameFromControl('tabContracts',pageName.ManageProviderContract)

		for(String CompModel:lstCompModel) {

			getBaseSteps().scrollUp()
			if(CompModel.endsWith(CompensationModel))
				getBaseSteps().selectTabFromControl('tabContracts', CompModel, pageName.ManageProviderContract)
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectTabCostCenter(String CostCenter) {
		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getBaseSteps().getTabsNameFromControl('tabCostCenters',pageName.ManageProviderContract)

		for(String CC:lstCostCenter) {

			if(CC.contains(CostCenter))
				getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, pageName.ManageProviderContract)
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectTabCompensationModel(String CompensationModel) {
		getBaseSteps().scrollUp()

	}

	public static String getMaxCompensation() {
		return getBaseSteps().getValueFromControl('txtContractMaxCompensation', pageName.ManageProviderContract)
	}

	public static boolean verifyValidContractWithDate(String Provider,String ServiceDate) {
		boolean blnDate=false
		openManageProviderContract_newTab()
		setProviderID(Provider)
		editProviderContract()
		List<String> lstMasterContract=new ArrayList<String>();
		lstMasterContract=getMasterContracts()
		for(String masterContract:lstMasterContract) {
			selectMasterContract(masterContract)
			List<String> lstCurrentYear=new ArrayList<String>();
			lstCurrentYear=currentYear
			for(String currentYear:lstCurrentYear) {
				selectCurrentYear(currentYear)
				List<String> lstContractTabs=new ArrayList<String>();
				lstContractTabs=getContractTabName()
				for(String contractTab:lstContractTabs) {
					selectCompensationModelTab(contractTab)
					String ContractStartDate=this.getContractStartDate()
					String ContractEndDate=this.getContractEndDate()
					getContractMarkCompleteStatus()
					if(DateTimeUtil.verifyDateInbetween(ContractStartDate, ContractEndDate, ServiceDate) && getContractMarkCompleteStatus())
						blnDate=true
				}

			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return blnDate
	}




	/********************************************************************************************************************************************************************************/

	// COMMON DEPENDENCY METHODS//

	/********************************************************************************************************************************************************************************/
	//Verify whether Provider has Valid Contract
	public static boolean VerifyProviderHasContractWithMarkCompleteStatus(String Provider) {
		boolean blnValidContract
		gotoManageProviderContract()
		setProviderID(Provider)
		if(blnProvider)
		{
			editProviderContract()
			List<String> lstMasterContract=new ArrayList<String>();
			lstMasterContract=getMasterContracts()
			for(String masterContract:lstMasterContract) {
				selectMasterContract(masterContract)
				List<String> lstCurrentYear=new ArrayList<String>();
				lstCurrentYear=currentYear
				for(String currentYear:lstCurrentYear) {
					selectCurrentYear(currentYear)
					List<String> lstContractTabs=new ArrayList<String>();
					lstContractTabs=getContractTabName()
					for(String contractTab:lstContractTabs) {
						selectCompensationModelTab(contractTab)
						if(getContractMarkCompleteStatus())
							blnValidContract=true
					}

				}
			}
		}
		return 	blnValidContract
	}

	public static boolean VerifyContractWithMarkCompleteStatus(String Provider) {
		boolean blnProvider=false
		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear
		contractData = getContractDetailsMarkCompleted(Provider)
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

	public static List<String> getLocationsMappedtoMarkCompletedContract(String Provider){
		List<String> lstLocations=new ArrayList<String>()
		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear
		contractData = getContractDetailsMarkCompleted(Provider)
		for(String currentYear:contractData.CurrentYear)
		{
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				if(contractCompModel.ContractStatus.equals('Checked'))
					lstLocations.add(contractCompModel.Location)
			}
		}

		return lstLocations

	}

	public static HashMap<String,String> getMaxCompensationAndThresholdAmount(String Provider,String CompensationModel,String PayElement) {

		String MaxCompensation,ThresholdAmount
		String AmountType,AmountRate,Unit,ThresholdUnits
		String ContractStartDate,ContractEndDate
		HashMap<String,String> ContractAmountDetails=new HashMap<String,String>()
		openManageProviderContract_newTab()
		setProviderID(Provider)
		editProviderContract()
		List<String> lstMasterContract=new ArrayList<String>();
		lstMasterContract=getMasterContracts()
		for(String masterContract:lstMasterContract) {
			selectMasterContract(masterContract)
			List<String> lstCurrentYear=new ArrayList<String>();
			lstCurrentYear=currentYear
			for(String currentYear:lstCurrentYear) {
				selectCurrentYear(currentYear)
				List<String> lstContractTabs=new ArrayList<String>();
				lstContractTabs=getContractTabName()
				for(String contractTab:lstContractTabs) {
					if(contractTab.endsWith(CompensationModel))
					{
						selectCompensationModelTab(contractTab)
						if(getContractMarkCompleteStatus())
						{
							ContractStartDate=getContractStartDate()
							ContractEndDate=getContractEndDate()
							MaxCompensation=getBaseSteps().getValueFromControl('txtContractMaxCompensation', pageName.ManageProviderContract)
							List<String> lstCostCenters=new ArrayList<String>();
							lstCostCenters=getCostCenterTabName()
							for(String costCenter:lstCostCenters) {
								getBaseSteps().scrollDown()
								getBaseSteps().selectTabFromControl(tabCostCenters, costCenter, pageName.ManageProviderContract)
								List<String> lstPayElements=new ArrayList<String>()
								lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
								int index=0
								for(String cPayElement:lstPayElements)
								{
									if(PayElement.equals(cPayElement.split(' - ')[0].trim())) {
										AmountType=getBaseSteps().getSelectedDropDownControls('ddlPayElementAmountType',index,pageName.ManageProviderContract)
										switch(AmountType){
											case'Rate':AmountRate=getBaseSteps().getValueControls('txtPayElementAnnAmountRate',index,pageName.ManageProviderContract)
												Unit=getBaseSteps().getSelectedDropDownControls('ddlPayElementUnit',index,pageName.ManageProviderContract)
												ThresholdUnits=getBaseSteps().getValueControls('txtPayElementThresholdUnits',index,pageName.ManageProviderContract)
												break
											case'Amount':ThresholdAmount=getBaseSteps().getValueControls('txtPayElementThresholdAmount',index,pageName.ManageProviderContract)
												break
										}
									}
									index++
								}
							}
						}
					}
				}
			}
		}
		ContractAmountDetails.put('ContractPeriod', ContractStartDate+' - '+ContractEndDate)
		ContractAmountDetails.put('MaxCompensation', MaxCompensation)
		ContractAmountDetails.put('ThresholdAmount', ThresholdAmount)
		ContractAmountDetails.put('AmountRate', AmountRate)
		ContractAmountDetails.put('Unit', Unit)
		ContractAmountDetails.put('ThresholdUnits', ThresholdUnits)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		return ContractAmountDetails

	}

	public static Set<String> getProviders(){}

	public static void selectCostCentersByOffsetLocation(String CostCenter) {
		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getBaseSteps().getTabsNameFromControl('tabCostCenters',pageName.ManageProviderContract)

		for(String CC:lstCostCenter) {
			if(CC.contains(CostCenter))
				try {
					getBaseSteps().scrollDown()
					getBaseSteps().selectTabFromControl('tabCostCenters', CostCenter, 'ManageProviderContractPage')
				}catch(ElementClickInterceptedException e) {
					getBaseSteps().moveToControl('ddlbtnCostCenterTab', pageName.ManageProviderContract)
					getBaseSteps().clickControlJavaScriptExecutor(ddlbtnCostCenterTab, pageName.ManageProviderContract)
					Thread.sleep(20)
					getBaseSteps().clickControlJavaScriptExecutor('ddlCostCenterTabClearAll', pageName.ManageProviderContract)
					Thread.sleep(20)
					getBaseSteps().setTextToControl('ddltxtCostCenterTab', CostCenter, pageName.ManageProviderContract)
					Thread.sleep(20)
					getBaseSteps().clickControlJavaScriptExecutor(ddllblCostCenterTab, pageName.ManageProviderContract)
					Thread.sleep(20)
					//getBaseSteps().clickLabelStartswithtextJS(ddllblCostCenterTab, CostCenter, pageName.ManageProviderContract)
					getBaseSteps().selectTabFromControlJSExecutor('tabCostCenters', CostCenter, 'ManageProviderContractPage')
				}finally{
					getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
				}
		}
	}

	public static HashMap<String,String> getGLAccNoHIICCIDWRTPayElementCostCenter(String Provider,String PayElement,String CostCenter) {
		
		String contractCostCenter=CostCenterPageSteps.getHIICCIDCostCenterShortNameforCostCenterName(CostCenter)
		String contractHIICCID=CostCenterPageSteps.getHIICCIDforCostCenterName(CostCenter)
		
		HashMap<String,String> hmGLAccNoHIICCID=new HashMap<String,String>()
		List<HashMap> lsthmContractDetails=new ArrayList<>()
		openManageProviderContract_newTab()
		setProviderID(Provider)
		editProviderContract()
		List<String> lstCurrentYear = new ArrayList<String>()
		lstCurrentYear = getCurrentYear()
		String PositionLevel
		String EmployeeType
		String Location
		String Specialty
		for (String currentYear : lstCurrentYear) {
			selectCurrentYear(currentYear)
			PositionLevel=getPosition()
			EmployeeType=getEmployeeType()
			List<String> lstCompModels = new ArrayList<String>()
			if (isCompensationModelTabsClickable()) {
				lstCompModels = getCompModelsTabs()
				for (String CompensationModel : lstCompModels) {
					Location=getLocation()
					Specialty=getSpecialty()
					selectCompensationModelTab(CompensationModel)
					List<String> lstCostCenters=new ArrayList<String>();
					lstCostCenters=getCostCenterTabName()
					for(String costCenter:lstCostCenters) {
						selectCostCentersByOffsetLocation(costCenter)
						List<String> lstPayElements=new ArrayList<String>()
						lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
						int index=0
						for(String cPayElement:lstPayElements)
						{
							index=lstPayElements.indexOf(cPayElement)
							String GLAccNo=getBaseSteps().getValueControls('txtPayElementGLAccNo',index,pageName.ManageProviderContract)
							String HIICCID=getBaseSteps().getValueControls('txtPayElementLocationCostCenter',index,pageName.ManageProviderContract)
							HashMap<String,String> hmContractDetails=new HashMap<>()
							hmContractDetails.put('CurrentYear', currentYear)
							hmContractDetails.put('CompensationModel', CompensationModel)
							hmContractDetails.put('CostCenter', costCenter)
							hmContractDetails.put('PayElement', cPayElement)
							hmContractDetails.put('GLAccNo', GLAccNo)
							hmContractDetails.put('HIICCID', HIICCID)
							hmContractDetails.put('PositionLevel', PositionLevel)
							hmContractDetails.put('EmployeeType', EmployeeType)
							hmContractDetails.put('Location', Location)
							hmContractDetails.put('Specialty', Specialty)
							lsthmContractDetails.add(hmContractDetails)
						}
					}
				}
			}

		}

		
		for(HashMap<String,String> hmContractDetails:lsthmContractDetails) {

			String hmPayElement=hmContractDetails.get('PayElement').split('-')[0].trim()
			String hmCostCenter=hmContractDetails.get('CostCenter').trim()


			if(hmPayElement.equals(PayElement) && hmCostCenter.equals(contractCostCenter)) {
				hmGLAccNoHIICCID.put('GLAccNo', hmContractDetails.get('GLAccNo'))
				hmGLAccNoHIICCID.put('Location',hmContractDetails.get('Location'))
				hmGLAccNoHIICCID.put('Specialty',hmContractDetails.get('Specialty'))
				hmGLAccNoHIICCID.put('CompensationModel',hmContractDetails.get('CompensationModel').substring(hmContractDetails.get('CompensationModel').lastIndexOf('-')+1).trim())
				hmGLAccNoHIICCID.put('PositionLevel',hmContractDetails.get('PositionLevel'))
				hmGLAccNoHIICCID.put('EmployeeType',hmContractDetails.get('EmployeeType'))
				hmGLAccNoHIICCID.put('HIICCID', contractHIICCID)

			}
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return hmGLAccNoHIICCID
	}


	public static Set<String> getListOfPayElementsMappedToProviderContract(String Provider,String Year){
		Set<String> PayElements=new HashSet<>()
		openManageProviderContract_newTab()
		setProviderID(Provider)
		editProviderContract()
		List<String> lstCurrentYear = new ArrayList<String>()
		lstCurrentYear = getCurrentYear()
		if(!lstCurrentYear.contains(Year))
			throw new HMException('Provider :'+Provider+' has no Contract for Year :'+Year)
		selectCurrentYear(Year)
		List<String> lstCompModels = new ArrayList<String>()
		if (isCompensationModelTabsClickable()) {
			lstCompModels = getCompModelsTabs()
			for (String CompensationModel : lstCompModels) {
				selectCompensationModelTab(CompensationModel)
				List<String> lstCostCenters=new ArrayList<String>();
				lstCostCenters=getCostCenterTabName()
				for(String costCenter:lstCostCenters) {
					selectCostCentersByOffsetLocation(costCenter)
					List<String> lstPayElements=new ArrayList<String>()
					lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
					for(String cPayElement:lstPayElements)
					{
						PayElements.add(cPayElement.split('-')[0].trim())
					}
				}
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return PayElements
	}

	public static List<HashMap> getPaymentDetailsMappedToProviderContract(String Provider,String Year){
		String flagSetting=GeneralSettingsSteps.getAllowtoGroupContractPayElementsbasedonCostCenter()
		List<HashMap> PaymentDetails=new ArrayList<>()
		int index=0
		openManageProviderContract_newTab()
		setProviderID(Provider)
		editProviderContract()
		List<String> lstCurrentYear = new ArrayList<String>()
		lstCurrentYear = getCurrentYear()
		if(!lstCurrentYear.contains(Year))
			throw new HMException('Provider :'+Provider+' has no Contract for Year :'+Year)
		selectCurrentYear(Year)
		List<String> lstCompModels = new ArrayList<String>()
		if (isCompensationModelTabsClickable()) {
			lstCompModels = getCompModelsTabs()
			for (String CompensationModel : lstCompModels) {
				selectCompensationModelTab(CompensationModel)
				String MaxCompensation=getMaxCompensation().replace(',', '')

				if(flagSetting.equals(HIIConstants.Yes))
				{
					List<String> lstCostCenters=new ArrayList<String>();
					lstCostCenters=getCostCenterTabName()
					for(String costCenter:lstCostCenters) {
						selectCostCentersByOffsetLocation(costCenter)
						List<String> lstPayElements=new ArrayList<String>()
						lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
						for(String cPayElement:lstPayElements)
						{
							index=lstPayElements.indexOf(cPayElement)
							String PayElement=cPayElement.split('-')[0].trim()
							HashMap<String,String> ContractDetails=new HashMap<>()
							String AnnAmountRate=getBaseSteps().getValueControls(txtPayElementAnnAmountRate,index,pageName.ManageProviderContract)
							String ThresholdAmount=getBaseSteps().getValueControls(txtPayElementThresholdAmount,index,pageName.ManageProviderContract)
							String PayElementStartDate=getBaseSteps().getValueControls(txtPayElementStartDate,index,pageName.ManageProviderContract)
							String PayElementEndDate=getBaseSteps().getValueControls(txtPayElementEndDate,index,pageName.ManageProviderContract)
							String PayElementPayFrequency=getBaseSteps().getSelectedDropDownControls(ddlPayElementPayFrequency, index, pageName.ManageProviderContract)
							ContractDetails.put('CompensationModel', CompensationModel)
							ContractDetails.put('MaxCompensation', MaxCompensation)
							ContractDetails.put('CostCenter', costCenter)
							ContractDetails.put('PayElement', PayElement)
							ContractDetails.put('PayElementStartDate', PayElementStartDate)
							ContractDetails.put('PayElementEndDate', PayElementEndDate)
							ContractDetails.put('PayElementPayFrequency', PayElementPayFrequency)
							ContractDetails.put('AnnAmountRate', AnnAmountRate)
							ContractDetails.put('ThresholdAmount', ThresholdAmount)
							PaymentDetails.add(ContractDetails)
						}
					}
				}else {
					String CostCenter
					/*
					try {
						getBaseSteps().waitForControlDisplay(lblCostCenter, 50, pageName.ManageProviderContract)
						CostCenter=getBaseSteps().getTextFromControl(lblCostCenter, pageName.ManageProviderContract)
					}catch(Exception e) {
						CostCenter=getBaseSteps().getTextFromControl(lnkCostCenter, pageName.ManageProviderContract)
					}
					*/
					CostCenter=getBaseSteps().getTextFromControl(lnkCostCenter, pageName.ManageProviderContract)
					List<String> lstPayElements=new ArrayList<String>()
					lstPayElements=getBaseSteps().getControlsName('lblPayElementDesc', pageName.ManageProviderContract)
					for(String cPayElement:lstPayElements)
					{
						index=lstPayElements.indexOf(cPayElement)
						String PayElement=cPayElement.split('-')[0].trim()
						HashMap<String,String> ContractDetails=new HashMap<>()
						String AnnAmountRate=getBaseSteps().getValueControls(txtPayElementAnnAmountRate,index,pageName.ManageProviderContract)
						String ThresholdAmount=getBaseSteps().getValueControls(txtPayElementThresholdAmount,index,pageName.ManageProviderContract)
						ContractDetails.put('CompensationModel', CompensationModel)
						ContractDetails.put('MaxCompensation', MaxCompensation)
						ContractDetails.put('CostCenter', CostCenter)
						ContractDetails.put('PayElement', PayElement)
						ContractDetails.put('AnnAmountRate', AnnAmountRate)
						ContractDetails.put('ThresholdAmount', ThresholdAmount)
						PaymentDetails.add(ContractDetails)
					}
				}

			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoLatestWindow()
		return PaymentDetails
	}

}

