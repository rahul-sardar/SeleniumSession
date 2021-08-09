package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws IOException {
		File src = new File("/Users/rahulmac/Downloads/SeleniumTestingData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		String data0= sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data0);
		int rowcount = sheet.getLastRowNum()+1;
		//there is npo method to get directly last colunm number so 
		//observe carefully how we get column number
		
		for(int i=0; i<rowcount;i++) {
			Row r = sheet.getRow(i);
			System.out.println("row number is"+i);
			int maxCell=  r.getLastCellNum();
			//System.out.println("For Learning last cell is" +maxCell);
			
			for(int j=0; j<r.getLastCellNum(); j++) {
				System.out.println("cell no"+j);
				System.out.println(r.getCell(j).getStringCellValue());
			}
		}
		wb.close();
		
		ExcelReadingUtil read = new ExcelReadingUtil("/Users/rahulmac/Downloads/SeleniumTestingData.xlsx");
		System.out.println("\nData is "+read.getExcelData(0, 1, 1));
}
}