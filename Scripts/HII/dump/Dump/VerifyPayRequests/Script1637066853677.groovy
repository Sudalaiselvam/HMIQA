import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
String expectedSuccessMSG

String expectedErrorMSG

expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate) + ' for the Pay Element ') + PayElement)

expectedErrorMSG = (((('Pay Request already exists on service date ' + RequestDate) + ' for pay element ') + PayElement) +
' , this request will not be raised')


ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

//ProviderPayRequestSteps.PayRequestGridFunctionalities()


  ProviderPayRequestSteps.editProviderPayRequest(RequestDate)
  
  ProviderPayRequestSteps.setPayElementValue(PayElementValue)
  
  ProviderPayRequestSteps.clickSave()
  
  
 
  ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG, expectedErrorMSG)
//ProviderPayRequestSteps.deleteProviderPayRequest(RequestDate)

