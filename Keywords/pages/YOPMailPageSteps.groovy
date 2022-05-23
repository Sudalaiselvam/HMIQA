package pages

import core.BaseSteps
import core.ControlFactory
import testDataTypes.ContractCompModel
import testDataTypes.ContractCostCenter
import testDataTypes.ContractData
import testDataTypes.ContractPayElement
import testDataTypes.ContractYear
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.model.FailureHandling
import core.AssertSteps
import utils.DateTimeUtil
import configs.HIIConstants
import utils.Utilities
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import core.Browser

public class YOPMailPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	private static final String txtLogin='txtLogin'
	private static final String fInbox='fInbox'
	private static final String fMail='fMail'
	private static final String btnMail='btnMail'
	private static final String tblPayRequestDetails='tblPayRequestDetails'
	

	public static void setLogin(String LoginName) {
		getBaseSteps().setTextToControl(txtLogin, LoginName, pageName.YOPMail)
		getBaseSteps().clickEnter()
	}

	public static void openLatestMail() {
		//WebDriver driver = Browser.getDriverContext();
		//WebUI.switchToFrame(driver.find, 20)
		//driver.switchTo().frame
		getBaseSteps().clickToControl(btnMail, pageName.YOPMail)
		
	}
	
	public static void RequestMailDetails() {
		WebUI.switchToFrame(fMail, 20)
		println getBaseSteps().getCellTableText(tblPayRequestDetails, 'Physician', pageName.YOPMail)
		
	}
}
