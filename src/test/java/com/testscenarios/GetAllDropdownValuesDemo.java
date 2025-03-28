package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.Commonfunctions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.bidi.Command;
import org.testng.annotations.AfterClass;

public class GetAllDropdownValuesDemo extends Commonfunctions {
	@BeforeClass
	public void beforeClass() throws Exception {
		launchChromeBrowser();
		//getURL("ATD_URL");
		getURL("automationtesting");
	}

	@AfterMethod
	public void afterMethod() throws Exception {
		takescreenshot("GetAllDropdownValuesDemo");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void f() throws Exception {
		//printAllDropdownValues(loc.atd_nameOption_dropdown);
		printAllDropdownValues(loc.dob_dropdown);
	}

}
