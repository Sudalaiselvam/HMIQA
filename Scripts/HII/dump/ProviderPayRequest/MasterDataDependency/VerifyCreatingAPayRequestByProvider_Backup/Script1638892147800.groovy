import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.HeaderPageSteps
import pages.ManageUserInformationSteps

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

if(ManageUserInformationSteps.getProviderPayRequest_Eligiblity(ProviderID))
	println 'Creation of Pay Request eligible'


  HeaderPageSteps.logOff() 
  LoginPageSteps.ProviderLogin(ProviderID,ProviderPWD)
  
 