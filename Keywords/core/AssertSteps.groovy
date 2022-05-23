package core

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import java.text.SimpleDateFormat


public class AssertSteps {
	@Keyword
	static void verifyExpectedResult(boolean actualResult, String failedMessage="", FailureHandling failureHandling = FailureHandling.CONTINUE_ON_FAILURE){

		String passedString="Expected result: PASSED"
		String failedString="Expected result: FAILED"

		if(actualResult){
			Logger.setPassHandling(passedString)
		}else{
			Browser.takeScreenshot();
			WebUiBuiltInKeywords.takeFullPageScreenshot();
			Logger.setFailureHandling(String.format("%s. %s", failedString,failedMessage), failureHandling);
		}
	}

	public static void verifyActualResult(boolean actualResult,String successMessage="",String failureMessage="",FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE) {
		if(actualResult) {
			Logger.setPassHandling(String.format("Result: PASSED. %s on Page :  %s",successMessage,Browser.getCurrentURL()))
		}else {
			Browser.takeScreenshot();
			WebUiBuiltInKeywords.takeFullPageScreenshot();
			Logger.setFailureHandling(String.format("Result: Failed. %s on Page :  %s", failureMessage,Browser.getCurrentURL()), failureHandling);
		}
	}

	public static void verifyProviderHints(boolean actualResult,String successMessage="",String failureMessage="",FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		if(actualResult) {
			Logger.setPassHandling(successMessage)
		}else {
			switch(failureHandling) {
				case FailureHandling.CONTINUE_ON_FAILURE: Logger.setFailureHandling(failureMessage, failureHandling)
					break;
				case FailureHandling.STOP_ON_FAILURE:Logger.setFailureHandling(failureMessage,failureHandling)
					break;
				default:break;
			}
		}
	}

	public static boolean verifyDateInbetween(String StartDate,String EndDate,String CompareDate) {
		SimpleDateFormat sdf=new SimpleDateFormat('MM/dd/yyyy')
		Date dtStart=sdf.parse(StartDate);
		Date dtEnd=sdf.parse(EndDate);
		Date dtCompare=sdf.parse(CompareDate);
		if((dtCompare.after(dtStart) && dtCompare.before(dtEnd)) || (dtCompare.equals(dtStart)) || (dtCompare.equals(dtEnd))) {
			return true
		}else {
			return false
		}
	}
}
