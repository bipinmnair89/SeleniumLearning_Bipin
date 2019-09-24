package com.SeleniumIntermediate;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCalendarDatePicker {
	
	static WebDriver driver;
	public static void initializeMethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("https://www.goibibo.com");
	    
	    //entering and splitting the date to be selected
	    String dateToSearch="31-August-2019";
	    String dateToSearchArr[]=dateToSearch.split("-");
	    String dayValue=dateToSearchArr[0];
	    String monthValue=dateToSearchArr[1];
	    String yearValue=dateToSearchArr[2];
	    System.out.println("Value of day is : "+dayValue+", Value of month : "+monthValue+", Value of year : "+yearValue);
	   
	    //clicking on the field to open the date picker
	    WebElement departureDateField=driver.findElement(By.xpath("//*[@type='text' and @placeholder='Departure']"));
	    departureDateField.click();
	    
	    //check for the specific day and select the same
	    //use try-catch block to find out if the user is giving invalid date like 32-August-2019
	    
	    try { 
	    		WebElement searchResult=driver.findElement(By.xpath("//div[@class='DayPicker-Body']/descendant::div[starts-with(@class,'DayPicker-Day')]//div[text()='"+dayValue+"']"));
	    		searchResult.click();
	    }catch(Throwable e)				//throwable is used as it is superclass of both exception and error
	    {
	    	System.out.println("Please enter a valid date");
	    }
	    
	    Thread.sleep(2000);
	    driver.close();
	    //
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
