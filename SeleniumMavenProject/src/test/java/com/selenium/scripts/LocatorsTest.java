package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsTest {

	static WebDriver driver;

	@BeforeClass
	public void accessSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
	}

	@Test(priority = 0)
	public void locatorsExample() throws InterruptedException {
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
		driver.findElement(By.tagName("input")).clear();
		// 8. XPath Locator
		driver.findElement(By.xpath("//input[@id='subject']")).sendKeys("ravikanth@gmail.com");
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void advancedlocatorsExample() throws InterruptedException {
		// 9. Absolute XPath
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).sendKeys("Prabhakar");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/form/fieldset/div/input")).clear();
		// 10. Relative XPath
		driver.findElement(By.xpath("//form/fieldset/div/input")).sendKeys("Ravikanth");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//form/fieldset/div/input")).clear();
		// 11. Relative XPath with Id attribute
		driver.findElement(By.xpath("//input[@id='user']")).sendKeys("Naresh");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='user']")).clear();
		// 12. Relative XPath with Name attribute
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("Shiva");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@name='user']")).clear();
		// 13. Xpath with starts-with method
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).sendKeys("Bharath");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[starts-with(@id,'use')]")).clear();

		// 14. Xpath with contains method
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("Karuna");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).clear();

		// 15. CSS with starts with
		driver.findElement(By.xpath("input[id^='use']")).sendKeys("Ravi");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("input[id^='use']")).clear();


		// 16. CSS with ends with
		driver.findElement(By.xpath("input[id$='er']")).sendKeys("Sagar");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("input[id$='er']")).clear();


		// 17. CSS with contains
		driver.findElement(By.xpath("input[id*='ser']")).sendKeys("Tony");
		Thread.sleep(2000); 
		driver.findElement(By.xpath("input[id*='ser']")).clear();


	}

	@AfterClass
	public void closeBrowser() {
		driver.quit(); 
	}

}
