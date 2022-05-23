package core

import com.google.common.base.Strings
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import configs.Timeout
import controls.CalendarControl
import controls.ComboBox
import controls.DatePicker
import controls.DropDown
import controls.JavaScriptExecutorControl
import controls.Menu
import controls.Table
import controls.Tabs
import controls.WebElements
import java.text.SimpleDateFormat
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import utils.EncodeUtil
import configs.PageLocatorReader as page
import utils.CommonUtilities
import org.openqa.selenium.support.Color
import internal.GlobalVariable
import pages.LoginPageSteps

public class BaseSteps {
	private IControlFactory controlFactory;

	public BaseSteps(IControlFactory controlFactory){
		this.controlFactory = controlFactory;
	}

	public IControlFactory getControlFactory(){
		return this.controlFactory;
	}

	// ===================== COMMON ACTIONS STEPS =====================

	public String getTextFromControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getText();
	}

	public List<String> getListTextFromControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getListText()
	}

	public void clickEscape() {
		BaseControl control=new BaseControl();
		control.clickEscape();
	}

	public void clickEnter() {
		BaseControl control=new BaseControl();
		control.clickEnter()
	}

	public void clickToControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.click();
	}

	public void clickLabelwithtext(String controlName, String Text,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.clickwithText(Text)
	}

	public void getControlBackgroundColorwithText(String controlName, String Text,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.getBackgroundColorwithText(Text)
	}

	public void clickLabelStartswithtext(String controlName, String Text,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.clickStartswithText(Text)
	}

	public void clickLabelStartswithtextJS(String controlName, String Text,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.clickStartswithTextJS(Text)
	}

	public void clickLabelEndswithtextJS(String controlName, String Text,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.clickEndswithTextJS(Text)
	}

	public void setTextToControl(String controlName, String inputText, String pageName){

		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		if(!Strings.isNullOrEmpty(control.getValue())){
			control.setValueByJS("");
		}
		control.clearText();
		control.sendKeys(String.valueOf(inputText));
	}

	public void moveToControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.moveToControl()
	}

	public Point getLocationControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		Point loc=control.getLocationControl()
		println loc.getX()
		println loc.getY()
		return loc

	}

	public void setTextToMultipleControl(String controlName, String index='1',String inputText, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.setTexttoControl(index,inputText);
	}

	public void setTextToControlJS(String controlName, String inputText, String pageName){

		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		if(!Strings.isNullOrEmpty(control.getValue())){
			control.setValueByJS("");
		}
		control.clearText();
		//control.sendKeys(inputText);
		control.JSsendKeys(inputText);
	}

	public void setEncodeTextToControl(String controlName, String encodeText, String pageName){

		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		if(!Strings.isNullOrEmpty(control.getValue())){
			control.setValueByJS("");
		}
		control.clearText();
		control.sendKeys(EncodeUtil.decode(EncodeUtil.getDefault(encodeText)));
	}

	public void selectSubMenu(String controlName, String subMenu, String pageName) {
		Menu control = controlFactory.initControl(Menu, controlName, pageName);
		control.selectSubMenu(subMenu);
	}

	public void selectItemByTextInComboBox(String controlName, String itemText, String pageName){
		ComboBox control = controlFactory.initControl(ComboBox, controlName, pageName);
		control.selectByText(itemText);

	}

	public void selectItemByContainedTextInComboBox(String controlName, String itemText, String pageName){
		ComboBox control = controlFactory.initControl(ComboBox, controlName, pageName);
		control.selectByContainedText(itemText);
	}

	public void submitToControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.submit();
	}

	public void waitForControlDoesNotDisplay(String controlName, int timeOut = Timeout.WAIT_TIMEOUT_SHORT_SECONDS, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.waitForControlDoesNotDisplay(timeOut);
	}

	public void waitForControlDisplay(String controlName, int timeOut = Timeout.WAIT_TIMEOUT_SHORT_SECONDS, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.waitForControlDisplay(timeOut);
	}

	public void waitForControlClickable(String controlName, int timeOut = Timeout.WAIT_TIMEOUT_SHORT_SECONDS, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.waitForControlClickable(timeOut);
	}

	public boolean isControlClickable(String controlName,int timeOut = Timeout.WAIT_TIMEOUT_SHORT_SECONDS,String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		return control.isControlClickable(timeOut)
	}

	public void waitForProgressBarDisappear() {
		waitForControlDoesNotDisplay("Progress_Image","CommonLocators");
	}

	public void waitforLoadingComplete(String controlName,int timeOut = Timeout.WAIT_TIMEOUT_SHORT_SECONDS,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.waitForControlDoesNotDisplay(timeOut)
	}

	public void uploadFile(String controlName, String filePath, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.uploadFile(filePath);
	}


	// ===================== COMMON ASSERTION STEPS =====================

	public void verifyPageIsLoaded(String url, String errMsg=String.format("The URL %s is NOT changed",url)){
		Browser.waitForUrlChange(url, Timeout.WAIT_TIMEOUT_SHORT_SECONDS);
		AssertSteps.verifyExpectedResult(Browser.getCurrentURL().contains(url),errMsg);
	}

	public void verifyPageHeaderCorrect(String expectedHeader, String errMsg="The page header is NOT correct"){
		AssertSteps.verifyExpectedResult(Browser.getPageHeader().trim().equalsIgnoreCase(expectedHeader),errMsg);
	}

	public void verifyControlDisplayed(String controlName, String pageName, String successMessage='Control displayed',String failureMessage="Control NOT displayed",FailureHandling failureHandling=FailureHandling.CONTINUE_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		//AssertSteps.verifyExpectedResult(control.isDisplayed(),errMsg);
		AssertSteps.verifyActualResult(control.isDisplayed(), successMessage, failureMessage, failureHandling)
	}

	public void verifyControlNotDisplayed(String controlName, String pageName, String errMsg="The control Displayed"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyExpectedResult(!control.isDisplayed(),errMsg);
	}

	public void verifyControlEnabled(String controlName, String pageName, String errMsg="The control does NOT Enable"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyExpectedResult(control.isEnabled(),errMsg);
	}

	public void verifyMainPopUpHasContent(String content,String errMsg="The pop up does NOT show correct content") {
		String popUpContent = getTextFromControl("Main_Popup", "CommonLocators");
		AssertSteps.verifyExpectedResult(popUpContent.contains(content.trim()),errMsg);
		clickToControl("Close_Popup_Button", "CommonLocators")
	}

	public void verifyCheckBoxIsChecked(String controlName, String pageName, String errMsg="The control is NOT checked"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyExpectedResult(control.isSelected(),errMsg);
	}

	public void verifyControlWithTextDisplayed(String controlName, String expectedText, String pageName, String errMsg="Displayed and Text does NOT meet the verification"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName );
		String controlText = control.getText();
		AssertSteps.verifyExpectedResult(control.isDisplayed()&&controlText.equals(expectedText),errMsg);
	}

	public void verifyControlContainedTextDisplayed(String controlName, String expectedText, String pageName, String errMsg="Displayed and Text does NOT meet the verification"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName );
		String controlText = control.getText();
		AssertSteps.verifyExpectedResult(control.isDisplayed()&&controlText.contains(expectedText),errMsg);
	}

	public void verifyOptionIsDefaultInSpanComboBox(String controlName, String optionName, String pageName, String errMsg="The option is not displayed in the combo box"){
		ComboBox control = controlFactory.initControl(ComboBox, controlName,pageName);
		boolean a = control.isOptionDefault(optionName);
		AssertSteps.verifyExpectedResult(control.isOptionDefault(optionName),errMsg);
	}



	// ===================== TABLE STEPS =====================
	// ===================== TABLE COMMON ACTION STEPS =====================

	public String getRowTableCounts(String tableName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getRowCounts().toString();
	}

	public String getTableRowCount(String tableName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getNoofRecords().toString();
	}

	public String getCellTableText(String tableName, String rowIndex="2", String colName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellText(rowIndex, colName);
	}

	public String getCellDataActive(String tableName, String rowIndex="2", String colName,String chkName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellDataActive(rowIndex, colName, chkName)
	}

	//String tableName, String rowIndex="2", String colName, String pageName
	public String getCellTableText_thead(String tableName, String rowIndex="1", String colName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellText_thead(rowIndex, colName);
	}

	public boolean getCellTableRadioButtonChecked(String tableName, String rowIndex="2", String colName,String radioName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellRadioButtonChecked(rowIndex, colName, radioName)

	}

	public String getCellTableTextBackgroundColor(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellTextBackgroundColor(rowIndex, colName);
	}

	public String getCellTableBackgroundColor(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellBackgroundColor(rowIndex, colName);
	}

	public String getBodyTableText(String tableName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getBodyText();
	}

	public List<String> getTableHeadings(String tableName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getTableHeadings();
	}

	public List<String> getTableHeadingsWithSortingTag(String tableName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getTableHeadingsWithSortingTag();
	}

	public List<String> getColumnTableText(String tableName,String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnData(colName)

	}

	public List<String> getColumnTableText_thead(String tableName,String colName, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnData_thead(colName)

	}

	public Collection<String> getColumnTableActiveText(String tableName,String colName,String chkName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnDataActive(colName, chkName)
	}

	public Collection<String> getColumnTableInActive(String tableName,String colName,String chkName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnDataInActive(colName, chkName)
	}

	public List<String> getColumnTableActiveandDpdcy(String tableName,String colName,String chkName,String depName,String depValue, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnDataActiveDependency(colName, chkName, depName, depValue)
	}

	public List<String> getColumnTableDpdcy(String tableName,String colName,String depName,String depValue, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getColumnDataDependency(colName, depName, depValue)
	}

	public String getCellDataWRTDependency(String tableName,String colName,String depName,String depValue, String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellDataDependency(colName, depName, depValue)
	}

	public void clickToCellTableCheckBoxControl(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellCheckBox(rowIndex, colName);
	}

	public boolean isCellTableCheckBoxActive(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.isCellCheckBoxActive(rowIndex, colName)

	}

	public void clickToCellTableCheckBoxWithoutColumnNameControl(String tableName, String rowIndex="2", String pageName){
		//waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellCheckBoxWithoutColumnName(rowIndex);
	}

	public void clickToCellTableLink(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellLink(rowIndex, colName);
	}

	public void clickToCellTableImage(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellImage(rowIndex, colName);
	}

	public String getCellTableImageName(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellImageName(rowIndex, colName);
	}

	public void clickToimgCellDependentTable(String tableName, String colName,String depName,String depValue, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellImageDependency(colName, depName, depValue);
	}

	public void clickToimgCellTable(String tableName,String colName,String colValue, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickCellImageTable(colName,  colValue);
	}

	public void clickToCellTableText(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickToCellText(rowIndex, colName);
	}

	public void clickToCellTableLinkBaseOnAnotherCellDataTable(String tableName, String conditionColumn, String conditionData, String colNameToClick, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		int rows =Integer.parseInt(getRowTableCounts(tableName,pageName));

		for(int i=1;i<=rows;i++){
			if(getCellTableText(tableName, i.toString(),conditionColumn,pageName).contains(conditionData)){
				clickToCellTableLink(tableName, i.toString(), colNameToClick,pageName);
				break;
			}
		}
	}

	public void clickToCellTableTextBaseOnAnotherCellDataTable(String tableName, String conditionColumn, String conditionData, String colNameToClick, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		int rows =Integer.parseInt(getRowTableCounts(tableName,pageName));

		for(int i=1;i<=rows;i++){
			if(getCellTableText(tableName, i.toString(),conditionColumn,pageName).contains(conditionData)){
				clickToCellTableText(tableName, i.toString(), colNameToClick,pageName);
				break;
			}
		}
	}

	public String getCellTextBaseOnAnotherCellDataTable(String tableName, String conditionColumn, String conditionData, String colNameToGetText, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		int rows =Integer.parseInt(getRowTableCounts(tableName,pageName));

		for(int i=1;i<=rows;i++){
			if(getCellTableText(tableName, i.toString(),conditionColumn,pageName).contains(conditionData)){
				return getCellTableText(tableName, i.toString(),colNameToGetText,pageName);
			}
		}
	}

	public void setTextToCellTableControl(String tableName, String rowIndex="2", String colName, String text, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.setCellText(text, rowIndex, colName);
	}

	/*public String setTextToCellTextBoxTableControl(String tableName, String rowIndex="2", String colName, String pageName){
	 waitForTableDataLoaded(tableName,pageName);
	 Table control = controlFactory.initControl(Table, tableName, pageName);
	 control.setCellTextBoxText(rowIndex, colName);
	 }*/

	public String getTextfromCellTextBoxTableControl(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.getCellTextBoxText(rowIndex, colName);
	}

	public String getTextfromCellTextBoxTableControlJS(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.getCellTextBoxTextJS(rowIndex, colName);
	}

	public void waitForTableDataLoaded(String tableName, int timeoutInSeconds = Timeout.WAIT_TIMEOUT_SHORT_SECONDS, String pageName){
		Table control = controlFactory.initControl(Table,tableName,pageName);
		control.waitForDataLoaded(timeoutInSeconds);
	}

	// ===================== TABLE COMMON VERIFY STEPS =====================

	public void verifyTableBodyContainData(String controlName, String expText, String pageName, String errMsg="The expected text is not include in the table"){
		String tableBody = getBodyTableText(controlName, pageName);
		AssertSteps.verifyExpectedResult(tableBody.contains(expText), errMsg)
	}



	/****************************************************************************
	 * 
	 METHODS DEVELOPED BY ANIL JANAPAREDDY   
	 * 
	 ****************************************************************************/

	/*
	 *  COMMON ACTION STEPS
	 */

	public void gotoSubMenu(String itemMenu,String itemSubMenu,String pageName) {
		try {
			BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
			menuControl.moveToControl()
			BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
			subMenuControl.moveToControl()
		}catch(Exception e) {
			Logger.logERROR('Menu:'+itemSubMenu+' Navigation is Failed')
			Browser.navigateToURL(GlobalVariable.URL)
		}
	}

	public void gotoMenuItem(String itemMenu,String itemSubMenu,String pageName) {
		try {
			BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
			menuControl.moveToControl()
			BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
			subMenuControl.moveToControl()
		}catch(Exception e) {
			Logger.logERROR('Menu:'+itemSubMenu+' Navigation is Failed')
			Browser.navigateToURL(GlobalVariable.URL)
		}
	}

	public void gotoMenuItem(String itemMenu,String itemSubMenu,String itemCascadingMenu,String pageName) {
		try {
			BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
			menuControl.moveToControl()
			BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
			subMenuControl.moveToControl()
			BaseControl cascadingMenuControl=controlFactory.initControl(BaseControl, itemCascadingMenu,pageName );
			cascadingMenuControl.moveToControl()
		}catch(Exception e) {
			Logger.logERROR('Menu:'+itemCascadingMenu+' Navigation is Failed')
			Browser.navigateToURL(GlobalVariable.URL)
		}
	}

	public void gotoCascadingMenu(String itemMenu,String itemSubMenu,String itemCascadingMenu,String pageName) {
		try {
			BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
			menuControl.moveToControl()
			BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
			subMenuControl.moveToControl()
			BaseControl cascadingMenuControl=controlFactory.initControl(BaseControl, itemCascadingMenu,pageName );
			cascadingMenuControl.moveToControl()
		}catch(Exception e) {
			Logger.logERROR('Menu:'+itemCascadingMenu+' Navigation is Failed')
			Browser.navigateToURL(GlobalVariable.URL)
			String currentURL=Browser.getCurrentURL();
			if(currentURL.endsWith('Login.aspx')) {
				LoginPageSteps.Login(GlobalVariable.USERNAME, GlobalVariable.PASSWORD, GlobalVariable.ROLE)
			}
		}
	}

	public void openSubMenu_newTab(String itemMenu,String itemSubMenu,String pageName) {
		BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
		try {
			menuControl.moveToControl()
		}catch(Exception e) {
			menuControl.click()
		}
		BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
		subMenuControl.CtrlClick()
		Browser.switchtoLatestWindow();
	}

	public void openCascadingMenu_newTab(String itemMenu,String itemSubMenu,String itemCascadingMenu,String pageName) {
		BaseControl menuControl=controlFactory.initControl(BaseControl, itemMenu,pageName );
		menuControl.moveToControl()
		BaseControl subMenuControl=controlFactory.initControl(BaseControl, itemSubMenu,pageName );
		subMenuControl.moveToControl()
		BaseControl cascadingMenuControl=controlFactory.initControl(BaseControl, itemCascadingMenu,pageName );
		cascadingMenuControl.CtrlClick()
		Browser.switchtoLatestWindow();

	}

	public void selectByVisibleText(String controlName, String option, String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		control.selectByVisibleText(option)
	}

	public void selectRandomOptionDropdownControl(String controlName,String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		control.selectRandomOption()
	}

	public boolean isOptionEqualAfterConditionOptionDropDownControl(String controlName, String option,String conditionOption, String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		return control.isOptionEqualAfterConditionOption(option,conditionOption)
	}

	public void selectFirstOptionDropdownControl(String controlName, int Index=0, String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		control.selectFirstOption(Index)
	}

	public String getOptionBackgroundColor(String controlName, String option, String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		return control.getOptionBackgroundColor(option)
	}

	public String getBackgroundColor(String controlName,String pageName) {
		BaseControl control=controlFactory.initControl(BaseControl, controlName, pageName)
		return control.getBackgroundColor()
	}

	public void selectByVisibleTextStartsWith(String controlName, String option, String pageName) {
		DropDown control=controlFactory.initControl(DropDown, controlName, pageName)
		control.selectByVisibleTextStartsWith(option)
	}

	public String getselectedControlDropdowm(String controlName, String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		//control.scrollIntoViewJS()
		//this.scrollDown()
		return control.getselectedDropDown()
	}

	public boolean isLastOptionSelectedOfControlDropdown(String controlName, String pageName) {
		DropDown control = controlFactory.initControl(DropDown, controlName, pageName);
		return control.isSelectedLastIndex()
	}

	public void scrollIntoView(String controlName, String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		control.scrollIntoViewJS()

	}

	public boolean verifyCurrentURLEndsWith(String URLSuffix) {
		if(Browser.getCurrentURL().endsWith(URLSuffix))
			return true
		else
			return false
	}

	public void verifyControlSelected(String controlName, String expectedText, String pageName, String errMsg="Displayed and Selected does NOT meet the verification"){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName );
		String controlText = control.getselectedDropDown();
		AssertSteps.verifyExpectedResult(control.isDisplayed()&&controlText.equals(expectedText),errMsg);
	}

	public List<String> getlistControlDropdowm(String controlName, String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getlistDropDown()

	}

	public List<Integer> getIntegerListOfControlDropdownOptions(String controlName, String pageName) {
		DropDown control = controlFactory.initControl(DropDown, controlName, pageName);
		return control.getIntegerListOfDropdownOptions()

	}

	public List<String> getControlDropdownListWithIndex(String controlName,String Index='1', String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getDropDownListWithIndex(Index.toInteger())
	}

	public HashSet<String> getControlDropdownUniqueListWithIndex(String controlName,String Index='1', String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getDropDownUniqueListWithIndex(Index.toInteger())
	}

	public void clickTableLink(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.clickCellLink(rowIndex, colName);
	}

	public void getTableLinkName(String tableName, String rowIndex="2", String colName, String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);
		control.getCellLinkName(rowIndex, colName);
	}

	public String getValueFromControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getValue();
	}

	public String getPlaceHolderOfControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getPlaceHolder();
	}

	public String getTitleFromControl(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.getTitle();
	}

	public int getTabsCountFromControl(String controlName,String pageName) {
		Tabs control = controlFactory.initControl(Tabs, controlName, pageName);
		return control.getTabsCount()

	}

	public List<String> getTabsNameFromControl(String controlName,String pageName) {
		Tabs control = controlFactory.initControl(Tabs, controlName, pageName);
		return control.getTabsName()
		//return control.getTabsNameJSExecutor()

	}

	public List<String> getTabsNameFromControlJSExecutor(String controlName,String pageName) {
		Tabs control = controlFactory.initControl(Tabs, controlName, pageName);
		return control.getTabsNameJSExecutor()

	}

	public void selectTabFromControl(String controlName,String tabName,String pageName) {
		Tabs control = controlFactory.initControl(Tabs, controlName, pageName);
		control.selectTab(tabName)
	}

	public void selectTabFromControlJSExecutor(String controlName,String tabName,String pageName) {
		Tabs control = controlFactory.initControl(Tabs, controlName, pageName);
		control.selectTabJSExecutor(tabName)
	}

	public String isChecked(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		if(control.isChecked())
		{
			return 'Checked'
		}else {
			return 'Unchecked'
		}
	}

	public boolean isSelectedCheckboxControl(String controlName, String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.isSelected()
	}

	public void setCheckBox(String controlName,String option, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);

		switch(option) {
			case 'Check':
				if(!control.isChecked())
					control.click();
				break
			case 'Uncheck':
				if(control.isChecked())
					control.click();
				break
		}
	}

	public void InactiveCheckBox(String controlName,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		if(control.isChecked())
			control.click();
	}

	public void ActiveCheckBox(String controlName,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		if(!control.isChecked())
			control.click();
	}

	public int getCountofControl(String controlName,String pageName) {
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.getControlsCount()
	}

	public List<String> getControlsName(String controlName,String pageName) {
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.getControlsName()

	}

	public String getTextControls(String controlName, int index,String pageName){
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.getTextControls(index);
	}

	public String getValueControls(String controlName, int index,String pageName){
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.getValueControls(index);
	}

	public String getSelectedDropDownControls(String controlName, int index,String pageName){
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.getSelectedDropDownControls(index);
	}

	public String isCheckedControls(String controlName, int index,String pageName){
		WebElements control = controlFactory.initControl(WebElements, controlName, pageName);
		return control.isCheckedControls(index);
	}

	public void scrollDown() {
		BaseControl control = new BaseControl();
		control.scrollDown()
	}

	public void scrollToMiddle() {
		BaseControl control = new BaseControl();
		control.scrollToMiddle()
	}

	public void scrollUp() {
		BaseControl control = new BaseControl();
		control.scrollUp()
	}

	public void selectLastOptionDropDownControl(String controlName,String pageName) {
		DropDown control = controlFactory.initControl(DropDown, controlName, pageName);
		if(control.isDisplayed())
			control.selectlastIndex()
	}

	public void setWindowsSize(int percentage) {
		BaseControl control=new BaseControl();
		control.WindowsSetZoomPerc(percentage)
	}

	public void waitForReadyState() {
		BaseControl control=new BaseControl();
		control.waitForPageReady(10000)
	}

	/*
	 *  COMMON ASSERTION
	 */


	public void clickProviderHint(String controlName,String pageName,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		if(control.isDisplayed())
		{
			clickToControl(controlName, page.CMN)
			Logger.logINFO('Provider hints exists for entered details.')
		}
		else
		{
			KeywordUtil.markErrorAndStop('Provider hints details does not exist for entered details.')
		}

	}

	public void verifyProviderHintsDisplayed(String controlName,String pageName,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyActualResult(control.isDisplayed(), 'Provider hints are listed', 'Provider hints are not listed', failureHandling)
		clickToControl(controlName, page.CMN)

	}

	public void verifyProviderHintsNotDisplayed(String controlName,String pageName,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyActualResult(!(control.isDisplayed()), 'Provider hints are not listed', 'Provider hints are listed', failureHandling)

	}

	public void verifyWebElementDisplayed(String controlName, String pageName, String successMsg="WebElement not displayed",String failureMsg='WebElement displayed',FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyActualResult(control.isDisplayed(), successMsg, failureMsg, failureHandling)
	}

	public void verifyWebElementNotDisplayed(String controlName, String pageName, String successMsg="WebElement not displayed",String failureMsg='WebElement displayed',FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		AssertSteps.verifyActualResult(!control.isDisplayed(), successMsg, failureMsg, failureHandling)
	}

	public void verifyLabelWithTextDisplayed(String controlName, String expectedText, String pageName,String successMsg='Expected Label with text message is displayed', String failureMsg="Expected Label with text message is not displayed",FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName );
		String controlText = control.getText();
		AssertSteps.verifyActualResult(control.isDisplayed()&&controlText.equals(expectedText), successMsg, failureMsg, failureHandling)
	}

	public void verifyDropDownSelected(String controlName, String expectedText, String pageName,String successMsg='Drop down displayed and selected with expected option', String failureMsg="Either Drop down is not displayed or not with expected option",FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE){
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName );
		String controlText = control.getselectedDropDown();
		AssertSteps.verifyActualResult(control.isDisplayed()&&controlText.equals(expectedText), successMsg, failureMsg, failureHandling)

	}


	/*
	 * 
	 * Page Object Model Methods
	 * 
	 */

	public void setText(WebElement txtWebElement,String strText) {
		BaseControl control=new BaseControl(txtWebElement);
		control.sendKeys(strText);
	}

	public void click(WebElement txtWebElement) {
		BaseControl control=new BaseControl(txtWebElement);
		control.click();
	}

	public void switchtoMainWindow() {
		Browser.switchtoMainWindow()
		Thread.sleep(250)
	}

	public void switchtoLatestWindow() {
		Browser.switchtoLatestWindow()
		Thread.sleep(250)
	}

	public void closeWindow() {
		Browser.closeCurrentWindow()
	}

	public void verifyApplicationLinks() {
		Browser.verifyLinks()
	}

	public List<String> getApplicationLinks() {
		return Browser.getValidLinks()
	}

	public void refreshWindow() {
		Browser.refreshCurrentPage()
	}

	public void selectDate(String controlName,String strDate,String pageName) {
		DatePicker control=controlFactory.initControl(DatePicker, controlName, pageName)
		control.click()
		control.selectDate(strDate)
	}

	public void selectFirstDayOfCurrentMonth(String controlName,String pageName) {
		DatePicker control=controlFactory.initControl(DatePicker, controlName, pageName)
		control.click()
		control.selectFirstDayofCurrentMonth()
	}

	public void selectCurrentDayOfCurrentMonth(String controlName,String pageName) {
		DatePicker control=controlFactory.initControl(DatePicker, controlName, pageName)
		control.click()
		control.selectDefaultDayofCurrentMonth()
	}


	public void selectMultipleDates(String controlName,List<String> lDate,String pageName) {
		//CalendarControl control = controlFactory.initControl(CalendarControl, controlName, pageName);
		DatePicker control=controlFactory.initControl(DatePicker, controlName, pageName)
		control.click()

		for(String sDate:lDate)
		{
			println sDate
			control.chooseDate(sDate)
		}

	}

	public void chooseDate(String controlName,String sDate,String pageName) {
		DatePicker control=controlFactory.initControl(DatePicker, controlName, pageName)
		control.click()
		control.chooseDate(sDate)

	}

	public boolean WebElementDisplayed(String controlName,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		return control.isDisplayed()
	}

	public boolean WebElementEnabled(String controlName,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		return control.isEnabled()
	}

	/*
	 * 
	 * 
	 */

	public void inputDataMissing(String ErrMessage,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		switch(failureHandling) {
			case FailureHandling.CONTINUE_ON_FAILURE: Logger.setFailureHandling(ErrMessage, failureHandling)
				break;
			case FailureHandling.STOP_ON_FAILURE:Logger.setFailureHandling(ErrMessage,failureHandling)
				break;
			case FailureHandling.OPTIONAL:Logger.setFailureHandling(ErrMessage,failureHandling)
				break;
			default:break;
		}
	}

	public void StepOnFailure(String FailureMessage,FailureHandling failureHandling=FailureHandling.STOP_ON_FAILURE) {
		switch(failureHandling) {
			case FailureHandling.CONTINUE_ON_FAILURE: Logger.setFailureHandling(FailureMessage, failureHandling)
				break;
			case FailureHandling.STOP_ON_FAILURE:Logger.setFailureHandling(FailureMessage,failureHandling)
				break;
			case FailureHandling.OPTIONAL:Logger.setFailureHandling(FailureMessage,failureHandling)
				break;
			default:break;
		}
	}

	public static boolean verifyDateInbetween(String StartDate,String EndDate,String CompareDate) {
		SimpleDateFormat sdf=new SimpleDateFormat('MM/dd/yyyy')
		Date dtStart=sdf.parse(StartDate);
		Date dtEnd=sdf.parse(EndDate);
		Date dtCompare=sdf.parse(CompareDate);
		if((dtCompare.after(dtStart) && dtCompare.before(dtEnd)) || (dtCompare.equals(dtStart)) || (dtCompare.equals(dtEnd))) {
			return true
		}else {
			return false
		}
	}

	public void scrollHorizontalBar(String controlName,int position,String pageName) {
		BaseControl control = controlFactory.initControl(BaseControl, controlName,pageName);
		control.scrollHorizontalBar(position)
	}

	public void clickFrameControl(String frameControl,String controlName,String pageName) {
		WebDriver driver = Browser.getDriverContext();
		driver.switchTo().frame(frameControl)
		BaseControl control=controlFactory.initControl(BaseControl, controlName, pageName)
		control.click()
	}

	public String getFrameCellTableText(String frameControl,String tableName, String rowIndex="1", String colName, String pageName){
		WebDriver driver = Browser.getDriverContext();
		driver.switchTo().frame(frameControl)
		Table control = controlFactory.initControl(Table, tableName, pageName);
		return control.getCellText(rowIndex, colName);
	}

	public HashMap<String,String> getFrameGridFirstRecord(String frameControl,String childframe,String tableName, int HeaderIndex=1, String pageName){
		Map<String,String> gridData=new TreeMap<>()
		WebDriver driver = Browser.getDriverContext();
		driver.switchTo().frame(frameControl)
		driver.switchTo().frame(childframe)
		Table control = controlFactory.initControl(Table, tableName, pageName);
		gridData=control.getGridFirstRecord(HeaderIndex);
		driver.switchTo().defaultContent()
		return gridData
	}

	public HashMap<String,String> getFrameGridFirstRecordDoubleHeader(String frameControl,String childframe,String tableName, int HeaderIndex=1, String pageName){
		Map<String,String> gridData=new TreeMap<>()
		WebDriver driver = Browser.getDriverContext();
		try {
			driver.switchTo().frame(frameControl)
			driver.switchTo().frame(childframe)
			Table control = controlFactory.initControl(Table, tableName, pageName);
			gridData=control.getGridFirstRecordDoubleHeader(HeaderIndex);
		}catch(Exception e) {
			Logger.logERROR('Exception while collecting data from grid')
		}
		finally {
			driver.switchTo().defaultContent()
		}
		return gridData
	}

	public Map<String,String> getFrameGridRecord(String parentFrame=null,String childFrame=null,String Grid,int HeaderIndex=1,int DataIndex=HeaderIndex+1,String pageName){
		Map<String,String> gridData=new TreeMap<>()
		WebDriver driver=Browser.getDriverContext()
		if(parentFrame!=null) {
			driver.switchTo().frame(parentFrame)
			if(childFrame!=null)
				driver.switchTo().frame(childFrame)
		}
		Table control = controlFactory.initControl(Table, Grid, pageName);
		gridData=control.getGridRecordOfReports(HeaderIndex,DataIndex);
		driver.switchTo().defaultContent()
		return gridData

	}

	public Map<String,String> getGridRecord(String Grid,int HeaderIndex=1,int DataIndex=HeaderIndex+1,String pageName){
		Map<String,String> gridData=new TreeMap<>()
		Table control = controlFactory.initControl(Table, Grid, pageName);
		gridData=control.getGridRecordOfReports(HeaderIndex,DataIndex);
		return gridData

	}

	public boolean isChildFrameErrorDisplayed(String parentFrame,String childFrame,String controlName,String pageName) {
		WebDriver driver = Browser.getDriverContext();
		driver.switchTo().frame(parentFrame)
		driver.switchTo().frame(childFrame)
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		boolean blnReportError=control.isDisplayed()
		driver.switchTo().defaultContent()
		return blnReportError
	}

	public List<WebElement> getListOfWebElements(String controlName, String pageName){
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		return control.findElements(control.by)
	}

	public HashMap<String,String> getListOfWebElementsBackgroundColor(String controlName, String pageName){
		HashMap<String,String> hmWebElementBgColor=new HashMap<String,String>();
		List<WebElement> lstWebElements=new ArrayList<WebElement>();
		String bgColorCode,bgColor
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		lstWebElements= control.findElements(control.by)
		for(WebElement selWebElement:lstWebElements) {

			bgColorCode=selWebElement.getCssValue('background-color')
			bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
			hmWebElementBgColor.put(selWebElement.getText(), bgColor)

		}
		return hmWebElementBgColor
	}

	public List<String> getListOfControlsBackgroundColor(String controlName, String pageName){
		List<String> lstColors=new ArrayList<String>()
		List<WebElement> lstWebElements=new ArrayList<WebElement>();
		String bgColorCode,bgColor
		BaseControl control = controlFactory.initControl(BaseControl, controlName, pageName);
		lstWebElements= control.findElements(control.by)
		for(WebElement selWebElement:lstWebElements) {

			bgColorCode=selWebElement.getCssValue('background-color')
			bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
			lstColors.add(bgColor)

		}
		return lstColors
	}

	public void clickControlJavaScriptExecutor(String controlName,String pageName) {
		JavaScriptExecutorControl control=controlFactory.initControl(JavaScriptExecutorControl,controlName, pageName)
		control.click()
	}

	public boolean isControlMandatory(String controlName,String pageName) {
		try {
			WebElements control=controlFactory.initControl(WebElements,controlName, pageName)
			return control.isMandatoryControl()
		}catch(Exception e) {
			return false
		}
	}

	public HashMap<String,String> getGridRecordWithHeading(String tableName,String rowIndex="2",String pageName){
		waitForTableDataLoaded(tableName,pageName);
		Table control = controlFactory.initControl(Table, tableName, pageName);

		HashMap<String,String> grdData=new HashMap<String,String>()
		List<String> lstHeadings=new ArrayList<String>()
		lstHeadings=control.getTableHeadings()
		for(String Heading:lstHeadings) {
			grdData.put(Heading, control.getCellText(rowIndex, Heading))
		}
		return grdData
	}


	public void selectRandomOptionOfDropDownList(String controlName,String pageName){
		DropDown control = controlFactory.initControl(DropDown, controlName,pageName);
		control.selectRandomOptionOfDropDownList()
	}

}
