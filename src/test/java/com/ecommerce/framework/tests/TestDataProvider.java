package com.ecommerce.framework.tests;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider(name = "loginData")
	public Object[][] loginData() {

		return new Object[][] {

				// Valid login
				{ "standard_user", "secret_sauce" }, };
	}
}