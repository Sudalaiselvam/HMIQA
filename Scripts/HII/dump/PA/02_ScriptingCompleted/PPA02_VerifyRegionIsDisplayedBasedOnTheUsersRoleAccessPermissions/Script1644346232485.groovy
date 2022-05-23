import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.HeaderPageSteps

Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ManageUserInformation.getRowNumbers(); i++) {
    
	String UserName=ManageUserInformation.getValue('UserName',i)
	String UserEncryptedPassword=ManageUserInformation.getValue('EncryptedPassword',i)
	String UserRole=ManageUserInformation.getValue('Role',i)
	
	LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

    Set<String> expectedRegions = new HashSet<String>()
    
    expectedRegions = ManageUserInformationSteps.getRegionsList(UserName,UserRole)
	
	HeaderPageSteps.logOff()
	
	LoginPageSteps.Login(UserName, UserEncryptedPassword,UserRole)
	
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.verifyRegionList(expectedRegions)
	 
	HeaderPageSteps.logOff()
	
}