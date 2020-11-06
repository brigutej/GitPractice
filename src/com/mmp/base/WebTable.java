package com.mmp.base;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {
	static WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal");
		WebElement webtable =driver.findElement(By.xpath("//table[@class='table']"));
		List rows=(List) webtable.findElements(By.tagName("tr"));

		//System.out.println("Number of rows "+ rows.);
		
		//Git Practice
		
		System.out.println("git");
		System.out.println("practice");
	}

}
