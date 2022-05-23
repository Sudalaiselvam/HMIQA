package pages

import core.BaseSteps
import core.ControlFactory
import testDataTypes.ContractCompModel
import testDataTypes.ContractCostCenter
import testDataTypes.ContractData
import testDataTypes.ContractPayElement
import testDataTypes.ContractYear
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import core.AssertSteps
import utils.DateTimeUtil
import configs.HIIConstants
import utils.Utilities
import core.Logger

public class ProviderPayApprovalsSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//To Navigate Provider Pay Approvals Screen
	public static void gotoProviderPayApprovals() {
		HeaderPageSteps.gotoHomePage()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProviderPayApprovals', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void openProviderPayApprovals_newTab() {
		HeaderPageSteps.gotoHomePage()
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		getBaseSteps().openSubMenu_newTab('mnuPayment', 'mnuProviderPayApprovals', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)

	}

	/*###################################################################################################################################################################################################################################*/

	//                                                              PROVIDER PAY APPROVALS WEB ELEMENTS
	private static final String txtProvider='txtProvider'
	private static final String ddlRegion='ddlRegion'
	private static final String ddlPayCycle='ddlPayCycle'
	private static final String ddlLocation='ddlLocation'
	private static final String ddlPayrollStatus='ddlPayrollStatus'
	private static final String ddlYear='ddlYear'
	private static final String ddlPayPeriod='ddlPayPeriod'
	private static final String ddlCompensationModel='ddlCompensationModel'
	private static final String ddlPayElement='ddlPayElement'
	private static final String ddlCostCenter='ddlCostCenter'
	private static final String ddlSpecialty='ddlSpecialty'
	private static final String ddlPosition='ddlPosition'
	private static final String chkShowInactive='chkShowInactive'
	private static final String chkShowAdjHold='chkShowAdjHold'
	private static final String btnGetDetails='btnGetDetails'
	private static final String btnClear='btnClear'
	private static final String grdPhysicianPayRequest='grdPhysicianPayRequest'
	private static final String imgExport='imgExport'
	private static final String btnSendtoNextApprover='btnSendtoNextApprover'
	private static final String btnUpdate='btnUpdate'
	private static final String btnDeny='btnDeny'
	private static final String grdPayApprovalSelectAll='grdPayApprovalSelectAll'
	private static final String grdPhysicianPayRequestFreeze='grdPhysicianPayRequestFreeze'
	private static final String msgSuccess='msgSuccess'
	private static final String pnlPEPopup='pnlPEPopup'
	private static final String infoPEPopup='infoPEPopup'
	private static final String btnUploadRequestorFile='btnUploadRequestorFile'
	private static final String imgHorizontalBar='imgHorizontalBar'
	private static final String btnContinuePopup='btnContinuePopup'
	private static final String btnCancelPopup='btnCancelPopup'
	/*###################################################################################################################################################################################################################################*/

	//                                                             PROVIDER PAY APPROVALS SET METHODS

	public static void setProvider(String Provider,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(Provider!="")
		{
			getBaseSteps().setTextToControl(txtProvider, Provider, pageName.ProviderPayApprovals)
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, failureHandling)
			getBaseSteps().waitforLoadingComplete('imgLoading', 10, pageName.CMN)
		}else {
			getBaseSteps().inputDataMissing('Provider data is missing from Input Data',failureHandling)
		}
	}

	public static void selectRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlRegion, Region, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayCycle(String PayCycle) {
		getBaseSteps().selectByVisibleText(ddlPayCycle, PayCycle, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectLocation(String Location) {
		getBaseSteps().selectByVisibleText(ddlLocation, Location, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayrollStatus(String PayrollStatus) {
		getBaseSteps().selectByVisibleText(ddlPayrollStatus, PayrollStatus, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayrollStatusAsApproved() {
		getBaseSteps().selectByVisibleText(ddlPayrollStatus, 'Approved', pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayrollStatusAsPending() {
		getBaseSteps().selectByVisibleText(ddlPayrollStatus, 'Pending', pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlYear, Year, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayPeriod(String PayPeriod) {
		getBaseSteps().selectByVisibleText(ddlPayPeriod, PayPeriod, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayElement(String PayElement) {
		try {
			getBaseSteps().selectByVisibleText(ddlPayElement, PayElement, pageName.ProviderPayApprovals)
		}catch(Exception e) {
			getBaseSteps().selectByVisibleTextStartsWith(ddlPayElement, PayElement, pageName.ProviderPayApprovals)
		}
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().selectByVisibleText(ddlCostCenter, CostCenter, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectSpecialty(String Specialty) {
		getBaseSteps().selectByVisibleText(ddlSpecialty, Specialty, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPosition(String Position) {
		getBaseSteps().selectByVisibleText(ddlPosition, Position, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void checkShowInactive() {
		getBaseSteps().clickToControl(chkShowInactive, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void checkShowAdjHold() {
		getBaseSteps().clickToControl(chkShowAdjHold, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickGetDetails() {
		getBaseSteps().clickToControl(btnGetDetails, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickClear() {
		getBaseSteps().clickToControl(btnGetDetails, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickExportPayRequests() {
		if(Utilities.checkFileExists(HIIConstants.PayRequestApprovalExportExcelName)) {
			Utilities.deleteFile(HIIConstants.PayRequestApprovalExportExcelName)
		}
		getBaseSteps().clickToControl(imgExport, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		Utilities.waitForFileDownloaded(HIIConstants.PayRequestApprovalExportExcelName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.PayRequestApprovalExportExcelName), 'Requestor File:'+HIIConstants.PayRequestApprovalExportExcelName+' exported successfully', 'Requestor File:'+HIIConstants.PayRequestApprovalExportExcelName+' export failed', FailureHandling.STOP_ON_FAILURE)

	}

	public static void clickSendtoNextApprover() {
		getBaseSteps().clickToControl(btnSendtoNextApprover, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickUpdate() {
		getBaseSteps().clickToControl(btnUpdate, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickDeny() {
		getBaseSteps().clickToControl(btnDeny, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickContinue() {
		getBaseSteps().clickToControl(btnContinuePopup, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickCancel() {
		getBaseSteps().clickToControl(btnCancelPopup, pageName.ProviderPayApprovals)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}




	public static void selectPayElementWithServiceDate(String PayElement,String ServiceDate) {
		String grdPayElement,grdServiceDate,sPayElement
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)) {
			getBaseSteps().clickToControl(grdPayApprovalSelectAll, pageName.ProviderPayApprovals)
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayApprovals))

			if(rowCount==2) {
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ').getAt(0)
				if(sPayElement.equals(PayElement) && grdServiceDate.equals(ServiceDate))
				{
					getBaseSteps().clickToCellTableCheckBoxWithoutColumnNameControl(grdPhysicianPayRequestFreeze,pageName.ProviderPayApprovals)
				}
			}else if(rowCount>2) {
				for(int i=2;i<=rowCount;i++) {
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(),'Pay Element', pageName.ProviderPayApprovals)
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					sPayElement=grdPayElement.split(' - ').getAt(0)
					if(sPayElement.equals(PayElement) && grdServiceDate.equals(ServiceDate))
					{
						getBaseSteps().clickToCellTableCheckBoxWithoutColumnNameControl(grdPhysicianPayRequestFreeze,i.toString(),pageName.ProviderPayApprovals)
						break
					}
				}


			}
		}
	}

	public static void setAdjHold(String ServiceDate,String PayElement,double AdjHold) {
		String grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
		String grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
		String grdOriginal=getBaseSteps().getCellTableText(grdPhysicianPayRequest, '$ Original', pageName.ProviderPayApprovals)
		String grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest, '$ Amount', pageName.ProviderPayApprovals)

		Double grdAdjAmount
		Double AdjAmount
		//String msgAssert='Before Adjustment - Pay Request details Original: '+grdOriginal+' and Amount: '+grdAmount
		//AssertSteps.verifyActualResult(grdOriginal.equals(grdAmount), msgAssert +' - PASSED', msgAssert + '- FAILED', FailureHandling.CONTINUE_ON_FAILURE)

		if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement))
		{
			getBaseSteps().setTextToCellTableControl(this.grdPhysicianPayRequest, '$ Adj/Hold', AdjHold.toString(), pageName.ProviderPayApprovals)
			getBaseSteps().clickEnter()
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			AdjAmount=(Double.parseDouble(grdOriginal.replace(',', ''))-AdjHold)
			grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest, '$ Amount', pageName.ProviderPayApprovals)
			String msgAssert='After Adjustment - Pay Request details Amount: '+grdAmount+' and Adjusted Amount: '+AdjAmount
			AssertSteps.verifyActualResult(AdjAmount==Double.parseDouble(grdAmount.replace(',', '')), msgAssert +' - PASSED', msgAssert + '- FAILED', FailureHandling.CONTINUE_ON_FAILURE)
		}

	}

	/*###################################################################################################################################################################################################################################*/

	//                                                             PROVIDER PAY APPROVALS GET METHODS

	//To get Regions list
	public static List<String> getRegionList() {
		List<String> Regions=getBaseSteps().getlistControlDropdowm(ddlRegion, pageName.ProviderPayApprovals)
		Regions.remove('- Select Region -')
		return Regions
	}

	public static String getRegion() {
		String Region=getBaseSteps().getselectedControlDropdowm(ddlRegion, pageName.ProviderPayApprovals)
		return Region
	}

	//To get Pay Cycle list
	public static List<String> getPayCycleList() {
		List<String> PayCycles=getBaseSteps().getlistControlDropdowm(ddlPayCycle, pageName.ProviderPayApprovals)
		PayCycles.remove('- Select Pay Cycle -')
		return PayCycles
	}

	public static String getPayCycle() {
		String PayCycle=getBaseSteps().getselectedControlDropdowm(ddlPayCycle, pageName.ProviderPayApprovals)
		return PayCycle
	}

	//To get Location list
	public static List<String> getLocationList() {
		List<String> Locations=getBaseSteps().getlistControlDropdowm(ddlLocation, pageName.ProviderPayApprovals)
		Locations.remove('- Select Location -')
		return Locations
	}

	//To get Payroll Status list
	public static List<String> getPayrollStatusList() {
		List<String> PayrollStatus=getBaseSteps().getlistControlDropdowm(ddlPayrollStatus, pageName.ProviderPayApprovals)
		return PayrollStatus
	}

	//To get Year list
	public static List<String> getYearList() {
		List<String> Year=getBaseSteps().getlistControlDropdowm(ddlYear, pageName.ProviderPayApprovals)
		return Year
	}

	//To get Pay Period list
	public static List<String> getPayPeriodList() {
		List<String> PayPeriod=getBaseSteps().getlistControlDropdowm(ddlPayPeriod, pageName.ProviderPayApprovals)
		return PayPeriod
	}

	//To get Compensation Model list
	public static List<String> getCompensationModelList() {
		List<String> CompensationModel=getBaseSteps().getlistControlDropdowm(ddlCompensationModel, pageName.ProviderPayApprovals)
		return CompensationModel
	}

	//To get Pay Element list
	public static List<String> getPayElementList() {
		List<String> PayElement=getBaseSteps().getlistControlDropdowm(ddlPayElement, pageName.ProviderPayApprovals)
		PayElement.remove('- All -')
		return PayElement
	}

	//To get Cost Center list
	public static List<String> getCostCenterList() {
		List<String> CostCenter=getBaseSteps().getlistControlDropdowm(ddlCostCenter, pageName.ProviderPayApprovals)
		CostCenter.remove('- ALL -')
		return CostCenter
	}

	//To get Specialty list
	public static List<String> getSpecialtyList() {
		List<String> Specialty=getBaseSteps().getlistControlDropdowm(ddlSpecialty, pageName.ProviderPayApprovals)
		Specialty.remove('- All -')
		return Specialty
	}

	//To get Position list
	public static List<String> getPositionList() {
		List<String> Position=getBaseSteps().getlistControlDropdowm(ddlPosition, pageName.ProviderPayApprovals)
		return Position
	}

	public static String getGridPayPeriod(String RequestDate) {
		String grdServiceDate,grdPayPeriod
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				if(grdServiceDate.equals(RequestDate)) {
					grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Pay Period', pageName.ProviderPayApprovals)
				}

			}else {
				for(int i=2;i<rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
					if(grdServiceDate.equals(RequestDate)) {
						grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Pay Period', pageName.ProviderPayApprovals)
						break
					}
				}
			}

		}
		return grdPayPeriod
	}

	public static String getGridApprovalStatus(String RequestDate,String PayElement) {
		String grdServiceDate,grdPayElement,grdApprovalStatus,sPayElement
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ').getAt(0)
				if(grdServiceDate.equals(RequestDate) && sPayElement.equals(PayElement)) {
					grdApprovalStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Approval Status', pageName.ProviderPayApprovals)
				}

			}else {
				for(int i=2;i<=rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
					sPayElement=grdPayElement.split(' - ').getAt(0)
					if(grdServiceDate.equals(RequestDate) && sPayElement.equals(PayElement)) {
						grdApprovalStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Approval Status', pageName.ProviderPayApprovals)
						break
					}
				}
			}

		}
		return grdApprovalStatus
	}

	public static HashMap<String,String> getGridGLAccNoHIICCID(String PayElement,String CostCenter){
		HashMap<String,String> hmHIICCIDGLACCNo=new HashMap<String,String>()
		String grdPayElement,grdCostCenterID,sPayElement,grdHIICCID,grdGLACCNo,grdServiceDate
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				grdCostCenterID=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Cost Center ID', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				println grdPayElement
				println grdCostCenterID
				if(grdCostCenterID.equals(CostCenter) && sPayElement.equals(PayElement)) {
					//grdHIICCID=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'Location_Cost Center', pageName.ProviderPayApprovals)
					//grdGLACCNo=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'GL Account', pageName.ProviderPayApprovals)

					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					hmHIICCIDGLACCNo.put('Service Date', grdServiceDate)
					try{
						grdHIICCID=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'Location_Cost Center', pageName.ProviderPayApprovals)
					}catch(Exception e) {
						grdHIICCID=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Location_Cost Center', pageName.ProviderPayApprovals)
					}
					hmHIICCIDGLACCNo.put('HIICCID', grdHIICCID)
					try {
						grdGLACCNo=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'GL Account', pageName.ProviderPayApprovals)
					}catch(Exception e) {
						grdGLACCNo=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'GL Account', pageName.ProviderPayApprovals)
					}
					hmHIICCIDGLACCNo.put('GLAccNo', grdGLACCNo)
					break
				}
				i++
			}
		}
		return hmHIICCIDGLACCNo
	}

	public static String getGridAmount(String RequestDate,String PayElement) {
		String grdServiceDate,grdPayElement,grdAmount,sPayElement
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(RequestDate) && sPayElement.equals(PayElement)) {
					grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,'$ Amount', pageName.ProviderPayApprovals)
				}

			}else {
				for(int i=2;i<=rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
					sPayElement=grdPayElement.split(' - ')[0]
					if(grdServiceDate.equals(RequestDate) && sPayElement.equals(PayElement)) {
						grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'$ Amount', pageName.ProviderPayApprovals)
						break
					}
				}
			}

		}
		return grdAmount
	}

	public static HashMap<String,String> getGridDataForPayElementWithServiceDate(String PayElement,String ServiceDate){
		HashMap<String,String> PayRequestData=new HashMap<String,String>()
		String grdServiceDate,grdPayElement,grdProviderName,grdAmount,sPayElement,grdPayPeriod,grdApprovalStatus,grdYTDAmounts,grdThresholdAmount
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					grdProviderName=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Provider Name', pageName.ProviderPayApprovals)
					grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'$ Amount', pageName.ProviderPayApprovals)
					grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Pay Period', pageName.ProviderPayApprovals)
					grdApprovalStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Approval Status', pageName.ProviderPayApprovals)
					grdYTDAmounts=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'YTD Amounts', pageName.ProviderPayApprovals)
					grdThresholdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(),'Threshold Amount', pageName.ProviderPayApprovals)
					PayRequestData.put('ProviderName', grdProviderName)
					PayRequestData.put('Amount', grdAmount.replace(',', ''))
					PayRequestData.put('PayPeriod', grdPayPeriod)
					PayRequestData.put('ApprovalStatus', grdApprovalStatus)
					PayRequestData.put('YTDAmounts', grdYTDAmounts)
					PayRequestData.put('ThresholdAmount', grdThresholdAmount)
					break
				}
				i++
			}

		}

		return PayRequestData
	}

	public static void updateAmountForPayElementWithServiceDate(String PayElement,String ServiceDate,String updateAmount) {
		String grdPayElement,grdServiceDate,sPayElement
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(sPayElement.equals(PayElement) && grdServiceDate.equals(ServiceDate)) {
					getBaseSteps().setTextToCellTableControl(grdPhysicianPayRequest,i.toString(), '$ Amount', updateAmount, pageName.ProviderPayApprovals)
					getBaseSteps().clickEnter()
					getBaseSteps().waitforLoadingComplete('imgLoading',pageName.CMN)
					break
				}
			}
		}
	}

	public static void verifyGridAmountWRTUnitsUpdate(String RequestDate,String PayElement,String Unit) {
		String grdServiceDate,grdPayElement,grdRate,grdAmount,grdUnits,sPayElement
		Double dblAmount,expAmount,actAmount
		boolean blnUpdateUnit=false
		String msgAssert
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				grdRate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Rate', pageName.ProviderPayApprovals)
				grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'$ Amount', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(RequestDate) && sPayElement.equals(PayElement) && grdRate!='') {
					grdUnits=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'Units', pageName.ProviderPayApprovals)
					expAmount=Utilities.getResultOfProduct(grdRate, grdUnits)
					actAmount=Double.parseDouble(grdAmount.replace(',', ''))
					msgAssert='Expected Amount:'+expAmount+' and Actual Amount :'+actAmount+ ' with product of Rate:'+grdRate+' and Unit: '+grdUnits
					AssertSteps.verifyActualResult(Utilities.verifyValuesAreSame(expAmount, actAmount), msgAssert, msgAssert, FailureHandling.STOP_ON_FAILURE)
					getBaseSteps().setTextToCellTableControl(grdPhysicianPayRequest,i.toString(), 'Units', Unit, pageName.ProviderPayApprovals)
					getBaseSteps().clickEnter()
					grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'$ Amount', pageName.ProviderPayApprovals)
					grdUnits=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'Units', pageName.ProviderPayApprovals)
					expAmount=Utilities.getResultOfProduct(grdRate, grdUnits)
					actAmount=Double.parseDouble(grdAmount.replace(',', ''))
					msgAssert='Before clicking Update Button - Expected Amount:'+expAmount+' and Actual Amount :'+actAmount+ ' with product of Rate:'+grdRate+' and Unit: '+grdUnits
					AssertSteps.verifyActualResult(Utilities.verifyValuesAreSame(expAmount, actAmount), msgAssert, msgAssert, FailureHandling.STOP_ON_FAILURE)
					blnUpdateUnit=true
					this.clickUpdate()
					this.verifyUpdateFunctionality()
					grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'$ Amount', pageName.ProviderPayApprovals)
					grdUnits=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(),'Units', pageName.ProviderPayApprovals)
					expAmount=Utilities.getResultOfProduct(grdRate, grdUnits)
					actAmount=Double.parseDouble(grdAmount.replace(',', ''))
					msgAssert='After clicking Update Button - Expected Amount:'+expAmount+' and Actual Amount :'+actAmount+ ' with product of Rate:'+grdRate+' and Unit: '+grdUnits
					AssertSteps.verifyActualResult(Utilities.verifyValuesAreSame(expAmount, actAmount), msgAssert, msgAssert, FailureHandling.STOP_ON_FAILURE)

				}
				i++
			}
		}
		if(!blnUpdateUnit)
			AssertSteps.verifyActualResult(blnUpdateUnit, ' Pay Element:'+PayElement+'  with Service Date:'+RequestDate+' and Unit Rate exists', ' Pay Element:'+PayElement+'with Service Date:'+RequestDate+' and Unit Rate does not exists', FailureHandling.OPTIONAL)
	}

	public static String getGridPeriod(String RequestDate) {
		String grdServiceDate,grdPeriod
		if(getBaseSteps().WebElementDisplayed(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				if(grdServiceDate.equals(RequestDate)) {
					grdPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Period', pageName.ProviderPayApprovals)
				}

			}else {
				for(int i=2;i<rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
					if(grdServiceDate.equals(RequestDate)) {
						grdPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,'Period', pageName.ProviderPayApprovals)
						break
					}
				}
			}

		}
		return grdPeriod
	}

	public static String getMaxCompensationAndThresholdExceedAlertMessage() {
		String msgPopUp
		if(MaxCompensationAndThresholdExceedAlert_Popup_Displayed())
		{
			msgPopUp=getBaseSteps().getTextFromControl(infoPEPopup, pageName.ProviderPayApprovals)
		}else {
			Logger.setFailureHandling('MaxCompensationAndThreshold Exceed Alert Message should display', FailureHandling.STOP_ON_FAILURE)
		}
		return msgPopUp

	}

	public static String getGridProviderName() {
		return getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Provider Name', pageName.ProviderPayApprovals)
	}

	public static String getGridPayPeriod() {
		return getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Period', pageName.ProviderPayApprovals)
	}

	/*###################################################################################################################################################################################################################################*/
	//########################### PAY REQUEST METHODS ####################################

	public static void verifyShowAdjHoldSetting(String flagSetting) {
		if(flagSetting.equals('Yes')) {
			getBaseSteps().verifyWebElementDisplayed(chkShowAdjHold, pageName.ProviderPayApprovals, 'Show Adj/Hold checkbox displayed', 'Show Adj/Hold checkbox option is not displayed', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void verifySendtoNextApproverFunctionality() {

		AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayApprovals), 'Success Message displayed', 'Success Message not displayed', FailureHandling.STOP_ON_FAILURE)

		String msgValidation=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayApprovals)

		AssertSteps.verifyActualResult(msgValidation.equals(HIIConstants.PayRequestApprovalSuccessMessage), 'Success Message is as expected', 'Success Message is not as expected', FailureHandling.OPTIONAL)

	}

	public static void verifyUpdateFunctionality() {

		AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayApprovals), 'Success Message displayed', 'Success Message not displayed', FailureHandling.STOP_ON_FAILURE)

		String msgValidation=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayApprovals)

		AssertSteps.verifyActualResult(msgValidation.equals(HIIConstants.PayRequestApprovalUpdateMessage), 'Success Message is as expected', 'Success Message is not as expected', FailureHandling.OPTIONAL)

	}

	public static void verifyDenyFunctionality() {

		AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(msgSuccess, pageName.ProviderPayApprovals), 'Success Message displayed', 'Success Message not displayed', FailureHandling.STOP_ON_FAILURE)

		String msgValidation=getBaseSteps().getTextFromControl(msgSuccess, pageName.ProviderPayApprovals)

		String AssertMsg='Expected : '+HIIConstants.PayRequestApprovalDenyMessage+' and Actual : '+msgValidation

		AssertSteps.verifyActualResult(msgValidation.equals(HIIConstants.PayRequestApprovalDenyMessage), AssertMsg+' :PASS', AssertMsg+' :FAIL', FailureHandling.CONTINUE_ON_FAILURE)

	}

	public static void verifySendtoNextApproverDisplayedWRTPayRequest(String ProviderName) {
		boolean blnPayRequestCreated=ProviderPayRequestSteps.ProviderPayRequestCreated(ProviderName)
		if(blnPayRequestCreated)
			AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(btnSendtoNextApprover, pageName.ProviderPayApprovals), 'SendtoNextApprover button is displayed : PASSED ', 'SendtoNextApprover button is not displayed : FAILED', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifySendtoNextApproverDisplayed() {
		getBaseSteps().setWindowsSize(75)
		AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(btnSendtoNextApprover, pageName.ProviderPayApprovals), 'SendtoNextApprover button is displayed : PASSED ', 'SendtoNextApprover button is not displayed : FAILED', FailureHandling.STOP_ON_FAILURE)
		getBaseSteps().setWindowsSize(100)
	}

	//########################### DEPENDENCY METHODS #######################################

	// To get Provider eligibility from Contract screen

	public static boolean getContractProviderNameValidity(String Provider) {

		boolean blnProvider=false

		ContractData contractData
		ContractCompModel contractCompModel
		ContractCostCenter contractCostCenter
		ContractPayElement contractPayElement
		ContractYear contractYear

		contractData = ManageProviderContractSteps.getContractDetailsMarkCompleted(Provider)
		for(String currentYear:contractData.CurrentYear)
		{
			contractYear=contractData.HMContractYear.get(currentYear)
			for(String compModel:contractYear.lstCompModel) {
				contractCompModel=contractYear.HMContractCompModel.get(compModel)
				if(contractCompModel.ContractStatus.equals('Checked'))
					blnProvider=true
			}
		}
		return blnProvider
	}

	public static Collection<String> getExpectedPayElements(String Role,String Region,String CompensationModel){

		List<String> lstOCPayElements=new ArrayList<String>()
		List<String> lstRWPayElements=new ArrayList<String>()
		List<String> expectedPayElements=new ArrayList<String>()

		String hmKey,hmValue

		HashMap<String,String> hmPayElement=new HashMap<String,String>()
		List<String> lstFiltered=new ArrayList<String>()

		hmPayElement= PayElementsSteps.getActivePayElementDescriptionPayrollRefCode_Combination()

		lstOCPayElements=OrgCompModelsPayElementsSteps.getPayElementsWRTRegionCompensationModel(Region, CompensationModel)

		for(Map.Entry map:hmPayElement.entrySet()) {
			if(!lstOCPayElements.contains(map.getKey())) {
				lstFiltered.add(map.getKey())
			}
		}

		for(String rPayElement:lstFiltered)
			hmPayElement.remove(rPayElement)

		lstFiltered.clear()

		lstRWPayElements=RoleUserWisePayElementsSteps.getPayElementsWRTRoleRegionCompensationModel(Role, Region, CompensationModel)

		for(Map.Entry map:hmPayElement.entrySet()) {
			if(!lstRWPayElements.contains(map.getKey())) {
				lstFiltered.add(map.getKey())

			}
		}

		for(String rPayElement:lstFiltered)
			hmPayElement.remove(rPayElement)

		lstFiltered.clear()


		for(Map.Entry map:hmPayElement.entrySet()) {
			expectedPayElements.add(map.getValue())
		}

		return expectedPayElements



	}

	//########################### ASSERTION METHODS #######################################

	//To check Provider Name Web Service functionality after entering Provider into Provider Name field
	public static void verifyProviderWebService(String Provider,boolean validProvider) {
		getBaseSteps().setTextToControl(txtProvider, Provider, pageName.ProviderPayApprovals)

		if(validProvider) {
			getBaseSteps().verifyProviderHintsDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}else {
			getBaseSteps().verifyProviderHintsNotDisplayed('lstProviderhints', pageName.CMN, FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void verifyRegionList(Collection<String> expectedRegions,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualRegions=getRegionList()
		for(String eRegion:expectedRegions)
		{
			AssertSteps.verifyActualResult(actualRegions.contains(eRegion), 'Region : '+eRegion+' contains in Region dropdown', 'Region : '+eRegion+' does not contain in Region dropdown', failureHandling)
		}
	}

	public static void verifyPayCyleList(Collection<String> expectedPayCycle,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualPayCycle=getPayCycleList()

		for(String epayCycle:expectedPayCycle)
		{
			AssertSteps.verifyActualResult(actualPayCycle.contains(epayCycle), 'Pay Cycle : '+epayCycle+' contains in Pay Cycle dropdown', 'Pay Cycle : '+epayCycle+' does not contain in Pay Cycle dropdown', failureHandling)
		}
	}

	public static void verifyLocationList(Collection<String> expectedLocation,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualLocation=getLocationList()

		for(String eLocation:expectedLocation)
		{
			AssertSteps.verifyActualResult(actualLocation.contains(eLocation), 'Location : '+eLocation+' contains in Location dropdown', 'Location : '+eLocation+' does not contain in Location dropdown', failureHandling)
		}
	}

	public static void verifyPayPeriodList(Collection<String> expectedPayPeriod,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualPayPeriod=this.getPayPeriodList()
		/*actualPayPeriod.remove('- Select Pay Period -')
		 for(String payPeriod:actualPayPeriod)
		 println payPeriod
		 */
		for(String ePayPeriod:expectedPayPeriod)
		{
			AssertSteps.verifyActualResult(actualPayPeriod.contains(ePayPeriod), 'Pay Period : '+ePayPeriod+' contains in Pay Period dropdown', 'Pay Period : '+ePayPeriod+' does not contain in Pay Period dropdown', failureHandling)
		}

	}

	public static void verifyPayElementList(Collection<String> expectedPayElements,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		List<String> actualPayElements=this.getPayElementList()
		int acount=0,ecount=0

		println 'Expected Pay Elements count: '+expectedPayElements.size()
		println 'Actual Pay Elements count: '+actualPayElements.size()
		for(String aPayElement:actualPayElements)
		{
			AssertSteps.verifyActualResult(expectedPayElements.contains(aPayElement), 'Pay Element : '+aPayElement+' contains in expected Pay Element list', 'Pay Element : '+aPayElement+' does not contain in expected Pay Element list', failureHandling)
		}

		//AssertSteps.verifyActualResult((expectedPayElements.size().toString()).equals(actualPayElements.size().toString()),failureHandling)

		for(String ePayElement:expectedPayElements)
		{
			AssertSteps.verifyActualResult(actualPayElements.contains(ePayElement), 'Pay Element : '+ePayElement+' contains in Pay Element dropdown', 'Pay Element : '+ePayElement+' does not contain in Pay Element dropdown', failureHandling)
		}

	}

	public static void verifyCostCenterListDropdown(Collection<String> expectedCostCenter,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {

		List<String> lstCostCenter=new ArrayList<String>()
		lstCostCenter=getCostCenterList()

		//println 'Expected Specialty count: '+expectedCostCenter.size()+' with list : '+expectedCostCenter
		//println 'Actual Specialty count: '+lstCostCenter.size()+' with list : '+lstCostCenter
		String msgAssert='Expected Cost Centers count: '+expectedCostCenter.size()+' with list : '+expectedCostCenter+' and Actual Cost Centers count: '+lstCostCenter.size()+' with list : '+lstCostCenter
		AssertSteps.verifyActualResult(expectedCostCenter.equals(lstCostCenter), msgAssert, msgAssert, FailureHandling.CONTINUE_ON_FAILURE)
		for(String aCostCenter:lstCostCenter)
		{
			AssertSteps.verifyActualResult(expectedCostCenter.contains(aCostCenter), 'Cost Center : '+aCostCenter+' contains in expected Cost Center list', 'Cost Center : '+aCostCenter+' does not contain in expected Cost Center list', failureHandling)
		}

		for(String eCostCenter:expectedCostCenter)
		{
			AssertSteps.verifyActualResult(lstCostCenter.contains(eCostCenter), 'Cost Center : '+eCostCenter+' contains in Cost Center dropdown', 'Cost Center : '+eCostCenter+' does not contain in Cost Center dropdown', failureHandling)
		}

	}

	public static void verifySpecialtyListDropdown(Collection<String> expectedSpecialty,FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {

		List<String> lstSpecialties=new ArrayList<String>()
		lstSpecialties=getSpecialtyList()

		String msgAssert='Expected Specialty count: '+expectedSpecialty.size()+' with list : '+expectedSpecialty+' and Actual Specialty count: '+lstSpecialties.size()+' with list : '+lstSpecialties
		AssertSteps.verifyActualResult(expectedSpecialty.equals(lstSpecialties), msgAssert, msgAssert, FailureHandling.CONTINUE_ON_FAILURE)

		for(String aSpecialty:lstSpecialties)
		{
			AssertSteps.verifyActualResult(expectedSpecialty.contains(aSpecialty), 'Specialty : '+aSpecialty+' contains in expected Specialty list', 'Specialty : '+aSpecialty+' does not contain in expected Specialty list', failureHandling)
		}

		for(String eSpecialty:expectedSpecialty)
		{
			AssertSteps.verifyActualResult(lstSpecialties.contains(eSpecialty), 'Specialty : '+eSpecialty+' contains in Specialty dropdown', 'Specialty : '+eSpecialty+' does not contain in Specialty dropdown', failureHandling)
		}

	}

	public static void verifyPayRequestsCreatedForInactiveContracts() {
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		AssertSteps.verifyActualResult(bGridPayRequests, 'Grid with Inactive Contracts are displayed', 'May be there are no Pay Requests with Inactive Contracts', FailureHandling.OPTIONAL)
		if(bGridPayRequests)
		{
			String ContractStatus=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Contract Status', pageName.ProviderPayApprovals)
			AssertSteps.verifyActualResult(ContractStatus.equals('Inactive'), 'Pay Request Contract Status is as expected ', 'Pay Request Contract status is not as expected', FailureHandling.STOP_ON_FAILURE)
		}
	}

	public static void verifyPayRequest(String ServiceDate,String PayElement) {

		String grdServiceDate,grdPayElement
		boolean blnPayRequest=false
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		if(bGridPayRequests)
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
				if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
					blnPayRequest=true
				}

			}else {
				for(int i=2;i<=rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
					if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
						blnPayRequest=true
						break
					}
				}
			}
		}

		AssertSteps.verifyActualResult(blnPayRequest,'Pay Request exists','Pay Request does not exists',FailureHandling.STOP_ON_FAILURE)


	}

	public static void verifyPayRequestExists(String Provider,String ServiceDate,String PayElement) {

		String grdServiceDate,grdPayElement,sPayElement
		boolean blnPayRequest=false
		gotoProviderPayApprovals()
		setProvider(Provider)
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		if(bGridPayRequests)
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					blnPayRequest=true
					break
				}
				i++
			}
		}
		AssertSteps.verifyActualResult(blnPayRequest,'Pay Request exists','Pay Request does not exists',FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyPayPeriod(String ServiceDate)
	{
		String PayCycle=getPayCycle()
		String PayPeriod,grdPayPeriod
		List<String> expectedPayPeriod = new ArrayList<String>()
		expectedPayPeriod = PayCycleSetupPageSteps.getPayPeriodWRTPayCycle(PayCycle, ServiceDate.split('/').getAt(2))

		for(String ePayPeriod:expectedPayPeriod) {
			if(DateTimeUtil.verifyDateInbetween(ePayPeriod.split(' - ').getAt(0), ePayPeriod.split(' - ').getAt(1), ServiceDate))
			{
				PayPeriod=ePayPeriod
				break
			}
		}
		grdPayPeriod=getGridPayPeriod(ServiceDate)
		AssertSteps.verifyActualResult(grdPayPeriod.equals(PayPeriod), 'Pay Period values is as expected, Actual:'+grdPayPeriod+' Expected: '+PayPeriod, 'Pay Period values is not as expected, Actual:'+grdPayPeriod+' Expected: '+PayPeriod, FailureHandling.STOP_ON_FAILURE)


	}

	public static void verifyPeriod(String ServiceDate)
	{

		String grdPeriod=getGridPeriod(ServiceDate)
		AssertSteps.verifyActualResult(grdPeriod.equals(''), 'Period values is as expected, Actual:'+grdPeriod+' Expected:'+null, 'Pay Period values is not as expected, Actual:'+grdPeriod+' Expected: '+null, FailureHandling.STOP_ON_FAILURE)


	}

	public static boolean MaxCompensationAndThresholdExceedAlert_Popup_Displayed() {
		return getBaseSteps().WebElementDisplayed(pnlPEPopup, pageName.ProviderPayApprovals)
		//AssertSteps.verifyActualResult(getBaseSteps().WebElementDisplayed(pnlPEPopup, pageName.ProviderPayApprovals), 'Alert Pop-Up Displayed', 'Alert Pop-up not displayed', FailureHandling.OPTIONAL)
	}

	public static void verifyRequestorFiles(String PayElement,String ServiceDate,String RequestorFileName) {
		String grdServiceDate,grdPayElement,grdRequestorFiles
		boolean blnRequestorFile=false
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		if(bGridPayRequests)
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			if(rowCount==2) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Pay Element', pageName.ProviderPayApprovals)
				if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
					grdRequestorFiles=getBaseSteps().getCellTableText(grdPhysicianPayRequest, 'Requestor Files', pageName.ProviderPayApprovals)
					if(grdRequestorFiles.equals(RequestorFileName))
						blnRequestorFile=true
				}

			}else {
				for(int i=2;i<=rowCount;i++)
				{
					grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
					grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
					if(grdServiceDate.equals(ServiceDate) && grdPayElement.equals(PayElement)) {
						grdRequestorFiles=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Requestor Files', pageName.ProviderPayApprovals)
						if(grdRequestorFiles.equals(RequestorFileName))
							blnRequestorFile=true
						break
					}
				}
			}
		}

		AssertSteps.verifyActualResult(blnRequestorFile,'Requestor File exists','Requestor File does not exists',FailureHandling.STOP_ON_FAILURE)
	}

	public static void clickRequestorFile(String PayElement,String ServiceDate,String RequestorFileName) {
		String grdServiceDate,grdPayElement,grdRequestorFiles,sPayElement
		boolean blnRequestorFile=false
		int i=2
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		if(bGridPayRequests)
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))

			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					grdRequestorFiles=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Requestor Files', pageName.ProviderPayApprovals)
					if(grdRequestorFiles.equals(RequestorFileName))
						blnRequestorFile=true
					break
				}
				i++
			}
		}
		AssertSteps.verifyActualResult(blnRequestorFile,'Requestor File exists','Requestor File does not exists',FailureHandling.STOP_ON_FAILURE)
		if(blnRequestorFile)
			getBaseSteps().clickToCellTableText(grdPhysicianPayRequest,i.toString(), 'Requestor Files', pageName.ProviderPayApprovals)
	}



	public static void verifyRequestorFileClickFunctionality(String PayElement,String ServiceDate,String RequestorFileName) {
		if(Utilities.checkFileExists(RequestorFileName)) {
			Utilities.deleteFile(RequestorFileName)
		}
		clickRequestorFile(PayElement,ServiceDate,RequestorFileName)

		Utilities.waitForFileDownloaded(RequestorFileName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(RequestorFileName), 'Requestor File:'+RequestorFileName+' exported successfully', 'Requestor File:'+RequestorFileName+' export failed', FailureHandling.STOP_ON_FAILURE)
	}

	public static void verifyExportPayRequestsClickFunctionality() {
		if(Utilities.checkFileExists(HIIConstants.PayRequestApprovalExportExcelName)) {
			Utilities.deleteFile(HIIConstants.PayRequestApprovalExportExcelName)
		}
		clickExportPayRequests()

		Utilities.waitForFileDownloaded(HIIConstants.PayRequestApprovalExportExcelName, 2000)

		AssertSteps.verifyActualResult(Utilities.checkFileExists(HIIConstants.PayRequestApprovalExportExcelName), 'Pay Requests Export Excel File:'+HIIConstants.PayRequestApprovalExportExcelName+' exported successfully', 'Pay Requests Export Excel File:'+HIIConstants.PayRequestApprovalExportExcelName+' export failed', FailureHandling.STOP_ON_FAILURE)
	}

	public static void uploadRequestorFile(String PayElement,String ServiceDate,String RequestorFileName) {
		String grdServiceDate,grdPayElement,sPayElement
		String filepath=System.getProperty("user.dir") + "\\ImportFiles\\ProviderPayApprovals\\"+RequestorFileName
		boolean bGridPayRequests=getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)
		if(bGridPayRequests)
		{
			int rowCount=Integer.parseInt(getBaseSteps().getRowTableCounts(this.grdPhysicianPayRequest, pageName.ProviderPayApprovals))
			int i=2
			while(i<=rowCount) {
				grdServiceDate=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Service Date', pageName.ProviderPayApprovals)
				grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
				sPayElement=grdPayElement.split(' - ')[0]
				if(grdServiceDate.equals(ServiceDate) && sPayElement.equals(PayElement)) {
					getBaseSteps().scrollHorizontalBar(imgHorizontalBar, 750, pageName.ProviderPayApprovals)
					getBaseSteps().clickEnter()
					//getBaseSteps().clickEscape()
					//getBaseSteps().clickToControl(btnUploadRequestorFile, pageName.ProviderPayApprovals)
					//getBaseSteps().clickEscape()
					getBaseSteps().setTextToMultipleControl(btnUploadRequestorFile,(i-2).toString(),filepath, pageName.ProviderPayApprovals)

					break
				}
				i++
			}

		}
	}


	public static void LoginAndApprovePayRequest(String UserRole,String Provider,String PayElement,String ServiceDate,String BeforeStatus) {
		String grdApprovalStatus,msgAsserStep
		LoginPageSteps.Login(UserRole)
		gotoProviderPayApprovals()
		setProvider(Provider)
		grdApprovalStatus=getGridApprovalStatus(ServiceDate, PayElement)
		msgAsserStep='Pay Element:' + PayElement + ' is with Pay Request Status: ' +grdApprovalStatus
		AssertSteps.verifyActualResult(grdApprovalStatus.equals(BeforeStatus), msgAsserStep, msgAsserStep, FailureHandling.STOP_ON_FAILURE)
		selectPayElementWithServiceDate(PayElement, ServiceDate)
		clickSendtoNextApprover()
		verifySendtoNextApproverFunctionality()
		HeaderPageSteps.logOff()
	}

	public static void LoginAndDenyPayRequest(String UserRole,String Provider,String PayElement,String ServiceDate,String BeforeStatus) {
		String grdApprovalStatus,msgAsserStep
		String ExpectedDenyStatus
		LoginPageSteps.Login(UserRole)
		gotoProviderPayApprovals()
		setProvider(Provider)
		grdApprovalStatus=getGridApprovalStatus(ServiceDate, PayElement)
		msgAsserStep='Pay Element:' + PayElement + ' is with Pay Request Status: ' +grdApprovalStatus
		AssertSteps.verifyActualResult(grdApprovalStatus.equals(BeforeStatus), msgAsserStep, msgAsserStep, FailureHandling.STOP_ON_FAILURE)
		selectPayElementWithServiceDate(PayElement, ServiceDate)
		clickDeny()
		verifyDenyFunctionality()
		HeaderPageSteps.logOff()
	}

	public static void LoginAndApproveDenyPayRequest(String UserRole,String Provider,String PayElement,String ServiceDate,String BeforeStatus,String ApproveDeny) {
		String grdApprovalStatus,msgAsserStep
		String ExpectedDenyStatus
		LoginPageSteps.Login(UserRole)
		gotoProviderPayApprovals()
		setProvider(Provider)
		grdApprovalStatus=getGridApprovalStatus(ServiceDate, PayElement)
		msgAsserStep='Pay Element:' + PayElement + ' is with Pay Request Status: ' +grdApprovalStatus
		AssertSteps.verifyActualResult(grdApprovalStatus.equals(BeforeStatus), msgAsserStep, msgAsserStep, FailureHandling.STOP_ON_FAILURE)
		selectPayElementWithServiceDate(PayElement, ServiceDate)
		switch(ApproveDeny) {
			case 'Approve':
				clickSendtoNextApprover()
				verifySendtoNextApproverFunctionality()
				break
			case 'Deny':
				ExpectedDenyStatus=BeforeStatus+'(Denied)'
				clickDeny()
				verifyDenyFunctionality()
				grdApprovalStatus=getGridApprovalStatus(ServiceDate, PayElement)
				msgAsserStep='Pay Element:' + PayElement + ' is with Pay Request Status: ' +grdApprovalStatus
				AssertSteps.verifyActualResult(grdApprovalStatus.equals(ExpectedDenyStatus), msgAsserStep, msgAsserStep, FailureHandling.STOP_ON_FAILURE)
				break
		}

		HeaderPageSteps.logOff()
	}

	public static HashMap<String,String> getPayPeriodAmount(){
		HashMap<String,String> PayPeriodAmount=new HashMap<String,String>()
		if(getBaseSteps().WebElementDisplayed(grdPhysicianPayRequest, pageName.ProviderPayApprovals)) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			int recordsCount=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayApprovals).toInteger()
			int i=2
			String PayPeriod,Amount
			while(i<=recordsCount) {
				PayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest,i.toString(), 'Pay Period', pageName.ProviderPayApprovals)
				Amount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest,i.toString(), '$ Amount', pageName.ProviderPayApprovals)
				PayPeriodAmount.put(PayPeriod, Amount)
				i++
			}
		}
		return PayPeriodAmount

	}


	public static List<HashMap> getPayDetails(String Provider) {
		List<HashMap> PayDetails=new ArrayList<>()
		openProviderPayApprovals_newTab()
		setProvider(Provider)
		int recordsCount,i
		String grdApprovalStatus
		selectPayrollStatusAsPending()
		clickGetDetails()

		CommonSteps.selectMaxPagesize()
		recordsCount=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayApprovals).toInteger()
		i=2
		grdApprovalStatus='Pending'
		while(i<=recordsCount) {
			HashMap<String,String> PendingPay=new HashMap<>()
			String grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
			String grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Period', pageName.ProviderPayApprovals)
			String grdAmount=getBaseSteps().getTextfromCellTextBoxTableControl(grdPhysicianPayRequest, i.toString(), '$ Amount', pageName.ProviderPayApprovals)
			PendingPay.put('PayElement', grdPayElement)
			PendingPay.put('PayPeriod', grdPayPeriod)
			PendingPay.put('Amount', grdAmount)
			PendingPay.put('ApprovalStatus', grdApprovalStatus)
			PayDetails.add(PendingPay)
			i++
		}

		selectPayrollStatusAsApproved()
		clickGetDetails()

		CommonSteps.selectMaxPagesize()
		recordsCount=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayApprovals).toInteger()
		i=2
		grdApprovalStatus='Approved'
		while(i<=recordsCount) {
			HashMap<String,String> ApprovedPay=new HashMap<>()
			String grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
			String grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Period', pageName.ProviderPayApprovals)
			String grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), '$ Amount', pageName.ProviderPayApprovals)
			ApprovedPay.put('PayElement', grdPayElement)
			ApprovedPay.put('PayPeriod', grdPayPeriod)
			ApprovedPay.put('Amount', grdAmount)
			ApprovedPay.put('ApprovalStatus', grdApprovalStatus)
			PayDetails.add(ApprovedPay)
			i++
		}


		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return PayDetails
	}

	public static List<HashMap> getPayDetailsApproved(String Provider,String Year) {
		List<HashMap> PayDetails=new ArrayList<>()
		openProviderPayApprovals_newTab()
		setProvider(Provider)
		int recordsCount,i
		String grdApprovalStatus
		selectPayrollStatusAsApproved()
		selectYear(Year)
		clickGetDetails()
		CommonSteps.selectMaxPagesize()
		recordsCount=getBaseSteps().getRowTableCounts(grdPhysicianPayRequest, pageName.ProviderPayApprovals).toInteger()
		i=2
		grdApprovalStatus='Approved'
		while(i<=recordsCount) {
			HashMap<String,String> ApprovedPay=new HashMap<>()
			String grdPayElement=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Element', pageName.ProviderPayApprovals)
			String grdPayPeriod=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'Pay Period', pageName.ProviderPayApprovals)
			String grdAmount=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), '$ Amount', pageName.ProviderPayApprovals)
			String grdYTDAmounts=getBaseSteps().getCellTableText(grdPhysicianPayRequest, i.toString(), 'YTD Amounts', pageName.ProviderPayApprovals)
			ApprovedPay.put('PayElement', grdPayElement)
			ApprovedPay.put('PayPeriod', grdPayPeriod)
			ApprovedPay.put('Amount', grdAmount)
			ApprovedPay.put('YTDAmount', grdYTDAmounts)
			ApprovedPay.put('ApprovalStatus', grdApprovalStatus)
			PayDetails.add(ApprovedPay)
			i++
		}
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return PayDetails
	}

}



