import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderSetupSteps
import pages.OrganizationPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Provider Setup Home Page'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Verify Provider Search Textbox'
ProviderSetupSteps.verifyProviderSearchTextBoxUI()

'Step 05 : Verify Universal Search Textbox'
ProviderSetupSteps.verifyUniversalSearchTextBoxUI()

'Step 06 : Verify Search Button'
ProviderSetupSteps.verifySearchButtonUI()

'Step 07 : Verify Search Clear Button'
ProviderSetupSteps.verifySearchClearButtonUI()

'Step 08 : Verify Export Excel Image'
ProviderSetupSteps.verifyExportExcelImageUI()

'Step 09 : Verify Create Provider Button'
ProviderSetupSteps.verifyCreateProviderButtonUI()

'Step 10 : Verify Physician Details Grid'
ProviderSetupSteps.verifyPhysicianDetailsGridUI()

'Step 11 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 12 : Verify Organization Label'
String expectedOrgName=OrganizationPageSteps.getOrganizationName()
ProviderSetupSteps.verifyOrganizationLabelUI(expectedOrgName)

'Step 13 : Verify Back to Providers Button'
ProviderSetupSteps.verifyBacktoProvidersButtonUI()

'Step 14 : Verify Personal Details UI'
ProviderSetupSteps.verifyPersonalDetailsUI()

'Step 15 : Verify Professional Details UI'
ProviderSetupSteps.verifyProfessionalDetailsUI()

'Step 16 : Verify Status Details UI'
ProviderSetupSteps.verifyStatusDetailsUI()

'Step 17 : Verify Save Button'
ProviderSetupSteps.verifySaveButtonUI()

'Step 18 : Verify Save Button'
ProviderSetupSteps.verifyClearButtonUI()
