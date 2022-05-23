import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps

'Step 1: Launch Heisenberg II'
Browser.start(GlobalVariable.URL)

'Step 2: Compensation Administrator Login'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD)
