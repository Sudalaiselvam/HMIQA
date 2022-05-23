import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.ProviderPayApprovalsSteps
import pages.PayCycleMappingPageSteps
import pages.LocationPageSteps

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD,HIIConstants.ROLE_CompensationAdministrator)

	for (int i = 1; i <= ProviderPayApprovals.getRowNumbers(); i++) {
		
		Set<String> expectedLocations = new HashSet<String>()
	
		expectedLocations = PayCycleMappingPageSteps.getLocationMappedtoRegionPayCycle(ProviderPayApprovals.getValue('Region',i), ProviderPayApprovals.getValue('PayCycle',i))
		
		Set<String> expectedLocationNames=new HashSet<String>()
			
		expectedLocationNames=LocationPageSteps.getLocationNameWRTLocationShortName(expectedLocations)
		
		ProviderPayApprovalsSteps.gotoProviderPayApprovals()
	
		ProviderPayApprovalsSteps.selectRegion(ProviderPayApprovals.getValue('Region',i))
	
		ProviderPayApprovalsSteps.selectPayCycle(ProviderPayApprovals.getValue('PayCycle',i))
		
		ProviderPayApprovalsSteps.verifyLocationList(expectedLocationNames)
	}