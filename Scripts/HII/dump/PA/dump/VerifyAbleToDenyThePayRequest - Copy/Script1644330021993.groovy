import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import utils.DateTimeUtil as DateTimeUtil
import core.Logger as Logger
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.HeaderPageSteps as HeaderPageSteps
import core.AssertSteps as AssertSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import pages.PayElementsSteps as PayElementsSteps
import pages.ApprovalLevelSettingsForRolePageSteps as ApprovalLevelSettingsForRolePageSteps

String ServiceDate = '02/06/2022'

// = '01/19/2021'
String Provider = 'PayApproval04'

String CompensationModel = 'Comp Model 1'

String PayElement = 'APP supervision pay'

String PayElementValue = 5

String Region = 'Region-1'

HashMap<String, String> hmApprovalLevelSettings = new HashMap<String, String>()

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

if (ServiceDate == null) {
    ServiceDate = DateTimeUtil.getDateTime()
}

if (ManageProviderContractSteps.verifyValidContractWithDate(Provider, ServiceDate)) {
    Logger.logINFO(((('Provider:' + Provider) + ' with Service Date :') + ServiceDate) + ' has Valid Contract')

    String PayRequestStatus = ProviderPayRequestSteps.getProviderPayRequestStatusForServiceDateExists(Provider, CompensationModel, 
        PayElement, ServiceDate)

    switch (PayRequestStatus) {
        case null:
            Logger.logINFO(((((((('Provider: ' + Provider) + ' with Compensation Model: ') + CompensationModel) + ' , Pay Element : ') + 
                PayElement) + ' for Service Date: ') + ServiceDate) + ' does not exists in the system')

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

            HeaderPageSteps.logOff()

            break
    }
    
    while (PayRequestStatus != 'Approved') {
        String LevelApproval

        switch (PayRequestStatus) {
            case 'Level1ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 1 Approval')

                break
            case 'Level2ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 2 Approval')

                break
            case 'Level3ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 3 Approval')

                break
            case 'Level4ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 4 Approval')

                break
            case 'Level5ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 5 Approval')

                break
            case 'Level6ApprovalPending':
                LevelApproval = hmApprovalLevelSettings.getAt('Level 6 Approval')

                break
        }
        
        String LevelUser = LevelApproval.split(' - ')[0]

        Double LevelApprovalAmount = Double.parseDouble((LevelApproval.split(' - ')[1]).replace('$', ''))

        if (LevelApprovalAmount < Double.parseDouble(PayElementValue)) {
            ProviderPayApprovalsSteps.LoginAndApprovePayRequest(LevelUser, Provider, PayElement, ServiceDate, PayRequestStatus)
        } else {
            msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

            AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
        }
        
        LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

        PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)

        HeaderPageSteps.logOff()
    } 
} else {
    Logger.logERROR(((('Provider:' + Provider) + ' with Service Date :') + ServiceDate) + ' do not have Valid Contract')
}