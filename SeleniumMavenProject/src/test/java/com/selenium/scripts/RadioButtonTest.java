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

public class RadioButtonTest extends Base{

	@Test
	public void radiobuttonMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement radioButton = driver.findElement(By.xpath("//input[@id='q4' and @value='First Option']"));
			System.out.println(radioButton.isDisplayed());
			System.out.println(radioButton.isEnabled());
			System.out.println("Before selecting radio status is : " + radioButton.isSelected());
			radioButton.click();
			System.out.println("After selecting radio status is : " + radioButton.isSelected());
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on a radio button");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on a radio button since : "+ errMsg);
			}
		}
	}
	
	
	@BeforeClass
	public void accessSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sample Forms")).click();
		test =report.startTest("Radio Button_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
