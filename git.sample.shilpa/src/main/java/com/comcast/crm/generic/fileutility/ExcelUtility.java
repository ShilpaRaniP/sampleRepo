package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{

	public String getDataFromExcel(String shName, int rowNo, int cellNo) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(shName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowCount(String shName) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount=wb.getSheet(shName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String shName, int rowNo, int cellNo, String data) throws Exception
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(shName).getRow(rowNo).createCell(cellNo);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./testData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
