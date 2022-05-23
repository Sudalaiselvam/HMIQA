package controls

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import core.BaseControl



public class Menu extends BaseControl {
	public Menu(){}
	public Menu(String xpath){
		super(By.xpath(xpath));
	}
	public Menu(By by){
		super(by);
	}
	public Menu(WebElement element){
		super(element);
	}

	public void selectSubMenu(String subMenu) {
		click();
		this.by= By.xpath(String.format("//div[@id='ctl00_MenuUserCntrl1_RadMenu1']//a[.='%s']",subMenu.trim()))
		click();
	}

	public void gotoSubMenu(String subMenu) {
		this.moveToControl()
		//click();
		this.by= By.xpath(String.format("//a[text()='%s']",subMenu))
		this.moveToControl()
		//click();
	}
}
