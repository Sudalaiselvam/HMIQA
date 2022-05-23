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

HashMap<String, String> hmApprovalLevelSettings = new HashMap<String, String>()
	
	if (ServiceDate == null || ServiceDate == '') {
		ServiceDate = DateTimeUtil.getDateTime()
	}

	'Step 2: Login with Compensation Administrator'
	LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
	
	'Step 3: Get Pay Approval Denial Limit'
	String PayApprovalDenialLimit=GeneralSettingsSteps.getPayApprovalDenialLimit()
	
	if (ManageProviderContractSteps.verifyValidContractWithDate(Provider, ServiceDate)) {
		
		String PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel,PayElement, ServiceDate)
		
		switch (PayRequestStatus) {
			case null:
				Logger.logINFO('Provider: '+ Provider+' with Compensation Model: '+CompensationModel+' , Pay Element : '+PayElement+' for Service Date: '+ServiceDate+' does not exists in the system')
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
		
		int j=1
		
		while(j<=Integer.parseInt(PayApprovalDenialLimit)) {
				
				String LevelApproval
				boolean blnApproval
			
				switch (PayRequestStatus) {
					case 'Level1ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 1 Approval')
						blnApproval=true
						break
					case 'Level2ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 2 Approval')
						blnApproval=true
						break
					case 'Level3ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 3 Approval')
						blnApproval=true
						break
					case 'Level4ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 4 Approval')
						blnApproval=true
						break
					case 'Level5ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 5 Approval')
						blnApproval=true
						break
					case 'Level6ApprovalPending':
						LevelApproval = hmApprovalLevelSettings.getAt('Level 6 Approval')
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
						ProviderPayApprovalsSteps.LoginAndDenyPayRequest(LevelUser, Provider, PayElement, ServiceDate, PayRequestStatus)
					} else {
						msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)
						AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
					}
					
					LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
					if(j==Integer.parseInt(PayApprovalDenialLimit)) {
						PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)
						msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)
						AssertSteps.verifyActualResult(PayRequestStatus.equals('Rejected'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
					}else {
					ProviderPayRequestSteps.gotoProviderPayRequest()
					ProviderPayRequestSteps.setProviderName(Provider)
					ProviderPayRequestSteps.editProviderPayRequest(CompensationModel, PayElement, ServiceDate)
					ProviderPayRequestSteps.clickSave()
					PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)
					HeaderPageSteps.logOff()
					}
				}else {
					break
				}
			
			j++
		}
		
		
	}else {
		Logger.logERROR(((('Provider:' + Provider) + ' with Service Date :') + ServiceDate) + ' do not have Valid Contract')
	}
	
