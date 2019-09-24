package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingDynamicWebTable {
	
	static WebDriver driver;
	
	public static void testDynamicTable()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.automationtesting.in/WebTable.html");
		String nameToSearch="Karen";
		
		//the webtable content is captured using the axes methods of xpath and this is better method than using forloop and if conditions
		WebElement toEdit=driver.findElement(By.xpath("//div[contains(text(),'"+nameToSearch+"')]/parent::div/following-sibling::div[4]/descendant::i[@class='fa fa-pencil']"));
		highLightJSE(toEdit);
		doubleClick(toEdit);
	}
	//actions class method to double click on the element
	public static void doubleClick(WebElement ele)
	{
		Actions action=new Actions(driver);
		action.doubleClick(ele).build().perform();	
	}
	
	//javascriptexecutor method to highlight the element
	public static void highLightJSE(WebElement ele)
	{
		for(int i=0;i<10;i++)
		{
			try {
					JavascriptExecutor js=(JavascriptExecutor)driver;
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);",ele,"color:black;border:4px solid red;");
					Thread.sleep(100);
					js.executeScript("arguments[0].setAttribute('style',arguments[1]);",ele,"");
					Thread.sleep(100);
				}catch(InterruptedException e)
				{
				e.printStackTrace();
				}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testDynamicTable();

	}

}
