import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageProviderContractSteps
import pages.ProviderPayApprovalsSteps
import pages.ProviderSetupSteps
import pages.PaymentProcessPageSteps
import pages.PayElementsSteps
import core.Logger
import configs.HIIConstants
import core.AssertSteps
import utils.Utilities
import utils.DateTimeUtil


'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Capture Required Details from Contract Screen'
Double MaxCompensation=0
List<HashMap> PaymentContractDetails = new ArrayList()
PaymentContractDetails = ManageProviderContractSteps.getPaymentDetailsMappedToProviderContract(Provider, Year)
for (HashMap<String, String> PaymentContractDetail : PaymentContractDetails) {
	MaxCompensation=PaymentContractDetail.get('MaxCompensation').toDouble()
}
Logger.logINFO('Max Compensation for Provider - '+Provider+' of Year - '+Year+ ' : '+MaxCompensation)

'Capture Required Details from Pay Approval Screen'
Double PayCompensation = 0
String exceededPayPeriod
HashMap<String,String> PayDetailForPayPeriod=new HashMap<>()
List<HashMap> PayDetails = new ArrayList()
PayDetails = ProviderPayApprovalsSteps.getPayDetailsApproved(Provider, Year)
for (HashMap<String, String> payDetail : PayDetails) {
	String ApprovalStatus = payDetail.get('ApprovalStatus')
	if (ApprovalStatus.equals('Approved')) {
		Double Amount = Double.parseDouble(payDetail.get('Amount').replace(',', ''))
		Double YTDAmount = Double.parseDouble(payDetail.get('YTDAmount').replace(',', ''))
		PayCompensation = (PayCompensation + Amount)
		if(YTDAmount>MaxCompensation) {
			exceededPayPeriod=payDetail.get('PayPeriod')
		}
		String pPayPeriod
		if(PayPeriod.equals(payDetail.get('PayPeriod'))) {
			PayDetailForPayPeriod.put('PayElement', payDetail.get('PayElement'))
			PayDetailForPayPeriod.put('PayPeriod', PayPeriod)
			PayDetailForPayPeriod.put('Amount', Amount)
			if(payDetail.get('PayElement').endsWith('PPEC'))
				PayDetailForPayPeriod.put('AutpApprovedPE', 'Yes')
		}
	}
}

Logger.logINFO('Max Compensation exceeded for Provider - '+Provider+' of Year - '+Year+ ' at Pay Period : '+exceededPayPeriod)

'Capture Required Details from Provider Setup'
HashMap<String,String> ProviderDetails=new HashMap<>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)
String Region=ProviderDetails.get('Region')
String Location=ProviderDetails.get('Location')

'Step 03 : Navigate to Payment Process'
PaymentProcessPageSteps.gotoPaymentProcess()

'Step 04 : Select Region'
PaymentProcessPageSteps.selectRegion(Region)

'Step 05 : Select Pay Cycle'
PaymentProcessPageSteps.selectPayCycle(PayCycle)

'Step 06 : Select Year'
PaymentProcessPageSteps.selectYear(Year)

'Step 07 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)

'Step 08 : Select Location and Capture Background Color of selected Location'
String bgColorLocation=PaymentProcessPageSteps.getLocationBackgroundColor(Location)
PaymentProcessPageSteps.selectLocation(Location)

'Step 09 : Click Process Compensation'
if(bgColorLocation.equals(HIIConstants.White))
	PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()

'Step 10 : Set Payment Process Physician Name'
PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)

'Step 11 : Validate Pay Elements and Amounts'
int exceededIndex=PaymentProcessPageSteps.getPayPeriodIndex(exceededPayPeriod)
int currentIndex=PaymentProcessPageSteps.getPayPeriodIndex(PayPeriod)
int PPECIndex

String actualPayElement
String actualAmount
String expectedPayElement
String expectedAmount
String AssertPayElementMsg
String AssertAmountMsg
List<HashMap> PaymentProcessDetails=new ArrayList<>()
PaymentProcessDetails=PaymentProcessPageSteps.getPaymentProcessDetails()
for(HashMap PaymentProcessDetail:PaymentProcessDetails)
{
	actualPayElement=PaymentProcessDetail.get('PayElement')
	actualAmount=PaymentProcessDetail.get('CalculatedAmount').replace('$','')
	for (HashMap<String, String> payDetail : PayDetails) {
		String vPayPeriod=payDetail.get('PayPeriod')
		String vPayElement=payDetail.get('PayElement')
		if(exceededPayPeriod!=null) {
			if(vPayElement.equals(actualPayElement) && vPayPeriod.equals(PayPeriod)){
				expectedPayElement=payDetail.get('PayElement')
				expectedAmount=payDetail.get('Amount')
				AssertPayElementMsg='PayElement validation, Expected : '+expectedPayElement+' and Actual : '+actualPayElement
				AssertAmountMsg='PayElement Amount validation, Expected : '+expectedAmount+' and Actual : '+actualAmount
				AssertSteps.verifyActualResult(expectedPayElement.equals(actualPayElement), AssertPayElementMsg+' -PASS', AssertPayElementMsg+' -FAIL')
				AssertSteps.verifyActualResult(expectedAmount.equals(actualAmount), AssertAmountMsg+' -PASS', AssertAmountMsg+' -FAIL')
			}
			if(bgColorLocation.equals(HIIConstants.Gray)) {
				if(actualPayElement.endsWith('PPEC'))
					{
						PPECIndex=currentIndex-1
						String PPECPayPeriod=PaymentProcessPageSteps.getPayPeriodWithIndex(PPECIndex)
							if(vPayPeriod.equals(PPECPayPeriod) && vPayElement.endsWith('PPEC')) {
								expectedPayElement=payDetail.get('PayElement')
								expectedAmount=payDetail.get('Amount')
								AssertPayElementMsg='PayElement validation, Expected : '+expectedPayElement+' and Actual : '+actualPayElement
								AssertAmountMsg='PayElement Amount validation, Expected : '+expectedAmount+' and Actual : '+actualAmount
								AssertSteps.verifyActualResult(expectedPayElement.equals(actualPayElement), AssertPayElementMsg+' -PASS', AssertPayElementMsg+' -FAIL')
								AssertSteps.verifyActualResult(expectedAmount.equals(actualAmount), AssertAmountMsg+' -PASS', AssertAmountMsg+' -FAIL')
							}
					}
			}
		}else {
			if(vPayElement.equals(actualPayElement) && vPayPeriod.equals(PayPeriod)){
				expectedPayElement=payDetail.get('PayElement')
				expectedAmount=payDetail.get('Amount')
				AssertPayElementMsg='PayElement validation, Expected : '+expectedPayElement+' and Actual : '+actualPayElement
				AssertAmountMsg='PayElement Amount validation, Expected : '+expectedAmount+' and Actual : '+actualAmount
				AssertSteps.verifyActualResult(expectedPayElement.equals(actualPayElement), AssertPayElementMsg+' -PASS', AssertPayElementMsg+' -FAIL')
				AssertSteps.verifyActualResult(expectedAmount.equals(actualAmount), AssertAmountMsg+' -PASS', AssertAmountMsg+' -FAIL')
			}
			for (HashMap<String, String> PaymentContractDetail : PaymentContractDetails) {
				String cPayElement=PaymentContractDetail.get('PayElement')
				HashMap<String,String> PayElementDetails=new HashMap<String,String>()
				PayElementDetails=PayElementsSteps.getPayElementDetails(cPayElement)
				if(PayElementDetails.get('Type').equals(HIIConstants.PEType_Fixed)) {
					if(cPayElement.equals(actualPayElement)) {
						Double AnnAmount=Double.parseDouble(PaymentContractDetail.get('AnnAmountRate'))
						String PEStartDate=PaymentContractDetail.get('PayElementStartDate')
						String PEEndDate=PaymentContractDetail.get('PayElementEndDate')
						String PayFrequency=PaymentContractDetail.get('PayElementPayFrequency')
						long PECount
						switch(PayFrequency) {
							case 'Pay Period': PECount=378
							break
							default: PECount=365
							break
						}
						Double PerDay=(AnnAmount)/PECount
						String PayPeriodStartDate=PayPeriod.split(' - ')[0]
						String PayPeriodEndDate=PayPeriod.split(' - ')[1]
						long perPayPeriod=DateTimeUtil.getNoOfDaysBetweenTwoDates(PayPeriodStartDate, PayPeriodEndDate)
						expectedAmount=Utilities.DecimalFormatToTwo(perPayPeriod*PerDay)
						expectedPayElement=cPayElement
						AssertPayElementMsg='PayElement validation, Expected : '+expectedPayElement+' and Actual : '+actualPayElement
						AssertAmountMsg='PayElement Amount validation, Expected : '+expectedAmount+' and Actual : '+actualAmount
						AssertSteps.verifyActualResult(expectedPayElement.equals(actualPayElement), AssertPayElementMsg+' -PASS', AssertPayElementMsg+' -FAIL')
						AssertSteps.verifyActualResult(expectedAmount.equals(actualAmount), AssertAmountMsg+' -PASS', AssertAmountMsg+' -FAIL')
					}
				}
			}	
				
			
			
		}
	}
}

	
