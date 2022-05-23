package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class PayCycleMappingPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Pay Cycle Mapping ############################
	private static final String ddlRegion='ddlRegion'
	private static final String lblddlRegion='lblddlRegion'
	private static final String ddlLocation='ddlLocation'
	private static final String lblddlLocation='lblddlLocation'
	private static final String ddlPayCycle='ddlPayCycle'
	private static final String btnShowDetails='btnShowDetails'
	private static final String grdPayCycleMapping='grdPayCycleMapping'

	//##############     Pay Cycle Mapping Page WebElement Operations        #########################################

	public static void openPayCycleMappingPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuPayCycles', 'mnuPayCycleMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setRegion(String Region) {
		getBaseSteps().clickToControl(ddlRegion, pageName.PayCycleMapping)
		getBaseSteps().clickLabelwithtext(lblddlRegion, Region, pageName.PayCycleMapping)
		getBaseSteps().clickEnter()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setLocation(String Location) {
		getBaseSteps().clickToControl(ddlLocation, pageName.PayCycleMapping)
		getBaseSteps().clickLabelwithtext(lblddlLocation, Location, pageName.PayCycleMapping)
		getBaseSteps().clickEnter()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setPayCycle(String PayCycle) {
		getBaseSteps().selectByVisibleText(ddlPayCycle, PayCycle, pageName.PayCycleMapping)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickShowDetails() {
		getBaseSteps().clickToControl(btnShowDetails, pageName.PayCycleMapping)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	//##############     DEPENDENCY METHODS         #########################################
	public static Collection<String> getPayCycleMappedtoRegion(String Region){

		openPayCycleMappingPage_newTab()

		setRegion(Region)

		clickShowDetails()

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		Set<String> lstPayCycle=new HashSet<String>()
		lstPayCycle=getBaseSteps().getColumnTableActiveText(grdPayCycleMapping, 'Pay Cycle', 'Active', pageName.PayCycleMapping)

		getBaseSteps().closeWindow()

		getBaseSteps().switchtoMainWindow()

		return 	lstPayCycle

	}

	public static Collection<String> getLocationMappedtoRegionPayCycle(String Region,String PayCycle){

		openPayCycleMappingPage_newTab()

		setRegion(Region)

		setPayCycle(PayCycle)

		clickShowDetails()

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		Set<String> lstLocation=new HashSet<String>()
		lstLocation=getBaseSteps().getColumnTableActiveText(grdPayCycleMapping, 'Location', 'Active', pageName.PayCycleMapping)

		getBaseSteps().closeWindow()

		getBaseSteps().switchtoMainWindow()

		return 	lstLocation

	}

	public static String getPayCycleMappedtoRegionLocation(String Region,String Location){

		openPayCycleMappingPage_newTab()

		setRegion(Region)

		setLocation(Location)

		clickShowDetails()

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)


		String PayCycle=getBaseSteps().getCellDataActive(grdPayCycleMapping, 'Pay Cycle', 'Active', pageName.PayCycleMapping)

		getBaseSteps().closeWindow()

		getBaseSteps().switchtoMainWindow()

		return 	PayCycle

	}

}
