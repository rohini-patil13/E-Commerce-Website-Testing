package com.testcases;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageobjects.HomePage;
import com.pageobjects.ProductPage;

public class ProductTest extends BaseClass{

	HomePage home;
	ProductPage product;
	
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
	public void verifyProductPageDetails() {
		home = new HomePage();
		home.isHomePageLoaded();
		product = home.clickOnProductsBtn();
		product.isProductListsVisible();
		product.clickOnViewProduct();
		product.isProductDetailPageLoaded();
		product.verifyProductDetails();
	}
	
	@Test
	public void verifyProductSearch() {
		home = new HomePage();
		home.isHomePageLoaded();
		product = home.clickOnProductsBtn();
		product.enterProductNameInSearchField("Blue Top");
		product.verifySearchProductResult("Blue Top");	
		}
}
