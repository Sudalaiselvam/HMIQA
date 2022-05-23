import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

String expectedSuccessMSG

String expectedErrorMSG

expectedSuccessMSG = ((('Pay Request inserted/updated successfully on ' + RequestDate) + ' for the Pay Element ') + PayElement)

expectedErrorMSG = (((('Pay Request already exists on service date ' + RequestDate) + ' for pay element ') + PayElement) +' , this request will not be raised')

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.OPTIONAL)

Double ThresholdAmount = ProviderPayRequestSteps.getThresholdAmount()

String PEValue = (ThresholdAmount + 1).toString()

ProviderPayRequestSteps.setPayElementValue(PEValue, FailureHandling.CONTINUE_ON_FAILURE)

ProviderPayRequestSteps.savePayRequest_reachingMaxThresholdContinue(RequestDate, CompensationModel, PayElement, PEValue, 
    expectedSuccessMSG, expectedErrorMSG)

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.STOP_ON_FAILURE)

ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.STOP_ON_FAILURE)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.STOP_ON_FAILURE)

//Double ThresholdAmount = ProviderPayRequestSteps.getThresholdAmount()

Double YTD = ProviderPayRequestSteps.getYTDAmount()

def PEAmount = ProviderPayRequestSteps.getPayElementAmountfromGrid()

def PEAmountBC = ProviderPayRequestSteps.getPayElementAmountBackgroundColor()

def exceedThreshold = Math.abs(ThresholdAmount - YTD)

if (YTD > ThresholdAmount) {
    if (Double.parseDouble(PEAmount) > exceedThreshold) {
        ProviderPayRequestSteps.verifyMaxPayRequestBackgroundColor(RequestDate, CompensationModel, PayElement, PEAmount)
    }
}

ProviderPayRequestSteps.deleteProviderPayRequest(RequestDate, CompensationModel, PayElement)

ProviderPayRequestSteps.gotoProviderPayRequest()

ProviderPayRequestSteps.setProviderName(ProviderName, FailureHandling.STOP_ON_FAILURE)

ProviderPayRequestSteps.selectRequestDate(RequestDate, FailureHandling.STOP_ON_FAILURE)

ProviderPayRequestSteps.selectCompensationModel(CompensationModel, FailureHandling.OPTIONAL)

ProviderPayRequestSteps.selectPayElement(PayElement, FailureHandling.STOP_ON_FAILURE)

ProviderPayRequestSteps.verifyExceededPayElementThresholdBackgroundColor()