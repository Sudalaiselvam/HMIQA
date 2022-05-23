import core.Browser
import configs.HIIConstants
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ManageProviderContractSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login to Application'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER,GlobalVariable.COMPADMIN_PWD,HIIConstants.ROLE_CompensationAdministrator)

'Step 3: Go to Manage Provider Contract'
ManageProviderContractSteps.gotoManageProviderContract()

'Step 4: get Total Facility Count Value'
String TotalFacilityCount=ManageProviderContractSteps.getTotalFacilityCount()

'Step 5: Export Contract Details Excel File'
ManageProviderContractSteps.verifyExportContractDetailsClickFunctionality()

'Step 6: Verify Total Facility Count with Exported Excel File'
ManageProviderContractSteps.verifyTotalFacilityCount(TotalFacilityCount)