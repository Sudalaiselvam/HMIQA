package core

import java.util.concurrent.TimeUnit
import org.apache.commons.io.FileUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.OutputType
import org.openqa.selenium.TakesScreenshot
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.events.EventFiringWebDriver
import com.google.common.base.Strings
import com.google.common.util.concurrent.Uninterruptibles
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import configs.Path
import configs.Timeout
import configs.HIIConstants
import internal.GlobalVariable
import utils.DateTimeUtil
import utils.PlatformUtil





public class Browser {

	private static WebDriver driver = null


	protected static WebDriver getDriverContext(){
		return this.driver;
	}

	protected static void setDriverContext(WebDriver driver){
		DriverFactory.changeWebDriver(driver);
	}

	public static String getPageTitle(){
		return Browser.getDriverContext().getTitle();
	}

	public static String getPageHeader(){
		JavascriptExecutor js = (JavascriptExecutor)getDriverContext();
		String text = js.executeScript("return document.getElementsByTagName(\"h1\")[0].textContent");
		return text.replaceAll("\\s+"," ").trim();
	}

	public static void refreshCurrentPage(){
		Browser.getDriverContext().navigate().to(Browser.getDriverContext().getCurrentUrl());
	}

	public static String getCurrentURL(){
		return Browser.getDriverContext().currentUrl;
	}

	public static void quitDriver(){
		if(Browser.getDriverContext()!=null){
			Browser.getDriverContext().quit();
		}
	}

	public static void waitForUrlChange(String url, int seconds){

		double miliSeconds = seconds * 1000;
		String a = Browser.getCurrentURL();
		while (!Browser.getCurrentURL().contains(url)){
			Uninterruptibles.sleepUninterruptibly(Timeout.URL_CHANGE_TIMEOUT_MILISECONDS, TimeUnit.MILLISECONDS);
			miliSeconds = miliSeconds - 300;
			if(miliSeconds<0){
				KeywordUtil.logger.logWarning(String.format("The url %s is NOT changed after %s seconds", url,seconds))
				break;
			}
		}
	}

	public static void scrollToView(WebDriver d, WebElement e){
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].scrollIntoView(false);", e);
	}

	public static void setImplicitlyWait(int timeInSeconds){
		Browser.getDriverContext().manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS)
	}

	public static void maximizeWindow(){
		Browser.getDriverContext().manage().window().maximize();
	}

	public static void navigateToURL(String url){
		Browser.getDriverContext().navigate().to(url);
	}

	public static void start(String url){

		WebUIDriverType executedBrowser = DriverFactory.getExecutedBrowser();
		switch(executedBrowser) {
			case WebUIDriverType.EDGE_CHROMIUM_DRIVER:
				this.driver = configEventListener(DesiredCapability.setEdgeOptions());
				setDriverContext(driver);
				break;
			case WebUIDriverType.CHROME_DRIVER:
				this.driver = configEventListener(DesiredCapability.setChromeOptions());
				setDriverContext(driver);
				break;
			case WebUIDriverType.HEADLESS_DRIVER://chrome headless
				this.driver = configEventListener(DesiredCapability.setChromeHeadlessOptions());
				setDriverContext(driver);
				break;
			case WebUIDriverType.EDGE_DRIVER:
				this.driver = configEventListener(DesiredCapability.setEdgeOptions());
				setDriverContext(driver);
				break;
			case WebUIDriverType.IE_DRIVER:
				this.driver = configEventListener(DesiredCapability.setEdgeOptions());
				setDriverContext(driver);
				break;
			case WebUIDriverType.FIREFOX_DRIVER:
				break;
			case WebUIDriverType.SAFARI_DRIVER:
				break;
		}

		Browser.navigateToURL(url);
		Browser.setImplicitlyWait(Timeout.IMPLICIT_WAIT_TIME_OUT_SECONDS);
		Browser.maximizeWindow();
	}

	public static void takeScreenshot(String storageFolderPath = Path.SCREENSHOT_PATH ){
		try{
			String folderPath = PlatformUtil.getFolderProjectPath(storageFolderPath);
			String tcID =String.format("%s_%s" ,GlobalVariable.TC_NAME,DriverFactory.getExecutedBrowser().toString());
			TakesScreenshot scrShot =(TakesScreenshot)Browser.getDriverContext();
			String fileName="";
			String dateTime = DateTimeUtil.getDateTime("MMM_dd_yyyy")

			if(!Strings.isNullOrEmpty(tcID)){
				if(PlatformUtil.isWindows()) {
					tcID= tcID.replace('/', '\\');
				}
				fileName = String.format("%s%s_%s_%s%s",folderPath,tcID,dateTime,System.currentTimeMillis().toString(),".png")
			}else{
				fileName = String.format("%s_%s_%s%s",folderPath,dateTime,System.currentTimeMillis().toString(),".png")
			}

			File srcImage=scrShot.getScreenshotAs(OutputType.FILE);
			File destImage=new File(fileName);
			FileUtils.copyFile(srcImage, destImage);
		}catch(Throwable e){
			throw new HMException("The screenshot can NOT be taken", e);
		}
	}

	private static EventFiringWebDriver configEventListener(WebDriver driver) {
		EventFiringWebDriver eventFiringListener =new EventFiringWebDriver(driver);
		WebEventListener webEventListener=new WebEventListener();
		return eventFiringListener.register(webEventListener);
	}

	public static void switchtoMainWindow() {
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0))
	}

	public static void switchtoLatestWindow() {
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1))
	}

	public static void closeCurrentWindow() {
		driver.close();
	}

	public static void verifyLinks() {
		List<WebElement> links=driver.findElements(By.tagName('a'))
		for(WebElement link:links)
			verifyLinks(link.getAttribute('href'))
	}

	public static void verifyLinkNavigation() {
		List<WebElement> links=driver.findElements(By.tagName('a'))
		for(WebElement link:links)
			gotoLinkPage(link.getAttribute('href'))
	}

	public static void verifyLinks(String linkURL) {
		if(!HIIConstants.getExcludeLinks().contains(linkURL))
		try {
			URL url=new URL(linkURL)
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection()
			httpURLConnect.setConnectTimeout(5000)
			httpURLConnect.connect()
			if(httpURLConnect.getResponseCode()>=400) {
				Logger.logWARNING(linkURL+' - '+httpURLConnect.getResponseMessage()+ ' is a broken link.')
			}else {
				Logger.logINFO(linkURL+' - '+httpURLConnect.getResponseMessage())
			}
		}catch(Exception e) {
		}
	}

	public static List<String> getValidLinks() {
		List<String> lstLinks=new ArrayList<>()
		List<WebElement> links=driver.findElements(By.tagName('a'))
		for(WebElement link:links) {

			//if(isValidLink(link.getAttribute('href')))
			lstLinks.add(link.getAttribute('href'))
		}
		println lstLinks
		return lstLinks
	}

	public static boolean isValidLink(String linkURL){
		try {
			URL url=new URL(linkURL)
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection()
			httpURLConnect.setConnectTimeout(5000)
			httpURLConnect.connect()
			if(!httpURLConnect.getResponseCode()>=400)
				return true
		}catch(Exception e) {
		}
	}

	public static void gotoLinkPage(String linkURL) {
		try {

			URL url=new URL(linkURL)
			HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection()
			httpURLConnect.setConnectTimeout(5000)
			httpURLConnect.connect()
			if(httpURLConnect.getResponseCode()>=400) {
				Logger.logWARNING(linkURL+' - '+httpURLConnect.getResponseMessage()+ ' is a broken link.')
			}else {
				Logger.logINFO(linkURL+' - '+httpURLConnect.getResponseMessage())
			}
		}catch(Exception e) {
		}
	}
}
