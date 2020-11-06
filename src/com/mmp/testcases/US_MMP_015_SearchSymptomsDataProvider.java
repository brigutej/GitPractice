package com.mmp.testcases;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mmp.base.BaseClass;
import com.mmp.utils.ExcelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
 
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
 


public class US_MMP_015_SearchSymptomsDataProvider extends BaseClass {
	
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\excel\\symptoms.xlsx");

	@Test(dataProvider="dp")
	public void searchSymptoms3(String symptom) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		ChromeDriver driver= new ChromeDriver();
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal");
        //driver.get(url);
		driver.findElement(By.xpath("//li[7]/a/span[@class='hidden-minibar']")).click();
		
				
		driver.findElement(By.xpath(".//*[@id='search']")).click();
		driver.findElement(By.xpath(".//*[@id='search']")).sendKeys(symptom);
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(20,
		//		TimeUnit.SECONDS);
		driver.findElement(By.name("submit")).click();
		driver.manage().timeouts().implicitlyWait(20,
				TimeUnit.SECONDS);
		driver.close();
				
	}
	
	@DataProvider(name="dp")
    public Object[][] getData(){
		
		String sheetName = "symptoms";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows-1][cols];
		
    	for (int rowNum =2;  rowNum <=rows; rowNum++) {
    		
    		for (int colNum=0; colNum < cols; colNum++) {
    			//data[0][0]
    			data[rowNum-2][colNum]= excel.getCellData(sheetName,colNum,rowNum);
    		}
    	}
    	return data;	
    }
	
	
}

