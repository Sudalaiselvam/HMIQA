package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ProviderEMRDataPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String ddlRegion='ddlRegion'
	private static final String ddlCostCenter='ddlCostCenter'
	private static final String ddlYear='ddlYear'
	private static final String ddlMonth='ddlMonth'
	private static final String txtProviderName='txtProviderName'
	private static final String chkIncludeAdjustments='chkIncludeAdjustments'
	private static final String btnGo='btnGo'
	private static final String btnClear='btnClear'
	private static final String ddlselectMissingType='ddlselectMissingType'
	private static final String btnDownload='btnDownload'
	private static final String btnExportwRVUstRVUscalculationReport='btnExportwRVUstRVUscalculationReport'
	private static final String btnExportExcel='btnExportExcel'
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnSearch='btnSearch'

	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ProviderEMRData)
	}

	/**
	 * @param CostCenter
	 */
	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().selectByVisibleText(ddlCostCenter, CostCenter, pageName.ProviderEMRData)
	}

	/**
	 * @param Year
	 */
	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.ProviderEMRData)
	}

	/**
	 * @param Month
	 */
	public static void selectMonth(String Month) {
		getBaseSteps().selectByVisibleText(ddlMonth, Month, pageName.ProviderEMRData)
	}

	/**
	 * @param ProviderName
	 */
	public static void setProviderName(String ProviderName) {
		getBaseSteps().setTextToControl(txtProviderName, ProviderName, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void checkIncludeAdjustments() {
		getBaseSteps().ActiveCheckBox(chkIncludeAdjustments, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void uncheckIncludeAdjustments() {
		getBaseSteps().InactiveCheckBox(chkIncludeAdjustments, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickGo() {
		getBaseSteps().clickToControl(btnGo, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.ProviderEMRData)
	}

	/**
	 * @param MissingTyp
	 */
	public static void selectMissingType(String MissingType) {
		getBaseSteps().selectByVisibleText(ddlselectMissingType, MissingType, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickDownload() {
		getBaseSteps().clickToControl(btnDownload, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickExportwRVUstRVUsCalculationReport() {
		getBaseSteps().clickToControl(btnExportwRVUstRVUscalculationReport, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickExportExcel() {
		getBaseSteps().clickToControl(btnExportExcel, pageName.ProviderEMRData)
	}

	/**
	 * @param UniversalSearch
	 */
	public static void setUniveralSearch(String UniversalSearch) {
		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.ProviderEMRData)
	}

	/**
	 * 
	 */
	public static void clickSearch() {
		getBaseSteps().clickToControl(btnSearch, pageName.ProviderEMRData)
	}
}
