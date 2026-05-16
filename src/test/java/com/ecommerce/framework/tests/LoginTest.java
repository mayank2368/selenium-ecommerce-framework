package com.ecommerce.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.framework.base.BaseTest;
import com.ecommerce.framework.pages.CartPage;
import com.ecommerce.framework.pages.LoginPage;
import com.ecommerce.framework.pages.ProductPage;

public class LoginTest extends BaseTest {

	@Test
	public void endToEndTest() {

		// Login
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		// Product page
		ProductPage productPage = new ProductPage(driver);

		productPage.addProductToCart("Sauce Labs Backpack");

		productPage.goToCart();

		// Cart page
		CartPage cartPage = new CartPage(driver);

		String actualProduct = cartPage.getProductName();

		// Validation
		Assert.assertEquals(actualProduct, "Sauce Labs Backpack", "Product not added correctly!");
	}
}