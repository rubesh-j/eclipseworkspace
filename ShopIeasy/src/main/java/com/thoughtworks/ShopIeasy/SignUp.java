package com.thoughtworks.ShopIeasy;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp {
	public static void userSignUp(WebDriver driver)
	{
		driver.findElement(By.linkText("SignUp")).click();	
		driver.findElement(By.id("firstName")).sendKeys(ExecuteTestcase.prop.getProperty("userFirstname"));
		driver.findElement(By.id("lastName")).sendKeys(ExecuteTestcase.prop.getProperty("userLastName"));
		driver.findElement(By.id("users.emailId")).sendKeys(ExecuteTestcase.prop.getProperty("userMail"));
		driver.findElement(By.id("customerPhone")).sendKeys(ExecuteTestcase.prop.getProperty("userPh"));
		driver.findElement(By.id("pass")).sendKeys(ExecuteTestcase.prop.getProperty("userPwd"));
		driver.findElement(By.id("confirmpass")).sendKeys(ExecuteTestcase.prop.getProperty("userConfirmPwd"));
		driver.findElement(By.xpath("//div[@class='form-actions']/button[1]")).click();
		System.out.println("User Signed Up as " + ExecuteTestcase.prop.getProperty("userFirstname"));
	}

}
