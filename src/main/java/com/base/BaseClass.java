package com.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
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
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		action = new Actions(driver);

	}

	public static String generateRandomEmail() {
		int length = 10;
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);
	    String generatedEmail = generatedString + "@xyzdomain.com";
	    System.out.println("Test Email: " + generatedEmail);
	    
	    return generatedEmail;
	    }
	
}
