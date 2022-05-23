import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.PayElementsSteps as PayElementsSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

PayElementsSteps.openPayElements_newTab()

PayElementsSteps.selectPayElementType('Variable')

PayElementsSteps.selectLastPageSize()

List<String> lstNotePayElements=new ArrayList<String>()
lstNotePayElements = PayElementsSteps.getAttachmentRequiredPayElements()

for(String payElement:lstNotePayElements)
	println payElement

