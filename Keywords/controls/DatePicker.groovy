

package controls
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select
import java.time.temporal.ChronoUnit
import java.time.LocalDate
import core.BaseControl
public class DatePicker extends BaseControl {

	public DatePicker(){}
	public DatePicker(String xpath){
		super(By.xpath(xpath));
	}
	public DatePicker(By by){
		super(by);
	}
	public DatePicker(WebElement element){
		super(element);
	}


	private By calendar=By.xpath("//div[@id='ui-datepicker-div']");
	private By leftArrow=By.xpath("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[@data-handler='prev']/span");
	private By rightArrow=By.xpath("//div[@id='ui-datepicker-div']/div[@class='ui-datepicker-header ui-widget-header ui-helper-clearfix ui-corner-all']/a[@data-handler='next']/span");
	private By period=By.xpath("//td[contains(@class,'ui-datepicker-today') or contains(@class,'ui-datepicker-current-day')]")
	private String day_Format="//td[@data-handler='selectDay']/a[text()='%d']"
	private String day_default="//td[@data-handler='selectDay']/a[contains(@class,'ui-state-highlight')]"
	private By ddlMonth=By.xpath("//select[@class='ui-datepicker-month']")
	private By ddlYear=By.xpath("//select[@class='ui-datepicker-year']")

	public boolean isCalendarOpen() {
		return this.findElement(calendar).isDisplayed()
	}

	public void chooseYear(LocalDate date) {

		def currentPeriod=getCurrentPeriod()
		long yearsAway=ChronoUnit.YEARS.between(currentPeriod, date.withDayOfYear(1))

		By arrow=yearsAway<0?leftArrow:rightArrow

		for(int i=0;i<Math.abs(yearsAway);i++) {
			this.findElement(arrow).click();
		}
	}

	public void selectYear(LocalDate date) {
		Select option=new Select(this.findElement(ddlYear))
		option.selectByValue(date.getYear().toString())
	}

	public void selectMonth(LocalDate date) {
		Select option=new Select(this.findElement(ddlMonth))
		option.selectByVisibleText(getProperCaseMonth(date.getMonth().toString()))
	}

	public void chooseMonth(LocalDate date) {
		def currentPeriod=getCurrentPeriod()
		long monthsAway=ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1))
		By arrow=monthsAway<0?leftArrow:rightArrow

		for(int i=0;i<Math.abs(monthsAway);i++) {
			this.findElement(arrow).click();
		}
	}

	public String getProperCaseMonth(String monthName) {
		String pcase
		String firstChar=""+monthName.charAt(0)
		String lowcase=monthName.substring(1, 3).toLowerCase()
		pcase=firstChar + lowcase
		return pcase
	}

	public void chooseDate(String Date) {

		LocalDate LDate=this.formattoLocalDate(Date)

		if(this.isCalendarOpen()) {
			chooseMonth(LDate)
			chooseDay(LDate.getDayOfMonth());
		}
	}

	public void selectDate(String Date) {

		LocalDate LDate=this.formattoLocalDate(Date)

		if(this.isCalendarOpen()) {
			this.selectYear(LDate)
			this.selectMonth(LDate)
			chooseDay(LDate.getDayOfMonth());
		}
	}

	public void selectFirstDayofCurrentMonth() {
		if(this.isCalendarOpen())
			chooseDay(01);
	}

	public void selectDefaultDayofCurrentMonth() {
		if(this.isCalendarOpen())
			chooseDay();
	}

	public void chooseDay(int dayofMonth) {
		By locator=By.xpath(String.format(day_Format,dayofMonth))
		this.findElement(locator).click();
	}

	public void chooseDay() {
		By locator=By.xpath(String.format(day_default))
		this.findElement(locator).click();
	}

	public LocalDate formattoLocalDate(String sDate) {
		def fDate=sDate.split('/')
		return LocalDate.of(fDate.getAt(2).toInteger(), fDate.getAt(0).toInteger(), fDate.getAt(1).toInteger())
	}

	public LocalDate getCurrentPeriod() {
		Integer month=this.findElement(period).getAttribute('data-month').toInteger()
		Integer year=this.findElement(period).getAttribute('data-year').toInteger()
		return LocalDate.of(year, month+1, 1);
	}
}
