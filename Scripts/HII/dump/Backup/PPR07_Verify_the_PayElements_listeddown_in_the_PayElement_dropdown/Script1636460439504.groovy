import core.Browser as Browser
import internal.GlobalVariable as GlobalVariable
import configs.HIIConstants as HIIConstants
import pages.LoginPageSteps as LoginPageSteps
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.PayElementsSteps as PayElementsSteps
import pages.CostCenterPageSteps as CostCenterPageSteps
import pages.OrgCompModelsPayElementsSteps as OrgCompModelsPayElementsSteps

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

/*
 * List<String> lstUPayElements = new ArrayList<String>()
 * 
 * PayElementsSteps.openPayElements_newTab()
 * 
 * PayElementsSteps.selectPayElementType('Variable')
 * 
 * PayElementsSteps.selectLastPageSize()
 * 
 * lstUPayElements=PayElementsSteps.getUniversalPayElements()
 * 
 * for(String uPayElement:lstUPayElements) println uPayElement
 * 
 * 
 * List<String> lstCMPayElements = new ArrayList<String>()
 * OrgCompModelsPayElementsSteps.openOrgCompModelsPayElements_newTab()
 * OrgCompModelsPayElementsSteps.selectRegion('Region-3')
 * OrgCompModelsPayElementsSteps.selectCompensationModel('RVU with Floor')
 * OrgCompModelsPayElementsSteps.clickShowDetails()
 * OrgCompModelsPayElementsSteps.clickExpandAll()
 * lstCMPayElements=OrgCompModelsPayElementsSteps.getCheckedPayElements()
 * 
 * for(String cmPayElement:lstCMPayElements) println cmPayElement
 */
'Step 3: Get list of Universal expected PayElements'
/*
 * String cModel = CompModel.split(' - ').getAt(0) String cc = CompModel.split('
 * - ').getAt(1) String Region =
 * CostCenterPageSteps.getRegionforCostCenterName(cc.substring(0, cc.length() -
 * 5))
 * 
 * 
 * List<String> lstUPayElements = new ArrayList<String>()
 * 
 * lstUPayElements = ProviderPayRequestSteps.getUniversalPayElements(Region,
 * cModel)
 * 
 * List<String> lstCPayElements = new ArrayList<String>()
 * 
 * lstCPayElements =
 * ProviderPayRequestSteps.getExpectedPayElementsfromContract(Provider,
 * RequestDate, CompModel)
 * 
 * List<String> expectedPayElements = new ArrayList<String>()
 * 
 * expectedPayElements.addAll(lstUPayElements)
 * 
 * expectedPayElements.addAll(lstCPayElements)
 */

List<String> expectedPayElements = new ArrayList<String>()
expectedPayElements=ProviderPayRequestSteps.getExpectedPayElements(Provider, RequestDate, CompModel)

  
  ProviderPayRequestSteps.gotoProviderPayRequest()
  
  ProviderPayRequestSteps.setProviderName(Provider)
  
  ProviderPayRequestSteps.selectRequestDate(RequestDate)
  
  ProviderPayRequestSteps.selectCompensationModel(CompModel)
  
  ProviderPayRequestSteps.verifyPayElementsData(expectedPayElements)
 