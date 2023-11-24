package com.selenium.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserTest {

	static WebDriver driver;

	public static void browserTest(String strBrowser) throws InterruptedException {
		switch (strBrowser) {
		case "chrome": case "google":
			System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "edge": case "chromium":
			System.setProperty("webdriver.edge.driver", "./browsers/msedgedriver.exe");
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
		Thread.sleep(2000);
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		browserTest("chrome");
		browserTest("edge");
	}

}
