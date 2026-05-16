package com.ecommerce.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecommerce.framework.base.BaseTest;
import com.ecommerce.framework.pages.LoginPage;

@Listeners(com.ecommerce.framework.listeners.TestListener.class)

public class LoginTest extends BaseTest {

	@Test(dataProvider = "loginData", dataProviderClass = TestDataProvider.class)

	public void loginTest(String username, String password) {

		LoginPage loginPage = new LoginPage(driver);

		loginPage.login(username, password);

		Assert.assertTrue(false);

		waitForDemo();

		String currentUrl = driver.getCurrentUrl();

		// Validation
		if (username.equals("standard_user") && password.equals("secret_sauce")) {

			Assert.assertTrue(currentUrl.contains("inventory"));

			System.out.println("Valid login successful");

		} else {

			Assert.assertFalse(currentUrl.contains("inventory"));

			System.out.println("Invalid login verified");
		}
	}

	// Demo delay
	public void waitForDemo() {

		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}