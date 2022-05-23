import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.SpecialtyPageSteps as SpecialtyPageSteps
import pages.CompensationModelSpecialtyMappingPageSteps as CompensationModelSpecialtyMappingPageSteps

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

'Step 03 : Get expected list of Specialty mapped to Region and Compensation Model'
List<String> lstexpectedSpecialty = new ArrayList<String>()
lstexpectedSpecialty = CompensationModelSpecialtyMappingPageSteps.getSpecialtyMappedWRTRegionCompensationModel(Region, CompensationModel)

'Step 04 : Go to Provider Pay Approvals'
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 05 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 06 : Select Compensation Model'
ProviderPayApprovalsSteps.selectCompensationModel(CompensationModel)

'Step 07 : verify Specialty List'
ProviderPayApprovalsSteps.verifySpecialtyListDropdown(lstexpectedSpecialty)