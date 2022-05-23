package pages

import core.BaseSteps
import core.Browser
import core.ControlFactory
import configs.PageLocatorReader as pageName
import core.AssertSteps
import core.Logger
import com.kms.katalon.core.model.FailureHandling
import java.util.regex.*

/**
 * @author AnilKumarJanapareddy
 *
 */
public class CommonSteps {

	private static final String ddlPageSize='ddlPageSize'
	private static final String imgLoading='imgLoading'

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void backtoMainWindow() {
		getBaseSteps().backtoMainWindow();
	}

	public static void closeCurrentWindow() {
		getBaseSteps().closeWindow()
	}

	public static void verifyApplicationLinks() {
		getBaseSteps().verifyApplicationLinks()
	}

	public static void verifyApplicationLinksNavigation() {
		List<String> lstLinks=new ArrayList<>()
		lstLinks=getBaseSteps().getApplicationLinks()
		for(String Link:lstLinks) {
			Browser.navigateToURL(Link)
			boolean blnPageHeader=getBaseSteps().WebElementDisplayed('pageHeader', pageName.Header)
			String strPageHeader
			if(blnPageHeader) {
				strPageHeader=getBaseSteps().getTextFromControl('pageHeader', pageName.Header)
			
			String AssertMsg
				if(strPageHeader.matches(".*[45][0-9]{2}.*")) {
					AssertMsg='Navigation to Link -'+Link+' with Response :'+strPageHeader
					AssertSteps.verifyActualResult(false, AssertMsg+'- PASS',AssertMsg+ ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
				}else {
					AssertMsg='Navigation to Link -'+Link+' with Page Header :'+strPageHeader
					AssertSteps.verifyActualResult(true, AssertMsg+'- PASS',AssertMsg+ ' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
				}
			}		
			
			
		}
	}


	public static void refreshWindow() {
		getBaseSteps().refreshWindow()
	}

	public static void clickImgOrganization() {
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
	}

	//============================ ASSERT METHODS ==========================
	public static void verifyProviderHintsDisplayed() {
		getBaseSteps().verifyControlDisplayed('lstProviderhints', pageName.CMN)
	}

	public static boolean isPageHeaderDisplayed() {
		return getBaseSteps().WebElementDisplayed('pageHeader', pageName.Header)
	}

	public static String getPageHeader() {
		return getBaseSteps().getTextFromControl('pageHeader', pageName.Header)
	}

	public static void verifyPageHeader(String ExpectedPageHeader) {
		boolean blnValidation=isPageHeaderDisplayed()
		AssertSteps.verifyActualResult(blnValidation, 'Page Header Displayed', 'Page Header not Displayed', FailureHandling.CONTINUE_ON_FAILURE)
		if(blnValidation) {
			'Verifying Page Header'
			String ActualPageHeader=getPageHeader()
			boolean blnCondition=ActualPageHeader.equalsIgnoreCase(ExpectedPageHeader)
			String AssertMsg='Page Header Validation - Expected : '+ExpectedPageHeader+' and Actual : '+ActualPageHeader
			AssertSteps.verifyActualResult(blnCondition, AssertMsg+' - PASS', AssertMsg+' - FAIL', FailureHandling.CONTINUE_ON_FAILURE)
		}
	}

	public static void selectMaxPagesize() {
		getBaseSteps().selectLastOptionDropDownControl('ddlPageSize', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}
}
