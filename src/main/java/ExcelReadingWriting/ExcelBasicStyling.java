package ExcelReadingWriting;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelBasicStyling {
	
	public static void main(String[] args) throws IOException {
		String filePath = System.getProperty("user.dir") + "//Excel//EmployeesData.xlsx";
		File src = new File(filePath);
		
		// This modification checks if the file "EmployeesData.xlsx" already exists. If
		// it does, it reads the existing workbook; otherwise, it creates a new
		// workbook. This way, any existing sheets in the workbook won't be deleted when
		// you create the new "Sheettwo0."
		
		
		XSSFWorkbook workbook;
        XSSFSheet sheetOne;

        if (src.exists()) {
            FileInputStream fis = new FileInputStream(src);
            workbook = new XSSFWorkbook(fis);
            sheetOne = workbook.getSheet("SheetStlying");

            // If the sheet doesn't exist, create it
            if (sheetOne == null) {
                sheetOne = workbook.createSheet("SheetStlying");
            }
        } else {
            workbook = new XSSFWorkbook();
            sheetOne = workbook.createSheet("SheetStlying");
        }

		Object[][] data = { { "Muffins"}, { "Biscuit"  },
				{ "Berries" }, { "Chips" },

		};

		int rows = data.length;
		int columns = data[0].length;
		
		XSSFCellStyle style1 = workbook.createCellStyle();
		style1.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
		style1.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		style1.setBorderLeft(BorderStyle.THICK);
		style1.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
		style1.setBorderRight(BorderStyle.THICK);
		style1.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
		style1.setBorderTop(BorderStyle.THICK);
		style1.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
		style1.setBorderBottom(BorderStyle.THICK);
		style1.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());
		
		
		XSSFCellStyle style2 = workbook.createCellStyle();
		style2.setBorderLeft(BorderStyle.THICK);
		style2.setLeftBorderColor(IndexedColors.DARK_RED.getIndex());
		style2.setBorderRight(BorderStyle.THICK);
		style2.setRightBorderColor(IndexedColors.DARK_RED.getIndex());
		style2.setBorderTop(BorderStyle.THICK);
		style2.setTopBorderColor(IndexedColors.DARK_RED.getIndex());
		style2.setBorderBottom(BorderStyle.THICK);
		style2.setBottomBorderColor(IndexedColors.DARK_RED.getIndex());

		for (int r = 0; r < rows; r++) {
			XSSFRow row = sheetOne.createRow(r);
			for (int c = 0; c < columns; c++) {
				XSSFCell cell = row.createCell(c);
				Object cellValue = data[r][c];
				if(r == 0) {
					cell.setCellStyle(style1);
				}else {
					cell.setCellStyle(style2);
				}
				
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
