import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps as PayCycleMappingPageSteps
import pages.LocationPageSteps as LocationPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : get Expected List of Locations Mapped to Region and PayCycle'
Set<String> expectedLocations = new HashSet<String>()
expectedLocations = PayCycleMappingPageSteps.getLocationMappedtoRegionPayCycle(Region, PayCycle)
Set<String> expectedLocationNames = new HashSet<String>()
expectedLocationNames = LocationPageSteps.getLocationNameWRTLocationShortName(expectedLocations)

'Step 04 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 05 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 06 : Select Pay Cycle'
ProviderPayApprovalsSteps.selectPayCycle(PayCycle)

'Step 07 : Verify Locations list'
ProviderPayApprovalsSteps.verifyLocationList(expectedLocationNames)