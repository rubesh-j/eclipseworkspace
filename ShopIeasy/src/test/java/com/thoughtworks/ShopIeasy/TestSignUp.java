package com.thoughtworks.ShopIeasy;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestSignUp {
	public static void userSignUp(WebDriver driver)
	{
		driver.findElement(By.linkText("SignUp")).click();	
		driver.findElement(By.id("firstName")).sendKeys(BaseTest.prop.getProperty("userFirstname"));
		driver.findElement(By.id("lastName")).sendKeys(BaseTest.prop.getProperty("userLastName"));
		driver.findElement(By.id("users.emailId")).sendKeys(BaseTest.prop.getProperty("userMail"));
		driver.findElement(By.id("customerPhone")).sendKeys(BaseTest.prop.getProperty("userPh"));
		driver.findElement(By.id("pass")).sendKeys(BaseTest.prop.getProperty("userPwd"));
		driver.findElement(By.id("confirmpass")).sendKeys(BaseTest.prop.getProperty("userConfirmPwd"));
		driver.findElement(By.xpath("//div[@class='form-actions']/button[1]")).click();
		System.out.println("User Signed Up as " + BaseTest.prop.getProperty("userFirstname"));
	}

}
