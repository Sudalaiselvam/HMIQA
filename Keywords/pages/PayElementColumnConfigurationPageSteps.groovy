package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class PayElementColumnConfigurationPageSteps {

	protected static BaseSteps getBaseSteps() {
		return new BaseSteps(new ControlFactory());
	}

	//Open Pay Element Column Configuration new tab
	public static void openPayElementColumnConfiguration_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuPayElementColumnConfiguration', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static final String ddlCompensationModel='ddlCompensationModel'
	private static final String ddlPayElement='ddlPayElement'
	private static final String lstSelectedPayElementColumnConfigurations='lstSelectedPayElementColumnConfigurations'

	public static void setCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.PayElementColumnConfiguration)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static void setPayElement(String PayElement) {
		getBaseSteps().selectByVisibleText(ddlPayElement, PayElement, pageName.PayElementColumnConfiguration)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getSelectedPayElementColumns(){
		getBaseSteps().getlistControlDropdowm(lstSelectedPayElementColumnConfigurations, pageName.PayElementColumnConfiguration)
	}

	public static List<String> getPayElementColumnsMappedToCompensationModelPayElement(String CompensationModel,String PayElement){
		List<String> PayElementColumns=new ArrayList<String>()
		openPayElementColumnConfiguration_newTab()
		setCompensationModel(CompensationModel)
		setPayElement(PayElement)
		PayElementColumns=getSelectedPayElementColumns()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return PayElementColumns
	}


}
