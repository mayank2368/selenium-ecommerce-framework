package com.ecommerce.framework.pages;

import java.util.List;

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

	// All product names
	@FindBy(className = "inventory_item_name")
	List<WebElement> allProducts;

	// Cart icon
	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	// Dynamic product add
	public void addProductToCart(String productName) {

		boolean productFound = false;

		// Loop through all products
		for (WebElement product : allProducts) {

			String currentProduct = product.getText();

			System.out.println("Available Product: " + currentProduct);

			if (currentProduct.equals(productName)) {

				productFound = true;

				String xpath = "//div[text()='" + productName + "']/ancestor::div[@class='inventory_item']//button";

				WebElement addButton = driver.findElement(By.xpath(xpath));

				wait.waitForElementToBeClickable(addButton);

				addButton.click();

				wait.addDelay(2000);

				System.out.println(productName + " added successfully");

				break;
			}
		}

		// If product not found
		if (!productFound) {

			throw new RuntimeException("Product NOT found: " + productName);
		}
	}

	// Open cart
	public void goToCart() {

		wait.waitForElementToBeClickable(cartIcon);

		cartIcon.click();

		wait.addDelay(2000);
	}
}