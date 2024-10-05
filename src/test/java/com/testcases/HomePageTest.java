package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageobjects.AccountCreatedPage;
import com.pageobjects.AccountDeletedPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginSignupPage;
import com.pageobjects.SignupPage;

public class HomePageTest extends BaseClass{
	
	HomePage home;
	LoginSignupPage signup;
	SignupPage create;
	AccountCreatedPage confirmCreate;
	AccountDeletedPage delete;

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
	public void registerNewUser() {
		home = new HomePage();
		home.isHomePageLoaded();
		signup = home.clickOnSignUpLoginInBtn();
		signup.enterNewUserInfo("meow", "test11@zyffgfx.com");
		create = signup.clickOnSignUp();
		create.isSignupPageLoaded();
		create.enterNewUserCreds("Mr", "Qwerty123", "11", "4", "1990");
		create.selectNewsletterCheckBox();
		create.selectOfferCheckBox();
		create.enterName("tester", "auto");
		create.enterAddress("address123", "India", "AP", "City12", "654321");
		create.enterMobileNumber("987463210");
		confirmCreate = create.clickOnCreateAccountBtn();
		confirmCreate.isAccountCreatedPageLoaded();
		confirmCreate.clickOnContinue();
		home.isUserLoggedIn("meow");
		delete = home.clickOnDeleteAccountOption();
		delete.isAccountDeletedPageLoaded();
		delete.clickOnContinue();
	}
	
}
