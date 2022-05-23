import core.Browser
import pages.YOPMailPageSteps
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

String LoginName='compadminhii'
Browser.start('https://yopmail.com/')
YOPMailPageSteps.setLogin(LoginName)
WebUI.delay(30)
WebUI.switchToFrame(null, 0)
YOPMailPageSteps.openLatestMail()
YOPMailPageSteps.RequestMailDetails()

