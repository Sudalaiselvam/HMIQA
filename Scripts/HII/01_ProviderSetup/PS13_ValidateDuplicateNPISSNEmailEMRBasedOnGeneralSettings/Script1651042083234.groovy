import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.GeneralSettingsSteps
import pages.LocationPageSteps
import pages.ProviderSetupSteps
import configs.HIIConstants
import utils.ApplicationUtilities

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Get Allow same NPI SSN Email EMR for Multiple Provider Profiles Flag Setting'
String flgAllowsameNPISSNEmailEMR
flgAllowsameNPISSNEmailEMR=GeneralSettingsSteps.getAllowsameNPISSNEmailEMRformultipleProviderProfiles()

String FirstName=null
String LastName=null
String Email=null
String NPINumber=null
String SSN=null
String EMRID=null
String PayrollID=null

FirstName=ApplicationUtilities.getAutomated_FirstName()
LastName=ApplicationUtilities.getAutomated_LastName()
SSN=ApplicationUtilities.getUnique_Automated_SSN();
Email=ApplicationUtilities.getUnique_Automated_Email()
NPINumber=ApplicationUtilities.getUnique_Automated_NPI();
PayrollID=ApplicationUtilities.getUnique_Automated_PayrollID()
EMRID=ApplicationUtilities.getUnique_Automated_EMRID();

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Enter details to Create Provider'
ProviderSetupSteps.setFirstName(FirstName)
ProviderSetupSteps.setLastName(LastName)
ProviderSetupSteps.setSSN(SSN)
ProviderSetupSteps.setEmail(Email)
ProviderSetupSteps.setNPINumber(NPINumber)
ProviderSetupSteps.selectRegion(Region)
ProviderSetupSteps.selectLocation(Location)
ProviderSetupSteps.selectPrimaryCostCenter(PrimaryCostCenter)
ProviderSetupSteps.selectPositionLevel(PositionLevel)
ProviderSetupSteps.selectPrimarySpecialty(PrimarySpecialty)
ProviderSetupSteps.selectSpecialtyGroup(SpecialtyGroup)
ProviderSetupSteps.setPayrollID(PayrollID)

'Step 06 : Click Save Button'
ProviderSetupSteps.clickSave()

'Step 07 : Verify Provider Creation'
ProviderSetupSteps.verifyProvideCreation()

PayrollID=ApplicationUtilities.getUnique_Automated_PayrollID()


'Step 08 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 09 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 10 : Enter details to Create Provider'
ProviderSetupSteps.setFirstName(FirstName)
ProviderSetupSteps.setLastName(LastName)
ProviderSetupSteps.setSSN(SSN)
ProviderSetupSteps.setEmail(Email)
ProviderSetupSteps.setNPINumber(NPINumber)
ProviderSetupSteps.selectRegion(Region)
ProviderSetupSteps.selectLocation(Location)
ProviderSetupSteps.selectPrimaryCostCenter(PrimaryCostCenter)
ProviderSetupSteps.selectPositionLevel(PositionLevel)
ProviderSetupSteps.selectPrimarySpecialty(PrimarySpecialty)
ProviderSetupSteps.selectSpecialtyGroup(SpecialtyGroup)
ProviderSetupSteps.setPayrollID(PayrollID)

'Step 11 : Click Save Button'
ProviderSetupSteps.clickSave()

'Step 12 : Verify Provider Creation with respect to Flag Setting'
if(flgAllowsameNPISSNEmailEMR.equals(HIIConstants.Yes))
ProviderSetupSteps.verifyProvideCreation()














