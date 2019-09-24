package com.excelImplementations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ReadDataFromExcel {
	
	//static WebDriver driver;
	//FileInputStream->WorkBook->Sheet->Row->Cell
	public static void getxlsxData() throws IOException
	{
		
		//get the file location and assign it using FileInputStreamMethod
		FileInputStream file=new FileInputStream("D://Learning//ExcelGallery//CityDetails.xlsx");
		
		//create XSSFworkbook first as we are dealing with XLSX file and assign the file value
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//create XSSFSheet inside the workbook
		XSSFSheet sheet=workbook.getSheet("Page1");
		
		//now get the number of rows and columns with data in the excel sheet
		int rowCount=sheet.getLastRowNum();
		int columnCount=sheet.getRow(0).getLastCellNum();
		System.out.println("Number of rows : "+rowCount+" Number of columns : "+columnCount);
		
		//using nested for loop and traversing through rows and columns and accessing each element
		for(int i=0;i<=rowCount;i++)
		{
			//get to the row
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<columnCount;j++)
			{
				String data=row.getCell(j).toString();
				System.out.print("            "+data);
			}
			System.out.println();	
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getxlsxData();
	}

}

/* Faced error with Inputstream and resolved it by replacing the poi 4.1 with 3.17 maven dependency
 * https://stackoverflow.com/questions/53142170/getting-noclassdeffounderror-when-trying-to-read-excel-sheet-using-apache-poi-ap/57710965#57710965
 */
