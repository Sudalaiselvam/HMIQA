package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class MiscellaneousProfileSettingsPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void openMiscellaneousProfileSettings_newTab() {
		Thread.sleep(1000)
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuMiscellaneousProfileSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	private static final String ddlLookupType='ddlLookupType'
	private static final String ddlbtnSpecialty='ddlbtnSpecialty'
	private static final String ddllblSpecialty='ddllblSpecialty'
	private static final String ddlbtnRegion='ddlbtnRegion'
	private static final String ddllblRegion='ddllblRegion'
	private static final String ddlPositionLevel='ddlPositionLevel'
	private static final String ddlbtnLocation='ddlbtnLocation'
	private static final String ddllblLocation='ddllblLocation'
	private static final String ddlbtnCostCenter='ddlbtnCostCenter'
	private static final String ddllblCostCenter='ddllblCostCenter'
	private static final String btnClear='btnClear'
	private static final String btnShowDetail='btnShowDetail'
	private static final String grdMiscProfles='grdMiscProfles'
	
	public static void selectLookupType(String LookupType) {
		getBaseSteps().selectByVisibleText(ddlLookupType, LookupType, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void selectSpecialty(String Specialty) {
		getBaseSteps().clickToControl(ddlbtnSpecialty, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickLabelwithtext(ddllblSpecialty, Specialty, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void selectRegion(String Region) {
		getBaseSteps().clickToControl(ddlbtnRegion, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickLabelwithtext(ddllblRegion, Region, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void selectPositionLevel(String PositionLevel) {
		getBaseSteps().selectByVisibleText(ddlPositionLevel, PositionLevel, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void selectLocation(String Location) {
		getBaseSteps().clickToControl(ddlbtnLocation, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickLabelwithtext(ddllblLocation, Location, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().clickToControl(ddlbtnCostCenter, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickLabelwithtext(ddllblCostCenter, CostCenter, pageName.MiscellaneousProfileSettings)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static void clickShowDetail() {
		getBaseSteps().clickToControl(btnShowDetail, pageName.MiscellaneousProfileSettings)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	
	public static List<String> getLookupValue(String LookupType,String Specialty,String Region,String PositionLevel,String Location,String CostCenter){
		List<String> lstLookupValue=new ArrayList<String>()
		openMiscellaneousProfileSettings_newTab()
		selectLookupType(LookupType)
		selectSpecialty(Specialty)
		selectRegion(Region)
		selectPositionLevel(PositionLevel)
		selectLocation(Location)
		selectCostCenter(CostCenter)
		clickShowDetail()
		if(getBaseSteps().WebElementDisplayed(grdMiscProfles, pageName.MiscellaneousProfileSettings))
		{
			int rowCount=getBaseSteps().getRowTableCounts(grdMiscProfles, pageName.MiscellaneousProfileSettings).toInteger()
			int i=2
			while(i<=rowCount) {
				lstLookupValue.add(getBaseSteps().getCellTableText(grdMiscProfles, i.toString(), 'Lookup Value', pageName.MiscellaneousProfileSettings))
				i++
				}
			
			}
			//lstLookupValue=getBaseSteps().getColumnTableText(grdMiscProfles, 'Lookup Value', pageName.MiscellaneousProfileSettings)
			//lstLookupValue=getBaseSteps().getColumnTableText_thead(grdMiscProfles, 'Lookup Value', pageName.MiscellaneousProfileSettings)
			//getColumnTableText(grdMiscProfles, 'Lookup Value', pageName.MiscellaneousProfileSettings)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		return lstLookupValue
	}
}
