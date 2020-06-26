package com.thoughtworks.ShopIeasy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class BaseTest 
{
public static Properties prop = new Properties();
public static WebDriver driver;
    
 public BaseTest() throws FileNotFoundException, IOException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		prop.load(new FileInputStream(new File("config.properties")));
		driver = new ChromeDriver();
		driver.get("http://10.134.124.198:8080/shopieasy");
		
	}
   
}
