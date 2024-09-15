package com.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataClass {  // configuring the file
	Properties pro;

	public ConfigDataClass() {  //reads and loads the file to Properties class
		
		File src = new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getBrowser() 
	{
		return pro.getProperty("browser");
	}
	
	public String getUrl()
	{
		return pro.getProperty("url");
	}
}
