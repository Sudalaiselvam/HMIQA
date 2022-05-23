package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

/**
 * @author AnilKumarJanapareddy
 *
 */
public class CompensationModelSpecialtyMappingPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	static final String ddlRegion='ddlRegion'
	static final String ddlCompensationModel='ddlCompensationModel'
	static final String grdCompModelSpecialty='grdCompModelSpecialty'

	/**
	 * 
	 */
	public static void openCompensationModelSpecialtyMapping_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuCompModelSpecialtyMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.CompensationModelSpecialtyMapping)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param CompensationModel
	 */
	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.CompensationModelSpecialtyMapping)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Region
	 * @param CompensationModel
	 * @return
	 */
	public static Collection<String> getSpecialtyMappedWRTRegionCompensationModel(String Region,String CompensationModel) {

		String SpecialtyMappped

		openCompensationModelSpecialtyMapping_newTab()
		selectRegion(Region)
		selectCompensationModel(CompensationModel)
		SpecialtyMappped=getBaseSteps().getCellDataActive(grdCompModelSpecialty, 'Specialty', 'Is Active', pageName.CompensationModelSpecialtyMapping)

		//List<String> lstSpecialty=Arrays.asList(SpecialtyMappped.split(','))

		List<String> lstSpecialty=new ArrayList<String>()
		String[] aSpecialty=SpecialtyMappped.split(',')
		for(String Specialty:aSpecialty)
			lstSpecialty.add(Specialty.trim())

		getBaseSteps().closeWindow()

		getBaseSteps().switchtoMainWindow()

		return lstSpecialty

	}
}
