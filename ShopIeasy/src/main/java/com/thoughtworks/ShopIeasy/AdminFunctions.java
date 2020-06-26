package com.thoughtworks.ShopIeasy;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminFunctions {
	
	public static void addProductsbyAdmin(WebDriver driver) throws InterruptedException
	{
		System.out.println("Logged in as " + ExecuteTestcase.prop.getProperty("adminMail"));
		driver.findElement(By.xpath("//div[@id='myNavbar']/ul[1]/li[4]")).click();
		System.out.println("Into Add Products page");
		driver.findElement(By.id("productName")).sendKeys(ExecuteTestcase.prop.getProperty("productName"));
		driver.findElement(By.id("productDescription")).sendKeys(ExecuteTestcase.prop.getProperty("productDescription"));
		driver.findElement(By.id("productManufacturer")).sendKeys(ExecuteTestcase.prop.getProperty("productManufacturer"));
		driver.findElement(By.id("productPrice")).clear();
		driver.findElement(By.id("productPrice")).sendKeys(ExecuteTestcase.prop.getProperty("productPrice"));
		driver.findElement(By.id("unitStock")).sendKeys(ExecuteTestcase.prop.getProperty("unitStock"));
		driver.findElement(By.id("productImage")).sendKeys(ExecuteTestcase.prop.getProperty("imgName"));
		driver.findElement(By.xpath("//div[@class='form-actions']/button[1]")).click();
		Thread.sleep(5000);
		System.out.println("Product Added successFully");
		
	}
	
	public static boolean checkProductAdded(WebDriver driver){
		driver.findElement(By.xpath("//div[@id='myNavbar']/ul[1]/li[2]")).click();
		//Checking whether the Products is listed
		String prodName =ExecuteTestcase.prop.getProperty("productName");
		boolean check = false;
		try{
			WebElement element = driver.findElement(By.xpath("//table[@id='productList']/tbody/tr/td[text() = '"+prodName+"']"));
			if(element.isDisplayed())
			{
				check = true;
			}
		}
		catch(Exception e)
		{
			check = false;
		}

		return check;
	}
}
