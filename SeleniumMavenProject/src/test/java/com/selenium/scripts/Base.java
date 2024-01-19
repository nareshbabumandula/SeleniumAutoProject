package com.selenium.scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Base {
	
	WebDriver driver;
	static ExtentTest test;
	static ExtentReports report;

	@BeforeSuite
	public void setup() {
		report = new ExtentReports("./ExtentReportResults.html");
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
