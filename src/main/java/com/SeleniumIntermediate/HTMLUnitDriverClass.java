package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HTMLUnitDriverClass {
	
	public static void initializeMethod()
	{
		//System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new HtmlUnitDriver();
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
