package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerAPI {
	
	
	static WebDriver driver;
	public static void initializeMethod()
	{
		
//		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
//		WebDriverManager.iedriver().setup();
	
//		driver=new ChromeDriver();
		driver=new FirefoxDriver();
//		driver=new InternetExplorerDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://github.com/bonigarcia/webdrivermanager");
		
		System.out.println("Execution Completed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();
	}
	
	/*https://github.com/bonigarcia/webdrivermanager-examples/issues/13
	 * 
	 */

}
