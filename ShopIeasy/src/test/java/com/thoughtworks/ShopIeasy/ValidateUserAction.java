package com.thoughtworks.ShopIeasy;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

public class ValidateUserAction extends BaseTest {

	public ValidateUserAction() throws FileNotFoundException, IOException {
		super();
	}

	@Test
	public void userSignUpValidation() {
		SignUp.userSignUp(driver);
	}

	@Test
	public void userValidProductAdd() {
		WebUiBasic.logIn("userMail", "userPwd", driver);
		UserAddtoCart.addProducttoCart(driver, "productName");
		WebUiBasic.logOut(driver);
	}

	@Test
	public void userInvalidProductAdd() {
		WebUiBasic.logIn("userMail", "userPwd", driver);
		UserAddtoCart.addProducttoCart(driver, "InproductName");
		WebUiBasic.logOut(driver);
	}

}
