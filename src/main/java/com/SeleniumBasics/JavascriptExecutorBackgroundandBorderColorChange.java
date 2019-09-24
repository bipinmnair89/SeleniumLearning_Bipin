package com.SeleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorBackgroundandBorderColorChange {

	public static void initializeMethod() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login");
		WebElement logInButton=driver.findElement(By.xpath("//button[text()='Log in']"));
		WebElement SignUpLink=driver.findElement(By.xpath("//*[contains(text(),'Sign up now')]"));
	
		highLight(driver,logInButton);
		drawBorder(driver,logInButton);
		takeScreenshot(driver);
		
	}
	
	//JavascriptExecutor method to highlight an element
	public static void highLight(WebDriver driver,WebElement element)
    {
        for (int i = 0; i <10; i++) 
        {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
                Thread.sleep(200);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
	
	public static void drawBorder(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", ele);
	}
	
	public static void takeScreenshot(WebDriver driver) throws IOException
	{
		TakesScreenshot scrShot=(TakesScreenshot)driver;
		File scrShotFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrShotFile, new File("D://Learning//FileScreenshots//image1.png"));
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		initializeMethod();

	}

}
