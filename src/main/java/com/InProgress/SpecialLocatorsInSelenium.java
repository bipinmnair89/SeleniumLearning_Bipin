package com.InProgress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ByIdOrName;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

public class SpecialLocatorsInSelenium {
	
	//<<hitting elementnotinteractable error while using the special locators>>
	
	/* Here we see the usage of 3 special locators
	 *  ByAll, ByIdorName, ByChained
	 */
	static WebDriver driver;
	public static void testMethod() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/login");
		
		//Entering the username using ByAll locator
		
		//driver.findElement(By.xpath("//*[@class='clearfix field']/child::input[@type='text']")).sendKeys("TestUser");
		driver.findElement(new ByAll(By.name("session[username_or_email]"),
									 By.xpath("//*[@class='clearfix field']/child::input[@type='text']"))).sendKeys("Devil367");
		
		//Enter the password using ByIdorName
		driver.findElement(new ByIdOrName("session[password]")).sendKeys("Secret123");
		
		//Clicking on the LogIn button using ByChained
		driver.findElement(new ByChained(By.className("clearfix"),
										 By.xpath("//*[(@type='submit') and (text()='Log in')]"))).click();
		
		
		Thread.sleep(3000);
		driver.close();
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		testMethod();
	}

}
