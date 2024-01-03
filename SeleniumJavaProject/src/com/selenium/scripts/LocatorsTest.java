package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		// 1. ID Locator
		driver.findElement(By.id("user")).sendKeys("Prabhakar");
		// 2. Name Locator
		driver.findElement(By.name("pass")).sendKeys("Secure*1234");
		Thread.sleep(2000);
		// 3. Classname Locator
		driver.findElement(By.className("btn_log")).click();
		Thread.sleep(2000);
		// 4. Linktext Locator
		driver.findElement(By.linkText("Sample Forms")).click();
		Thread.sleep(2000);
		// 5. Partial Linktext
		driver.findElement(By.partialLinkText("Featu")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sample Forms")).click();
		// 6. CSS Selector
		driver.findElement(By.cssSelector("input[name='email_to[]']")).click();
		Thread.sleep(2000);
		// 7. Tag name Locator
		driver.findElement(By.tagName("input")).sendKeys("Ravi");
		Thread.sleep(2000);
		// 8. XPath Locator
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("ravikanth@gmail.com");
		Thread.sleep(2000);
		driver.quit();
	}

}
