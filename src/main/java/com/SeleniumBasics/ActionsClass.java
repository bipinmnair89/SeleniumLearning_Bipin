package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {

	public static void actionsMethod()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.guru99.com/");
		
		//mousehover scenario
		WebElement testingOption=driver.findElement(By.xpath("//div[@class='g-menu-item-container']//span[contains(text(),'Testing')]"));
		moveToCustomMethod(driver,testingOption);
		driver.findElement(By.xpath("//span[starts-with(text(),'Agile Testing')]")).click();
		
		//drag and drop
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		WebElement dragFromElementLocation=driver.findElement(By.xpath("//*[@id='credit2']"));
		WebElement dragToElementLocation=driver.findElement(By.xpath("//*[@id='bank']//li"));
		dragAndDropMethod1(driver,dragFromElementLocation,dragToElementLocation);
		
//		driver.navigate().refresh();
//		dragAndDropMethod2(driver, dragFromElementLocation, dragToElementLocation);         //Stale Element exception appears once the page is refreshed and this code fails to work
		
		//rightclick, doubleclick
		driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement toDoubleClick=driver.findElement(By.xpath("//*[contains(text(),'Double-Click Me To See Alert')]"));
		WebElement toRightClick=driver.findElement(By.xpath("//*[contains(text(),'right click me')]"));
		
		Actions action=new Actions(driver);
		action.doubleClick(toDoubleClick).build().perform();
		handleAlert(driver); //to handle the alert that appears on double click
		action.contextClick(toRightClick).build().perform();
		
		driver.close();
		
			
	}
	
	
	public static void moveToCustomMethod(WebDriver driver, WebElement ele)
	{
		Actions action=new Actions(driver);
		action.moveToElement(ele).build().perform();	
	}	
	
	public static void dragAndDropMethod1(WebDriver driver, WebElement from,WebElement to)
	{
		Actions action=new Actions(driver);
		action.clickAndHold(from).moveToElement(to).release().build().perform();	
	}
	public static void dragAndDropMethod2(WebDriver driver, WebElement from,WebElement to)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(from, to).build().perform();
	}
	public static void handleAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		actionsMethod();

	}

}
