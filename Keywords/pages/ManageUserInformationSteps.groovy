package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import configs.HIIConstants
import internal.GlobalVariable

public class ManageUserInformationSteps {


	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Provider Pay Request ############################
	private static String ddlUserRole='ddlUserRole'
	private static String txtUniversalSearch='txtUniversalSearch'
	private static String btnSearch='btnSearch'
	private static String btnSearchClear='btnSearchClear'
	private static String grdUserDetails='grdUserDetails'
	private static String btnRoleSettingsAccess='btnRoleSettingsAccess'
	private static String grdRoleSettingsAccess='grdRoleSettingsAccess'
	private static String ddlRoleSettingsAccessRole='ddlRoleSettingsAccessRole'
	private static String rdoReadWrite='rdoReadWrite'
	private static String ddlRoleName='ddlRoleName'
	private static String ddlSettingType='ddlSettingType'

	//########################### PAY REQUEST METHODS ####################################

	public static void selectUserRole(String UserRole) {
		getBaseSteps().selectByVisibleText('ddlUserRole', UserRole, pageName.ManageUserInformation)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setUniversalSearch(String UniversalSearch) {
		getBaseSteps().waitForControlDisplay('txtUniversalSearch', 30,pageName.ManageUserInformation)
		getBaseSteps().setTextToControl('txtUniversalSearch', UniversalSearch, pageName.ManageUserInformation)
	}

	public static void clickSearch() {
		getBaseSteps().clickToControl('btnSearch', pageName.ManageUserInformation)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRoleName(String RoleName) {
		getBaseSteps().selectByVisibleText(ddlRoleName, RoleName, pageName.ManageUserInformation)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectSettingType(String SettingType) {
		getBaseSteps().selectByVisibleText(ddlSettingType, SettingType, pageName.ManageUserInformation)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}


	public static void gotoManageUserInformation() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuManageUserInformation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void openManageUserInformation_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuUserManagement', 'mnuManageUserInformation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}







	public static void viewUserDetails() {
		getBaseSteps().clickToCellTableImage('grdUserDetails', 'View', pageName.ManageUserInformation)
		getBaseSteps().waitForControlDisplay('lblHeader', pageName.ManageUserInformation)
	}

	public static void viewUserDetailsWithUserName(String UserName) {
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().clickToCellTableImage('grdUserDetails', 'View', pageName.ManageUserInformation)
		getBaseSteps().waitForControlDisplay('lblHeader', pageName.ManageUserInformation)
	}

	public static void clickRoleSetingsAccess() {
		getBaseSteps().clickToControl('btnRoleSettingsAccess', pageName.ManageUserInformation)
		getBaseSteps().waitForControlDisplay('ddlRoleSettingsAccessRole', pageName.ManageUserInformation)
	}

	public static boolean getAccessLevel_ProviderPayRequest() {
		String NoofRows=getBaseSteps().getTableRowCount('grdRoleSettingsAccess', pageName.ManageUserInformation)
		String rdoReadWrite="//table[contains(@id,'rdBtnLstAccessControl')]/tbody/tr/td[2]/span"

		boolean ProviderPayRequest=false
		for(int i=1;i<=Integer.parseInt(NoofRows);i++) {
			//getBaseSteps().getCellTableText_thead('grdRoleSettingsAccess', i.toString(), 'SettingType', pageName.ManageUserInformation)
			if(getBaseSteps().getCellTableRadioButtonChecked('grdRoleSettingsAccess', i.toString(), 'Access Level', rdoReadWrite, pageName.ManageUserInformation))
				ProviderPayRequest=true
		}

		return ProviderPayRequest
	}


	public static boolean getProviderPayRequest_Eligiblity(String ProviderID) {
		gotoManageUserInformation()
		selectUserRole('Provider')
		setUniversalSearch(ProviderID)
		clickSearch()
		viewUserDetails()
		clickRoleSetingsAccess()
		return getAccessLevel_ProviderPayRequest()
	}

	public static Collection<String> getRegionsList(String UserName,String UserRole) {

		'Step: Open Manage User Information in new tab'
		openManageUserInformation_newTab()

		'Step: Select Role'
		selectUserRole(UserRole)

		'Step: set Universal Search'
		setUniversalSearch(UserName)

		'Step: click Search button'
		clickSearch()

		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)

		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

		getBaseSteps().clickToimgCellDependentTable(this.grdUserDetails, 'View', 'User Name', UserName, pageName.ManageUserInformation)

		clickRoleSetingsAccess()

		selectRoleName(UserRole)

		selectSettingType('Region')

		Set<String> RegionsMapped=new HashSet<String>();
		RegionsMapped=getBaseSteps().getColumnTableText_thead(grdRoleSettingsAccess,'Value', pageName.ManageUserInformation)

		getBaseSteps().closeWindow()
		
		getBaseSteps().switchtoMainWindow()


		if(RegionsMapped.size()==1 && RegionsMapped.getAt(0).equals('--ALL--'))
		{
			Set<String> activeRegions=new HashSet<String>()
			activeRegions=RegionPageSteps.getActiveRegions()
			return activeRegions
		}else {
			return RegionsMapped
		}
		



	}
}
