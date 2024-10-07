package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.base.BaseClass;

public class CartPage extends BaseClass{

	@FindBy(xpath = "(//i[contains(@class,'shopping-cart')])[1]")
	WebElement cartBtn;
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyProductsVisible(String productName) {
		List<WebElement> prodList = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
		for(WebElement product: prodList) {
			Assert.assertTrue(product.getText().contains(productName));
		}
	}
	
	public void clickOnCartBtn() {
		action.moveToElement(cartBtn).click().build().perform();
	}
}
