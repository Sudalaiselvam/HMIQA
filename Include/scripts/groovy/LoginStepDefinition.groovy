import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

import pages.LoginPageSteps as LoginPageSteps
import internal.GlobalVariable
import configs.HIIConstants
import core.Browser


class LoginStepDefinition {
	/**
	 * The step definitions below match with Katalon sample Gherkin steps
	 */


	@Given('Launch HII Application')
	def Launch_HII_Application(){
		Browser.start(GlobalVariable.URL)
	}
	@And('Enter Login details')
	def Enter_Login_details() {
		LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
	}
}