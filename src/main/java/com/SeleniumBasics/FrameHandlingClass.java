package com.SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandlingClass {
	
	public static void testFrameHandle() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.automationtesting.in/Frames.html");
		driver.switchTo().frame("SingleFrame");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sec1234");
		String screenShotName="FrameScreenShot";
		takesScreenshotMethod(driver,screenShotName);
		driver.close();
		/*driver.switchTo().frame("FrameName");<-- frame name is preferred over id as id can change
      	or
		driver.switchTo().frame("a077aa5e"); <-- frame id
		*/
	}

	public static void takesScreenshotMethod(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot scrShot=((TakesScreenshot)driver);
		File scrFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("D://Learning//FileScreenshots//"+screenShotName+".png"));
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testFrameHandle(); //no need of object as the method is static

	}

}
