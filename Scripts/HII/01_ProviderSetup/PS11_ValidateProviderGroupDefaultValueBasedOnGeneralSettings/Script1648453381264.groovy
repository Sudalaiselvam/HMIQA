import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.GeneralSettingsSteps
import pages.LocationPageSteps
import pages.ProviderSetupSteps
import configs.HIIConstants

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Provider Group Hierarchy Flag Setting'
String flgProviderGroupHierarchy
flgProviderGroupHierarchy=GeneralSettingsSteps.getProviderGroupHierarchyFlagSetting()

'Get Provider Group Mapped to Location'
String defaultProviderGroup
if(flgProviderGroupHierarchy.equals(HIIConstants.Yes))
	defaultProviderGroup=LocationPageSteps.getProviderGroupMappedToLocation(Location)

'Step 03 : Go to Provider Setup'	
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Select Region'
ProviderSetupSteps.selectRegion(Region)

'Step 06 : Select Location'
ProviderSetupSteps.selectLocation(Location)

'Step 07 : Verify Provider Group Deafult Value'
ProviderSetupSteps.verifyProviderGroupDefaultValue(flgProviderGroupHierarchy,defaultProviderGroup)
	