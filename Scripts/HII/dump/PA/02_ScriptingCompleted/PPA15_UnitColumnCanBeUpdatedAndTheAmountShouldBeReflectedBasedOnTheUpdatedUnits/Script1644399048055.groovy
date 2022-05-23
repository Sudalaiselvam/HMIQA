import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps


'Step 1: Browse H2 URL, Provide Valid Credentials and Click on Login button'
Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	'Test Data'
	String Provider = ProviderPayApprovals.getValue('Provider', i)
	String ServiceDate = ProviderPayApprovals.getValue('ServiceDate', i)
	String PayElement = ProviderPayApprovals.getValue('PayElement', i)
	String PayrollStatus = ProviderPayApprovals.getValue('PayrollStatus', i)
	String Units = ProviderPayApprovals.getValue('Units', i)
	
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.setProvider(Provider)

    ProviderPayApprovalsSteps.selectPayrollStatus(PayrollStatus)

    ProviderPayApprovalsSteps.clickGetDetails()

    ProviderPayApprovalsSteps.verifyGridAmountWRTUnitsUpdate(ServiceDate, PayElement, Units)
}