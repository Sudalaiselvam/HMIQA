import core.Browser as Browser
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.LoginPageSteps as LoginPageSteps
import pages.ApprovalLevelSettingsForRolePageSteps as ApprovalLevelSettingsForRolePageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.PayElementsSteps as PayElementsSteps
import core.AssertSteps as AssertSteps
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps

String Region

String CompensationModel

String PayElement

String ProviderName

String ServiceDate

String PayElementValue

boolean blnUniversalPayElement

String PayRequestStatus

String PayRequestPayElement

String msgAssertStep

Browser.start(GlobalVariable.URL)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    Region = ProviderPayApprovals.getValue('Region', i)

    CompensationModel = ProviderPayApprovals.getValue('CompensationModel', i)

    PayElement = ProviderPayApprovals.getValue('PayElement', i)

    ProviderName = ProviderPayApprovals.getValue('ProviderName', i)

    ServiceDate = ProviderPayApprovals.getValue('ServiceDate', i)

    PayElementValue = ProviderPayApprovals.getValue('PayElementValue', i)

    PayRequestPayElement = ProviderPayApprovals.getValue('PayRequestPayElement', i)

    LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

    ProviderPayRequestSteps.createProviderRequestwithCurrentDate(ProviderName, ServiceDate, CompensationModel, PayRequestPayElement, 
        PayElementValue)

    PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

    blnAutoApprovedPayElement = PayElementsSteps.verifyPayElementIsAutoApproved(PayElement)

    if (blnAutoApprovedPayElement) {
        msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

        AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
    } else {
        HashMap<String, String> hmApprovalLevelSettings = new HashMap<String, String>()

        String ALSPayElement = ((PayElement + ' [') + CompensationModel) + ']'

        hmApprovalLevelSettings = ApprovalLevelSettingsForRolePageSteps.getApprovalLevelSettings(Region, CompensationModel, 
            ALSPayElement)

        HeaderPageSteps.logOff()

        'Level 1 Approval:'
        String Level1Approval = hmApprovalLevelSettings.getAt('Level 1 Approval')

        String Level1User = Level1Approval.split(' - ').getAt(0)

        Double Level1ApprovalAmount = Double.parseDouble(Level1Approval.split(' - ').getAt(1).replace('$', ''))

        if (Level1ApprovalAmount < Double.parseDouble(PayElementValue)) {
            ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level1User, ProviderName, PayElement, ServiceDate, 'Level1ApprovalPending')
        } else {
            msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

            AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
        }
        
        LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

        PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

        HeaderPageSteps.logOff()

        'Level 2 Approval'
        String Level2Approval = hmApprovalLevelSettings.getAt('Level 2 Approval')

        if (Level2Approval != '') {
            String Level2User = Level2Approval.split(' - ').getAt(0)

            Double Level2ApprovalAmount = Double.parseDouble(Level2Approval.split(' - ').getAt(1).replace('$', ''))

            if (Level2ApprovalAmount < Double.parseDouble(PayElementValue)) {
                ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level2User, ProviderName, PayElement, ServiceDate, 'Level2ApprovalPending')
            } else {
                msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
            }
            
            LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

            PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

            HeaderPageSteps.logOff()

            'Level 3 Approval'
            String Level3Approval = hmApprovalLevelSettings.getAt('Level 3 Approval')

            if (Level3Approval != '') {
                String Level3User = Level3Approval.split(' - ').getAt(0)

                Double Level3ApprovalAmount = Double.parseDouble(Level3Approval.split(' - ').getAt(1).replace('$', ''))

                if (Level3ApprovalAmount < Double.parseDouble(PayElementValue)) {
                    ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level3User, ProviderName, PayElement, ServiceDate, 
                        'Level3ApprovalPending')
                } else {
                    msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                    AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, FailureHandling.STOP_ON_FAILURE)
                }
                
                LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

                PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

                HeaderPageSteps.logOff()

                'Level 4 Approval'
                String Level4Approval = hmApprovalLevelSettings.getAt('Level 4 Approval')

                if (Level4Approval != '') {
                    String Level4User = Level4Approval.split(' - ').getAt(0)

                    Double Level4ApprovalAmount = Double.parseDouble(Level4Approval.split(' - ').getAt(1).replace('$', ''))

                    if (Level4ApprovalAmount < Double.parseDouble(PayElementValue)) {
                        ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level4User, ProviderName, PayElement, ServiceDate, 
                            'Level3ApprovalPending')
                    } else {
                        msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                        AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, 
                            FailureHandling.STOP_ON_FAILURE)
                    }
                    
                    LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

                    PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

                    HeaderPageSteps.logOff()

                    'Level 5 Approval'
                    String Level5Approval = hmApprovalLevelSettings.getAt('Level 5 Approval')

                    if (Level5Approval != '') {
                        String Level5User = Level5Approval.split(' - ').getAt(0)

                        Double Level5ApprovalAmount = Double.parseDouble(Level5Approval.split(' - ').getAt(1).replace('$', 
                                ''))

                        if (Level5ApprovalAmount < Double.parseDouble(PayElementValue)) {
                            ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level5User, ProviderName, PayElement, ServiceDate, 
                                'Level3ApprovalPending')
                        } else {
                            msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                            AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, 
                                FailureHandling.STOP_ON_FAILURE)
                        }
                        
                        LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

                        PayRequestStatus = ProviderPayRequestSteps.getPayRequestStatus(ProviderName, ServiceDate, PayElement)

                        HeaderPageSteps.logOff()

                        'Level 6 Approval'
                        String Level6Approval = hmApprovalLevelSettings.getAt('Level 6 Approval')

                        if (Level6Approval != '') {
                            String Level6User = Level6Approval.split(' - ').getAt(0)

                            Double Level6ApprovalAmount = Double.parseDouble(Level6Approval.split(' - ').getAt(1).replace(
                                    '$', ''))

                            if (Level6ApprovalAmount < Double.parseDouble(PayElementValue)) {
                                ProviderPayApprovalsSteps.LoginAndApprovePayRequest(Level6User, ProviderName, PayElement, 
                                    ServiceDate, 'Level3ApprovalPending')
                            } else {
                                msgAssertStep = ((('Pay Element:' + PayElement) + ' is with Pay Request Status: ') + PayRequestStatus)

                                AssertSteps.verifyActualResult(PayRequestStatus.equals('Approved'), msgAssertStep, msgAssertStep, 
                                    FailureHandling.STOP_ON_FAILURE)
                            }
                        }
                    }
                }
            }
        }
    }
}