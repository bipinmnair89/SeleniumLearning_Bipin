package com.SeleniumIntermediate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFileClass {
	
	static WebDriver driver;
	
	public static void initializeMethod() throws IOException, InterruptedException
	{
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("D://Learning//Workspace//SeleniumSessions//src//main//java//com//SeleniumIntermediate//config.properties");
		prop.load(ip);
		//load the browser
		String browserName=prop.getProperty("browsername");
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("signinbutton_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("username_xpath"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath(prop.getProperty("password_xpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("loginSubmitButton_xpath"))).click();	

	}
	


	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
