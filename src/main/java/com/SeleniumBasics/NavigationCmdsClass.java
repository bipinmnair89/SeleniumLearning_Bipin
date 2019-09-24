package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCmdsClass {
	
	public static void navigateSelenium()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		String title=driver.getTitle();
		driver.navigate().to("https://www.twitter.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("https://www.guru99.com/selenium-tutorial.html");
		driver.navigate().refresh();
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		navigateSelenium();

	}

}
