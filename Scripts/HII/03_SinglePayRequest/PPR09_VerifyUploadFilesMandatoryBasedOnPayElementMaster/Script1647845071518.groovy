import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Get List of Pay Elements where attachment is mandatory'
List<String> lstAttchReqPayElements=new ArrayList<String>()
lstAttchReqPayElements = PayElementsSteps.getAttachmentRequiredPayElements()

'Step 03 : Go to Provider Pay Request'
ProviderPayRequestSteps.gotoProviderPayRequest()

'Step 04 : Set Provider Name'
ProviderPayRequestSteps.setProviderName(ProviderName)

'Step 05 : Select Request Date'
ProviderPayRequestSteps.selectRequestDate(RequestDate)

'Step 06 : Select Compensation Model'
ProviderPayRequestSteps.selectCompensationModel(CompensationModel)

'Step 07 : Select Pay Element'
ProviderPayRequestSteps.selectPayElement(PayElement)

'Step 08 : enter Pay request Notes'
ProviderPayRequestSteps.setPayRequestNote(PayRequestNote)

'Step 09 : Click Save'
ProviderPayRequestSteps.clickSave()

'Step 10 : Verify Validation SUmmary for Payelement when attachment is mandatory is missing'
ProviderPayRequestSteps.verifyValidationSummaryAttachmentRequired(lstAttchReqPayElements)
