package com.mmp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class US_MMP_015_SearchSymptoms {

	public static void main(String[] args) throws InterruptedException {
		/*System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		FirefoxDriver driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/searchsymptoms.php");
		
		driver.findElement(By.xpath("//li[7]/a/span[@class='hidden-minibar']")).click();
		
				
		driver.findElement(By.xpath(".//*[@id='search']")).click();
		driver.findElement(By.xpath(".//*[@id='search']")).sendKeys("fever");
		driver.findElement(By.name("submit")).click();
		
		
		
		
	}
	
}
