import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import core.Logger as Logger
import configs.HIIConstants as HIIConstants
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PaymentProcessPageSteps as PaymentProcessPageSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps
import pages.ProviderSetupSteps
import pages.PayElementsSteps
import core.AssertSteps
import utils.DateTimeUtil
import utils.Utilities
//Team Health

String Provider='PaymentProcess04'
String Year='2022'
String PayCycle='Sunday to Saturday-2'
String PayPeriod='01/02/2022 - 01/15/2022'
//'01/16/2022 - 01/29/2022'
//'01/30/2022 - 02/12/2022'

//DulyQA
/*
String Provider = '11008'
String Year = '2020'
*/
'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)
'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)
Double MaxCompensation=0
List<HashMap> PaymentContractDetails = new ArrayList()
PaymentContractDetails = ManageProviderContractSteps.getPaymentDetailsMappedToProviderContract(Provider, Year)
for (HashMap<String, String> PaymentContractDetail : PaymentContractDetails) {
	MaxCompensation=PaymentContractDetail.get('MaxCompensation').toDouble()
}


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
println exceededPayPeriod

HashMap<String,String> ProviderDetails=new HashMap<>()
ProviderDetails=ProviderSetupSteps.getProviderDetails(Provider)
String Region=ProviderDetails.get('Region')
String Location=ProviderDetails.get('Location')
PaymentProcessPageSteps.gotoPaymentProcess()
PaymentProcessPageSteps.selectRegion(Region)
PaymentProcessPageSteps.selectPayCycle(PayCycle)
PaymentProcessPageSteps.selectYear(Year)
int exceededIndex=PaymentProcessPageSteps.getPayPeriodIndex(exceededPayPeriod)
int currentIndex=PaymentProcessPageSteps.getPayPeriodIndex(PayPeriod)
int PPECIndex
//if(currentIndex>=exceededIndex) 
if(exceededPayPeriod!=null)	
	{
	String bgColorPayPeriod=PaymentProcessPageSteps.getPayPeriodBackgroundColor(PayPeriod)
	PaymentProcessPageSteps.selectPayPeriod(PayPeriod)
	String bgColorLocation=PaymentProcessPageSteps.getLocationBackgroundColor(Location)
	PaymentProcessPageSteps.selectLocation(Location)
	switch(bgColorLocation) {
		case HIIConstants.White:
			PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
			PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)
			List<HashMap> PaymentProcessDetails=new ArrayList<>()
			PaymentProcessDetails=PaymentProcessPageSteps.getPaymentProcessDetails()
			for(HashMap PaymentProcessDetail:PaymentProcessDetails)
				{
					String ppPayElement=PaymentProcessDetail.get('PayElement')
					HashMap<String,String> PayElementDetails=new HashMap<String,String>()
					PayElementDetails=PayElementsSteps.getPayElementDetails(ppPayElement)
					if(PayElementDetails.get('Type').equals(HIIConstants.PEType_Fixed)) {
						for (HashMap<String, String> PaymentContractDetail : PaymentContractDetails) {
								if(PaymentContractDetail.get('PayElement').equals(ppPayElement))
								{
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
									Double ExpectedAmount=perPayPeriod*PerDay
									String expPayElement=PaymentContractDetail.get('PayElement')
									String actPayElement=ppPayElement
									String expAmount=Utilities.DecimalFormatToTwo(ExpectedAmount)
									String actAmount=PaymentProcessDetail.get('CalculatedAmount').replace('$','')
									AssertSteps.verifyActualResult(expPayElement.equals(actPayElement), 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -PASS', 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -FAIL')
									AssertSteps.verifyActualResult(expAmount.equals(actAmount), 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -PASS', 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -FAIL')
								}
						}
					}
				}
		break
		case HIIConstants.Gray:
		PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)
		List<HashMap> PaymentProcessDetails=new ArrayList<>()
		PaymentProcessDetails=PaymentProcessPageSteps.getPaymentProcessDetails()
		for(HashMap PaymentProcessDetail:PaymentProcessDetails)
			{
				String ppPayElement=PaymentProcessDetail.get('PayElement')
				if(ppPayElement.endsWith('PPEC'))
				{
					PPECIndex=currentIndex-1
					String PPECPayPeriod=PaymentProcessPageSteps.getPayPeriodWithIndex(PPECIndex)
					for (HashMap<String, String> payDetail : PayDetails) {
						String vPayPeriod=payDetail.get('PayPeriod')
						String vPayElement=payDetail.get('PayElement')
						if(vPayPeriod.equals(PPECPayPeriod) && vPayElement.endsWith('PPEC')) {
							String expPayElement=payDetail.get('PayElement')
							String expAmount=payDetail.get('Amount')
							String actPayElement=PaymentProcessDetail.get('PayElement')
							String actAmount=PaymentProcessDetail.get('CalculatedAmount').replace('$','')
							AssertSteps.verifyActualResult(expPayElement.equals(actPayElement), 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -PASS', 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -FAIL')
									AssertSteps.verifyActualResult(expAmount.equals(actAmount), 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -PASS', 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -FAIL')
						}
					}
				}else {
					
							String actPayElement=PaymentProcessDetail.get('PayElement')
							String actAmount=PaymentProcessDetail.get('CalculatedAmount').replace('$','')
							for (HashMap<String, String> payDetail : PayDetails) {
								String vPayPeriod=payDetail.get('PayPeriod')
								String vPayElement=payDetail.get('PayElement')
								if(vPayElement.equals(ppPayElement) && vPayPeriod.equals(PayPeriod)){
									String expPayElement=payDetail.get('PayElement')
									String expAmount=payDetail.get('Amount')
									AssertSteps.verifyActualResult(expPayElement.equals(actPayElement), 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -PASS', 'PayElement validation, Expected : '+expPayElement+' and Actual : '+actPayElement+' -FAIL')
									AssertSteps.verifyActualResult(expAmount.equals(actAmount), 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -PASS', 'PayElement Amount validation, Expected : '+expAmount+' and Actual : '+actAmount+' -FAIL')
									}
									
								}
				}
			}
		break
	}
}else {
	for (HashMap<String, String> payDetail : PayDetails) {
		String pPayElement=payDetail.get('PayElement')
		println pPayElement
		println payDetail
	}
	
}


