package com.SeleniumBasics;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintingDataOfWebTableDiffMethods {
	
	static WebDriver driver;
	public static void webtableToExcel() throws FileNotFoundException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		
		//DIFFERENT WAY OF GETTING THE WEBELEMENT COUNT WITHOUT USING LIST INTERFACE
		int rowCount=driver.findElements(By.xpath("//table[@id='customers']/descendant::tr")).size();
		int colCount=driver.findElements(By.xpath("//table[@id='customers']/descendant::tr//th")).size();
		System.out.println("The row count is : "+rowCount+" The column count is : "+colCount);
		
		//DIFFERENT WAY OF ITERATING A WEBTABLE AND DISPLAYING ALL ITS CONTENTS
		for(WebElement tabledata:driver.findElements(By.xpath("//table[@id='customers']/descendant::tr")))
		{
			System.out.println(tabledata.getText());
		}
		System.out.println();
		
		//CONVENTIONAL WAY TO PRINT THE DATA FROM A WEBTABLE
		List<WebElement> dataList=driver.findElements(By.xpath("//table[@id='customers']/descendant::tr"));
	    for(int i=0;i<rowCount;i++)
	    {
	    	System.out.println(dataList.get(i).getText());

	    }
	    driver.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		webtableToExcel();
	}

}
