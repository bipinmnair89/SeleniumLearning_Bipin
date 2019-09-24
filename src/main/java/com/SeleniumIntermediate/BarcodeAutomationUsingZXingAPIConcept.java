package com.SeleniumIntermediate;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarcodeAutomationUsingZXingAPIConcept {
	
	static WebDriver driver;
	public static void testMethod() throws IOException, NotFoundException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D://Learning//JARFiles//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://barcode.tec-it.com/en");
		
		String textToGenerateBarcode="Bipin";
		System.out.println("Input ==> "+textToGenerateBarcode);
		
		WebElement barCodeTextBox=driver.findElement(By.xpath("//*[@name='Data']"));
		barCodeTextBox.clear();
		barCodeTextBox.sendKeys(textToGenerateBarcode);
		
		WebElement clickRefreshLink=driver.findElement(By.xpath("//*[text()='Refresh']"));
		clickRefreshLink.click();
		driver.navigate().refresh(); //refreshing the whole page for the barcode to get generated as it was not happening otherwise
		Thread.sleep(2000);
		
		WebElement barCodeGenerated=driver.findElement(By.xpath("//*[@class='barcode']//img"));
		String barCodeUrl=barCodeGenerated.getAttribute("src");
		
		URL url=new URL(barCodeUrl);
		BufferedImage bufferImage= ImageIO.read(url);
		LuminanceSource lumSource=new BufferedImageLuminanceSource(bufferImage);
		BinaryBitmap bitMap=new BinaryBitmap(new HybridBinarizer(lumSource));
		Result result=new MultiFormatReader().decode(bitMap);
		String barCodeResult=result.getText();
		System.out.println("Output ==> "+barCodeResult);
		
		if(textToGenerateBarcode.equals(barCodeResult))
		{
			System.out.println("Test Case Passed");
		}
		else
		{
			System.out.println("Test Case Failed");
		}	
		
		Thread.sleep(3000);
		driver.close();
}

	public static void main(String[] args) throws NotFoundException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		testMethod();
	}

}
