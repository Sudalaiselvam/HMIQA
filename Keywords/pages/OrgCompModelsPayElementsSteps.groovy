package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
public class OrgCompModelsPayElementsSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static String lblOrganization='lblOrganization'
	private static String ddRegion='ddRegion'
	private static String ddllblRegion='ddllblRegion'
	private static String ddCompensationModel='ddCompensationModel'
	private static String ddllblCompensationModel='ddllblCompensationModel'

	private static String btnShowDetails='btnShowDetails'
	private static String imgExpandall='imgExpandall'
	private static String chkPayElements='chkPayElements'

	//Open Org Comp Models Pay Elements new tab
	public static void openOrgCompModelsPayElements_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuOrgCompModelsPayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRegion(String Region) {
		getBaseSteps().clickToControl(ddRegion, pageName.OrgCompModelsPayElements)
		getBaseSteps().clickLabelwithtext(ddllblRegion, Region, pageName.OrgCompModelsPayElements)
		getBaseSteps().clickToControl(lblOrganization, pageName.OrgCompModelsPayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().clickToControl(ddCompensationModel, pageName.OrgCompModelsPayElements)
		getBaseSteps().clickLabelwithtext(ddllblCompensationModel, CompensationModel, pageName.OrgCompModelsPayElements)
		getBaseSteps().clickToControl(lblOrganization, pageName.OrgCompModelsPayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickShowDetails() {
		getBaseSteps().clickToControl(btnShowDetails, pageName.OrgCompModelsPayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickExpandAll() {
		getBaseSteps().clickToControl(imgExpandall, pageName.OrgCompModelsPayElements)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getCheckedPayElements() {
		List<String> lstPayElements=new ArrayList<String>()
		List<String> lstchkPayElements=new ArrayList<String>()
		lstPayElements=getBaseSteps().getListTextFromControl(chkPayElements, pageName.OrgCompModelsPayElements)
		for(String chkPayElement:lstPayElements)
			lstchkPayElements.add(chkPayElement.split(' - ').getAt(0).trim())

		return lstchkPayElements
	}

	public static List<String> getPayElementsWRTRegionCompensationModel(String Region,String CompensationModel){
		openOrgCompModelsPayElements_newTab()

		selectRegion(Region)

		selectCompensationModel(CompensationModel)

		clickShowDetails()

		clickExpandAll()

		List<String> lstPayElements=new ArrayList<String>()

		lstPayElements=getCheckedPayElements()

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

		return lstPayElements
	}

	public static Collection<String> getCompensationModel(String Region){
		openOrgCompModelsPayElements_newTab()
		selectRegion(Region)
		clickShowDetails()
		clickExpandAll()

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)

	}

}
