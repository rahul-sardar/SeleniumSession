package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataToExcelSimple {

	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir") + "//Excel//EmployeesData.xlsx";
		File src = new File(filePath);
		
		// This modification checks if the file "EmployeesData.xlsx" already exists. If
		// it does, it reads the existing workbook; otherwise, it creates a new
		// workbook. This way, any existing sheets in the workbook won't be deleted when
		// you create the new "Sheettwo0."

		XSSFWorkbook workbook;
		if (src.exists()) {
			FileInputStream fis = new FileInputStream(src);
			workbook = new XSSFWorkbook(fis);
		} else {
			workbook = new XSSFWorkbook();
		}
		XSSFSheet sheetOne = workbook.createSheet("Sheettwo2");

		Object[][] data = { { "Muffins" , 3, "Mumbai"}, { "Biscuit" , 10, "Navi Mumbai" },
				{ "Berries" ,9, "Shimla" }, { "Chips" , 6, "Kerela" },

		};

		int rows = data.length;
		int columns = data[0].length;

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheetOne.createRow(r);
			for (int c = 0; c < columns; c++) {
				XSSFCell cell = row.createCell(c);
				Object cellValue = data[r][c];
				if (cellValue instanceof String) {
					cell.setCellValue((String) cellValue);
				} else if (cellValue instanceof Integer) {
					cell.setCellValue((Integer) cellValue);
				} else if (cellValue instanceof Boolean) {
					cell.setCellValue((Boolean) cellValue);
				}
			}
		}

		FileOutputStream fos = new FileOutputStream(src);
		workbook.write(fos);
		workbook.close();

		System.out.println("Task Completed");

	}
}
