package com.SeleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DESMethodsClass {
	
	/*3 main validation methods are DES - isDisplayed(), isEnabled(), isSelected
	 * isDisplayed() is used to verify if elements are appearing on the page
	 * isEnabled() is used to verify if buttons are enabled
	 * isSelected() is used to verify if checkboxes,radiobuttons,dropdowns are selected
	 */
	
	public static void desMethodValidation()
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com");
		
//		isDisplayed() method
		WebElement email=driver.findElement(By.xpath("//input[contains(@class,'inputtext') and @name='email']"));
		if(email.isDisplayed())
		{
			System.out.println("Email address field is enabled");
			email.sendKeys("unknownuser@gmail.com");
		}
		else
		{
			System.out.println("The email address is not displayed");
		}
		
//		isEnabled method
		WebElement loginButton=driver.findElement(By.xpath("//input[starts-with(@value,'Log')]"));
		if(loginButton.isEnabled())
		{
			System.out.println("Login button is enabled");
		}
		else
		{
			System.out.println("Login button is not enabled");
		}
		
//		isSelected method
		WebElement genderRadioButton=driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		if(genderRadioButton.isSelected())
		{
			System.out.println("RadioButton is selected");
		}
		else
		{
			System.out.println("Selecting the radio button 'Male'");
			genderRadioButton.click();
		}
		driver.close();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		desMethodValidation();
	}

}
