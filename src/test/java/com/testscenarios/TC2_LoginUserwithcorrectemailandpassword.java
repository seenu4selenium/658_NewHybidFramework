package com.testscenarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.objectrepository.QA_Locators;
import com.utilities.Commonfunctions;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TC2_LoginUserwithcorrectemailandpassword {

	WebDriver driver;

	@Test
	public void loginUserwithcorrectemailandpassword() throws Exception {

		driver = new ChromeDriver();
		QA_Locators Loc = new QA_Locators();

		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\QA_TestData.properties");
		p.load(fi);

		driver.get(p.getProperty("AE_URL"));
		driver.manage().window().maximize();

		WebElement homepage = driver.findElement(Loc.AE_Homepage_Click);
		if (homepage.isDisplayed()) {
			System.out.println("Home page is visible successfully");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("***Implicit wait method used***");

		driver.findElement(Loc.AE_Consent_Click).click();

		driver.findElement(Loc.AE_Signuplogin_Click).click();

		WebElement loginToAccount = driver.findElement(Loc.AE_Homepage_Click);
		if (loginToAccount.isDisplayed()) {
			System.out.println("'Login to your account' is visible.");
		}

		driver.findElement(Loc.AE_EmailAddress_Editbox).sendKeys(p.getProperty("AE_UN"));
		driver.findElement(Loc.AE_Password_Editbox).sendKeys(p.getProperty("AE_PWSD"));
		driver.findElement(Loc.AE_LoginButton_Click).click();

		WebElement loggedIn = driver.findElement(Loc.AE_LoggedinButton_text);
		if (loggedIn.isDisplayed()) {
			System.out.println("'Logged in as Venkat' is visible.");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("***Implicit wait method used***");
		}
		driver.findElement(Loc.AE_Deleteaccount_Click).click();

		WebElement accountDeleted = driver.findElement(Loc.AE_accountdeleted_Deleted);
		if (accountDeleted.isDisplayed()) {
			System.out.println("'ACCOUNT DELETED!' is visible.");
			Thread.sleep(2000);
		}
	}

	// take a screenshot
	@AfterTest
	public void screenshotAfterAtTestAnnotation() throws Exception {

		Date d = new Date();
		DateFormat df = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timeStamp = df.format(d);

		// String screenshotPath = ".\\screenshots\\";
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Move taken screenshot from abc location to screenshots folder
		FileHandler.copy(abc, new File(".\\screenshots\\test" + timeStamp + ".png"));

	}
}
