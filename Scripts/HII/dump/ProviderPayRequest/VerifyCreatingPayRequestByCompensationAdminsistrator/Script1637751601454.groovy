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

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    
    
	ProviderPayRequestSteps.gotoProviderPayRequest()

    ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName', i), FailureHandling.OPTIONAL)

    if (ProviderPayRequestSteps.verifyProviderPayRequestExists(ProviderPayRequest.getValue('RequestDate', i), ProviderPayRequest.getValue(
            'CompensationModel', i), ProviderPayRequest.getValue('PayElement', i))) {
        expectedErrorMSG = (((('Pay Request already exists on service date ' + ProviderPayRequest.getValue('RequestDate', 
            i)) + ' for pay element ') + ProviderPayRequest.getValue('PayElement', i)) + ' , this request will not be raised')
    } else {
        expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + ProviderPayRequest.getValue('RequestDate', 
            i)) + ' for the Pay Element ') + ProviderPayRequest.getValue('PayElement', i))
    }
	  
	ProviderPayRequestSteps.selectServiceStartDate(ProviderPayRequest.getValue('ServiceStartDate', i),FailureHandling.OPTIONAL)
	  
	  
	  ProviderPayRequestSteps.selectRequestDate(ProviderPayRequest.getValue('RequestDate', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.selectCompensationModel(ProviderPayRequest.getValue('CompensationModel', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.selectPayElement(ProviderPayRequest.getValue('PayElement', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.setPayElementValue(ProviderPayRequest.getValue('PayElementValue', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.selectPayElementReason(ProviderPayRequest.getValue('Reason', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.setPayElementGLAccount(ProviderPayRequest.getValue('GLAccount', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.setPayElementLocationCostCenter(ProviderPayRequest.getValue('Location_CostCenter', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.selectPayElementPayDate(ProviderPayRequest.getValue('PayDate', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.selectPayElementCheckGroup(ProviderPayRequest.getValue('Checkgroup', i), FailureHandling.OPTIONAL)
	  
	  ProviderPayRequestSteps.saveProviderPayRequest()
	  
	  ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG,expectedErrorMSG)
	 
    
}