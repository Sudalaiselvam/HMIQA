import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling
//Verify the functionality of "Save button" when all the mandatory fields are entered
//Verify the functionality of "Save button" when all the mandatory fields are not entered
//Check whether the mandatory marks will display for the field "Upload Files *" based on pay element master for the respective pay element
//Check whether the mandatory marks will display for the field "Pay Request Note *" based on pay element master for the respective pay element
//Verify Creating a Pay Request by Provider.





'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(Provider, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectServiceStartDate(ServiceStartDate, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectRequestDate(RequestDate,FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel,FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElement(PayElement,FailureHandling.OPTIONAL)

ProviderPayRequestSteps.setPayElementValue(PayElementValue,FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElementReason(Reason)

//

String path='C:/Users/AnilKumarJanapareddy/git/QAAutomation/ImportFiles/ProviderPayRequestTest001.txt'
ProviderPayRequestSteps.setPayElementUploadFile(path, FailureHandling.OPTIONAL)



/*
 * ProviderPayRequestSteps.clickSave()
 * 
 * ProviderPayRequestSteps.verifyValidationSummary()
 */
	

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ProviderPayRequestSteps.selectReason(Reason)
 * 
 * ProviderPayRequestSteps.setGLAccount(GLAccount)
 * 
 * ProviderPayRequestSteps.setLocationCostCenter(Location_CostCenter)
 * 
 * ProviderPayRequestSteps.selectPayDate(PayDate)
 * 
 * ProviderPayRequestSteps.selectCheckgroup(Checkgroup)
 * 
 * ProviderPayRequestSteps.setPayRequestNote(PayRequestNote)
 * 
 * ProviderPayRequestSteps.selectUploadFiles(UploadFiles)
 * 
 * 
 */








