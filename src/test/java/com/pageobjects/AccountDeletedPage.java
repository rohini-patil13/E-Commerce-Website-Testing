package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class AccountDeletedPage extends BaseClass{

	@FindBy(xpath  = "(//h2[contains(@class,'text-center')])[1]")
	WebElement AccountDeletedTitle;
	
	@FindBy(xpath = "//a[contains(@class,'btn-primary')]")
	WebElement ContinueBtn;
	
	public void isAccountDeletedPageLoaded() {
		Boolean value = AccountDeletedTitle.isDisplayed();
		System.out.println("Account deleted: " + value);
	}
	
	public void clickOnContinue() {
		action.moveToElement(ContinueBtn).click().build().perform();
	}
	
	public AccountDeletedPage() {
		PageFactory.initElements(driver, this);
	}
}
