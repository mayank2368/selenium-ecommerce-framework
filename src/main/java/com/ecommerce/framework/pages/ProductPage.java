package com.ecommerce.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.framework.utils.WaitUtils;

public class ProductPage {

	WebDriver driver;
	WaitUtils wait;

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		wait = new WaitUtils(driver);
	}

	// Cart icon
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	// Dynamic product add method
	public void addProductToCart(String productName) {

		String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";

		WebElement product = driver.findElement(By.xpath(xpath));

		wait.waitForElementToBeClickable(product);

		product.click();

		// Demo delay so you can see action
		wait.addDelay(2000);
	}

	// Open cart
	public void goToCart() {

		wait.waitForElementToBeClickable(cartIcon);

		cartIcon.click();

		// Demo delay
		wait.addDelay(2000);
	}
}