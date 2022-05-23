package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ApprovalLevelSettingsForRolePageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String ddlRegion='ddlRegion'
	private static final String ddlCompModel='ddlCompModel'
	private static final String ddlchkCompModel='ddlchkCompModel'
	private static final String ddlPayElement='ddlPayElement'
	private static final String ddlchkPayElement='ddlchkPayElement'
	private static final String grdApprovalRolesSettings='grdApprovalRolesSettings'


	public static void openApprovalLevelSettingsForRole_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuUserManagement', 'mnuApprovalLevelSettingsforRole', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ApprovalLevelSettingsForRole)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCompModel(String CompensationModel) {
		getBaseSteps().clickToControl(ddlCompModel, pageName.ApprovalLevelSettingsForRole)
		getBaseSteps().clickLabelwithtext(ddlchkCompModel, CompensationModel, pageName.ApprovalLevelSettingsForRole)
		getBaseSteps().clickEnter()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayElement(String PayElement) {
		getBaseSteps().clickToControl(ddlPayElement, pageName.ApprovalLevelSettingsForRole)
		getBaseSteps().clickLabelwithtext(ddlchkPayElement, PayElement, pageName.ApprovalLevelSettingsForRole)
		getBaseSteps().clickEnter()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static HashMap<String,String> getApprovalLevelSettings(String Region,String CompensationModel,String PayElement) {

		HashMap<String,String> hmApprovalLevelSettings=new HashMap<String,String>()

		openApprovalLevelSettingsForRole_newTab()
		selectRegion(Region)
		selectCompModel(CompensationModel)
		selectPayElement(PayElement)

		hmApprovalLevelSettings.put('Level 1 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 1 Approval', pageName.ApprovalLevelSettingsForRole))
		hmApprovalLevelSettings.put('Level 2 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 2 Approval', pageName.ApprovalLevelSettingsForRole))
		hmApprovalLevelSettings.put('Level 3 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 3 Approval', pageName.ApprovalLevelSettingsForRole))
		hmApprovalLevelSettings.put('Level 4 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 4 Approval', pageName.ApprovalLevelSettingsForRole))
		hmApprovalLevelSettings.put('Level 5 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 5 Approval', pageName.ApprovalLevelSettingsForRole))
		hmApprovalLevelSettings.put('Level 6 Approval', getBaseSteps().getCellTableText(grdApprovalRolesSettings, 'Level 6 Approval', pageName.ApprovalLevelSettingsForRole))

		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return hmApprovalLevelSettings
	}
}
