package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirectUploadFileClass {

	public static void directFileUploadMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://html.com/input-type-file/");
		
		//make sure the Type of the field is file
		driver.findElement(By.xpath("//input[@name='fileupload' and @id='fileupload']")).sendKeys("D://Learning//FileScreenshots//file1.png");
		System.out.println("File upload successfull");
		driver.close();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		directFileUploadMethod();
	}

}
