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



public class Table extends BaseControl {
	public Table(){}
	public Table(String xpath){
		super(By.xpath(xpath));
	}
	public Table(By by){
		super(by);
	}
	public Table(WebElement element){
		super(element);
	}

	public String getBodyText(){
		String tableLocator = String.format("%s//tbody",xpath);
		this.by = By.xpath(tableLocator);
		List<WebElement> lstElement = findElements(by);
		String text ="";
		if(lstElement.size()==1){
			text = getText().trim().replaceAll("[\\t\\n\\r]+"," ");
		}else{
			for(WebElement e: lstElement){
				text += e.getText();
			}
			text = text.trim().replaceAll("[\\t\\n\\r]+"," ");
		}

		return text;
	}

	public int getRowCounts(){
		String rowLocator = String.format("%s//tbody//tr",xpath);
		return findElements(By.xpath(rowLocator)).size();
	}

	public int getNoofRecords(){
		String rowLocator = String.format("%s/tbody/tr/td[1]",xpath);
		return findElements(By.xpath(rowLocator)).size();
	}

	public String getCellText(String rowIndex, String colName){
		/*String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//thead/tr/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		 */
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		return getText().trim().replaceAll("[\\t\\n\\r]+"," ");
	}

	public String getCellText_thead(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//thead/tr/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		return getText().trim().replaceAll("[\\t\\n\\r]+"," ");
	}

	public boolean getCellRadioButtonChecked(String rowIndex, String colName,String radioName){
		String cellLocator = String.format("%s//tbody/tr[%s]%s/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),radioName.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		return isChecked()
	}

	public String getCellTextBackgroundColor(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//span",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		return getTextBackgroundColor().trim()
	}

	public String getCellBackgroundColor(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		return getBackgroundColor()
	}

	public void clickToCellLink(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]/a"
				,xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
	}
	//table[@id='BodyContentHolder_grdPhysicianPayRequestFreeze']//tbody/tr[3]/*[count( //table[@id='BodyContentHolder_grdPhysicianPayRequest']//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'Edit')]]/preceding-sibling::*)+1]/div/a/img
	public void clickToCellImage(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//a"
				,xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		js.executeScript('arguments[0].click()', driver.findElement(By.xpath(cellLocator)))
		//JSclick();
	}

	public String getCellImageName(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//a"
				,xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		return this.getText()
		/*WebDriver driver = Browser.getDriverContext();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(cellLocator)))
		 js.executeScript('arguments[0].click()', driver.findElement(By.xpath(cellLocator)))
		 *///JSclick();
	}

	public void clickToCellText(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]"
				,xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
	}

	public void clickToCellCheckBox(String rowIndex, String colName){
		String cellLocator = String.format("%s//tr[%s]/td[count(%s//thead//*[starts-with(normalize-space(),'%s')]/preceding-sibling::*)+1]/*"
				,xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
	}

	public void clickToCellCheckBoxWithoutColumnName(String rowIndex){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]//*[./input]/preceding-sibling::*)+1]/*",xpath,rowIndex.trim(),xpath);
		this.by = By.xpath(cellLocator);
		click();
	}

	public void setCellText(String text, String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
		/*cellLocator = String.format("%s%s",cellLocator,"/input[@type='text']");
		 this.by = By.xpath(cellLocator);
		 */
		if(isDisplayed()) {
			clearText();
			sendKeys(text);
		}
	}

	public String getCellTextBoxText(String rowIndex, String colName) {
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
		if(isDisplayed()) {
			getValue()
		}
	}
	
	public String getCellTextBoxTextJS(String rowIndex, String colName) {
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
		getValue()
		
	}

	/*public String setCellTextBoxText(String rowIndex, String colName) {
	 String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,colName.trim());
	 this.by = By.xpath(cellLocator);
	 click();
	 if(isDisplayed()) {
	 getValue()
	 }
	 }*/

	public void waitForDataLoaded(int timeoutInSeconds){
		try{
			loadControl();
			String cellLocator = String.format("%s//tbody//tr[1]//th",xpath);
			this.wait = new WebDriverWait(Browser.getDriverContext(), timeoutInSeconds);
			this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(cellLocator),1));
		}catch(Throwable e){
			throw new HMException(String.format("The table with locator : %s has NO data",xpath), e);
		}
	}

	public String getCellDataActive(String rowIndex, String colName,String chkName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		String chkLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,chkName.trim());
		this.by = By.xpath(cellLocator);
		WebElement colWebElement=this.findElement(by)
		this.by = By.xpath(chkLocator);
		WebElement chkWebElement=this.findElement(by)

		WebDriver driver = Browser.getDriverContext();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(chkWebElement.getAttribute('checked'))
		{
			js.executeScript('arguments[0].scrollIntoView()', colWebElement)
			return colWebElement.getText().trim().replaceAll("[\\t\\n\\r]+"," ")
		}
	}

	//================================== ANIL JANAPAREDDY ==================================================

	public void clickCellLink(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		click();
	}

	public void getCellLinkName(String rowIndex, String colName){
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,rowIndex.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		getText()
	}

	public List<String> getColumnData(String colName){

		List<String> colData=new ArrayList<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)

		WebDriver driver = Browser.getDriverContext();
		for(int i=2;i<colWebElement.size();i++)
		{

			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript('arguments[0].scrollIntoView()', colWebElement.get(i))
			this.scrollToView(driver, colWebElement.get(i))
			colData.add(colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," "));
		}


		return colData

	}

	public List<String> getColumnData_thead(String colName){

		List<String> colData=new ArrayList<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//thead/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		WebDriver driver = Browser.getDriverContext();
		for(int i=0;i<colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i))
			colData.add(colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," "));
		}
		return colData
	}

	//List<String>
	public Collection<String> getColumnDataActive(String colName,String chkName){

		//List<String> colData=new ArrayList<String>();
		Set<String> colData=new HashSet<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		String chkLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,xpath,chkName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by=By.xpath(chkLocator)
		List<WebElement> chkWebElement=this.findElements(by)

		WebDriver driver = Browser.getDriverContext();

		for(int i=2;i<=colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i-1))
			if(chkWebElement.get(i-2).getAttribute('checked'))
			{
				colData.add(colWebElement.get(i-1).getText().trim().replaceAll("[\\t\\n\\r]+"," "));
			}
		}


		return colData

	}

	public Collection<String> getColumnDataInActive(String colName,String chkName){

		//List<String> colData=new ArrayList<String>();
		Set<String> colData=new HashSet<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		String chkLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,xpath,chkName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by=By.xpath(chkLocator)
		List<WebElement> chkWebElement=this.findElements(by)

		WebDriver driver = Browser.getDriverContext();

		for(int i=2;i<=colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i-1))
			if(!chkWebElement.get(i-2).getAttribute('checked'))
			{
				colData.add(colWebElement.get(i-1).getText().trim().replaceAll("[\\t\\n\\r]+"," "));
			}
		}


		return colData

	}

	public List<String> getColumnDataActiveDependency(String colName,String chkName,String depName,String depValue){

		List<String> colData=new ArrayList<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		String depLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,depName.trim());
		String chkLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,xpath,chkName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by = By.xpath(depLocator);
		List<WebElement> depWebElement=this.findElements(by)
		this.by=By.xpath(chkLocator)
		List<WebElement> chkWebElement=this.findElements(by)

		WebDriver driver = Browser.getDriverContext();
		for(int i=2;i<colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i))
			if(chkWebElement.get(i-1).getAttribute('checked'))
			{
				if(depWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equals(depValue))
					colData.add(colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," "));
			}
		}


		return colData

	}

	public List<String> getColumnDataDependency(String colName,String depName,String depValue){

		List<String> colData=new ArrayList<String>();
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,colName.trim());
		String depLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,xpath,depName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by = By.xpath(depLocator);
		List<WebElement> depWebElement=this.findElements(by)

		WebDriver driver = Browser.getDriverContext();
		for(int i=2;i<colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i))
			if(depWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equals(depValue))
				colData.add(colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," "));

		}


		return colData

	}

	public void clickToCellImageDependency(String colName,String depName,String depValue){
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath.trim(),xpath,colName.trim());
		String depLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath.trim(),xpath,depName.trim());

		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by = By.xpath(depLocator);
		List<WebElement> depWebElement=this.findElements(by)



		WebDriver driver = Browser.getDriverContext();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for(int i=2;i<colWebElement.size();i++)
		{

			this.scrollToView(driver, colWebElement.get(i))
			if(depWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equalsIgnoreCase(depValue))
			{
				String filteredLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//a",xpath,(i+1).toString(),xpath,colName.trim());
				this.by = By.xpath(filteredLocator);
				js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(filteredLocator)))
				js.executeScript('arguments[0].click()', driver.findElement(By.xpath(filteredLocator)))
				break
			}
		}
	}


	public void clickCellImageTable(String colName,String colValue) {
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//a",xpath.trim(),xpath,colName.trim());
		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		WebDriver driver = Browser.getDriverContext();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		for(int i=2;i<colWebElement.size();i++)
		{
			this.scrollToView(driver, colWebElement.get(i))
			if(colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equalsIgnoreCase(colValue))
			{
				colWebElement.get(i).click()
			}
		}
	}

	public String getCellDataDependency(String colName,String depName,String depValue){
		String cellLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath.trim(),xpath,colName.trim());
		String depLocator = String.format("%s//tbody/tr/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath.trim(),xpath,depName.trim());

		this.by = By.xpath(cellLocator);
		List<WebElement> colWebElement=this.findElements(by)
		this.by = By.xpath(depLocator);
		List<WebElement> depWebElement=this.findElements(by)



		WebDriver driver = Browser.getDriverContext();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		int noofRows=colWebElement.size()
		int i=1
		while(i<=noofRows) {
			scrollToView(driver, colWebElement.get(i))
			if(depWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equalsIgnoreCase(depValue))
			{
				//String filteredLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,(i+1).toString(),xpath,colName.trim());
				//this.by = By.xpath(filteredLocator);
				//js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(filteredLocator)))
				//return driver.findElement(By.xpath(filteredLocator)).getText()
				return colWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ")
			}
			i++
		}

		/*if(noofRows==2) {
		 return getCellText(noofRows.toString(), colName)
		 }
		 else
		 for(int i=2;i<colWebElement.size();i++)
		 {
		 this.scrollToView(driver, colWebElement.get(i))
		 if(depWebElement.get(i).getText().trim().replaceAll("[\\t\\n\\r]+"," ").equalsIgnoreCase(depValue))
		 {
		 String filteredLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",xpath,(i+1).toString(),xpath,colName.trim());
		 this.by = By.xpath(filteredLocator);
		 js.executeScript('arguments[0].scrollIntoView()', driver.findElement(By.xpath(filteredLocator)))
		 return driver.findElement(By.xpath(filteredLocator)).getText()
		 }
		 }*/
	}

	public boolean isCellCheckBoxActive(String rowIndex,String chkName) {
		String chkLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]//input",xpath,rowIndex.trim(),xpath,chkName.trim());
		this.by = By.xpath(chkLocator);
		WebElement chkWebElement=this.findElement(by)
		if(chkWebElement.getAttribute('checked'))
		{ return true
		}else {return false}
	}

	public List<String> getTableHeadings(){
		List<String> ColHeadings=new ArrayList<String>()
		String cellLocator = String.format("%s/tbody/tr[1]/td[1]",xpath);
		by = By.xpath(cellLocator);
		List<WebElement> colWebElements=this.findElements(by)
		println colWebElements.size()
		for(int i=0;i<colWebElements.size();i++) {
			println colWebElements.get(i).getText()
			ColHeadings.add(colWebElements.get(i).getText())
		}
		return ColHeadings
	}

	public List<String> getTableHeadingsWithSortingTag(){
		List<String> ColHeadings=new ArrayList<String>()
		String cellLocator = String.format("%s/tbody/tr[1]/th/div",xpath);

		by = By.xpath(cellLocator);
		List<WebElement> colWebElements=this.findElements(by)
		for(int i=0;i<colWebElements.size();i++) {
			ColHeadings.add(colWebElements.get(i).getText())
		}
		return ColHeadings
	}


	public Map<String,String> getGridFirstRecord(int HeaderRow){
		Map<String,String> gridData=new TreeMap<String,String>()
		String cellHeaderLocator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow);
		by = By.xpath(cellHeaderLocator);
		List<WebElement> colHeadWebElements=this.findElements(by)
		String cellDataLocator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow+1);
		by = By.xpath(cellDataLocator);
		List<WebElement> colDataWebElements=this.findElements(by)
		for(int i=0;i<colHeadWebElements.size();i++) {
			gridData.put(colHeadWebElements.get(i).getText().trim(), colDataWebElements.get(i).getText().replace(" \n", "").replace("\n", "").trim())
		}
		return gridData
	}
	
	public Map<String,String> getGridFirstRecordDoubleHeader(int HeaderRow){
		Map<String,String> gridData=new TreeMap<String,String>()
		String cellHeaderLocator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow);
		by = By.xpath(cellHeaderLocator);
		List<WebElement> colHeadWebElements=this.findElements(by)
		
		List<String> Header1=new ArrayList<>()
		for(WebElement preHeader:colHeadWebElements) {
			Integer cSpan
			if(preHeader.getAttribute('colspan')!=null)
			cSpan=Integer.parseInt(preHeader.getAttribute('colspan'))
			if(cSpan>1)
				for(int i=1;i<=cSpan;i++) 
					Header1.add(preHeader.getText())
			else
				Header1.add('')
				//Header1.add(preHeader.getText())
					
		}
		
		
		String cellHeader2Locator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow+1);
		by = By.xpath(cellHeader2Locator);
		List<WebElement> colHead2WebElements=this.findElements(by)
		
		
		
		String cellDataLocator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow+2);
		by = By.xpath(cellDataLocator);
		List<WebElement> colDataWebElements=this.findElements(by)
		for(int i=0;i<colDataWebElements.size();i++) {
			String Header
			if(!Header1[i].equals(''))
				Header=(Header1[i]+'_'+ colHead2WebElements.get(i).getText()).trim()
			else
				Header=colHead2WebElements.get(i).getText().trim()
				
				if(Header.startsWith('_')) {
					Header=Header.substring(1);
				}
				
			gridData.put(Header, colDataWebElements.get(i).getText().replace(" \n", "").replace("\n", "").trim())
		}
		return gridData
	}
	
	public HashMap<String,String> getGridRecordOfReports(int HeaderRow,int DataRow=HeaderRow+1){
		Map<String,String> gridData=new TreeMap<>()
		String cellHeaderLocator = String.format("%s/tbody/tr[%d]/td",xpath,HeaderRow);
		by = By.xpath(cellHeaderLocator);
		List<WebElement> colHeadWebElements=this.findElements(by)
		String cellDataLocator = String.format("%s/tbody/tr[%d]/td",xpath,DataRow);
		by = By.xpath(cellDataLocator);
		List<WebElement> colDataWebElements=this.findElements(by)
		for(int i=0;i<colHeadWebElements.size();i++) {
			gridData.put(colHeadWebElements.get(i).getText().trim(), colDataWebElements.get(i).getText().replace(" \n", "").replace("\n", "").trim())
		}
		return gridData
	}

}
