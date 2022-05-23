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

'Step 18 : Navigate to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 19 : Enter Test Data : Provider Search into Provider Search TextBox'
ProviderSetupSteps.setProviderSearch(ProviderSearch)

'Step 20 : Edit Provider'
ProviderSetupSteps.editProvider()

'Step 21 : Enter Personal Details'
ProviderSetupSteps.setFirstName(FirstName)
ProviderSetupSteps.setMiddleName(MiddleName)
ProviderSetupSteps.setLastName(LastName)
ProviderSetupSteps.setSSN(SSN)
ProviderSetupSteps.setDateOfBirth(DateOfBirth)
ProviderSetupSteps.setPreferredContactNo(PreferredContactNo)
ProviderSetupSteps.setSecondaryContactNo(SecondaryContactNo)
ProviderSetupSteps.setEmail(Email)
ProviderSetupSteps.setNPINumber(NPINumber)
ProviderSetupSteps.setStreetAddress(StreetAddress)
ProviderSetupSteps.setCity(City)
ProviderSetupSteps.selectState(State)
ProviderSetupSteps.setZipCode(ZipCode)

'Step 22 : Enter Professional Details'
ProviderSetupSteps.selectRegion(Region)
ProviderSetupSteps.selectLocation(Location)
ProviderSetupSteps.selectPrimaryCostCenter(PrimaryCostCenter)
ProviderSetupSteps.selectProviderGroup(ProviderGroup)
ProviderSetupSteps.selectPositionLevel(PositionLevel)
ProviderSetupSteps.selectPrimarySpecialty(PrimarySpecialty)
ProviderSetupSteps.selectSpecialtyGroup(SpecialtyGroup)
ProviderSetupSteps.setPayrollID(PayrollID)
ProviderSetupSteps.setProviderID(ProviderID)
ProviderSetupSteps.setEMRID(EMRID)
ProviderSetupSteps.setSupervisorLead(SupervisorLead)
ProviderSetupSteps.setDirector(Director)
ProviderSetupSteps.setPracMgrLead(PracMgrLead)
ProviderSetupSteps.setAdminDirector(AdminDirector)
ProviderSetupSteps.setPracticeLocationCostCenterID(PracticeLocationCostCenterID)
ProviderSetupSteps.setSecondaryCostCenter1(SecondaryCostCenter1)
ProviderSetupSteps.setSecondaryCostCenter2(SecondaryCostCenter2)
ProviderSetupSteps.setHiringReq(HiringReq)
ProviderSetupSteps.setCredentialingID(CredentialingID)
ProviderSetupSteps.setBudgetedHours(BudgetedHours)
ProviderSetupSteps.setHourlyRate(HourlyRate)
ProviderSetupSteps.setDEALicense(DEALicense)
ProviderSetupSteps.setDEALicenseRenewalDate(DEALicenseRenewalDate)
ProviderSetupSteps.selectProviderTitle(ProviderTitle)
ProviderSetupSteps.setAccrualAccountNumber(AccrualAccountNumber)
ProviderSetupSteps.setSchedulingID(SchedulingID)
ProviderSetupSteps.setFTE(FTE)
ProviderSetupSteps.setExperienceasofDate(ExperienceasofDate)
ProviderSetupSteps.setExperienceYears(ExperienceYears)
ProviderSetupSteps.setExperienceMonths(ExperienceMonths)
ProviderSetupSteps.selectVisaStatus(VisaStatus)
ProviderSetupSteps.setVisaEndDate(VisaEndDate)

'Step 23 :Enter Status Details'
ProviderSetupSteps.selectEmployeeStatus(EmployeeStatus)
ProviderSetupSteps.setHireDate(HireDate)
ProviderSetupSteps.setTerminationNoticeGivenOn(TerminationNoticeGivenOn)
ProviderSetupSteps.setTerminationDate(TerminationDate)
ProviderSetupSteps.selectEmploymentType(EmploymentType)
ProviderSetupSteps.selectSubCategory(SubCategory)
ProviderSetupSteps.selectEmployeeType(EmployeeType)

'Step 24 : Click Save'
ProviderSetupSteps.clickSave()

'Step 25 : Verify Provider updation'
ProviderSetupSteps.verifyProviderUpdation()
