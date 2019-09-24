package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/* Locate element by id,name,classname,tagname, linktext, partiallinktext, cssselector, xpath, DOM
 * 
 */
public class ElementLocatorsClass {
	
	public void initializeConcept()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\JARFiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://newtours.demoaut.com");
		driver.findElement(By.name("userName")).sendKeys("bipinmnair");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("newtours");
		driver.findElement(By.cssSelector("input[type^=ima]")).click();	//starts with css selector option ^
		
		//explicit wait condition
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='passCount']")));
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='oneway']")).click();
		
	}
	
	public static void main(String[] args) {

		ElementLocatorsClass elc=new ElementLocatorsClass();
		elc.initializeConcept();

	}

}
