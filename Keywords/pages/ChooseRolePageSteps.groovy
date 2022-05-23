package pages
import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader


/**
 * @author AnilKumarJanapareddy
 *
 */
public class ChooseRolePageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void selectCompensationAdministrator() {
		getBaseSteps().clickToControl('rdoCompensationAdministrator', PageLocatorReader.ChooseRole)
	}

	public static void selectOrganizationAdmin() {
		getBaseSteps().clickToControl('rdoOrganizationAdmin', PageLocatorReader.ChooseRole)
	}

	public static void selectDirector() {
		getBaseSteps().clickToControl('rdoDirector', PageLocatorReader.ChooseRole)
	}

	public static void selectCompApprover() {
		getBaseSteps().clickToControl('rdoCompApprover', PageLocatorReader.ChooseRole)
	}
}
