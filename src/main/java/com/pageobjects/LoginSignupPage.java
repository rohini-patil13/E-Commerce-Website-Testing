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
	
	@FindBy(name = "password")
	WebElement LoginPasswordField;
	
	@FindBy(xpath="(//input[contains(@name,'email')])[2]")
	WebElement EmailField;
	
	@FindBy(xpath="(//input[contains(@name,'email')])[1]")
	WebElement LoginEmailField;
	
	@FindBy(xpath = "(//button[contains(@class,'btn-default')])[2]")
	WebElement SignupBtn;
	
	@FindBy(xpath = "(//button[contains(@class,'btn-default')])[1]")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//h2[text()='Login to your account']")
	WebElement LoginTitle;
	
	@FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
	WebElement IncorrectCredsErrorMessage;
	
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
	
	public void clickOnLoginBtn() {
		action.moveToElement(LoginBtn).click().build().perform();
	}
	
	public LoginSignupPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void isLoginTitleVisible() {
		Boolean value = LoginTitle.isDisplayed();
		System.out.println("Login title displayed: " + value);
	}
	
	public void enterLoginCreds(String emailAddress, String password) {
		LoginEmailField.sendKeys(emailAddress);
		LoginPasswordField.sendKeys(password);
	}
	
	public void isInvaidUserErrorDisplayed() {
		Boolean value = IncorrectCredsErrorMessage.isDisplayed();
		System.out.println("Error message displayed: " + value);
	}
}
