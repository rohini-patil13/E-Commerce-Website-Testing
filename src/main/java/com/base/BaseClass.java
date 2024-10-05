package com.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	public static Actions action;
	
	@BeforeAll
	public static void loadConfig() { //loads config.properties file

		try {
			prop = new Properties();
//			String filepath = System.getProperty("user.dir") + "\\Configuration\\config.properties";
//			System.out.println("Config filepath: " + filepath);
			FileInputStream fil = new FileInputStream("D:\\E-Commerce Website Testing\\Configuration\\config.properties");
			prop.load(fil);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void launchBrowser() {
//		WebDriverManager.chromedriver().setup();
		String browser = prop.getProperty("browser");
		
		if (browser.contains("Chrome")) {
			driver = WebDriverManager.chromedriver().create();
		}
		else if (browser.contains("Firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		}
		else if (browser.contains("MSEdge")) {
			driver = WebDriverManager.iedriver().create();
		}
		
		System.out.println("Driver: " + driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		action = new Actions(driver);
	}

	
}
