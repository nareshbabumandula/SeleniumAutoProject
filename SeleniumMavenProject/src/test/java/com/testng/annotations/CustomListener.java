package com.testng.annotations;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started : " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed : " + result.getName());
	}
}
