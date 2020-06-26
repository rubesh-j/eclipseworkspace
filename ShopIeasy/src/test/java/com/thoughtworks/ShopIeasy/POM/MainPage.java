package com.thoughtworks.ShopIeasy.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
@FindBy(name="j_username")
WebElement username;
@FindBy(name="j_password")
WebElement password;
@FindBy(xpath="//div[@id='button']/button[1]")
WebElement submit;
WebDriver driver;
@FindBy(linkText="Login")
WebElement logIn;
@FindBy(linkText="Logout")
WebElement logout;
public MainPage(WebDriver driver){
	this.driver = driver;
    PageFactory.initElements(driver, this);
}

public void login(String userKey, String pwdKey){
	logIn.click();
	username.sendKeys(userKey);
	password.sendKeys(pwdKey);
	submit.click();
	
}

public void logout(){
	logout.click();
}

}
