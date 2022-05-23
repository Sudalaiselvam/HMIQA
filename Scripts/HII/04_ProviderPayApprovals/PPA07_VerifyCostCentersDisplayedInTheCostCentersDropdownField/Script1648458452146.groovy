import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.CostCenterPageSteps as CostCenterPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get Expected list of Cost Centers Mapped to Region and Location'
List<String> lstexpectedCostCenters = new ArrayList<String>()
lstexpectedCostCenters = CostCenterPageSteps.getCostCenterNameWRTRegionLocation(Region, Location)

'Step 04 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 05 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 06 : Select Location'
ProviderPayApprovalsSteps.selectLocation(Location)

'Step 07 : Verify Cost Center List'
ProviderPayApprovalsSteps.verifyCostCenterListDropdown(lstexpectedCostCenters)