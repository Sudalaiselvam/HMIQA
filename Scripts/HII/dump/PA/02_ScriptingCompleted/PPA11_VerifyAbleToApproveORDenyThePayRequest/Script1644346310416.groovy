import core.Browser
import core.Logger
import core.AssertSteps
import configs.HIIConstants
import internal.GlobalVariable
import utils.DateTimeUtil
import pages.LoginPageSteps
import pages.GeneralSettingsSteps
import pages.ManageProviderContractSteps
import pages.ProviderPayRequestSteps
import pages.PayElementsSteps
import pages.ApprovalLevelSettingsForRolePageSteps
import pages.HeaderPageSteps
import pages.ProviderPayApprovalsSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
	
	String Provider = ProviderPayApprovals.getValue('Provider', i)
	String CompensationModel = ProviderPayApprovals.getValue('CompensationModel', i)
	String Region =ProviderPayApprovals.getValue('Region', i)
	String PayElement = ProviderPayApprovals.getValue('PayElement', i)
	String ServiceDate = ProviderPayApprovals.getValue('ServiceDate', i)
	String PayElementValue = ProviderPayApprovals.getValue('PayElementValue', i)
	String Level1Approval= ProviderPayApprovals.getValue('Level1Approval', i)
	String Level2Approval= ProviderPayApprovals.getValue('Level2Approval', i)
	String Level3Approval= ProviderPayApprovals.getValue('Level3Approval', i)
	String Level4Approval= ProviderPayApprovals.getValue('Level4Approval', i)
	String Level5Approval= ProviderPayApprovals.getValue('Level5Approval', i)
	String Level6Approval= ProviderPayApprovals.getValue('Level6Approval', i)
	HashMap<String, String> hmApprovalLevelSettings = new HashMap<String, String>()
	
	if (ServiceDate == null || ServiceDate == '') {
		ServiceDate = DateTimeUtil.getDateTime()
	}

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
		
'Step 3: Verify Provider has Valid Contract with Service Date'
	if (ManageProviderContractSteps.verifyValidContractWithDate(Provider, ServiceDate)) {
		
'Step 4: Verify Pay Request Exists for the Service Date'
		String PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel,PayElement, ServiceDate)
		
		switch (PayRequestStatus) {
			case null:
				Logger.logINFO('Provider: '+ Provider+' with Compensation Model: '+CompensationModel+' , Pay Element : '+PayElement+' for Service Date: '+ServiceDate+' does not exists in the system')
'Step 5: Create Provider Pay Request'
				ProviderPayRequestSteps.createProviderRequestwithCurrentDate(Provider, ServiceDate, CompensationModel, PayElement,PayElementValue)
				PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel,PayElement, ServiceDate)
				blnAutoApprovedPayElement = PayElementsSteps.verifyPayElementIsAutoApproved(PayElement)
				if (blnAutoApprovedPayElement) {
					msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)
					AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
				} else {
					String ALSPayElement = ((PayElement + ' [') + CompensationModel) + ']'
					hmApprovalLevelSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel,ALSPayElement)
					HeaderPageSteps.logOff()
				}
				break
			case 'Approved':
				Logger.logWARNING('Provider: '+Provider+' with Compensation Model: '+CompensationModel+' , Pay Element : '+PayElement+' for Service Date: '+ServiceDate+' already exists in the system with status :'+ PayRequestStatus)
				break
			default:
				Logger.logWARNING('Provider: '+Provider+' with Compensation Model: '+CompensationModel+' , Pay Element : '+PayElement+' for Service Date: '+ ServiceDate+' already exists in the system with status :'+ PayRequestStatus)
				String ALSPayElement = ((PayElement + ' [') + CompensationModel) + ']'
				hmApprovalLevelSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel,ALSPayElement)
				HeaderPageSteps.logOff()
				break
		}

'Step 6: Approve OR Deny Pay Request based on Test Data Approval Level Settings'				
		
	while (PayRequestStatus != 'Approved') {
		
		String LevelApproval,ApproveDeny
		boolean blnApproval
	
		switch (PayRequestStatus) {
			case 'Level1ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 1 Approval')
				ApproveDeny=Level1Approval
				blnApproval=true
				break
			case 'Level2ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 2 Approval')
				ApproveDeny=Level2Approval
				blnApproval=true
				break
			case 'Level3ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 3 Approval')
				ApproveDeny=Level3Approval
				blnApproval=true
				break
			case 'Level4ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 4 Approval')
				ApproveDeny=Level4Approval
				blnApproval=true
				break
			case 'Level5ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 5 Approval')
				ApproveDeny=Level5Approval
				blnApproval=true
				break
			case 'Level6ApprovalPending':
				LevelApproval = hmApprovalLevelSettings.getAt('Level 6 Approval')
				ApproveDeny=Level6Approval
				blnApproval=true
				break
			default:
			blnApproval=false
			break	
		}
		
		if(blnApproval)
		{
			String LevelUser = LevelApproval.split(' - ')[0]
			Double LevelApprovalAmount = Double.parseDouble((LevelApproval.split(' - ')[1]).replace('$', ''))
			if (LevelApprovalAmount < Double.parseDouble(PayElementValue)) {
				ProviderPayApprovalsSteps.LoginAndApproveDenyPayRequest(LevelUser, Provider, PayElement, ServiceDate, PayRequestStatus,ApproveDeny)
			} else {
				msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)
				AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
			}
					
			LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
			PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)
			HeaderPageSteps.logOff()
		}else {
			break
		}
	}
		
		
	}else {
		Logger.logERROR(((('Provider:' + Provider) + ' with Service Date :') + ServiceDate) + ' do not have Valid Contract')
	}
	
}