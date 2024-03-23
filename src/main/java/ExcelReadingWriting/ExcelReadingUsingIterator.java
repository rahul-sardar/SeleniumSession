package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingUsingIterator {
	public static void main(String[] args) throws IOException {

		String filePath = System.getProperty("user.dir") + "//Excel//EmployeesData.xlsx";
		File src = new File(filePath);
		FileInputStream fis = new FileInputStream(src);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		Iterator<Row> itrRow = sheet.iterator();
		while (itrRow.hasNext()) {
			Row row = itrRow.next();

			Iterator<Cell> itrCell = row.iterator();
			
			while(itrCell.hasNext()) {
				Cell cell = itrCell.next();
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;

				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());

				default:
					break;

				}
				System.out.print(" ");
				workbook.close();
			}
			System.out.println();
				
		}
	}

}
