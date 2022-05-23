package core

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil


public class Logger {

	//	private static final KeywordLogger logger = KeywordLogger.getInstance(Thread.currentThread().getStackTrace()[1].getMethodName());

	public static void logINFO(String message){
		KeywordUtil.logger.logInfo(message);
	}

	public static void logDEBUG(String message){
		KeywordUtil.logger.logDebug(message);
	}

	public static void logERROR(String message){
		KeywordUtil.logger.logError(message);

	}

	public static void logWARNING(String message){
		KeywordUtil.logger.logWarning(message);
	}

	public static void setFailureHandling(String message, FailureHandling failureHandling = FailureHandling.STOP_ON_FAILURE) {

		switch (failureHandling) {
			case FailureHandling.OPTIONAL:
				logINFO(message);
				break;
			case FailureHandling.CONTINUE_ON_FAILURE:
				KeywordUtil.markFailed(message);
				break;
			case FailureHandling.STOP_ON_FAILURE:
				KeywordUtil.markFailedAndStop(message);
				break;
			default:
				break;
		}
	}

	public static void setPassHandling(String message){
		KeywordUtil.markPassed(message);
	}
}