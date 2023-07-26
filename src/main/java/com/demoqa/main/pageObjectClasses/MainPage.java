package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.DriverFactory;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.ConfigManager;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;

public class MainPage extends BaseForm {
	WaitUtills wait = new WaitUtills();
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
    private static final Logger log = LogManager.getLogger(MainPage.class);
	private static WebDriver driver = DriverFactory.getInstance();
	private static By mainPageUniqueLocator = By.className("banner-image");	
    private static By alertsFrameWindowsLocator = By.xpath("//h5[contains(text(),'Alerts, Frame & Windows')]");
    private static By elementsLocator = By.xpath("//h5[contains(text(), 'Elements')]");
    private ButtonElement alertsFramesWindowsButton = new ButtonElement(alertsFrameWindowsLocator, "Alerts, frames & windows");
    private ButtonElement elementsButton = new ButtonElement(elementsLocator, "Elements");
	
	public MainPage() {
		super(new UniqueElement(mainPageUniqueLocator, "Main Page"), "Main Page");		
	}
	public void openMainPage() {
		log.info("Opening Main Page");
		driver.get(ConfigManager.getUrl());
	}	
	public boolean isMainPageOpen() throws Exception {	
		log.info("Checking if main page is open");
		wait.waitUntilElementIsFound(mainPageUniqueLocator);
		boolean isMainPageLoaded = super.isPageLoaded();
		return isMainPageLoaded;
	}		
	public void clickOnAlertsFrameWindowsButton() {
		log.info("Clicking on Alerts Frame Windows button");
    	jsMethods.scrolling();		
    	alertsFramesWindowsButton.findElement();
		wait.waitUntilClickable(alertsFrameWindowsLocator);
		alertsFramesWindowsButton.click();		
    }
	public void clickOnElementsButton() {
		log.info("Clicking on Elements button");
		jsMethods.scrolling();		
		elementsButton.findElement();
		wait.waitUntilClickable(elementsLocator);
		elementsButton.click();		
	}
}
