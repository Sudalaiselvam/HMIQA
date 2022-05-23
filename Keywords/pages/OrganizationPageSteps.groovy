package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class OrganizationPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}
	
	//Open Organization Page in new tab
	public static void openRegionPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuOrganization', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	
	private static final String grdOrganization='grdOrganization'
	
	//to get Organization Name
	public static String getOrganizationName() {
		openRegionPage_newTab()
		String Organization
		Organization=getBaseSteps().getCellTableText(grdOrganization, 'Organization Name', pageName.Organization)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickEscape()
		return Organization
	}
}
