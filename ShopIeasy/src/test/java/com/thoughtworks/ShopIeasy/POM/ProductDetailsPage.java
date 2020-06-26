package com.thoughtworks.ShopIeasy.POM;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
	WebDriver driver;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[2]/td[2]")
	WebElement productname;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[3]/td[2]")
	WebElement category;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[4]/td[2]")
	WebElement productDescription;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[5]/td[2]")
	WebElement productManufacturer;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[6]/td[2]")
	WebElement productPrice;
	@FindBy(xpath="//table[@id='prod']/tbody/tr[7]/td[2]")
	WebElement unitStock;
	
	HashMap<String,Boolean> assertfields;
	public  ProductDetailsPage(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	public HashMap<String,Boolean> checkEachFields(HashMap<String,String> productValues){
		assertfields = new HashMap();
		assertfields.put("productname", productname.getText().equals(productValues.get("productname")));
		assertfields.put("productDescription", productDescription.getText().equals(productValues.get("productDescription")));
		assertfields.put("productManufacturer", productManufacturer.getText().equals(productValues.get("productManufacturer")));
		assertfields.put("productPrice", productPrice.getText().equals(productValues.get("productPrice")));
		assertfields.put("unitStock", unitStock.getText().equals(productValues.get("unitStock")));
		System.out.println(assertfields);
		return assertfields;
	}
	
	
}
