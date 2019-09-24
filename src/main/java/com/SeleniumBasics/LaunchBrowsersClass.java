package com.SeleniumBasics;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LaunchBrowsersClass {
	
	public void startChromeDriver()
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Learning\\JARFiles\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		if(title.equals("Google"))
		{
			System.out.println("Test case passed");
		}
		else
		{
			System.out.println("Test case failed");
		}
		driver.close();
		
	}
	
	public void startFirefoxDriver()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Learning\\JARFiles\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com");
		String title=driver.getTitle();
		if(title.equals("Google"))
		{
			System.out.println("Test case passed on firefox");
		}
		else
		{
			System.out.println("Test case failed on firefox");
		}
		driver.close();
	}
	
	/*To launch safari browser 
	 * webdriver extension must be installed in safari browser
	 * then from preferences enable the safari browser extension
	 * and then desktop-> allow remote automation check and restart safari browser
	 */
		
	public static void main(String[] args)
	{
		LaunchBrowsersClass obj=new LaunchBrowsersClass();
		obj.startChromeDriver();
		obj.startFirefoxDriver();
		
	}

}
