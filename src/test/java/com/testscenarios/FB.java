package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.objectrepository.QA_Locators;

public class FB {
	WebDriver driver;

	@Test
	public void fblogin() throws Exception {

		driver = new ChromeDriver();
		// Create an object for Locators parent class
		// using object will call any variable to here
		// Syntax: ClassName refereneceName = new ClassName();
		QA_Locators loc = new QA_Locators();
		
		//Get the test data from .properties file
		Properties p= new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\QA_TestData.properties");
		p.load(fi);

		driver.get(p.getProperty("FB_URL"));
		//Implicit wait: wait until for Page load
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		System.out.println("Title of the page is: " + driver.getTitle());

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].style.border='7px solid red'",driver.findElement(loc.fbLoginPage_Email_Editbox));
		Thread.sleep(200);
		executor.executeScript("arguments[0].style.border='7px groove green'", driver.findElement(loc.fbLoginPage_Email_Editbox));
		
		driver.findElement(loc.fbLoginPage_Email_Editbox).sendKeys(p.getProperty("FB_UN"));
		driver.findElement(loc.fbLoginPage_Password_Editbox).sendKeys(p.getProperty("FB_PWSD"));
		driver.findElement(loc.fbLoginPage_Login_Button).click();
		// wait for 5 second
		Thread.sleep(5000);

		// driver.quit();

	}

	// take a screenshot
	@AfterTest
	public void screenshotAfterAtTestAnnotation() throws Exception {
		
		Date d = new Date();		
		DateFormat df = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timeStamp = df.format(d);
				
		//String screenshotPath = ".\\screenshots\\";
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);		
		//Move taken screenshot from abc location to screenshots folder
		FileHandler.copy(abc, new File(".\\screenshots\\test"+timeStamp+".png"));
		
	}
}
