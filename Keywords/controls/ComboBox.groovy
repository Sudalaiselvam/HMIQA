package controls

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import core.BaseControl



public class ComboBox extends BaseControl {
	public ComboBox(){}
	public ComboBox(String xpath){
		super(By.xpath(xpath));
	}
	public ComboBox(By by){
		super(by);
	}
	public ComboBox(WebElement element){
		super(element);
	}

	public void selectByText(String text,boolean isClickToOpen=true){
		if(isClickToOpen){
			click();
		}
		this.by = By.xpath(String.format("//div[(contains(@id,'DropDown') and contains(@style,'visible')) or (contains(@class,'dropup') and contains(@class,'open')) or (contains(@class,'bs3') and contains(@class,'open'))]//li[normalize-space()='%s']",text.trim()));
		click();
	}

	public void selectByContainedText(String text,boolean isClickToOpen=true){
		if(isClickToOpen){
			click();
		}
		this.by = By.xpath(String.format("//div[(contains(@class,'DropDown') and contains(@style,'visible')) or (contains(@class,'dropup') and contains(@class,'open')) or (contains(@class,'bs3') and contains(@class,'open'))]//li[contains(text(),'%s')]",text.trim()));
		click();
	}

	public String getSelectedText(){
		return getValue();
	}

	public boolean isOptionDefault(String optName){
		return getSelectedText().contains(optName);
	}
}
