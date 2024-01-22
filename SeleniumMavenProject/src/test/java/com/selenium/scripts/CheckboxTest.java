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

public class CheckboxTest extends Base{

	@Test
	public void checkboxMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement chkMarketingDepartment = driver.findElement(By.xpath("//input[@name='email_to[]' and @value=0]"));
			System.out.println(chkMarketingDepartment.isDisplayed());
			System.out.println(chkMarketingDepartment.isEnabled());
			System.out.println("Before selecting checkbox status is : " + chkMarketingDepartment.isSelected());
			chkMarketingDepartment.click();
			System.out.println("After selecting checkbox status is : " + chkMarketingDepartment.isSelected());
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on a checkbox");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on a checkbox since : "+ errMsg);
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
		test =report.startTest("Checkbox_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
