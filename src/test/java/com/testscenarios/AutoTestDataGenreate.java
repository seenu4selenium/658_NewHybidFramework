package com.testscenarios;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.utilities.Commonfunctions;

public class AutoTestDataGenreate extends Commonfunctions {

	@BeforeClass
	public void beforeClass() throws Exception {
		launchChromeBrowser();
		getURL("ATD_URL");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@AfterMethod
	public void afterMethod() throws Exception {
		takescreenshot();
		takescreenshot("AutoTestDataGenreate");
	}

	@Test
	public void f() throws Exception {

		//Verify atd_nameOption_dropdown locator has displayed?
		verifyWebElement(loc.atd_nameOption_dropdown);
		
		
		clickByAnyLocator(loc.atd_numberRange_checkbox);
		clickByAnyLocator(loc.atd_Excel_RadioButton);
		sendKeysByAnyLocator(loc.atd_numberofrows_Editbox, "ATD_NumberOfRows");
		// Click on generate button
		clickByAnyLocator(loc.atd_generate_button);
		implicitWait(30);
		// Click on download button
		clickByAnyLocator(loc.atd_download_button);

	}

}
