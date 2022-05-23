import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.OrgCompModelsPayElementsSteps as OrgCompModelsPayElementsSteps
import pages.RoleUserWisePayElementsSteps as RoleUserWisePayElementsSteps
import pages.PayElementsSteps as PayElementsSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	String Region=ProviderPayApprovals.getValue('Region', i)
	String CompensationModel=ProviderPayApprovals.getValue('CompensationModel', i)
	String PayCycle=ProviderPayApprovals.getValue('PayCycle',i)
	String Location=ProviderPayApprovals.getValue('Location',i)
	String PayrollStatus=ProviderPayApprovals.getValue('PayrollStatus',i)
	String Year=ProviderPayApprovals.getValue('Year',i)
	String PayPeriod=ProviderPayApprovals.getValue('PayPeriod',i)
	
	Set<String> lstexpectedPayElements = new HashSet<String>()

    lstexpectedPayElements = ProviderPayApprovalsSteps.getExpectedPayElements(HIIConstants.ROLE_CompensationAdministrator,Region, CompensationModel)
	
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(Region)
	
	ProviderPayApprovalsSteps.selectPayCycle(PayCycle)
	
	ProviderPayApprovalsSteps.selectLocation(Location)
	
	ProviderPayApprovalsSteps.selectPayrollStatus(PayrollStatus)
	
	ProviderPayApprovalsSteps.selectYear(Year)
	
	ProviderPayApprovalsSteps.selectPayPeriod(PayPeriod)
	
    ProviderPayApprovalsSteps.selectCompensationModel(CompensationModel)

    ProviderPayApprovalsSteps.verifyPayElementList(lstexpectedPayElements)
}