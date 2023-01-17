package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTestSheet {
	
	public static String testSheet;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	
	public static String getTestCase(String sheetname) throws Exception {
	//Path of the excel file
	testSheet = ReadProperties.getData("TestSheet");
	//Creating a workbook
	workbook = new XSSFWorkbook(testSheet);
	sheet = workbook.getSheet(sheetname);
	String TestCaseName=sheet.getRow(1).getCell(1).toString();
	return TestCaseName;
	
	}
	

	public static String getTestData(String sheetname,int row,int cell) throws Exception
	{
		//Path of the excel file
		testSheet = ReadProperties.getData("TestSheet");
	     //Creating a workbook
		workbook = new XSSFWorkbook(testSheet);
		sheet = workbook.getSheet(sheetname);
		String testData = workbook.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return testData;
	}
	public static String getExecution() throws Exception
	{
		//Path of the excel file
		testSheet = ReadProperties.getData("TestSheet");
	    //Creating a workbook
		workbook = new XSSFWorkbook(testSheet);
	   sheet = workbook.getSheetAt(0);
		String runmode=sheet.getRow(1).getCell(3).toString();
		return runmode;
	   
	}
	
}
