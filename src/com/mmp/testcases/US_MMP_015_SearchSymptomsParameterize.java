package com.mmp.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.base.BaseClass;


public class US_MMP_015_SearchSymptomsParameterize extends BaseClass {
	
	
	@Parameters({"url","username","password", "symptom"})
	@Test
	public void TC_001_searchSymptoms(String url,String username,String password,String symptom) throws InterruptedException{
		
		setUpBrowser();
		login(url,username,password);
		driver.findElement(By.xpath("//span[contains(text(),'Search Symptoms')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='search']")).click();
		driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(symptom);
		Thread.sleep(2000);
		driver.findElement(By.name("submit")).click();
		closeBrowser();

	}	
	
	
	
		
	}
	
		