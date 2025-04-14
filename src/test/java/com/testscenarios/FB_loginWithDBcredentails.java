package com.testscenarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FB_loginWithDBcredentails {
	public Connection cnn;
	public Statement stmt;
	public ResultSet rs;
	public String un;
	public String pwd;

	@Test
	public void f() throws Exception {
		WebDriver driver;
		// Connect the DB
		String databaseURL = "jdbc:mysql://127.0.0.1:3306/658_batchdemo";
		String databaseUN = "root";
		String databasePWD = "admin@123";

		Class.forName("com.mysql.cj.jdbc.Driver");
		cnn = DriverManager.getConnection(databaseURL, databaseUN, databasePWD);

		// write a sql query
		String myQry = "select * from FB_User_Details where FB_UN= 'SREENIVAS@GMAIL.COM';";
		stmt = cnn.createStatement();

		// run hte SQL query
		rs = stmt.executeQuery(myQry);

		// to print the results will use While loop
		while (rs.next()) {
			un = rs.getString(1);
			pwd = rs.getString(2);
			// System.out.println(un + "\t" + pwd);
		}

		// Close the DB connection
		cnn.close();

		// Launch chrome browser
		driver = new ChromeDriver();

		driver.get("https://www.facebook.com/");
		// Get the title of the page
		System.out.println("Title of the page is: " + driver.getTitle());

		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.name("pass")).sendKeys(pwd);
		//driver.findElement(By.name("login")).click();
	}
}
