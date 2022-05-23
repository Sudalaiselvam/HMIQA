package controls
import core.BaseControl
import core.Browser
import core.HMException
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait
public class WebElements extends BaseControl {

	public WebElements(){}
	public WebElements(String xpath){
		super(By.xpath(xpath));
	}
	public WebElements(By by){
		super(by);
	}
	public WebElements(WebElement element){
		super(element);
	}

	public int getControlsCount(){
		String controlLocator = String.format(xpath);
		return findElements(By.xpath(controlLocator)).size();
	}

	public String getTextControls(int index) {
		String controlLocator=String.format(xpath);
		return findElements(By.xpath(controlLocator)).get(index).getText()
	}

	public String getValueControls(int index) {
		String controlLocator=String.format(xpath);
		return findElements(By.xpath(controlLocator)).get(index).getAttribute('value')
	}

	public String getSelectedDropDownControls(int index) {
		String controlLocator=String.format(xpath);
		Select option=new Select(findElements(By.xpath(controlLocator)).get(index))
		return option.getFirstSelectedOption().getText()
	}

	public boolean isCheckedControls(int index) {
		String controlLocator=String.format(xpath);
		return findElements(By.xpath(controlLocator)).get(index).getAttribute('checked')
	}

	public List<String> getControlsName(){
		List<String> lstControls=new ArrayList<String>();
		String ControlLocator = String.format(xpath);

		for(int i=0;i<getControlsCount();i++) {
			lstControls.add(findElements(By.xpath(ControlLocator)).get(i).text)
		}

		return lstControls
	}

	public boolean isMandatoryControl() {
		String controlLocator=String.format('%s/preceding::span[1]', xpath)
		this.by=By.xpath(controlLocator)
		return getText().equals('*')
	}
}
