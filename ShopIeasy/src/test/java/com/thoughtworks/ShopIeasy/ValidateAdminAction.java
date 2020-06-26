package com.thoughtworks.ShopIeasy;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.thoughtworks.ShopIeasy.POM.MainPage;

public class ValidateAdminAction extends BaseTest {
	
	public static TestAdminFunctions admin = new TestAdminFunctions();
	public ValidateAdminAction() throws FileNotFoundException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test
	public void addProductToListasAdmin() throws InterruptedException {
		System.out.println(prop.getProperty("adminMail"));
		MainPage objLogin = new MainPage(driver);
		objLogin.login(prop.getProperty("adminMail"), prop.getProperty("adminPswd"));		
		admin.addProductsbyAdmin(driver);
		
	}

	@Test
	public void checkAddedProductDetails()
	{
		MainPage objLogin = new MainPage(driver);
		Assert.assertTrue(admin.checkProductAdded(driver));
		TestWebUiBasic.logOut(driver);
	}
}
