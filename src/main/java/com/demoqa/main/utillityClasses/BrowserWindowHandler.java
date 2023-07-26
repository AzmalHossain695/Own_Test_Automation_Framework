package com.demoqa.main.utillityClasses;

import org.openqa.selenium.WebDriver;
import com.demoqa.main.frameworkClasses.DriverFactory;

public class BrowserWindowHandler {
	private WebDriver driver;
	private String currentWindowHandler;
	
	public BrowserWindowHandler(){
		driver = DriverFactory.getInstance();
	}
	public void windowCheck() {
		currentWindowHandler = driver.getWindowHandle();		
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandler)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}
	public void switchToMainWindow() {
		driver.close();
		driver.switchTo().window(currentWindowHandler);
	}
}
