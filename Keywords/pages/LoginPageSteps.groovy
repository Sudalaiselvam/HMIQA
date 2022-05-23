package pages

import core.BaseSteps
import core.ControlFactory
import internal.GlobalVariable
import configs.PageLocatorReader as pageName
import configs.HIIConstants
import core.AssertSteps
import com.kms.katalon.core.model.FailureHandling

public class LoginPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	//################################ LOGIN PAGE METHODS #########################################

	public static void setUsername(String Username) {
		getBaseSteps().setTextToControl("txtUsername",Username, pageName.Login)
	}

	public static void setPassword(String Password) {
		getBaseSteps().setEncodeTextToControl("txtPassword", Password, pageName.Login)
	}

	public static void clickLogin() {
		getBaseSteps().clickToControl("btnLogin",pageName.Login)
	}


	public static void Login(String USERNAME,String PASSWORD,String ROLE) {
		setUsername(USERNAME)
		setPassword(PASSWORD)
		clickLogin()

		//getBaseSteps().waitForControlDisplay("imgOrganization",pageName.CMN)


		switch(ROLE){
			case HIIConstants.ROLE_CompensationAdministrator:
				if(getBaseSteps().verifyCurrentURLEndsWith(HIIConstants.URL_ChooseRole))
					selectCompensationAdministrator()
				verifyCompensationAdministratorSuccessfulLogin()
				break
			case HIIConstants.ROLE_OrganizationAdmin:
				if(getBaseSteps().verifyCurrentURLEndsWith(HIIConstants.URL_ChooseRole))
					selectOrganizationAdmin()
				verifyOrganizationAdminSuccessfulLogin()
				break
			case HIIConstants.ROLE_CompApprover:
				if(getBaseSteps().verifyCurrentURLEndsWith(HIIConstants.URL_ChooseRole))
					selectCompApprover()
				verifyCompApproverSuccessfulLogin()
				break
			case 'Director':
				if(getBaseSteps().verifyCurrentURLEndsWith(HIIConstants.URL_ChooseRole))
					selectDirector()
				break

		}
	}


	public static void Login(String UserRole) {
		String UserName,UserPWD
		switch(UserRole) {
			case HIIConstants.ROLE_CompensationAdministrator:
				UserName=GlobalVariable.COMPADMIN_USER
				UserPWD=GlobalVariable.COMPADMIN_PWD
				Login(UserName,UserPWD,UserRole)
				break
			case HIIConstants.ROLE_OrganizationAdmin:
				UserName=GlobalVariable.COMPADMIN_USER
				UserPWD=GlobalVariable.COMPADMIN_PWD
				Login(UserName,UserPWD,UserRole)
				break
			case HIIConstants.ROLE_CompApprover:
				UserName=GlobalVariable.COMPAPPROVER_USER
				UserPWD=GlobalVariable.COMPAPPROVER_PWD
				Login(UserName,UserPWD,UserRole)
				break


		}

	}

	public static void ProviderLogin(String ProviderID,String Password) {
		setUsername(ProviderID)
		setPassword(Password)
		//getBaseSteps().setTextToControl("txtPassword", Password, pageName.Login)
		clickLogin()
		verifyProviderSuccessfulLogin()
	}


	public static void selectRole(String Role) {

	}

	public static void selectCompensationAdministrator() {
		getBaseSteps().clickToControl('rdoCompensationAdministrator', pageName.ChooseRole)
	}

	public static void selectOrganizationAdmin() {
		getBaseSteps().clickToControl('rdoOrganizationAdmin', pageName.ChooseRole)
	}

	public static void selectDirector() {
		getBaseSteps().clickToControl('rdoDirector', pageName.ChooseRole)
	}

	public static void selectCompApprover() {
		getBaseSteps().clickToControl('rdoCompApprover', pageName.ChooseRole)
	}

	public static void verifyPageIsLoaded() {
		getBaseSteps().verifyControlDisplayed("frmLogIn", "LoginPage");
	}

	// =================== ASSERT METHODS ZONE ======================

	public static void verifyCompensationAdministratorSuccessfulLogin() {
		getBaseSteps().verifyDropDownSelected('ddlRole', HIIConstants.ROLE_CompensationAdministrator, pageName.Header, 'Compensation Administartor logged In successfully', 'Compensation Administrator failed to Logged In', FailureHandling.STOP_ON_FAILURE)

	}

	public static void verifyCompApproverSuccessfulLogin() {
		getBaseSteps().verifyDropDownSelected('ddlRole', HIIConstants.ROLE_CompApprover, pageName.Header, 'Comp Approver logged In successfully', 'Comp Approver failed to Logged In', FailureHandling.STOP_ON_FAILURE)

	}

	public static void verifyProviderSuccessfulLogin() {

		if(getBaseSteps().WebElementDisplayed('lblRole', pageName.Header))
		{
			String Role=getBaseSteps().getTextFromControl('lblRole', pageName.Header)
			AssertSteps.verifyActualResult(Role.equals('Provider'), 'Provider logged In Successfully', 'Provider login failed', FailureHandling.STOP_ON_FAILURE)

		}
	}

	public static void verifyOrganizationAdminSuccessfulLogin() {
		getBaseSteps().verifyDropDownSelected('ddlRole', HIIConstants.ROLE_OrganizationAdmin, pageName.Header)
	}

	public static void verifyLogInForm() {
		getBaseSteps().verifyControlDisplayed('frmLogIn',pageName.Login)
	}

}
