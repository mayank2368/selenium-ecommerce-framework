package com.ecommerce.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.framework.base.BaseTest;
import com.ecommerce.framework.pages.CartPage;
import com.ecommerce.framework.pages.CheckoutPage;
import com.ecommerce.framework.pages.LoginPage;
import com.ecommerce.framework.pages.ProductPage;

@Listeners(com.ecommerce.framework.listeners.TestListener.class)

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)

	public void endToEndTest(String username, String password) {

		// Login page
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		waitForDemo();

		// Product page
		ProductPage productPage = new ProductPage(driver);

		productPage.addProductToCart("Sauce Labs Backpack");

		productPage.goToCart();

		waitForDemo();

		// Cart page
		CartPage cartPage = new CartPage(driver);

		String actualProduct = cartPage.getProductName();

		// Validation
		Assert.assertEquals(actualProduct, "Sauce Labs Backpack", "Product not added correctly!");

		System.out.println("Product added successfully");

		// Checkout page
		CheckoutPage checkoutPage = new CheckoutPage(driver);

		checkoutPage.completeCheckout("Mayank", "Parvati", "12345");

		String successText = checkoutPage.getSuccessMessage();

		Assert.assertEquals(successText, "Thank you for your order!", "Order placement failed!");

		System.out.println("Order placed successfully");
	}

	public void waitForDemo() {

		try {

			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

}