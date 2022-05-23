package utils

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.WorkbookFactory
import groovy.swing.factory.CellEditorFactory
import org.apache.poi.ss.usermodel.Workbook
import utils.PlatformUtil
import utils.DateTimeUtil
import java.text.DateFormat
import java.text.NumberFormat
import configs.HIIConstants
import org.apache.poi.ss.util.CellRangeAddress
import core.Logger

/**
 * @author AnilKumarJanapareddy
 *
 */
public class ExcelUtilities {

	private static final String downloadPath = System.getProperty("user.dir") + "\\ExportedFiles"

	/**
	 * @param FileName
	 * @param ColumnName
	 * @return
	 */
	public static Double getSumofColumn(String FileName,String ColumnName) {
		Double TotalofColumn = 0.0;
		FileInputStream FIS = new FileInputStream(downloadPath + "\\" +FileName);
		Workbook XWorkbook = WorkbookFactory.create(FIS);
		Sheet Xsheet = XWorkbook.getSheetAt(0);
		int cols = Xsheet.getRow(0).getLastCellNum();
		int requiredCol = 0;
		for (int i = 0; i < cols; i++) {
			if (Xsheet.getRow(0).getCell(i).toString().equalsIgnoreCase(ColumnName)) {
				requiredCol = i;
				break;
			}
		}
		for (int i = 1; i <= Xsheet.getLastRowNum(); i++) {
			TotalofColumn = TotalofColumn + Double.parseDouble(Xsheet.getRow(i).getCell(requiredCol).toString());
		}
		XWorkbook.close()
		return TotalofColumn;
	}

	/**
	 * @param FileName
	 * @return
	 */
	public static HashMap<String,String> getExcelData(String FileName){
		HashMap<String,String> ExcelData=new HashMap<String,String>()
		FileInputStream FIS = new FileInputStream(PlatformUtil.getDownloadedFileProjectPath(FileName));
		Workbook XWorkbook = WorkbookFactory.create(FIS);
		Sheet Xsheet = XWorkbook.getSheetAt(0);
		int cols = Xsheet.getRow(0).getLastCellNum();
		String ExcelValue
		for (int i = 0; i < cols; i++) {
			ExcelData.put(Xsheet.getRow(0).getCell(i).toString(), Xsheet.getRow(1).getCell(i).toString())
		}
		return ExcelData
	}

	/**
	 * @param FileName
	 * @param HeaderRow
	 * @return
	 */
	public static HashMap<String,String> getExcelFirstRecord(String FileName,int HeaderRow=0){
		HashMap<String,String> ExcelData=new HashMap<String,String>()
		FileInputStream FIS = new FileInputStream(PlatformUtil.getDownloadedFileProjectPath(FileName));
		Workbook XWorkbook = WorkbookFactory.create(FIS);
		Sheet Xsheet = XWorkbook.getSheetAt(0);
		int cols = Xsheet.getRow(HeaderRow).getLastCellNum();
		String ExcelValue
		for (int i = 0; i < cols; i++) {
			//println Xsheet.getRow(HeaderRow+1).getCell(i).getRichStringCellValue()
			String hmKey=Xsheet.getRow(HeaderRow).getCell(i).toString().trim()
			String hmValue
			//println Xsheet.getRow(HeaderRow+1).getCell(i).getCellStyle().getDataFormatString()
			Cell cellValue=Xsheet.getRow(HeaderRow+1).getCell(i)
			switch(hmKey) {
				case HIIConstants.getHlogdatetime():
					hmValue=DateTimeUtil.SimpleDateFormatter(cellValue.getDateCellValue()).toString()
					break
				case HIIConstants.getHdatetimeofevent():
					hmValue=DateTimeUtil.SimpleDateFormatter(cellValue.getDateCellValue()).toString()
					break
				case HIIConstants.getHmaxcompensation():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					break
				case HIIConstants.getHthresholdamount():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					break
				case HIIConstants.getHrequestedamount():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					break
				case HIIConstants.getHapprovedrejectedamount():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					break
				case HIIConstants.getHtotalunits():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=Utilities.DecimalFormatToTwo(Amount)
					break
				case HIIConstants.getHtotalwrvustrvus():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=Utilities.DecimalFormatToTwo(Amount)
					break
				case HIIConstants.getHannivnoticedays():
					Integer Amount=(int)Float.parseFloat(cellValue.toString())
					hmValue=Amount.toString()
					break
				default:
					hmValue=cellValue.toString().replace(" \n", "").replace("\n","").trim()
					break
			}


			/*if(hmKey.equals('Log Date Time') || hmKey.equals('Date & Time of Event'))
			 hmValue= DateTimeUtil.SimpleDateFormatter(Xsheet.getRow(HeaderRow+1).getCell(i).getDateCellValue()).toString()
			 else if(hmKey.equals('Max Compensation') || hmKey.contains('Threshold Amount')) {
			 Locale locale=new Locale("en","US")
			 NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale)
			 hmValue= numberFormat.format(Double.parseDouble(Xsheet.getRow(HeaderRow+1).getCell(i).toString().replace(" \n", "").replace("\n","").trim())).toString()
			 }
			 else	
			 switch(Xsheet.getRow(HeaderRow+1).getCell(i).getCellStyle().getDataFormatString()) {
			 case dollarCurrency:
			 println "HI"
			 Locale locale=new Locale("en","US")
			 NumberFormat numberFormat=NumberFormat.getCurrencyInstance(locale)
			 hmValue= numberFormat.format(Double.parseDouble(Xsheet.getRow(HeaderRow+1).getCell(i).toString().replace(" \n", "").replace("\n","").trim())).toString()
			 default:
			 hmValue= Xsheet.getRow(HeaderRow+1).getCell(i).toString().replace(" \n", "").replace("\n","").trim()
			 break
			 }*/

			ExcelData.put(hmKey,hmValue)

		}
		return ExcelData
	}

	/**
	 * @param FileName
	 * @param HeaderRow
	 * @param DataRow
	 * @return
	 */
	public static Map<String,String> getExcelRecordForReports(String FileName,int HeaderRow=0,int DataRow=HeaderRow+1){
		Map<String,String> excelData=new TreeMap<>()
		FileInputStream FIS = new FileInputStream(PlatformUtil.getDownloadedFileProjectPath(FileName));
		Workbook XWorkbook = WorkbookFactory.create(FIS);
		Sheet Xsheet = XWorkbook.getSheetAt(0);
		int cols = Xsheet.getRow(HeaderRow).getLastCellNum();
		for (int i = 0; i < cols; i++) {
			String hmKey=Xsheet.getRow(HeaderRow).getCell(i).toString().trim()
			String hmValue
			Cell cellValue=Xsheet.getRow(DataRow).getCell(i)
			String headerType

			switch(cellValue.getCellTypeEnum()) {
				case 0:
					headerType=HIIConstants.getDecimalcommatype()
					break
			}

			if(!cellValue.toString().isEmpty())
				if(hmKey.equals(HIIConstants.getHlogdatetime()) || hmKey.equals(HIIConstants.getHdatetimeofevent()))
					headerType=HIIConstants.getDatetype()
				else if(hmKey.equals(HIIConstants.getHoutboundamount()) || hmKey.equals(HIIConstants.getHvariance()) || hmKey.equals(HIIConstants.getHinboundamount()) || hmKey.equals(HIIConstants.getHnonffscompensation()) || hmKey.equals(HIIConstants.getHffscompensation()) || hmKey.equals(HIIConstants.getHmaxcompensation()) || hmKey.equals(HIIConstants.getHthresholdamount()) || hmKey.equals(HIIConstants.getHrequestedamount()) || hmKey.equals(HIIConstants.getHapprovedrejectedamount()))
					headerType=HIIConstants.getCurrencytype()
				else if(hmKey.equals(HIIConstants.getHtotal()) || hmKey.equals(HIIConstants.getHcmebalance()) || hmKey.equals(HIIConstants.getHcmeeligibleamount()) || hmKey.equals(HIIConstants.getHtotalamount()) || hmKey.equals(HIIConstants.getHtotalunits()) || hmKey.equals(HIIConstants.getHtotalwrvustrvus()) || hmKey.equals(HIIConstants.getHltsaccrualrate()) || hmKey.equals(HIIConstants.getHltsbalance()) || hmKey.equals(HIIConstants.getHltscfbalance()) || hmKey.equals(HIIConstants.getHltsplanhours()) || hmKey.equals(HIIConstants.getHltshoursused()) || hmKey.equals(HIIConstants.getHptoaccrualrate()) || hmKey.equals(HIIConstants.getHptocfbalance()) || hmKey.equals(HIIConstants.getHptohoursused()) || hmKey.equals(HIIConstants.getHptoplanhours()))
					headerType=HIIConstants.getDecimalcommatype()
				else if(hmKey.equals(HIIConstants.getHcptffsrate()) || hmKey.equals(HIIConstants.getHunitvalue()) || hmKey.equals(HIIConstants.getHtotalfte()) || hmKey.equals(HIIConstants.getHcmeconsumed()) || hmKey.equals(HIIConstants.getHptoatoconsumed()) || hmKey.equals(HIIConstants.getHptoatobalance()) || hmKey.equals(HIIConstants.getHptoatoeligible()) || hmKey.equals(HIIConstants.getHthreshold()) || hmKey.equals(HIIConstants.getHdailyrate()) || hmKey.equals(HIIConstants.getHencounters()) || hmKey.equals(HIIConstants.getHencountersbeyondthreshold()) || hmKey.equals(HIIConstants.getHclinicalfte()) || hmKey.equals(HIIConstants.getHcurrentmonthpaidhours()) || hmKey.equals(HIIConstants.getHcurrentmonthworkedhours()) || hmKey.equals(HIIConstants.getHytdpaidhours()) || hmKey.equals(HIIConstants.getHytdworkedhours()) || hmKey.equals(HIIConstants.getHpreviousmonthpaidhours()) || hmKey.equals(HIIConstants.getHpreviousmonthworkedhours()) || hmKey.equals(HIIConstants.getHcptquantity())|| hmKey.equals(HIIConstants.getHtotalshiftshours()) || hmKey.equals(HIIConstants.getHptobalance()) || hmKey.equals(HIIConstants.getHrate()))
					headerType=HIIConstants.getDecimaltype()
				else if(hmKey.equals(HIIConstants.getHyear()) || hmKey.equals(HIIConstants.getHannivnoticedays()) || hmKey.equals(HIIConstants.getHtotalshifts()))
					headerType=HIIConstants.getInttype()
				else if(hmKey.startsWith(HIIConstants.getHjan()) || hmKey.startsWith(HIIConstants.getHfeb()) || hmKey.startsWith(HIIConstants.getHmar()) || hmKey.startsWith(HIIConstants.getHapr()) || hmKey.startsWith(HIIConstants.getHmay()) || hmKey.startsWith(HIIConstants.getHjun()) || hmKey.startsWith(HIIConstants.getHjul()) || hmKey.startsWith(HIIConstants.getHaug()) || hmKey.startsWith(HIIConstants.getHsep()) || hmKey.startsWith(HIIConstants.getHoct()) || hmKey.startsWith(HIIConstants.getHnov()) || hmKey.startsWith(HIIConstants.getHdec()))
					headerType=HIIConstants.getDecimaltypedigits3()






			switch(headerType) {
				case HIIConstants.getDatetype():
					hmValue=DateTimeUtil.SimpleDateFormatter(cellValue.getDateCellValue()).toString()
					break
				case HIIConstants.getCurrencytype():
					try {
						Double Amount=Double.parseDouble(cellValue.toString())
						hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					}catch(Exception e) {
						Logger.logWARNING('Exception with excel value of '+hmKey);
						Logger.logINFO(e.printStackTrace())
					}
					break
				case HIIConstants.getDecimalcommatype():
					try {
						Double Amount=Double.parseDouble(cellValue.toString())
						hmValue=Utilities.DecimalFormatWithCommaToTwo(Amount)
					}catch(Exception e) {
						Logger.logWARNING('Exception with excel value of '+hmKey);
						Logger.logINFO(e.printStackTrace())
					}
					break
				case HIIConstants.getDecimaltype():
					try {
						Double Amount=Double.parseDouble(cellValue.toString())
						hmValue=Utilities.DecimalFormatToTwo(Amount)
					}catch(Exception e) {
						Logger.logWARNING('Exception with excel value of '+hmKey);
						Logger.logINFO(e.printStackTrace())
					}
					break
				case HIIConstants.getDecimaltypedigits3():
					try {
						Double Amount=Double.parseDouble(cellValue.toString())
						hmValue=Utilities.DecimalFormatter(Amount, 3)
					}catch(Exception e) {
						Logger.logWARNING('Exception with excel value of '+hmKey);
						Logger.logINFO(e.printStackTrace())
					}
					break
				case HIIConstants.getInttype():
					try {
						Integer Amount=(int)Float.parseFloat(cellValue.toString())
						hmValue=Amount.toString()
					}catch(Exception e) {
						Logger.logWARNING('Exception with excel value of '+hmKey);
						Logger.logINFO(e.printStackTrace())
					}
					break
				default:
					hmValue=cellValue.toString().replace(" \n", "").replace("\n","").trim()
					break
			}

			if(hmKey.equals(HIIConstants.getHreviewed())) {
				if(hmValue.equals("No"))
					hmValue=""
			}



			if(hmKey.equals(HIIConstants.getHltshoursused()) || hmKey.equals(HIIConstants.getHptohoursused()))
				if(hmValue.equals(".00") || hmValue.equals("0.0"))
					hmValue=""
			excelData.put(hmKey,hmValue)
		}
		return excelData
	}

	/**
	 * @param FileName
	 * @param HeaderRow
	 * @param DataRow
	 * @return
	 */
	public static Map<String,String> getExcelRecordForReportsDoubleHeader(String FileName,int HeaderRow=0,int DataRow=HeaderRow+2){
		Map<String,String> excelData=new TreeMap<>()
		FileInputStream FIS = new FileInputStream(PlatformUtil.getDownloadedFileProjectPath(FileName));
		Workbook XWorkbook = WorkbookFactory.create(FIS);
		Sheet Xsheet = XWorkbook.getSheetAt(0);


		int cols = Xsheet.getRow(HeaderRow).getLastCellNum();
		for (int i = 0; i < cols; i++) {
			String prefix='';
			for(CellRangeAddress mergedRegions:Xsheet.getMergedRegions())
				if(mergedRegions.getFirstRow()==HeaderRow) {
					int k=mergedRegions.getFirstColumn();
					if(i>=mergedRegions.getFirstColumn() && i<=mergedRegions.getLastColumn()) {
						prefix=Xsheet.getRow(HeaderRow).getCell(k).toString()
					}
				}
			String suffix=Xsheet.getRow(HeaderRow+1).getCell(i).toString();
			String hmKey
			if(!prefix.isEmpty())
				hmKey=prefix+'_'+suffix
			else
				hmKey=suffix
			String hmValue
			Cell cellValue=Xsheet.getRow(DataRow).getCell(i)
			String headerType
			if(!cellValue.toString().isEmpty())
				if(hmKey.equals(HIIConstants.getHlogdatetime()) || hmKey.equals(HIIConstants.getHdatetimeofevent()))
					headerType=HIIConstants.getDatetype()
				else if(hmKey.equals(HIIConstants.getHratec()) || hmKey.equals(HIIConstants.getHpreviouspayperiodRate()) || hmKey.equals(HIIConstants.getHpreviouspayperiodAmount()) || hmKey.equals(HIIConstants.getHcurrentpayperiodAmount()) || hmKey.equals(HIIConstants.getHnonffscompensation()) || hmKey.equals(HIIConstants.getHffscompensation()) || hmKey.equals(HIIConstants.getHmaxcompensation()) || hmKey.equals(HIIConstants.getHthresholdamount()) || hmKey.equals(HIIConstants.getHrequestedamount()) || hmKey.equals(HIIConstants.getHapprovedrejectedamount()))
					headerType=HIIConstants.getCurrencytype()
				else if(hmKey.equals(HIIConstants.getHcmebalance()) || hmKey.equals(HIIConstants.getHcmeeligibleamount()) || hmKey.equals(HIIConstants.getHtotalamount()) || hmKey.equals(HIIConstants.getHtotalunits()) || hmKey.equals(HIIConstants.getHtotalwrvustrvus()) || hmKey.equals(HIIConstants.getHltsaccrualrate()) || hmKey.equals(HIIConstants.getHltsbalance()) || hmKey.equals(HIIConstants.getHltscfbalance()) || hmKey.equals(HIIConstants.getHltsplanhours()) || hmKey.equals(HIIConstants.getHltshoursused()) || hmKey.equals(HIIConstants.getHptoaccrualrate()) || hmKey.equals(HIIConstants.getHptocfbalance()) || hmKey.equals(HIIConstants.getHptohoursused()) || hmKey.equals(HIIConstants.getHptoplanhours()))
					headerType=HIIConstants.getDecimalcommatype()
				else if(hmKey.equals(HIIConstants.getHvarianceShiftshours()) || hmKey.equals(HIIConstants.getHvariancep()) || hmKey.equals(HIIConstants.getHvarianceAmount()) || hmKey.startsWith(HIIConstants.getHvisitsencounters()) || hmKey.startsWith(HIIConstants.getHwrvustrvus()) || hmKey.equals(HIIConstants.getHunitvalue()) || hmKey.equals(HIIConstants.getHtotalfte()) || hmKey.equals(HIIConstants.getHcmeconsumed()) || hmKey.equals(HIIConstants.getHptoatoconsumed()) || hmKey.equals(HIIConstants.getHptoatobalance()) || hmKey.equals(HIIConstants.getHptoatoeligible()) || hmKey.equals(HIIConstants.getHthreshold()) || hmKey.equals(HIIConstants.getHdailyrate()) || hmKey.equals(HIIConstants.getHencounters()) || hmKey.equals(HIIConstants.getHencountersbeyondthreshold()) || hmKey.equals(HIIConstants.getHclinicalfte()) || hmKey.equals(HIIConstants.getHcurrentmonthpaidhours()) || hmKey.equals(HIIConstants.getHcurrentmonthworkedhours()) || hmKey.equals(HIIConstants.getHytdpaidhours()) || hmKey.equals(HIIConstants.getHytdworkedhours()) || hmKey.equals(HIIConstants.getHpreviousmonthpaidhours()) || hmKey.equals(HIIConstants.getHpreviousmonthworkedhours()) || hmKey.equals(HIIConstants.getHcptquantity())|| hmKey.equals(HIIConstants.getHtotalshiftshours()) || hmKey.equals(HIIConstants.getHptobalance()) || hmKey.equals(HIIConstants.getHrate()))
					headerType=HIIConstants.getDecimaltype()
				else if(hmKey.equals(HIIConstants.getHyear()) || hmKey.equals(HIIConstants.getHannivnoticedays()) || hmKey.equals(HIIConstants.getHtotalshifts()))
					headerType=HIIConstants.getInttype()
				else if(hmKey.startsWith(HIIConstants.getHjan()) || hmKey.startsWith(HIIConstants.getHfeb()) || hmKey.startsWith(HIIConstants.getHmar()) || hmKey.startsWith(HIIConstants.getHapr()) || hmKey.startsWith(HIIConstants.getHmay()) || hmKey.startsWith(HIIConstants.getHjun()) || hmKey.startsWith(HIIConstants.getHjul()) || hmKey.startsWith(HIIConstants.getHaug()) || hmKey.startsWith(HIIConstants.getHsep()) || hmKey.startsWith(HIIConstants.getHoct()) || hmKey.startsWith(HIIConstants.getHnov()) || hmKey.startsWith(HIIConstants.getHdec()))
					headerType=HIIConstants.getDecimaltypedigits3()




			switch(headerType) {
				case HIIConstants.getDatetype():
					hmValue=DateTimeUtil.SimpleDateFormatter(cellValue.getDateCellValue()).toString()
					break
				case HIIConstants.getCurrencytype():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=CurrencyUtility.getCurrencyValue(Amount, 'USD')
					break
				case HIIConstants.getDecimalcommatype():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=Utilities.DecimalFormatWithCommaToTwo(Amount)
					break
				case HIIConstants.getDecimaltype():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=Utilities.DecimalFormatToTwo(Amount)
					break
				case HIIConstants.getDecimaltypedigits3():
					Double Amount=Double.parseDouble(cellValue.toString())
					hmValue=Utilities.DecimalFormatter(Amount, 3)
					break
				case HIIConstants.getInttype():
					Integer Amount=(int)Float.parseFloat(cellValue.toString())
					hmValue=Amount.toString()
					break
				default:
					hmValue=cellValue.toString().replace(" \n", "").replace("\n","").trim()
					break
			}

			if(hmKey.equals(HIIConstants.getHltshoursused()) || hmKey.equals(HIIConstants.getHptohoursused()))
				if(hmValue.equals(".00") || hmValue.equals("0.0"))
					hmValue=""
			excelData.put(hmKey,hmValue)
		}
		return excelData
	}


}
