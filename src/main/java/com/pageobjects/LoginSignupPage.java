package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginSignupPage extends BaseClass{
	
	@FindBy(xpath = "//h2[contains(text(),'New User Signup!')]")
	WebElement SignUpTitle;
	
	@FindBy(name = "name")
	WebElement NameField;
	
	@FindBy(xpath="(//input[contains(@name,'email')])[2]")
	WebElement EmailField;
	
	@FindBy(xpath = "(//button[contains(@class,'btn-default')])[2]")
	WebElement SignupBtn;
	
	public void isSignUpTitleVIsible() {
		Boolean value = SignUpTitle.isDisplayed();
		System.out.println("Sign Up title displayed: " + value);
	}
	
	public void enterNewUserInfo(String username, String emailAddress) {
		NameField.sendKeys(username);
		EmailField.sendKeys(emailAddress);
	}
	
	public SignupPage clickOnSignUp() {
		action.moveToElement(SignupBtn).click().build().perform();
		return new SignupPage();
	}
	
	public LoginSignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}
