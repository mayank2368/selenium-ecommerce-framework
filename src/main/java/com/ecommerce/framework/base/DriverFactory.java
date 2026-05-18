package com.ecommerce.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.ecommerce.framework.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static WebDriver driver;

	public static WebDriver initDriver() {

		String browser = ConfigReader.getProperty("browser");

		// Chrome
		if (browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver();
		}

		// Firefox
		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
		}

		// Edge
		else if (browser.equalsIgnoreCase("edge")) {

			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
		}

		else if (browser.equalsIgnoreCase("safari")) {

			driver = new SafariDriver();
		}

		// Invalid browser
		else {

			throw new RuntimeException("Invalid browser: " + browser);
		}

		driver.manage().window().maximize();

		return driver;
	}
}