package core

import java.util.concurrent.TimeUnit
import org.openqa.selenium.By
import org.openqa.selenium.ElementClickInterceptedException
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait

import com.google.common.util.concurrent.Uninterruptibles

import configs.Timeout
import com.kms.katalon.core.model.FailureHandling
import utils.CommonUtilities
import org.openqa.selenium.support.Color

public class BaseControl extends Browser{

	protected WebElement element;
	protected Actions action;
	protected WebDriverWait wait;
	protected Wait<WebDriver> fluentWait;

	public String xpath =""
	public By by = null;

	public BaseControl(){}

	public BaseControl(By by){
		this.by = by;
		this.xpath = by.toString().substring(by.toString().indexOf(':')+1);
		action = new Actions(Browser.getDriverContext());
	}

	public BaseControl(String xpath){
		this.xpath = xpath;
		this.by = By.xpath(xpath);
		action = new Actions(Browser.getDriverContext());
	}

	public BaseControl(WebElement element){
		this.element = element;
		action = new Actions(Browser.getDriverContext());
	}



	public void loadControl(){
		if(this.by!=null){
			waitForControlDisplay(Timeout.WAIT_TIMEOUT_MEDIUM_SECONDS);
			this.element = highlightControl(this.by);
			//this.scrollIntoViewJS();
		}
	}

	public WebElement highlightControl(By by){
		WebDriver d = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor)d;
		WebElement e;
		int attempts = 0;
		while(attempts < 2) {
			try {
				e = d.findElement(by);
				break;
			}catch(StaleElementReferenceException ex) {
				return;
			}
			attempts++;
		}
		Browser.scrollToView(d, e);
		js.executeScript("arguments[0].style.border='2px dashed green'", e);
		return e;
	}

	public setValueByJS(String value){
		loadControl();
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].value=arguments[1];", this.element,value);
	}


	// ========================= Wait Control method ZONE  =========================


	public void waitForPageReady(int timeoutInSeconds) {
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, timeoutInSeconds);
		this.wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
		//<Boolean> -> { return  js.executeScript("return document.readyState").equals("complete")}

	}

	public void waitForControlPresentOnDOM(int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.presenceOfElementLocated(this.by));
		}catch(Throwable e){
			throw new HMException(String.format("No element %s presents on DOM", this.by),e);
		}
	}

	public void waitForControlDisplay(int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.visibilityOfElementLocated(this.by));
		}catch(Throwable e){
			throw new HMException(String.format("No element %s displayes", this.by),e);
		}
	}

	public void waitForControlClickable(int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
		}catch(Throwable e){
			throw new HMException(String.format("Element %s is not Clickable", this.by),e);
		}
	}


	public boolean isControlClickable(int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.elementToBeClickable(this.by));
			return true
		}catch(Throwable e){
			return false
		}
	}

	public void waitForControlDoesNotDisplay(int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.invisibilityOfElementLocated(this.by));
		}catch(Throwable e){
			throw new HMException(String.format("The element %s still displayes", this.by),e);
		}
	}

	public void waitForControlAttributeChange(String attribute, String expectedValue, int timeoutInSeconds){
		try{
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(new ExpectedCondition<Boolean>() {
						public Boolean apply(WebDriver driver) {
							WebElement element = driver.findElement(By.xpath("xpath"));
							String actualValue = element.getAttribute(attribute);
							if(actualValue.equals(expectedValue))
								return true;
							else
								return false;
						}
					});
		}catch(Throwable e){
			throw new HMException(String.format("No element %s displayes", this.by),e);
		}
	}




	// ========================= Control action method ZONE  =========================


	public void click(){
		loadControl();
		int attempts = 0;
		while(attempts < 2) {
			try {

				this.element.click();

				break;
			}catch(ElementClickInterceptedException ex) {

				return;
			}
			attempts++;
		}
	}

	public void clickwithText(String Text){
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements)
		{
			if(lwebElement.getText().equals(Text))
			{
				lwebElement.click();
				break;
			}
		}
	}

	public String getBackgroundColorwithText(String Text) {
		String bgColorCode,bgColor
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)

		for(WebElement lwebElement:lstWebElements)
		{
			if(lwebElement.getText().equals(Text))
			{
				bgColorCode=lwebElement.getCssValue('background-color')
				bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
				break;
			}
		}

		return bgColor
	}

	public void clickStartswithText(String Text){
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements)
		{
			if(lwebElement.getText().startsWith(Text))
			{
				lwebElement.click();
				break;
			}
		}
	}

	public void clickStartswithTextJS(String Text){
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements)
		{
			if(lwebElement.getText().startsWith(Text))
			{
				JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
				js.executeScript("arguments[0].click();", lwebElement);
				break;
			}
		}
	}

	public void clickEndswithTextJS(String Text){
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements)
		{
			if(lwebElement.getText().endsWith(Text))
			{
				JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
				js.executeScript("arguments[0].click();", lwebElement);
				break;
			}
		}
	}





	public void CtrlClick() {
		loadControl();
		this.element.sendKeys(Keys.LEFT_CONTROL+Keys.ENTER)
		this.element.sendKeys(Keys.ESCAPE)


	}



	public void clearText(){
		loadControl();
		this.element.sendKeys(Keys.END);
		this.element.sendKeys(Keys.SHIFT+Keys.HOME);
		this.element.sendKeys(Keys.DELETE);
		this.element.clear();
	}

	public void sendKeys(String text){
		click();
		for(char c: text.toCharArray()){
			Uninterruptibles.sleepUninterruptibly(Timeout.SEND_KEY_TIMEOUT_MILISECONDS, TimeUnit.MILLISECONDS);
			this.element.sendKeys(""+ c);
		}
	}

	public void submit(){
		loadControl();
		this.element.submit();
	}

	public String getText(){
		loadControl();
		return this.element.getText();

	}

	public String getTextBackgroundColor() {
		loadControl();
		String eStyle=this.element.getAttribute('style')
		return ((eStyle.replace('background-color:', '')).replace(';', '')).replace('border: 2px dashed green', '').trim()

	}

	public String getBackgroundColor() {
		String bgColorCode,bgColor
		loadControl();
		bgColorCode=element.getCssValue('background-color')
		bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
		return bgColor
	}

	public List<String> getListText(){
		List<String> lstText=new ArrayList<String>()
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements)
		{
			lstText.add(lwebElement.getText())
		}

		return lstText
	}

	public String getValue(){
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		return (String) js.executeScript("return arguments[0].value;", this.element);
	}

	public String getPlaceHolder(){
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		return (String) js.executeScript("return arguments[0].placeholder;", this.element);
	}

	public String getTitle(){
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		return (String) js.executeScript("return arguments[0].title;", this.element);
	}


	public void JSclick(){
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		js.executeScript("arguments[0].click();", this.element);
	}

	public void waitForReadyStateJS(){
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		js.executeScript("return document.readyState").equals("complete")


	}

	public void JSsendKeys(String text) {
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		js.executeScript("arguments[0].setAttribute('value','arguments[1]');", this.element,text);
	}

	//	public WebElement findElement(By by){
	//		WebElement eFound;
	//		loadControl();
	//		try{
	//			eFound = this.element.findElement(by);
	//		}catch(Throwable e){
	//			throw new HMException(String.format("No Element '%s' is found.",by),e);
	//		}
	//		return eFound;
	//	}

	public List<WebElement> findElements(By by){
		//loadControl();

		WebDriver d = Browser.getDriverContext();

		int attempts = 0;
		while(attempts < 2) {
			try {
				return d.findElements(by);
				break;
			}catch(Exception e) {
				return;
			}
			attempts++;
		}
	}

	public WebElement findElement(By by) {
		WebDriver d = Browser.getDriverContext();

		int attempts = 0;
		while(attempts < 2) {
			try {
				return d.findElement(by);
				break;
			}catch(Exception e) {
				return;
			}
			attempts++;
		}
	}

	public void uploadFile(String path){
		if(isExisted()){
			loadControl();
			this.element.sendKeys(path);
		}
	}

	public void moveToControl() {
		loadControl();
		action.moveToElement(this.element)
		action.click().build().perform()
	}

	public void moveToLocation(xOffset,yOffset) {
		loadControl();
		action.moveByOffset(xOffset, yOffset)
		action.click().build().perform()
	}

	// ========================= Check status of control method ZONE  =========================

	public Point getLocationControl() {
		loadControl();
		return element.getLocation()
	}


	public boolean isExisted(){
		try{
			if(by!=null){
				//Browser.setImplicitlyWait(timeOut);
				int elementFound = findElements(this.by).size();
				return elementFound > 0 ? true : false;
			}
			return element != null ? true : false;
		}catch(Throwable e){
			//throw new HMException("The %s control is NOT existed in %s with %s",this.by,Browser.getCurrentURL(),e);
			return false;
		}
		//		finally{
		//			Browser.setImplicitlyWait(timeOut);
		//		}
	}


	public boolean isDisplayed(){
		if(isExisted()){
			try {
				//loadControl();
				this.element = highlightControl(this.by);
				return this.element.displayed;
			}catch (Exception e) {
				return false;
			}
		}else{
			return false;
		}
	}

	public boolean isEnabled(){
		if(isDisplayed()){
			return this.element.enabled;
		}else{
			return false;
		}
	}

	public boolean isSelected(){

		if(isDisplayed()){
			return this.element.selected;
		}else{
			return false;
		}
	}

	//=============================== Methods by ANIL JANAPAREDDY =====================================

	public String getselectedDropDown() {
		loadControl();
		Select option=new Select(this.element)
		return option.getFirstSelectedOption().getText()
	}

	public List<String> getlistDropDown(){
		loadControl();
		List<String> Dropdownlist = new ArrayList<String>();
		Select option = new Select(this.element);
		List<WebElement> Options = option.getOptions();
		for (int i = 0; i < Options.size(); i++) {
			Dropdownlist.add(Options.get(i).getText().trim());
		}
		return Dropdownlist;
	}

	public boolean isChecked() {
		loadControl();
		this.waitForControlDisplay(10)
		this.element.getAttribute('checked')
	}

	public scrollIntoViewJS(){
		//loadControl();
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].scrollIntoView()", this.element);
	}

	public void scrollDown() {
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollToMiddle() {
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0, (document.body.scrollHeight)/2)");
		js.executeScript("window.scrollTo(0, 250)");
	}

	public void scrollUp() {
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	public void clickEscape() {
		action = new Actions(Browser.getDriverContext());
		action.sendKeys(Keys.ESCAPE).build().perform();
	}

	public void clickEnter() {
		action = new Actions(Browser.getDriverContext());
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void WindowsSetZoomPerc(int percentage) {
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='"+percentage+"%'");
	}

	public void setTexttoControl(String index,String Text) {
		/*JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		 js.executeScript("arguments[0].setAttribute('value','arguments[1]');", findElements(by).get(Integer.parseInt(index)),Text);*/

		findElements(by).get(Integer.parseInt(index)).clear()
		findElements(by).get(Integer.parseInt(index)).sendKeys(Text)

	}

	public List<String> getDropDownListWithIndex(int index='1'){
		loadControl();
		List<String> Dropdownlist = new ArrayList<String>();
		Select option = new Select(findElements(by).get(index));
		List<WebElement> Options = option.getOptions();
		for (int i = 0; i < Options.size(); i++) {
			Dropdownlist.add(Options.get(i).getText().trim());
		}
		return Dropdownlist;
	}

	public HashSet<String> getDropDownUniqueListWithIndex(int index='1'){
		loadControl();
		Set<String> Dropdownlist = new HashSet<String>();
		Select option = new Select(findElements(by).get(index));
		List<WebElement> Options = option.getOptions();
		for (int i = 0; i < Options.size(); i++) {
			Dropdownlist.add(Options.get(i).getText().trim());
		}
		return Dropdownlist;
	}

	public void scrollHorizontalBar(int position) {
		click();
		Actions move=new Actions(Browser.getDriverContext())
		move.moveToElement(element).clickAndHold();
		move.moveByOffset(position, 0)
		move.release()
		move.perform()
	}





}
