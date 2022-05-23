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

'Step 03 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 04 : set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

'Step 05: Get expected Message'
if (ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate,CompensationModel,PayElement)) {
    expectedErrorMSG = ('Pay Request already exists on service date ' +RequestDate+ ' for pay element '+ PayElement + ' , this request will not be raised')
} else {
    expectedSuccessMSG = ('Pay Request inserted/updated successfully on ' + RequestDate+ ' for the Pay Element '+PayElement)
}
	  
'Step 06 : Select Service Start Date'
ProviderPayRequestSteps.selectServiceStartDate(ServiceStartDate,FailureHandling.OPTIONAL)
	
'Step 07 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)
	  
'Step 08 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)
	
'Step 09 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)
	  
'Step 10 : Select Pay Element Value'
ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.OPTIONAL)
	  
'Step 11 : Select Pay Element Reason'
ProviderPayRequestSteps.selectPayElementReason(Reason, FailureHandling.OPTIONAL)
	  
'Step 12 : Select Pay Element GL Acccount'
ProviderPayRequestSteps.setPayElementGLAccount(GLAccount, FailureHandling.OPTIONAL)
	  
'Step 13 : Select Pay Element Location Cost Center'
ProviderPayRequestSteps.setPayElementLocationCostCenter(Location_CostCenter, FailureHandling.OPTIONAL)
	  
'Step 14 : Select Pay Element Pay Date'
ProviderPayRequestSteps.selectPayElementPayDate(PayDate, FailureHandling.OPTIONAL)
	  
'Step 15 : Select Pay Element Check Group'
ProviderPayRequestSteps.selectPayElementCheckGroup(Checkgroup, FailureHandling.OPTIONAL)
	  
'Step 16 : Save Provider Pay Request'
ProviderPayRequestSteps.saveProviderPayRequest()
	  
'Step 17 : Verify Provider Pay Request Creation'
ProviderPayRequestSteps.verifyProviderPayRequestCreation(expectedSuccessMSG,expectedErrorMSG)
	 
