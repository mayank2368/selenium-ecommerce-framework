package com.ecommerce.framework.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public WaitUtils(WebDriver driver) {

		this.driver = driver;

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	// Wait for visibility
	public void waitForElementToBeVisible(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for clickable
	public void waitForElementToBeClickable(WebElement element) {

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Demo delay
	public void addDelay(int milliseconds) {

		try {
			Thread.sleep(milliseconds);

		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}