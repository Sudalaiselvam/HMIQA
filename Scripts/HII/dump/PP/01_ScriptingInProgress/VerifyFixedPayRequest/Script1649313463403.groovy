import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.PayElementsSteps
import pages.ManageProviderContractSteps
import core.Logger
import configs.HIIConstants
import pages.ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps
import pages.PaymentProcessPageSteps

String PayElement='allfields'
String Provider='PaymentProcess04'
String Year='2022'
String PayElementType
boolean PayElementAutoApproved
HashMap<String,String> PayRequestDetails=new HashMap<>()
String Region='Region-1'
String PayCycle='Sunday to Saturday-2'
String PayPeriod='01/02/2022 - 01/15/2022'
String Location='Location 123'

'Step 01 : Launch Application '
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, GlobalVariable.ROLE)


HashMap<String,String> PayElementDetails=new HashMap<>()
PayElementDetails=PayElementsSteps.getPayElementDetails(PayElement)
println PayElementDetails
//[Type:Variable, AutoApproved:false]
PayElementType=PayElementDetails.get('Type')
PayElementAutoApproved=PayElementDetails.get('AutoApproved').toBoolean()

switch(PayElementType) {
	case HIIConstants.PEType_Variable:
			PayRequestDetails=ProviderPayRequestSteps.getPayRequestDetailsWRTPayElement(Provider,PayElement)
			
		break
	case HIIConstants.PEType_Fixed:
			PayRequestDetails=ProviderPayRequestSteps.getPayRequestDetailsWRTPayElement(Provider,PayElement)
		break
}

println PayRequestDetails

ManageProviderContractSteps.getMaxCompensationAndThresholdAmount(Provider, CompensationModel, PayElement)

Set<String> setPayElements=new HashSet<>()
setPayElements=ManageProviderContractSteps.getListOfPayElementsMappedToProviderContract(Provider,Year)
println setPayElements

if(setPayElements.contains(PayElement))
	Logger.logINFO('PayElement :'+PayElement+' mapped to Provider : '+Provider)
	
	





Double PayCompensation=0
List<HashMap> PayDetails=new ArrayList<>()
PayDetails=ProviderPayApprovalsSteps.getPayDetails(Provider)
for(HashMap payDetail:PayDetails)
{
	String ApprovalStatus=payDetail.get('ApprovalStatus')
	if(ApprovalStatus.equals('Approved')) {
		Double Amount=Double.parseDouble(payDetail.get('Amount').replace(',',''))
		PayCompensation=PayCompensation+Amount
	}	
	println payDetail
}
println PayCompensation	




PaymentProcessPageSteps.gotoPaymentProcess()
PaymentProcessPageSteps.selectRegion(Region)
PaymentProcessPageSteps.selectPayCycle(PayCycle)
PaymentProcessPageSteps.selectYear(Year)
'Get Pay Period BackGround Color'
String PayPeriodBGColor=PaymentProcessPageSteps.getPayPeriodBackgroundColor(PayPeriod)
'Step 07 : Select Pay Period'
PaymentProcessPageSteps.selectPayPeriod(PayPeriod)
'Get Location Background Color'
String LocationBGColor=PaymentProcessPageSteps.getLocationBackgroundColor(Location)
'Step 08 : Select Location'
PaymentProcessPageSteps.selectLocation(Location)
switch(LocationBGColor) {
	case HIIConstants.White:
							Logger.logINFO('Selected Location :'+Location+' is not processed yet')
							'Step 09 : Click Process Compensation'
							PaymentProcessPageSteps.clickProcessCompensationAndAcceptAlertIfExists()
							break
	case HIIConstants.Gray:
							Logger.logWARNING('Selected Location :'+Location+' is Processed earlier')
							break
}
PaymentProcessPageSteps.setPaymentProcessPhysicianName(Provider)

List<HashMap> PaymentProcessDetails=new ArrayList<>()
PaymentProcessDetails=PaymentProcessPageSteps.getPaymentProcessDetails()
for(HashMap PaymentProcessDetail:PaymentProcessDetails)
	println PaymentProcessDetail
