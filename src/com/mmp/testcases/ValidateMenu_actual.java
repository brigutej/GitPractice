package com.mmp.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateMenu_actual {
	@Test
	public void verifyMenu() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/searchsymptoms.php");
        
		WebElement home = driver.findElement(By.xpath("//a[@href='profile.php']//preceding::span[1]"));
		String strhome = home.getText();
		System.out.println(strhome);
		Assert.assertEquals("Home", strhome);
		home.click();
		
	    WebElement profile = driver.findElement(By.xpath("//a[@href='profile.php']//span"));
	    String strprofile = profile.getText();
		System.out.println(strprofile);
		Assert.assertEquals("Profile", strprofile);
		profile.click();
		
	    WebElement schapt = driver.findElement(By.xpath("//li[@class='submenu'][1]//span"));
	    String strsa = schapt.getText();
	   	System.out.println(strsa);
	  	Assert.assertEquals("Schedule Appointment", strsa);
		schapt.click();
		
	    WebElement info = driver.findElement(By.xpath("//li[@class='submenu'][2]//span[@class='hidden-minibar']"));
	    String strinfo = info.getText();
	   	System.out.println(strinfo);
		Assert.assertEquals("Information", strinfo);
		info.click();
		
	    WebElement fees = driver.findElement(By.xpath("//li[@class='submenu'][3]//span[@class='hidden-minibar']"));
	    String strfees = fees.getText();
		System.out.println(strinfo);
		Assert.assertEquals("Fees",strfees);
		fees.click();
		
	    WebElement ss = driver.findElement(By.xpath("//li[@class='submenu'][4]//span[@class='hidden-minibar']"));
	    String strss = ss.getText();
		System.out.println(strss);
		Assert.assertEquals("Search Symptoms",strss);
		ss.click();
		
	    WebElement msg = driver.findElement(By.xpath("//li[@class='submenu'][5]//span[@class='hidden-minibar']"));
	    String strmsg = msg.getText();
		System.out.println(strmsg);
		Assert.assertEquals("Message",strmsg);
		msg.click();
		
		
	    
		
	}

}
