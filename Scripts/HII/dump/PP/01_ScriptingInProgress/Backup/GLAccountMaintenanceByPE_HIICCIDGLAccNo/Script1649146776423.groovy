import core.Browser
import internal.GlobalVariable
import pages.LoginPageSteps
import pages.GLAccountMaintenanceByPEPageSteps

String Region='Region-1'
String contractLocation='Location 123'
String contractHIICCID='12301'
String contractSpecialty='Allergy'
String contractCompModel='Comp Model 1'
String contractPositionLevel='Provider'
String contractEmployeeType='Employed'

String actualPayElement='APP supervision pay'
String actualCostCenter='Cost Center-1123'
String PayPeriod='01/02/2022 - 01/15/2022'


'Step 01 : Launch Application'
Browser.start(GlobalVariable.URL)

'Step 02 : Login to Application'
LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)

String EffectiveFrom=PayPeriod.split('-')[0].trim()


GLAccountMaintenanceByPEPageSteps.openGLAccountMaintenanceByPE_newTab()

GLAccountMaintenanceByPEPageSteps.selectPayElement(actualPayElement)

GLAccountMaintenanceByPEPageSteps.selectRegion(Region)

GLAccountMaintenanceByPEPageSteps.selectLocation(contractLocation)

GLAccountMaintenanceByPEPageSteps.clickShowDetails()

println GLAccountMaintenanceByPEPageSteps.getGridGLAccountNo(Region, contractLocation, contractHIICCID, contractSpecialty, contractCompModel, contractPositionLevel, contractEmployeeType, EffectiveFrom)