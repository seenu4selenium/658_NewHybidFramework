package com.objectrepository;

import org.openqa.selenium.By;
//Here QA will store Application locators
public class QA_Locators {
	// PageName_ElementName_TypeOfElement
	public final By fbLoginPage_Email_Editbox = By.id("email");
	public final By fbLoginPage_Password_Editbox = By.name("pass");
	public final By fbLoginPage_Login_Button = By.name("login");	
	public final By products_Search_Editbox = By.name("search");
	
	
	//autotestdata locators
	public final By atd_numberRange_checkbox = By.xpath("//*[@id=\"property-table\"]/div[6]/div[1]/div/img[1]");
	public final By atd_Excel_RadioButton = By.id("exampleRadios10");
	public final By atd_numberofrows_Editbox = By.id("total-rows-gen");
	public final By atd_generate_button = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[2]/div");
	public final By atd_download_button = By.xpath("/html/body/div[1]/div[1]/div[5]/button");

	public final By atd_nameOption_dropdown = By.xpath("//*[@id='property-table']/div[2]/div[4]/div/select");
	
	public final By dob_dropdown = By.xpath("//*[@id='basicBootstrapForm']/div[11]/div[2]/select");
}
