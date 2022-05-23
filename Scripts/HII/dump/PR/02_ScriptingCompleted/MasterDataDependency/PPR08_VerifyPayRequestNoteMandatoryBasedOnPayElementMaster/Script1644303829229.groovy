import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayRequest.getRowNumbers(); i++) {

List<String> lstRequestNotePayElements = new ArrayList<String>()

lstRequestNotePayElements = ProviderPayRequestSteps.getExpectedPayRequestNotePayElements()

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderPayRequest.getValue('ProviderName',i))

ProviderPayRequestSteps.selectRequestDate(ProviderPayRequest.getValue('RequestDate',i))

ProviderPayRequestSteps.selectCompensationModel(ProviderPayRequest.getValue('CompensationModel',i))

ProviderPayRequestSteps.selectPayElement(ProviderPayRequest.getValue('PayElement',i))

ProviderPayRequestSteps.setPayRequestNote(ProviderPayRequest.getValue('PayRequestNote',i))

ProviderPayRequestSteps.clickSave()

ProviderPayRequestSteps.verifyValidationSummaryPayRequestNote(lstRequestNotePayElements)

}

