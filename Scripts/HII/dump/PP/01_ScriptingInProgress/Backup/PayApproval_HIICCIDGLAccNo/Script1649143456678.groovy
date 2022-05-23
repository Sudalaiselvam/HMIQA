import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderPayApprovalsSteps


String Provider='PaymentProcess05'
String Region='Region-1'
String PayCycle='Sunday to Saturday-2'
String actualPayElement='APP supervision pay'
String actualCostCenter='Cost Center-1123'

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

'Step 11 : Go to Provider Pay Approval '
ProviderPayApprovalsSteps.gotoProviderPayApprovals()

'Step 12 : Enter Provider'
ProviderPayApprovalsSteps.setProvider(Provider)

'Step 13 : Select Region'
ProviderPayApprovalsSteps.selectRegion(Region)

'Step 14 : Select Pay Cycle'
ProviderPayApprovalsSteps.selectPayCycle(PayCycle)

'Step 15 : Select Payroll Status as Approved'
ProviderPayApprovalsSteps.selectPayrollStatusAsApproved()

'Step 16 : Select Year'
//ProviderPayApprovalsSteps.selectYear(Year)

'Step 17 : Select Pay Period'
//ProviderPayApprovalsSteps.selectPayPeriod(PayPeriod)

'Step 18: Click Get Details'
ProviderPayApprovalsSteps.clickGetDetails()

'Step 19: Get Expected GLAccNo & HII CC ID'
HashMap<String,String> PayApprovalHIICCIDGLACCNo=new HashMap<String,String>()
PayApprovalHIICCIDGLACCNo=ProviderPayApprovalsSteps.getGridGLAccNoHIICCID(actualPayElement, actualCostCenter)
String PPAGLAccNo=PayApprovalHIICCIDGLACCNo.get('GLAccNo')
String PPAHIICCID=PayApprovalHIICCIDGLACCNo.get('HIICCID')

println PPAGLAccNo
println PPAHIICCID

