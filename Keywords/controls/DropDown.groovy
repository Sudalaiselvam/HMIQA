package controls

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import core.BaseControl
import utils.CommonUtilities

import org.openqa.selenium.support.Color



public class DropDown extends BaseControl {
	public DropDown(){}
	public DropDown(String xpath){
		super(By.xpath(xpath));
	}
	public DropDown(By by){
		super(by);
	}
	public DropDown(WebElement element){
		super(element);
	}

	public void selectByVisibleText(String option) {
		loadControl();
		Select options=new Select(this.element)
		options.selectByVisibleText(option)
	}

	public void selectRandomOption() {
		loadControl();
		Select options=new Select(this.element)
		int option=CommonUtilities.generateRandomInteger(options.getOptions().size())
		options.selectByIndex(option)
	}

	public void selectRandomOptionOfDropDownList() {
		loadControl();
		List<WebElement> lstWebElements=this.findElements(this.by)
		for(WebElement lwebElement:lstWebElements) {
			String id=lwebElement.getAttribute('id')
			println id
			this.element=findElement(By.id(id))
			Select options=new Select(element)
			int option=CommonUtilities.generateRandomInteger(options.getOptions().size())
			options.selectByIndex(option)
		}
	}

	public void selectByVisibleTextStartsWith(String option) {
		loadControl();
		Select ddloption = new Select(this.element);
		List<WebElement> Options = ddloption.getOptions();
		for (int i = 0; i < Options.size(); i++) {

			if(Options.get(i).getText().trim().startsWith(option)) {
				ddloption.selectByVisibleText(Options.get(i).getText().trim())
				break
			}
		}
	}

	public String getOptionBackgroundColor(String option) {
		String bgColorCode,bgColor
		loadControl();
		Select ddloption = new Select(this.element);
		List<WebElement> Options = ddloption.getOptions();
		for (int i = 0; i < Options.size(); i++) {

			if(Options.get(i).getText().trim().startsWith(option)) {

				//String eStyle=Options.get(i).getAttribute('style')
				//bgColor=((eStyle.replace('background-color:', '')).replace(';', '')).replace('border: 2px dashed green', '').trim()
				bgColorCode=Options.get(i).getCssValue('background-color')
				bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
				break
			}
		}
		return bgColor
	}

	public String getBackgroundColor() {
		String bgColorCode,bgColor
		loadControl();
		Select ddloption = new Select(this.element);
		List<WebElement> Options = ddloption.getOptions();
		for (int i = 0; i < Options.size(); i++) {

			if(Options.get(i).getText().trim().startsWith(option)) {

				//String eStyle=Options.get(i).getAttribute('style')
				//bgColor=((eStyle.replace('background-color:', '')).replace(';', '')).replace('border: 2px dashed green', '').trim()
				bgColorCode=Options.get(i).getCssValue('background-color')
				bgColor=CommonUtilities.getColorNameForHexCode(Color.fromString(bgColorCode).asHex())
				break
			}
		}
		return bgColor
	}

	public void selectByValue(String option) {
		loadControl();
		Select options=new Select(this.element)
		options.selectByValue(option)
	}

	public void selectByIndex(int index) {
		loadControl();
		Select options=new Select(this.element)
		options.selectByIndex(index)
	}

	public void selectlastIndex() {
		loadControl();
		Select options=new Select(this.element)
		options.selectByIndex(options.getOptions().size()-1)
	}

	public void selectFirstOption(int Index=0) {
		loadControl();
		Select options=new Select(this.element)
		options.selectByIndex(Index)
	}

	public String getselectedDropDown() {
		loadControl();
		Select option=new Select(this.element)
		return option.getFirstSelectedOption().getText()
	}

	public boolean isSelectedLastIndex() {
		boolean blnLastIndex
		loadControl();
		Select option=new Select(element)
		int lastIndex=option.getOptions().size()-1
		int index=option.getOptions().indexOf(option.getFirstSelectedOption())
		if(lastIndex==index)
			blnLastIndex=true
		return 	blnLastIndex
	}

	public List<Integer> getIntegerListOfDropdownOptions(){
		loadControl();
		List<Integer> Dropdownlist = new ArrayList<Integer>();
		Select option = new Select(this.element);
		List<WebElement> Options = option.getOptions();
		for (int i = 0; i < Options.size(); i++) {
			if(!Options.get(i).getText().trim().contains('Select'))
				Dropdownlist.add(Options.get(i).getText().trim().toInteger());
		}
		return Dropdownlist;
	}

	public boolean isOptionEqualAfterConditionOption(String Option,String ConditionOption) {
		boolean blnReturn
		loadControl();
		Select options=new Select(element)
		int CondIndex=options.getOptions().indexOf(ConditionOption)
		int OptIndex=options.getOptions().indexOf(Option)
		if(OptIndex>=CondIndex)
			blnReturn=true
		return 	blnReturn
	}

	
	
	}
