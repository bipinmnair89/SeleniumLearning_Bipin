package com.SeleniumBasics;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotSeleniumClass {
	
	//using takesscreeshot interface
	
	public static void takeScreenshotMethod() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		
		/*TakesScreenshot scrShot=((TakesScreenshot)driver); //we need to add external IO jars for file operations to work - http://commons.apache.org/proper/commons-io/
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D://Learning//FileScreenshots//file1.png"));
		driver.close();
		
		driver.navigate().to("https://www.twitter.com");*/
		takesScreenshotMethod(driver,"Screenshot2");
		
	} 
	//custom method to take screenshot
	public static void takesScreenshotMethod(WebDriver driver,String filename) throws IOException
	{
		TakesScreenshot scrShot=(TakesScreenshot)driver;
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D://Learning//Workspace//SeleniumSessions//src//main//java//com.screenshots//"+filename+".png"));
	}
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		takeScreenshotMethod();
	}

}
