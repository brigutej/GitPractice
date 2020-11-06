package com.mmp.testcases;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateMenu {
    @Test
	public void validateMenu() {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/searchsymptoms.php");
        
		WebElement home = driver.findElement(By.xpath("//a[@href='profile.php']//preceding::span[1]"));
	    WebElement profile = driver.findElement(By.xpath("//a[@href='profile.php']//span"));
	    WebElement schapt = driver.findElement(By.xpath("//li[@class='submenu'][1]//span"));
	    WebElement info = driver.findElement(By.xpath("//li[@class='submenu'][2]//span[@class='hidden-minibar']"));;
	    WebElement fees = driver.findElement(By.xpath("//li[@class='submenu'][3]//span[@class='hidden-minibar']"));
	    WebElement SS = driver.findElement(By.xpath("//li[@class='submenu'][4]//span[@class='hidden-minibar']"));
	    WebElement Msg = driver.findElement(By.xpath("//li[@class='submenu'][5]//span[@class='hidden-minibar']"));
	    
	    
	    Assert.assertEquals(true, home.isDisplayed());
	    System.out.println("Home Menu is displayed:"+ home.isDisplayed());
	    Assert.assertEquals(true, profile.isDisplayed());
	    System.out.println("Profile sub-menu is displayed:"+profile.isDisplayed());
	    Assert.assertEquals(true, schapt.isDisplayed());
	    System.out.println("Schedule Appointment sub-menu is displayed:"+schapt.isDisplayed());
	    Assert.assertEquals(true, info.isDisplayed());
	    System.out.println("Information sub-menu is displayed:"+info.isDisplayed());
	    Assert.assertEquals(true, fees.isDisplayed());
	    System.out.println("Fees sub-menu is displayed:"+fees.isDisplayed());
	    Assert.assertEquals(true, SS.isDisplayed());
	    System.out.println("Search Symptoms sub-menu is displayed:"+SS.isDisplayed());
	    Assert.assertEquals(true, Msg.isDisplayed());
	    System.out.println("Message sub-menu is displayed:"+Msg.isDisplayed());
	    
	    driver.quit();
	    
	    /*Assert.assertEquals(true, Msg.isEnabled());
	    System.out.println("Msg submenu is enabled:"+Msg.isEnabled());
	    */
	        
	}
}
