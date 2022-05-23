import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PaymentProcessPageSteps
import pages.ProviderPayRequestSteps
import pages.ManageProviderContractSteps
import pages.GLAccountMaintenanceByPEPageSteps
import core.AssertSteps

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
  
if(PaymentProcessPageSteps.isPhysicianNameDisplayed()) {
	  PaymentProcessPageSteps.checkProcessByProvider()
	  PaymentProcessPageSteps.setPhysicianName(Provider)
	  PaymentProcessPageSteps.clickAdd()
 }
  
'Step 09 : Click Process Compensation and Accept Alert If Popup'
if(PaymentProcessPageSteps.isProcessCompensationButtonDisplayed())
	PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)
  
'Step 10 : Pick one record for Validation'
HashMap<String,String> PaymentProcess=new HashMap<String,String>()
PaymentProcess=PaymentProcessPageSteps.getRandomPaymentProcessRecordToValidate()

println PaymentProcess

String Provider=PaymentProcess.get('PayrollID')
String PayElement=PaymentProcess.get('PayElement')
String CostCenter=PaymentProcess.get('CostCenter')
String actualGLAccNo=PaymentProcess.get('GLAccNo')
String actualHIICCID=PaymentProcess.get('HIICCID')
String expectedGLAccNo=''
String expectedHIICCID=''


HashMap<String,String> hmPayRequestDetails=new HashMap<String,String>()
hmPayRequestDetails=ProviderPayRequestSteps.getGridGLAccNoHIICCID(Provider, PayElement, CostCenter)
println hmPayRequestDetails
String PRGLAccNo=hmPayRequestDetails.get('GLAccNo')
String PRHIICCID=hmPayRequestDetails.get('HIICCID')
if(!PRGLAccNo.isEmpty())
	expectedGLAccNo=PRGLAccNo
if(!PRHIICCID.isEmpty())
	expectedHIICCID=PRHIICCID



HashMap<String,String> hmContractDetails=new HashMap<String,String>()
hmContractDetails=ManageProviderContractSteps.getGLAccNoHIICCIDWRTPayElementCostCenter(Provider, PayElement, CostCenter)

String CGLAccNo=hmContractDetails.get('GLAccNo')
String CHIICCID=hmContractDetails.get('HIICCID')

if(expectedHIICCID.isEmpty())
	expectedHIICCID=CHIICCID

if(expectedGLAccNo.isEmpty())
		expectedGLAccNo=CGLAccNo

		
String Location=hmContractDetails.get('Location')
String HIICCID=hmContractDetails.get('HIICCID')
String Specialty=hmContractDetails.get('Specialty')
String CompModel=hmContractDetails.get('CompensationModel')
String PositionLevel=hmContractDetails.get('PositionLevel')
String EmployeeType=hmContractDetails.get('EmployeeType')

String EffectiveFrom=PayPeriod.split('-')[0].trim()
String GLAccNo
GLAccNo=GLAccountMaintenanceByPEPageSteps.getGLAccountNoWRTPayElementCostCenter(PayElement, Region, Location, HIICCID, Specialty, CompModel, PositionLevel, EmployeeType, EffectiveFrom)
if(expectedGLAccNo.isEmpty())
	expectedGLAccNo=GLAccNo

	AssertSteps.verifyActualResult(actualGLAccNo.equals(expectedGLAccNo), 'GL Acc No Valdiation, Expected : '+expectedGLAccNo+' and Actual : '+actualGLAccNo+'- PASS', 'GL Acc No Valdiation, Expected : '+expectedGLAccNo+' and Actual : '+actualGLAccNo+' - FAIL')
	AssertSteps.verifyActualResult(actualHIICCID.equals(expectedHIICCID), 'HII CC ID Valdiation, Expected : '+expectedHIICCID+' and Actual : '+actualHIICCID+'- PASS', 'HII CC ID Valdiation, Expected : '+expectedHIICCID+' and Actual : '+actualHIICCID+'- FAIL')
