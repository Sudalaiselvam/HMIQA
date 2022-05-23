import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.SpecialtyPageSteps
import pages.CompensationModelSpecialtyMappingPageSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	List<String> lstexpectedSpecialty=new ArrayList<String>()
	lstexpectedSpecialty=CompensationModelSpecialtyMappingPageSteps.getSpecialtyMappedWRTRegionCompensationModel(ProviderPayApprovals.getValue('Region', i), ProviderPayApprovals.getValue('CompensationModel', i))
	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()
	
	ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region', i))
	
	ProviderPayApprovalsSteps.selectPayCycle(ProviderPayApprovals.getValue('PayCycle',i))
	
	ProviderPayApprovalsSteps.selectLocation(ProviderPayApprovals.getValue('Location',i))
	
	ProviderPayApprovalsSteps.selectPayrollStatus(ProviderPayApprovals.getValue('PayrollStatus',i))
	
	ProviderPayApprovalsSteps.selectYear(ProviderPayApprovals.getValue('Year',i))
	
	
	ProviderPayApprovalsSteps.selectCompensationModel(ProviderPayApprovals.getValue('CompensationModel', i))
	
	/*
	 * List<String> lstSpecialties=new ArrayList<String>()
	 * 
	 * lstSpecialties=ProviderPayApprovalsSteps.getSpecialtyList()
	 */
	ProviderPayApprovalsSteps.verifySpecialtyListDropdown(lstexpectedSpecialty)
	
	
	
}