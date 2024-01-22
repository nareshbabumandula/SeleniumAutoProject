package com.selenium.scripts;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class DropdownTest extends Base{

	@Test
	public void dropdownMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement predefinedCountries = driver.findElement(By.xpath("//select[@id='q9']"));
			System.out.println(predefinedCountries.isDisplayed());
			System.out.println(predefinedCountries.isEnabled());
	
			Select select = new Select(predefinedCountries);
			select.selectByIndex(2); 
			Thread.sleep(2000);
			select.selectByVisibleText("India");
			System.out.println(select.getFirstSelectedOption());
			System.out.println(select.isMultiple());
					
			List<WebElement> options = select.getOptions();
			// Select last but one value from a dropdown
			select.selectByIndex(options.size()-2);
			Thread.sleep(2000);
			System.out.println(options.size());
			System.out.println("Looping through for each loop on predefinedCountries");
			for (WebElement country : options) {
				System.out.println(country.getText());
			}
			System.out.println("Looping through for loop on predefinedCountries");
			for (int i = 0; i < options.size(); i++) {
				System.out.println(options.get(i).getText());
			}
			
			System.out.println("Looping through for loop using lamba expression");
			options.forEach(country->System.out.println(country.getText()));

					
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on a dropdown");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on a dropdown since : "+ errMsg);
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
		test =report.startTest("Dropdown_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
