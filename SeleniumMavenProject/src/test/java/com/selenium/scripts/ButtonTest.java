package com.selenium.scripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class ButtonTest extends Base{

	@Test
	public void buttonMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement btnLogin = driver.findElement(By.name("btnSubmit"));
			System.out.println(btnLogin.isDisplayed());
			System.out.println(btnLogin.isEnabled());
			System.out.println(btnLogin.getAttribute("name"));
			test.log(LogStatus.PASS, "Name attribute value is : " + btnLogin.getAttribute("name"));
			System.out.println(btnLogin.getAttribute("type"));
			test.log(LogStatus.PASS, "Type attribute value is : " + btnLogin.getAttribute("type"));
			System.out.println(btnLogin.getAttribute("class"));
			System.out.println(btnLogin.getTagName());
			btnLogin.click();
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on a button");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on a button since : "+ errMsg);
			}
		}
	}
	
	
	@BeforeClass
	public void accessSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		test =report.startTest("Button_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
