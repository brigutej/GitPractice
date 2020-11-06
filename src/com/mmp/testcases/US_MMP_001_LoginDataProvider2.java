package com.mmp.testcases;

import java.lang.reflect.Method;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mmp.utils.ExcelReader;


public class US_MMP_001_LoginDataProvider2 {
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\excel\\Login.xlsx");
    	
    	WebDriver driver;
    	
    	@BeforeMethod
		public void setUpBrowser() {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000");}
		
    
    	@Test(dataProvider = "dp")
    	public  void verifyTitle(String username,String password) {
        driver.findElement(By.xpath(".//*[@id='testimonials']//div[2]/a")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).click();
        driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath(".//*[@id='password']")).click();
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath(".//input[@value='Sign In']")).click();
        String actual_title = driver.getTitle();
        System.out.println(actual_title);
        String expected_title = "home";
        Assert.assertEquals(actual_title, expected_title);
        System.out.println("Test Passed");
       /* Assert.assertTrue(actual_title.contains("Home"));
        System.out.println("Title Verified");
        
        */
        	
        }
    	
    	
    	@DataProvider(name="dp")
    	public Object[][] getData(){
    		
    		String sheetName = "login";
    		int rows = excel.getRowCount(sheetName);
    		int cols = excel.getColumnCount(sheetName);
    		
    		System.out.println("No of rows" + rows);
    		System.out.println("No of cols" + cols);
    		
    		Object[][] data = new Object[rows-1][cols];
    		
    		for(int rowNum=2; rowNum<= rows; rowNum++) {
    			for(int colNum=0; colNum < cols; colNum++) {
    				//data[0][0]
    				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
    			}
    		}
    		return data;
    	}
		@AfterMethod
		public void closeBrowser() {
		
			driver.quit();
		
		}
		
		
		}
		
