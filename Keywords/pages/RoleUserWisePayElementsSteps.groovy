package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import configs.HIIConstants

public class RoleUserWisePayElementsSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static String tabRoleWisePayElements='tabRoleWisePayElements'
	private static String ddlRole='ddlRole'
	private static String ddRegion='ddRegion'
	private static String ddllblRegion='ddllblRegion'
	private static String lblRegion='lblRegion'
	private static String ddCompensationModel='ddCompensationModel'
	private static String ddllblCompensationModel='ddllblCompensationModel'
	private static String lblCompensationModel='lblCompensationModel'
	private static String imgExpandall='imgExpandall'
	private static String chkPayElements='chkPayElements'

	//Open Org Comp Models Pay Elements new tab
	public static void openRoleUserWisePayElements_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuUserRoleWisePayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickRoleWisePayElements() {
		getBaseSteps().clickToControl(tabRoleWisePayElements, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRoleAsCompensationAdministrator() {
		getBaseSteps().selectByVisibleText(ddlRole, HIIConstants.ROLE_CompensationAdministrator, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRole(String Role) {
		getBaseSteps().selectByVisibleText(ddlRole, Role, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRegion(String Region) {
		getBaseSteps().clickToControl(ddRegion, pageName.RoleUserWisePayElements)
		getBaseSteps().clickLabelwithtext(ddllblRegion, Region, pageName.RoleUserWisePayElements)
		getBaseSteps().clickToControl(lblRegion, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().clickToControl(ddCompensationModel, pageName.RoleUserWisePayElements)
		getBaseSteps().clickLabelwithtext(ddllblCompensationModel, CompensationModel, pageName.RoleUserWisePayElements)
		getBaseSteps().clickToControl(lblCompensationModel, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickExpandAll() {
		getBaseSteps().clickToControl(imgExpandall, pageName.RoleUserWisePayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getCheckedPayElements() {
		List<String> lstPayElements=new ArrayList<String>()
		List<String> lstchkPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getListTextFromControl(chkPayElements, pageName.RoleUserWisePayElements)
		for(String chkPayElement:lstPayElements)
			lstchkPayElements.add(chkPayElement.split(' - ').getAt(0).trim())

		return lstchkPayElements
	}


	public static List<String> getPayElementsWRTRoleRegionCompensationModel(String Role,String Region,String CompensationModel){

		openRoleUserWisePayElements_newTab()

		clickRoleWisePayElements()

		selectRole(Role)

		selectRegion(Region)

		selectCompensationModel(CompensationModel)

		clickExpandAll()

		List<String> lstPayElements=new ArrayList<String>()

		lstPayElements=getCheckedPayElements()

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		return lstPayElements
	}



}
