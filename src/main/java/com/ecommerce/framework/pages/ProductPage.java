package com.ecommerce.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.framework.utils.WaitUtils;

public class ProductPage {

	WebDriver driver;
	WaitUtils wait;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils(driver);
	}

	// Add to cart button for specific product
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//button")
	WebElement addToCartBackpack;

	// Cart icon
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	// Actions
	public void addBackpackToCart() {
		wait.waitForElementToBeClickable(addToCartBackpack);
		addToCartBackpack.click();
	}

	public void goToCart() {
		cartIcon.click();
	}
}