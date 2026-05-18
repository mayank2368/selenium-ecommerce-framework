package com.ecommerce.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.ecommerce.framework.base.DriverFactory;
import com.ecommerce.framework.utils.ExtentManager;
import com.ecommerce.framework.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	// Extent report object
	ExtentReports extent = ExtentManager.getInstance();

	// Individual test
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {

		test = extent.createTest(result.getName());

		System.out.println("Test Started: " + result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		test.pass("Test Passed");

		System.out.println("Test Passed: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Listener Triggered");

		test.fail("Test Failed");

		// Capture screenshot
		String screenshotPath = ScreenshotUtils.captureScreenshot(DriverFactory.driver, result.getName());

		// Attach screenshot in report
		try {

			test.addScreenCaptureFromPath(screenshotPath);

		} catch (Exception e) {

			e.printStackTrace();
		}

		System.out.println("Screenshot captured for: " + result.getName());

		System.out.println("Test Failed: " + result.getName());
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {

		// VERY IMPORTANT
		extent.flush();

		System.out.println("Extent Report Generated");

		System.out.println("Test Execution Finished");
	}
}