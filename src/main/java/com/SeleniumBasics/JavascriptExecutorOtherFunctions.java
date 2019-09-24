package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorOtherFunctions {
	
	public static void testInitializeMethod() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login");
		generateJSEAlert(driver,"Twitter Login page Alert");
		Thread.sleep(1000);
		acceptAlert(driver);
		WebElement SignUpLink=driver.findElement(By.xpath("//*[contains(text(),'Sign up now')]"));
		clickUsingJSE(driver,SignUpLink);
		Thread.sleep(1000);
		pageRefreshUsingJSE(driver);
		driver.navigate().to("https://www.guru99.com/manual-testing.html");
		scrollToBottomJSE(driver);
		driver.navigate().to("https://www.guru99.com/software-testing.html");
		WebElement linkFind=driver.findElement(By.xpath("//*[@title='10 Best Cross Browser Compatibility Testing Tools']//*"));
		scrollTillElementJSE(driver,linkFind);
		
	}

	//JavascriptExecutor generate alert
	public static void generateJSEAlert(WebDriver driver,String message)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	//JavascriptExecutor click method
	public static void clickUsingJSE(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",ele);
	}
	//JavascriptExecutor pagerefresh method
	public static void pageRefreshUsingJSE(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	//JavascriptExecutorScrolltoBottom method
	public static void scrollToBottomJSE(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	//JavascriptExecutorScrollTillElement method
	public static void scrollTillElementJSE(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
	}
	//Capture Alert
	public static void acceptAlert(WebDriver driver)
	{
		Alert alerts=driver.switchTo().alert();
		alerts.accept();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		testInitializeMethod();
	}

}
