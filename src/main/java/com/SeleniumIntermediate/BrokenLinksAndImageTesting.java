package com.SeleniumIntermediate;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksAndImageTesting {
	
	static WebDriver driver;
	public static void initializeMethod() throws MalformedURLException, IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		Thread.sleep(8000);
		
		//Images are having 'img' tag and links are having 'a' tag
		List<WebElement> linksFromPage=driver.findElements(By.tagName("a"));
		linksFromPage.addAll(driver.findElements(By.tagName("img")));
		System.out.println("Total Number of Links in the Page = "+linksFromPage.size());
		
		//now remove all links which are not having href value and also are of type javascript
		List<WebElement> activeLinks=new ArrayList<WebElement>();
		for(int i=0;i<linksFromPage.size();i++)
		{
			//System.out.println(linksFromPage.get(i).getAttribute("href"));
			if(linksFromPage.get(i).getAttribute("href") !=null && (!linksFromPage.get(i).getAttribute("href").contains("javascript")))
			{	
				activeLinks.add(linksFromPage.get(i));
			}
		}
		System.out.println("Total Number of Active Links in the Page = "+activeLinks.size());
		
		Thread.sleep(8000);
		//use HTTPURLConnection
		for(int j=0;j<activeLinks.size();j++)
		{
			//System.out.println(activeLinks.get(j).getAttribute("href"));
			HttpURLConnection connection=(HttpURLConnection)new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			int responseCode=connection.getResponseCode();
			connection.disconnect();
			System.out.println(activeLinks.get(j).getAttribute("href")+" --->"+responseCode);
			
		}
		
		driver.close();
	}
	
	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		initializeMethod();
	}

}
