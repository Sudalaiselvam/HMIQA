package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class ProviderGroupPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Region ############################
	private static final String grdProviderGroup='grdProviderGroup'


	public static void openProviderGroupPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuProviderGroup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static Collection<String> getActiveProviderGroup() {
		
				openProviderGroupPage_newTab()
				getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
				getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
				Set<String> lstProviderGroups=new HashSet<String>()
				lstProviderGroups=getBaseSteps().getColumnTableActiveText(grdProviderGroup, 'Provider Group', 'Active', pageName.ProviderGroup)
				getBaseSteps().closeWindow()
				getBaseSteps().switchtoMainWindow()
				return lstProviderGroups
		
			}
}
