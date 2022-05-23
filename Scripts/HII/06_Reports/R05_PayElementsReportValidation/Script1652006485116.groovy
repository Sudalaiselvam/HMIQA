import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.HeaderPageSteps
import pages.ReportsPageSteps
import utils.ExcelUtilities


'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Validate Pay Elements Report'
ReportsPageSteps.validatePayElementsReport()