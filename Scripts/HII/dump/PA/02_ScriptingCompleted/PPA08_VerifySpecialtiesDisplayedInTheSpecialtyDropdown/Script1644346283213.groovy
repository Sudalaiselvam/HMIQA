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
    
	String Region=ProviderPayApprovals.getValue('Region', i)
	String CompensationModel=ProviderPayApprovals.getValue('CompensationModel', i)
	List<String> lstexpectedSpecialty=new ArrayList<String>()
	lstexpectedSpecialty=CompensationModelSpecialtyMappingPageSteps.getSpecialtyMappedWRTRegionCompensationModel(Region, CompensationModel)
	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()
	
	ProviderPayApprovalsSteps.selectRegion(Region)
	
	ProviderPayApprovalsSteps.selectCompensationModel(CompensationModel)
	
	ProviderPayApprovalsSteps.verifySpecialtyListDropdown(lstexpectedSpecialty)
	
}