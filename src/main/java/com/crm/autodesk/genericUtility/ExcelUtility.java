package com.crm.autodesk.genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author priyanka
 *
 */
public class ExcelUtility {
	
	/**
	 * 
	 * it is use to read data from excel sheet based on below arguments
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws Throwable
	 */
	
	public String getDataFromExcel(String sheetName, int rowNumber, int cellNumber) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./Data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		String data = row.getCell(cellNumber).getStringCellValue();
		wb.close();
		return data;
	}

}
