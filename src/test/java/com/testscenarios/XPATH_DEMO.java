package com.testscenarios;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class XPATH_DEMO {
	@Test
	public void f() {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.pqe.io/go-signup/");	
		//wait 
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		driver.findElement(By.id("firstName")).sendKeys("RAMAN");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("selenium");
		
		
	}
}
