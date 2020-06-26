package com.thoughtworks.ShopIeasy;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExecuteTestcase {
	public static Properties prop = new Properties();
	public static WebDriver driver;

	public static void main(String[] args)
			throws FileNotFoundException, IOException, InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		prop.load(new FileInputStream(new File("config.properties")));
		driver = new ChromeDriver();
		driver.get("http://10.134.124.198:8080/shopieasy");
		WebUiBasic.logIn("adminMail", "adminPswd", driver);
		AdminFunctions.addProductsbyAdmin(driver);
		WebUiBasic.logOut(driver);

		SignUp.userSignUp(driver);

		WebUiBasic.logIn("userMail", "userPwd", driver);
		UserAddtoCart.addProducttoCart(driver, "productName");
		UserAddtoCart.addProducttoCart(driver, "InproductName");
		WebUiBasic.logOut(driver);

		driver.close();
	}

}
