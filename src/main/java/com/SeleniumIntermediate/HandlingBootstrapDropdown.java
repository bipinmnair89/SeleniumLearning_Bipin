package com.SeleniumIntermediate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBootstrapDropdown {
	
	static WebDriver driver;

	public static void initializeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		
		//click on the dropdown
		driver.findElement(By.xpath("//button[@type='button']")).click();
		//use findelements and store the values in a list
		List <WebElement> li=driver.findElements(By.xpath("//button[@type='button']/parent::div/descendant::a"));
		for(int i=0;i<li.size();i++)
		{
			if(li.get(i).getText().contains("HTML"))
			{
				li.get(i).click();					//The code is working but we cant see it as the website has restrictions on displaying the selected value
				break;
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();

	}

}
