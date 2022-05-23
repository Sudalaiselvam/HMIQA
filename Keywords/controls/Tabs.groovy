package controls

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import core.BaseControl
import core.Browser
import core.HMException


public class Tabs extends BaseControl {

	public Tabs(){}
	public Tabs(String xpath){
		super(By.xpath(xpath));
	}
	public Tabs(By by){
		super(by);
	}
	public Tabs(WebElement element){
		super(element);
	}



	public int getTabsCount(){
		String tabLocator = String.format(xpath);
		return findElements(By.xpath(tabLocator)).size();
	}

	public List<String> getTabsName(){
		List<String> lstTabs=new ArrayList<String>();
		String tabLocator = String.format(xpath);

		for(int i=0;i<getTabsCount();i++) {
			lstTabs.add(findElements(By.xpath(tabLocator)).get(i).text)
		}

		return lstTabs
	}

	public List<String> getTabsNameJSExecutor(){

		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		List<String> lstTabs=new ArrayList<String>();
		String tabLocator = String.format(xpath);

		for(int i=0;i<getTabsCount();i++) {
			js.executeScript("arguments[0].scrollIntoView()", findElements(By.xpath(tabLocator)).get(i))
			lstTabs.add((js.executeScript("return arguments[0].text;", findElements(By.xpath(tabLocator)).get(i))))
		}

		return lstTabs
	}

	public selectTab(String tabName) {
		WebDriver driver=Browser.getDriverContext()
		JavascriptExecutor js = (JavascriptExecutor)driver

		String tabLocator = String.format(xpath);
		for(int i=0;i<getTabsCount();i++) {
			if((findElements(By.xpath(tabLocator)).get(i).text).equals(tabName)) {

				/*this.element=findElements(By.xpath(tabLocator)).get(i)
				 click();*/

				//println findElements(By.xpath(tabLocator)).get(i)
				findElements(By.xpath(tabLocator)).get(i).click()

				/*	scrollIntoViewJS();
				 action.moveToElement(findElements(By.xpath(tabLocator)).get(i))
				 action.click()
				 action.perform()*/

				/*try {
				 js.executeScript('arguments[0].scrollIntoView(true);', findElements(By.xpath(tabLocator)).get(i))
				 action.moveToElement(findElements(By.xpath(tabLocator)).get(i))
				 this.waitForControlDisplay(10)
				 //Thread.sleep(8000)
				 action.click()
				 action.perform()
				 }catch(Exception e) {}
				 //findElements(By.xpath(tabLocator)).get(i).click()
				 JavascriptExecutor js = (JavascriptExecutor) Browser.getDriverContext();
				 js.executeScript("arguments[0].click()", findElements(By.xpath(tabLocator)).get(i));*/
			}
		}
	}

	public selectTabJSExecutor(String tabName) {
		WebDriver driver=Browser.getDriverContext()
		JavascriptExecutor js = (JavascriptExecutor)driver
		String tabLocator = String.format(xpath);
		for(int i=0;i<getTabsCount();i++) {
			if((findElements(By.xpath(tabLocator)).get(i).text).equals(tabName)) {
				js.executeScript("arguments[0].click()", findElements(By.xpath(tabLocator)).get(i))
			}
		}
	}
}
