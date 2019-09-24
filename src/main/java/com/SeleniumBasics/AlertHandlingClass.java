package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandlingClass {

	public void popupHandleTest()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebDriverWait wait=new WebDriverWait(driver,10);
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//alert handling using Alert class
		Alert alert=driver.switchTo().alert();
		String alerttext=alert.getText();
		System.out.println("Alert text is :"+alerttext);
		alert.accept();	
		String alerttext1=alert.getText();
		System.out.println("Alert text is :"+alerttext1);
		alert.accept();
		driver.close();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlertHandlingClass obj=new AlertHandlingClass();
		obj.popupHandleTest();
		

	}

}
