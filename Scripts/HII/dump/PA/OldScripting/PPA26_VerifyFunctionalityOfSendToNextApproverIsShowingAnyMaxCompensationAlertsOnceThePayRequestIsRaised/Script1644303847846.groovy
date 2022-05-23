import core.Browser as Browser
import pages.LoginPageSteps as LoginPageSteps
import configs.HIIConstants as HIIConstants
import internal.GlobalVariable as GlobalVariable
import pages.ProviderPayRequestSteps as ProviderPayRequestSteps
import pages.ProviderPayApprovalsSteps as ProviderPayApprovalsSteps
import pages.ManageProviderContractSteps as ManageProviderContractSteps
import pages.ProviderSetupSteps as ProviderSetupSteps
import utils.Utilities
import core.AssertSteps

/*
 * String Provider='PayRequest001' String RequestDate='11/06/2021' String
 * CompensationModel='Comp Model 1 - Cost Center-1123-2021' String
 * PayElement='CME ~ 01/01/2021-12/31/2021'
 * 
 * String Compensation
 * 
 * Browser.start(GlobalVariable.URL)
 * LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER,
 * GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)
 * 
 * Compensation=ManageProviderContractSteps.getPayElementThreshold(Provider,
 * RequestDate, CompensationModel, PayElement)
 * 
 * println Compensation
 */
/*
 * if(ProviderPayRequestSteps.ProviderPayRequestCreated(Provider)) {
 * ProviderPayApprovalsSteps.gotoProviderPayApprovals()
 * 
 * ProviderPayApprovalsSteps.setProvider(Provider)
 * 
 * 'Step has to Implement'
 * ProviderPayApprovalsSteps.selectPayRequestCreated(PayElement,ServiceDate)
 * 
 * ProviderPayApprovalsSteps.clickSendtoNextApprover()
 * 
 * 'Step has to Implement' ProviderPayApprovalsSteps.verifyApprovalStatus()
 * 
 * 
 * }
 */
/*
 * String FirstName String LastName String Email String Region String Location
 * String PrimaryCostCenter String PositionLevel String PrimarySpecialty String
 * SpecialtyGroup String PayrollID='PayApproval02' String EmployeeStatus String
 * HireDate
 */
/*
 * ProviderSetupSteps.gotoProviderSetup()
 * ProviderSetupSteps.clickCreateProvider()
 * ProviderSetupSteps.setFirstName(FirstName)
 * ProviderSetupSteps.setLastName(LastName) ProviderSetupSteps.setEmail(Email)
 * ProviderSetupSteps.selectRegion(Region)
 * ProviderSetupSteps.selectLocation(Location)
 * ProviderSetupSteps.selectPrimaryCostCenter(PrimaryCostCenter)
 * ProviderSetupSteps.selectPositionLevel(PositionLevel)
 * ProviderSetupSteps.selectPrimarySpecialty(PrimarySpecialty)
 * ProviderSetupSteps.selectSpecialtyGroup(SpecialtyGroup)
 * ProviderSetupSteps.setPayrollID(PayrollID)
 * ProviderSetupSteps.selectEmployeeStatus(EmployeeStatus)
 * ProviderSetupSteps.setHireDate(HireDate) ProviderSetupSteps.clickSave()
 * ProviderSetupSteps.verifyProvideCreation()
 */
/*
 * ManageProviderContractSteps.gotoManageProviderContract()
 * ManageProviderContractSteps.clickADDCONTRACT()
 * ManageProviderContractSteps.setProvider(PayrollID)
 */
Browser.start(GlobalVariable.URL)

LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)

String Provider = 'PayRequest002'

String PayElement = 'APP supervision pay'

String ServiceDate = '12/02/2021'

String CompensationModel = 'Comp Model 1'

String contractCompensationModel = 'Comp Model 1 - Cost Center-1-2021'

String contractPayElement = 'APP supervision pay ~ 01/01/2021-12/31/2021'



  String Threshold = ManageProviderContractSteps.getPayElementThreshold(Provider, ServiceDate,contractCompensationModel, contractPayElement)
  
  println(Threshold)
  
  ProviderPayRequestSteps.gotoProviderPayRequest()
  
  ProviderPayRequestSteps.setProviderName(Provider)
  
  ProviderPayRequestSteps.selectRequestDate(ServiceDate)
  
  ProviderPayRequestSteps.selectCompensationModel(contractCompensationModel)
  
  ProviderPayRequestSteps.selectPayElement(contractPayElement)
 
HashMap<String,String> PayRequestDetails=new HashMap<String,String>()

PayRequestDetails=ProviderPayRequestSteps.getGridYTDAmount(Provider, CompensationModel, PayElement, ServiceDate)

println PayRequestDetails.get('Status')

println PayRequestDetails.get('YTDAmount')


String PayRequestThreshold = ProviderPayRequestSteps.getPayRequestYTD(ServiceDate, contractCompensationModel, PayElement)

println(PayRequestThreshold)

ProviderPayApprovalsSteps.gotoProviderPayApprovals()

ProviderPayApprovalsSteps.setProvider(Provider)

ProviderPayApprovalsSteps.selectPayElementWithServiceDate(PayElement, ServiceDate)

ProviderPayApprovalsSteps.clickSendtoNextApprover()

String ExceedAmount= Utilities.getDifferenceBTWValues(PayRequestThreshold, Threshold.replace('$', ''))
//(Double.parseDouble(PayRequestThreshold)-Double.parseDouble(Threshold.replace('$', '')))

String expectedMsg=HIIConstants.PPA_MaxThresholdLimitPopupMessage(ProviderPayApprovalsSteps.getGridProviderName(), PayElement, CompensationModel,contractPayElement.split(' ~ ')[1],ExceedAmount)

String actualMsg=ProviderPayApprovalsSteps.getMaxCompensationAndThresholdExceedAlertMessage()

String AssertMsg='Actual:\n '+actualMsg+' and Expected:\n'+expectedMsg

AssertSteps.verifyActualResult(actualMsg.equals(expectedMsg), AssertMsg+': PASS', AssertMsg+': FAIL')

