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

public class ImageTest extends Base{

	@Test
	public void imageMethods() {
		boolean bFlag=false;
		String errMsg="";
		try {
			WebElement imgTestimonial = driver.findElement(By.xpath("//img[@class='test_img']"));
			System.out.println(imgTestimonial.isDisplayed());
			System.out.println(imgTestimonial.isEnabled());
			System.out.println(imgTestimonial.getAttribute("src"));
			test.log(LogStatus.PASS, "src attribute value is : " + imgTestimonial.getAttribute("src"));
			System.out.println(imgTestimonial.getAttribute("alt"));
			test.log(LogStatus.PASS, "Type attribute value is : " + imgTestimonial.getAttribute("alt"));
			System.out.println(imgTestimonial.getAttribute("class"));
			System.out.println(imgTestimonial.getTagName());
			imgTestimonial.click();
			bFlag=true;
		} catch (Exception e) {
			e.printStackTrace();
			errMsg=e.getMessage();
		}finally {
			if (bFlag) {
				test.log(LogStatus.PASS, "Successfully performed actions on an image");
			} else {
				test.log(LogStatus.FAIL, "Failed to perform actions on an image since : "+ errMsg);
			}
		}
	}
	
	
	@BeforeClass
	public void accessSite() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.mycontactform.com");
		driver.manage().window().maximize();
		test =report.startTest("Image_Actions");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
