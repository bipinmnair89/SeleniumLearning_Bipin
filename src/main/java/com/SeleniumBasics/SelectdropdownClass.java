package com.SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectdropdownClass {
	
	/*This class illustrates the use of select class to access dropdown values and also custom method for selecting by value
	 * deselect method can be used only for multiselect dropdowns
	 * always make sure not to use selectbyindex as the index can change
	 */

	public static void selectDropdownTest()    //test method
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://phptravels.org/clientarea.php");
		driver.findElement(By.linkText("Register")).click();
		
		WebElement ele=driver.findElement(By.xpath("//select[@id='customfield1']"));
		selectDrpdownMethod(ele,"Bing");
		verifyMultipledrpdown(ele);
		
		
		//getting all elements in the drpdown
		List<WebElement> eles=driver.findElements(By.xpath("//select[@id='customfield1']")); 
		for(int i=0;i<eles.size();i++)
		{
			System.out.println(eles.get(i).getText());
		}
	}
	
	
	public static void selectDrpdownMethod(WebElement ele, String value) //custom method to select by value
	{
		Select sel=new Select(ele);
		sel.selectByValue(value);
		//find total number of elements in the list
		List<WebElement> list=sel.getOptions();
		System.out.println("Total number of options in dropdown is :"+list.size());
		
	}
	
	
	public static void verifyMultipledrpdown(WebElement ele) //custom method to check the dropdown is single or multiselect
	{
		Select sel=new Select(ele);
		if(sel.isMultiple())
		{
			System.out.println("Multiselect dropdown");
		}
		else
		{
			System.out.println("Single select dropdown");
		}
	}
	
	public static void main(String args[])
	{
		SelectdropdownClass obj=new SelectdropdownClass();
		obj.selectDropdownTest();
	}

}
