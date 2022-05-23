import core.Browser as Browser
import core.Logger as Logger
import core.AssertSteps as AssertSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import utils.DateTimeUtil as DateTimeUtil
import pages.LoginPageSteps as LoginPageSteps
import pages.GeneralSettingsSteps as GeneralSettingsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.ApprovalLevelSettingsForRolePageSteps as ApprovalLevelSettingsForRolePageSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

HashMap<String, String> hmApprovalLevelSettings = new HashMap<String, String>()

if ((ServiceDate == null) || (ServiceDate == '')) {
    ServiceDate = DateTimeUtil.getDateTime()
}

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Verify Provider has Valid Contract with Service Date'
if (ManageProviderContractSteps.verifyValidContractWithDate(Provider, ServiceDate)) {
    'Step 4: Verify Pay Request Exists for the Service Date'
    String PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel, 
        PayElement, ServiceDate)

    switch (PayRequestStatus) {
        case null:
            Logger.logINFO(((((((('Provider: ' + Provider) + ' with Compensation Model: ') + CompensationModel) + ' , Pay Element : ') + 
                PayElement) + ' for Service Date: ') + ServiceDate) + ' does not exists in the system')

            'Step 5: Create Provider Pay Request'
            ProviderPayRequestSteps.createProviderRequestwithCurrentDate(Provider, ServiceDate, CompensationModel, PayElement, 
                PayElementValue)

            PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel, 
                PayElement, ServiceDate)

            blnAutoApprovedPayElement = PayElementsSteps.verifyPayElementIsAutoApproved(PayElement)

            if (blnAutoApprovedPayElement) {
                msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
            } else {
                String ALSPayElement = ((PayElement + ' [') + CompensationModel) + ']'

                hmApprovalLevelSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel, 
                    ALSPayElement)

                HeaderPageSteps.logOff()
            }
            
            break
        case 'Approved':
            Logger.logWARNING((((((((('Provider: ' + Provider) + ' with Compensation Model: ') + CompensationModel) + ' , Pay Element : ') + 
                PayElement) + ' for Service Date: ') + ServiceDate) + ' already exists in the system with status :') + PayRequestStatus)

            break
        default:
            Logger.logWARNING((((((((('Provider: ' + Provider) + ' with Compensation Model: ') + CompensationModel) + ' , Pay Element : ') + 
                PayElement) + ' for Service Date: ') + ServiceDate) + ' already exists in the system with status :') + PayRequestStatus)

            String ALSPayElement = ((PayElement + ' [') + CompensationModel) + ']'

            hmApprovalLevelSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel, 
                ALSPayElement)

            HeaderPageSteps.logOff()

            break
    }
    
    'Step 6: Approve OR Deny Pay Request based on Test Data Approval Level Settings'
    while (PayRequestStatus != 'Approved') {
        String LevelApproval

        String ApproveDeny

        boolean blnApproval

        switch (PayRequestStatus) {
            case 'Level1ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 1 Approval')

                ApproveDeny = Level1Approval

                blnApproval = true

                break
            case 'Level2ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 2 Approval')

                ApproveDeny = Level2Approval

                blnApproval = true

                break
            case 'Level3ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 3 Approval')

                ApproveDeny = Level3Approval

                blnApproval = true

                break
            case 'Level4ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 4 Approval')

                ApproveDeny = Level4Approval

                blnApproval = true

                break
            case 'Level5ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 5 Approval')

                ApproveDeny = Level5Approval

                blnApproval = true

                break
            case 'Level6ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 6 Approval')

                ApproveDeny = Level6Approval

                blnApproval = true

                break
            default:
                blnApproval = false

                break
        }
        
        if (blnApproval) {
            String LevelUser = LevelApproval.split(' - ')[0]

            Double LevelApprovalAmount = Double.parseDouble((LevelApproval.split(' - ')[1]).replace('$', ''))

            if (LevelApprovalAmount < Double.parseDouble(PayElementValue)) {
                ProviderPayApprovalsSteps.LoginAndApproveDenyPayRequest(LevelUser, Provider, PayElement, ServiceDate, PayRequestStatus, 
                    ApproveDeny)
            } else {
                msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
            }
            
            LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

            PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)

            HeaderPageSteps.logOff()
        } else {
            break
        }
    }
} else {
    Logger.logERROR(((('Provider:' + Provider) + ' with Service Date :') + ServiceDate) + ' do not have Valid Contract')
}