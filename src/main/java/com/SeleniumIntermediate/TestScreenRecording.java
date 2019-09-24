package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.reusableclasses.MyScreenRecorder;

public class TestScreenRecording {

	public static void initializeTest() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		MyScreenRecorder.startRecording("initializeTest");
		
		driver.get("https://www.facebook.com");
		driver.navigate().to("https://www.twitter.com");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().to("https://www.guru99.com/selenium-tutorial.html");
		driver.navigate().refresh();
		
		MyScreenRecorder.stopRecording();
		
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		initializeTest();
	}

}
