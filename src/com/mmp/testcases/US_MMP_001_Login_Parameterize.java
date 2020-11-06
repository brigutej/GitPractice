package com.mmp.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_MMP_001_Login_Parameterize {
	static WebDriver driver;
	@Parameters({"url","username","password"})
	@Test
	public void TC_MMP_001_login_Valid(String url,String username,String password) {
		
		login(url,username,password);
		String titletext=  driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(titletext);
	}
		
		public void TC_MMP_001_login_Invalid(String url,String username,String password) {
			
			login(url,username,password);
			Alert alt = driver.switchTo().alert();
			System.out.println(alt.getText());
			alt.accept();
			
	}
	
	
	public void login(String url,String username,String password) {
		
		driver.get(url);
		driver.findElement(By.xpath(".//*[@id='testimonials']//div[2]/a")).click();
		driver.findElement(By.xpath(".//*[@id='username']")).click();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='password']")).click();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath(".//input[@value='Sign In']")).click();
		
	}
	@BeforeMethod
	public void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	}

