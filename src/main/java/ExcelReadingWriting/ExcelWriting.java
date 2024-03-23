package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriting {

	public static void main(String[] args) throws IOException {
		XSSFSheet sheet;
		XSSFRow row = null;
	    @SuppressWarnings("unused")
		XSSFCell cell = null;
	    String filePath= System.getProperty("user.dir") + "//Excel//EmployeesData.xlsx";
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		//int sheetindex = wb.getSheetIndex("Names");
		//System.out.println("Sheet Index is" +sheetindex);
	
		wb.createSheet("Names");
		int sheetindex = wb.getSheetIndex("Names");
		System.out.println("Sheet Index is" +sheetindex);
		sheet = wb.getSheetAt(sheetindex);
		row = sheet.getRow(0);
		if(row == null) {
			sheet.createRow(0);
		}
		
		sheet.getRow(0).createCell(0).setCellValue("NAMES");
		sheet.getRow(0).createCell(1).setCellValue("SURNAME");
		FileOutputStream fout = new FileOutputStream(src);
		wb.write(fout);
		wb.close();
		

	}

}
