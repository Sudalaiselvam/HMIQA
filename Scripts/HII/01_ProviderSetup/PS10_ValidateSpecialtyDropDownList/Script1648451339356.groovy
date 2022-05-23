import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.SpecialtyPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Expected list of ProviderGroup'
Set<String> lstExpectedSpecialty=new HashSet<String>();
lstExpectedSpecialty=SpecialtyPageSteps.getSpecialtyName()

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05: Verify Primary Specialty DropDown List'
ProviderSetupSteps.verifyListOfPrimarySpecialty(lstExpectedSpecialty)