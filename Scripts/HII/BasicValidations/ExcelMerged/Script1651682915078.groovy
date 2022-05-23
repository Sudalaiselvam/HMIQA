import utils.ExcelUtilities
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
import org.apache.poi.ss.usermodel.CellRange
import org.apache.poi.ss.util.CellRangeAddress

String ReportFileName='Provider wRVUs.xlsx'
Map<String,String> firstRecord=new TreeMap<>()
FileInputStream FIS = new FileInputStream(PlatformUtil.getDownloadedFileProjectPath(ReportFileName));
Workbook XWorkbook = WorkbookFactory.create(FIS);
Sheet Xsheet = XWorkbook.getSheetAt(0);
Map<String,String> excelData=new TreeMap<>()
int cols = Xsheet.getRow(2).getLastCellNum();

		for (int i = 0; i < cols; i++) {
				String prefix='';
				for(CellRangeAddress mergedRegions:Xsheet.getMergedRegions())
					if(mergedRegions.getFirstRow()==2) {
					int k=mergedRegions.getFirstColumn();
					if(i>=mergedRegions.getFirstColumn() && i<=mergedRegions.getLastColumn()) {
						prefix=Xsheet.getRow(2).getCell(k).toString()
					}
					}
				String suffix=Xsheet.getRow(3).getCell(i).toString();
				String hmKey
				if(!prefix.isEmpty())
					hmKey=prefix+'_'+suffix
				else
					hmKey=suffix	
				String hmValue=Xsheet.getRow(4).getCell(i).toString()
				
				firstRecord.put(hmKey,hmValue)
			}

println firstRecord

