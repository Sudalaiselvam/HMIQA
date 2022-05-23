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
		
		String Region=ProviderPayApprovals.getValue('Region',i)
		String PayCycle=ProviderPayApprovals.getValue('PayCycle',i)
		Set<String> expectedLocations = new HashSet<String>()
	
		expectedLocations = PayCycleMappingPageSteps.getLocationMappedtoRegionPayCycle(Region, PayCycle)
		
		Set<String> expectedLocationNames=new HashSet<String>()
			
		expectedLocationNames=LocationPageSteps.getLocationNameWRTLocationShortName(expectedLocations)
		
		ProviderPayApprovalsSteps.gotoProviderPayApprovals()
	
		ProviderPayApprovalsSteps.selectRegion(Region)
	
		ProviderPayApprovalsSteps.selectPayCycle(PayCycle)
		
		ProviderPayApprovalsSteps.verifyLocationList(expectedLocationNames)
	}