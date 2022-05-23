package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class SpecialtyPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	static final String grdSpecilaity='grdSpecilaity'

	public static void openSpecialty_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuSpecialty', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static Collection<String> getSpecialtyName(){

		Set<String> lstSpecialty=new HashSet<String>()
		openSpecialty_newTab()
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		lstSpecialty=getBaseSteps().getColumnTableActiveText(grdSpecilaity, 'Specialty Name', 'Active', pageName.Specialty)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return lstSpecialty
	}
}
