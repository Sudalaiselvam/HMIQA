import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.CostCenterPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Expected list of Cost Centers'
Set<String> lstExpectedCostCenter=new HashSet<String>()
lstExpectedCostCenter=CostCenterPageSteps.getListOfCostCentersMappedtoRegionLocation(Region, Location)

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Select Region'
ProviderSetupSteps.selectRegion(Region)

'Step 06 : Select Location'
ProviderSetupSteps.selectLocation(Location)

'Step 07 : Verify List of expected Cost Centers in Primary Cost Center Dropdown'
ProviderSetupSteps.verifyListOfPrimaryCostCenter(lstExpectedCostCenter)

'Step 08 : Verify List of expected Cost Centers in Secondary Cost Center 1 Dropdown'
ProviderSetupSteps.verifyListOfSecondaryCostCenter1(lstExpectedCostCenter)

'Step 09 : Verify List of expected Cost Centers in Secondary Cost Center 2 Dropdown'
ProviderSetupSteps.verifyListOfSecondaryCostCenter2(lstExpectedCostCenter)