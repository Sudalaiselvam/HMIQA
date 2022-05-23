package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class RegionPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Region ############################
	private static final String grdRegion='grdRegion'

	public static void gotoRegion() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy','mnuRegion', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void openRegionPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuRegion', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	public static Collection<String> getActiveRegions() {

		openRegionPage_newTab()
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Set<String> lstRegions=new HashSet<String>()
		lstRegions=getBaseSteps().getColumnTableActiveText(grdRegion, 'Region Name', 'Active', pageName.Region)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return lstRegions

	}
}
