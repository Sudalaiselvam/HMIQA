import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.ProviderPayRequestSteps


String Provider='PaymentProcess05'
String actualPayElement='APP supervision pay'
String actualCostCenter='Cost Center-1123'

'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

HashMap<String,String> PayRequestHIICCIDGLACCNo=new HashMap<String,String>()
PayRequestHIICCIDGLACCNo=ProviderPayRequestSteps.getGridGLAccNoHIICCID(Provider, actualPayElement, actualCostCenter)

println PayRequestHIICCIDGLACCNo