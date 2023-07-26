package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;

public class BrowserWindowsPage extends BaseForm {
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
    private static final Logger log = LogManager.getLogger(BrowserWindowsPage.class);
    private static By browserWindowsButtonLocator = By.xpath("//span[@class='text' and contains(text(), 'Browser Windows')]");
    private static By browserWindowsFormUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Browser Windows')]");
    private static By newTabButtonLocator = By.xpath("//button[@id='tabButton']");
	private static By elementsLocator = By.xpath("//div[@class='header-text' and contains (text(), 'Elements')]");
	private ButtonElement browserWindowsButton = new ButtonElement(browserWindowsButtonLocator, "Browser Windows Button");
	private ButtonElement newTabButton = new ButtonElement(newTabButtonLocator, "New Tab Button");
	private ButtonElement elementsButton = new ButtonElement(elementsLocator, "Elements Button");
    
	public BrowserWindowsPage() {
    	super(new UniqueElement(browserWindowsFormUniqueLocator, "Browser Windows Form"), "Browser Windows Form");
	}
	public void openBrowserWindowsForm() {
		log.info("Opening Browser Windows form");
		jsMethods.scrolling();	
		browserWindowsButton.findElement();
		wait.waitUntilClickable(browserWindowsButtonLocator);
		browserWindowsButton.click();
	}
	public boolean isBrowserWindowsFormAppeared() throws Exception {
	    log.info("Checking if Browser windows form appeared");
	    boolean isBrowserWindowsFormOpened = super.isPageLoaded();	     
	    return isBrowserWindowsFormOpened;
	} 
	public void clickOnNewTabButton() {
		log.info("Clicking on New Tab Button");
		newTabButton.findElement();
		wait.waitUntilClickable(newTabButtonLocator);
		newTabButton.click();
	}	
	public void clickOnElementsButton() {
		log.info("Clicking on elements button");
		elementsButton.findElement();
		wait.waitUntilClickable(elementsLocator);
		elementsButton.click();
	}
}
