import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.HeaderPageSteps

Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ManageUserInformation.getRowNumbers(); i++) {
    
	LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

    Set<String> expectedRegions = new HashSet<String>()
    
    expectedRegions = ManageUserInformationSteps.getRegionsList(ManageUserInformation.getValue('UserName',i),ManageUserInformation.getValue('Role',i))
	
	HeaderPageSteps.logOff()
	
	LoginPageSteps.Login(ManageUserInformation.getValue('UserName',i), ManageUserInformation.getValue('EncryptedPassword',i),ManageUserInformation.getValue('Role',i))
	
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.verifyRegionList(expectedRegions)
	 
	HeaderPageSteps.logOff()
	
}