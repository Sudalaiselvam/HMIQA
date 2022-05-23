import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.HeaderPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Verify Navigation to Organizaion'
HeaderPageSteps.verifyNavigationToOrganization()

'Step 04 : Verify Navigation to Region'
HeaderPageSteps.verifyNavigationToRegion()

'Step 05 : Verify Navigation to Provider Group'
HeaderPageSteps.verifyNavigationToProviderGroup()

'Step 06 : Verify Navigation to Location'
HeaderPageSteps.verifyNavigationToLocation()

'Step 07 : Verify Navigation to Cost Center'
HeaderPageSteps.verifyNavigationToCostCenter()

'Step 08 : Verify Navigation to Specialty Group'
HeaderPageSteps.verifyNavigationToSpecialtyGroup()

'Step 09 : Verify Navigation to Crosswalk Specialty'
HeaderPageSteps.verifyNavigationToCrosswalkSpecialty()

'Step 10 : Verify Navigation to Specialty'
HeaderPageSteps.verifyNavigationToSpecialty()

'Step 11 : Verify Navigation to Position Level'
HeaderPageSteps.verifyNavigationToPositionLevel()

'Step 12 : Verify Navigation to General Settings'
HeaderPageSteps.verifyNavigationToGeneralSettings()

'Step 13 : Verify Navigation to Manage Menu List'
HeaderPageSteps.verifyNavigationToManageMenuList()

'Step 14 : Verify Navigation to HR Interface Provider Status Mapping'
HeaderPageSteps.verifyNavigationToHRInterfaceProviderStatusMapping()

'Step 15: Verify Navigation to Pay Element Wise Reason'
HeaderPageSteps.verifyNavigationToPayElementWiseReason()

'Step 16 : Verify Navigation to Bulletin Message'
HeaderPageSteps.verifyNavigationToBulletinMessage()

'Step 17 : Verify Navigation to Roles'
HeaderPageSteps.verifyNavigationToRoles()

'Step 18 : Verify Navigation to Role Menu Mapping'
HeaderPageSteps.verifyNavigationToRoleMenuMapping()

'Step 19 : Verify Navigation to Approval Level Settings for Role'
HeaderPageSteps.verifyNavigationToApprovalLevelSettingsforRole()

'Step 20 : Verify Navigation to Map Widgets to Dashboard Name'
HeaderPageSteps.verifyNavigationToMapWidgetstoDashboardName()

'Step 21 : Verify Navigation to Manage User Information'
HeaderPageSteps.verifyNavigationToManageUserInformation()

'Step 22 : Verify Navigation to Manage Dashboard Widgets'
HeaderPageSteps.verifyNavigationToManageDashboardWidgets()

'Step 23 : Verify Navigation to Benchmarking Source'
HeaderPageSteps.verifyNavigationToBenchmarkingSource()

'Step 24 : Verify Navigation to Benchmarking'
HeaderPageSteps.verifyNavigationToBenchmarking()

'Step 25 : Verify Navigation to Benchmarking Summary'
HeaderPageSteps.verifyNavigationToBenchmarkingSummary()

'Step 26 : Verify Navigation to wRVUs/tRVUs Process Rules Setup'
HeaderPageSteps.verifyNavigationTowRVUstRVUsProcessRulesSetup()

'Step 27 : Verify Navigation to CPT Code Master List'
HeaderPageSteps.verifyNavigationToCPTCodeMasterList()

'Step 28 : Verify Navigation to wRVUs/tRVUs Rules Adv. Setup'
HeaderPageSteps.verifyNavigationTowRVUstRVUsRulesAdvSetup()

'Step 29 : Verify Navigation to wRVus/tRVUs Override'
HeaderPageSteps.verifyNavigationTowRVUstRVUsOverride()

'Step 30 : Verify Navigation to Productivity wRVUs/tRVUs Collection Tiers'
HeaderPageSteps.verifyNavigationToProductivitywRVUstRVUsCollectionTiers()

'Step 31 : Verify Navigation to Metrics'
HeaderPageSteps.verifyNavigationToMetrics()

'Step 32 : Verify Navigation to Metrics Measures'
HeaderPageSteps.verifyNavigationToMetricMeasures()

'Step 33 : Verify Navigation to Performance Metrics Profile'
HeaderPageSteps.verifyNavigationToPerformanceMetricsProfile()

'Step 34 : Verify Navigation to Import Wizard'
HeaderPageSteps.verifyNavigationToImportWizard()

'Step 35 : Verify Navigation to Pay Period Maintenance'
HeaderPageSteps.verifyNavigationToPayPeriodMaintenance()

'Step 36 : Verify Navigation to Run Interface Jobs'
HeaderPageSteps.verifyNavigationToRunInterfaceJobs()

'Step 37 : Verify Navigation to Holiday Master'
HeaderPageSteps.verifyNavigationToHolidayMaster()

'Step 38 : Verify Navigation to Holiday Profile'
HeaderPageSteps.verifyNavigationToHolidayProfile()

'Step 39 : Verify Navigation to Pay Cycle Setup'
HeaderPageSteps.verifyNavigationToPayCycleSetup()

'Step 40 : Verify Navigation to Pay Cycle Mapping'
HeaderPageSteps.verifyNavigationToPayCycleMapping()

'Step 41 : Verify Navigation to Shifts Setup'
HeaderPageSteps.verifyNavigationToShiftsSetup()

'Step 42 : Verify Navigation to Shifts Mapping'
HeaderPageSteps.verifyNavigationToShiftsMapping()

'Step 43 : Verify Navigation to Fee Schedule'
HeaderPageSteps.verifyNavigationToFeeSchedule()

'Step 44 : Verify Navigation to Batch Plan Period'
HeaderPageSteps.verifyNavigationToBatchPlanPeriod()

'Step 45 : Verify Navigation to Compensation Models'
HeaderPageSteps.verifyNavigationToCompensationModels()

'Step 46 : Verify Navigation to Pay Elements'
HeaderPageSteps.verifyNavigationToPayElements()

'Step 47 : Verify Navigation to Org Comp Models Pay Elements'
HeaderPageSteps.verifyNavigationToOrgCompModelsPayElements()

'Step 48 : Verify Navigation to Comp Model Specialty Mapping'
HeaderPageSteps.verifyNavigationToCompModelSpecialtyMapping()

'Step 49 : Verify Navigation to Comp Model Pay Element Settings'
HeaderPageSteps.verifyNavigationToCompModelPayElementSettings()

'Step 50 : Verify Navigation to Pay Element Column Configuration'
HeaderPageSteps.verifyNavigationToPayElementColumnConfiguration()

'Step 51 : Verify Navigation to Miscellaneous Profile Settings'
HeaderPageSteps.verifyNavigationToMiscellaneousProfileSettings()

'Step 52 : Verify Navigation to Pay Elements Accrual Settings'
HeaderPageSteps.verifyNavigationToPayElementsAccrualSettings()

'Step 53 : Verify Navigation to Model Wise Profile Type Settings'
HeaderPageSteps.verifyNavigationToModelWiseProfileTypeSettings()

'Step 54 : Verify Navigation to User Role Wise Pay Elements'
HeaderPageSteps.verifyNavigationToUserRoleWisePayElements()

'Step 55 : Verify Navigation to New Bonus Pay Element Configuration'
HeaderPageSteps.verifyNavigationToNewBonusPayelementConfiguration()

'Step 56 : Verify Navigation to Productivity Report Layout and Bonus Calc'
HeaderPageSteps.verifyNavigationToProductivityReportLayoutandBonusCalc()

'Step 57 : Verify Navigation to Default Rate Amount By Pay Element'
HeaderPageSteps.verifyNavigationToDefaultRateAmountbyPayElement()

'Step 58 : Verify Navigation to GL Account Maintenance By PE'
HeaderPageSteps.verifyNavigationToGLAccountMaintenaceByPE()

'Step 59 : Verify Navigation to Provider Setup'
HeaderPageSteps.verifyNavigationToProviderSetup()

'Step 60 : Verify Navigation to Manage Provider Contract'
HeaderPageSteps.verifyNavigationToManageProviderContract()

'Step 61 : Verify Navigation to Provider Leave of Absence'
HeaderPageSteps.verifyNavigationToProviderLeaveofAbsence()

'Step 62 : Verify Navigation to Provider Exclusion List'
HeaderPageSteps.verifyNavigationToProviderExclusionList()

'Step 63 : Verify Navigation to Interface Log Summary'
HeaderPageSteps.verifyNavigationToInterfaceLogSummary()

'Step 64 : Verify Navigation to SSIS Column Configuration'
HeaderPageSteps.verifyNavigationToSSISColumnConfiguration()

'Step 65 : Verify Navigation to Provider EMR Data'
HeaderPageSteps.verifyNavigationToProviderEMRData()

'Step 66 : Verify Navigation to Adjustmnet Import'
HeaderPageSteps.verifyNavigationToAdjustmentImport()

'Step 67 : Verify Navigation to Payroll Inbound'
HeaderPageSteps.verifyNavigationToPayrollInbound()

'Step 68 : Verify Navigation to Import Variable Metrics'
HeaderPageSteps.verifyNavigationToImportVariableMetrics()

'Step 69 : Verify Navigation to Shifts Hours Import'
HeaderPageSteps.verifyNavigationToShiftsHoursImport()

'Step 70 : Verify Navigation to Provider Scheduling Data'
HeaderPageSteps.verifyNavigationToProviderSchedulingData()

'Step 71 : Verify Navigation to Provider Pay Request'
HeaderPageSteps.verifyNavigationToProviderPayRequest()

'Step 72 : Verify Navigation to Provider Pay Approvals'
HeaderPageSteps.verifyNavigationToProviderPayApprovals()

'Step 73 : Verify Navigation to Process Bonus'
HeaderPageSteps.verifyNavigationToProcessBonus()

'Step 74 : Verify Navigation to Payment Process'
HeaderPageSteps.verifyNavigationToPaymentProcess()

'Step 75 : Verify Navigation to Accrual Details'
HeaderPageSteps.verifyNavigationToAccrualDetails()

'Step 76 : Verify Navigation to Pay Element Accrual Hold Adjustment'
HeaderPageSteps.verifyNavigationToPayElementAccrualHoldAdjustment()

'Step 77 : Verify Navigation to user Event Log'
HeaderPageSteps.verifyNavigationToUserEventLog()

'Step 78 : Verify Navigation to Activity Log'
HeaderPageSteps.verifyNavigationToActivityLog()

'Step 79 : Verify Navigation to Message History'
HeaderPageSteps.verifyNavigationToMessageHistory()

'Step 80 : Verify Navigation to Provider List Report'
HeaderPageSteps.verifyNavigationToProviderListReport()

'Step 81 : Verify Navigation to Pay Elements Report'
HeaderPageSteps.verifyNavigationToPayElementsReport()

'Step 82 : Verify Navigation to CPT Summary Report'
HeaderPageSteps.verifyNavigationToCPTSummaryReport()

'Step 83 : Verify Navigation to Provider wRVUs/tRVUs Report'
HeaderPageSteps.verifyNavigationToProviderwRVUstRVUsReport()

'Step 84 : Verify Navigation to Productivity Incentive Report'
HeaderPageSteps.verifyNavigationToProductivityIncentiveReport()

'Step 85 : Verify Navigation to Month End Productivity Report'
HeaderPageSteps.verifyNavigationToMonthEndProductivityReport()

'Step 86 : Verify Navigation to Productivity Group Report'
HeaderPageSteps.verifyNavigationToProductivityGroupReport()

'Step 87 : Verify Navigation to Productivity Incentive Facility Wise Report'
HeaderPageSteps.verifyNavigationToProductivityIncentiveFacilityWiseReport()

'Step 88 : Verify Navigation to Discrepancy Report'
HeaderPageSteps.verifyNavigationToDiscrepancyReport()

'Step 89 : Verify Navigation to Pay Request Status Report'
HeaderPageSteps.verifyNavigationToPayRequestStatusReport()

'Step 90 : Verify Navigation to YTD Compensation'
HeaderPageSteps.verifyNavigationToYTDCompensation()

'Step 91 : Verify Navigation to Provider Compensation Statement'
HeaderPageSteps.verifyNavigationToProviderCompensationStatement()

'Step 92 : Verify Navigation to Compensation Summary Report'
HeaderPageSteps.verifyNavigationToCompensationSummaryReport()

'Step 93 : Verify Navigation to PTO/LTS Hours Report'
HeaderPageSteps.verifyNavigationToPTOLTSHoursReport()

'Step 94 : Verify Navigation to Provider Scheduling Report'
HeaderPageSteps.verifyNavigationToProviderSchedulingReport()

'Step 95 : Verify Navigation to Reasonableness Reprot'
HeaderPageSteps.verifyNavigationToReasonablenessReport()

'Step 96 : Verify Navigation to FFS Compensation Report'
HeaderPageSteps.verifyNavigationToFFSCompensationReport()

'Step 97 : Verify Navigation to Non FFS Compensation Report'
HeaderPageSteps.verifyNavigationToNonFFSCompensationReport()

'Step 98 : Verify Navigation to PTO Rate Report'
HeaderPageSteps.verifyNavigationToPTORateReport()

'Step 99 : Verify Navigation to Provider Scheduling Stats Report'
HeaderPageSteps.verifyNavigationToProviderSchedulingStatsReport()

'Step 100 : Verify Navigation to CME and PTO ATO Hours Report'
HeaderPageSteps.verifyNavigationToCMEandPTOATOHoursReport()

'Step 101 : Verify Navigation to Summary of Hours and Shifts'
HeaderPageSteps.verifyNavigationToSummaryofHoursandShifts()

'Step 102 : Verify Navigation to Change Password'
HeaderPageSteps.verifyNavigationToChangePassword()

'Step 103 : Verify Navigation to Contact Us'
HeaderPageSteps.verifyNavigationToContactUs()
