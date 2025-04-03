package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.objectrepository.QA_Locators;

public class Commonfunctions {
	public String testDataPath = ".\\src\\test\\resources\\testdata\\QA_TestData.properties";

	public static WebDriver driver;
	public FileInputStream fi;

	public QA_Locators loc = new QA_Locators();
	public Properties p = new Properties();
	public JavascriptExecutor executor = (JavascriptExecutor) driver;

	// Launch chrome browser
	public void launchChromeBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("******* Chrome Browser Launched Successfully *******");
	}

	public void launchEdgeBrowser() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		System.out.println("******* Edge Browser Launched Successfully *******");
	}

	public void launchChromeIncogintoBrowser() {
		// Chrome browser incoginto window
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--incoginto");
		driver = new ChromeDriver(ops);
		driver.manage().window().maximize();
		System.out.println("******* Chrome incoginto Browser Launched Successfully *******");
	}

	// Get URL
	public void getURL(String URL) throws Exception {
		fi = new FileInputStream(testDataPath);
		p.load(fi);
		driver.get(p.getProperty(URL));
		implicitWait(10);
		System.out.println("******* URL Launched in a Browser Successfully *******");

	}

	/************ waits in selenium ***********************/

	public void implicitWait(int waitTime) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println("***Implicit wait method used***");
	}

	public void waitForElementToBevisibilityOf(By locator, int waitTime) {
		WebElement element = driver.findElement(locator);
		try {
			new WebDriverWait(driver, Duration.ofSeconds(waitTime)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.visibilityOf(element));
			System.out.println("element To Be visibilityOf***");
		} catch (Exception Ex) {
			System.out.println(Ex);
			System.out.println("element To Be not visibilityOf***");
		}
	}

	public void waitForElementToBeClickable(By locator, int waitTime) {
		WebElement element = driver.findElement(locator);
		try {
			new WebDriverWait(driver, Duration.ofSeconds(waitTime)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.elementToBeClickable(element));
			System.out.println("element To Be lickable***");
		} catch (Exception Ex) {
			System.out.println(Ex);
			System.out.println("element To Be not Clickable***");
		}
	}

	public void waitForElementToBeClickable(int waitTime) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(waitTime)).ignoring(StaleElementReferenceException.class)
					.until(ExpectedConditions.alertIsPresent());
			System.out.println("alert Is Present***");
		} catch (Exception Ex) {
			System.out.println(Ex);
			System.out.println("alert Is not Present****");
		}
	}

//	  Wait<WebDriver> wait
//      = new FluentWait<>(driver)
//            .withTimeout(Duration.ofSeconds(40))
//            .pollingEvery(Duration.ofSeconds(3))
//            .ignoring(TimeoutException.class);
//	  
	/***
	 * instead of fluent wait use customized While loop statement
	 ** 
	 * @throws Exception
	 *****/

	public void waitforElement(By locater) throws Exception {
		int i = 0;
		while (driver.findElements(locater).size() < 1) {// 1<1
			Thread.sleep(2000);
			System.out.println("Wait for the element***************");
			// Suppose system has not present the element it will repeat 30 time
			// then stop
			// the execution using break
			if (i > 30) {
				System.out.println("Element is not present");
				break;
			}
			i++;
		}
	}

	/*******
	 * SendKeys
	 * 
	 * @throws Exception
	 ************************/
	public void sendKeysByAnyLocator(By locator, String inputdata) throws Exception {
		fi = new FileInputStream(testDataPath);
		p.load(fi);

		WebElement element = driver.findElement(locator);

		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				System.out.println("Given locator is enable state ***");
				// Clear any existing data
				highlightElement(element);
				element.clear();
				// Send the test data to Edit box
				highlightElement(element);
				element.sendKeys(p.getProperty(inputdata));
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	public void highlightElement(WebElement element) throws InterruptedException {
		try {

			for (int i = 0; i < 1; i++) {
				executor.executeScript("arguments[0].style.border='7px solid red'", element);
				Thread.sleep(200);
				executor.executeScript("arguments[0].style.border='7px groove green'", element);
			}
		} catch (Exception e) {
			System.out.println("Exception - " + e.getMessage());
		}
	}

	/*******
	 * Click
	 * 
	 * @throws Exception
	 ************************/
	public void clickByAnyLocator(By locator) throws Exception {
		implicitWait(10);
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				highlightElement(element);
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}

	// time stamp
	public String timeStamp() {
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("MMddyyyy_HHmmss");
		String timeStamp = df.format(d);
		return timeStamp;
	}

	// Take screenshot
	public void takescreenshot() throws Exception {
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\test" + timeStamp() + ".png"));
	}

	public void takescreenshot(String name) throws Exception {
		File abc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(abc, new File(".\\screenshots\\" + name + timeStamp() + ".png"));
	}

	/****************** Dropdown selection **************************************/

	public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void printAllDropdownValues(By locater) {
		WebElement element = driver.findElement(locater);

		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println("dropdown values are: " + dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());
				}
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());

					// Select Aug option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void verifyWebElement(By locator) {
		// Validate the given Locator has displayed or not on current Page?
		if (driver.findElements(locator).size() > 0) {
			System.out.println(locator + " is displayed on screen ");
		} else {
			System.out.println(locator + " is not displayed on screen,please check the locator ");
		}

	}

	public void GetAllWebelementsonCurrentPage(String URL) throws Exception {
		launchChromeBrowser();
		getURL(URL);

		By allEdiboxes = By.xpath("//*[@type='text']");
		By checkboxes = By.xpath("//*[@type='checkbox']");
		By radiobuttons = By.xpath("//*[@type='radio']");
		By hyperlinks = By.xpath("//a");
		By dropdowns = By.xpath("//select");
		By buttons = By.xpath("//button");
		By password_editbox = By.xpath("//*[@type='password']");

		// Get editboxes from current page
		List<WebElement> allEditboxesCount = driver.findElements(allEdiboxes);
		System.out.println("Ediboxes count is: " + allEditboxesCount.size());

		List<WebElement> allPasswordCount = driver.findElements(hyperlinks);
		System.out.println("Password Ediboxes count is: " + allPasswordCount.size());

		List<WebElement> allCheckboxesCount = driver.findElements(checkboxes);
		System.out.println("Checkboxes count is: " + allCheckboxesCount.size());

		List<WebElement> allRadiobuttonsCount = driver.findElements(radiobuttons);
		System.out.println("Radiobuttons count is: " + allRadiobuttonsCount.size());

		List<WebElement> allHyperlinksCount = driver.findElements(hyperlinks);
		System.out.println("Hyperlinks count is: " + allHyperlinksCount.size());

		List<WebElement> allDropdownCount = driver.findElements(dropdowns);
		System.out.println("Dropdown count is: " + allDropdownCount.size());

		List<WebElement> allButtonsCount = driver.findElements(buttons);
		System.out.println("Buttons count is: " + allButtonsCount.size());

		// Print all total webelements count in the current page?
		long totalWebElemnts = allEditboxesCount.size() + allPasswordCount.size() + allCheckboxesCount.size()
				+ allRadiobuttonsCount.size() + allHyperlinksCount.size() + allDropdownCount.size()
				+ allButtonsCount.size();
		System.out.println("**************************************************");
		System.out.println("****Total webelements count is: " + totalWebElemnts);
		System.out.println("**************************************************");
	}
}
