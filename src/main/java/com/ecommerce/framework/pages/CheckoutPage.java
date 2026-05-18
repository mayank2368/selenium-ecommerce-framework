package com.ecommerce.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.framework.utils.WaitUtils;

public class CheckoutPage {

	WebDriver driver;
	WaitUtils wait;

	// Constructor
	public CheckoutPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

		wait = new WaitUtils(driver);
	}

	// Checkout button
	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	// User details
	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	// Continue
	@FindBy(id = "continue")
	WebElement continueBtn;

	// Finish order
	@FindBy(id = "finish")
	WebElement finishBtn;

	// Success message
	@FindBy(className = "complete-header")
	WebElement successMessage;

	// Checkout flow
	public void completeCheckout(String fName, String lName, String zip) {

		wait.waitForElementToBeClickable(checkoutBtn);

		checkoutBtn.click();

		wait.addDelay(2000);

		firstName.sendKeys(fName);

		wait.addDelay(1000);

		lastName.sendKeys(lName);

		wait.addDelay(1000);

		postalCode.sendKeys(zip);

		wait.addDelay(1000);

		continueBtn.click();

		wait.addDelay(2000);

		finishBtn.click();

		wait.addDelay(2000);
	}

	// Success validation
	public String getSuccessMessage() {

		wait.waitForElementToBeVisible(successMessage);

		return successMessage.getText();
	}
}