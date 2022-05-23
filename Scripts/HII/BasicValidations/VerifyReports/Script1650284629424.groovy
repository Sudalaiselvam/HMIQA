import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.HeaderPageSteps
import pages.ReportsPageSteps
import utils.ExcelUtilities


'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

HeaderPageSteps.verifyNavigationToYTDCompensation()
ReportsPageSteps.verifyYTDCompensationReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()


'Step 03 : Verify Navigation to user Event Log' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToUserEventLog()
ReportsPageSteps.verifyGenericReportExportForCurrentDate()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 04 : Verify Navigation to Activity Log' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToActivityLog()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 05 : Verify Navigation to Message History' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToMessageHistory()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 06 : Verify Navigation to Provider List Report' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToProviderListReport()
ReportsPageSteps.verifyGenericReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 07 : Verify Navigation to Pay Elements Report' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToPayElementsReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()


'Step 08 : Verify Navigation to CPT Summary Report' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToCPTSummaryReport()
ReportsPageSteps.verifyGenericReportExportWithDefaultSelection()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 09 : Verify Navigation to Provider wRVUs/tRVUs Report'// Grid format is differ
HeaderPageSteps.verifyNavigationToProviderwRVUstRVUsReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 10 : Verify Navigation to Productivity Incentive Report'
HeaderPageSteps.verifyNavigationToProductivityIncentiveReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 11 : Verify Navigation to Month End Productivity Report'
HeaderPageSteps.verifyNavigationToMonthEndProductivityReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 12 : Verify Navigation to Productivity Group Report'
HeaderPageSteps.verifyNavigationToProductivityGroupReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 13 : Verify Navigation to Productivity Incentive Facility Wise Report'
HeaderPageSteps.verifyNavigationToProductivityIncentiveFacilityWiseReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 14 : Verify Navigation to Discrepancy Report'
HeaderPageSteps.verifyNavigationToDiscrepancyReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 15 : Verify Navigation to Pay Request Status Report' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToPayRequestStatusReport()
ReportsPageSteps.verifyGenericReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 16 : Verify Navigation to YTD Compensation' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToYTDCompensation()
ReportsPageSteps.verifyYTDCompensationReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 17 : Verify Navigation to Provider Compensation Statement'
HeaderPageSteps.verifyNavigationToProviderCompensationStatement()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 18 : Verify Navigation to Compensation Summary Report'  // Grid format is differ
HeaderPageSteps.verifyNavigationToCompensationSummaryReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 19 : Verify Navigation to PTO/LTS Hours Report'// Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToPTOLTSHoursReport()
ReportsPageSteps.verifyPTOLTSHoursReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 20 : Verify Navigation to Provider Scheduling Report'// Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToProviderSchedulingReport()
ReportsPageSteps.verifyProviderSchedulingReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 21 : Verify Navigation to Reasonableness Reprot' // Report has double column header
HeaderPageSteps.verifyNavigationToReasonablenessReport()
ReportsPageSteps.verifyReasonablenessReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 22 : Verify Navigation to FFS Compensation Report'// Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToFFSCompensationReport()
ReportsPageSteps.verifyFFSCompensationReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 23 : Verify Navigation to Non FFS Compensation Report'// Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToNonFFSCompensationReport()
ReportsPageSteps.verifyGenericReportExportwithDates()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 24 : Verify Navigation to PTO Rate Report'// Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToPTORateReport()
ReportsPageSteps.verifyPTORateReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()


'Step 25 : Verify Navigation to Provider Scheduling Stats Report' // Scripting Completed - Executing without Errors
HeaderPageSteps.verifyNavigationToProviderSchedulingStatsReport()
ReportsPageSteps.verifyProviderSchedulingStatsReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 26 : Verify Navigation to CME and PTO ATO Hours Report'
HeaderPageSteps.verifyNavigationToCMEandPTOATOHoursReport()
ReportsPageSteps.verifyGenericReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()

'Step 27 : Verify Navigation to Summary of Hours and Shifts'
HeaderPageSteps.verifyNavigationToSummaryofHoursandShifts()
ReportsPageSteps.verifyGenericReportExport()
ReportsPageSteps.verifyReportFirstRecordwithExportedExcel()


