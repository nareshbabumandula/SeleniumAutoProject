package com.selenium.scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest {

	static ExtentTest test;
	static ExtentReports report;

	WebDriver driver;

	// The annotated method will be run before the first test method in the current class is invoked.
	@BeforeClass 
	public void launchBrowser() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		System.out.println("Launched the browser..!");
		// Extent Reports
		report = new ExtentReports("./ExtentReportResults.html");
		test = report.startTest("Action Methods");
	}

	@Test
	public void mouseActionMethods() throws InterruptedException {
		boolean bFlag=false;
		try {
			driver.manage().window().maximize();
			Thread.sleep(5000);
			WebElement addons = driver.findElement(By.xpath("//div[contains(text(),'Add-ons')]"));

			Actions action = new Actions(driver);
			action.moveToElement(addons).perform();
			Thread.sleep(2000);
			String mainWindow = driver.getWindowHandle();
			System.out.println("Before clicking on SpiceFlex link : " + driver.getWindowHandles());
			driver.findElement(By.xpath("//div[contains(text(),'SpiceFlex')]")).click();
			System.out.println("After clicking on SpiceFlex link : " + driver.getWindowHandles());
			Thread.sleep(2000);
			Set<String> windows = driver.getWindowHandles();

			Iterator<String> iter = windows.iterator();

			while (iter.hasNext()) {
				String window = iter.next();
				System.out.println(window);
				driver.switchTo().window(window);
				if (!(driver.getTitle().contains("Flight Booking"))) {
					driver.switchTo().window(window);
				}
			}

			boolean blnSpiceFlex = driver.findElement(By.xpath("//strong[contains(text(),'HOW TO BOOK SPICEFLEX')]")).isDisplayed();
			Assert.assertEquals(blnSpiceFlex, true, "Failed to navigate to 'SpiceFlex' page");
			bFlag=true;	
		} catch (Exception e) {
			e.printStackTrace();
			String message = e.getMessage();
			String errorMsg[] = message.split("}");
			test.log(LogStatus.FAIL, "Failed to navigate to 'SpiceFlex' page since - " + errorMsg[0]);
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully navigated to 'SpiceFlex' page..!");
				System.out.println("Test Case Executed Successfully..!");
			} else {
				test.log(LogStatus.FAIL, "Test Case Failed..!");
				System.out.println("Test Case Failed..!");
			}
		}
	}

	// The annotated method will be run after all the test methods in the current class have been run.
	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		report.endTest(test);
		report.flush();
		driver.quit();
		System.out.println("Closed the browser..!");
	}


}
