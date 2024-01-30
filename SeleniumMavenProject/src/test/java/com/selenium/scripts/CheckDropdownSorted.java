package com.selenium.scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class CheckDropdownSorted {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.twoplugs.com/newsearchserviceneed");
        driver.manage().window().maximize();

        Select options = new Select(driver.findElement(By.name("category_id")));

        // Get all options from category dropdown
        List<WebElement> lists = options.getOptions();

        //Creating a List to store all dropdown values
        List OriginalList = new ArrayList();

        //Using for-each loop fetch all options one by one and get their values
        for(WebElement ele : lists) {

            OriginalList.add(ele.getText());
        }

        System.out.println("Options in dropdown: " +OriginalList);

        //Creating temp List - same copy of Original for comparing purpose
        List templist = new ArrayList(OriginalList);

        System.out.println("Temp List: " + templist);

        //Sorting the Original List
        Collections.sort(OriginalList);
        System.out.println("Sorted List:" + OriginalList );


        // In IF Condition we will compare both List
        if(OriginalList.equals(templist)) {

            System.out.println("List is Sorted");

        }else {

            System.out.println("List is unsorted");
        }

        driver.quit();

    }
}
