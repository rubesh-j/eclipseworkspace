package com.thoughtworks.ShopIeasy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserAddtoCart {
	public static void addProducttoCart(WebDriver driver, String prodKey)
	{
		driver.findElement(By.xpath("//div[@id='myNavbar']/ul[1]/li[2]")).click();
		//Checking whether the Products is listed
		boolean productFound = false;
		List<WebElement> rowValues = driver.findElements(By.xpath("//table[@id='productList']/tbody/tr"));
		for(WebElement product : rowValues)
		{
			if(product.findElement(By.xpath("td[4]")).getText().equals(ExecuteTestcase.prop.getProperty(prodKey)))
			{
				System.out.println("Product added to the cart");
				productFound = true;
				break;
			}
		}	
		if(!productFound)
		{
			System.out.println("Product is not available in the list");
		}
	}
}
