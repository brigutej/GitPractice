package com.mmp.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ListElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal");
		
		String[] expected = {"HOME","Profile","Schedule Appointment","Information","Fees","Search Symptoms","Messages","Logout"};
				
		
				
		WebElement element = driver.findElement(By.xpath("//div[@class='left-sidebar']/div/ul"));//
		System.out.println("Name :" + element.getText());
		List<WebElement> li_All = element.findElements(By.tagName("span"));
		System.out.println(li_All.size());
		
		for(int i = 0;i < li_All.size();i++) {
			
			String liValue= li_All.get(i).getText();
			System.out.println(liValue);
			
			if(liValue.equals(expected[i])) {
				System.out.println("passed on : "+ liValue);}
				else {
					System.out.println("failed on : "+ liValue);
					Actions actions = new Actions(driver);
					List<WebElement> li_AllClick = element.findElements(By.xpath("//span[@class='hidden-minibar']"));
					//li_AllClick.get(i).click();
					actions.click();
				}
			}
		
		
        //List<WebElement> expandQA = driver.findElements(By.xpath("//img[contains(@class, 'x-tree-expander')]/following-sibling::span[text()='QA']"));
        //WebElement e = li_All.get(i);
        
	
			//System.out.println(li_All.get(i).getText());
			
			
	       // li_All.get(i).click();
	        
	        
	        
		
			
		}

}


