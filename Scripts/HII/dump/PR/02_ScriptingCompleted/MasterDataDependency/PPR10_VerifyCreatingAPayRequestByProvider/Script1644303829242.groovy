import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ManageUserInformationSteps as ManageUserInformationSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {
    
	LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

    if (ManageUserInformationSteps.getProviderPayRequest_Eligiblity(ProviderPayRequest.getValue('ProviderID', i))) {
       
		HeaderPageSteps.logOff()

        LoginPageSteps.ProviderLogin(ProviderPayRequest.getValue('ProviderID', i), ProviderPayRequest.getValue('ProviderPWD',i))

        ProviderPayRequestSteps.gotoProviderPayRequest_Provider()

        ProviderPayRequestSteps.selectRequestDate(ProviderPayRequest.getValue('RequestDate', i), FailureHandling.OPTIONAL)

		ProviderPayRequestSteps.selectCompensationModel(ProviderPayRequest.getValue('CompensationModel', i), FailureHandling.OPTIONAL)
		
        ProviderPayRequestSteps.selectPayElement(ProviderPayRequest.getValue('PayElement', i), FailureHandling.OPTIONAL)

        ProviderPayRequestSteps.setPayElementValue(ProviderPayRequest.getValue('PayElementValue', i), FailureHandling.OPTIONAL)

        boolean existsPayRequest = ProviderPayRequestSteps.verifyProviderPayRequestExists(ProviderPayRequest.getValue('RequestDate', 
                i), ProviderPayRequest.getValue('CompensationModel', i), ProviderPayRequest.getValue('PayElement', i))

        ProviderPayRequestSteps.saveProviderPayRequest()

        if (existsPayRequest) {
            ProviderPayRequestSteps.verifyPayRequestCreationErrorMessage(ProviderPayRequest.getValue('RequestDate',i), ProviderPayRequest.getValue('PayElement', i))
        } else {
            ProviderPayRequestSteps.verifyPayRequestCreationSuccessMessage(ProviderPayRequest.getValue('RequestDate',i), ProviderPayRequest.getValue('PayElement', i))
        }
    }
	
	HeaderPageSteps.logOff()
}