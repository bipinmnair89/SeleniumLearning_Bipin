package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowserWithChrome {
	
	public static void initializeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		//code for launching chrome as headless browser
		ChromeOptions options=new ChromeOptions();
		//options.addArguments("window-size=1400:800");
//		options.addArguments("headless");
		
		options.setHeadless(true); //can be used instead of add arguments
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login");
		WebElement SignUpLink=driver.findElement(By.xpath("//*[contains(text(),'Sign up now')]"));
		SignUpLink.click();
		System.out.println("signup link clicked");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
