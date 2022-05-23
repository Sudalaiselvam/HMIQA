import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import java.text.SimpleDateFormat as SimpleDateFormat
import java.time.temporal.ChronoUnit as ChronoUnit
import java.time.LocalDate as LocalDate

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

/*
 * ProviderPayRequestSteps.gotoProviderPayRequest()
 * 
 * ProviderPayRequestSteps.setProviderName('PayRequest001')
 * 
 * ProviderPayRequestSteps.selectMultipleRequestDate(RequestDates)
 */

ProviderPayRequestSteps.verifymultipleRequestDate(Provider, RequestDates)