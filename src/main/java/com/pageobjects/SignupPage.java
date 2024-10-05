package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.BaseClass;

public class SignupPage extends BaseClass{
	
	
	@FindBy(xpath = "(//h2[contains(@class,'text-center')])[1]")
	WebElement SignupPageTitle;
	
	@FindBy(id="uniform-id_gender1")
	WebElement MrTitleRadioBtn;
	
	@FindBy(id="uniform-id_gender2")
	WebElement MrsTitleRadioBtn;
	
	@FindBy(id ="name")
	WebElement NameField;
	
	@FindBy(id="email")
	WebElement EmailField;
	
	@FindBy(id="password")
	WebElement PasswordField;
	
	@FindBy(xpath="//input[contains(@id,'newsletter')]")
	WebElement NewsletterCheckBox;
	
	@FindBy(xpath="//input[contains(@id,'optin')]")
	WebElement OfferCheckBox;
	
	@FindBy(id="first_name")
	WebElement FirstNameField;
	
	@FindBy(id="last_name")
	WebElement LastNameField;
	
	@FindBy(id="address1")
	WebElement AddressField;
	
	@FindBy(id="country")
	WebElement CountryDropDown;
	
	@FindBy(id="state")
	WebElement StateField;
	
	@FindBy(id="city")
	WebElement CityField;
	
	@FindBy(id="zipcode")
	WebElement ZipcodeField;
	
	@FindBy(id="mobile_number")
	WebElement MobileField;
	
	@FindBy(xpath="(//button[contains(@class,'btn-default')])[1]")
	WebElement CreateAccountBtn;
	
	
	public void isSignupPageLoaded() {
		String title = SignupPageTitle.getText();
		Boolean value = title.contains("ENTER ACCOUNT INFORMATION");
		System.out.println("Signup page title visible: " + value);
	}
	
	public void enterNewUserCreds(String Title, String password, String day, String month, String year) {
		if (Title == "Mr") {
			action.moveToElement(MrTitleRadioBtn).click().build().perform();
//			MrTitleRadioBtn.click();
		}
		else {
			action.moveToElement(MrsTitleRadioBtn).click().build().perform();
//			MrsTitleRadioBtn.click();
		}
		PasswordField.sendKeys(password);
		
		Select sel = new Select(driver.findElement(By.id("days")));
		sel.selectByValue(day);
		
		Select sel1 = new Select(driver.findElement(By.id("months")));
		sel1.selectByValue(month);
		
		Select sel2 = new Select(driver.findElement(By.id("years")));
		sel2.selectByValue(year);
	}
	
	public void selectNewsletterCheckBox() {
		action.moveToElement(NewsletterCheckBox).click().build().perform();
		NewsletterCheckBox.click();
	}
	
	public void selectOfferCheckBox() {
		action.moveToElement(OfferCheckBox).click().build().perform();
		OfferCheckBox.click();
	}
	
	public void enterName(String fName, String lName) {
		FirstNameField.sendKeys(fName);
		LastNameField.sendKeys(lName);
	}
	
	public void enterAddress(String address, String country, String state, String city, String code) {
		AddressField.sendKeys(address);
		Select sel3 = new Select(CountryDropDown);
		sel3.selectByValue(country);
		StateField.sendKeys(state);
		CityField.sendKeys(city);
		ZipcodeField.sendKeys(code);
	}
	
	public void enterMobileNumber(String number) {
		MobileField.sendKeys(number);
	}
	
	public AccountCreatedPage clickOnCreateAccountBtn() {
		action.moveToElement(CreateAccountBtn).click().build().perform();
//		CreateAccountBtn.click();
		return new AccountCreatedPage();
	}
	
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

}
