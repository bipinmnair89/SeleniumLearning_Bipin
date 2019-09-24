package com.excelImplementations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdateDataFromExcel {
	
	static WebDriver driver;
	
	public static void updateSiteFromExcel() throws IOException, InterruptedException
	{
		Properties prop=new Properties();
		FileInputStream ip=new FileInputStream("D://Learning//Workspace//SeleniumSessions//src//main//java//com//SeleniumIntermediate//config.properties");
		prop.load(ip);
		
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	    driver.get("https://www.amazon.in/");
	    
		driver.findElement(By.xpath(prop.getProperty("signinButtonAmazon_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("usernameAmazon_xpath"))).sendKeys(prop.getProperty("usernameAmazon_value"));
		driver.findElement(By.xpath(prop.getProperty("passwordAmazon_continue"))).click();
		driver.findElement(By.xpath(prop.getProperty("passwordAmazon_xpath"))).sendKeys(prop.getProperty("passwordAmazon_value"));
		driver.findElement(By.xpath(prop.getProperty("loginButtonAmazon_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("signinButtonAmazon_xpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("yourAddressesAmazon_xpath"))).click();
		
		
		System.out.println("Starting to execute the reading from excel section");
		FileInputStream file=new FileInputStream("D:\\Learning\\ExcelGallery\\AddressDetails.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int colCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Row Count : "+rowCount+" Column Count : "+colCount);
		
		for(int i=1;i<=rowCount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			String fullName=row.getCell(0).getStringCellValue();
			long phoneNumber=(long) row.getCell(1).getNumericCellValue(); //here we are casting as by default numeric values gets appended by 0.0 decimal place hence to remove that we typecast
			int pinCode=(int)row.getCell(2).getNumericCellValue();
			String address=row.getCell(3).getStringCellValue();
			
			driver.findElement(By.xpath(prop.getProperty("addAddressAmazon_xpath"))).click();
			driver.findElement(By.xpath(prop.getProperty("addNameAmazon_xpath"))).sendKeys(fullName);
			driver.findElement(By.xpath(prop.getProperty("addPhoneNumberAmazon_xpath"))).sendKeys(String.valueOf(phoneNumber)); //using stringvalueof as sendkeys doesnt allow to enter a value into numeric field such as accountnumber or amount
			driver.findElement(By.xpath(prop.getProperty("addPostalCode_xpath"))).sendKeys(String.valueOf(pinCode));
			driver.findElement(By.xpath(prop.getProperty("addAddressFirstLineAmazon_xpath"))).sendKeys(address);
			Thread.sleep(2000);
		    WebElement submitButton=driver.findElement(By.xpath(prop.getProperty("AddAddressFinalButtonAmazon_xpath")));
		    submitButton.click();

		}
	    Thread.sleep(6000);
		driver.close();
		
	}
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		updateSiteFromExcel();
	}

}
