package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateLogsWithLog4jConcept {
	
	
	static WebDriver driver;
	public static void initializeMethod()
	{
		Logger log=Logger.getLogger(GenerateLogsWithLog4jConcept.class); //logger object created
		
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		log.info("********************************Loading Facebook Website*****************************");
		driver.get("https://www.facebook.com");
		log.warn("********************************Navigating to another page Warning*****************************");
		driver.navigate().to("https://www.twitter.com");
		log.debug("********************************Debug Log******************************************");
		driver.navigate().back();
		log.fatal("*****************************Fatal Error Chances Warning***************************");
		driver.navigate().forward();
		driver.navigate().to("https://www.guru99.com/selenium-tutorial.html");
		driver.navigate().refresh();
		driver.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();

	}

}
