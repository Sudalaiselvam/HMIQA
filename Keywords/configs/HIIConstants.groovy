package configs

import java.text.DecimalFormat

/**
 * @author AnilKumarJanapareddy
 *
 */
public class HIIConstants {


	//PageHeaders
	public static final String pgOrganization='ORGANIZATION'
	public static final String pgRegion='REGION'
	public static final String pgProviderGroup='PROVIDER GROUP'
	public static final String pgLocation='LOCATION'
	public static final String pgCostCenter='COST CENTER'
	public static final String pgSpecialtyGroup='SPECIALTY GROUP'
	public static final String pgCrosswalkSpecialty='CROSSWALK SPECIALTY'
	public static final String pgSpecialty='SPECIALTY'
	public static final String pgPositionLevel='POSITION LEVEL'
	public static final String pgGeneralSettings='GENERAL SETTINGS'
	public static final String pgManageMenuList='MANAGE MENU LIST'
	public static final String pgHRInterfaceProviderStatusMapping='HR INTERFACE PROVIDER STATUS MAPPING'
	public static final String pgPayElementWiseReason='PAY ELEMENT WISE REASON'
	public static final String pgBulletinMessage='BULLETIN MESSAGE'
	public static final String pgRoles='ROLES'
	public static final String pgRoleMenuMapping='ROLE MENU MAPPING'
	public static final String pgApprovalLevelSettingsforRole='APPROVAL LEVEL SETTINGS FOR ROLE'
	public static final String pgMapWidgetstoDashboardName='MAP WIDGETS TO DASHBOARD NAME'
	public static final String pgManageUserInformation='MANAGE USER INFORMATION'
	public static final String pgManageDashboardWidgets='MANAGE DASHBOARD WIDGETS'
	public static final String pgBenchmarkingSource='BENCHMARKING SOURCE'
	public static final String pgBenchmarking='BENCHMARKING'
	public static final String pgBenchmarkingSummary='BENCHMARKING SUMMARY'
	public static final String pgwRVUstRVUsProcessRulesSetup='WRVUS/TRVUS PROCESS RULES SETUP'
	public static final String pgCPTCodeMasterList='CPT CODE MASTER LIST'
	public static final String pgwRVUstRVUsRulesAdvSetup='WRVUS/TRVUS RULES ADV. SETUP'
	public static final String pgwRVUstRVUsOverride='WRVUS/TRVUS OVERRIDE'
	public static final String pgProductivitywRVUstRVUsCollectionTiers='PRODUCTIVITY WRVUS/TRVUS/COLLECTION TIERS'
	public static final String pgMetrics='METRICS'
	public static final String pgMetricMeasures='METRIC MEASURES'
	public static final String pgPerformanceMetricsProfile='PERFORMANCE METRICS PROFILE'
	public static final String pgImportWizard='IMPORT WIZARD'
	public static final String pgPayPeriodMaintenance='PAY PERIOD MAINTENANCE'
	public static final String pgRunInterfaceJobs='RUN INTERFACE JOBS'
	public static final String pgHolidayMaster='HOLIDAY MASTER'
	public static final String pgHolidayProfile='HOLIDAY PROFILE'
	public static final String pgPayCycleSetup='PAY CYCLE SETUP'
	public static final String pgPayCycleMapping='PAY CYCLE MAPPING'
	public static final String pgShiftsSetup='SHIFTS SETUP'
	public static final String pgShiftsMapping='SHIFTS MAPPING'
	public static final String pgFeeSchedule='FEE SCHEDULE'
	public static final String pgBatchPlanPeriod='BATCH PLAN PERIOD'
	public static final String pgCompensationModels='COMPENSATION MODELS'
	public static final String pgPayElements='PAY ELEMENTS'
	public static final String pgOrgCompModelsPayElements='ORG COMP MODELS PAY ELEMENTS'
	public static final String pgCompModelSpecialtyMapping='COMP MODEL SPECIALTY MAPPING'
	public static final String pgCompModelPayElementSettings='COMP MODEL PAY ELEMENT SETTINGS'
	public static final String pgPayElementColumnConfiguration='PAY ELEMENT COLUMN CONFIGURATION'
	public static final String pgMiscellaneousProfileSettings='MISCELLANEOUS PROFILE SETTINGS'
	public static final String pgPayElementsAccrualsSettings='PAY ELEMENTS ACCRUALS SETTINGS'
	public static final String pgModelWiseProfileTypeSettings='MODEL WISE PROFILE TYPE SETTINGS'
	public static final String pgUserRoleWisePayElements='ROLE/USER WISE PAY ELEMENTS'
	public static final String pgNewBonusPayelementConfiguration='BONUS PAYELEMENT CONFIGURATION'
	public static final String pgProductivityReportLayoutandBonusCalc='PRODUCTIVITY REPORT LAYOUT AND BONUS CALC'
	public static final String pgDefaultRateAmountbyPayElement='DEFAULT RATE/AMOUNT BY PAY ELEMENT'
	public static final String pgGLAccountMaintenanceByPE='GL ACCOUNT MAINTENANCE BY PE'
	public static final String pgProviderSetup='PROVIDER SETUP'
	public static final String pgManageProviderContract='MANAGE PROVIDER CONTRACT'
	public static final String pgProviderLeaveofAbsence='PROVIDER LEAVE OF ABSENCE'
	public static final String pgProviderExclusionList='PROVIDER EXCLUSION LIST'
	public static final String pgInterfaceLogSummary='INTERFACE LOG SUMMARY'
	public static final String pgSSISColumnConfiguration='SSIS COLUMN CONFIGURATION'
	public static final String pgProviderEMRData='PROVIDER EMR DATA'
	public static final String pgAdjustmentImport='ADJUSTMENT IMPORT'
	public static final String pgPayrollInbound='PAYROLL INBOUND'
	public static final String pgImportVariableMetrics='IMPORT VARIABLE METRICS'
	public static final String pgShiftsHoursImport='SHIFTS/HOURS IMPORT'
	public static final String pgProviderSchedulingData='PROVIDER SCHEDULING DATA'
	public static final String pgProviderPayRequest='PROVIDER PAY REQUEST'
	public static final String pgProviderPayApprovals='PROVIDER PAY APPROVALS'
	public static final String pgProcessBonus='PROCESS BONUS & FIXED'
	public static final String pgPaymentProcess='PAYMENT PROCESS'
	public static final String pgAccrualDetails='ACCRUAL DETAILS'
	public static final String pgPayElementAccrualHoldAdjustment='PAY ELEMENT ACCRUAL HOLD/ADJUSTMENT'
	public static final String pgUserEventLog='USER EVENT LOG'
	public static final String pgActivityLog='ACTIVITY LOG'
	public static final String pgMessageHistory='MESSAGE HISTORY'
	public static final String pgProviderListReport='PROVIDER LIST REPORT'
	public static final String pgPayElementsReport='PAY ELEMENTS REPORT'
	public static final String pgCPTSummaryReport='CPT SUMMARY REPORT'
	public static final String pgProviderwRVUstRVUsReport='PROVIDER WRVUS/TRVUS REPORT'
	public static final String pgProductivityIncentiveReport='PRODUCTIVITY INCENTIVE REPORT'
	public static final String pgMonthEndProductivityReport='MONTH END PRODUCTIVITY REPORT'
	public static final String pgProductivityGroupReport='PRODUCTIVITY GROUP REPORT'
	public static final String pgProductivityIncentiveFacilityWiseReport='PRODUCTIVITY INCENTIVE FACILITY WISE REPORT'
	public static final String pgDiscrepancyReport='DISCREPANCY REPORT'
	public static final String pgPayRequestStatusReport='PAY REQUEST STATUS REPORT'
	public static final String pgYTDCompensation='YTD COMPENSATION'
	public static final String pgProviderCompensationStatement='PROVIDER COMPENSATION STATEMENT'
	public static final String pgCompensationSummaryReport='COMPENSATION SUMMARY REPORT'
	public static final String pgPTOLTSHoursReport='PTO/LTS HOURS REPORT'
	public static final String pgProviderSchedulingReport='PROVIDER SCHEDULING REPORT'
	public static final String pgReasonablenessReport='REASONABLENESS REPORT'
	public static final String pgFFSCompensationReport='FFS COMPENSATION REPORT'
	public static final String pgNonFFSCompensationReport='NON FFS COMPENSATION REPORT'
	public static final String pgPTORateReport='PTO RATE REPORT'
	public static final String pgProviderSchedulingStatsReport='PROVIDER SCHEDULING STATS REPORT'
	public static final String pgCMEandPTOATOHoursReport='CME AND PTO/ATO HOURS REPORT'
	public static final String pgSummaryofHoursandShifts='SUMMARY OF HOURS AND SHIFTS'
	public static final String pgChangePassword='CHANGE PASSWORD'
	public static final String pgContactUs='CONTACT US'


	private static final String ExportFormatExcel='Excel'
	private static final String ExportFormatPDF='PDF'

	public static String getExportformatexcel() {
		return ExportFormatExcel;
	}

	public static String getExportformatpdf() {
		return ExportFormatPDF;
	}

	private static final String UserEventLogExcelReport='UserEventLog.xlsx'
	private static final String ActivityLogExcelReport='Activity Log.xlsx'
	private static final String MessageHistoryExcelReport='MessageHistory.xlsx'
	private static final String ProviderListReportExcelReport='Provider List Report.xlsx'
	private static final String PayElementsReportExcelReport='Pay Elements Report.xlsx'
	private static final String PayRequestStatusExcelReport='PayRequestStatus.xlsx'
	private static final String YTDCompensationExcelReport='YTD Compensation.xlsx'
	private static final String SummaryofHoursAndShiftsExcelReport='ShiftsReport.xlsx'
	private static final String CMEAndPTOATOHoursReportExcelReport='CME Balance Report.xlsx'
	private static final String PTOReportSummaryExcelReport='PTOReport_Summary.xlsx'
	private static final String ReasonablenessReportExcelReport='Reasonableness Report.xlsx'
	private static final String FFSCompensationReportExcelReport='FFS Compensation Report.xlsx'
	private static final String NonFFSCompensationReportExcelReport='Non FFS Compensation Report.xlsx'
	private static final String PTORateReportExcelReport='PTO Rate Report.xlsx'
	private static final String ProviderSchedulingStatsReportExcelReport='Provider Scheduling Stats Report.xlsx'
	private static final String ProviderwRVUstRVUsReportExcelReport='Provider wRVUs.xlsx'
	private static final String ProductivityIncentiveReportExcelReport='Productivity Incentive Report.xlsx'
	private static final String MonthEndProductivityReportExcelReport='Month End Productivity Report.xlsx'
	private static final String ProductivityIncentiveFacilityWiseReportExcelReport='Productivity Incentive Facility Wise Report.xlsx'
	private static final String CompensationSummaryExcelReport='CompSummary.xlsx'
	private static final String ProvidercompensationstatementExcelReport='Providercompensationstatement.xlsx'
	private static final String DiscrepancyReportExcelReport='DiscrepancyReport.xlsx'
	public static String getDiscrepancyreportexcelreport() {
		return DiscrepancyReportExcelReport;
	}

	public static String getProvidercompensationstatementexcelreport() {
		return ProvidercompensationstatementExcelReport;
	}

	public static String getCompensationsummaryexcelreport() {
		return CompensationSummaryExcelReport;
	}

	public static String getProductivityincentivefacilitywisereportexcelreport() {
		return ProductivityIncentiveFacilityWiseReportExcelReport;
	}

	public static String getMonthendproductivityreportexcelreport() {
		return MonthEndProductivityReportExcelReport;
	}

	public static String getProductivityincentivereportexcelreport() {
		return ProductivityIncentiveReportExcelReport;
	}

	public static String getProviderwrvustrvusreportexcelreport() {
		return ProviderwRVUstRVUsReportExcelReport;
	}

	public static String getProviderschedulingstatsreportexcelreport() {
		return ProviderSchedulingStatsReportExcelReport;
	}
	public static String getPtoratereportexcelreport() {
		return PTORateReportExcelReport;
	}
	public static String getNonffscompensationreportexcelreport() {
		return NonFFSCompensationReportExcelReport;
	}
	public static String getFfscompensationreportexcelreport() {
		return FFSCompensationReportExcelReport;
	}
	public static String getReasonablenessreportexcelreport() {
		return ReasonablenessReportExcelReport;
	}
	public static String getPtoreportsummaryexcelreport() {
		return PTOReportSummaryExcelReport;
	}
	public static String getUserEventLogexcelreportname() {
		return UserEventLogExcelReport;
	}
	public static String getCmeandptoatohoursreportexcelreport() {
		return CMEAndPTOATOHoursReportExcelReport;
	}
	public static String getSummaryofhoursandshiftsexcelreport() {
		return SummaryofHoursAndShiftsExcelReport;
	}
	public static String getActivitylogexcelreportname() {
		return ActivityLogExcelReport;
	}
	public static String getMessagehistoryexcelreportname() {
		return MessageHistoryExcelReport;
	}
	public static String getProviderlistreportexcelreport() {
		return ProviderListReportExcelReport;
	}
	public static String getPayelementsreportexcelreportname() {
		return PayElementsReportExcelReport;
	}
	public static String getPayrequeststatusexcelreport() {
		return PayRequestStatusExcelReport;
	}
	public static String getYtdcompensationexcelreport() {
		return YTDCompensationExcelReport;
	}

	private static final String NoRecordsAvailable='No Records available.'


	public static String getNorecordsavailableMsg() {
		return NoRecordsAvailable;
	}

	public static final String URL_ChooseRole='/ChooseRole.aspx'
	public static final String URL_ProviderPayRequest='/PhysicianPayRequest.aspx'
	public static final String URL_ProviderSetup='/ManagePhysicians.aspx'
	public static final String URL_ProviderContract='/PhysicianContractMasterDetails.aspx'

	public static final String ROLE_CompensationAdministrator='Compensation Administrator'
	public static final String ROLE_OrganizationAdmin='Organization Admin'
	public static final String ROLE_CompApprover='Comp Approver'

	public static final String PEType_Variable='Variable'
	public static final String PEType_Fixed='Fixed'


	public static final String ES_OnboardingInProgress='Onboarding - In Progress'
	public static final String ES_Hired='Hired'
	public static final String ES_Terminated='Terminated'

	//Provider Setup Page Constants
	public static final String PhysicianDetailsExcel='Provider Setup.xlsx'
	public static final String PS_PageHeader='PROVIDER SETUP'
	public static final String PS_ProviderDetailsInsertedSuccessfully='Provider Details Inserted Successfully.'
	public static final String PS_ProviderDetailsUpdatedSuccessfully='Provider Details Updated Successfully.'
	public static final String PS_ProviderDeletedSuccessfully='Provider Deleted Successfully.'
	public static final String PS_ProviderSearchPlaceHolder='Provider Search'
	public static final String PS_UniversalSearchPlaceHolder='Universal Search'
	public static final String PS_SearchButtonText='Search'
	public static final String PS_SearchClearButtonText='Clear'
	public static final String PS_CreateProviderButtonText='Create Provider'
	public static final String PS_BacktoProvidersButtonText='Back to Providers'
	public static final String PS_SaveButtonText='Save'
	public static final String PS_EncryptedDateOfBirth='00/00/0000'
	public static final String PS_EncryptedNPINumber='0000000000'
	public static final String PS_EncryptedSSN='000-00-0000'

	public static final String DateTextBoxPlaceHolder='MM/DD/YYYY'

	public static final String PPR_NoContractSelectedServiceDate='No Contract found for the selected Service date(s)'

	public static final String MaxCompensationDuration_WithintheContract='Within the Contract'
	public static final String MaxCompensationDuration_AcrossMasterContracts='Across Master Contracts'

	public static final String ProviderContractDetailsExcel='PROVIDER CONTRACT DETAILS.xlsx'
	public static final String PayRequestApprovalSuccessMessage='Request approved successfully'
	public static final String PayRequestApprovalUpdateMessage='Request Updated successfully'
	public static final String PayRequestApprovalExportExcelName='Pending Pay Request.xlsx'
	public static final String PayRequestApprovalDenyMessage='Request denied successfully'

	public static final String PaymentProcess_PageHeader='PAYMENT PROCESS'
	public static final String PaymentProcessCompensationAlertMessage='Fixed Payments has not been generated for the selected Pay Period. Do you want to continue processing compensation?'
	public static final String PaymentProcessSendToPayrollAlertMessage='Are you sure you want to commit the selected Pay Cycle ?'
	public static final String PaymentProcessSuccessMessage ='Payments File is Processed Successfully.'
	public static final String Yes='Yes'
	public static final String No='No'


	public static final String White='White'
	public static final String Gray='Gray'
	public static final String Orange='Golden Cream (Orange Color Family)'
	public static final String Brick='Brick Color (Trinidad)'

	public static String PPR_MaxThresholdLimitPopUpMessage(String PayElement,String CompensationModel,String Provider) {
		return 'Max Threshold Limit is exceeded for the selected Pay Element \"'+PayElement+'\" with a Comp. Model \"'+CompensationModel+'\" and for the Provider \"'+Provider+'\".\n\nDo you want to continue?'
	}

	public static String PPR_MaxCompLimitPopUpMessage(String PayElement,String Provider,Double ExceedLimit) {
		DecimalFormat df=new DecimalFormat('0.00')
		return 'Max Comp Limit is exceeded for the selected Pay Element '+PayElement+' and for the Provider '+Provider+' . Exceeded limit :$'+df.format(ExceedLimit)+'.Do you want to continue?'
	}

	public static String PPR_PayRequestSuccessMessage(String RequestDate,String PayElement) {
		return 'Pay Request inserted/updated successfully on ' + RequestDate + ' for the Pay Element ' + PayElement
	}

	public static String PPR_PayRequestErrorMessage(String RequestDate,String PayElement) {
		return 'Pay Request already exists on service date ' + RequestDate + ' for pay element ' + PayElement +' , this request will not be raised'
	}

	public static String PPR_SinglePayRequest_UploadFiles(String FileName) {
		return System.getProperty('user.dir')+'\\ImportFiles\\ProviderPayRequest\\'+FileName
	}

	public static String PPA_MaxThresholdLimitPopupMessage(String Provider,String PayElement,String CompensationModel,String PayPeriod,String ExceedAmount) {
		String updatedPayPeriod=PayPeriod.split('-')[0].trim() + ' to ' +PayPeriod.split('-')[1].trim()
		return 'Max Compensation Amount exceeded for the following Provider(s) :\n\n'+Provider+': '+PayElement+' for '+CompensationModel+' ('+updatedPayPeriod+') has Exceeded Threshold in the Amount of: $'+ExceedAmount+'\n\nDo you want to continue?'
	}
	public static String PPA_MaxThresholdLimitPopup_ThresholdLimitMessage(String Provider,String PayElement) {
		return 'Max Threshold Limit exceeded for the following Provider(s) :\n'+Provider+'\n'+PayElement+'\nDo you want to continue?'
	}

	public static List<String> PhysicianDetailsGridColumnHeadings(){
		List<String> gridHeadings=new ArrayList<String>()
		gridHeadings.add('Edit')
		gridHeadings.add('Payroll ID')
		gridHeadings.add('NPI Number')
		gridHeadings.add('Provider Name')
		gridHeadings.add('Region')
		gridHeadings.add('Location')
		gridHeadings.add('Cost Center')
		gridHeadings.add('HII CC ID')
		gridHeadings.add('Specialty')
		gridHeadings.add('Position Level')
		gridHeadings.add('Employee Type')
		gridHeadings.add('Contract Status')
		gridHeadings.add('Active')
		gridHeadings.add('Created Date')
		return gridHeadings
	}

	public static List<String> PaymentProcessGridColumnHeadings(){
		List<String> gridHeadings=new ArrayList<String>()
		gridHeadings.add('Payroll ID')
		gridHeadings.add('Provider Name')
		gridHeadings.add('Specialty')
		gridHeadings.add('Pay Element')
		gridHeadings.add('Pay Code')
		gridHeadings.add('GL AccNo')
		gridHeadings.add('HII CCID')
		gridHeadings.add('Cost Center')
		gridHeadings.add('Calculated Amount')
		gridHeadings.add('Out Bound')
		gridHeadings.add('Out Bound Type')
		gridHeadings.add('Bill To Entity')
		return gridHeadings
	}

	private static final String hLogDateTime='Log Date Time'
	private static final String hDateTimeofEvent='Date & Time of Event'
	private static final String hMaxCompensation='Max Compensation'
	private static final String hThresholdAmount='Threshold Amount'
	private static final String hAnnivNoticeDays='Anniv. Notice Days'
	private static final String hTotalUnits='Total Units'
	private static final String hTotalwRVUstRVUs='Total wRVUs/tRVUs'
	private static final String hRequestedAmount='Requested Amount'
	private static final String hApprovedRejectedAmount='Approved/ Rejected Amount'
	private static final String hLTSAccrualRate='LTS Accrual Rate'
	private static final String hCPTQuantity='CPT Quantity'
	private static final String hFFSCompensation='FFS Compensation'
	private static final String hPreviousMonthPaidHours='Previous Month Paid Hours'
	private static final String hPreviousMonthWorkedHours='Previous Month Worked Hours'
	private static final String hCurrentMonthPaidHours='Current Month Paid Hours'
	private static final String hCurrentMonthWorkedHours='Current Month Worked Hours'
	private static final String hYTDPaidHours='YTD Paid Hours'
	private static final String hYTDWorkedHours='YTD Worked Hours'
	private static final String hwRVUstRVUs='wRVUs/tRVUs'
	private static final String hVisitsEncounters='Visits/Encounters'
	private static final String hVariance='Variance'
	private static final String hInboundAmount='Inbound Amount'

	public static String getHinboundamount() {
		return hInboundAmount;
	}

	public static String getHvariance() {
		return hVariance;
	}

	public static String getHvisitsencounters() {
		return hVisitsEncounters;
	}

	public static String getHwrvustrvus() {
		return hwRVUstRVUs;
	}

	public static String getHytdworkedhours() {
		return hYTDWorkedHours;
	}

	public static String getHytdpaidhours() {
		return hYTDPaidHours;
	}

	public static String getHcurrentmonthworkedhours() {
		return hCurrentMonthWorkedHours;
	}

	public static String getHcurrentmonthpaidhours() {
		return hCurrentMonthPaidHours;
	}

	public static String getHpreviousmonthworkedhours() {
		return hPreviousMonthWorkedHours;
	}

	public static String getHpreviousmonthpaidhours() {
		return hPreviousMonthPaidHours;
	}

	public static String getHffscompensation() {
		return hFFSCompensation;
	}

	public static String getHcptquantity() {
		return hCPTQuantity;
	}

	public static String getHltsaccrualrate() {
		return hLTSAccrualRate;
	}

	public static String getHltsbalance() {
		return hLTSBalance;
	}

	public static String getHltscfbalance() {
		return hLTSCFBalance;
	}

	public static String getHltshoursused() {
		return hLTSHoursUsed;
	}

	public static String getHltsplanhours() {
		return hLTSPlanHours;
	}

	public static String getHptoaccrualrate() {
		return hPTOAccrualRate;
	}

	public static String getHptobalance() {
		return hPTOBalance;
	}

	public static String getHptocfbalance() {
		return hPTOCFBalance;
	}

	public static String getHptohoursused() {
		return hPTOHoursUsed;
	}

	public static String getHptoplanhours() {
		return hPTOPlanHours;
	}

	private static final String hLTSBalance='LTS Balance'
	private static final String hLTSCFBalance='LTS C/F Balance'
	private static final String hLTSHoursUsed='LTS Hours Used'
	private static final String hLTSPlanHours='LTS Plan Hours'
	private static final String hPTOAccrualRate='PTO Accrual Rate'
	private static final String hPTOBalance='PTO Balance'
	private static final String hPTOCFBalance='PTO C/F Balance'
	private static final String hPTOHoursUsed='PTO Hours Used'
	private static final String hPTOPlanHours='PTO Plan Hours'
	private static final String hRate='Rate ($)'
	private static final String hClinicalFTE='Clinical FTE'
	private static final String hDailyRate='Daily Rate'
	private static final String hEncounters='Encounters'
	private static final String hEncountersBeyondThreshold='Encounters Beyond Threshold'
	private static final String hNonFFSCompensation='Non FFS Compensation'
	private static final String hThreshold='Threshold'
	private static final String hPTOATOEligible='PTO/ATO Eligible'
	private static final String hPTOATOConsumed='PTO/ATO Consumed'
	private static final String hCMEEligibleAmount='CME Eligible Amount'
	private static final String hPTOATOBalance='PTO/ATO Balance'
	private static final String hCMEConsumed='CME Consumed'
	private static final String hCMEBalance='CME Balance'
	private static final String hTotalFTE='Total FTE'
	private static final String hYear='Year'
	private static final String hUnitValue='Unit Value'
	private static final String hJan='Jan'
	private static final String hTotal='Total'
	private static final String hCPTFFSRate='CPT FFS Rate'
	private static final String hCurrentPayPeriod_Amount='Current Pay Period_Amount'
	private static final String hPreviousPayPeriod_Amount='Previous Pay Period_Amount'
	private static final String hPreviousPayPeriod_Rate='Previous Pay Period_Rate'
	private static final String hRateC='Rate'
	private static final String hOutboundAmount='Outbound Amount'
	private static final String hReviewed='Reviewed'
	public static String getHreviewed() {
		return hReviewed;
	}

	public static String getHoutboundamount() {
		return hOutboundAmount;
	}

	public static String getHratec() {
		return hRateC;
	}

	private static final String hVariance_Amount='Variance %_Amount'
	private static final String hVariance_ShiftsHours='Variance %_Shifts/Hours'
	private static final String hVarianceP='Variance %_'
	public static String getHvariancep() {
		return hVarianceP;
	}

	public static String getHvarianceShiftshours() {
		return hVariance_ShiftsHours;
	}

	public static String getHvarianceAmount() {
		return hVariance_Amount;
	}

	public static String getHpreviouspayperiodRate() {
		return hPreviousPayPeriod_Rate;
	}

	public static String getHpreviouspayperiodAmount() {
		return hPreviousPayPeriod_Amount;
	}

	public static String getHcurrentpayperiodAmount() {
		return hCurrentPayPeriod_Amount;
	}

	public static String getHcptffsrate() {
		return hCPTFFSRate;
	}

	public static String getHtotal() {
		return hTotal;
	}

	public static String getHjan() {
		return hJan;
	}

	public static String getHfeb() {
		return hFeb;
	}

	public static String getHmar() {
		return hMar;
	}

	public static String getHapr() {
		return hApr;
	}

	public static String getHmay() {
		return hMay;
	}

	public static String getHjun() {
		return hJun;
	}

	public static String getHjul() {
		return hJul;
	}

	public static String getHaug() {
		return hAug;
	}

	public static String getHsep() {
		return hSep;
	}

	public static String getHoct() {
		return hOct;
	}

	public static String getHnov() {
		return hNov;
	}

	public static String getHdec() {
		return hDec;
	}

	private static final String hFeb='Feb'
	private static final String hMar='Mar'
	private static final String hApr='Apr'
	private static final String hMay='May'
	private static final String hJun='Jun'
	private static final String hJul='Jul'
	private static final String hAug='Aug'
	private static final String hSep='Sep'
	private static final String hOct='Oct'
	private static final String hNov='Nov'
	private static final String hDec='Dec'


	public static String getHunitvalue() {
		return hUnitValue;
	}

	public static String getHyear() {
		return hYear;
	}

	public static String getHtotalfte() {
		return hTotalFTE;
	}

	public static String getHcmebalance() {
		return hCMEBalance;
	}

	public static String getHcmeconsumed() {
		return hCMEConsumed;
	}

	public static String getHptoatobalance() {
		return hPTOATOBalance;
	}

	public static String getHcmeeligibleamount() {
		return hCMEEligibleAmount;
	}

	public static String getHptoatoconsumed() {
		return hPTOATOConsumed;
	}

	public static String getHptoatoeligible() {
		return hPTOATOEligible;
	}

	public static String getHthreshold() {
		return hThreshold;
	}

	public static String getHnonffscompensation() {
		return hNonFFSCompensation;
	}

	public static String getHencountersbeyondthreshold() {
		return hEncountersBeyondThreshold;
	}

	public static String getHencounters() {
		return hEncounters;
	}

	public static String getHdailyrate() {
		return hDailyRate;
	}

	public static String getHclinicalfte() {
		return hClinicalFTE;
	}

	public static String getHrate() {
		return hRate;
	}

	public static String getHtotalshifts() {
		return hTotalShifts;
	}

	public static String getHtotalamount() {
		return hTotalAmount;
	}

	public static String getHtotalshiftshours() {
		return hTotalShiftsHours;
	}

	private static final String hTotalShifts='Total Shifts'
	private static final String hTotalAmount='Total Amount ($)'
	private static final String hTotalShiftsHours='Total Shifts/ Hours'

	public static String getHapprovedrejectedamount() {
		return hApprovedRejectedAmount;
	}

	public static String getHrequestedamount() {
		return hRequestedAmount;
	}
	public static String getHlogdatetime() {
		return hLogDateTime;
	}
	public static String getHdatetimeofevent() {
		return hDateTimeofEvent;
	}
	public static String getHmaxcompensation() {
		return hMaxCompensation;
	}
	public static String getHthresholdamount() {
		return hThresholdAmount;
	}
	public static String getHannivnoticedays() {
		return hAnnivNoticeDays;
	}
	public static String getHtotalunits() {
		return hTotalUnits;
	}
	public static String getHtotalwrvustrvus() {
		return hTotalwRVUstRVUs;
	}

	private static final String DateType='Date'
	private static final String CurrencyType='Currency'
	private static final String IntType='Int'
	private static final String DecimalType='Decimal'
	private static final String DecimalTypeDigit3='DecimalTypeDigit3'
	public static String getDecimaltypedigits3() {
		return DecimalTypeDigit3;
	}

	private static final String DecimalCommaType='DecimalComma'


	public static String getDecimaltype() {
		return DecimalType;
	}
	public static String getInttype() {
		return IntType;
	}
	public static String getDatetype() {
		return DateType;
	}
	public static String getCurrencytype() {
		return CurrencyType;
	}
	public static String getDecimalcommatype() {
		return DecimalCommaType;
	}


	public static List<String> getExcludeLinks(){
		List<String> lstLinks=new ArrayList<>();
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/Admin/");
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/UserControls/#");
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/CPT/");
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/Physician/");
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/Payment/");
		lstLinks.add("https://teamhealthphaseii.heisenberg2.net/Report/");
		return lstLinks

	}


}
