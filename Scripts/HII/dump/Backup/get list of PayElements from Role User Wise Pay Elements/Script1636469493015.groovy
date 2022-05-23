import core.Browser
import pages.RoleUserWisePayElementsSteps
import pages.LoginPageSteps

import internal.GlobalVariable
import configs.HIIConstants

'Step 1: Launch Application'
Browser.start(GlobalVariable.URL)

'Step 2: Login with Compensation Administrator'
LoginPageSteps.Login(GlobalVariable.COMPADMIN_USER, GlobalVariable.COMPADMIN_PWD, HIIConstants.ROLE_CompensationAdministrator)



RoleUserWisePayElementsSteps.openRoleUserWisePayElements_newTab()

RoleUserWisePayElementsSteps.clickRoleWisePayElements()

RoleUserWisePayElementsSteps.selectRoleAsCompensationAdministrator()

RoleUserWisePayElementsSteps.selectRegion('Region-3')

RoleUserWisePayElementsSteps.selectCompensationModel('RVU with Floor')

RoleUserWisePayElementsSteps.clickExpandAll()

List<String> chkPayElements=new ArrayList<String>()
chkPayElements=RoleUserWisePayElementsSteps.getCheckedPayElements()

for(String cPayElement:chkPayElements)
	println cPayElement
