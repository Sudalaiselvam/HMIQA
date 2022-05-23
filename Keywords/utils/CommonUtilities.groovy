package utils

import core.BaseSteps
import core.ControlFactory
import core.Logger
import configs.PageLocatorReader as pageName
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class CommonUtilities {

	protected static BaseSteps getBaseSteps() {
		return new BaseSteps(new ControlFactory());
	}

	public static void CloseCurrentWindow_SwitchToMainWindow() {
		getBaseSteps().closeWindow()
		getBaseSteps().switchtoMainWindow()
		getBaseSteps().clickToControl('imgOrganization', pageName.CMN)
		getBaseSteps().waitforLoadingComplete('imgLoading', pageName.CMN)
	}

	public static String getColorNameForHexCode(String HexCode) {
		String ColorName
		switch(HexCode) {
			case '#bcbcbc':
				ColorName='Gray'
				break
			case '#ffffff':
				ColorName='White'
				break
			case '#f7b768':
				ColorName='Golden Cream (Orange Color Family)'
				break
			case '#e04607':
				ColorName='Brick Color (Trinidad)'
				break
			default:
				Logger.logWARNING(HexCode+' color code is not defined')
				break
		}
		return ColorName
	}

	public static int generateRandomInteger(int Range) {
		int i=2
		Random rand=new Random()

		if(Range<=2)
			return rand.nextInt(Range)

		return rand.nextInt(Range-i)+i
	}
}
