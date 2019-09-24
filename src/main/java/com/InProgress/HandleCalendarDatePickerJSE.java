package com.InProgress;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendarDatePickerJSE {

	//Incomplete program, jse not working for calendar
	static WebDriver driver;
	public static void initializeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("http://demo.guru99.com/test/");
	    WebElement dateField=driver.findElement(By.xpath("//input[@name='bdaytime']"));
	    String dateToEnter="04-06-1989 04:00";
	    //Sat, 31 Aug
	    customJSEMethod(dateField,dateToEnter);
	    
	}
	public static void customJSEMethod(WebElement ele,String date)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+date+"');", ele);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
