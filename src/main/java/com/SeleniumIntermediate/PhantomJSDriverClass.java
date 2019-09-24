package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSDriverClass {
	
	/*We need to download the phantomjs exe file and configure the path in system.setpropery
	 * and also we need to download the phantom js jar file and add it as external jar in java build path
	 */
	
	public static void initialize()
	{
		System.setProperty("phantomjs.binary.path", "D://Learning//JARFiles//phantomjs-2.1.1-windows\\bin//phantomjs.exe");
		WebDriver driver=new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://twitter.com/login");
		WebElement SignUpLink=driver.findElement(By.xpath("//*[contains(text(),'Sign up now')]"));
		SignUpLink.click();
		System.out.println("signup link clicked");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initialize();
	}

}
