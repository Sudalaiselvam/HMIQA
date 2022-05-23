import core.Browser
import internal.GlobalVariable
import configs.HIIConstants
import pages.LoginPageSteps
import pages.CostCenterPageSteps
import pages.ProviderPayRequestSteps
import pages.CommonSteps
import pages.ManageProviderContractSteps

Browser.start(GlobalVariable.URL)
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
/*
 * //CostCenterPageSteps.gotoCostCenter()
 * ProviderPayRequestSteps.gotoProviderPayRequest()
 * CostCenterPageSteps.openCostCenter_newTab()
 * CostCenterPageSteps.setUniversalSearch('20001')
 * CostCenterPageSteps.clickSearch() println CostCenterPageSteps.getRegion()
 * println CostCenterPageSteps.getLocation() CommonSteps.closeCurrentWindow()
 * CommonSteps.backtoMainWindow()
 * 
 * CommonSteps.clickImgOrganization()
 * 
 * ProviderPayRequestSteps.setProviderName('THPZ078')
 */

ManageProviderContractSteps.getContractDetails('PayRequest001')

ProviderPayRequestSteps.gotoProviderPayRequest()

/*
 * HashMap<String,String> hmRL=new HashMap<String,String>()
 * 
 * 
 * hmRL=CostCenterPageSteps.getRegionLocationforHIICCID('20001')
 * 
 * println hmRL.get('Region') println hmRL.get('Location')
 */

