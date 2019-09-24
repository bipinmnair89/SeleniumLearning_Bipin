package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliScriptingConcept {
	/*Sikuli is a 3rd party application which can be integrated with selenium to automate flash objects
	 * and windows based popups
	 * Such as Images, Videos etc
	 * User needs to add "sikuliX" jar or dependancy to maven project
	 * User needs to get the screenshots of the actions to be performed as sikuli uses image processing
	 * use screen and pattern sikuli objects to control the execution
	 * sometimes we would need to perform same action twice to execute the same in sikuli
	 */
	
	public static void initializeMethod() throws InterruptedException, FindFailed
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("http://demo.guru99.com/test/image_upload/index.php");
	    driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
	    Screen s=new Screen();
	    Pattern cancelButton = new Pattern("D://Learning//FileScreenshots//CancelButton.PNG");
	    s.wait(cancelButton,1000);
	    s.click(cancelButton);
	    //s.click();
	    driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException, FindFailed {
		// TODO Auto-generated method stub
		initializeMethod();
//		guru99DemoMethod();
	}

}

/* Bug identified for sikuli and windows 10 -> https://bugs.launchpad.net/sikuli/+bug/1730645
 * due to which cursor movement is erratic
 * 
 */







