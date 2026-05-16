package com.ecommerce.framework.tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {

		return new Object[][] {

				// Valid login

				// Invalid password
				{ "standard_user", "wrong_password" },

				// Invalid username

		};
	}
}