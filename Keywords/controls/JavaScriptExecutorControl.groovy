package controls

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebElement
import core.BaseControl
import core.Browser

public class JavaScriptExecutorControl extends BaseControl {

	public JavaScriptExecutorControl(){}
	public JavaScriptExecutorControl(String xpath){
		super(By.xpath(xpath));
	}
	public JavaScriptExecutorControl(By by){
		super(by);
	}
	public JavaScriptExecutorControl(WebElement element){
		super(element);
	}

	public void click() {
		loadControl();
		JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
		js.executeScript("arguments[0].click();", this.element);
	}
}
