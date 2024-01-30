package com.selenium.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	static WebDriver driver;

	public static void browserTest(String strBrowser) throws InterruptedException {
		switch (strBrowser) {
		case "chrome": case "google":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(); //A WebDriver implementation that controls a Chrome browser running on the local machine.
			break;
		case "edge": case "chromium":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("Invalid browser..!");
			break;
		}
		driver.get("https://www.mycontactform.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().forward();
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		browserTest("chrome");
		browserTest("edge");
	}

}
