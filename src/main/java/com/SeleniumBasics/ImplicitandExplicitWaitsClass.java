package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitandExplicitWaitsClass {
	
	public static void waitTestMethod()
	
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		/*Implicitly wait is a global wait which would apply for all the webelements in the page
		 * 
		 */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guru99.com/selenium-tutorial.html");
		driver.findElement(By.xpath("//a[(text()='Software Testing')]")).click();
		WebElement nextPageElement=driver.findElement(By.xpath("//a[@title='What is Software Testing? Introduction, Definition, Basics & Types']"));
		explicitWaitMethod(driver,nextPageElement,10);
		nextPageElement.click();
	}
	
	public static void explicitWaitMethod(WebDriver driver, WebElement ele, int waitTime)  //Custom explicit method
	{
		
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void main(String[] args)
	{
		waitTestMethod();
	}

}
