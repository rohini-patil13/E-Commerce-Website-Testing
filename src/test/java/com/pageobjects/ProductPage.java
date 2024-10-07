package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class ProductPage extends BaseClass{

	@FindBy(xpath = "(//h2[contains(@class,'text-center')])[1]")
	WebElement ProductsPageTitle;
	
	@FindBy(xpath = "//div[contains(@class,'product-image-wrapper')]")
	WebElement ProductList;
	
	@FindBy(xpath = "(//i[contains(@class,'fa-plus-square')])[1]")
	WebElement viewProductBtn;
	
	@FindBy(xpath = "//div[@class='product-information']//h2")
	WebElement prodName;
	
	@FindBy(xpath = "//div[@class='product-information']//p")
	WebElement prodCategory;
	
	@FindBy(xpath = "//div[@class='col-sm-7']//span//span")
	WebElement prodPrice;
	
	@FindBy(xpath = "(//div[@class='product-information']//p)[2]")
	WebElement prodAvailability;
	
	@FindBy(xpath = "(//div[@class='product-information']//p)[3]")
	WebElement prodCondition;
	
	@FindBy(xpath = "(//div[@class='product-information']//p)[4]")
	WebElement prodBrand;
	
	@FindBy(name = "search")
	WebElement searchInputField;
	
	@FindBy(id = "submit_search")
	WebElement searchBtn;
	
	@FindBy(xpath = "//button[contains(@class,'btn btn-success')]")
	WebElement contShoppingBtn;
	
	@FindBy(xpath = "(//i[contains(@class,'shopping-cart')])[1]")
	WebElement cartBtn;

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void isProductsPageLoaded() {
		Boolean value = ProductsPageTitle.isDisplayed();
		System.out.println("Products page displayed? : " + value);
	}
	
	public void isProductListsVisible() {
		List<WebElement> prodList = driver.findElements(By.className("product-image-wrapper"));
		if(prodList.size() > 0) {
			for(int i = 0; i < prodList.size(); i++) {
				Assert.assertTrue(prodList.get(i).isDisplayed());
			}
		}
	}
	
	public void clickOnViewProduct() {
		action.moveToElement(viewProductBtn).click().build().perform();
	}
	
	public void isProductDetailPageLoaded() {
		Boolean value = driver.findElement(By.xpath("//div[@class='view-product']")).isDisplayed();
		Assert.assertTrue(value);
	}
	
	public void verifyProductDetails() {
		Assert.assertTrue(prodName.isDisplayed());
		Assert.assertTrue(prodCategory.isDisplayed());
		Assert.assertTrue(prodPrice.isDisplayed());
		Assert.assertTrue(prodAvailability.isDisplayed());
		Assert.assertTrue(prodCondition.isDisplayed());
		Assert.assertTrue(prodBrand.isDisplayed());
	}
	
	public void enterProductNameInSearchField(String productName) {
		action.moveToElement(searchInputField).click().build().perform();
		action.sendKeys(searchInputField, productName);
		action.moveToElement(searchBtn).click().build().perform();
	}
	
	public void verifySearchProductResult(String productName) {
		List<WebElement> prodList = driver.findElements(By.className("product-image-wrapper"));
		if(prodList.size() > 0) {
			for(int i = 0; i < prodList.size(); i++) {
				System.out.println("Product text: " + prodList.get(i).getText());
				Assert.assertTrue(prodList.get(i).getText().contains(productName));
			}
		}
	}
	
	public void addSearchRelatedProductsToCart() {
		List<WebElement> prodCartList = driver.findElements(By.xpath("//div[@class='product-image-wrapper']/div/div/a"));
		if (prodCartList.size() > 0) {
			for(WebElement cart: prodCartList) {
				action.moveToElement(cart).click().build().perform();
				action.moveToElement(contShoppingBtn).click().build().perform();
				}
			}
			
		}
	
	public CartPage clickOnCartBtn() {
		action.moveToElement(cartBtn).click().build().perform();
		return new CartPage();
	}
	
}
	
	
	

