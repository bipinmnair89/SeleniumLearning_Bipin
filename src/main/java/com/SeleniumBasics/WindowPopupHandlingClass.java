package com.SeleniumBasics;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPopupHandlingClass {

	public static void popupHandleTest()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		
		driver.findElement(By.xpath("//a[text()='Good PopUp #1']")).click(); //moving to first popup window
		switchToSecondWindow(driver);
		System.out.println("Page 2 title is :"+driver.getTitle());
		driver.close();
		switchToFirstWindow(driver);
		System.out.println("Page 1 title is :"+driver.getTitle());
		
		
		driver.findElement(By.xpath("//a[text()='Good PopUp #2']")).click();  //moving to second popup window
		switchToSecondWindow(driver);
		System.out.println("Page 2 title is :"+driver.getTitle());
		driver.close();
		switchToFirstWindow(driver);
		System.out.println("Page 1 title is :"+driver.getTitle());
//				 
		
	}
	public static void switchToSecondWindow(WebDriver driver) //custom method to switch to next window
	{
		
		Set<String> s1=driver.getWindowHandles(); 
		Iterator<String> it=s1.iterator();
		String page1=it.next();
		String page2=it.next();
		driver.switchTo().window(page2);
		
	}
	
	public static void switchToFirstWindow(WebDriver driver) //custom method to switch back to first window
	{
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> it=s1.iterator();
		String page1=it.next();
		driver.switchTo().window(page1);
	}
		
	public static void main(String[] args) {

//		WindowPopupHandlingClass obj=new WindowPopupHandlingClass();
		popupHandleTest();

	}

}
