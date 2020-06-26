package com.thoughtworks.ShopIeasy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestWebUiBasic {
	
	public static void logIn(String userKey, String pwdKey, WebDriver driver)
	{
		driver.findElement(By.linkText("Login")).click();
		try{
		driver.findElement(By.name("j_username")).sendKeys(BaseTest.prop.getProperty(userKey));
		driver.findElement(By.name("j_password")).sendKeys(BaseTest.prop.getProperty(pwdKey));
		driver.findElement(By.xpath("//div[@id='button']/button[1]")).click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Login UnsuccessFul");
		}
	}
	
	public static void logOut(WebDriver driver)
	{
		driver.findElement(By.linkText("Logout")).click();
	}
}
