package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import utils.Utilities
import utils.ExcelUtilities
import configs.HIIConstants
import core.AssertSteps
import  java.time.Instant
import java.time.Duration
import core.Logger

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ReportsPageSteps {

	/**
	 * @return
	 */
	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String btnShowDetails='btnShowDetails'
	private static final String btnClear='btnClear'
	private static final String txtStartDate='txtStartDate'
	private static final String txtEndDate='txtEndDate'
	private static final String txtAsofDate='txtAsofDate'
	private static final String ddlYear='ddlYear'
	private static final String txtProviderName='txtProviderName'
	private static final String fmReport='ReportFrameBodyContentHolder_rpFinal'
	private static final String fmrptMessageHistory='ReportFrameBodyContentHolder_rptMessageHistory'
	private static final String fmChildReport='report'
	private static final String ddlExportFormat='ddlExportFormat'
	private static final String lnkExport='lnkExport'
	private static final String grdUserEventLog='grdUserEventLog'
	private static final String grdActivityLog='grdActivityLog'
	private static final String grdMessageHistory='grdMessageHistory'
	private static final String grdPayElementsReport='grdPayElementsReport'
	private static final String grdCPTSummaryReport='grdCPTSummaryReport'
	private static final String grdCMEBalanceReport='grdCMEBalanceReport'
	private static final String grdSummaryofHoursandShifts='grdSummaryofHoursandShifts'
	private static final String grdProviderListReport='grdProviderListReport'
	private static final String grdPayRequestStatusReport='grdPayRequestStatusReport'
	private static final String grdYTDCompensation='grdYTDCompensation'
	private static final String grdProviderwRVus='grdProviderwRVus'
	private static final String grdProductivityIncentiveReport='grdProductivityIncentiveReport'
	private static final String grdPTOLTSHoursReport='grdPTOLTSHoursReport'
	private static final String grdProviderSchedulingReport='grdProviderSchedulingReport'
	private static final String grdFFSCompensationReport='grdFFSCompensationReport'
	private static final String grdNonFFSCompensationReport='grdNonFFSCompensationReport'
	private static final String grdPTORateReport='grdPTORateReport'
	private static final String grdProviderSchedulingStatsReport='grdProviderSchedulingStatsReport'
	private static final String grdMonthEndProductivityReport='grdMonthEndProductivityReport'
	private static final String grdProductivityIncentiveFacilityWiseReport='grdProductivityIncentiveFacilityWiseReport'
	private static final String grdCompensationSummaryReport='grdCompensationSummaryReport'
	private static final String grdProviderCompensationStatement='grdProviderCompensationStatement'
	private static final String grdReasonablenessReport='grdReasonablenessReport'
	private static final String ddlMandatory='ddlMandatory'
	private static final String ddlMonth='ddlMonth'
	private static final String ddlRegion='ddlRegion'
	private static final String ddlCompModel='ddlCompModel'
	private static final String ddlPayCycle='ddlPayCycle'
	private static final String ddlPayPeriod='ddlPayPeriod'
	private static final String ddlPayPeriod2='ddlPayPeriod2'
	private static final String ddllblPayPeriod2='ddllblPayPeriod2'
	private static final String ddlPayPeriod2Selectall='ddlPayPeriod2Selectall'
	private static final String ddlPECC='ddlPECC'
	private static final String ddlBenchMarkSources='ddlBenchMarkSources'
	private static final String vldSummary='vldSummary'
	private static final String lblError='lblError'
	private static final String rpError='rpError'
	private static final String noRecords='noRecords'
	private static final String nodatatodisplay='nodatatodisplay'
	private static final String btnExportExcel='btnExportExcel'
	private static final String btnExportPDF='btnExportPDF'
	private static final String grdMainTable='grdMainTable'

	/**
	 * 
	 */
	public static void clickShowDetails() {
		getBaseSteps().clickToControl(btnShowDetails, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}

	/**
	 * 
	 */
	public static void clickClear() {
		getBaseSteps().clickToControl(btnClear, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * @param StartDate
	 */
	public static void setStartDate(String StartDate) {
		getBaseSteps().selectDate(txtStartDate, StartDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * 
	 */
	public static void selectStartDateAsCurrentMonthFirstDay() {
		getBaseSteps().selectFirstDayOfCurrentMonth(txtStartDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * 
	 */
	public static void selectStartDateAsCurrentMonthCurrentDay() {
		getBaseSteps().selectCurrentDayOfCurrentMonth(txtStartDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	public static void selectAsofDateAsCurrentMonthCurrentDay() {
		getBaseSteps().selectCurrentDayOfCurrentMonth(txtAsofDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}

	/**
	 * 
	 */
	public static void selectEndDateAsCurrentMonthCurrentDay() {
		getBaseSteps().selectCurrentDayOfCurrentMonth(txtEndDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * @param EndDate
	 */
	public static void setEndDate(String EndDate) {
		getBaseSteps().selectDate(txtEndDate, EndDate, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * @param Year
	 */
	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * @param ProviderName
	 */
	public static void setProviderName(String ProviderName) {
		getBaseSteps().setTextToControl(txtProviderName, ProviderName, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().clickProviderHint('lstProviderhints', pageName.CMN, FailureHandling.STOP_ON_FAILURE)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * @return
	 */
	public static boolean isExportFormatOptionDisplayed() {
		return getBaseSteps().WebElementDisplayed(ddlExportFormat, pageName.ReportPages)
	}

	/**
	 * @param ExportFormat
	 */
	public static void selectExportFormat(String ExportFormat) {
		getBaseSteps().selectByVisibleText(ddlExportFormat, ExportFormat, pageName.ReportPages)
		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
	}

	/**
	 * 
	 */
	public static void selectExportFormatAsExcel() {
		selectExportFormat(HIIConstants.getExportformatexcel())
	}

	/**
	 * 
	 */
	public static void selectExportFormatAsPDF() {
		selectExportFormat(HIIConstants.getExportformatpdf())
	}

	/**
	 * 
	 */
	public static void verifyExportOptionsDisplayed() {
		AssertSteps.verifyActualResult(isExportFormatOptionDisplayed(), 'Export Option Format is Displayed - PASS ', 'Export Option Format is not Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
	}

	/**
	 * 
	 */
	public static void clickExportLink() {
		getBaseSteps().clickToControl(lnkExport, pageName.ReportPages)
	}

	/**
	 * @return
	 */
	public static String expReportName() {
		String expReportFileName
		String pageHeader=CommonSteps.getPageHeader()

		switch(pageHeader) {
			case 'MESSAGE HISTORY':
				expReportFileName='MessageHistory'
				break
			case 'USER EVENT LOG':
				expReportFileName='UserEventLog'
				break
			case 'SUMMARY OF HOURS AND SHIFTS':
				expReportFileName='ShiftsReport'
				break
			case 'CME AND PTO/ATO HOURS REPORT':
				expReportFileName='CME Balance Report'
				break
			case HIIConstants.pgProviderwRVUstRVUsReport:
				expReportFileName='Provider wRVUs'
				break
			case HIIConstants.pgPayRequestStatusReport:
				expReportFileName='PayRequestStatus'
				break
			case HIIConstants.pgYTDCompensation:
				expReportFileName='YTD Compensation'
				break
			case HIIConstants.pgPTOLTSHoursReport:
				expReportFileName='PTOReport_Summary'
				break
			case HIIConstants.pgProviderSchedulingReport:
				expReportFileName='Scheduling Report'
				break
			case HIIConstants.pgFFSCompensationReport:
				expReportFileName='FFS Compensation Report'
				break
			case HIIConstants.pgNonFFSCompensationReport:
				expReportFileName='Non FFS Compensation Report'
				break
			case HIIConstants.pgMonthEndProductivityReport:
				expReportFileName='Month End Productivity Report'
				break
			case HIIConstants.pgCompensationSummaryReport:
				expReportFileName='CompSummary'
				break
			case HIIConstants.pgProviderCompensationStatement:
				expReportFileName='Providercompensationstatement'
				break
			case HIIConstants.pgDiscrepancyReport:
				expReportFileName='DiscrepancyReport'
				break
			default:
				expReportFileName=Utilities.getFirstLetterCapitalized(pageHeader)
				break
		}
		//return Utilities.getFirstLetterCapitalized(CommonSteps.getPageHeader())
		return expReportFileName
	}

	/**
	 * 
	 */
	public static void verifyExportReportasExcel() {
		selectExportFormatAsExcel()

		String expReportFileName=expReportName()+'.xlsx'
		verifyExportingReport(expReportFileName,60000)
		getBaseSteps().waitForReadyState()
	}

	public static void verifyExcelReportExport() {

		String expReportFileName=expReportName()+'.xlsx'

		if(Utilities.checkFileExists(expReportFileName)) {
			Utilities.deleteFile(expReportFileName)
		}
		Instant Start=Instant.now()
		getBaseSteps().clickToControl(btnExportExcel, pageName.ReportPages)
		Utilities.waitForFileDownloaded(expReportFileName, 60000)
		Instant End=Instant.now()
		Duration timeElapsed=Duration.between(Start, End)
		String AssertMsgPass=expReportFileName+' Report Export validation,exported successfully. Time taken to export: '+timeElapsed.toSeconds()+' seconds'
		String AssertMsgFail=expReportFileName+' Report Export validation,Failed to export. Duration to check export: '+timeElapsed.toSeconds()+' seconds'
		AssertSteps.verifyActualResult(Utilities.checkFileExists(expReportFileName), AssertMsgPass, AssertMsgFail)
	}

	public static void verifyPDFReportExport() {

		String expReportFileName=expReportName()+'.pdf'

		if(Utilities.checkFileExists(expReportFileName)) {
			Utilities.deleteFile(expReportFileName)
		}
		Instant Start=Instant.now()
		getBaseSteps().clickToControl(btnExportPDF, pageName.ReportPages)
		Utilities.waitForFileDownloaded(expReportFileName, 60000)
		Instant End=Instant.now()
		Duration timeElapsed=Duration.between(Start, End)
		String AssertMsgPass=expReportFileName+' Report Export validation,exported successfully. Time taken to export: '+timeElapsed.toSeconds()+' seconds'
		String AssertMsgFail=expReportFileName+' Report Export validation,Failed to export. Duration to check export: '+timeElapsed.toSeconds()+' seconds'
		AssertSteps.verifyActualResult(Utilities.checkFileExists(expReportFileName), AssertMsgPass, AssertMsgFail)
	}

	/**
	 * 
	 */
	public static void verifyExportReportasPDF() {
		selectExportFormatAsPDF()

		String expReportFileName=expReportName()+'.pdf'
		verifyExportingReport(expReportFileName,120000)
		getBaseSteps().waitForReadyState()
	}

	/**
	 * @param expReportFileName
	 * @param timeoutMilliSeconds
	 */
	public static void verifyExportingReport(String expReportFileName,int timeoutMilliSeconds=2000) {
		if(Utilities.checkFileExists(expReportFileName)) {
			Utilities.deleteFile(expReportFileName)
		}
		Instant Start=Instant.now()
		clickExportLink()
		Utilities.waitForFileDownloaded(expReportFileName, timeoutMilliSeconds)
		Instant End=Instant.now()
		Duration timeElapsed=Duration.between(Start, End)
		String AssertMsgPass=expReportFileName+' Report Export validation,exported successfully. Time taken to export: '+timeElapsed.toSeconds()+' seconds'
		String AssertMsgFail=expReportFileName+' Report Export validation,Failed to export. Duration to check export: '+timeElapsed.toSeconds()+' seconds'
		AssertSteps.verifyActualResult(Utilities.checkFileExists(expReportFileName), AssertMsgPass, AssertMsgFail)
	}

	/**
	 * 
	 */
	public static void verifyGenericReportExportwithDates() {

		selectStartDateAsCurrentMonthFirstDay()

		selectEndDateAsCurrentMonthCurrentDay()

		clickShowDetails()

		AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)

		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			verifyExportOptionsDisplayed()
			verifyExportReportasExcel()
			verifyExportReportasPDF()
		}
	}

	/**
	 * 
	 */
	public static void verifyGenericReportExportForCurrentDate() {

		selectStartDateAsCurrentMonthCurrentDay()

		selectEndDateAsCurrentMonthCurrentDay()

		clickShowDetails()

		AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)

		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			verifyExportOptionsDisplayed()
			verifyExportReportasExcel()
			verifyExportReportasPDF()
		}
	}

	/**
	 * 
	 */
	public static void verifyGenericReportExport() {

		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
			verifyExportOptionsDisplayed()
			verifyExportReportasExcel()
			verifyExportReportasPDF()
		}
	}

	/**
	 * 
	 */
	public static void verifyGenericReportExportWithDefaultSelection() {

		//getBaseSteps().selectRandomOptionOfDropDownList(ddlMandatory, pageName.ReportPages)

		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlCompModel, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlCompModel, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlCompModel, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPECC, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPECC, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPECC, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlBenchMarkSources, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlBenchMarkSources, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlBenchMarkSources, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		clickShowDetails()

		AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)

		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			verifyExportOptionsDisplayed()
			verifyExportReportasExcel()
			verifyExportReportasPDF()
		}


	}

	/**
	 * 
	 */
	public static void verifyYTDCompensationReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlBenchMarkSources, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlBenchMarkSources, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlBenchMarkSources, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		verifyGenericReportExport()

	}



	/**
	 * 
	 */
	public static void YTDCompensationMandatoryOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlBenchMarkSources, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlBenchMarkSources, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlBenchMarkSources, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

	}

	/**
	 * 
	 */
	public static void UserEventLogReportOptionsSelection() {
		selectStartDateAsCurrentMonthCurrentDay()
		selectEndDateAsCurrentMonthCurrentDay()
	}
	public static void ActivityLogReportOptionsSelection() {
		selectStartDateAsCurrentMonthCurrentDay()
		selectEndDateAsCurrentMonthCurrentDay()
	}
	public static void MessageHistoryReportOptionsSelection() {
		selectStartDateAsCurrentMonthFirstDay()
		selectEndDateAsCurrentMonthCurrentDay()
	}
	public static void ProviderListReportOptionsSelection() {}
	public static void PayElementsReportOptionsSelection() {
		selectStartDateAsCurrentMonthFirstDay()
		selectEndDateAsCurrentMonthCurrentDay()
	}
	public static void CPTSummaryReportOptionsSelection() {}
	public static void ProviderwRVUstRVUsReportOptionsSelection() {
		selectStartDateAsCurrentMonthFirstDay()
		selectEndDateAsCurrentMonthCurrentDay()
	}
	public static void ProductivityIncentiveReportOptionsSelection() {
		/*if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
		 if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
		 getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)
		 getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		 getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		 getBaseSteps().waitForReadyState()
		 if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
		 if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
		 getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)
		 getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		 getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		 getBaseSteps().waitForReadyState()
		 if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
		 if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
		 getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)
		 getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		 getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		 getBaseSteps().waitForReadyState()*/

	}
	public static void MonthEndProductivityReportOptionsSelection() {

	}
	public static void ProductivityGroupReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlCompModel, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlCompModel, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlCompModel, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPECC, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPECC, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPECC, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

	}
	public static void ProductivityIncentiveFacilityWiseReportOptionsSelection() {

	}
	public static void DiscrepancyReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

	}
	public static void PayRequestStatusReportOptionsSelection() {}
	public static void YTDCompensationReportOptionsSelection() {if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
				if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
					getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlBenchMarkSources, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlBenchMarkSources, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlBenchMarkSources, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}
	public static void ProviderCompensationStatementReportOptionsSelection() {}
	public static void CompensationSummaryReportOptionsSelection() {}
	public static void PTOLTSHoursReportOptionsSelection() {
		selectAsofDateAsCurrentMonthCurrentDay()
	}
	public static void ProviderSchedulingReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod2, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayPeriod2, pageName.ReportPages))
		{
			getBaseSteps().clickToControl(ddlPayPeriod2, pageName.ReportPages)
			if(!getBaseSteps().isSelectedCheckboxControl(ddlPayPeriod2Selectall, pageName.ReportPages))
				getBaseSteps().clickToControl(ddllblPayPeriod2, pageName.ReportPages)
			getBaseSteps().clickToControl('pageHeader', pageName.Header)
		}


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}

	/**
	 * 
	 */
	public static void ReasonablenessReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		/*if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
		 if(getBaseSteps().isControlMandatory(ddlPayPeriod, pageName.ReportPages))
		 getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)
		 getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		 getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		 getBaseSteps().waitForReadyState()*/

	}
	public static void FFSCompensationReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}
	public static void NonFFSCompensationReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}
	public static void PTORateReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}
	public static void ProviderSchedulingStatsReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

	}
	public static void CMEandPTOATOHoursReportOptionsSelection() {
		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()
	}
	public static void SummaryofHoursandShiftsReportOptionsSelection() {}


	/**
	 * 
	 */
	public static void verifyCompensationSummaryReportExport() {
		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayPeriod, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		verifyGenericReportExport()
	}

	/**
	 * 
	 */
	public static void verifyPTOLTSHoursReportExport() {

		selectAsofDateAsCurrentMonthCurrentDay()

		verifyGenericReportExport()
	}

	public static void verifyProviderSchedulingReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod2, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayPeriod2, pageName.ReportPages))
		{
			getBaseSteps().clickToControl(ddlPayPeriod2, pageName.ReportPages)
			if(!getBaseSteps().isSelectedCheckboxControl(ddlPayPeriod2Selectall, pageName.ReportPages))
				getBaseSteps().clickToControl(ddllblPayPeriod2, pageName.ReportPages)
			getBaseSteps().clickToControl('pageHeader', pageName.Header)
		}


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()


		verifyGenericReportExport()
	}

	public static void verifyReasonablenessReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()


		verifyGenericReportExport()
	}

	/**
	 * 
	 */
	public static void verifyFFSCompensationReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()


		verifyGenericReportExport()
	}

	public static void verifyNONFFSCompensationReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlPayCycle, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlPayCycle, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlPayCycle, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlPayPeriod, pageName.ReportPages))
			getBaseSteps().selectRandomOptionDropdownControl(ddlPayPeriod, pageName.ReportPages)


		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()


		verifyGenericReportExport()
	}

	public static void verifyPTORateReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()




		verifyGenericReportExport()
	}

	/**
	 * 
	 */
	public static void verifyProviderSchedulingStatsReportExport() {

		if(getBaseSteps().WebElementDisplayed(ddlYear, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlYear, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlYear, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlMonth, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlMonth, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlMonth, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()

		if(getBaseSteps().WebElementDisplayed(ddlRegion, pageName.ReportPages))
			if(getBaseSteps().isControlMandatory(ddlRegion, pageName.ReportPages))
				getBaseSteps().selectRandomOptionDropdownControl(ddlRegion, pageName.ReportPages)

		getBaseSteps().waitforLoadingComplete('imgLoading2', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().waitForReadyState()




		verifyGenericReportExport()
	}



	/**
	 * 
	 */
	public static void verifyExportedExcelReport() {
		println getExcelReportFirstRecord()
	}

	/**
	 * @return
	 */
	public static Map getExcelReportFirstRecord(){
		Map<String,String> firstRecord=new TreeMap<>()
		String ReportFileName=expReportName()+'.xlsx'
		switch(ReportFileName) {
			case HIIConstants.getUserEventLogexcelreportname():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 5)
				break
			case HIIConstants.getActivitylogexcelreportname():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getPayelementsreportexcelreportname():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 4)
				break
			case HIIConstants.getProviderlistreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 4)
				break
			case HIIConstants.getMessagehistoryexcelreportname():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 3)
				break
			case HIIConstants.getSummaryofhoursandshiftsexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getCmeandptoatohoursreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getPayrequeststatusexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 7)
				break
			case HIIConstants.getYtdcompensationexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 3, 8)
				break
			case HIIConstants.getPtoreportsummaryexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getReasonablenessreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReportsDoubleHeader(ReportFileName, 1)
				break
			case HIIConstants.getFfscompensationreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getNonffscompensationreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getPtoratereportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getProviderschedulingstatsreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getProviderwrvustrvusreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReportsDoubleHeader(ReportFileName, 2)
				break
			case HIIConstants.getProductivityincentivereportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 7)
				break

			case HIIConstants.getMonthendproductivityreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReportsDoubleHeader(ReportFileName, 1)
				break
			case HIIConstants.getProductivityincentivefacilitywisereportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 2)
				break
			case HIIConstants.getCompensationsummaryexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
			case HIIConstants.getProvidercompensationstatementexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 2)
				break
			case HIIConstants.getDiscrepancyreportexcelreport():
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 10,12)
				break

			default:
				firstRecord=ExcelUtilities.getExcelRecordForReports(ReportFileName, 1)
				break
		}
		return firstRecord
	}

	/**
	 * @return
	 */
	public static Map getGridReportFirstRecord() {
		String pageHeader=CommonSteps.getPageHeader()

		Map<String,String> hmReports=new TreeMap<>();
		//Map<String,String> tmReports=new TreeMap<>()
		switch(pageHeader) {
			case HIIConstants.pgUserEventLog:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport,grdUserEventLog , 7, pageName.ReportPages)
				break
			case HIIConstants.pgActivityLog:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdActivityLog, 3, pageName.ReportPages)
				break
			case HIIConstants.pgMessageHistory:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmrptMessageHistory,fmChildReport, grdMessageHistory, 5, pageName.ReportPages)
				break
			case HIIConstants.pgPayElementsReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdPayElementsReport, 6, pageName.ReportPages)
				break
			case HIIConstants.pgSummaryofHoursandShifts:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdSummaryofHoursandShifts, 3, pageName.ReportPages)
				break
			case HIIConstants.pgCMEandPTOATOHoursReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdCMEBalanceReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgProviderListReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdProviderListReport, 2, pageName.ReportPages)
				break
			case HIIConstants.pgCPTSummaryReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdCPTSummaryReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgProviderwRVUstRVUsReport:
				hmReports=getBaseSteps().getFrameGridFirstRecordDoubleHeader(fmReport,fmChildReport, grdProviderwRVus, 4, pageName.ReportPages)
			//getFrameGridFirstRecord(fmReport,fmChildReport, grdProviderwRVus, 5, pageName.ReportPages)
				break
			case HIIConstants.pgProductivityIncentiveReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdProductivityIncentiveReport,2, pageName.ReportPages)
				break
			case HIIConstants.pgPayRequestStatusReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdPayRequestStatusReport, 2, pageName.ReportPages)
				break
			case HIIConstants.pgYTDCompensation:
				hmReports=getBaseSteps().getFrameGridRecord(fmReport, fmChildReport, grdYTDCompensation, 4, 9, pageName.ReportPages)
				break
			case HIIConstants.pgPTOLTSHoursReport:
				hmReports=getBaseSteps().getFrameGridRecord(fmReport, fmChildReport, grdPTOLTSHoursReport,3, pageName.ReportPages)
				break
			case HIIConstants.pgProviderSchedulingReport:
				hmReports=getBaseSteps().getFrameGridRecord(fmReport, fmChildReport, grdProviderSchedulingReport,3, pageName.ReportPages)
				break
			case HIIConstants.pgFFSCompensationReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdFFSCompensationReport, 2, pageName.ReportPages)
				break
			case HIIConstants.pgNonFFSCompensationReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdNonFFSCompensationReport, 2, pageName.ReportPages)
				break
			case HIIConstants.pgPTORateReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdPTORateReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgProviderSchedulingStatsReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdProviderSchedulingStatsReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgMonthEndProductivityReport:
				hmReports=getBaseSteps().getFrameGridFirstRecordDoubleHeader(fmReport,fmChildReport, grdMonthEndProductivityReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgProductivityIncentiveFacilityWiseReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdProductivityIncentiveFacilityWiseReport, 4, pageName.ReportPages)
				break
			case HIIConstants.pgCompensationSummaryReport:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdCompensationSummaryReport, 3, pageName.ReportPages)
				break
			case HIIConstants.pgProviderCompensationStatement:
				hmReports=getBaseSteps().getFrameGridFirstRecord(fmReport,fmChildReport, grdProviderCompensationStatement, 4, pageName.ReportPages)
				break
			case HIIConstants.pgReasonablenessReport:
				hmReports=getBaseSteps().getFrameGridFirstRecordDoubleHeader(fmReport,fmChildReport, grdReasonablenessReport, 2, pageName.ReportPages)
				break
			case HIIConstants.pgDiscrepancyReport:
				hmReports=getBaseSteps().getGridRecord(grdMainTable, 2,8, pageName.ReportPages)
				break
			default:
				break
		}
		//tmReports.putAll(hmReports)

		return hmReports

	}

	/**
	 * 
	 */
	public static void verifyReportFirstRecordwithExportedExcel() {
		if(isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else
		if(!isNoDataFoundDisplayed()) {
			Map<String,String> ExcelReportsRecord=getExcelReportFirstRecord()
			ExcelReportsRecord.remove("")
			ExcelReportsRecord.sort()
			Map<String,String> GridReportsRecord=getGridReportFirstRecord()
			GridReportsRecord.remove("")
			GridReportsRecord.sort()
			String Reports="""
					Excel First Record : %s
					Grid First Record  : %s	
				"""
			String AssertMsg=Reports.format(Reports, ExcelReportsRecord,GridReportsRecord)
			AssertSteps.verifyActualResult(ExcelReportsRecord.equals(GridReportsRecord), AssertMsg+' - PASS', AssertMsg+' - FAIL')

			for(String Key:ExcelReportsRecord.keySet()) {
				String AssertMsg2='Validation of '+Key+' in Exported Excel: '+ExcelReportsRecord.get(Key)+' and from Grid : '+GridReportsRecord.get(Key)
				AssertSteps.verifyActualResult(ExcelReportsRecord.get(Key).equals(GridReportsRecord.get(Key)), AssertMsg2+' - PASS', AssertMsg2+' - FAIL')
			}
		}else
			Logger.logWARNING('Exported Data validation can not be performed, hence No Data Found')
	}

	/**
	 * @return
	 */
	public static boolean isValidationSummaryDisplayed() {
		if(getBaseSteps().WebElementDisplayed(vldSummary, pageName.ReportPages) || getBaseSteps().WebElementDisplayed(lblError, pageName.ReportPages))
			return true
		else
			return false
	}

	/**
	 * @return
	 */
	public static String getValidationSummary() {
		try {
			return getBaseSteps().getTextFromControl(vldSummary, pageName.ReportPages)
		}catch(Exception e) {
			return getBaseSteps().getTextFromControl(lblError, pageName.ReportPages)
		}
	}

	public static boolean isReportErrorOccured() {
		Thread.sleep(2000)
		String pageHeader=CommonSteps.getPageHeader()
		switch(pageHeader) {
			case HIIConstants.pgMessageHistory:
				return getBaseSteps().isChildFrameErrorDisplayed(fmrptMessageHistory,fmChildReport,rpError, pageName.ReportPages)
				break
			case HIIConstants.pgDiscrepancyReport:
				return getBaseSteps().WebElementDisplayed(rpError, pageName.ReportPages)
				break
			default:
				return getBaseSteps().isChildFrameErrorDisplayed(fmReport,fmChildReport,rpError, pageName.ReportPages)
				break
		}


		/*
		 try {
		 return getBaseSteps().isChildFrameErrorDisplayed(fmReport,fmChildReport,rpError, pageName.ReportPages)
		 }catch(Exception e) {
		 return false
		 }*/
	}

	public static boolean isNoDataFoundDisplayed() {
		boolean blnNoRecords=false
		Thread.sleep(2000)
		String pageHeader=CommonSteps.getPageHeader()
		switch(pageHeader) {
			case HIIConstants.pgMessageHistory:
				blnNoRecords=getBaseSteps().isChildFrameErrorDisplayed(fmrptMessageHistory,fmChildReport,noRecords, pageName.ReportPages)
				break
			case HIIConstants.pgDiscrepancyReport:
				blnNoRecords=getBaseSteps().WebElementDisplayed(nodatatodisplay, pageName.ReportPages)
				break
			default:
				blnNoRecords=getBaseSteps().isChildFrameErrorDisplayed(fmReport,fmChildReport,noRecords, pageName.ReportPages)
				break
		}
		return blnNoRecords
	}


	/**
	 * 
	 */
	static int counter=0;


	public static void rereun() {}


	/**
	 * @param retryLimit
	 */
	public static void validateUserEventLogReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToUserEventLog()
		UserEventLogReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					println Thread.currentThread().getStackTrace()[1].getMethodName()
					validateUserEventLogReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;

	}

	/**
	 * @param retryLimit
	 */
	public static void validateActivityLogReport(int retryLimit=4) {
		try {
			HeaderPageSteps.verifyNavigationToActivityLog()
			ActivityLogReportOptionsSelection()
			clickShowDetails()
			if(this.isValidationSummaryDisplayed()) {
				Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
				Logger.logWARNING('Exporting can not continue due to Validation Summary')
			}else {
				if(isNoDataFoundDisplayed())
				{
					if(counter<=retryLimit) {
						counter++;
						validateActivityLogReport(retryLimit-counter+1);
					}else
						Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
				}else {
					AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
					verifyExportOptionsDisplayed()
					verifyExportReportasExcel()
					verifyExportReportasPDF()
					verifyReportFirstRecordwithExportedExcel()
				}
			}
			counter=0;
		}catch(Exception e) {
			Logger.logWARNING('Exception while validatiion of Report');
		}
	}

	/**
	 * @param retryLimit
	 */
	public static void validateMessageHistoryReport(int retryLimit=4) {
		try {
			HeaderPageSteps.verifyNavigationToMessageHistory()
			MessageHistoryReportOptionsSelection()
			clickShowDetails()
			if(this.isValidationSummaryDisplayed()) {
				Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
				Logger.logWARNING('Exporting can not continue due to Validation Summary')
			}else {
				if(isNoDataFoundDisplayed())
				{
					if(counter<=retryLimit) {
						counter++;
						validateMessageHistoryReport(retryLimit-counter+1);
					}else
						Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
				}else {
					AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
					verifyExportOptionsDisplayed()
					verifyExportReportasExcel()
					verifyExportReportasPDF()
					verifyReportFirstRecordwithExportedExcel()
				}
			}
			counter=0;
		}catch(Exception e) {
			Logger.logWARNING('Exception while validatiion of Report');
		}
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProviderListReport(int retryLimit=4) {
		try {
			HeaderPageSteps.verifyNavigationToProviderListReport()
			ProviderListReportOptionsSelection()
			clickShowDetails()
			if(this.isValidationSummaryDisplayed()) {
				Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
				Logger.logWARNING('Exporting can not continue due to Validation Summary')
			}else {
				if(isNoDataFoundDisplayed())
				{
					if(counter<=retryLimit) {
						counter++;
						validateProviderListReport(retryLimit-counter+1);
					}else
						Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
				}else {
					AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
					verifyExportOptionsDisplayed()
					verifyExportReportasExcel()
					verifyExportReportasPDF()
					verifyReportFirstRecordwithExportedExcel()
				}
			}
			counter=0;
		}catch(Exception e) {
			Logger.logWARNING('Exception while validatiion of Report');
		}
	}

	/**
	 * @param retryLimit
	 */
	public static void validatePayElementsReport(int retryLimit=4) {
		try {
			HeaderPageSteps.verifyNavigationToPayElementsReport()
			PayElementsReportOptionsSelection()
			clickShowDetails()
			if(this.isValidationSummaryDisplayed()) {
				Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
				Logger.logWARNING('Exporting can not continue due to Validation Summary')
			}else {
				if(isNoDataFoundDisplayed())
				{
					if(counter<=retryLimit) {
						counter++;
						validatePayElementsReport(retryLimit-counter+1);
					}else
						Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
				}else {
					AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
					verifyExportOptionsDisplayed()
					verifyExportReportasExcel()
					verifyExportReportasPDF()
					verifyReportFirstRecordwithExportedExcel()
				}
			}
			counter=0;
		}catch(Exception e) {
			Logger.logWARNING('Exception while validatiion of Report');
		}
	}

	/**
	 * @param retryLimit
	 */
	public static void validateCPTSummaryReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToCPTSummaryReport()
		CPTSummaryReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateCPTSummaryReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProviderwRVUstRVUsReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProviderwRVUstRVUsReport()
		ProviderwRVUstRVUsReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProviderwRVUstRVUsReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProductivityIncentiveReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProductivityIncentiveReport()
		ProductivityIncentiveReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProductivityIncentiveReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateMonthEndProductivityReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToMonthEndProductivityReport()
		MonthEndProductivityReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateMonthEndProductivityReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProductivityGroupReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProductivityGroupReport()
		ProductivityGroupReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
			if(counter<=retryLimit) {
				counter++;
				validateProductivityGroupReport(retryLimit-counter+1);
			}else
				Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')

		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProductivityGroupReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProductivityIncentiveFacilityWiseReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProductivityIncentiveFacilityWiseReport()
		ProductivityIncentiveFacilityWiseReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProductivityIncentiveFacilityWiseReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateDiscrepancyReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToDiscrepancyReport()
		DiscrepancyReportOptionsSelection()
		clickShowDetails()


		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateDiscrepancyReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)

				verifyExcelReportExport()
				verifyPDFReportExport()

				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}



	/**
	 * @param retryLimit
	 */
	public static void validatePayRequestStatusReport(int retryLimit=4) {
		try {
			HeaderPageSteps.verifyNavigationToPayRequestStatusReport()
			PayRequestStatusReportOptionsSelection()
			clickShowDetails()
			if(this.isValidationSummaryDisplayed()) {
				Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
				Logger.logWARNING('Exporting can not continue due to Validation Summary')
			}else {
				if(isNoDataFoundDisplayed())
				{
					if(counter<=retryLimit) {
						counter++;
						validatePayRequestStatusReport(retryLimit-counter+1);
					}else
						Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
				}else {
					AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
					verifyExportOptionsDisplayed()
					verifyExportReportasExcel()
					verifyExportReportasPDF()
					verifyReportFirstRecordwithExportedExcel()
				}
			}
			counter=0;
		}catch(Exception e) {
			Logger.logWARNING('Exception while validatiion of Report');
		}
	}

	/**
	 * @param retryLimit
	 */
	public static void validateYTDCompensationReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToYTDCompensation()
		YTDCompensationMandatoryOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					println Thread.currentThread().getStackTrace()[1].getMethodName()
					validateYTDCompensationReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProviderCompensationStatementReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProviderCompensationStatement()
		ProviderCompensationStatementReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProviderCompensationStatementReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateCompensationSummaryReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToCompensationSummaryReport()
		CompensationSummaryReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateCompensationSummaryReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validatePTOLTSHoursReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToPTOLTSHoursReport()
		PTOLTSHoursReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validatePTOLTSHoursReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProviderSchedulingReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProviderSchedulingReport()
		ProviderSchedulingReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProviderSchedulingReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateReasonablenessReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToReasonablenessReport()
		ReasonablenessReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateReasonablenessReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateFFSCompensationReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToFFSCompensationReport()
		FFSCompensationReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateFFSCompensationReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateNonFFSCompensationReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToNonFFSCompensationReport()
		NonFFSCompensationReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateNonFFSCompensationReport(1+retryLimit-counter);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validatePTORateReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToPTORateReport()
		PTORateReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validatePTORateReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateProviderSchedulingStatsReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToProviderSchedulingStatsReport()
		ProviderSchedulingStatsReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateProviderSchedulingStatsReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateCMEandPTOATOHoursReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToCMEandPTOATOHoursReport()
		CMEandPTOATOHoursReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateCMEandPTOATOHoursReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

	/**
	 * @param retryLimit
	 */
	public static void validateSummaryofHoursandShiftsReport(int retryLimit=4) {
		HeaderPageSteps.verifyNavigationToSummaryofHoursandShifts()
		SummaryofHoursandShiftsReportOptionsSelection()
		clickShowDetails()
		if(this.isValidationSummaryDisplayed()) {
			Logger.logWARNING('Validation Summary Message Displayed : '+this.getValidationSummary())
			Logger.logWARNING('Exporting can not continue due to Validation Summary')
		}else {
			if(isNoDataFoundDisplayed())
			{
				if(counter<=retryLimit) {
					counter++;
					validateSummaryofHoursandShiftsReport(retryLimit-counter+1);
				}else
					Logger.logWARNING('Export Data validation is failed to perform, after multiple times of retrying')
			}else {
				AssertSteps.verifyActualResult(!isReportErrorOccured(), 'Report Error is not Occured - PASS', 'Report Error Displayed - FAIL', FailureHandling.STOP_ON_FAILURE)
				verifyExportOptionsDisplayed()
				verifyExportReportasExcel()
				verifyExportReportasPDF()
				verifyReportFirstRecordwithExportedExcel()
			}
		}
		counter=0;
	}

}
