import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps

'Test Data'
String Provider='PayRequest003'
String RequestDate='12/03/2020'
String PayElement='Base Draw'
String Amount
String RequestorFile='PayApprovalsTestImport01.txt'

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
/*
 * ProviderPayRequestSteps.gotoProviderPayRequest()
 * ProviderPayRequestSteps.setProviderName(Provider)
 * ProviderPayRequestSteps.setRequestDate(RequestDate)
 * ProviderPayRequestSteps.selectPayElement(PayElement)
 * ProviderPayRequestSteps.setPayElementValue(Amount)
 * ProviderPayRequestSteps.setPayElementUploadFile(FileName)
 * ProviderPayRequestSteps.clickSave()
 */

ProviderPayApprovalsSteps.gotoProviderPayApprovals()
ProviderPayApprovalsSteps.setProvider(Provider)
ProviderPayApprovalsSteps.uploadRequestorFile(PayElement,RequestDate,RequestorFile)
//ProviderPayApprovalsSteps.verifyRequestorFiles(PayElement,RequestDate,FileName)