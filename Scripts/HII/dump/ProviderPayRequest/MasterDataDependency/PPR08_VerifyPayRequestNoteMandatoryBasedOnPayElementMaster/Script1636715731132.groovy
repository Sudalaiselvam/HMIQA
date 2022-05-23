import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

List<String> lstRequestNotePayElements = new ArrayList<String>()

lstRequestNotePayElements = ProviderPayRequestSteps.getExpectedPayRequestNotePayElements()

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName)

ProviderPayRequestSteps.selectRequestDate(RequestDate)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel)

ProviderPayRequestSteps.selectPayElement(PayElement)

ProviderPayRequestSteps.setPayRequestNote(PayRequestNote)

ProviderPayRequestSteps.clickSave()

ProviderPayRequestSteps.verifyValidationSummaryPayRequestNote(lstRequestNotePayElements)