package com.utilites;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static FileInputStream fis;
	public static XSSFWorkbook WorkBook;
	public static XSSFSheet Sheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;
	
	public static String getCellValue(String fileName, String sheetName, int row, int col) 
	{
		try {
			fis = new FileInputStream(fileName);
			WorkBook = new XSSFWorkbook(fis);
			Sheet = WorkBook.getSheet(sheetName);
			Cell = Sheet.getRow(row).getCell(col);
			
			WorkBook.close();
			
			return Cell.getStringCellValue();
			
		} catch (Exception e) {
			return " ";
		}
	}
	
	public static int getRowCount(String fileName, String sheetName)
	{
		try {
			fis = new FileInputStream(fileName);
			WorkBook = new XSSFWorkbook(fis);
			Sheet = WorkBook.getSheet(sheetName);
			int row = Sheet.getLastRowNum()+1;
			WorkBook.close();
			
			return row;
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int getColCount(String fileName, String sheetName)
	{
		try {
			fis = new FileInputStream(fileName);
			WorkBook = new XSSFWorkbook(fis);
			Sheet = WorkBook.getSheet(sheetName);
			int col = Sheet.getRow(0).getLastCellNum();
			WorkBook.close();
			
			return col;
			
		} catch (Exception e) {
			return 0;
		}
	}
	
	public String getStringData (String sheetName, int row, int col)
	{
		return WorkBook.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumData (String sheetName, int row, int col)
	{
		return WorkBook.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
	
}
