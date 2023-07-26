package com.demoqa.test.testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import com.demoqa.main.frameworkClasses.DriverFactory;

public class BaseTest {
	private WebDriver driver;
	
	@BeforeMethod
	public void BeforeMethod() {
		driver = DriverFactory.getInstance();	
		driver.manage().window().maximize();
	}
	@AfterTest
	public void AfterTest() {
		driver.close();
	}
}
