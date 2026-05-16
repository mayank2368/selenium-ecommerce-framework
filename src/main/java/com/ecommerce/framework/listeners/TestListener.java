package com.ecommerce.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ecommerce.framework.base.DriverFactory;
import com.ecommerce.framework.utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("Listener Triggered");

		System.out.println("Screenshot captured for: " + result.getName());

		System.out.println("Test Failed: " + result.getName());

		ScreenshotUtils.captureScreenshot(DriverFactory.driver, result.getName());
	}

	@Override
	public void onStart(ITestContext context) {

		System.out.println("Test Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {

		System.out.println("Test Execution Finished");
	}
}