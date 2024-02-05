package com.testng.annotations;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	@DataProvider(name="testData")
	public Object[][] testData(){
		return new Object[][] {{"Samsung", 30000}, {"iPhone", 90000}, {"Realme", 10000}};
	}

	@Test(dataProvider = "testData", invocationCount = 1)
	public void testMethod(String product, double price) {
		System.out.println("Product : " + product + "," + " price : "  + price);
	}

}
