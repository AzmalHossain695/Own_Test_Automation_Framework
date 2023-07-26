package com.demoqa.main.utillityClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.demoqa.main.frameworkClasses.DriverFactory;

public class JavaScriptMethods {	
	WebDriver driver;
	
	public void scrolling() {		
		driver = DriverFactory.getInstance();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	public void scrollUntillElementIsFound(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
