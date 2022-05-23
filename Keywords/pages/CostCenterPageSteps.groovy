package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

/**
 * @author AnilKumarJanapareddy
 *
 */
public class CostCenterPageSteps {

	static final String ddlRegion='ddlRegion'
	static final String ddlLocation='ddlLocation'
	static final String txtUniversalSearch='txtUniversalSearch';
	static final String btnSearch='btnSearch';
	static final String grdCostCenter='grdCostCenter';

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void gotoCostCenter() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuCostCenter', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void openCostCenter_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuCostCenter', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Region
	 */
	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.CostCenter)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param Location
	 */
	public static void selectLocation(String Location) {
		getBaseSteps().selectByVisibleText(ddlLocation, Location, pageName.CostCenter)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @param UniversalSearch
	 */
	public static void setUniversalSearch(String UniversalSearch) {
		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.CostCenter)
	}

	/**
	 * 
	 */
	public static void clickSearch() {
		getBaseSteps().clickToControl(btnSearch, pageName.CostCenter)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	/**
	 * @return
	 */
	public static String getRegion() {
		return getBaseSteps().getCellTableText(grdCostCenter, 'Region', pageName.CostCenter)
	}

	/**
	 * @return
	 */
	public static String getLocation() {
		return getBaseSteps().getCellTableText(grdCostCenter, 'Location', pageName.CostCenter)
	}

	/**
	 * @param HIICCID
	 * @return
	 */
	public static HashMap<String,String> getRegionLocationforHIICCID(String HIICCID){

		this.openCostCenter_newTab()
		this.setUniversalSearch(HIICCID)
		this.clickSearch()

		String strHIICCID,strRegion,strLocation,strCostCenter
		HashMap<String,String> hmRL=new HashMap<String,String>();


		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
		//println rowCount
		for(int i=2;i<=rowCount;i++) {
			strHIICCID=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'HII CC ID', pageName.CostCenter)
			//println strHIICCID
			if(strHIICCID.equals(HIICCID)) {
				strRegion=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Region', pageName.CostCenter)
				strLocation=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Location', pageName.CostCenter)
				strCostCenter=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter)
				break
			}
		}
		hmRL.put('Region', strRegion)
		hmRL.put('Location', strLocation)
		hmRL.put('CostCenter',strCostCenter)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return hmRL
	}

	/**
	 * @param CostCenterName
	 * @return
	 */
	public static String getRegionforCostCenterName(String CostCenterName){

		this.openCostCenter_newTab()
		this.setUniversalSearch(CostCenterName)
		this.clickSearch()

		String strCostCenter,strRegion

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
		for(int i=2;i<=rowCount;i++) {
			strCostCenter=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter)
			if(strCostCenter.equals(CostCenterName)) {
				strRegion=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Region', pageName.CostCenter)
				break
			}
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return strRegion
	}

	/**
	 * @param CostCenterName
	 * @return
	 */
	public static String getHIICCIDCostCenterShortNameforCostCenterName(String CostCenterName){

		openCostCenter_newTab()
		setUniversalSearch(CostCenterName)
		clickSearch()

		String strCostCenter,strRegion,strHIICCID,strCostCenterShortName,strFormat

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
		for(int i=2;i<=rowCount;i++) {
			strCostCenter=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter)
			if(strCostCenter.equals(CostCenterName)) {
				strHIICCID=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'HII CC ID', pageName.CostCenter)
				strCostCenterShortName=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Short Name', pageName.CostCenter)
				strFormat=strHIICCID+'-'+strCostCenterShortName
				break
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return strFormat
	}

	/**
	 * @param CostCenterName
	 * @return
	 */
	public static String getHIICCIDforCostCenterName(String CostCenterName){

		openCostCenter_newTab()
		setUniversalSearch(CostCenterName)
		clickSearch()

		String strCostCenter,strRegion,strHIICCID,strCostCenterShortName,strFormat

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
		for(int i=2;i<=rowCount;i++) {
			strCostCenter=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter)
			if(strCostCenter.equals(CostCenterName)) {
				strHIICCID=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'HII CC ID', pageName.CostCenter)
				strFormat=strHIICCID
				break
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return strFormat
	}

	/**
	 * @param lstCostCenterName
	 * @return
	 */
	public static List<String> getHIICCIDCostCenterShortNameforListCostCenterName(List<String> lstCostCenterName){

		List<String> lstFormatCC=new ArrayList<String>()
		openCostCenter_newTab()
		for(String CostCenterName:lstCostCenterName)
		{
			setUniversalSearch(CostCenterName)
			clickSearch()
			String strCostCenter,strRegion,strHIICCID,strCostCenterShortName,strFormat
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
			for(int i=2;i<=rowCount;i++) {
				strCostCenter=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter)
				if(strCostCenter.equals(CostCenterName)) {
					strHIICCID=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'HII CC ID', pageName.CostCenter)
					strCostCenterShortName=getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Short Name', pageName.CostCenter)
					strFormat=strHIICCID+'-'+strCostCenterShortName
					lstFormatCC.add(strFormat)
					break
				}
			}
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		return lstFormatCC
	}

	/**
	 * @param Region
	 * @param Location
	 * @return
	 */
	public static List<String> getCostCenterNameWRTRegionLocation(String Region,String Location) {

		List<String> lstCostCenterName=new ArrayList<String>()

		openCostCenter_newTab()
		selectRegion(Region)
		selectLocation(Location)

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		int rowCount=getBaseSteps().getRowTableCounts(grdCostCenter, pageName.CostCenter).toInteger()
		for(int i=2;i<=rowCount;i++) {
			lstCostCenterName.add(getBaseSteps().getCellTableText(grdCostCenter,i.toString(), 'Cost Center Name', pageName.CostCenter))
		}

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return lstCostCenterName


	}

	/**
	 * @param Region
	 * @param Location
	 * @return
	 */
	public static Set<String> getListOfCostCentersMappedtoRegionLocation(String Region,String Location){

		openCostCenter_newTab()

		Set<String> lstCostCenter=new HashSet<String>()

		selectRegion(Region)
		selectLocation(Location)

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		lstCostCenter=getBaseSteps().getColumnTableActiveText(grdCostCenter, 'Cost Center Name', 'Active', pageName.CostCenter)

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return lstCostCenter
	}
}
