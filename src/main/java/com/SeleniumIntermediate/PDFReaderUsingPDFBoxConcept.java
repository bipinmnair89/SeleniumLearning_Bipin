package com.SeleniumIntermediate;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PDFReaderUsingPDFBoxConcept {
	
	static WebDriver driver;
	public static void testMethod() throws IOException
	{
		URL url=new URL("http://www.pdf995.com/samples/pdf.pdf");
		InputStream ip=url.openStream();
		BufferedInputStream buffer=new BufferedInputStream(ip);
		
		PDDocument document=PDDocument.load(buffer);
		String pdfContent=new PDFTextStripper().getText(document);
		System.out.println(pdfContent);
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		testMethod();
	}

}
