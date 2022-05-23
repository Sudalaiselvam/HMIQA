import pages.ProviderSetupSteps as ProviderSetupSteps
import pages.HeaderPageSteps as HeaderPageSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps

HeaderPageSteps.gotoProviderSetup()

ProviderSetupSteps.verifyProviderSetupPageLoaded()

ProviderSetupSteps.setProviderSearch(Provider)

/*
	 * ProviderSetupSteps.verifyProviderDetailsExists('199011')
	 * 
	 * 
	 * 
	 * println ProviderSetupSteps.getProviderEmployeeStatus()
	 * 
	 * println ProviderSetupSteps.getProviderEmployeeType()
	 */
ProviderSetupSteps.editProvider()

HeaderPageSteps.gotoManageProviderContract()

ManageProviderContractSteps.verifyManageProviderContractPageLoaded()

ManageProviderContractSteps.setProviderID(Provider)

ManageProviderContractSteps.editProviderContract()