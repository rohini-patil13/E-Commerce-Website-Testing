package com.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.utilites.BrowserFactory;
import com.utilites.ConfigDataClass;
import com.utilites.ReadExcelFile;

public class BaseClass {
	
	public WebDriver driver;
	public ConfigDataClass config = new ConfigDataClass();  //define obj of ConfigClass so to becomes easier to fetch anything from BaseClass instead

	ReadExcelFile read = new ReadExcelFile();
	
	@BeforeClass 
	public void setup()
	{
		driver = BrowserFactory.openBrowser(driver, config.getBrowser());
		driver.get(config.getUrl());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
}
