package utils

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.model.FailureHandling
import core.AssertSteps
public class AlertUtiltities {


	public static boolean isAlertDisplayed(int timeOut=10) {

		return WebUI.verifyAlertPresent(timeOut)
	}

	public static void acceptAlert() {
		WebUI.acceptAlert()
	}

	public static void declineAlert() {
		WebUI.dismissAlert()
	}

	public static void verifyAlertMessage(String ExpectedText) {
		String actualAlertText=WebUI.alertText
		String AssertMsg='Alert Message Validation, Expected : '+ExpectedText+' and Actual : '+actualAlertText
		AssertSteps.verifyActualResult(ExpectedText.equals(actualAlertText), AssertMsg+' - PASS', AssertMsg+' - FAIL')
	}
}
