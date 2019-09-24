package com.SeleniumIntermediate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadUsingwgetConcept {
	
	/*wget is a third party application that can be used to download files and copy them to desired location
	 * here we need to get the link from the download button or icon using getAttribute
	 * then run the wget command using Runtime.getRuntime() method and by giving the wget.exe location
	 * and the location where we want to place the downloaded file
	 */
	
	static WebDriver driver;
	
	public static void initializeMain() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.get("http://demo.guru99.com/test/yahoo.html");
	    Thread.sleep(3000);
	    WebElement downloadButton=driver.findElement(By.xpath("//*[@id='messenger-download']"));
		String sourceLocation=downloadButton.getAttribute("href");
		
		String wget_cmd="cmd /c D:\\Learning\\wget\\wget.exe -P D:\\Learning\\wget\\ --no-check-certificate "+sourceLocation;

		try {
			Process exec = Runtime.getRuntime().exec(wget_cmd);
			int waitTimeTaken=exec.waitFor();
			System.out.println("Download has got completed in = "+waitTimeTaken+" sec");		
		   }catch(Exception e)
		  {
			   e.printStackTrace();
		  }
		driver.close();
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		initializeMain();
	}

}
