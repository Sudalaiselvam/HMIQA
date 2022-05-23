import internal.GlobalVariable
import core.Browser
import pages.LoginPageSteps
import pages.ProviderSetupSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application with Global Variables - USERNAME,PASSWORD,ROLE defined in Profile'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 03 : Go to Provider Setup'
ProviderSetupSteps.gotoProviderSetup()

'Step 04 : Click Create Provider'
ProviderSetupSteps.clickCreateProvider()

'Step 05 : Enter Personal Details'
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

'Step 06 : Enter Professional Details'
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

'Step 07 :Enter Status Details'
ProviderSetupSteps.selectEmployeeStatus(EmployeeStatus)
ProviderSetupSteps.setHireDate(HireDate)
ProviderSetupSteps.setTerminationNoticeGivenOn(TerminationNoticeGivenOn)
ProviderSetupSteps.setTerminationDate(TerminationDate)
ProviderSetupSteps.selectEmploymentType(EmploymentType)
ProviderSetupSteps.selectSubCategory(SubCategory)
ProviderSetupSteps.selectEmployeeType(EmployeeType)

'Step 08: Click Save'
ProviderSetupSteps.clickSave()

'Step 09 : Verify Provider Creation'
ProviderSetupSteps.verifyProvideCreation()

