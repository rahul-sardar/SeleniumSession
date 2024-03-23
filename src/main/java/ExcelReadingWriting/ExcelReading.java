package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws IOException {
		String filePath= System.getProperty("user.dir") + "//Excel//EmployeesData.xlsx";
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		//String data0= sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data0);
		int rowcount = sheet.getLastRowNum()+1;
		//there is npo method to get directly last colunm number so 
		//observe carefully how we get column number
		
		for(int i=0; i<rowcount;i++) {
			XSSFRow r = sheet.getRow(i);
			System.out.println("row number is"+i);
			//int maxCell=  r.getLastCellNum();
			//System.out.println("For Learning last cell is" +maxCell);
			
			for(int j=0; j<r.getLastCellNum(); j++) {
				System.out.println("cell no"+j);
				XSSFCell cell = r.getCell(j);
				CellType cellType = cell.getCellType();
				switch(cellType) {
					case STRING: 
						System.out.println(cell.getStringCellValue());
						break;
					case NUMERIC: 
						System.out.println(cell.getNumericCellValue());
						break;
		
					case BOOLEAN: 
						System.out.println(cell.getBooleanCellValue());
						
					default:
						break;     		

				}
			}
		}
		wb.close();
		
		ExcelReadingUtil read = new ExcelReadingUtil(filePath);
		System.out.println("\nData is "+read.getExcelData(0, 1, 1));
}
}