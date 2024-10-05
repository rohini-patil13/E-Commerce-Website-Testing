package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AccountCreatedPage extends BaseClass{

	@FindBy(xpath  = "(//h2[contains(@class,'text-center')])[1]")
	WebElement AccountCreatedTitle;
	
	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement ContinueBtn;
	
	
	public void isAccountCreatedPageLoaded() {
		Boolean value = AccountCreatedTitle.isDisplayed();
		System.out.println("Account created page title visible: " + value);
	}
	
	public void clickOnContinue() {
		action.moveToElement(ContinueBtn).click().build().perform();
//		ContinueBtn.click();
	}
	
	public AccountCreatedPage() {
		PageFactory.initElements(driver, this);
	}
}
