package com.mmp.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_MMP_006_ValidateMenu2 {
	WebDriver driver;
	
	
	
	@BeforeMethod
	public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
	}
	@Parameters({"url","username","password"})
	@Test
	public void TC_001_verifyMenu(String url,String username, String password) throws InterruptedException {
		
        login(url,username,password);
        
        boolean result = clickonMenuItem("HOME","Patient Portal");
        Assert.assertTrue(result);
        System.out.println(result);
        
        boolean result2 = clickonMenuItem("Profile","Personal Details");
        Assert.assertTrue(result2);
		System.out.println(result2);
		
		boolean result3 = clickonMenuItem("Schedule Appointment","Current Appointments");
        Assert.assertTrue(result3);
		
		boolean result4 = clickonMenuItem("Information","Information");
        Assert.assertTrue(result4);
	
		boolean result5 = clickonMenuItem("Fees","Fees");
        Assert.assertTrue(result5);
		
		boolean result6 = clickonMenuItem("Search Symptoms","Search Symptoms");
        Assert.assertTrue(result6);
		
		boolean result7 = clickonMenuItem("Messages","Messages");
        Assert.assertTrue(result7);
		
		driver.findElement(By.xpath("//span[contains(text(),'Logout')]")).click();
		String actual = driver.findElement(By.xpath(".//*[@id='main']//div/p")).getText();
		System.out.println(actual);
		
					}
		
	
		public void login(String url, String username, String password) {
		driver.get(url);
		driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath(".//*[@id='password']")).click();
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath(".//input[@value='Sign In']")).click();
		}
        
		public boolean clickonMenuItem(String menuName,String expected ) throws InterruptedException
	    {
	        driver.findElement(By.xpath("//span[contains(text(),'"+menuName+"')]")).click();
	        String actual = driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
	        Thread.sleep(3000);
	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        return expected.equals(actual);
	    }
	       
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
		
		
	  
