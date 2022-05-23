import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderSetupSteps
import utils.ApplicationUtilities

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Set Personal Details - First Name'
ProviderSetupSteps.setAutomatedFirstName()

'Step 06 : Set Personal Details - Last Name'
ProviderSetupSteps.setAutomatedLastName()

'Step 07 : Set Personal Details - E-mail'
ProviderSetupSteps.setAutomatedEmail()

'Step 08 : Select First Eligible Region'
ProviderSetupSteps.selectFirstEligibleRegion(2)

'Step 09 : Select First Eligible Location'
ProviderSetupSteps.selectFirstEligibleLocation(1)

'Step 10 : Select First Eligible Primary Cost Center'
ProviderSetupSteps.selectFirstEligiblePrimaryCostCenter(1)

'Step 11 : Select Position Level as Provider'
ProviderSetupSteps.selectPositionLevelAsProvider()

'Step 12 : Select First Eligible Primary Specialty'
ProviderSetupSteps.selectFirstEligiblePrimarySpecialty(1)

'Step 13 : Select First Eligible Specialty Group'
ProviderSetupSteps.selectFirstEligibleSpecialtyGroup(1)


String PayrollID=ApplicationUtilities.getUnique_Automated_PayrollID()
'Step 14 : Set Professional Details - Payroll ID'
ProviderSetupSteps.setPayrollID(PayrollID)

'Step 15 : Set Employee Status as Hired'
ProviderSetupSteps.selectEmployeeStatusAsHired()

'Step 16 : Click Save Button'
ProviderSetupSteps.clickSave()

'Step 17 : Verify Provider Creation'
ProviderSetupSteps.verifyProvideCreation()

'Step 03 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Enter Test Data : Provider Search into Provider Search TextBox'
ProviderSetupSteps.setProviderSearch(PayrollID)

'Step 05 : Edit Provider'
ProviderSetupSteps.editProvider()

'Step 06 : Click Delete'
ProviderSetupSteps.clickDelete()

ProviderSetupSteps.verifyProvideDeletion()
