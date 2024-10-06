package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageobjects.HomePage;
import com.pageobjects.LoginSignupPage;


@Listeners(com.utility.ListenerCLass.class)

public class LoginTest extends BaseClass{
	
	HomePage home = null;
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
	public void loginWithExistingUser() {
		home = new HomePage();
		home.isHomePageLoaded();
		login = home.clickOnSignUpLoginInBtn();
		login.isLoginTitleVisible();
		login.enterLoginCreds("useracc@gmail.com", "Qwerty@123");
		login.clickOnLoginBtn();
		home.isUserLoggedIn("newUser");
	}

	@Test
	public void loginwithInvalidCreds() {
		home = new HomePage();
		home.isHomePageLoaded();
		login = home.clickOnSignUpLoginInBtn();
		login.isLoginTitleVisible();
		login.enterLoginCreds("fakeuser@gmail.com", "Qwerty@123");
		login.clickOnLoginBtn();
		login.isInvaidUserErrorDisplayed();
	}
	
	@Test
	public void logoutUser() {
		home = new HomePage();
		home.isHomePageLoaded();
		login = home.clickOnSignUpLoginInBtn();
		login.isLoginTitleVisible();
		login.enterLoginCreds("useracc@gmail.com", "Qwerty@123");
		login.clickOnLoginBtn();
		home.isUserLoggedIn("newUser");
		home.clickOnLogoutBtn();
		login.isLoginTitleVisible();

	}
}
