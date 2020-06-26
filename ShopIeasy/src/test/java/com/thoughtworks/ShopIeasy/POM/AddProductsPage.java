package com.thoughtworks.ShopIeasy.POM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thoughtworks.ShopIeasy.BaseTest;

public class AddProductsPage {

	@FindBy(id="productName")
	WebElement productName;
	@FindBy(id="productDescription")
	WebElement productDescription;
	@FindBy(id="productManufacturer")
	WebElement productManufacturer;
	@FindBy(id="productPrice")
	WebElement productPrice;
	@FindBy(id="unitStock")
	WebElement unitStock;
	@FindBy(id="productImage")
	WebElement productImage;
	@FindBy(xpath="//div[@class='form-actions']/button[1]")
	WebElement submit;
	WebDriver driver;

	public  AddProductsPage(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public void fillProductDetails(HashMap<String,String> productValues){
		productName.sendKeys(productValues.get("productName"));
		productDescription.sendKeys(productValues.get("productDescription"));
		productManufacturer.sendKeys(productValues.get("productManufacturer"));
		productPrice.clear();
		productPrice.sendKeys(productValues.get("productPrice"));
		unitStock.sendKeys(productValues.get("unitStock"));
		productImage.sendKeys(productValues.get("imgName"));
	}
	
	public void addProduct(){
		submit.click();
	}
	
}
