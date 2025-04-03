package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.Commonfunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;

public class GetAllWebelementsonCurrentPage extends Commonfunctions {

	@AfterMethod
	public void afterMethod() throws Exception {
		takescreenshot("GetAllWebelementsonCurrentPage");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void f() throws Exception {
		GetAllWebelementsonCurrentPage("FB_URL");
	}
}
