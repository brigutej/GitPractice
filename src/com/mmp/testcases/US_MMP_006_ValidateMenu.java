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

public class US_MMP_006_ValidateMenu {
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
		WebElement home = driver.findElement(By.xpath("//a[@href='profile.php']//preceding::span[1]"));
		String strhome = home.getText();
		System.out.println(strhome);
		Assert.assertEquals("HOME", strhome);
		home.click();
	
		WebElement profile = driver.findElement(By.xpath("//a[@href='profile.php']//span"));
		String strprofile = profile.getText();
		System.out.println(strprofile);
		Assert.assertEquals("Profile", strprofile);
		profile.click();
		
		WebElement sa = driver.findElement(By.xpath("//li[@class='submenu'][1]//span"));
		String strsa = sa.getText();
		System.out.println(strsa);
		Assert.assertEquals("Schedule Appointment", strsa);
		Thread.sleep(3000);
		/*Actions actions = new Actions(driver);
		actions.moveToElement(sa).click().perform();*/
		sa.click();
		
		
		//WebElement e;
		//WebDriverWait wait=new WebDriverWait(driver, 50);
		//e= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='submenu'][1]//span")));
		//e.click();
		//Thread.sleep(3000);
		
		
		WebElement info = driver.findElement(By.xpath("//li[@class='submenu'][2]//span[@class='hidden-minibar']"));
		String strinfo = info.getText();
		System.out.println(strinfo);
		Assert.assertEquals("Information", strinfo);
		Thread.sleep(3000);
		info.click();
		
		WebElement fees = driver.findElement(By.xpath("//li[@class='submenu'][3]//span[@class='hidden-minibar']"));
		String strfees = fees.getText();
		System.out.println(strfees);
		Assert.assertEquals("Fees", strfees);
		Thread.sleep(3000);
		fees.click();
		
		WebElement ss = driver.findElement(By.xpath("//li[@class='submenu'][4]//span[@class='hidden-minibar']"));
		String strss = ss.getText();
		System.out.println(strss);
		Assert.assertEquals("Search Symptoms", strss);
		Thread.sleep(3000);
		ss.click();
	
		WebElement msg = driver.findElement(By.xpath("//li[@class='submenu'][5]//span[@class='hidden-minibar']"));
		String strmsg = msg.getText();
		System.out.println(strmsg);
		Assert.assertEquals("Messages", strmsg);
		Thread.sleep(3000);
		msg.click();
		
		
		WebElement logout = driver.findElement(By.xpath("//li[@class='submenu'][6]//span[@class='hidden-minibar']"));
		String strlogout = logout.getText();
		System.out.println(strlogout);
		Assert.assertEquals("Logout", strlogout);
		Thread.sleep(3000);
		logout.click();
		
		
		
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
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
}
		
		
	  
