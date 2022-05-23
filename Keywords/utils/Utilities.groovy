package utils

import java.util.regex.Matcher
import java.util.regex.Pattern

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.ExpectedCondition
import com.google.common.base.Stopwatch

import core.Logger
import java.text.DecimalFormat

import core.Browser
import java.time.Duration
import java.util.function.Function

public class Utilities {

	private static final String downloadPath = System.getProperty("user.dir") + "\\ExportedFiles"

	public static By mapArgumentToSelector(By by, String[] lstArguments){
		String selector = by.toString();
		final String pattern = "By\\.(\\w+): (.*)";
		Pattern pat = Pattern.compile(pattern);
		Matcher match = pat.matcher(selector)

		if(match.find()){
			String byKey = match.group(1);
			String byValue = match.group(2);
			String result = String.format(byValue, lstArguments);

			switch(byKey.toUpperCase()){
				case "XPATH":
					return By.xpath(result);
				case "CSSSELECTOR":
					return By.cssSelector(result);
				case "ID":
					return By.id(result);
				case "NAME":
					return By.name(result);
				default:
					return By.xpath(result);
			}
		}
		return null;
	}

	public static String generateRandomNumber(int quantityNumbers=5){
		if(quantityNumbers<=5){
			String numbers = RandomStringUtils.randomNumeric(quantityNumbers);
			return numbers;
		}else{
			Logger.logERROR("The random number should less than or equal 5");
			return null;
		}
	}

	public static void waitForAWhile(int seconds, boolean condition=true){
		long timeInMiliSeconds = seconds * 1000;
		Stopwatch sw = new Stopwatch();
		sw.start();
		//		boolean condition = true;
		while(condition){
			if(timeInMiliSeconds< sw.elapsed().toMillis()){
				sw.stop();
				break;
			}
		}

	}

	public static String getDifferenceBTWValues(Object obj1,Object obj2) {
		DecimalFormat df=new DecimalFormat("0.00")
		return df.format(Math.abs(Double.parseDouble(obj1)-Double.parseDouble(obj2)))
	}

	public static String DecimalFormatToTwo(Object obj1) {
		DecimalFormat df=new DecimalFormat("0.00")
		return df.format(obj1)
	}
	
	public static String DecimalFormatToThree(Object obj1) {
		DecimalFormat df=new DecimalFormat("0.000")
		return df.format(obj1)
	}
	
	public static String DecimalFormatter(Object obj1, int count) {
		DecimalFormat df
		switch(count) {
			case 2:df=new DecimalFormat("0.00")
				break
			case 3:df=new DecimalFormat("0.000")
				break
		}
		return df.format(obj1)
	}
	
	public static String DecimalFormatWithCommaToTwo(Object obj1) {
		DecimalFormat df=new DecimalFormat("#,###.00")
		return df.format(obj1)
	}

	public static void deleteFile(String FileName) {
		File file=new File(downloadPath + "\\" +FileName)
		if(file.exists()) {
			file.delete()
		}
	}

	public static boolean checkFileExists(String FileName) {
		try {
			File file=new File(downloadPath + "\\" +FileName)
			boolean fileBoolean=false
			if(file.exists()) {
				fileBoolean=true
			}
			return fileBoolean
		}catch(Exception e) {
			throw new RuntimeException("Exception while checking file exists")
		}
	}

	public static void waitForFileDownloaded(String FileName, int timeoutSeconds) {
		File file=new File(downloadPath + "\\" +FileName)
		/*WebDriver driver = Browser.getDriverContext()
		 FluentWait<WebDriver> wait = new FluentWait<>(driver)
		 .withTimeout(Duration.ofMillis(timeoutSeconds))
		 .pollingEvery(Duration.ofMillis(250))
		 .ignoring(NoSuchElementException.class);
		 wait.until((x)->file.exists())
		 */	
		int pollingTimeOut=timeoutSeconds/1000
		for(int i=1;i<=1000;i++) {
			if(file.exists())
				break
			Thread.sleep(pollingTimeOut)
		}



	}

	public static double getResultOfProduct(Object obj1,Object obj2) {
		return Double.parseDouble(obj1)*Double.parseDouble(obj2)
	}

	public static boolean verifyValuesAreSame(Double dbl1,Double dbl2) {
		if(dbl1==dbl2)
			return true
		else
			return false
	}

	public static String getFirstLetterCapitalized(String Data) {

		List<String> lstWords=Data.split(' ')
		String updated=''
		for(String word:lstWords) {
			String flData=word.substring(0,1).toUpperCase()
			String remData=word.substring(1).toLowerCase()
			updated=updated+flData+remData+' '
		}
		return updated.trim()

	}


}
