package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName


/**
 * @author AnilKumarJanapareddy
 *
 */
public class CompModelPayElementSettingsPageSteps {

	protected static BaseSteps getBaseSteps() {
		return new BaseSteps(new ControlFactory());
	}

	//Open Pay Element Column Configuration new tab
	public static void openCompModelPayElementSettings_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuCompModelPayElementSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static final String ddlRegion='ddlRegion'
	private static final String ddlCompensationModel='ddlCompensationModel'
	private static final String ddlbtnSpecialty='ddlbtnSpecialty'
	private static final String ddllblSpecialty='ddllblSpecialty'
	private static final String ddlbtnCostCenter='ddlbtnCostCenter'
	private static final String ddllblCostCenter='ddllblCostCenter'
	private static final String grdDefaultPayElement='grdDefaultPayElement'
	private static final String ddlYear='ddlYear'

	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.CompModelPayElementSettings)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param CompensationModel
	 */
	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.CompModelPayElementSettings)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Specialty
	 */
	public static void selectSpecialty(String Specialty) {
		getBaseSteps().clickToControl(ddlbtnSpecialty, pageName.CompModelPayElementSettings)
		getBaseSteps().clickLabelwithtext(ddllblSpecialty, Specialty, pageName.CompModelPayElementSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param CostCenter
	 */
	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().clickToControl(ddlbtnCostCenter, pageName.CompModelPayElementSettings)
		getBaseSteps().clickLabelwithtext(ddllblCostCenter, CostCenter, pageName.CompModelPayElementSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Year
	 */
	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.CompModelPayElementSettings)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Region
	 * @param CompensationModel
	 * @param Specialty
	 * @param CostCenter
	 * @param Year
	 * @return List of Pay Element Mapped by default
	 */
	public static List<String> getDefaultPaymentMapped(String Region,String CompensationModel,String Specialty,String CostCenter,String Year){
		List<String> lstPayElement=new ArrayList<String>()
		openCompModelPayElementSettings_newTab()
		selectRegion(Region)
		selectCompensationModel(CompensationModel)
		selectSpecialty(Specialty)
		selectCostCenter(CostCenter)
		selectYear(Year)
		if(getBaseSteps().WebElementDisplayed(grdDefaultPayElement, pageName.CompModelPayElementSettings))
		{
			int rowCount=(getBaseSteps().getRowTableCounts(grdDefaultPayElement, pageName.CompModelPayElementSettings)).toInteger()
			int i=2
			while(i<rowCount) {
				lstPayElement.add(getBaseSteps().getCellDataActive(grdDefaultPayElement, i.toString(), 'Pay Element', 'Active', pageName.CompModelPayElementSettings))
				i++
			}
			//lstPayElement=getBaseSteps().getColumnTableActiveText(grdDefaultPayElement, 'Pay Element', 'Active', pageName.CompModelPayElementSettings)
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return lstPayElement
	}

}
