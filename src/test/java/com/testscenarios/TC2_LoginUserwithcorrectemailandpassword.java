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

public class TC2_LoginUserwithcorrectemailandpassword extends Commonfunctions {

	@Test
	public void loginUserwithcorrectemailandpassword() throws Exception {
		launchChromeBrowser();
		getURL("AE_URL");
		verifyWebElement(loc.AE_Homepage_Click);
		implicitWait(30);
		
		try {
			clickByAnyLocator(loc.AE_Consent_Click);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		clickByAnyLocator(loc.AE_Signuplogin_Click);
		verifyWebElement(loc.AE_Homepage_Click);
		sendKeysByAnyLocator(loc.AE_EmailAddress_Editbox, "AE_UN");
		sendKeysByAnyLocator(loc.AE_Password_Editbox, "AE_PWSD");
		clickByAnyLocator(loc.AE_LoginButton_Click);
		verifyWebElement(loc.AE_LoggedinButton_text);
		clickByAnyLocator(loc.AE_Deleteaccount_Click);
		verifyWebElement(loc.AE_accountdeleted_Deleted);
	}

	@AfterTest
	public void screenshotAfterAtTestAnnotation() throws Exception {
		takescreenshot();
	}
}
