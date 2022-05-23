package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class ProcessBonusPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void gotoProcessBonus() {
		getBaseSteps().gotoSubMenu('mnuPayment', 'mnuProcessBonus', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static final String fldFixedPaymentsProcess='fldFixedPaymentsProcess'
	private static final String ddlFPPRegion='ddlFPPRegion'
	private static final String ddlFPPPayCycle='ddlFPPPayCycle'
	private static final String ddlFPPYear='ddlFPPYear'
	private static final String ddlFPPPayPeriod='ddlFPPPayPeriod'

	public static boolean isFixedPaymentProcessSectionDisplayed() {
		return getBaseSteps().WebElementDisplayed(fldFixedPaymentsProcess, pageName.ProcessBonus)
	}

	public static void selectFixedPaymentProcessRegion(String Region) {
		getBaseSteps().selectByVisibleText(ddlFPPRegion, Region, pageName.ProcessBonus)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFixedPaymentProcessPayCycle(String PayCycle) {
		getBaseSteps().selectByVisibleText(ddlFPPPayCycle, PayCycle, pageName.ProcessBonus)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void selectFixedPaymentProcessYear(String Year) {
		getBaseSteps().selectByVisibleText(ddlFPPYear, Year, pageName.ProcessBonus)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getFixedPaymentProcessPayPeriodOptions(){
		return getBaseSteps().getlistControlDropdowm(ddlFPPPayPeriod, pageName.ProcessBonus)
	}

	public static String getFixedPaymentProcessPayPeriodOption(){
		return getBaseSteps().getselectedControlDropdowm(ddlFPPPayPeriod, pageName.ProcessBonus)
	}
}
