package com.selenium.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TextboxTest extends Base {
	

	@Test
	public void textboxMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement username = driver.findElement(By.id("user"));
			System.out.println(username.isDisplayed());
			System.out.println(username.isEnabled());
			System.out.println(username.getAttribute("name"));
			test.log(LogStatus.PASS, "Name attribute value is : " + username.getAttribute("name"));
			System.out.println(username.getAttribute("type"));
			test.log(LogStatus.PASS, "Type attribute value is : " + username.getAttribute("type"));
			System.out.println(username.getAttribute("class"));
			System.out.println(username.getAttribute("id"));
			System.out.println(username.getAttribute("value"));
			System.out.println(username.getAttribute("tabindex"));	
			System.out.println(username.getTagName());
			username.sendKeys("Ravikanth"); // Enter text in the textbox
			System.out.println(username.getAttribute("value"));
		
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on a textbox");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on a textbox since : "+ errMsg);
			}
		}
	}
	
	
	@BeforeClass
	public void accessSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		test =report.startTest("Textbox_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
