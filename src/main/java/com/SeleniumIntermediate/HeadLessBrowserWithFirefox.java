package com.SeleniumIntermediate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadLessBrowserWithFirefox {
	
	public static void initializeMethod()
	{
		//first set the FirefoxBinary
		FirefoxBinary fbinary=new FirefoxBinary();
		fbinary.addCommandLineOptions("-headless");
		System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
		FirefoxOptions options=new FirefoxOptions();
		options.setBinary(fbinary);
		
//		options.setHeadless(true);         //this one line can be used to replace all the binarycodes listed
		
		WebDriver driver=new FirefoxDriver(options);
		driver.get("https://www.twitter.com");
		System.out.println(driver.getTitle());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
