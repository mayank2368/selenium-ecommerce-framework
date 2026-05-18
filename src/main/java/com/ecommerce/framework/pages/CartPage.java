package com.ecommerce.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.framework.utils.WaitUtils;

public class CartPage {

	WebDriver driver;
	WaitUtils wait;

	// Constructor
	public CartPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		wait = new WaitUtils(driver);
	}

	// Product name in cart
	@FindBy(className = "inventory_item_name")
	WebElement productName;

	// Get product text
	public String getProductName() {

		wait.waitForElementToBeVisible(productName);

		wait.addDelay(2000);

		return productName.getText();
	}
}