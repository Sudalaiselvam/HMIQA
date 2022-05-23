import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Set Provider Search'
ProviderSetupSteps.setProviderSearch(ProviderSearch)

'Step 05 : Click Export Excel and Verify Excel Exported'
ProviderSetupSteps.clickExportExcelAndVerifyExcelExported()

'Step 06 : Verify Exported Excel'
ProviderSetupSteps.verifyExportedExcel()
