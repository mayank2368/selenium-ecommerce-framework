package com.ecommerce.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.framework.utils.WaitUtils;

public class LoginPage {

	WaitUtils wait;

	WebDriver driver;

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WaitUtils(driver);
	}

	// Locators (Advanced)
	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(css = "input[type='password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginBtn;

	// Actions
	public void login(String user, String pass) {

		wait.waitForElementToBeVisible(username);
		username.sendKeys(user);

		password.sendKeys(pass);

		wait.waitForElementToBeClickable(loginBtn);
		loginBtn.click();
	}
}