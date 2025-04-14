package com.testscenarios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FaceBookLogin {

	public static void main(String[] args) throws Exception {
		// Create an object for WebDriver interface
		WebDriver driver;
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\td.xlsx");
		Workbook wb = new XSSFWorkbook(fi);
		Sheet s = wb.getSheet("Retest");
		// Launch chrome browser
		driver = new ChromeDriver();

		for (int i = 1; i < 5; i++) {
			Row r = s.getRow(i);
			Cell username = r.getCell(0);
			Cell password = r.getCell(1);
			Cell results = r.createCell(2);
			
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();

			driver.findElement(By.id("email")).sendKeys(username.getStringCellValue());
			driver.findElement(By.name("pass")).sendKeys(password.getStringCellValue());
			driver.findElement(By.name("login")).click();

			
			Thread.sleep(8000);
			// validate error message has displayed or not?
			if (driver.findElements(By.linkText("Find your account and log in.")).size() > 0
					||
			    driver.findElements(By.linkText("Create a new Facebook account.")).size() > 0
			   )
			{
				System.out.println("Given credentials are in-valid*****");
				results.setCellValue("FAIL");
			} else {
				System.out.println("Given credentials are valid****");
				results.setCellValue("PASS");
			}

		}//for loop end
		//send the results to excel sheet
		FileOutputStream fo = new FileOutputStream(".\\src\\test\\resources\\testdata\\td.xlsx");
		wb.write(fo);
		wb.close();
		
		//driver.quit();
	}

}
