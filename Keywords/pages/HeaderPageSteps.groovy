package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import core.AssertSteps
import com.kms.katalon.core.model.FailureHandling
import configs.HIIConstants
import core.Logger

/**
 * @author AnilKumarJanapareddy
 *
 */
public class HeaderPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	// =================== ACTION METHODS ZONE ======================

	public static void logOff() {
		getBaseSteps().clickToControl("imgLogOff", pageName.Header)
	}

	public static void gotoHomePage() {
		getBaseSteps().clickToControl('imgHeisenbergIILogo', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
	/*
	 public static void gotoRoleMenuMapping() {
	 getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuRoleMenuMapping', pageName.Header)
	 }
	 public static void gotoManageUserInformation() {
	 getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuManageUserInformation', pageName.Header)
	 }
	 public static void gotoGeneralSettings() {
	 getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuGeneralSettings', pageName.Header)
	 }
	 public static void gotoPayElements() {
	 getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuPayElements', pageName.Header)
	 }
	 public static void gotoOrgCompModelsPayElements() {
	 getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuOrgCompModelsPayElements', pageName.Header)
	 }
	 public static void gotoUserRoleWisePayElements() {
	 getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuUserRoleWisePayElements', pageName.Header)
	 }
	 public static void gotoProviderPayRequest() {
	 getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayRequest', pageName.Header)
	 }
	 public static void gotoProviderSetup() {
	 getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderSetup', pageName.Header)
	 }
	 public static void gotoManageProviderContract() {
	 getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract', pageName.Header)
	 }
	 */
	// =================== ASSERT METHODS ZONE ======================
	public static void verifyLogginSuccessfully() {
		getBaseSteps().verifyControlDisplayed("lblLoggedInUserIdentity", pageName.Header)
	}


	//getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

	/**************************************************************************************************************************************************************************************************
	 * 																				HOME  MENU 
	 **************************************************************************************************************************************************************************************************/	
	//Home
	//Dashboard
	public static void gotoDashboard() {
		getBaseSteps().gotoSubMenu('mnuHome', 'mnuDashboard', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToDashboard() {
		gotoDashboard()
		Thread.sleep(2000)
		boolean blnWebElement=getBaseSteps().WebElementDisplayed('navbarSupportedContent',pageName.Dashboard)
		String AssertMsg='Basic WebElement Validation after Navigating to Screen'
		AssertSteps.verifyActualResult(blnWebElement, AssertMsg+' - PASS',AssertMsg+ ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	public static boolean isPageHeaderDisplayed() {
		return getBaseSteps().WebElementDisplayed('pageHeader', pageName.Header)
	}

	public static String getPageHeader() {
		String AssertMsg='Page Header Display Validation after Navigating to Screen'
		AssertSteps.verifyActualResult(isPageHeaderDisplayed(), AssertMsg+' - PASS',AssertMsg+ ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		if(isPageHeaderDisplayed())
			return getBaseSteps().getTextFromControl('pageHeader', pageName.Header)
	}

	public static void verifyPageHeader(String expectedPageHeader) {
		String actualPageHeader=getPageHeader()
		String AssertMsg='Page Header Validation Expected : '+expectedPageHeader+' and Actual : '+actualPageHeader
		AssertSteps.verifyActualResult(actualPageHeader.equals(expectedPageHeader), AssertMsg+' - PASS',AssertMsg+ ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
	}

	//Admin
	//OrganizationalHierarchy
	public static void gotoOrganization() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuOrganization', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToOrganization() {
		gotoOrganization()
		verifyPageHeader(HIIConstants.pgOrganization)
	}

	public static void gotoRegion() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuRegion', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToRegion() {
		gotoRegion()
		verifyPageHeader(HIIConstants.pgRegion)
	}

	public static void gotoProviderGroup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuProviderGroup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderGroup() {
		gotoProviderGroup()
		verifyPageHeader(HIIConstants.pgProviderGroup)
	}

	public static void gotoLocation() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuLocation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToLocation() {
		gotoLocation()
		verifyPageHeader(HIIConstants.pgLocation)
	}

	public static void gotoCostCenter() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuCostCenter', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCostCenter() {
		gotoCostCenter()
		verifyPageHeader(HIIConstants.pgCostCenter)
	}

	public static void gotoSpecialtyGroup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuSpecialtyGroup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToSpecialtyGroup() {
		gotoSpecialtyGroup()
		verifyPageHeader(HIIConstants.pgSpecialtyGroup)
	}

	public static void gotoCrosswalkSpecialty() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuCrosswalkSpecialty', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCrosswalkSpecialty() {
		gotoCrosswalkSpecialty()
		verifyPageHeader(HIIConstants.pgCrosswalkSpecialty)
	}

	public static void gotoSpecialty() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuSpecialty', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToSpecialty() {
		gotoSpecialty()
		verifyPageHeader(HIIConstants.pgSpecialty)
	}

	public static void gotoPositionLevel() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuPositionLevel', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPositionLevel() {
		gotoPositionLevel()
		verifyPageHeader(HIIConstants.pgPositionLevel)
	}

	public static void gotoGeneralSettings() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuGeneralSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToGeneralSettings() {
		gotoGeneralSettings()
		verifyPageHeader(HIIConstants.pgGeneralSettings)
	}

	public static void gotoManageMenuList() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuManageMenuList', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToManageMenuList() {
		gotoManageMenuList()
		verifyPageHeader(HIIConstants.pgManageMenuList)
	}

	public static void gotoHRInterfaceProviderStatusMapping() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuHRInterfaceProviderStatusMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToHRInterfaceProviderStatusMapping() {
		gotoHRInterfaceProviderStatusMapping()
		verifyPageHeader(HIIConstants.pgHRInterfaceProviderStatusMapping)
	}

	public static void gotoPayElementWiseReason() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuPayElementWiseReason', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElementWiseReason() {
		gotoPayElementWiseReason()
		verifyPageHeader(HIIConstants.pgPayElementWiseReason)
	}

	public static void gotoBulletinMessage() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuOrganizationalHierarchy', 'mnuBulletinMessage', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToBulletinMessage() {
		gotoBulletinMessage()
		verifyPageHeader(HIIConstants.pgBulletinMessage)
	}

	//User Management
	public static void gotoRoles() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuRoles', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToRoles() {
		gotoRoles()
		verifyPageHeader(HIIConstants.pgRoles)
	}

	public static void gotoRoleMenuMapping() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuRoleMenuMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToRoleMenuMapping() {
		gotoRoleMenuMapping()
		verifyPageHeader(HIIConstants.pgRoleMenuMapping)
	}

	public static void gotoApprovalLevelSettingsforRole() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuApprovalLevelSettingsforRole', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToApprovalLevelSettingsforRole() {
		gotoApprovalLevelSettingsforRole()
		verifyPageHeader(HIIConstants.pgApprovalLevelSettingsforRole)
	}

	public static void gotoMapWidgetstoDashboardName() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuMapWidgetstoDashboardName', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMapWidgetstoDashboardName() {
		gotoMapWidgetstoDashboardName()
		verifyPageHeader(HIIConstants.pgMapWidgetstoDashboardName)
	}

	public static void gotoManageUserInformation() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuManageUserInformation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToManageUserInformation() {
		gotoManageUserInformation()
		verifyPageHeader(HIIConstants.pgManageUserInformation)
	}

	public static void gotoManageDashboardWidgets() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuUserManagement', 'mnuManageDashboardWidgets', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToManageDashboardWidgets() {
		gotoManageDashboardWidgets()
		verifyPageHeader(HIIConstants.pgManageDashboardWidgets)
	}

	//Benchmarking
	public static void gotoBenchmarkingSource() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuBenchmarking', 'mnuBenchmarkingSource', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToBenchmarkingSource() {
		gotoBenchmarkingSource()
		verifyPageHeader(HIIConstants.pgBenchmarkingSource)
	}

	public static void gotoBenchmarking() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuBenchmarking', 'submnuBenchmarking', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToBenchmarking() {
		gotoBenchmarking()
		verifyPageHeader(HIIConstants.pgBenchmarking)
	}

	public static void gotoBenchmarkingSummary() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuBenchmarking', 'mnuBenchmarkingSummary', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToBenchmarkingSummary() {
		gotoBenchmarkingSummary()
		verifyPageHeader(HIIConstants.pgBenchmarkingSummary)
	}


	//CPT
	public static void gotowRVUstRVUsProcessRulesSetup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuCPT', 'mnuwRVUstRVUsProcessRulesSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationTowRVUstRVUsProcessRulesSetup() {
		gotowRVUstRVUsProcessRulesSetup()
		verifyPageHeader(HIIConstants.pgwRVUstRVUsProcessRulesSetup)
	}

	public static void gotoCPTCodeMasterList() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuCPT', 'mnuCPTCodeMasterList', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCPTCodeMasterList() {
		gotoCPTCodeMasterList()
		verifyPageHeader(HIIConstants.pgCPTCodeMasterList)
	}

	public static void gotowRVUstRVUsRulesAdvSetup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuCPT', 'mnuwRVUstRVUsRulesAdvSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationTowRVUstRVUsRulesAdvSetup() {
		gotowRVUstRVUsRulesAdvSetup()
		verifyPageHeader(HIIConstants.pgwRVUstRVUsRulesAdvSetup)
	}

	public static void gotowRVUstRVUsOverride() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuCPT', 'mnuwRVUstRVUsOverride', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationTowRVUstRVUsOverride() {
		gotowRVUstRVUsOverride()
		verifyPageHeader(HIIConstants.pgwRVUstRVUsOverride)
	}

	//Productivity wRVUs/tRVUs/CollectionTiers
	public static void gotoProductivitywRVUstRVUsCollectionTiers() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuwRVUstRVUsCollectionTiers', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProductivitywRVUstRVUsCollectionTiers() {
		gotoProductivitywRVUstRVUsCollectionTiers()
		verifyPageHeader(HIIConstants.pgProductivitywRVUstRVUsCollectionTiers)
	}

	//Strategic Goals
	public static void gotoMetrics() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuStrategicGoals', 'mnuMetrics', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMetrics() {
		gotoMetrics()
		verifyPageHeader(HIIConstants.pgMetrics)
	}

	public static void gotoMetricMeasures() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuStrategicGoals', 'mnuMetricMeasures', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMetricMeasures() {
		gotoMetricMeasures()
		verifyPageHeader(HIIConstants.pgMetricMeasures)
	}

	public static void gotoPerformanceMetricsProfile() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuStrategicGoals', 'mnuPerformanceMetricsProfile', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPerformanceMetricsProfile() {
		gotoPerformanceMetricsProfile()
		verifyPageHeader(HIIConstants.pgPerformanceMetricsProfile)
	}

	//Import Wizard
	public static void gotoImportWizard() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuImportWizard', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToImportWizard() {
		gotoImportWizard()
		verifyPageHeader(HIIConstants.pgImportWizard)
	}

	//Pay Period Maintenance
	public static void gotoPayPeriodMaintenance() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuPayPeriodMaintenance', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayPeriodMaintenance() {
		gotoPayPeriodMaintenance()
		verifyPageHeader(HIIConstants.pgPayPeriodMaintenance)
	}

	//Run Interface Jobs
	public static void gotoRunInterfaceJobs() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuRunInterfaceJobs', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToRunInterfaceJobs() {
		gotoRunInterfaceJobs()
		verifyPageHeader(HIIConstants.pgRunInterfaceJobs)
	}

	//Holidays
	public static void gotoHolidayMaster() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuHolidays', 'mnuHolidayMaster', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToHolidayMaster() {
		gotoHolidayMaster()
		verifyPageHeader(HIIConstants.pgHolidayMaster)
	}

	public static void gotoHolidayProfile() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuHolidays', 'mnuHolidayProfile', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToHolidayProfile() {
		gotoHolidayProfile()
		verifyPageHeader(HIIConstants.pgHolidayProfile)
	}

	//Pay Cycles
	public static void gotoPayCycleSetup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuPayCycles', 'mnuPayCycleSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayCycleSetup() {
		gotoPayCycleSetup()
		verifyPageHeader(HIIConstants.pgPayCycleSetup)
	}

	public static void gotoPayCycleMapping() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuPayCycles', 'mnuPayCycleMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayCycleMapping() {
		gotoPayCycleMapping()
		verifyPageHeader(HIIConstants.pgPayCycleMapping)
	}

	//Shifts
	public static void gotoShiftsSetup() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuShifts', 'mnuShiftsSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToShiftsSetup() {
		gotoShiftsSetup()
		verifyPageHeader(HIIConstants.pgShiftsSetup)
	}

	public static void gotoShiftsMapping() {
		getBaseSteps().gotoCascadingMenu('mnuAdmin', 'mnuShifts', 'mnuShiftsMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToShiftsMapping() {
		gotoShiftsMapping()
		verifyPageHeader(HIIConstants.pgShiftsMapping)
	}

	//Fee Schedule
	public static void gotoFeeSchedule() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuFeeSchedule', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToFeeSchedule() {
		gotoFeeSchedule()
		verifyPageHeader(HIIConstants.pgFeeSchedule)
	}

	//Batch Plan Period
	public static void gotoBatchPlanPeriod() {
		getBaseSteps().gotoSubMenu('mnuAdmin', 'mnuBatchPlanPeriod', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToBatchPlanPeriod() {
		gotoBatchPlanPeriod()
		verifyPageHeader(HIIConstants.pgBatchPlanPeriod)
	}

	//Pay Element Config

	public static void gotoCompensationModels() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuCompensationModels', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCompensationModels() {
		gotoCompensationModels()
		verifyPageHeader(HIIConstants.pgCompensationModels)
	}

	public static void gotoPayElements() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuPayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElements() {
		gotoPayElements()
		verifyPageHeader(HIIConstants.pgPayElements)
	}

	public static void gotoOrgCompModelsPayElements() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuOrgCompModelsPayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToOrgCompModelsPayElements() {
		gotoOrgCompModelsPayElements()
		verifyPageHeader(HIIConstants.pgOrgCompModelsPayElements)
	}

	public static void gotoCompModelSpecialtyMapping() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuCompModelSpecialtyMapping', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCompModelSpecialtyMapping() {
		gotoCompModelSpecialtyMapping()
		verifyPageHeader(HIIConstants.pgCompModelSpecialtyMapping)
	}

	public static void gotoCompModelPayElementSettings() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuCompModelPayElementSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCompModelPayElementSettings() {
		gotoCompModelPayElementSettings()
		verifyPageHeader(HIIConstants.pgCompModelPayElementSettings)
	}

	public static void gotoPayElementColumnConfiguration() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuPayElementColumnConfiguration', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElementColumnConfiguration() {
		gotoPayElementColumnConfiguration()
		verifyPageHeader(HIIConstants.pgPayElementColumnConfiguration)
	}

	public static void gotoMiscellaneousProfileSettings() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuMiscellaneousProfileSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMiscellaneousProfileSettings() {
		gotoMiscellaneousProfileSettings()
		verifyPageHeader(HIIConstants.pgMiscellaneousProfileSettings)
	}

	public static void gotoPayElementsAccrualsSettings() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuPayElementsAccrualsSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElementsAccrualSettings() {
		gotoPayElementsAccrualsSettings()
		verifyPageHeader(HIIConstants.pgPayElementsAccrualsSettings)
	}

	public static void gotoModelWiseProfileTypeSettings() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuModelWiseProfileTypeSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToModelWiseProfileTypeSettings() {
		gotoModelWiseProfileTypeSettings()
		verifyPageHeader(HIIConstants.pgModelWiseProfileTypeSettings)
	}

	public static void gotoUserRoleWisePayElements() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuUserRoleWisePayElements', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToUserRoleWisePayElements() {
		gotoUserRoleWisePayElements()
		verifyPageHeader(HIIConstants.pgUserRoleWisePayElements)
	}

	public static void gotoNewBonusPayelementConfiguration() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuNewBonusPayelementConfiguration', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToNewBonusPayelementConfiguration() {
		gotoNewBonusPayelementConfiguration()
		verifyPageHeader(HIIConstants.pgNewBonusPayelementConfiguration)
	}

	public static void gotoProductivityReportLayoutandBonusCalc() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuProductivityReportLayoutandBonusCalc', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProductivityReportLayoutandBonusCalc() {
		gotoProductivityReportLayoutandBonusCalc()
		verifyPageHeader(HIIConstants.pgProductivityReportLayoutandBonusCalc)
	}

	public static void gotoDefaultRateAmountbyPayElement() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuDefaultRateAmountbyPayElement', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToDefaultRateAmountbyPayElement() {
		gotoDefaultRateAmountbyPayElement()
		verifyPageHeader(HIIConstants.pgDefaultRateAmountbyPayElement)
	}

	public static void gotoGLAccountMaintenanceByPE() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuGLAccountMaintenanceByPE', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToGLAccountMaintenaceByPE() {
		gotoGLAccountMaintenanceByPE()
		verifyPageHeader(HIIConstants.pgGLAccountMaintenanceByPE)
	}

	//Provider

	public static void gotoProviderSetup() {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderSetup() {
		gotoProviderSetup()
		verifyPageHeader(HIIConstants.pgProviderSetup)
	}

	public static void gotoManageProviderContract() {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuManageProviderContract', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToManageProviderContract() {
		gotoManageProviderContract()
		verifyPageHeader(HIIConstants.pgManageProviderContract)
	}

	public static void gotoProviderLeaveofAbsence() {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderLeaveofAbsence', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderLeaveofAbsence() {
		gotoProviderLeaveofAbsence()
		verifyPageHeader(HIIConstants.pgProviderLeaveofAbsence)
	}

	public static void gotoProviderExclusionList() {
		getBaseSteps().gotoSubMenu('mnuProvider', 'mnuProviderExclusionList', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderExclusionList() {
		gotoProviderExclusionList()
		verifyPageHeader(HIIConstants.pgProviderExclusionList)
	}


	//Data Management

	public static void gotoInterfaceLogSummary() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuInterfaceLogSummary', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToInterfaceLogSummary() {
		gotoInterfaceLogSummary()
		verifyPageHeader(HIIConstants.pgInterfaceLogSummary)
	}

	public static void gotoSSISColumnConfiguration() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuSSISColumnConfiguration', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToSSISColumnConfiguration() {
		gotoSSISColumnConfiguration()
		verifyPageHeader(HIIConstants.pgSSISColumnConfiguration)
	}

	public static void gotoProviderEMRData() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuProviderEMRData', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderEMRData() {
		gotoProviderEMRData()
		verifyPageHeader(HIIConstants.pgProviderEMRData)
	}

	public static void gotoAdjustmentImport() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuAdjustmentImport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToAdjustmentImport() {
		gotoAdjustmentImport()
		verifyPageHeader(HIIConstants.pgAdjustmentImport)
	}

	public static void gotoPayrollInbound() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuPayrollInbound', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayrollInbound() {
		gotoPayrollInbound()
		verifyPageHeader(HIIConstants.pgPayrollInbound)
	}

	public static void gotoImportVariableMetrics() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuImportVariableMetrics', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToImportVariableMetrics() {
		gotoImportVariableMetrics()
		verifyPageHeader(HIIConstants.pgImportVariableMetrics)
	}

	public static void gotoShiftsHoursImport() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuShiftsHoursImport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToShiftsHoursImport() {
		gotoShiftsHoursImport()
		verifyPageHeader(HIIConstants.pgShiftsHoursImport)
	}

	public static void gotoProviderSchedulingData() {
		getBaseSteps().gotoSubMenu('mnuDataManagement', 'mnuProviderSchedulingData', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderSchedulingData() {
		gotoProviderSchedulingData()
		verifyPageHeader(HIIConstants.pgProviderSchedulingData)
	}


	//Payment

	public static void gotoProviderPayRequest() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayRequest', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderPayRequest() {
		gotoProviderPayRequest()
		verifyPageHeader(HIIConstants.pgProviderPayRequest)
	}

	public static void gotoProviderPayApprovals() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayApprovals', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderPayApprovals() {
		gotoProviderPayApprovals()
		verifyPageHeader(HIIConstants.pgProviderPayApprovals)
	}

	public static void gotoProcessBonus() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProcessBonus', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProcessBonus() {
		gotoProcessBonus()
		verifyPageHeader(HIIConstants.pgProcessBonus)
	}

	public static void gotoPaymentProcess() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuPaymentProcess', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPaymentProcess() {
		gotoPaymentProcess()
		verifyPageHeader(HIIConstants.pgPaymentProcess)
	}

	public static void gotoAccrualDetails() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuAccrualDetails', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToAccrualDetails() {
		gotoAccrualDetails()
		verifyPageHeader(HIIConstants.pgAccrualDetails)
	}

	public static void gotoPayElementAccrualHoldAdjustment() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuPayElementAccrualHoldAdjustment', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElementAccrualHoldAdjustment() {
		gotoPayElementAccrualHoldAdjustment()
		verifyPageHeader(HIIConstants.pgPayElementAccrualHoldAdjustment)
	}


	//Reports

	public static void gotoUserEventLog() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuLogDetails','mnuUserEventLog', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}

	public static void verifyNavigationToUserEventLog() {
		gotoUserEventLog()
		verifyPageHeader(HIIConstants.pgUserEventLog)
	}

	public static void gotoActivityLog() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuLogDetails','mnuActivityLog', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToActivityLog() {
		gotoActivityLog()
		verifyPageHeader(HIIConstants.pgActivityLog)
	}

	public static void gotoMessageHistory() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuLogDetails','mnuMessageHistory', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMessageHistory() {
		gotoMessageHistory()
		verifyPageHeader(HIIConstants.pgMessageHistory)
	}

	public static void gotoProviderListReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuProviderListReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderListReport() {
		gotoProviderListReport()
		verifyPageHeader(HIIConstants.pgProviderListReport)
	}

	public static void gotoPayElementsReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayElementsReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayElementsReport() {
		gotoPayElementsReport()
		verifyPageHeader(HIIConstants.pgPayElementsReport)
	}

	public static void gotoCPTSummaryReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuEMRwRVUstRVUs','mnuCPTSummaryReport', pageName.Header)
		getBaseSteps().waitForReadyState()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		
	}

	public static void verifyNavigationToCPTSummaryReport() {
		gotoCPTSummaryReport()
		verifyPageHeader(HIIConstants.pgCPTSummaryReport)
	}

	public static void gotoProviderwRVUstRVUsReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuEMRwRVUstRVUs','mnuProviderwRVUstRVUsReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderwRVUstRVUsReport() {
		gotoProviderwRVUstRVUsReport()
		verifyPageHeader(HIIConstants.pgProviderwRVUstRVUsReport)
	}

	public static void gotoProductivityIncentiveReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuProductivity','mnuProductivityIncentiveReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProductivityIncentiveReport() {
		gotoProductivityIncentiveReport()
		verifyPageHeader(HIIConstants.pgProductivityIncentiveReport)
	}

	public static void gotoMonthEndProductivityReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuProductivity','mnuMonthEndProductivityReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToMonthEndProductivityReport() {
		gotoMonthEndProductivityReport()
		verifyPageHeader(HIIConstants.pgMonthEndProductivityReport)
	}

	public static void gotoProductivityGroupReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuProductivity','mnuProductivityGroupReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProductivityGroupReport() {
		gotoProductivityGroupReport()
		verifyPageHeader(HIIConstants.pgProductivityGroupReport)
	}

	public static void gotoProductivityIncentiveFacilityWiseReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuProductivity','mnuProductivityIncentiveFacilityWiseReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProductivityIncentiveFacilityWiseReport() {
		gotoProductivityIncentiveFacilityWiseReport()
		verifyPageHeader(HIIConstants.pgProductivityIncentiveFacilityWiseReport)
	}

	public static void gotoDiscrepancyReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuDiscrepancyReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToDiscrepancyReport() {
		gotoDiscrepancyReport()
		verifyPageHeader(HIIConstants.pgDiscrepancyReport)
	}

	public static void gotoPayRequestStatusReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuPayRequestStatusReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPayRequestStatusReport() {
		gotoPayRequestStatusReport()
		verifyPageHeader(HIIConstants.pgPayRequestStatusReport)
	}

	public static void gotoYTDCompensation() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuYTDCompensation', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToYTDCompensation() {
		gotoYTDCompensation()
		verifyPageHeader(HIIConstants.pgYTDCompensation)
	}

	public static void gotoProviderCompensationStatement() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuProviderCompensationStatement', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderCompensationStatement() {
		gotoProviderCompensationStatement()
		verifyPageHeader(HIIConstants.pgProviderCompensationStatement)
	}

	public static void gotoCompensationSummaryReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuCompensationSummaryReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCompensationSummaryReport() {
		gotoCompensationSummaryReport()
		verifyPageHeader(HIIConstants.pgCompensationSummaryReport)
	}

	public static void gotoPTOLTSHoursReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuPTOLTSHoursReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPTOLTSHoursReport() {
		gotoPTOLTSHoursReport()
		verifyPageHeader(HIIConstants.pgPTOLTSHoursReport)
	}

	public static void gotoProviderSchedulingReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuProviderSchedulingReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderSchedulingReport() {
		gotoProviderSchedulingReport()
		verifyPageHeader(HIIConstants.pgProviderSchedulingReport)
	}


	public static void gotoReasonablenessReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuReasonablenessReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToReasonablenessReport() {
		gotoReasonablenessReport()
		verifyPageHeader(HIIConstants.pgReasonablenessReport)
	}

	public static void gotoFFSCompensationReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuFFSCompensationReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToFFSCompensationReport() {
		gotoFFSCompensationReport()
		verifyPageHeader(HIIConstants.pgFFSCompensationReport)
	}

	public static void gotoNonFFSCompensationReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuNonFFSCompensationReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToNonFFSCompensationReport() {
		gotoNonFFSCompensationReport()
		verifyPageHeader(HIIConstants.pgNonFFSCompensationReport)
	}

	public static void gotoPTORateReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuPTORateReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToPTORateReport() {
		gotoPTORateReport()
		verifyPageHeader(HIIConstants.pgPTORateReport)
	}

	public static void gotoProviderSchedulingStatsReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuPayments','mnuProviderSchedulingStatsReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToProviderSchedulingStatsReport() {
		gotoProviderSchedulingStatsReport()
		verifyPageHeader(HIIConstants.pgProviderSchedulingStatsReport)
	}

	public static void gotoCMEandPTOATOHoursReport() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuShiftsHoursCMEPTOATO','mnuCMEandPTOATOHoursReport', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToCMEandPTOATOHoursReport() {
		gotoCMEandPTOATOHoursReport()
		verifyPageHeader(HIIConstants.pgCMEandPTOATOHoursReport)
	}

	public static void gotoSummaryofHoursandShifts() {
		getBaseSteps().gotoMenuItem('mnuReports','mnuShiftsHoursCMEPTOATO','mnuSummaryofHoursandShifts', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToSummaryofHoursandShifts() {
		gotoSummaryofHoursandShifts()
		verifyPageHeader(HIIConstants.pgSummaryofHoursandShifts)
	}


	//Change Password

	public static void gotoChangePassword() {
		getBaseSteps().gotoMenuItem('mnuChangePassword','submnuChangePassword',pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToChangePassword() {
		gotoChangePassword()
		verifyPageHeader(HIIConstants.pgChangePassword)
	}

	//Help
	public static void gotoContactUs() {
		getBaseSteps().gotoMenuItem('mnuHelp','mnuContactUs',pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void verifyNavigationToContactUs() {
		gotoContactUs()
		verifyPageHeader(HIIConstants.pgContactUs)
	}



}

