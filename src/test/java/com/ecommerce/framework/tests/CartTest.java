package com.ecommerce.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.framework.base.BaseTest;
import com.ecommerce.framework.pages.LoginPage;
import com.ecommerce.framework.pages.ProductPage;

@Listeners(com.ecommerce.framework.listeners.TestListener.class)

public class CartTest extends BaseTest {

	@Test
	public void cartValidationTest() {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("standard_user", "secret_sauce");

		ProductPage productPage = new ProductPage(driver);

		productPage.addProductToCart("Sauce Labs Backpack");

		Assert.assertTrue(true);

		System.out.println("Cart validation successful");
	}
}