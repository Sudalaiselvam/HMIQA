package core

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.events.AbstractWebDriverEventListener

import com.google.common.util.concurrent.Uninterruptibles

import configs.Timeout

public class WebEventListener extends AbstractWebDriverEventListener{



	public void beforeClickOn(WebElement element, WebDriver driver) {
		doDelay(driver);
	}

	public void beforeNavigateBack(WebDriver driver) {
		doDelay(driver);
	}


	public void beforeNavigateForward(WebDriver driver) {
		doDelay(driver);
	}


	public void beforeNavigateRefresh(WebDriver driver) {
		doDelay(driver);
	}


	public void beforeNavigateTo(String url, WebDriver driver) {
		doDelay(driver);
	}


	private void doDelay(WebDriver driver, int timeout=Timeout.SCRIPT_DELAY_TIMEOUT_MILISECONDS) {
		Uninterruptibles.sleepUninterruptibly(timeout, TimeUnit.MILLISECONDS);
	}


	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		doDelay(arg2,Timeout.SCRIPT_DELAY_TIMEOUT_MILISECONDS);
	}
}
