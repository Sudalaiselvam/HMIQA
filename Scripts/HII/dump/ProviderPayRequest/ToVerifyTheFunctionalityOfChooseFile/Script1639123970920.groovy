import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
ProviderPayRequestSteps.gotoProviderPayRequest()

  ProviderPayRequestSteps.setProviderName(Provider)
  ProviderPayRequestSteps.setRequestDate(RequestDate)
  ProviderPayRequestSteps.selectPayElement(PayElement)
  ProviderPayRequestSteps.setPayElementUploadFile(FileName,FailureHandling.STOP_ON_FAILURE)
 
	