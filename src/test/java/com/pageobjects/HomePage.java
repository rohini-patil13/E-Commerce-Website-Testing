package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//a[contains(text(),'Signup / Login')]") 
	WebElement SignuploginBtn;
	
	@FindBy(xpath  = "(//div[@class='col-sm-6']//h1//span)[1]")
	WebElement homePageText;
	
	@FindBy(xpath ="//i[contains(@class,'fa-user')]")
	WebElement LoggedInAsUserText;
	
	@FindBy(xpath = "//i[contains(@class,'fa-trash')]")
	WebElement deleteAccountBtn;
	
	@FindBy(xpath = "//i[contains(@class,'fa-lock')]")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//i[contains(@class,'card_travel')]")
	WebElement ProductsBtn;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginSignupPage clickOnSignUpLoginInBtn() {
		action.moveToElement(SignuploginBtn).click().build().perform();
//		SignuploginBtn.click();
		return new LoginSignupPage();
	}
	
	public void isHomePageLoaded() {
		Boolean value = homePageText.isDisplayed();
		System.out.println("Home page loaded: "+ value);
	}
	
	public void isUserLoggedIn(String username) {
		Boolean value = LoggedInAsUserText.isDisplayed();
		System.out.println("User is logged in?: " + value);
	}
	
	public AccountDeletedPage clickOnDeleteAccountOption() {
		action.moveToElement(deleteAccountBtn).click().build().perform();
//		deleteAccountBtn.click();
		return new AccountDeletedPage();
	}
	
	public void clickOnLogoutBtn() {
		action.moveToElement(logoutBtn).click().build().perform();
	}
	
	public ProductPage clickOnProductsBtn() {
		action.moveToElement(ProductsBtn).click().build().perform();
		return new ProductPage();
	}
}
