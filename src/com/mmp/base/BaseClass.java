package com.mmp.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver driver;
	
	
	public void setUpBrowser() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
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
	
	public void closeBrowser() {
		driver.close();
	}
			
}