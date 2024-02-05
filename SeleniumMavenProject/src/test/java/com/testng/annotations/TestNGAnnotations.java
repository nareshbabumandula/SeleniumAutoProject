package com.testng.annotations;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAnnotations extends Generic {
	
	//The @BeforeTest annotated method will be executed before the execution of all the test methods of available classes belonging to that folder.
	@BeforeTest(groups = "smoke")
	void accessSite() {
		System.out.println("Accessed Amazon site..!");
	}

	// The @BeforeClass annotated method will be executed before the first method of the current class is invoked.
	@BeforeClass(groups = "smoke")
	void login() {
		System.out.println("Logged into the Amazon site..!");
	}

	@Parameters("product")
	@Test(priority = 1, groups = "smoke")
	void searchProduct(String product) {
		System.out.println("Searched the product : " + product);
	}

	@Test(priority = 2, groups = "smoke")
	void addToCart() {
		//Assert.assertTrue(false);  // hard assertion
		SoftAssert softassert = new SoftAssert();
		softassert.assertTrue(false); // soft assertion or verification
		System.out.println("Added the product to the cart..!");
		softassert.assertAll();
	}
	
	@Test(dependsOnMethods = {"addToCart"}, groups = "smoke", alwaysRun = true)
	void checkOut() {
		System.out.println("Checkedout the product..!");
	}

	@Test(dependsOnMethods = {"checkOut"}, groups = "smoke", enabled = true)
	void placeOrder() {
		System.out.println("Order placed successfully..!");
	}
	
	// The @AfterClass annotated method will be invoked after the execution of all the test methods of the current class.
	@AfterClass()
	void viewReceipt() {
		System.out.println("Viewed the receipt..!");
	}
	
	// The @AfterTest annotated method will be executed after the execution of all the test methods of available classes belonging to that folder.
	@AfterTest(groups = "smoke")
	void logout() {
		System.out.println("Logged out from Amazon site..!");
	}
	
	// The @BeforeMethod annotated method will be executed before each test method will run.
	@BeforeMethod
	void verifyProduct() {
		System.out.println("Verified the product..!");
	}
	
	// The @AfterMethod annotated method will run after the execution of each test method.
	@AfterMethod
	void verifyQuanity() {
		System.out.println("Verified the quantity..!");
	}

	
}

class Generic{
	
	// The @BeforeSuite annotated method will run before the execution of all the test methods in the suite.
	@BeforeSuite(groups = "smoke")
	void launchBrowser() {
		System.out.println("Launched the browser..!");
	}
	
	// The @AfterSuite annotated method will run after the execution of all the test methods in the suite.
	@AfterSuite(groups = "smoke")
	void closeBrowser() {
		System.out.println("Closed the browser..!");
	}

	
}
