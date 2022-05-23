package controls

import core.BaseControl
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.text.SimpleDateFormat

public class CalendarControl extends BaseControl{

	public CalendarControl(){}
	public CalendarControl(String xpath){
		super(By.xpath(xpath));
	}
	public CalendarControl(By by){
		super(by);
	}
	public CalendarControl(WebElement element){
		super(element);
	}

	public void selectDate(String strDate) {

		String yearLocator=String.format("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-year']")
		String monthLocator=String.format("//div[@class='ui-datepicker-title']/select[@class='ui-datepicker-month']")
		String dayLocator=String.format("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a")

		String dYear=strDate.split('/').getAt(2)
		println dYear

		this.by=By.xpath(yearLocator)
		this.loadControl()
		Select yoptions=new Select(this.element)
		yoptions.selectByValue(dYear)
		String dMonth=strDate.split('/').getAt(0)
		this.by=By.xpath(monthLocator)
		this.loadControl()
		Select moptions=new Select(this.element)
		switch(dMonth) {
			case '01':moptions.selectByVisibleText('Jan')
				break
			case '02':moptions.selectByVisibleText('Feb')
				break
			case '03':moptions.selectByVisibleText('Mar')
				break
			case '04':moptions.selectByVisibleText('Apr')
				break
			case '05':moptions.selectByVisibleText('May')
				break
			case '06':moptions.selectByVisibleText('Jun')
				break
			case '07':moptions.selectByVisibleText('Jul')
				break
			case '08':moptions.selectByVisibleText('Aug')
				break
			case '09':moptions.selectByVisibleText('Sep')
				break
			case '10':moptions.selectByVisibleText('Oct')
				break
			case '11':moptions.selectByVisibleText('Nov')
				break
			case '12':moptions.selectByVisibleText('Dec')
				break
		}

		String dDay=strDate.split('/').getAt(1)
		println dDay
		this.by=By.xpath(dayLocator)
		//this.loadControl()
		List<WebElements> ldays=this.findElements(this.by)
		for(WebElement day:ldays) {
			println day.getText()
			if(day.getText()!=null)
				if((day.getText().toInteger()).equals(dDay.toInteger())) {
					day.click()
					break
				}
		}
	}

	public void selectMultipleDates(List<String> lDate) {

		String prevLocator=String.format("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[@data-handler='prev']/span")
		String nextLocator=String.format("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[@data-handler='next']/span")
		String monthLocator=String.format("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")
		String yearLocator=String.format("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/div[@class='ui-datepicker-title']/span[@class='ui-datepicker-year']")
		String dayLocator=String.format("//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a")

		SimpleDateFormat monthParse = new SimpleDateFormat("MM");
		SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");

		this.by=By.xpath(prevLocator)
		WebElement btnPrev=this.findElement(this.by)
		this.by=By.xpath(nextLocator)
		WebElement btnNext=this.findElement(this.by)
		this.by=By.xpath(monthLocator)
		WebElement wMonth=this.findElement(this.by)
		this.by=By.xpath(yearLocator)
		WebElement wYear=this.findElement(this.by)

		String dYear,dMonth
		String xMonth
		for(String sDate:lDate) {

			dYear=sDate.split('/').getAt(2)
			dMonth=sDate.split('/').getAt(0)

			while((dYear.toInteger())<(wYear.getText().toInteger())) {
				this.by=By.xpath(prevLocator)
				this.loadControl()
				this.click()
				Thread.sleep(10)
				//btnPrev.click();
			}

			while((dYear.toInteger())>(wYear.getText().toInteger())) {
				this.by=By.xpath(nextLocator)
				this.loadControl()
				this.click()
				Thread.sleep(10)
				//btnNext.click();
			}


			xMonth=monthParse.format(monthDisplay.parse(wMonth.getText()))

			while((dMonth.toInteger())<(xMonth.toInteger())) {
				this.by=By.xpath(prevLocator)
				this.loadControl()
				this.click()
				Thread.sleep(10)
				//btnPrev.click();
			}

			while((dMonth.toInteger())>(xMonth.toInteger())) {
				this.by=By.xpath(nextLocator)
				this.loadControl()
				this.click()
				Thread.sleep(10)
				//btnNext.click();
			}

			String dDay=sDate.split('/').getAt(1)
			println dDay
			this.by=By.xpath(dayLocator)
			List<WebElements> ldays=this.findElements(this.by)
			for(WebElement day:ldays) {
				println day.getText()
				if(day.getText()!=null)
					if((day.getText().toInteger()).equals(dDay.toInteger())) {
						day.click()

					}
			}



		}
	}

}
