package com.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.BaseClass;
import com.pages.LoginPage;
import com.utilites.ReadExcelFile;


public class LoginTest extends BaseClass {
	String fileName = System.getProperty("user.dir"+"\\TestData\\EComTestData.xlsx");

	
	@Test(dataProvider="loginDataProvider")
	public void verify(String username, String password)
	{
		LoginPage login = new LoginPage(driver);
		login.login();
		
	}
	
	@DataProvider
	public String[][] loginDataProvider()
	{
		int row = ReadExcelFile.getRowCount(fileName, "Login");
		int col = ReadExcelFile.getColCount(fileName, "Login");
		
		String [][] data = new String[row-1][col];
		
		for (int i = 1; i < row; i++)
		{
			for (int j = 0; i < col; j++)
			{
				data[i-1][j] = ReadExcelFile.getCellValue(fileName, "Login",i,j);
			}
		}
		
		return data;

	}
}
