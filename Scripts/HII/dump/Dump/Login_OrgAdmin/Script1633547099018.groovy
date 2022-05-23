import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps

'Step 1: Launch Heisenberg II'
Browser.start(GlobalVariable.URL)

'Step 2: Organization Admin Login'
LoginPageSteps.loginWithOrgAdminUser()