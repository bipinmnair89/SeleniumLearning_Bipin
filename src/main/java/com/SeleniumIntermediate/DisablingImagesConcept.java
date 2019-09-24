package com.SeleniumIntermediate;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DisablingImagesConcept {
	
	static WebDriver driver;
	public static void testMethod()
	{
		//chrome
//		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
//		ChromeOptions options=new ChromeOptions();
//		disableImagesChrome(options);
//		driver=new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get("https://www.amazon.com");
		
		
		//firefox
		System.setProperty("webdriver.gecko.driver", "D://Learning//JARFiles//geckodriver.exe");
		FirefoxOptions options1=new FirefoxOptions();
		disableImagesFirefox(options1);
		driver=new FirefoxDriver(options1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		
		
	}
	
	public static void disableImagesChrome(ChromeOptions options)
	{
		HashMap<String, Object> images=new HashMap<String, Object>();
		images.put("images", 2);
		HashMap<String, Object> prefs=new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values", images);
		options.setExperimentalOption("prefs", prefs);
	}
	
	public static void disableImagesFirefox(FirefoxOptions options1)
	{
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		options1.setProfile(profile);
		options1.setCapability(FirefoxDriver.PROFILE, profile);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMethod();

	}

}
