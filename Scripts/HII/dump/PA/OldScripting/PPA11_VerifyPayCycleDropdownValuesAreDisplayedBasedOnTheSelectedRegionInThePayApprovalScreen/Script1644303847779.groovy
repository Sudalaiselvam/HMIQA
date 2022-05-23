import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps

Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
    Set<String> expectedPayCycle = new HashSet<String>()

    expectedPayCycle = PayCycleMappingPageSteps.getPayCycleMappedtoRegion(ProviderPayApprovals.getValue('Region',i))

    ProviderPayApprovalsSteps.gotoProviderPayApprovals()

    ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region',i))

    ProviderPayApprovalsSteps.verifyPayCyleList(expectedPayCycle)
}