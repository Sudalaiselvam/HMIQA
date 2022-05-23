
import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import utils.Utilities
import core.AssertSteps






Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	
	String Provider=ProviderPayApprovals.getValue('Provider',i)
	String CompensationModel=ProviderPayApprovals.getValue('CompensationModel',i)
	String PayElement=ProviderPayApprovals.getValue('PayElement',i)
	String ServiceDate=ProviderPayApprovals.getValue('ServiceDate',i)
	String updateAmount=ProviderPayApprovals.getValue('updateAmount',i)
	
	Double ContractMaxCompensation
	Double PayElementThreshold
	Double PayRequestCompensation
	Double PayRequestAmount
	Double PayRequestYTDAmount
	Double PayRequestThreshold
	String ContractPeriod
	String ProviderName
	String PayPeriod
	String existingAmount
	
	HashMap<String,String> ContractAmountDetails=new HashMap<String,String>()
	
	
	ContractAmountDetails=ManageProviderContractSteps.getMaxCompensationAndThresholdAmount(Provider, CompensationModel, PayElement)
	ContractMaxCompensation=Double.parseDouble(ContractAmountDetails.get('MaxCompensation').replace(',',''))
	PayElementThreshold=Double.parseDouble(ContractAmountDetails.get('ThresholdAmount').replace(',',''))
	ContractPeriod=ContractAmountDetails.get('ContractPeriod')
	
	PayRequestCompensation=ProviderPayRequestSteps.getCompensationForCompensationModel(Provider, CompensationModel, ServiceDate)
	
	HashMap<String,String> PayRequestData=new HashMap<String,String>()
	
	ProviderPayApprovalsSteps.gotoProviderPayApprovals()
	ProviderPayApprovalsSteps.setProvider(Provider)
	PayRequestData=ProviderPayApprovalsSteps.getGridDataForPayElementWithServiceDate(PayElement, ServiceDate)
	PayRequestYTDAmount=Double.parseDouble(PayRequestData.get('YTDAmounts').replace(',',''))
	ProviderName=PayRequestData.get('ProviderName')
	PayPeriod=PayRequestData.get('PayPeriod')
	existingAmount=PayRequestData.get('Amount')
	
	
	Double diffAmount=Double.parseDouble(updateAmount)-Double.parseDouble(existingAmount)
	
	String ExceedAmount
	String ExpectedMessage
	if((PayRequestCompensation+diffAmount)>ContractMaxCompensation) {
		ExceedAmount=Utilities.getDifferenceBTWValues(ContractMaxCompensation.toString(), PayRequestCompensation.toString())
		ExpectedMessage=HIIConstants.PPA_MaxThresholdLimitPopupMessage(ProviderName, PayElement, CompensationModel, ContractPeriod, ExceedAmount)
		
	}else if((PayRequestYTDAmount+diffAmount)>PayElementThreshold) {
		ExceedAmount=Utilities.getDifferenceBTWValues(PayElementThreshold.toString(), PayRequestYTDAmount.toString())
		ExpectedMessage=HIIConstants.PPA_MaxThresholdLimitPopup_ThresholdLimitMessage(ProviderName, PayElement)
	}
	
	
	
	
	
	ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)
	ProviderPayApprovalsSteps.updateAmountForPayElementWithServiceDate(PayElement, ServiceDate, updateAmount)
	
	
	
	ProviderPayApprovalsSteps.clickUpdate()
	
	if(ExpectedMessage!=null) {
		String actualMsg=ProviderPayApprovalsSteps.getMaxCompensationAndThresholdExceedAlertMessage()
		String AssertMsg='Actual:\n '+actualMsg+' and Expected:\n'+ExpectedMessage
		AssertSteps.verifyActualResult(actualMsg.equals(ExpectedMessage), AssertMsg+' : PASS', AssertMsg+' : FAIL')
		ProviderPayApprovalsSteps.clickCancel()
	}else {
		ProviderPayApprovalsSteps.verifyUpdateFunctionality()
	}
	
	
}



