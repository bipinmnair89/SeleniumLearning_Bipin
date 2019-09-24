package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CombatStaleElementReferenceException {

	public static void initializeMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		WebElement dragFromElementLocation=driver.findElement(By.xpath("//*[@id='credit2']"));
		WebElement dragToElementLocation=driver.findElement(By.xpath("//*[@id='bank']//li"));
		dragAndDropMethod2(driver,dragFromElementLocation,dragToElementLocation);
		driver.navigate().refresh();
		try {
			 dragAndDropMethod2(driver,dragFromElementLocation,dragToElementLocation);
		}catch(StaleElementReferenceException e)
		    {
			 dragFromElementLocation=driver.findElement(By.xpath("//*[@id='credit2']"));
			 dragToElementLocation=driver.findElement(By.xpath("//*[@id='bank']//li"));
		     dragAndDropMethod2(driver,dragFromElementLocation,dragToElementLocation);
		}
		driver.close();
	}
	
	public static void dragAndDropMethod2(WebDriver driver, WebElement from,WebElement to)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
