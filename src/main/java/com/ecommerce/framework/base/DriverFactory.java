package com.ecommerce.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

			ChromeOptions options = new ChromeOptions();

			String headless = ConfigReader.getProperty("headless");

			if (headless.equalsIgnoreCase("true")) {

				options.addArguments("--headless=new");

				options.addArguments("--window-size=1920,1080");
			}

			driver = new ChromeDriver(options);
		}

		// Firefox
		else if (browser.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();

			FirefoxOptions options = new FirefoxOptions();

			String headless = ConfigReader.getProperty("headless");

			if (headless.equalsIgnoreCase("true")) {

				options.addArguments("-headless");
			}

			driver = new FirefoxDriver(options);
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