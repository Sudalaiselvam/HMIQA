import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : verify Provider Pay Request Eligibility for Provider'
if (ManageUserInformationSteps.getProviderPayRequest_Eligiblity(ProviderID)) {
    
	'Step 03 : Log off Compensation Administrator'   
	HeaderPageSteps.logOff()

    'Step 04 : Login with Provider details'    
	LoginPageSteps.ProviderLogin(ProviderID, ProviderPWD)

    'Step 05 : Go to Provider Pay Request'
	ProviderPayRequestSteps.gotoProviderPayRequest_Provider()

    'Step 06 : Select Request Date'
	ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

	'Step 07 : Select Compensation Model'
	ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)
		
    'Step 08 : Select Pay Element'
	ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

    'Step 09 : Select Pay Element Value'
	ProviderPayRequestSteps.setPayElementValue(PayElementValue, FailureHandling.OPTIONAL)

    'Step 10 : verify Pay request exists'
	boolean existsPayRequest = ProviderPayRequestSteps.verifyProviderPayRequestExists(RequestDate,CompensationModel,PayElement)

    'Step 11 : Save Pay Request'
	ProviderPayRequestSteps.saveProviderPayRequest()

	'Step 12 : Verify Pay Request Creation'
    	if (existsPayRequest) {
			ProviderPayRequestSteps.verifyPayRequestCreationErrorMessage(RequestDate,PayElement)
    	} else {
        ProviderPayRequestSteps.verifyPayRequestCreationSuccessMessage(RequestDate,PayElement)
		}
    }
	
	
	