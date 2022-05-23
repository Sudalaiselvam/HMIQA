import core.Browser
import pages.LoginPageSteps
import configs.HIIConstants
import internal.GlobalVariable
import pages.ProviderSetupSteps
import pages.LocationPageSteps

String Region='Region-1'

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Get Expected Active Locations Mapped to Region'
Set<String> lstExpectedLocations=new HashSet<String>()
lstExpectedLocations=LocationPageSteps.getListOfLocationsMappedtoRegion(Region)

'Step 04 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 05 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 06 : Select Region'
ProviderSetupSteps.selectRegion(Region)

'Step 07 : Verify Location DropDown list'
ProviderSetupSteps.verifyLocationList(lstExpectedLocations)

