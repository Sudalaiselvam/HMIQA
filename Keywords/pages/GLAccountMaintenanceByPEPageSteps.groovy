package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName
import utils.DateTimeUtil
/**
 * @author AnilKumarJanapareddy
 *
 */
public class GLAccountMaintenanceByPEPageSteps {


	private static final String ddlPayElement='ddlPayElement'
	private static final String ddllblPayElement='ddllblPayElement'
	private static final String ddlRegion='ddlRegion'
	private static final String ddllblRegion='ddllblRegion'
	private static final String ddlLocation='ddlLocation'
	private static final String ddllblLocation='ddllblLocation'
	private static final String ddlCostCenter='ddlCostCenter'
	private static final String ddllblCostCenter='ddllblCostCenter'
	private static final String ddlSpecialty='ddlSpecialty'
	private static final String ddllblSpecialty='ddllblSpecialty'
	private static final String ddlCompModel='ddlCompModel'
	private static final String ddllblCompModel='ddllblCompModel'
	private static final String ddlPositionLevel='ddlPositionLevel'
	private static final String ddllblPositionLevel='ddllblPositionLevel'
	private static final String ddlEmployeeType='ddlEmployeeType'
	private static final String ddllblEmployeeType='ddllblEmployeeType'
	private static final String btnShowDetails='btnShowDetails'
	private static final String grdGLAccDetailsByPE='grdGLAccDetailsByPE'
	private static final String grdGLAccDetailsByPENoRecordsFound='grdGLAccDetailsByPENoRecordsFound'

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void openGLAccountMaintenanceByPE_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuGLAccountMaintenanceByPE', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void gotoGLAccountMaintenanceByPE() {
		getBaseSteps().gotoSubMenu('mnuPayElementConfig', 'mnuGLAccountMaintenanceByPE', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPayElement(String PayElement) {
		getBaseSteps().clickToControl(ddlPayElement, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelStartswithtext(ddllblPayElement, PayElement, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectRegion(String Region) {
		getBaseSteps().clickToControl(ddlRegion, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblRegion, Region, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectLocation(String Location) {
		getBaseSteps().clickToControl(ddlLocation, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblLocation, Location, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCostCenter(String CostCenter) {
		getBaseSteps().clickToControl(ddlCostCenter, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblCostCenter, CostCenter, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectSpecialty(String Specialty) {
		getBaseSteps().clickToControl(ddlSpecialty, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblSpecialty, Specialty, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectCompensationModel(String CompModel) {
		getBaseSteps().clickToControl(ddlCompModel, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblCompModel, CompModel, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectPositionLevel(String PositionLevel) {
		getBaseSteps().clickToControl(ddlPositionLevel, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblPositionLevel, PositionLevel, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectEmployeeType(String EmployeeType) {
		getBaseSteps().clickToControl(ddlEmployeeType, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickLabelwithtext(ddllblEmployeeType, EmployeeType, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().clickToControl('pageHeader', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void clickShowDetails() {
		getBaseSteps().clickToControl(btnShowDetails, pageName.GLAccountMaintenanceByPE)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		if(!getBaseSteps().WebElementDisplayed(grdGLAccDetailsByPENoRecordsFound, pageName.GLAccountMaintenanceByPE)) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
		}
	}

	public static String getGridGLAccountNo(String Region,String Location,String CostCenter,String Specialty,String CompModel,String PositionLevel,String EmployeeType,String EffectiveFrom) {

		String tempDate=''
		String gridRegion,gridLocation,gridCostCenter,gridSpecialty,gridCompModel,gridPositionLevel,gridEmployeeType,gridEffectiveFrom
		String gridGLAccountNo
		if(!getBaseSteps().WebElementDisplayed(grdGLAccDetailsByPENoRecordsFound, pageName.GLAccountMaintenanceByPE)) {
			getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
			getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
			int RowCount=getBaseSteps().getRowTableCounts(grdGLAccDetailsByPE, pageName.GLAccountMaintenanceByPE).toInteger()
			for(int i=2;i<=RowCount;i++) {

				gridRegion=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(), 'Region', pageName.GLAccountMaintenanceByPE)
				gridLocation=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Location', pageName.GLAccountMaintenanceByPE)
				gridCostCenter=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Cost Center', pageName.GLAccountMaintenanceByPE)
				gridSpecialty=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Specialty', pageName.GLAccountMaintenanceByPE)
				gridCompModel=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Comp. Model', pageName.GLAccountMaintenanceByPE)
				gridPositionLevel=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Position Level', pageName.GLAccountMaintenanceByPE)
				gridEmployeeType=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Employee Type', pageName.GLAccountMaintenanceByPE)
				gridEffectiveFrom=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'Effective From', pageName.GLAccountMaintenanceByPE)

				if(tempDate.isEmpty())
					tempDate=gridEffectiveFrom

				/*if(DateTimeUtil.verifyDateInbetween(EffectiveFrom, tempDate, gridEffectiveFrom))
				 tempDate=gridEffectiveFrom*/


				/*if(DateTimeUtil.verifyDateEqualsAfterDate(EffectiveFrom, gridEffectiveFrom))
				 if(DateTimeUtil.verifyDateInbetween(EffectiveFrom, gridEffectiveFrom, tempDate))
				 tempDate=gridEffectiveFrom
				 */

				/*
				 if(DateTimeUtil.verifyDateInbetween(EffectiveFrom, tempDate, gridEffectiveFrom)) {
				 tempDate=gridEffectiveFrom
				 }
				 */

				if((gridRegion.equals(Region)) || (gridRegion.equals('ALL')))
					if((gridLocation.equals(Location)) || (gridLocation.equals('ALL')))
						if((gridCostCenter.startsWith(CostCenter)) || (gridCostCenter.equals('ALL')))
							if((gridSpecialty.equals(Specialty)) || (gridSpecialty.equals('ALL')))
								if((gridCompModel.equals(CompModel)) || (gridCompModel.equals('ALL')))
									if((gridPositionLevel.equals(PositionLevel)) || (gridPositionLevel.equals('ALL')))
										if((gridEmployeeType.equals(EmployeeType)) || (gridEmployeeType.equals('ALL')))
											//if(DateTimeUtil.verifyDateEqualsAfterDate(EffectiveFrom, tempDate))
											//if(DateTimeUtil.verifyDateEqualsAfterDate(EffectiveFrom, gridEffectiveFrom))
											//if(DateTimeUtil.verifyDateInbetween(EffectiveFrom, gridEffectiveFrom, tempDate))

											//	01/02/2022
											//01/01/2020
											//01/01/2019
											if(DateTimeUtil.verifyDateInbetween(tempDate, EffectiveFrom, gridEffectiveFrom))
				{
					tempDate=gridEffectiveFrom
					gridGLAccountNo=getBaseSteps().getCellTableText(grdGLAccDetailsByPE, i.toString(),'GL Account No.', pageName.GLAccountMaintenanceByPE)
				}





			}
		}
		return gridGLAccountNo
	}

	public static String getGLAccountNoWRTPayElementCostCenter(String PayElement,String Region,String Location,String HIICCID,String Specialty,String CompModel,String PositionLevel,String EmployeeType,String EffectiveFrom) {

		String GLAccNo=''

		openGLAccountMaintenanceByPE_newTab()
		selectPayElement(PayElement)
		selectRegion(Region)
		selectLocation(Location)
		selectSpecialty(Specialty)
		selectCompensationModel(CompModel)
		//selectPositionLevel(PositionLevel)
		//selectEmployeeType(EmployeeType)
		clickShowDetails()
		GLAccNo=getGridGLAccountNo(Region, Location, HIICCID, Specialty, CompModel, PositionLevel, EmployeeType, EffectiveFrom)
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()

		return GLAccNo
	}


}


