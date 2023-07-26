package com.demoqa.main.utillityClasses;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.demoqa.main.frameworkClasses.DriverFactory;

public class WaitUtills {
	private WebDriver driver = DriverFactory.getInstance();
	
	public WebElement waitUntilClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWait()));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement waitUntilElementIsFound(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWait()));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }    
    public Alert waitUntillAlertIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWait()));
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public Boolean waitUntillAlertIsNotPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWait()));
        return wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    } 
    public boolean isFormClosed(By locator) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigManager.getWait()));
    	return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
