package com.thoughtworks.ShopIeasy;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.thoughtworks.ShopIeasy.POM.AddProductsPage;
import com.thoughtworks.ShopIeasy.POM.ProductDetailsPage;

public class TestAdminFunctions {
	
	
	public static AddProductsPage addObj;
	public static ProductDetailsPage detailsObj;
	public static HashMap<String,String> productValues = new HashMap<String,String>();
	public static void addProductsbyAdmin(WebDriver driver) throws InterruptedException
	{
		System.out.println("Logged in as " + BaseTest.prop.getProperty("adminMail"));
		driver.findElement(By.xpath("//div[@id='myNavbar']/ul[1]/li[4]")).click();
		loadMap();
		addObj = new AddProductsPage(driver);
		System.out.println("Into Add Products page");
		addObj.fillProductDetails(productValues);
		addObj.addProduct();
		Thread.sleep(5000);
		System.out.println("Product Added successFully");
		
	}
	
	public static boolean checkProductAdded(WebDriver driver){
		driver.findElement(By.xpath("//div[@id='myNavbar']/ul[1]/li[2]")).click();
		//Checking whether the Products is listed
		String prodName = BaseTest.prop.getProperty("productName");
		boolean check = false;
		loadMap();
		try{
			WebElement element = driver.findElement(By.xpath("//table[@id='productList']/tbody/tr/td[text() = '"+prodName+"']"));
			if(element.isDisplayed())
			{
				driver.findElement(By.xpath("//table[@id='productList']/tbody/tr/td[text() = '"+prodName+"']/parent::tr/td[9]/a[1]/span[1]")).click();
				
				detailsObj = new ProductDetailsPage(driver);
				System.out.println(detailsObj.checkEachFields(productValues));
				if(!detailsObj.checkEachFields(productValues).containsValue(false)){
					check = true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			check = false;
		}

		return check;
	}

	public static void loadMap(){
		productValues.put("productName", BaseTest.prop.getProperty("productName"));
		productValues.put("productDescription", BaseTest.prop.getProperty("productDescription"));
		productValues.put("productManufacturer", BaseTest.prop.getProperty("productManufacturer"));
		productValues.put("productPrice", BaseTest.prop.getProperty("productPrice"));
		productValues.put("unitStock", BaseTest.prop.getProperty("unitStock"));
		productValues.put("imgName", BaseTest.prop.getProperty("imgName"));
	}
	}
