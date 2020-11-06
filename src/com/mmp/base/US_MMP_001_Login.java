package com.mmp.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class US_MMP_001_Login {
	static WebDriver driver;

	public static void main(String[] args) {
		
		invokeBrowser();
		login("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000","ria1","Ria12345");
		
		String titletext=  driver.findElement(By.xpath("//h3[@class='panel-title']")).getText();
		String title = driver.getTitle();
		System.out.println(title);
		System.out.println(titletext);
		closeBrowser();
       
	}
	
	public static void invokeBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	public static void login(String url,String username,String password) {
		
		driver.get(url);
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.xpath(".//*[@id='username']")).click();
		driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath(".//*[@id='password']")).click();
		driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath(".//input[@value='Sign In']")).click();
		
	}
	
	public static void closeBrowser() {
		
		driver.quit();
	}
	}

