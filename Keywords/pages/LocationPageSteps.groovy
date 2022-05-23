package pages

import core.AssertSteps
import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling

public class LocationPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Locations ############################
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnUniversalSearch='btnUniversalSearch'
	private static final String grdLocations='grdLocations'
	private static final String btnClear='btnClear'
	private static final String ddlRegion='ddlRegion'

	//############### Location Page Operations ######################################

	public static void openLocationPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuLocation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setUniversalSearch(String UniversalSearch) {

		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.Location)
	}

	public static void clickUniversalSearch() {
		getBaseSteps().clickToControl(btnUniversalSearch, pageName.Location)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.Location)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static boolean isRegionDropDownDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlRegion, pageName.Location)
	}
	public static void selectRegion(String Region) {
		boolean blnDisplayed=isRegionDropDownDisplayed()
		AssertSteps.verifyActualResult(blnDisplayed, 'Region DropDown is Displayed', 'Region DropDown is not Displayed', FailureHandling.STOP_ON_FAILURE)
		if(blnDisplayed)
		{
			getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.Location)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}

	}

	//############### Location Page DEPENDENCY METHODS ######################################

	public static Collection<String> getLocationNameWRTLocationShortName(Collection<String> cLocationShortName) {
		openLocationPage_newTab()

		Set<String> cLocationName=new HashSet<String>()
		for(String LocationShortName:cLocationShortName) {
			clickClear()
			setUniversalSearch(LocationShortName)
			clickUniversalSearch()
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			cLocationName.add(getBaseSteps().getCellDataWRTDependency(grdLocations, 'Location Name', 'Location Short Name', LocationShortName, pageName.Location))
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return cLocationName
	}

	public static String getLocationShortNameWRTLocationName(String LocationName) {
		openLocationPage_newTab()
		String LocationShortName
		clickClear()
		setUniversalSearch(LocationName)
		clickUniversalSearch()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		LocationShortName=getBaseSteps().getCellTableText(grdLocations, 'Location Short Name', pageName.Location)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return LocationShortName
	}

	public static Set<String> getListOfLocationsMappedtoRegion(String Region){
		openLocationPage_newTab()

		Set<String> lstLocations=new HashSet<String>()

		selectRegion(Region)

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		lstLocations=getBaseSteps().getColumnTableActiveText(grdLocations, 'Location Name', 'Active', pageName.Location)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return lstLocations
	}


	public static String getProviderGroupMappedToLocation(String Location) {
		openLocationPage_newTab()
		String ProviderGroup
		clickClear()
		setUniversalSearch(Location)
		clickUniversalSearch()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		ProviderGroup=getBaseSteps().getCellTableText(grdLocations, 'Provider Group', pageName.Location)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return ProviderGroup
	}

}
