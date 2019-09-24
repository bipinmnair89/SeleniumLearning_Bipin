package com.SeleniumIntermediate;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingDynamicGoogleSearch {
	
	/*This program illustrates the method to select a dynamic entry from google search results
	 * Achieved using List and If method
	 */
	
	
	static WebDriver driver;
	public static void initializeTestMethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://www.google.com");
	    WebElement googleSearchField=driver.findElement(By.xpath("//input[@title='Search']"));
	    WebElement dialogBox=driver.findElement(By.xpath("//a[contains(text(),'thanks')]"));
	    explicitWait(dialogBox);
	    //checking for that dialog box popup and then clicking on the same
	    if(dialogBox.isEnabled())
	    {
	    	  dialogBox.click();
	    }else
	    {
	    	dialogBox=driver.findElement(By.xpath("//a[contains(text(),'thanks')]"));
	    	dialogBox.click();
	    }
	    googleSearchField.sendKeys("Testing");
	    
	    //now the search results will get populated and then store them in a List
	    List<WebElement> li=driver.findElements(By.xpath("//*[@role='listbox']//li/descendant::div[@class='sbtc']/descendant::span"));
	    System.out.println("Number of Elements in the List : "+li.size());
	    
	    //now iterate and click, use try catch block if staleelementreferenceexception appears
	  try {
	    for(int i=0;i<li.size();i++)
	    {
	    	if(li.get(i).getText().contains("testing tools"))
	    	{
	    		li.get(i).click();
	    	}
	    }
	  }
	  catch(StaleElementReferenceException e)
	  {
		  li=driver.findElements(By.xpath("//*[@role='listbox']//li/descendant::div[@class='sbtc']/descendant::span"));
		  for(int i=0;i<li.size();i++)
		    {
		    	if(li.get(i).getText().contains("testing tools"))
		    	{
		    		li.get(i).click();	
		    	}
		    }
	  }
	  finally {
	  driver.close();
	  }
	  
	}
	public static void explicitWait(WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		WebElement ele1=wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initializeTestMethod();
	}

}
