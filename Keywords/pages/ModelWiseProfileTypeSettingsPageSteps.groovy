package pages

import core.BaseSteps
import core.ControlFactory
import configs.PageLocatorReader as pageName

public class ModelWiseProfileTypeSettingsPageSteps {

	protected static BaseSteps getBaseSteps(){
		return new BaseSteps(new ControlFactory());
	}

	public static void openModelWiseProfileTypeSettings_newTab() {
		getBaseSteps().openSubMenu_newTab('mnuPayElementConfig', 'mnuModelWiseProfileTypeSettings', pageName.Header)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	private static final String ddlCompensationModel='ddlCompensationModel'
	private static final String lstSelectedMiscProfileTypes='lstSelectedMiscProfileTypes'

	public static void selectCompensationModel(String CompensationModel) {
		getBaseSteps().selectByVisibleText(ddlCompensationModel, CompensationModel, pageName.ModelWiseProfileTypeSettings)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static List<String> getSelectedMiscProfileTypes(){
		getBaseSteps().getlistControlDropdowm(lstSelectedMiscProfileTypes, pageName.ModelWiseProfileTypeSettings)
	}

	public static List<String> getMiscProfileTypesMappedToCompensationModel(String CompensationModel){
		List<String> MiscProfileTypes=new ArrayList<String>()
		openModelWiseProfileTypeSettings_newTab()
		selectCompensationModel(CompensationModel)
		MiscProfileTypes=getSelectedMiscProfileTypes()
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		return MiscProfileTypes
	}
}
