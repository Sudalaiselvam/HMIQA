package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class PayCycleSetupPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//############## WebElement available from Pay Cycle Setup ############################
	private static final String txtUniversalSearch='txtUniversalSearch'
	private static final String btnUniversalSearch='btnUniversalSearch'
	private static final String grdPayCycleDetails='grdPayCycleDetails'
	private static final String pnlPayCycleMaintenance='pnlPayCycleMaintenance'
	private static final String pnlgrdPayCycleDetails='pnlgrdPayCycleDetails'

	//##############     Pay Cycle Setup Page WebElement Operations        #########################################

	public static void openPayCycleSetupPage_newTab() {
		getBaseSteps().openCascadingMenu_newTab('mnuAdmin', 'mnuPayCycles', 'mnuPayCycleSetup', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setUniversalSearch(String UniversalSearch) {
		getBaseSteps().setTextToControl(txtUniversalSearch, UniversalSearch, pageName.PayCycleSetup)
	}

	public static void clickUniversalSearch() {
		getBaseSteps().clickToControl(btnUniversalSearch, pageName.PayCycleSetup)
		getBaseSteps().waitforLoadingComplete('imgLoading', 30,pageName.CMN)
	}
	
	
	public static List<String> getPayPeriodWRTPayCycle(String PayCycle,String Year) {
		openPayCycleSetupPage_newTab()
		setUniversalSearch(PayCycle)
		clickUniversalSearch()
		getBaseSteps().clickToimgCellDependentTable(grdPayCycleDetails, 'Pay Cycle', 'Year', Year, pageName.PayCycleSetup)
		
		getBaseSteps().waitForControlDisplay(pnlPayCycleMaintenance, pageName.PayCycleSetup)
		
		List<String> startDate=new ArrayList<String>()
		List<String> endDate=new ArrayList<String>()
		List<String> payPeriod=new ArrayList<String>()
		startDate=getBaseSteps().getColumnTableText(pnlgrdPayCycleDetails, 'Start Date', pageName.PayCycleSetup)
		endDate=getBaseSteps().getColumnTableText(pnlgrdPayCycleDetails, 'End Date', pageName.PayCycleSetup)
		
		for(int i=0;i<startDate.size();i++) {
			payPeriod.add(startDate.get(i)+' - '+endDate.get(i))
		}
		
		getBaseSteps().closeWindow()
		
		getBaseSteps().switchtoMainWindow()
		
		return payPeriod
	}

}
