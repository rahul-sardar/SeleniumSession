package ExcelReadingWriting;

public class ExcelUtilityTest {

	public static void main(String[] args) {
		
		Xls_Reader reader = new Xls_Reader("/Users/rahulmac/Downloads/SeleniumTestingData.xlsx");
		String sheetname = "Names";
		System.out.println(reader.getCellData(sheetname, 0, 2));
		
		int rowCount = reader.getRowCount(sheetname);
		System.out.println("Total number of rows present is "+rowCount);
		
		int colCount = reader.getColumnCount(sheetname);
		System.out.println("Total number of column present is "+colCount);
		
		if(!reader.isSheetExist("Registration")) {
			reader.addSheet("Registration");
		}
		else System.out.println("Sheet already existed with given name");
		
		System.out.println("Checking added sheet exists or not " +reader.isSheetExist("Registration"));
		
        //reader.addColumn(sheetname, "Status");
        reader.setCellData(sheetname, "Status", 2, "PASS");
        reader.setCellData(sheetname, "Status", 3, "FAIL");
        
        //reader.addColumn("Registration", "FirstName");
        //reader.addColumn("Registration", "LastName");
        //reader.addColumn("Registration", "DOB");
     
        reader.removeColumn("Registration", 2);
        System.out.println("Column Counts "+reader.getColumnCount("Registration"));
        System.out.println(reader.checkColumnWithNameExistsOrNot("Registration", "DOB"));
        System.out.println(reader.checkColumnWithNameExistsOrNot("Registration", "FirstName"));
        System.out.println(reader.checkColumnWithNameExistsOrNot("Test", "DOB"));
	}

}
