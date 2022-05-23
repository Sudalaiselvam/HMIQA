import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ApprovalLevelSettingsForRolePageSteps as ApprovalLevelSettingsForRolePageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.HeaderPageSteps as HeaderPageSteps

Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    
	String Provider = ProviderPayApprovals.getValue('Provider', i)

    String ServiceDate = ProviderPayApprovals.getValue('ServiceDate', i)

    String PayElement = ProviderPayApprovals.getValue('PayElement', i)

    String Region = ProviderPayApprovals.getValue('Region',i)

    String CompensationModel = ProviderPayApprovals.getValue('CompensationModel',i)
	
    String ALSRP_PayElement = ((PayElement + ' [') + CompensationModel) + ']'

    LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

    String PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(Provider, ServiceDate, PayElement)

    HashMap<String, String> hmApprovalSettings = new HashMap<String, String>()

    hmApprovalSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel, ALSRP_PayElement)

    HeaderPageSteps.logOff()

    String ApprovalUser

    switch (PayRequestStatus) {
        case 'Level1ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 1 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        case 'Level2ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 2 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        case 'Level3ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 3 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        case 'Level4ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 4 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        case 'Level5ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 5 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        case 'Level6ApprovalPending':
            ApprovalUser = hmApprovalSettings.get('Level 6 Approval').split(' - ').getAt(0)

            LoginPageSteps.Login(ApprovalUser)

            break
        default:
            break
    }
    
    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.setProvider(Provider)

    ProviderPayApprovalsSteps.verifyPayRequest(ServiceDate, PayElement)
}