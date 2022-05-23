import pages.ManageProviderContractSteps
import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import testDataTypes.ContractData


  Browser.start(GlobalVariable.URL)
  
  LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER,
  GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
  
  ContractData contractData
  
  contractData=ManageProviderContractSteps.getContractDetails('THPZ078')
  
  contractData.ProviderStatus
 

