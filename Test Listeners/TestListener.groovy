
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import pages.HeaderPageSteps as HeaderPageSteps
import core.Browser
import internal.GlobalVariable

class TestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	@BeforeTestCase
	def initEnvironment(TestCaseContext testCaseContext) {
		GlobalVariable.TC_NAME = testCaseContext.getTestCaseId()
	}
	/**
	 * Executes after every test case ends.
	 * @param testCaseContext related information of the executed test case.
	 */
	@AfterTestCase
	def cleanUpEnvironment(TestCaseContext testCaseContext) {
		HeaderPageSteps.logOff()
		Browser.quitDriver()
	}
}
