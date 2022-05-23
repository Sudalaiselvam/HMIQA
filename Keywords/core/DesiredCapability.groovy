package core

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.edge.EdgeOptions
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.safari.SafariOptions
import org.openqa.selenium.ie.InternetExplorerOptions
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.safari.SafariDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import com.kms.katalon.core.webui.driver.DriverFactory


public class DesiredCapability {

	private static final String downloadPath = System.getProperty("user.dir") + "\\ExportedFiles"

	public static WebDriver setEdgeOptions(){

		System.setProperty('webdriver.edge.driver', DriverFactory.getEdgeChromiumDriverPath());
		EdgeOptions options = new EdgeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadPath);//CustomDownloadPath from global variables
		prefs.put("download.prompt_for_download", false);
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		Map<String, Object> edgeOptions = new HashMap<String, Object>()
		edgeOptions.put('prefs', prefs)
		//		edgeOptions.put('useAutomationExtension', false)
		//		edgeOptions.put('args', ["--no-sandbox", "--disable-dev-shm-usage"])
		edgeOptions.put("excludeSwitches", Collections.singletonList("enable-automation"));

		options.setCapability('ms:edgeChrominum', true)
		options.setCapability('ms:edgeOptions', edgeOptions)

		WebDriver driver = new EdgeDriver(options);
		return driver;
	}

	/**
	 * This method is used to set Desired Capabilities for Chrome
	 * @return WebDriver: This is a driver with setting options
	 */
	public static WebDriver setChromeOptions(){
		System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		options.addArguments("disable-save-password-bubble");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		//options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.TGNORE)


		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver(options);
		//DriverFactory.changeWebDriver(driver);
		return driver;

	}

	/**
	 * This method is used to set Desired Capabilities for Chrome Headless
	 * @return WebDriver: This is a driver with setting options
	 */
	public static WebDriver setChromeHeadlessOptions(){
		System.setProperty('webdriver.chrome.driver', DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions();


		options.addArguments("--disable-gpu");
		options.addArguments("--disable-extensions");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--headless");
		options.addArguments("--headless", "--window-size=1580,1280");
		options.addArguments("disable-infobars");
		options.addArguments("disable-save-password-bubble");
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		//DriverFactory.changeWebDriver(driver);
		return driver;

	}

	public static WebDriver setIEOptions() {
		WebDriver driver = new InternetExplorerDriver()
		return driver;
	}

	public static WebDriver setFireFoxOptions() {
		WebDriver driver = new FirefoxDriver()
		return driver;
	}

	public static WebDriver setSafariOptions() {
		WebDriver driver = new SafariDriver()
		return driver;
	}
}