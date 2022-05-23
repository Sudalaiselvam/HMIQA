package pages

import core.BaseSteps
import core.ControlFactory
import core.AssertSteps
import org.testng.SkipException
import testDataTypes.ProviderData
import configs.PageLocatorReader as pageName
import configs.HIIConstants
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil as log
import utils.CommonUtilities
import utils.ApplicationUtilities
import utils.Utilities
import utils.ExcelUtilities
import core.Logger
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


/**
 * @author AnilKumarJanapareddy
 *
 */
public class ProviderSetupSteps {

	/**
	 * @return
	 */
	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//============== Provider Web Elements =================================
	private static final String txtProviderSearch='txtProviderSearch'
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnSearch='btnSearch'
	private static final String btnSearchClear='btnSearchClear'
	private static final String imgExcelDn='imgExcelDn'
	private static final String btnCreateProvider='btnCreateProvider'
	private static final String grdProviderDetails='grdProviderDetails'
	private static final String btnBacktoProviders='btnBacktoProviders'
	private static final String txtFirstName='txtFirstName'
	private static final String txtMiddleName='txtMiddleName'
	private static final String txtLastName='txtLastName'
	private static final String txtSSN='txtSSN'
	private static final String txtDateOfBirth='txtDateOfBirth'
	private static final String txtPreferredContactNo='txtPreferredContactNo'
	private static final String txtSecondaryContactNo='txtSecondaryContactNo'
	private static final String txtEmail='txtEmail'
	private static final String txtNPINumber='txtNPINumber'
	private static final String txtStreetAddress='txtStreetAddress'
	private static final String txtCity='txtCity'
	private static final String ddlState='ddlState'
	private static final String txtZipCode='txtZipCode'
	private static final String ddlRegion='ddlRegion'
	private static final String ddlLocation='ddlLocation'
	private static final String ddlPrimaryCostCenter='ddlPrimaryCostCenter'
	private static final String ddlProviderGroup='ddlProviderGroup'
	private static final String ddlPositionLevel='ddlPositionLevel'
	private static final String ddlPrimarySpecialty='ddlPrimarySpecialty'
	private static final String ddlSpecialtyGroup='ddlSpecialtyGroup'
	private static final String txtPayrollID='txtPayrollID'
	private static final String txtProviderID='txtProviderID'
	private static final String txtEMRID='txtEMRID'
	private static final String txtSupervisorLead='txtSupervisorLead'
	private static final String txtDirector='txtDirector'
	private static final String txtPracMgrLead='txtPracMgrLead'
	private static final String txtAdminDirector='txtAdminDirector'
	private static final String txtPracticeLocationCostCenterID='txtPracticeLocationCostCenterID'
	private static final String ddlSecondaryCostCenter1='ddlSecondaryCostCenter1'
	private static final String ddlSecondaryCostCenter2='ddlSecondaryCostCenter2'
	private static final String txtHiringReq='txtHiringReq'
	private static final String txtCredentialingID='txtCredentialingID'
	private static final String txtBudgetedHours='txtBudgetedHours'
	private static final String txtHourlyRate='txtHourlyRate'
	private static final String txtDEALicense='txtDEALicense'
	private static final String txtDEALicenseRenewalDate='txtDEALicenseRenewalDate'
	private static final String ddlProviderTitle='ddlProviderTitle'
	private static final String txtAccrualAccountNumber='txtAccrualAccountNumber'
	private static final String txtSchedulingID='txtSchedulingID'
	private static final String txtFTE='txtFTE'
	private static final String txtExperienceasofDate='txtExperienceasofDate'
	private static final String txtExperienceYears='txtExperienceYears'
	private static final String txtExperienceMonths='txtExperienceMonths'
	private static final String ddlVisaStatus='ddlVisaStatus'
	private static final String txtVisaEndDate='txtVisaEndDate'
	private static final String ddlEmployeeStatus='ddlEmployeeStatus'
	private static final String txtHireDate='txtHireDate'
	private static final String txtTerminationNoticeGivenOn='txtTerminationNoticeGivenOn'
	private static final String txtTerminationDate='txtTerminationDate'
	private static final String ddlEmploymentType='ddlEmploymentType'
	private static final String ddlSubCategory='ddlSubCategory'
	private static final String chkDisableAlert='chkDisableAlert'
	private static final String chkOnboardingCompleted='chkOnboardingCompleted'
	private static final String txtOnboardingCompletedDate='txtOnboardingCompletedDate'
	private static final String chkIsBoardEligible='chkIsBoardEligible'
	private static final String ddlEmployeeType='ddlEmployeeType'
	private static final String chkIsBoardCertified='chkIsBoardCertified'
	private static final String chkActive='chkActive'
	private static final String txtNotes='txtNotes'
	private static final String btnSave='btnSave'
	private static final String btnProviderDetailsClear='btnProviderDetailsClear'
	private static final String lblSuccess='lblSuccess'
	private static final String grdProviderDetailsHeaders='grdProviderDetailsHeaders'
	private static final String lblOrganization='lblOrganization'
	private static final String btnClear='btnClear'
	private static final String displayMsg='displayMsg'
	private static final String validationSummary='validationSummary'
	private static final String btnDelete='btnDelete'


	//================== Navigate to Provider ================================

	public static void gotoProviderSetup() {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderSetup', pageName.Header)
	}

	public static void openProviderSetup_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuProvider', 'mnuProviderSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static boolean isProviderSearchTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtProviderSearch, pageName.ProviderSetup)
	}

	public static String getProviderSearchTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtProviderSearch, pageName.ProviderSetup)
	}

	public static void verifyProviderSearchTextBoxUI() {

		boolean blnDisplayed=isProviderSearchTextBoxDisplayed()
		'Verifying Provider Search textbox whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Provider Search TextBox Displayed', 'Provider Search TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Provider Search textBox background text'
			String ExpectedPlaceHolder=HIIConstants.PS_ProviderSearchPlaceHolder
			String ActualPlaceHolder=getProviderSearchTextBoxBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Provider Search TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isUniversalSearchTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtUniversalSearch, pageName.ProviderSetup)
	}

	public static String getUniversalSearchTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtUniversalSearch, pageName.ProviderSetup)
	}

	public static void verifyUniversalSearchTextBoxUI() {

		boolean blnDisplayed=isUniversalSearchTextBoxDisplayed()
		'Verifying Universal Search textbox whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Universal Search TextBox Displayed', 'Universal Search TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Universal Search textBox background text'
			String ExpectedPlaceHolder=HIIConstants.PS_UniversalSearchPlaceHolder
			String ActualPlaceHolder=getUniversalSearchTextBoxBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Universal Search TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isSearchButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnSearch, pageName.ProviderSetup)
	}

	public static String getSearchButtonText() {
		return getBaseSteps().getValueFromControl(btnSearch, pageName.ProviderSetup)
	}

	public static void verifySearchButtonUI() {

		boolean blnDisplayed=isSearchButtonDisplayed()
		'Verifying Search Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Search Button Displayed', 'Search Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Search Button text'
			String ExpectedText=HIIConstants.PS_SearchButtonText
			String ActualText=getSearchButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Search Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isSearchClearButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnSearchClear, pageName.ProviderSetup)
	}

	public static String getSearchClearButtonText() {
		return getBaseSteps().getValueFromControl(btnSearchClear, pageName.ProviderSetup)
	}

	public static void verifySearchClearButtonUI() {

		boolean blnDisplayed=isSearchClearButtonDisplayed()
		'Verifying Search Clear Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Search Clear Button Displayed', 'Search Clear Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
		{
			'Verifying Search Clear Button text'
			String ExpectedText=HIIConstants.PS_SearchClearButtonText
			String ActualText=getSearchClearButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Search Clear Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isExportExcelDisplayed() {
		return getBaseSteps().WebElementDisplayed(imgExcelDn, pageName.ProviderSetup)
	}

	public static void verifyExportExcelImageUI() {

		'Verifying Export Excel Image whether displayed or not'
		AssertSteps.verifyActualResult(isExportExcelDisplayed(), 'Export Excel Image Displayed', 'Export Excel Image is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isCreateProviderButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnCreateProvider, pageName.ProviderSetup)
	}

	public static String getCreateProviderButtonText() {
		return getBaseSteps().getTextFromControl(btnCreateProvider, pageName.ProviderSetup)
	}

	public static void verifyCreateProviderButtonUI() {

		boolean blnDisplayed=isCreateProviderButtonDisplayed()
		'Verifying Create Provider Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Create Provider Button Displayed', 'Create Provider Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
		{
			'Verifying Create Provider Button text'
			String ExpectedText=HIIConstants.PS_CreateProviderButtonText
			String ActualText=getCreateProviderButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Create Provider Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isPhysicianDetailsGridDisplayed() {
		return getBaseSteps().WebElementDisplayed(grdProviderDetails, pageName.ProviderSetup)
	}

	public static List<String> getPhysicianDetailsGridColumnHeadings() {
		List<String> colHeadings=new ArrayList<String>()
		colHeadings=getBaseSteps().getTableHeadingsWithSortingTag(grdProviderDetailsHeaders, pageName.ProviderSetup)
		return colHeadings
	}

	public static void verifyPhysicianDetailsGridUI() {

		boolean blnDisplayed=isPhysicianDetailsGridDisplayed()
		'Verifying Physician Details Grid whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Create Provider Button Displayed', 'Create Provider Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
		{
			'Verifying Physician Details Grid Headings'
			List<String> gridHeadings=new ArrayList<String>()
			gridHeadings=getPhysicianDetailsGridColumnHeadings()
			List<String> expGridHeadings=new ArrayList<String>()
			expGridHeadings=HIIConstants.PhysicianDetailsGridColumnHeadings()
			for(String gridHeading:expGridHeadings)
				AssertSteps.verifyActualResult(gridHeadings.contains(gridHeading), gridHeading+' - heading contains in Physician Details Grid', gridHeading+' - heading is expected in Physician Details Grid', FailureHandling.CONTINUE_ON_FAILURE)

		}

	}

	public static boolean isOrganizationLabelDisplayed() {
		return getBaseSteps().WebElementDisplayed(lblOrganization, pageName.ProviderSetup)
	}

	public static String getOrganizationText() {
		return getBaseSteps().getTextFromControl(lblOrganization, pageName.ProviderSetup)
	}

	public static void verifyOrganizationLabelUI(String ExpectedOrgName) {
		boolean blnDisplayed=isOrganizationLabelDisplayed()
		'Verifying Organization Label whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Organization Label Displayed', 'Organization Label is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			String ActualOrgName=getOrganizationText()
			'Verifying Organization Name'
			boolean blnCondition=ActualOrgName.equals(ExpectedOrgName)
			String AssertMsg='Organization Name Validation - Expected : '+ExpectedOrgName+' and Actual : '+ActualOrgName
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isBacktoProvidersButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnBacktoProviders, pageName.ProviderSetup)
	}

	public static String getBacktoProvidersButtonText() {
		return getBaseSteps().getTextFromControl(btnBacktoProviders, pageName.ProviderSetup)
	}

	public static void verifyBacktoProvidersButtonUI() {

		boolean blnDisplayed=isBacktoProvidersButtonDisplayed()
		'Verifying Back to Providers Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Back to Providers Button Displayed', 'Back to Providers Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
		{
			'Verifying Back to Providers Button text'
			String ExpectedText=HIIConstants.PS_BacktoProvidersButtonText
			String ActualText=getBacktoProvidersButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Back to Provider Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isFirstNameTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtFirstName, pageName.ProviderSetup)
	}

	public static boolean isMiddleNameTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtMiddleName, pageName.ProviderSetup)
	}

	public static boolean isLastNameTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtLastName, pageName.ProviderSetup)
	}

	public static boolean isSSNTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtSSN, pageName.ProviderSetup)
	}

	public static boolean isDateOfBirthTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtDateOfBirth, pageName.ProviderSetup)
	}

	public static String getDateOfBirthTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtDateOfBirth, pageName.ProviderSetup)
	}

	public static String getDateOfBirthTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtDateOfBirth, pageName.ProviderSetup)
	}

	public static String getNPINumberTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtNPINumber, pageName.ProviderSetup)
	}

	public static String getSSNTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtSSN, pageName.ProviderSetup)
	}

	public static boolean isPreferredContactNoTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtPreferredContactNo, pageName.ProviderSetup)
	}

	public static boolean isSecondaryContactNoTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtSecondaryContactNo, pageName.ProviderSetup)
	}

	public static boolean isEmailTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtEmail, pageName.ProviderSetup)
	}

	public static boolean isNPINumberTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtNPINumber, pageName.ProviderSetup)
	}

	public static boolean isStreetAddressTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtStreetAddress, pageName.ProviderSetup)
	}

	public static boolean isCityTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtCity, pageName.ProviderSetup)
	}

	public static boolean isStateDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlState, pageName.ProviderSetup)
	}

	public static boolean isZipCodeTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtZipCode, pageName.ProviderSetup)
	}

	public static void verifyPersonalDetailsUI() {
		'Verifying Personal UI WebElements whether displayed or not'
		AssertSteps.verifyActualResult(isFirstNameTextBoxDisplayed(), 'First Name TextBox Displayed', 'First Name TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(txtFirstName, pageName.ProviderSetup), 'First Name with Mandatory indication - PASS', 'First Name is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isMiddleNameTextBoxDisplayed(), 'Middle Name TextBox Displayed', 'Middle Name TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isLastNameTextBoxDisplayed(), 'Last Name TextBox Displayed', 'Last Name TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(txtLastName, pageName.ProviderSetup), 'Last Name with Mandatory indication - PASS', 'Last Name is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSSNTextBoxDisplayed(), 'SSN TextBox Displayed', 'SSN TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isDateOfBirthTextBoxDisplayed(), 'Date Of Birth TextBox Displayed', 'Date Of Birth TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isDateOfBirthTextBoxDisplayed()) {
			'Verifying Date Of Birth textBox background text'
			String ExpectedPlaceHolder=HIIConstants.DateTextBoxPlaceHolder
			String ActualPlaceHolder=getDateOfBirthTextBoxBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Date Of Birth TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isPreferredContactNoTextBoxDisplayed(), 'Preferred Contact No TextBox Displayed', 'Preferred Contact No TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSecondaryContactNoTextBoxDisplayed(), 'Secondary Contact No TextBox Displayed', 'Secondary Contact No TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isEmailTextBoxDisplayed(), 'E-mail TextBox Displayed', 'E-mail TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(txtEmail, pageName.ProviderSetup), 'Email with Mandatory indication - PASS', 'Email is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isNPINumberTextBoxDisplayed(), 'NPI Number TextBox Displayed', 'NPI Number TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isStreetAddressTextBoxDisplayed(), 'Street Address TextBox Displayed', 'Street Address TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isCityTextBoxDisplayed(), 'City TextBox Displayed', 'City TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isStateDropDownDisplayed(), 'State DropDown Displayed', 'State DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isZipCodeTextBoxDisplayed(), 'Zip Code TextBox Displayed', 'Zip Code TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isRegionDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ProviderSetup)
	}

	public static boolean isLocationDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlLocation, pageName.ProviderSetup)
	}

	public static boolean isPrimaryCostCenterDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlPrimaryCostCenter, pageName.ProviderSetup)
	}

	public static boolean isProviderGroupDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlProviderGroup, pageName.ProviderSetup)
	}

	public static boolean isProviderGroupDropDownEnabled() {
		return getBaseSteps().WebElementEnabled(ddlProviderGroup, pageName.ProviderSetup)
	}

	public static boolean isPositionLevelDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlPositionLevel, pageName.ProviderSetup)
	}

	public static boolean isPrimarySpecialtyDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlPrimarySpecialty, pageName.ProviderSetup)
	}

	public static boolean isSpecialtyGroupDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlSpecialtyGroup, pageName.ProviderSetup)
	}

	public static boolean isPayrollIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtPayrollID, pageName.ProviderSetup)
	}

	public static boolean isProviderIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtProviderID, pageName.ProviderSetup)
	}

	public static boolean isEMRIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtEMRID, pageName.ProviderSetup)
	}

	public static boolean isSupervisorLeadTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtSupervisorLead, pageName.ProviderSetup)
	}

	public static boolean isDirectorTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtDirector, pageName.ProviderSetup)
	}

	public static boolean isPracMgrLeadTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtPracMgrLead, pageName.ProviderSetup)
	}

	public static boolean isAdminDirectorTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtAdminDirector, pageName.ProviderSetup)
	}

	public static boolean isPracticeLocationCostCenterIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtPracticeLocationCostCenterID, pageName.ProviderSetup)
	}

	public static boolean isSecondaryCostCenter1DropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlSecondaryCostCenter1, pageName.ProviderSetup)
	}

	public static boolean isSecondaryCostCenter2DropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlSecondaryCostCenter2, pageName.ProviderSetup)
	}

	public static boolean isHiringReqTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtHiringReq, pageName.ProviderSetup)
	}

	public static boolean isCredentialingIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtCredentialingID, pageName.ProviderSetup)
	}

	public static boolean isBudgetedHoursTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtBudgetedHours, pageName.ProviderSetup)
	}

	public static boolean isHourlyRateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtHourlyRate, pageName.ProviderSetup)
	}

	public static boolean isDEALicenseTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtDEALicense, pageName.ProviderSetup)
	}

	public static boolean isDEALicenseRenewalDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtDEALicenseRenewalDate, pageName.ProviderSetup)
	}

	public static String getDEALicenseRenewalDateBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtDEALicenseRenewalDate, pageName.ProviderSetup)
	}

	public static boolean isProviderTitleDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlProviderTitle, pageName.ProviderSetup)
	}

	public static boolean isAccrualAccountNumberTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtDEALicenseRenewalDate, pageName.ProviderSetup)
	}

	public static boolean isSchedulingIDTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtSchedulingID, pageName.ProviderSetup)
	}

	public static boolean isFTETextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtFTE, pageName.ProviderSetup)
	}

	public static boolean isExperienceasofDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtExperienceasofDate, pageName.ProviderSetup)
	}

	public static String getExperienceasofDateBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtExperienceasofDate, pageName.ProviderSetup)
	}

	public static boolean isExperienceYearsTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtExperienceYears, pageName.ProviderSetup)
	}

	public static String getExperienceYearsBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtExperienceYears, pageName.ProviderSetup)
	}

	public static boolean isExperienceMonthsTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtExperienceMonths, pageName.ProviderSetup)
	}

	public static String getExperienceMonthsBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtExperienceMonths, pageName.ProviderSetup)
	}

	public static boolean isVisaStatusDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlVisaStatus, pageName.ProviderSetup)
	}

	public static boolean isVisaEndDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtVisaEndDate, pageName.ProviderSetup)
	}

	public static String getVisaEndDateBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtVisaEndDate, pageName.ProviderSetup)
	}

	public static void verifyProfessionalDetailsUI() {
		'Verifying Professional UI WebElements whether displayed or not'
		AssertSteps.verifyActualResult(isRegionDropDownDisplayed(), 'Region DropDown Displayed', 'Region DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlRegion, pageName.ProviderSetup), 'Region Drop Down with Mandatory indication - PASS', 'Region Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isLocationDropDownDisplayed(), 'Location DropDown Displayed', 'Location DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlLocation, pageName.ProviderSetup), 'Location Drop Down with Mandatory indication - PASS', 'Location Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPrimaryCostCenterDropDownDisplayed(), 'Primary Cost Center DropDown Displayed', 'Primary Cost Center DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlPrimaryCostCenter, pageName.ProviderSetup), 'Primary Cost Center Drop Down with Mandatory indication - PASS', 'Primary Cost Center Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isProviderGroupDropDownDisplayed(), 'Provider Group DropDown Displayed', 'Provider Group DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPositionLevelDropDownDisplayed(), 'Position Level DropDown Displayed', 'Position Level DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlPositionLevel, pageName.ProviderSetup), 'Position Level Drop Down with Mandatory indication - PASS', 'Position Level Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPrimarySpecialtyDropDownDisplayed(), 'Primary Specialty DropDown Displayed', 'Primary Specialty DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlPrimarySpecialty, pageName.ProviderSetup), 'Primary Specialty Drop Down with Mandatory indication - PASS', 'Primary Specialty Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSpecialtyGroupDropDownDisplayed(), 'Specialty Group DropDown Displayed', 'Specialty Groupy DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlSpecialtyGroup, pageName.ProviderSetup), 'Specialty Group Drop Down with Mandatory indication - PASS', 'Specialty Group Drop Down is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPayrollIDTextBoxDisplayed(), 'Payroll ID TextBox Displayed', 'Payroll ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(txtPayrollID, pageName.ProviderSetup), 'Payroll ID TextBox with Mandatory indication - PASS', 'Payroll ID TextBox is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isProviderIDTextBoxDisplayed(), 'Provider ID TextBox Displayed', 'Provider ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isEMRIDTextBoxDisplayed(), 'EMR ID TextBox Displayed', 'EMR ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSupervisorLeadTextBoxDisplayed(), 'Supervisor Lead TextBox Displayed', 'Supervisor Lead TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isDirectorTextBoxDisplayed(), 'Director TextBox Displayed', 'Director TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPracMgrLeadTextBoxDisplayed(), 'Practice Manager Lead TextBox Displayed', 'Practice Manager Lead TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isAdminDirectorTextBoxDisplayed(), 'Admin Director TextBox Displayed', 'Admin Director Lead TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isPracticeLocationCostCenterIDTextBoxDisplayed(), 'Practice Location Cost Center ID TextBox Displayed', 'Practice Location Cost Center ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSecondaryCostCenter1DropDownDisplayed(), 'Secondary Cost Center 1 DropDown Displayed', 'Secondary Cost Center 1 DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSecondaryCostCenter2DropDownDisplayed(), 'Secondary Cost Center 2 DropDown Displayed', 'Secondary Cost Center 2 DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isHiringReqTextBoxDisplayed(), 'Hiring Req # TextBox Displayed', 'Hiring Req # TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isCredentialingIDTextBoxDisplayed(), 'Credentialing ID TextBox Displayed', 'Credentialing ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isBudgetedHoursTextBoxDisplayed(), 'Budgeted Hours TextBox Displayed', 'Budgeted Hours TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isHourlyRateTextBoxDisplayed(), 'Hourly Rate TextBox Displayed', 'Hourly Rate TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isDEALicenseTextBoxDisplayed(), 'DEA License TextBox Displayed', 'DEA License TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isDEALicenseRenewalDateTextBoxDisplayed(), 'DEA License Renewal Date TextBox Displayed', 'DEA License Renewal Date TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isDEALicenseRenewalDateTextBoxDisplayed()) {
			'Verifying DEA License Renewal Date textBox background text'
			String ExpectedPlaceHolder=HIIConstants.DateTextBoxPlaceHolder
			String ActualPlaceHolder=getDEALicenseRenewalDateBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='DEA License Renewal Date TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isProviderTitleDropDownDisplayed(), 'Provider Title DropDown Displayed', 'Provider Title DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isAccrualAccountNumberTextBoxDisplayed(), 'Accrual Account Number TextBox Displayed', 'Accrual Account Number TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSchedulingIDTextBoxDisplayed(), 'Scheduling ID TextBox Displayed', 'Scheduling ID TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isFTETextBoxDisplayed(), 'FTE TextBox Displayed', 'FTE TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isExperienceasofDateTextBoxDisplayed(), 'Experience as of Date TextBox Displayed', 'Experience as of Date TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isExperienceasofDateTextBoxDisplayed()) {
			'Verifying Experience as of Date textBox background text'
			String ExpectedPlaceHolder=HIIConstants.DateTextBoxPlaceHolder
			String ActualPlaceHolder=getExperienceasofDateBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Experience as of Date TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isExperienceYearsTextBoxDisplayed(), 'Experience Years TextBox Displayed', 'Experience Years TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isExperienceYearsTextBoxDisplayed()) {
			'Verifying Experience Years textBox background text'
			String ExpectedPlaceHolder='Year(s)'
			String ActualPlaceHolder=getExperienceYearsBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Experience Years TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isExperienceMonthsTextBoxDisplayed(), 'Experience Months TextBox Displayed', 'Experience Months TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isExperienceMonthsTextBoxDisplayed()) {
			'Verifying Experience Months textBox background text'
			String ExpectedPlaceHolder='Month(s)'
			String ActualPlaceHolder=getExperienceMonthsBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Experience Months TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isVisaStatusDropDownDisplayed(), 'Visa Status DropDown Displayed', 'Visa Status DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isVisaEndDateTextBoxDisplayed(), 'Visa End Date TextBox Displayed', 'Visa End Date TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(isVisaEndDateTextBoxDisplayed()) {
			'Verifying Visa End Date textBox background text'
			String ExpectedPlaceHolder=HIIConstants.DateTextBoxPlaceHolder
			String ActualPlaceHolder=getVisaEndDateBackgroundText()
			boolean blnCondition=ActualPlaceHolder.equals(ExpectedPlaceHolder)
			String AssertMsg='Visa End Date TextBox Background Text Validation - Expected : '+ExpectedPlaceHolder+' and Actual : '+ActualPlaceHolder
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isEmployeeStatusDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlEmployeeStatus, pageName.ProviderSetup)
	}

	public static String getEmployeeStatusDropDownValue() {
		return getBaseSteps().getselectedControlDropdowm(ddlEmployeeStatus, pageName.ProviderSetup)
	}

	public static boolean isHireDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtHireDate, pageName.ProviderSetup)
	}

	public static String getHireDateTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtHireDate, pageName.ProviderSetup)
	}

	public static boolean isTerminationNoticeGivenOnTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtTerminationNoticeGivenOn, pageName.ProviderSetup)
	}

	public static String getTerminationNoticeGivenOnTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtTerminationNoticeGivenOn, pageName.ProviderSetup)
	}

	public static boolean isTerminationDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtTerminationDate, pageName.ProviderSetup)
	}

	public static String getTerminationDateTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtTerminationDate, pageName.ProviderSetup)
	}

	public static boolean isEmploymentTypeDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlEmploymentType, pageName.ProviderSetup)
	}

	public static boolean isSubCategoryDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlSubCategory, pageName.ProviderSetup)
	}

	public static boolean isDisableAlertCheckBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkDisableAlert, pageName.ProviderSetup)
	}

	public static boolean isOnboardingCompletedCheckBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkOnboardingCompleted, pageName.ProviderSetup)
	}

	public static boolean isOnboardingCompletedDateTextBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtOnboardingCompletedDate, pageName.ProviderSetup)
	}

	public static String getOnboardingCompletedDateTextBoxBackgroundText() {
		return getBaseSteps().getPlaceHolderOfControl(txtOnboardingCompletedDate, pageName.ProviderSetup)
	}

	public static boolean isIsBoardEligibleCheckBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkIsBoardEligible, pageName.ProviderSetup)
	}

	public static boolean isEmployeeTypeDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlEmployeeType, pageName.ProviderSetup)
	}

	public static String getEmployeeTypeDropDownValue() {
		return getBaseSteps().getselectedControlDropdowm(ddlEmployeeType, pageName.ProviderSetup)
	}

	public static boolean isIsBoardCertifiedCheckBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkIsBoardCertified, pageName.ProviderSetup)
	}

	public static boolean isActiveCheckBoxDisplayed() {
		return getBaseSteps().WebElementDisplayed(chkActive, pageName.ProviderSetup)
	}

	public static boolean isNotesTextAreaDisplayed() {
		return getBaseSteps().WebElementDisplayed(txtNotes, pageName.ProviderSetup)
	}

	public static void verifyStatusDetailsUI() {
		boolean blnValidation

		blnValidation=isEmployeeStatusDropDownDisplayed()
		'Verifying Status UI WebElements whether displayed or not'
		AssertSteps.verifyActualResult(blnValidation, 'Employee Status DropDown Displayed', 'Employee Status DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying Employee Status default value'
			String ExpectedValue='Onboarding - In Progress'
			String ActualValue=getEmployeeStatusDropDownValue()
			boolean blnCondition=ActualValue.equals(ExpectedValue)
			String AssertMsg='Employee Status DropDown default value Validation - Expected : '+ExpectedValue+' and Actual : '+ActualValue
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		blnValidation=isTerminationNoticeGivenOnTextBoxDisplayed()
		AssertSteps.verifyActualResult(blnValidation, 'Termination Notice Given On TextBox Displayed', 'Termination Notice Given On TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying Termination Notice Given On TextBox Background'
			String ExpectedValue=HIIConstants.DateTextBoxPlaceHolder
			String ActualValue=getTerminationNoticeGivenOnTextBoxBackgroundText()
			boolean blnCondition=ActualValue.equals(ExpectedValue)
			String AssertMsg='Termination Notice Given On TextBox Background Validation - Expected : '+ExpectedValue+' and Actual : '+ActualValue
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		blnValidation=isTerminationDateTextBoxDisplayed()
		AssertSteps.verifyActualResult(blnValidation, 'Termination Date TextBox Displayed', 'Termination Date TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying ermination Date TextBox Background'
			String ExpectedValue=HIIConstants.DateTextBoxPlaceHolder
			String ActualValue=getTerminationDateTextBoxBackgroundText()
			boolean blnCondition=ActualValue.equals(ExpectedValue)
			String AssertMsg='Termination Date TextBox Background Validation - Expected : '+ExpectedValue+' and Actual : '+ActualValue
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isEmploymentTypeDropDownDisplayed(), 'Employment Type DropDown Displayed', 'Employment Type DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isSubCategoryDropDownDisplayed(), 'Sub Category DropDown Displayed', 'Sub Category DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isDisableAlertCheckBoxDisplayed(), 'Disable ALert CheckBox Displayed', 'Disable ALert CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isOnboardingCompletedCheckBoxDisplayed(), 'Onboarding Completed CheckBox Displayed', 'Onboarding Completed CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		blnValidation=isOnboardingCompletedDateTextBoxDisplayed()
		AssertSteps.verifyActualResult(blnValidation, 'Onboarding Completed Date TextBox Displayed', 'Onboarding Completed Date TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying Onboarding Completed Date TextBox Background Text'
			String ExpectedValue=HIIConstants.DateTextBoxPlaceHolder
			String ActualValue=getOnboardingCompletedDateTextBoxBackgroundText()
			boolean blnCondition=ActualValue.equals(ExpectedValue)
			String AssertMsg='Onboarding Completed Date TextBox Background Text Validation - Expected : '+ExpectedValue+' and Actual : '+ActualValue
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(isIsBoardEligibleCheckBoxDisplayed(), 'Is Board Eligible CheckBox Displayed', 'Is Board Eligible CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		blnValidation=isEmployeeTypeDropDownDisplayed()
		AssertSteps.verifyActualResult(blnValidation, 'Employee Type DropDown Displayed', 'Employee Type DropDown is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying Employee Type default value'
			String ExpectedValue='Employed'
			String ActualValue=getEmployeeTypeDropDownValue()
			boolean blnCondition=ActualValue.equals(ExpectedValue)
			String AssertMsg='Employee Type DropDown default value Validation - Expected : '+ExpectedValue+' and Actual : '+ActualValue
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
		AssertSteps.verifyActualResult(getBaseSteps().isControlMandatory(ddlEmployeeType, pageName.ProviderSetup), 'Employee Type with Mandatory indication - PASS', 'Employee Type is not with Mandatory indication - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isIsBoardCertifiedCheckBoxDisplayed(), 'Is Board Certified CheckBox Displayed', 'Is Board Certified CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isActiveCheckBoxDisplayed(), 'Active CheckBox Displayed', 'Active CheckBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		AssertSteps.verifyActualResult(isNotesTextAreaDisplayed(), 'Notes Text Area Displayed', 'Notes Text Area is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isSaveButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnSave, pageName.ProviderSetup)
	}

	public static String getSaveButtonText() {
		return getBaseSteps().getValueFromControl(btnSave, pageName.ProviderSetup)
	}

	public static void verifySaveButtonUI() {

		boolean blnDisplayed=isSaveButtonDisplayed()
		'Verifying Save Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Save Button Displayed', 'Save Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Save Button text'
			String ExpectedText=HIIConstants.PS_SaveButtonText
			String ActualText=getSaveButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Save Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static boolean isClearButtonDisplayed() {
		return getBaseSteps().WebElementDisplayed(btnClear, pageName.ProviderSetup)
	}

	public static String getClearButtonText() {
		return getBaseSteps().getValueFromControl(btnClear, pageName.ProviderSetup)
	}

	public static void verifyClearButtonUI() {

		boolean blnDisplayed=isClearButtonDisplayed()
		'Verifying Clear Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Clear Button Displayed', 'Clear Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {
			'Verifying Clear Button text'
			String ExpectedText=HIIConstants.PS_SearchClearButtonText
			String ActualText=getClearButtonText()
			boolean blnCondition=ActualText.equals(ExpectedText)
			String AssertMsg='Clear Button Text Validation - Expected : '+ExpectedText+' and Actual : '+ActualText
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}



	//================== Provider Setup ======================================

	public static boolean isCreateProviderEnabled() {
		return getBaseSteps().WebElementEnabled(btnCreateProvider, pageName.ProviderSetup)
	}

	public static boolean isCreateProviderClickable() {
		return getBaseSteps().isControlClickable(btnCreateProvider, pageName.ProviderSetup)

	}

	//Click Create Provider
	public static void clickCreateProvider() {
		getBaseSteps().clickToControl(btnCreateProvider, pageName.ProviderSetup)
		/*
		if(isCreateProviderClickable())
		 getBaseSteps().clickToControl(btnCreateProvider, pageName.ProviderSetup)
		 else
		 Logger.logWARNING('Create Provider Option is not Clickable for Logged User')
		*/ 
	}

	public static void setFirstName(String FirstName) {
		if(FirstName!='')
			getBaseSteps().setTextToControl(txtFirstName, FirstName, pageName.ProviderSetup)
	}

	public static void setMiddleName(String MiddleName) {
		if(MiddleName!='')
			getBaseSteps().setTextToControl(txtMiddleName, MiddleName, pageName.ProviderSetup)
	}

	public static void setLastName(String LastName) {
		if(LastName!='')
			getBaseSteps().setTextToControl(txtLastName, LastName, pageName.ProviderSetup)
	}

	public static void setSSN(String SSN) {
		if(SSN!='') {
			
			WebUI.sendKeys(null, validationMessage)
			}
			
			getBaseSteps().setTextToControl(txtSSN, String.valueOf(SSN), pageName.ProviderSetup)
	}

	public static void setDateOfBirth(String DateOfBirth) {
		if(DateOfBirth!='')
			getBaseSteps().setTextToControl(txtDateOfBirth, DateOfBirth, pageName.ProviderSetup)
	}

	public static void setPreferredContactNo(String PreferredContactNo) {
		if(PreferredContactNo!='')
			getBaseSteps().setTextToControl(txtPreferredContactNo, PreferredContactNo, pageName.ProviderSetup)
	}

	public static void setSecondaryContactNo(String SecondaryContactNo) {
		if(SecondaryContactNo!='')
			getBaseSteps().setTextToControl(txtSecondaryContactNo, SecondaryContactNo, pageName.ProviderSetup)
	}

	public static void setEmail(String Email) {
		if(Email!='')
			getBaseSteps().setTextToControl(txtEmail, Email, pageName.ProviderSetup)
	}

	public static void setNPINumber(String NPINumber) {
		if(NPINumber!='')
			getBaseSteps().setTextToControl(txtNPINumber, NPINumber, pageName.ProviderSetup)
	}

	public static void setStreetAddress(String StreetAddress) {
		if(StreetAddress!='')
			getBaseSteps().setTextToControl(txtStreetAddress, StreetAddress, pageName.ProviderSetup)
	}

	public static void setCity(String City) {
		if(City!='')
			getBaseSteps().setTextToControl(txtCity, City, pageName.ProviderSetup)
	}

	public static void selectState(String State) {
		if(State!='')
			getBaseSteps().selectByVisibleText(ddlState, State, pageName.ProviderSetup)
	}

	public static void setZipCode(String ZipCode) {
		if(ZipCode!='')
			getBaseSteps().setTextToControl(txtZipCode, ZipCode, pageName.ProviderSetup)
	}

	public static void selectRegion(String Region) {
		if(Region!='')
		{
			getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ProviderSetup)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}
	}
	
	/**
	 * 
	 */
	public static void selectRandomRegion() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}

	public static void selectLocation(String Location) {
		if(Location!='')
			getBaseSteps().selectByVisibleText(ddlLocation, Location, pageName.ProviderSetup)
	}

	public static void selectRandomLocation() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlLocation, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}
	
	public static void selectPrimaryCostCenter(String PrimaryCostCenter) {
		if(PrimaryCostCenter!='')
			getBaseSteps().selectByVisibleText(ddlPrimaryCostCenter, PrimaryCostCenter, pageName.ProviderSetup)
	}

	public static void selectRandomPrimaryCostCenter() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlPrimaryCostCenter, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}
	
	public static void selectProviderGroup(String ProviderGroup) {
		if(ProviderGroup!='')
			getBaseSteps().selectByVisibleText(ddlProviderGroup, ProviderGroup, pageName.ProviderSetup)
	}

	public static void selectPositionLevel(String PositionLevel) {
		if(PositionLevel!='')
			getBaseSteps().selectByVisibleText(ddlPositionLevel, PositionLevel, pageName.ProviderSetup)
	}
	
	public static void selectRandomPositionLevel() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlPositionLevel, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}
	

	public static void selectPrimarySpecialty(String PrimarySpecialty) {
		if(PrimarySpecialty!='')
			getBaseSteps().selectByVisibleText(ddlPrimarySpecialty, PrimarySpecialty, pageName.ProviderSetup)
	}
	
	public static void selectRandomPrimarySpecialty() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlPrimarySpecialty, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}
	

	public static void selectSpecialtyGroup(String SpecialtyGroup) {
		if(SpecialtyGroup!='')
			getBaseSteps().selectByVisibleText(ddlSpecialtyGroup, SpecialtyGroup, pageName.ProviderSetup)
	}
	
	public static void selectRandomSpecialtyGroup() {
		getBaseSteps().selectRandomOptionDropdownControl(ddlSpecialtyGroup, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2500);
	}

	public static void setPayrollID(String PayrollID) {
		if(PayrollID!='')
			getBaseSteps().setTextToControl(txtPayrollID, PayrollID, pageName.ProviderSetup)
	}

	public static void setProviderID(String ProviderID) {
		if(ProviderID!='')
			getBaseSteps().setTextToControl(txtProviderID, ProviderID, pageName.ProviderSetup)
	}

	public static void setEMRID(String EMRID) {
		if(EMRID!='')
			getBaseSteps().setTextToControl(txtEMRID, EMRID, pageName.ProviderSetup)
	}

	public static void setSupervisorLead(String SupervisorLead) {
		if(SupervisorLead!='')
			getBaseSteps().setTextToControl(txtSupervisorLead, SupervisorLead, pageName.ProviderSetup)
	}

	public static void setDirector(String Director) {
		if(Director!='')
			getBaseSteps().setTextToControl(txtDirector, Director, pageName.ProviderSetup)
	}

	public static void setPracMgrLead(String PracMgrLead) {
		if(PracMgrLead!='')
			getBaseSteps().setTextToControl(txtPracMgrLead, PracMgrLead, pageName.ProviderSetup)
	}

	public static void setAdminDirector(String AdminDirector) {
		if(AdminDirector!='')
			getBaseSteps().setTextToControl(txtAdminDirector, AdminDirector, pageName.ProviderSetup)
	}

	public static void setPracticeLocationCostCenterID(String PracticeLocationCostCenterID) {
		if(PracticeLocationCostCenterID!='')
			getBaseSteps().setTextToControl(txtPracticeLocationCostCenterID, PracticeLocationCostCenterID, pageName.ProviderSetup)
	}

	public static void setSecondaryCostCenter1(String SecondaryCostCenter1) {
		if(SecondaryCostCenter1!='')
			getBaseSteps().setTextToControl(ddlSecondaryCostCenter1, SecondaryCostCenter1, pageName.ProviderSetup)
	}

	public static void setSecondaryCostCenter2(String SecondaryCostCenter2) {
		if(SecondaryCostCenter2!='')
			getBaseSteps().setTextToControl(ddlSecondaryCostCenter2, SecondaryCostCenter2, pageName.ProviderSetup)
	}

	public static void setHiringReq(String HiringReq) {
		if(HiringReq!='')
			getBaseSteps().setTextToControl(txtHiringReq, HiringReq, pageName.ProviderSetup)
	}

	public static void setCredentialingID(String CredentialingID) {
		if(CredentialingID!='')
			getBaseSteps().setTextToControl(txtCredentialingID, CredentialingID, pageName.ProviderSetup)
	}

	public static void setBudgetedHours(String BudgetedHours) {
		if(BudgetedHours!='')
			getBaseSteps().setTextToControl(txtBudgetedHours, BudgetedHours, pageName.ProviderSetup)
	}

	public static void setHourlyRate(String HourlyRate) {
		if(HourlyRate!='')
			getBaseSteps().setTextToControl(txtHourlyRate, HourlyRate, pageName.ProviderSetup)
	}

	public static void setDEALicense(String DEALicense) {
		if(DEALicense!='')
			getBaseSteps().setTextToControl(txtDEALicense, DEALicense, pageName.ProviderSetup)
	}

	public static void setDEALicenseRenewalDate(String DEALicenseRenewalDate) {
		if(DEALicenseRenewalDate!='')
			getBaseSteps().setTextToControl(txtDEALicenseRenewalDate, DEALicenseRenewalDate, pageName.ProviderSetup)
	}

	public static void selectProviderTitle(String ProviderTitle) {
		if(ProviderTitle!='')
			getBaseSteps().setTextToControl(ddlProviderTitle, ProviderTitle, pageName.ProviderSetup)
	}

	public static void setAccrualAccountNumber(String AccrualAccountNumber) {
		if(AccrualAccountNumber!='')
			getBaseSteps().setTextToControl(txtAccrualAccountNumber, AccrualAccountNumber, pageName.ProviderSetup)
	}

	public static void setSchedulingID(String SchedulingID) {
		if(SchedulingID!='')
			getBaseSteps().setTextToControl(txtSchedulingID, SchedulingID, pageName.ProviderSetup)
	}

	public static void setFTE(String FTE) {
		if(FTE!='')
			getBaseSteps().setTextToControl(txtFTE, FTE, pageName.ProviderSetup)
	}

	public static void setExperienceasofDate(String ExperienceasofDate) {
		if(ExperienceasofDate!='')
			getBaseSteps().setTextToControl(txtExperienceasofDate, ExperienceasofDate, pageName.ProviderSetup)
	}

	public static void setExperienceYears(String ExperienceYears) {
		if(ExperienceYears!='')
			getBaseSteps().setTextToControl(txtExperienceYears, ExperienceYears, pageName.ProviderSetup)
	}

	public static void setExperienceMonths(String ExperienceMonths) {
		if(ExperienceMonths!='')
			getBaseSteps().setTextToControl(txtExperienceMonths, ExperienceMonths, pageName.ProviderSetup)
	}

	public static void selectVisaStatus(String VisaStatus) {
		if(VisaStatus!='')
			getBaseSteps().setTextToControl(ddlVisaStatus, VisaStatus, pageName.ProviderSetup)
	}

	public static void setVisaEndDate(String VisaEndDate) {
		if(VisaEndDate!='')
			getBaseSteps().setTextToControl(txtVisaEndDate, VisaEndDate, pageName.ProviderSetup)
	}

	public static void selectEmployeeStatus(String EmployeeStatus) {
		if(EmployeeStatus!='')
			getBaseSteps().selectByVisibleText(ddlEmployeeStatus, EmployeeStatus, pageName.ProviderSetup)
	}

	public static void setHireDate(String HireDate) {
		getBaseSteps().waitForControlDisplay(txtHireDate, pageName.ProviderSetup)
		if(HireDate!='')
		{
			getBaseSteps().clickToControl(txtHireDate, pageName.ProviderSetup)
			getBaseSteps().selectDate(txtHireDate, HireDate, pageName.ProviderSetup)
		}
	}

	public static void setTerminationNoticeGivenOn(String TerminationNoticeGivenOn) {
		if(TerminationNoticeGivenOn!='')
			getBaseSteps().setTextToControl(txtTerminationNoticeGivenOn, TerminationNoticeGivenOn, pageName.ProviderSetup)
	}

	public static void setTerminationDate(String TerminationDate) {
		if(TerminationDate!='')
			getBaseSteps().setTextToControl(txtTerminationDate, TerminationDate, pageName.ProviderSetup)
	}

	public static void selectEmploymentType(String EmploymentType) {
		if(EmploymentType!='')
			getBaseSteps().setTextToControl(ddlEmploymentType, EmploymentType, pageName.ProviderSetup)
	}

	public static void selectSubCategory(String SubCategory) {
		if(SubCategory!='')
			getBaseSteps().setTextToControl(ddlSubCategory, SubCategory, pageName.ProviderSetup)
	}

	public static void selectEmployeeType(String EmployeeType) {
		if(EmployeeType!='')
			getBaseSteps().setTextToControl(ddlEmployeeType, EmployeeType, pageName.ProviderSetup)
	}

	public static void clickSave() {
		getBaseSteps().waitForControlClickable(btnSave, pageName.ProviderSetup)
		//getBaseSteps().clickToControl(btnSave, pageName.ProviderSetup)
		getBaseSteps().clickControlJavaScriptExecutor(btnSave, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyProvideCreation() {
		if(isValidationSummaryDisplayed()) {
			AssertSteps.verifyActualResult(false,'','Validation Summary Displayed with : '+getValidationSummary(),FailureHandling.OPTIONAL)
		}else {
			AssertSteps.verifyActualResult(successMessageDisplayed(), 'Success Message displayed', 'Success Message is not displayed', FailureHandling.STOP_ON_FAILURE)
			AssertSteps.verifyActualResult(getSuccessMessage().equals(HIIConstants.PS_ProviderDetailsInsertedSuccessfully), 'Success Message:'+HIIConstants.PS_ProviderDetailsInsertedSuccessfully+' is as expected - PASS', 'Success Message -- Actual :'+getSuccessMessage()+' and Expected : '+HIIConstants.PS_ProviderDetailsInsertedSuccessfully+' is not as expected - FAIL', FailureHandling.STOP_ON_FAILURE)
		}	
	}
	
	public static void verifyProviderUpdation() {
		if(isValidationSummaryDisplayed()) {
			AssertSteps.verifyActualResult(false,'','Validation Summary Displayed with : '+getValidationSummary(),FailureHandling.OPTIONAL)
		}else {
			AssertSteps.verifyActualResult(successMessageDisplayed(), 'Success Message displayed', 'Success Message is not displayed', FailureHandling.STOP_ON_FAILURE)
			AssertSteps.verifyActualResult(getSuccessMessage().equals(HIIConstants.PS_ProviderDetailsUpdatedSuccessfully), 'Success Message:'+getSuccessMessage()+' is as expected - PASS', 'Success Message -- Actual :'+getSuccessMessage()+' and Expected : '+HIIConstants.PS_ProviderDetailsUpdatedSuccessfully+' is not as expected - FAIL', FailureHandling.STOP_ON_FAILURE)
		}
	}
	
	public static void verifyProvideDeletion() {
		if(isValidationSummaryDisplayed()) {
			AssertSteps.verifyActualResult(false,'','Validation Summary Displayed with : '+getValidationSummary(),FailureHandling.OPTIONAL)
		}else {
			AssertSteps.verifyActualResult(successMessageDisplayed(), 'Success Message displayed', 'Success Message is not displayed', FailureHandling.STOP_ON_FAILURE)
			AssertSteps.verifyActualResult(getSuccessMessage().equals(HIIConstants.PS_ProviderDeletedSuccessfully), 'Success Message:'+getSuccessMessage()+' is as expected - PASS', 'Success Message -- Actual :'+getSuccessMessage()+' and Expected : '+HIIConstants.PS_ProviderDeletedSuccessfully+' is not as expected - FAIL', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static boolean successMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(lblSuccess, pageName.ProviderSetup)
	}

	public static String getSuccessMessage() {
		if(successMessageDisplayed())
			return getBaseSteps().getTextFromControl(lblSuccess, pageName.ProviderSetup)
	}

	
	public static void clickDelete() {
		/*getBaseSteps().scrollDown()
		getBaseSteps().scrollIntoView(btnDelete, pageName.ProviderSetup)
		getBaseSteps().clickToControl(btnDelete, pageName.ProviderSetup)
		*/
		getBaseSteps().waitForControlClickable(btnDelete, pageName.ProviderSetup)
		getBaseSteps().clickControlJavaScriptExecutor(btnDelete, pageName.ProviderSetup)
		
		try {
			WebUI.waitForAlert(30)
			WebUI.acceptAlert()
		}catch(Exception e) {
			Logger.logINFO("Exception while accepting alert")
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Thread.sleep(2000)
	}
	
	
	//================== METHOD TO GET PROVIDER DATA =========================
	public static ProviderData getProviderData(String Provider) {
		gotoProviderSetup()
		setProviderSearch(Provider)
		editProvider()
		ProviderData providerdata=new ProviderData()

		providerdata.setEmployeeStatus(getBaseSteps().getselectedControlDropdowm('ddlEmployeeStatus', pageName.ProviderSetup))

		String empStatus=providerdata.getEmployeeStatus()

		switch(empStatus) {
			case HIIConstants.ES_Terminated :
				providerdata.setTerminationDate(getBaseSteps().getValueFromControl('txtTerminationDate', pageName.ProviderSetup))
				break

			case HIIConstants.ES_Hired:
				providerdata.setHireDate(getBaseSteps().getValueFromControl('txtHireDate', pageName.ProviderSetup))
				break
			default: break

		}
		return providerdata

	}

	//=======================================================
	public static void verifyProviderSetupPageLoaded() {
		getBaseSteps().verifyPageIsLoaded(HIIConstants.URL_ProviderSetup,"Provider Setup page is not launched")
	}

	public static void setProviderSearch(String ProviderSearch) {
		boolean blnDisplayed=isProviderSearchTextBoxDisplayed()
		'Verifying Provider Search textbox whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Provider Search TextBox Displayed', 'Provider Search TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnDisplayed) {
			getBaseSteps().setTextToControl('txtProviderSearch', ProviderSearch, pageName.ProviderSetup)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			if(getBaseSteps().WebElementDisplayed('lstProviderhints', pageName.CMN))
			{
				getBaseSteps().clickProviderHint('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
				getBaseSteps().waitForControlDisplay(grdProviderDetails, pageName.ProviderSetup)
			}else
				Logger.logINFO('Provider does not exist with data :'+ProviderSearch)
		}
	}

	public static void setUniversalSearch(String UniversalSearch) {

		boolean blnDisplayed=isUniversalSearchTextBoxDisplayed()
		'Verifying Universal Search textbox whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Universal Search TextBox Displayed', 'Universal Search TextBox is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
			getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.ProviderSetup)
	}

	public static void clickSearch() {
		boolean blnDisplayed=isSearchButtonDisplayed()
		'Verifying Search Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Search Button Displayed', 'Search Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnDisplayed)
			getBaseSteps().clickToControl(btnSearch, pageName.ProviderSetup)
	}

	public static String getProviderEmployeeStatus(String Provider) {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderSetup', pageName.Header)
		setProviderSearch(Provider)
		return getBaseSteps().getCellTableText('grdProviderDetails', 'Contract Status', pageName.ProviderSetup)
	}

	public static String getProviderEmployeeType() {
		return getBaseSteps().getCellTableText('grdProviderDetails', 'Employee Type', pageName.ProviderSetup)
	}

	public static void verifyProviderDetailsExists(String ProviderData) {
		getBaseSteps().waitForTableDataLoaded('grdProviderDetails',25,pageName.ProviderSetup)
		getBaseSteps().verifyTableBodyContainData('grdProviderDetails', ProviderData, pageName.ProviderSetup)
	}

	public static void editProvider() {
		getBaseSteps().clickTableLink('grdProviderDetails', 'Edit', pageName.ProviderSetup)
	}

	public static void verifyEmployeeStatusforProviderPayRequest(String EmployeeStatus) {
		switch(EmployeeStatus) {
			case HIIConstants.ES_OnboardingInProgress: log.markErrorAndStop('Can not proceed for Provider Pay Request, hence provider with Employee Status : '+HIIConstants.ES_OnboardingInProgress)
				break
			default: log.logInfo('Provider with Employee Status: '+EmployeeStatus)
				break

		}

	}


	/*********************************************************************************************************************************************************************************************************/

	public static boolean isProviderActive(String Provider) {
		boolean blnActive
		openProviderSetup_newTab()
		setProviderSearch(Provider)
		try {
			blnActive=getBaseSteps().isCellTableCheckBoxActive(grdProviderDetails, 'Active', pageName.ProviderSetup)
		}catch(Exception e) {}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		Thread.sleep(1000)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return blnActive
	}

	public static boolean verifyProviderExists(String ProviderSearch) {
		boolean blnProvider
		openProviderSetup_newTab()
		getBaseSteps().setTextToControl('txtProviderSearch', ProviderSearch, pageName.ProviderSetup)
		try {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
			blnProvider=true
		}catch(Exception e) {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		//getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return blnProvider
	}

	public static String getRegion() {
		return getBaseSteps().getselectedControlDropdowm(ddlRegion, pageName.ProviderSetup)
	}

	public static String getLocation() {
		return getBaseSteps().getselectedControlDropdowm(ddlLocation, pageName.ProviderSetup)
	}

	public static List<String> getListOfLocation(){
		List<String> lstLocation=new ArrayList<String>()
		lstLocation=getBaseSteps().getlistControlDropdowm(ddlLocation, pageName.ProviderSetup)
		lstLocation.remove('-Select Location-')
		return lstLocation
	}

	public static List<String> getListOfPrimaryCostCenter(){
		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getBaseSteps().getlistControlDropdowm(this.ddlPrimaryCostCenter, pageName.ProviderSetup)
		lstCostCenter.remove('-Select Primary Cost Center-')
		return lstCostCenter
	}

	public static List<String> getListOfSecondaryCostCenter1(){
		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getBaseSteps().getlistControlDropdowm(this.ddlSecondaryCostCenter1, pageName.ProviderSetup)
		lstCostCenter.remove('-Select Secondary Cost Center 1-')
		return lstCostCenter
	}

	public static List<String> getListOfSecondaryCostCenter2(){
		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getBaseSteps().getlistControlDropdowm(this.ddlSecondaryCostCenter2, pageName.ProviderSetup)
		lstCostCenter.remove('-Select Secondary Cost Center 2-')
		return lstCostCenter
	}

	public static List<String> getListOfProviderGroup(){
		List<String> lstProviderGroup=new ArrayList<String>()
		lstProviderGroup=getBaseSteps().getlistControlDropdowm(ddlProviderGroup, pageName.ProviderSetup)
		lstProviderGroup.remove('-Select Provider Group-')
		return lstProviderGroup
	}

	public static String getProviderGroup(){
		String selectedProviderGroup
		selectedProviderGroup=getBaseSteps().getselectedControlDropdowm(ddlProviderGroup, pageName.ProviderSetup)
		return selectedProviderGroup
	}

	public static List<String> getListOfPrimarySpecialty(){
		List<String> lstPrimarySpecialty=new ArrayList<String>()
		lstPrimarySpecialty=getBaseSteps().getlistControlDropdowm(ddlPrimarySpecialty, pageName.ProviderSetup)
		lstPrimarySpecialty.remove('-Select Specialty-')
		return lstPrimarySpecialty
	}

	public static String getPrimaryCostCenter() {
		return getBaseSteps().getselectedControlDropdowm(ddlPrimaryCostCenter, pageName.ProviderSetup)
	}

	public static String getPrimarySpecialty() {
		return getBaseSteps().getselectedControlDropdowm(ddlPrimarySpecialty, pageName.ProviderSetup)
	}

	public static String getPositionLevel() {
		return getBaseSteps().getselectedControlDropdowm(ddlPositionLevel, pageName.ProviderSetup)
	}

	public static String getPayrollID() {
		return getBaseSteps().getValueFromControl(txtPayrollID, pageName.ProviderSetup)
	}

	public static String getEmployeeType() {
		return getBaseSteps().getselectedControlDropdowm(ddlEmployeeType, pageName.ProviderSetup)
	}

	public static String getEmployeeStatus() {
		return getBaseSteps().getselectedControlDropdowm(ddlEmployeeStatus, pageName.ProviderSetup)
	}

	public static String getTerminationDate() {
		return getBaseSteps().getValueFromControl(txtTerminationDate, pageName.ProviderSetup)
	}

	public static String getAccrualAccountNumber() {
		return getBaseSteps().getValueFromControl(txtAccrualAccountNumber, pageName.ProviderSetup)
	}

	public static HashMap<String,String> getProviderDetails(String Provider){

		HashMap<String,String> ProviderDetails=new HashMap<String,String>()
		openProviderSetup_newTab()
		setProviderSearch(Provider)

		String HIICCID=getBaseSteps().getCellTableText(grdProviderDetails, 'HII CC ID', pageName.ProviderSetup)

		editProvider()


		String PositionLevel=getPositionLevel()
		String PayrollID=getPayrollID()
		String EmployeeType=getEmployeeType()
		String EmployeeStatus=getEmployeeStatus()
		String Region=getRegion()
		String Location=getLocation()
		String PrimaryCostCenter=getPrimaryCostCenter()
		String PrimarySpecialty=getPrimarySpecialty()
		String AccrualAccountNumber=getAccrualAccountNumber()


		ProviderDetails.put('Region',Region)
		ProviderDetails.put('Location',Location)
		ProviderDetails.put('PositionLevel', PositionLevel)
		ProviderDetails.put('PayrollID', PayrollID)
		ProviderDetails.put('EmployeeType', EmployeeType)
		ProviderDetails.put('EmployeeStatus', EmployeeStatus)
		ProviderDetails.put('PrimaryCostCenter', PrimaryCostCenter)
		ProviderDetails.put('PrimarySpecialty', PrimarySpecialty)
		ProviderDetails.put('HIICCID', HIICCID)
		ProviderDetails.put('AccrualAccountNumber', AccrualAccountNumber)

		if(EmployeeStatus.equals('Terminated'))
		{
			String TerminationDate=getTerminationDate()
			ProviderDetails.put('TerminationDate', TerminationDate)

		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		return ProviderDetails

	}

	/*********************************************************************************************************************************************************************************************************/

	public static void selectFirstEligibleRegion(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlRegion, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFirstEligibleLocation(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlLocation, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFirstEligiblePrimaryCostCenter(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlPrimaryCostCenter, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFirstEligiblePositionLevel(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlPositionLevel, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPositionLevelAsProvider() {
		getBaseSteps().selectByVisibleText(ddlPositionLevel, 'Provider', pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFirstEligiblePrimarySpecialty(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlPrimarySpecialty, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFirstEligibleSpecialtyGroup(int Index=1) {
		getBaseSteps().selectFirstOptionDropdownControl(ddlSpecialtyGroup, Index, pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setAutomatedFirstName() {
		getBaseSteps().setTextToControl(txtFirstName, ApplicationUtilities.getAutomated_FirstName(), pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setAutomatedLastName() {
		getBaseSteps().setTextToControl(txtLastName, ApplicationUtilities.getAutomated_LastName(), pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setAutomatedEmail() {
		getBaseSteps().setTextToControl(txtEmail, ApplicationUtilities.getUnique_Automated_Email(), pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setAutomatedPayrollID() {
		getBaseSteps().setTextToControl(txtPayrollID, ApplicationUtilities.getUnique_Automated_PayrollID(), pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	
	public static void selectEmployeeStatusAsHired() {
		getBaseSteps().selectByVisibleText(ddlEmployeeStatus, 'Hired', pageName.ProviderSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//To get Regions list
	public static List<String> getRegionList() {
		List<String> Regions=getBaseSteps().getlistControlDropdowm(ddlRegion, pageName.ProviderSetup)
		Regions.remove('- Select Region -')
		return Regions
	}

	public static boolean isRegionDropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ProviderSetup)
	}

	public static void verifyRegionList(Collection<String> expectedRegions,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isRegionDropdownDisplayed()) {
			List<String> actualRegions=getRegionList()
			for(String eRegion:expectedRegions)
			{
				AssertSteps.verifyActualResult(actualRegions.contains(eRegion), 'Region : '+eRegion+' contains in Region dropdown', 'Region : '+eRegion+' does not contain in Region dropdown', failureHandling)
			}
		}else
			Logger.logWARNING('Region Dropdown is not displayed')
	}

	public static boolean isLocationDropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ProviderSetup)
	}

	public static void verifyLocationList(Collection<String> lstExpectedLocations,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isLocationDropdownDisplayed()) {
			List<String> lstActualLocations=this.getListOfLocation()
			for(String Location:lstExpectedLocations)
			{
				AssertSteps.verifyActualResult(lstActualLocations.contains(Location), 'Location : '+Location+' contains in Location dropdown - PASS', 'Location : '+Location+' does not contain in Location dropdown - FAIL', failureHandling)
			}
			for(String Location:lstActualLocations)
			{
				AssertSteps.verifyActualResult(lstExpectedLocations.contains(Location), 'Location : '+Location+' contains in Expected Active Location - PASS', 'Location : '+Location+' does not contain in Expected Active Location - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Location Dropdown is not displayed')
	}

	public static boolean isPrimaryCostCenterDropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlPrimaryCostCenter, pageName.ProviderSetup)
	}
	public static boolean isSecondaryCostCenter1DropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlSecondaryCostCenter1, pageName.ProviderSetup)
	}
	public static boolean isSecondaryCostCenter2DropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlSecondaryCostCenter2, pageName.ProviderSetup)
	}

	public static boolean isProviderGroupDropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlProviderGroup, pageName.ProviderSetup)
	}

	public static boolean isPrimarySpecialtyDropdownDisplayed(){
		return getBaseSteps().WebElementDisplayed(ddlPrimarySpecialty, pageName.ProviderSetup)
	}

	public static void verifyListOfPrimaryCostCenter(Collection<String> lstExpectedCostCenter,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isPrimaryCostCenterDropdownDisplayed()) {
			List<String> lstActualCostCenter=this.getListOfPrimaryCostCenter()
			for(String CostCenter:lstExpectedCostCenter)
			{
				AssertSteps.verifyActualResult(lstActualCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Primary Cost Center dropdown - PASS', 'CostCenter : '+CostCenter+' does not contain in Primary Cost Center dropdown - FAIL', failureHandling)
			}
			for(String CostCenter:lstActualCostCenter)
			{
				AssertSteps.verifyActualResult(lstExpectedCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Expected Active CostCenter - PASS', 'CostCenter : '+CostCenter+' does not contain in Expected Active CostCenter - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Primary Cost Center Dropdown is not displayed')
	}

	public static void verifyListOfSecondaryCostCenter1(Collection<String> lstExpectedCostCenter,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isSecondaryCostCenter1DropdownDisplayed()) {
			List<String> lstActualCostCenter=this.getListOfSecondaryCostCenter1()
			for(String CostCenter:lstExpectedCostCenter)
			{
				AssertSteps.verifyActualResult(lstActualCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Secondary Cost Center 1 dropdown - PASS', 'CostCenter : '+CostCenter+' does not contain in Secondary Cost Center 1 dropdown - FAIL', failureHandling)
			}
			for(String CostCenter:lstActualCostCenter)
			{
				AssertSteps.verifyActualResult(lstExpectedCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Expected Active CostCenter - PASS', 'CostCenter : '+CostCenter+' does not contain in Expected Active CostCenter - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Primary Cost Center Dropdown is not displayed')
	}

	public static void verifyListOfSecondaryCostCenter2(Collection<String> lstExpectedCostCenter,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isSecondaryCostCenter2DropdownDisplayed()) {
			List<String> lstActualCostCenter=this.getListOfSecondaryCostCenter2()
			for(String CostCenter:lstExpectedCostCenter)
			{
				AssertSteps.verifyActualResult(lstActualCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Secondary Cost Center 2 dropdown - PASS', 'CostCenter : '+CostCenter+' does not contain in Secondary Cost Center 2 dropdown - FAIL', failureHandling)
			}
			for(String CostCenter:lstActualCostCenter)
			{
				AssertSteps.verifyActualResult(lstExpectedCostCenter.contains(CostCenter), 'CostCenter : '+CostCenter+' contains in Expected Active CostCenter - PASS', 'CostCenter : '+CostCenter+' does not contain in Expected Active CostCenter - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Primary Cost Center Dropdown is not displayed')
	}

	public static void verifyListOfProviderGroup(Collection<String> lstExpectedProviderGroup,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isProviderGroupDropdownDisplayed()) {
			List<String> lstActualProviderGroup=this.getListOfProviderGroup()
			for(String ProviderGroup:lstExpectedProviderGroup)
			{
				AssertSteps.verifyActualResult(lstActualProviderGroup.contains(ProviderGroup), 'ProviderGroup : '+ProviderGroup+' contains in ProviderGroup dropdown - PASS', 'ProviderGroup : '+ProviderGroup+' does not contain in ProviderGroup dropdown - FAIL', failureHandling)
			}
			for(String ProviderGroup:lstActualProviderGroup)
			{
				AssertSteps.verifyActualResult(lstExpectedProviderGroup.contains(ProviderGroup), 'ProviderGroup : '+ProviderGroup+' contains in Expected Active ProviderGroup - PASS', 'ProviderGroup : '+ProviderGroup+' does not contain in Expected Active ProviderGroup - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Provider Group Dropdown is not displayed')
	}

	public static void verifyProviderGroupDefaultValue(String flagSetting,String DefaultValue,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(flagSetting.equals(HIIConstants.Yes)) {
			AssertSteps.verifyActualResult(!isProviderGroupDropDownEnabled(), 'Provider Group is Disbaled - PASS', ' Provider Group should be Disbaled- FAIL', FailureHandling.CONTINUE_ON_FAILURE)
			AssertSteps.verifyActualResult(DefaultValue.equals(getProviderGroup()), 'Provider Group default value is ProviderGroup Mapped to Location - PASS', ' Provider Group default value should be ProviderGroup Mapped to Location- FAIL', failureHandling)
		}else if(flagSetting.equals(HIIConstants.No)) {
			AssertSteps.verifyActualResult(isProviderGroupDropDownEnabled(), 'Provider Group is Enabled - PASS', ' Provider Group should be Enabled- FAIL', FailureHandling.CONTINUE_ON_FAILURE)
			AssertSteps.verifyActualResult(getProviderGroup().equals('-Select Provider Group-'), 'User has to select Provider Group - PASS', ' User has to select Provider Group- FAIL', failureHandling)
		}
	}

	public static void verifyListOfPrimarySpecialty(Collection<String> lstExpectedSpecialty,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(isPrimarySpecialtyDropdownDisplayed()) {
			List<String> lstActualPrimarySpecialty=this.getListOfPrimarySpecialty()
			for(String Specialty:lstExpectedSpecialty)
			{
				AssertSteps.verifyActualResult(lstActualPrimarySpecialty.contains(Specialty), 'Primary Specialty : '+Specialty+' contains in Primary Specialty dropdown - PASS', 'Primary Specialty : '+Specialty+' does not contain in Primary Specialty dropdown - FAIL', failureHandling)
			}
			for(String Specialty:lstActualPrimarySpecialty)
			{
				AssertSteps.verifyActualResult(lstExpectedSpecialty.contains(Specialty), 'Primary Specialty : '+Specialty+' contains in Expected Active Specialties - PASS', 'Primary Specialty : '+Specialty+' does not contain in Expected Active Specialties - FAIL', failureHandling)
			}
		}else
			Logger.logWARNING('Primary Specialty Dropdown is not displayed')
	}


	public static String getProviderSearchTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtProviderSearch, pageName.ProviderSetup)
	}

	public static void verifyProviderSearchFunctionality() {
		String ProviderSearchValue=getProviderSearchTextBoxValue()
		try {
			String ProviderName= ProviderSearchValue.substring(0, ProviderSearchValue.indexOf('[')).trim()
			String PayrollID= ProviderSearchValue.substring(ProviderSearchValue.indexOf('[')+1, ProviderSearchValue.indexOf(']')).trim()
			String grdPayrollID=getBaseSteps().getCellTableText(grdProviderDetails, 'Payroll ID', pageName.ProviderSetup)
			String grdProviderName=getBaseSteps().getCellTableText(grdProviderDetails, 'Provider Name', pageName.ProviderSetup)
			String AssertMsg
			AssertMsg='Payroll ID validation with ProviderSearch data :'+ProviderSearchValue+' with Expected :'+PayrollID+' and Actual : '+grdPayrollID
			AssertSteps.verifyActualResult(grdPayrollID.equals(PayrollID), AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.STOP_ON_FAILURE)
			AssertMsg='Provider Name validation with ProviderSearch data :'+ProviderSearchValue+' with Expected :'+ProviderName+' and Actual : '+grdProviderName
			AssertSteps.verifyActualResult(grdProviderName.equals(ProviderName), AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.STOP_ON_FAILURE)
		}catch(IndexOutOfBoundsException e) {
			Logger.logWARNING("Provider Data may not exist with Provider Search Value : "+ProviderSearchValue)
		}
	}

	public static String getUniversalSearchTextBoxValue() {
		return getBaseSteps().getValueFromControl(txtUniversalSearch, pageName.ProviderSetup)
	}

	public static void verifyUniversalSearchFunctionality() {

		String UniversalSearchValue=getUniversalSearchTextBoxValue()
		
		if(!isValidationMessageDisplayed())
		{	
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			getBaseSteps().waitForControlClickable(grdProviderDetails, pageName.ProviderSetup)
			String records=getBaseSteps().getRowTableCounts(grdProviderDetails, pageName.ProviderSetup)
			String randomRecord
			if(records!=2)
				randomRecord=CommonUtilities.generateRandomInteger(records.toInteger()).toString()
			else
				randomRecord=records
			String grdPayrollID=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Payroll ID', pageName.ProviderSetup)
			String grdNPINumber=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'NPI Number', pageName.ProviderSetup)
			String grdProviderName=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Provider Name', pageName.ProviderSetup)
			String grdRegion=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Region', pageName.ProviderSetup)
			String grdLocation=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Location', pageName.ProviderSetup)
			String grdCostCenter=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Cost Center', pageName.ProviderSetup)
			String grdHIICCID=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'HII CC ID', pageName.ProviderSetup)
			String grdSpecialty=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Specialty', pageName.ProviderSetup)
			String grdPositionLevel=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Position Level', pageName.ProviderSetup)
			String grdEmployeeType=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Employee Type', pageName.ProviderSetup)
			String grdContractStatus=getBaseSteps().getCellTableText(grdProviderDetails,randomRecord, 'Contract Status', pageName.ProviderSetup)
	
			String AssertHeader='\n Universal Search data :'+UniversalSearchValue+' validation with record no:'+randomRecord
			String AssertMsg=AssertHeader+' match'
			boolean blnSearch
			if(grdPayrollID.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Payroll ID : '+grdPayrollID
			}
			if(grdNPINumber.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n NPI Number : '+grdNPINumber
			}
			if(grdProviderName.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Provider Name : '+grdProviderName
			}
			if(grdRegion.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Region : '+grdRegion
			}
			if(grdLocation.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Location : '+grdLocation
			}
			if(grdCostCenter.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Cost Center : '+grdCostCenter
			}
			if(grdHIICCID.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n HII CC ID : '+grdHIICCID
			}
			if(grdSpecialty.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Specialty : '+grdSpecialty
			}
			if(grdPositionLevel.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Position Level : '+grdPositionLevel
			}
			if(grdEmployeeType.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Employee Type : '+grdEmployeeType
			}
			if(grdContractStatus.contains(UniversalSearchValue))
			{
				blnSearch=true
				AssertMsg=AssertMsg+'\n Contract Status :'+grdContractStatus
			}
	
			AssertSteps.verifyActualResult(blnSearch, AssertMsg+'  - PASS', AssertHeader+' did not match - FAIL', FailureHandling.STOP_ON_FAILURE)
		}else {
			String AssertMsg='Records does not exist for Universal Search : '+UniversalSearchValue+' and Validation Message validation : '+HIIConstants.getNorecordsavailableMsg()
			AssertSteps.verifyActualResult(getValidationMessage().equals(HIIConstants.getNorecordsavailableMsg()), AssertMsg+' - PASS', AssertMsg+' - FAIL')
		}
			 
	}

	public static void clickSearchClear() {
		boolean blnDisplayed=isSearchClearButtonDisplayed()
		'Verifying Search Clear Button whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Search Clear Button Displayed', 'Search Clear Button is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed)
		{
			getBaseSteps().clickToControl(btnSearchClear, pageName.ProviderSetup)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}
	}

	public static void verifySearchClearFunctionality() {
		String ProviderSearchValue=getProviderSearchTextBoxValue()
		String UniversalSearchValue=getUniversalSearchTextBoxValue()
		boolean blnValidation=ProviderSearchValue.isEmpty() && UniversalSearchValue.isEmpty()
		AssertSteps.verifyActualResult(blnValidation, 'Search Clear button functionality is clearing Provider Search TextBox & Universal Search TextBox - PASS', 'Search Clear button functionality is not clearing Provider Search TextBox OR Universal Search TextBox - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	public static void clickExportExcelAndVerifyExcelExported() {
		boolean blnDisplayed=this.isExportExcelDisplayed()
		String ExcelName=HIIConstants.PhysicianDetailsExcel
		'Verifying Export Excel whether displayed or not'
		AssertSteps.verifyActualResult(blnDisplayed, 'Export Excel Option is Displayed', 'Export Excel Option is not Displayed', FailureHandling.CONTINUE_ON_FAILURE)

		if(blnDisplayed) {

			if(Utilities.checkFileExists(ExcelName)) {
				Utilities.deleteFile(ExcelName)
			}

			getBaseSteps().clickToControl(this.imgExcelDn, pageName.ProviderSetup)

			Utilities.waitForFileDownloaded(ExcelName, 2000)

			AssertSteps.verifyActualResult(Utilities.checkFileExists(ExcelName), 'Physician Details Excel:'+ExcelName+' exported successfully', 'Physician Details Excel:'+ExcelName+' export failed', FailureHandling.STOP_ON_FAILURE)


		}
	}

	public static void verifyExportedExcel() {

		HashMap<String,String> grdData=new HashMap<String,String>()
		grdData=getPhysicianDetailsFromGrid()
		grdData.remove('Edit')
		grdData.remove('Active')
		grdData.put('Active', getBaseSteps().isCellTableCheckBoxActive(grdProviderDetails, 'Active', pageName.ProviderSetup))
		HashMap<String,String> excelData=new HashMap<String,String>()
		excelData=ExcelUtilities.getExcelData(HIIConstants.PhysicianDetailsExcel)
		String grdValue,excelValue
		for(String grdColumm:grdData.keySet())
		{
			grdValue=grdData.get(grdColumm)
			if(excelData.get(grdColumm).equals('null'))
				excelValue=''
			else
				excelValue=excelData.get(grdColumm)


			switch(grdColumm) {
				case 'Created Date':
					excelValue=excelData.getAt('Created On')
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break
				case 'Cost Center':
					excelValue=excelData.getAt('Primary Cost Center')
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break
				case 'Specialty':
					excelValue=excelData.getAt('Primary Specialty')
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break
				case 'Location':
					excelValue=excelData.getAt(grdColumm).split(',')[0]
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break
				case 'Active':
					if(excelData.get(grdColumm).equals('Yes'))
						excelValue='true'
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break
				case 'HII CC ID':
					Logger.logINFO('HII CC ID is not capturing into Excel')
					break
				default:
					AssertSteps.verifyActualResult(grdValue.equals(excelValue), 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - PASS', 'Validating Data :'+grdColumm+' , from Application Table :'+grdValue+' and Exported Excel :'+excelValue+'  - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
					break

			}
		}



	}

	public static HashMap<String,String> getPhysicianDetailsFromGrid() {

		HashMap<String,String> grdData=new HashMap<String,String>()
		if(isPhysicianDetailsGridDisplayed()) {
			List<String> grdHeadings=new ArrayList<String>()
			grdHeadings=getBaseSteps().getTableHeadingsWithSortingTag(this.grdProviderDetailsHeaders, pageName.ProviderSetup)
			for(String Heading:grdHeadings)
				grdData.put(Heading, getBaseSteps().getCellTableText(grdProviderDetails, Heading, pageName.ProviderSetup))
		}
		return grdData
	}

	public static HashMap<String,String> getPhysicianDetailsFromGrid(String Provider) {

		openProviderSetup_newTab()

		clickSearchClear()
		setProviderSearch(Provider)

		HashMap<String,String> grdData=new HashMap<String,String>()
		if(isPhysicianDetailsGridDisplayed()) {
			List<String> grdHeadings=new ArrayList<String>()
			grdHeadings=getBaseSteps().getTableHeadingsWithSortingTag(this.grdProviderDetailsHeaders, pageName.ProviderSetup)
			for(String Heading:grdHeadings)
				grdData.put(Heading, getBaseSteps().getCellTableText(grdProviderDetails, Heading, pageName.ProviderSetup))
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return grdData


	}

	public static HashMap<String,String> getSetOfProvidersAndEmployeeType(Collection<String> lstProvider) {
		HashMap<String,String> ProviderEmployeeType=new HashMap<String,String>()
		String ProviderName
		String EmployeeType
		openProviderSetup_newTab()

		for(String Provider:lstProvider) {
			clickSearchClear()
			setProviderSearch(Provider)
			if(isPhysicianDetailsGridDisplayed()) {
				ProviderName=getBaseSteps().getCellDataActive(grdProviderDetails, 'Provider Name', 'Active', pageName.ProviderSetup)
				EmployeeType=getBaseSteps().getCellDataActive(grdProviderDetails, 'Employee Type', 'Active', pageName.ProviderSetup)
				ProviderEmployeeType.put(ProviderName, EmployeeType)
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return ProviderEmployeeType
	}

	public static void verifyEncryptedFields(String flagSetting,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {

		String DateOfBirth=ProviderSetupSteps.getDateOfBirthTextBoxValue()
		String NPINumber=ProviderSetupSteps.getNPINumberTextBoxValue()
		String SSN=ProviderSetupSteps.getSSNTextBoxValue()
		if(flagSetting.equals(HIIConstants.No)) {
			AssertSteps.verifyActualResult(DateOfBirth.equals(HIIConstants.PS_EncryptedDateOfBirth), 'Date Of Birth Encrypted Text Expected:'+HIIConstants.PS_EncryptedDateOfBirth+' and Actual:'+DateOfBirth+' - PASS', 'Date Of Birth Encrypted Text Expected:'+HIIConstants.PS_EncryptedDateOfBirth+' and Actual:'+DateOfBirth+' - FAIL', failureHandling)
			AssertSteps.verifyActualResult(NPINumber.equals(HIIConstants.PS_EncryptedNPINumber), 'NPI Number Encrypted Text Expected:'+HIIConstants.PS_EncryptedNPINumber+' and Actual:'+NPINumber+' - PASS', 'NPI Number Encrypted Text Expected:'+HIIConstants.PS_EncryptedNPINumber+' and Actual:'+NPINumber+' - FAIL', failureHandling)
			AssertSteps.verifyActualResult(SSN.equals(HIIConstants.PS_EncryptedSSN), 'SSN Encrypted Text Expected:'+HIIConstants.PS_EncryptedSSN+' and Actual:'+SSN+' - PASS', 'SSN Encrypted Text Expected:'+HIIConstants.PS_EncryptedSSN+' and Actual:'+SSN+' - FAIL', failureHandling)
		}else if(flagSetting.equals(HIIConstants.Yes)) {
			AssertSteps.verifyActualResult(!DateOfBirth.equals(HIIConstants.PS_EncryptedDateOfBirth), 'Date Of Birth should not Encrypted and Actual:'+DateOfBirth+' - PASS', 'Date Of Birth should not Encrypted and Actual:'+DateOfBirth+' - FAIL', failureHandling)
			AssertSteps.verifyActualResult(!NPINumber.equals(HIIConstants.PS_EncryptedNPINumber), 'NPI Number should not Encrypted and Actual:'+NPINumber+' - PASS', 'NPI Number should not Encrypted and Actual:'+NPINumber+' - FAIL', failureHandling)
			AssertSteps.verifyActualResult(!SSN.equals(HIIConstants.PS_EncryptedSSN), 'SSN should not Encrypted and Actual:'+SSN+' - PASS', 'SSN should not Encrypted and Actual:'+SSN+' - FAIL', failureHandling)
		}

	}

	public static boolean isValidationMessageDisplayed() {
		return getBaseSteps().WebElementDisplayed(displayMsg, pageName.ProviderSetup)
	}
	
	public static String getValidationMessage() {
		try {
			return getBaseSteps().getTextFromControl(displayMsg, pageName.ProviderSetup)
		}catch(NoSuchElementException e) {
			Logger.logDEBUG('Validation Message is not Displayed at this time of Execution')
		}
	}
	
	public static boolean isValidationSummaryDisplayed() {
		return getBaseSteps().WebElementDisplayed(validationSummary, pageName.ProviderSetup)
	}
	
	public static String getValidationSummary() {
		try {
			return getBaseSteps().getTextFromControl(validationSummary, pageName.ProviderSetup)
		}catch(NoSuchElementException e) {
			Logger.logDEBUG('Validation Message is not Displayed at this time of Execution')
		}
	}
	
	
}
