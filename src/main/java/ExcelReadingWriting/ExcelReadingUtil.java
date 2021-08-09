package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingUtil {
	XSSFWorkbook wb; 
	XSSFSheet sheet;
	
    public ExcelReadingUtil(String filepath) {
    	File src = new File(filepath);
		try {
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
    	
    }
    
    public String getExcelData(int sheetNumber, int rowNumber, int colNumber) {
    	sheet = wb.getSheetAt(sheetNumber);
    	String data = sheet.getRow(rowNumber).getCell(colNumber).getStringCellValue();
    	return data;
    	
    }
}
