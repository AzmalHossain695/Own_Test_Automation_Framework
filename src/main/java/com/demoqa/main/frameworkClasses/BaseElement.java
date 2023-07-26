package com.demoqa.main.frameworkClasses;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.demoqa.main.pageObjectClasses.AlertsPage;

public abstract class BaseElement {
    private WebDriver driver = DriverFactory.getInstance();  
    private static final Logger log = LogManager.getLogger(AlertsPage.class); 
    private By locator;
    
    public BaseElement(By locator, String name) {
        this.locator = locator;       
    }
    public boolean isDisplayed() throws Exception {
    	log.info("Checking if the page is displayed");
    	return findElement().isDisplayed();
    }
    public WebElement findElement() {
    	log.info("Finding Element");
        return driver.findElement(locator);
    }
    public List<WebElement> findElements() {
    	log.info("Finding Elements");
        return driver.findElements(locator);
    }
    
    public void click() {
    	log.info("Clicking on the button");
        findElement().click();
    }
    public void type(String text) {
    	log.info("Typing");
        findElement().sendKeys(text);;
    }
}