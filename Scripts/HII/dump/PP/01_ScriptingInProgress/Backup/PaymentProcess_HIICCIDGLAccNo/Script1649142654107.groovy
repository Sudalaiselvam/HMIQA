import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps


'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 07 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 08 : Select All Location'
PaymentProcessPageSteps.selectallLocations()

if (PaymentProcessPageSteps.isPhysicianNameDisplayed()) {
    PaymentProcessPageSteps.checkProcessByProvider()

    PaymentProcessPageSteps.setPhysicianName(Provider)

    PaymentProcessPageSteps.clickAdd()
}

'Step 09 : Click Process Compensation and Accept Alert If Popup'
if (PaymentProcessPageSteps.isProcessCompensationButtonDisplayed()) {
    PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
}

PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)

'Step 10 : Pick one record for Validation'
HashMap<String, String> PaymentProcess = new HashMap<String, String>()

PaymentProcess = PaymentProcessPageSteps.getRandomPaymentProcessRecordToValidate()

println(PaymentProcess)

String actualPayElement = PaymentProcess.get('PayElement')

String actualCostCenter = PaymentProcess.get('CostCenter')

String actualHIICCID = PaymentProcess.get('HIICCID')

String actualGLAccNo = PaymentProcess.get('GLAccNo')

println(actualHIICCID)

println(actualGLAccNo)