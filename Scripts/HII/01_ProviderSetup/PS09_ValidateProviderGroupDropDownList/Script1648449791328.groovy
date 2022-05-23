import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderGroupPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Expected list of ProviderGroup'
Set<String> lstProviderGroup=new HashSet<String>();
lstProviderGroup=ProviderGroupPageSteps.getActiveProviderGroup()

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05: Verify Provider Group DropDown List'
ProviderSetupSteps.verifyListOfProviderGroup(lstProviderGroup)