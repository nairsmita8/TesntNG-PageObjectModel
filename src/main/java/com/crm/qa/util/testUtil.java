package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.testBase;

public class testUtil extends testBase {

	public testUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long pageLoadTimeOut = 20;
	public static long implicitelyWait = 10;

	String TestDataPath= "C:\\Users\\nairs\\eclipse-workspace\\POMTestNG\\src\\main\\java\\com\\crm\\qa\\testData\\DataSheet.xlsx";
	
	Workbook book;
	Sheet sheet;
	
	
	public void switchFrame() {

		driver.switchTo().frame("mainpanel");
	}

	public static void JSClick(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public Object[][] getExcelTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		FileInputStream file = new FileInputStream(TestDataPath);
		
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet(sheetName);
		
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++) {
				
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
			
		}
		
		return data;
		
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
