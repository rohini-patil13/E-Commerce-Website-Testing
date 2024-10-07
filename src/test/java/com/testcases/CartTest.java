package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageobjects.CartPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginSignupPage;
import com.pageobjects.ProductPage;

public class CartTest extends BaseClass{
  

	HomePage home;
	ProductPage product;
	CartPage cart;
	LoginSignupPage login;
	
	@BeforeMethod
	public void setup() {
		loadConfig();
		launchBrowser();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@Test
	public void verifyCartAfterLogin() {
		home = new HomePage();
		home.isHomePageLoaded();
		product = home.clickOnProductsBtn();
		product.enterProductNameInSearchField("Top");
		product.isProductListsVisible();
		product.addSearchRelatedProductsToCart();
		cart = product.clickOnCartBtn();
		cart.verifyProductsVisible("Top");
		login = home.clickOnSignUpLoginInBtn();
		login.isLoginTitleVisible();
		login.enterLoginCreds("useracc@gmail.com", "Qwerty@123");
		login.clickOnLoginBtn();
		home.isUserLoggedIn("newUser");
		cart.clickOnCartBtn();
		cart.verifyProductsVisible("Top");
	}
	
}
