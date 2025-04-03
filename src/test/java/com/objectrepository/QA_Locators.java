package com.objectrepository;

import org.openqa.selenium.By;

//Here QA will store Application locators
public class QA_Locators {
	// PageName_ElementName_TypeOfElement
	public final By fbLoginPage_Email_Editbox = By.id("email");
	public final By fbLoginPage_Password_Editbox = By.name("pass");
	public final By fbLoginPage_Login_Button = By.name("login");
	public final By products_Search_Editbox = By.name("search");

	// autotestdata locators
	public final By atd_numberRange_checkbox = By.xpath("//*[@id=\"property-table\"]/div[6]/div[1]/div/img[1]");
	public final By atd_Excel_RadioButton = By.id("exampleRadios10");
	public final By atd_numberofrows_Editbox = By.id("total-rows-gen");
	public final By atd_generate_button = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[2]/div");
	public final By atd_download_button = By.xpath("/html/body/div[1]/div[1]/div[5]/button");

	public final By atd_nameOption_dropdown = By.xpath("//*[@id='property-table']/div[2]/div[4]/div/select");

	public final By dob_dropdown = By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select");

	// TC2_Login User with correct email and password
	// (https://automationexercise.com/test_cases)
	public final By AE_Homepage_Click = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
	public final By AE_Signuplogin_Click = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public final By AE_Logintoyouraccount_text = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
	public final By AE_Consent_Click = By.xpath("/html/body/div/div[2]/div[2]/div[2]/div[2]/button[1]/p");
	public final By AE_EmailAddress_Editbox = By.xpath("//input[@type='email']");
	public final By AE_Password_Editbox = By.xpath("//input[@type='password']");
	public final By AE_LoginButton_Click = By.xpath("//button[@type='submit']");
	public final By AE_LoggedinButton_text = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
	public final By AE_Deleteaccount_Click = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	public final By AE_accountdeleted_Deleted = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");

	// Cwl locators
	public final By allEdiboxes = By.xpath("//*[@type='text']");
	public final By checkboxes = By.xpath("//*[@type='checkbox']");
	public final By radiobuttons = By.xpath("//*[@type='radio']");
	public final By hyperlinks = By.xpath("//a");
	public final By dropdowns = By.xpath("//select");
	public final By buttons = By.xpath("//button");
	public final By password_editbox = By.xpath("//*[@type='password']");

}
