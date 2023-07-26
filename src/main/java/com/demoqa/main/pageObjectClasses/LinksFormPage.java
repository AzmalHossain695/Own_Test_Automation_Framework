package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;

public class LinksFormPage extends BaseForm {
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
    private static final Logger log = LogManager.getLogger(BrowserWindowsPage.class);    	
    private static By linksButtonLocator = By.xpath("//li[@id='item-5']//span[@class='text' and contains(text(), 'Links')]");
    private static By linksFormUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Links')]");
    private static By homeButtonLink = By.id("simpleLink");
    private ButtonElement linksButton = new ButtonElement(linksButtonLocator, "Links Button");
    private ButtonElement homeButton = new ButtonElement(homeButtonLink, "Home Button");
	
	public LinksFormPage() {
    	super(new UniqueElement(linksFormUniqueLocator, "Browser Windows Form"), "Browser Windows Form");
	}	
	public void openLinksForm() {
		log.info("Opening links form");
		jsMethods.scrolling();
		linksButton.findElement();
		wait.waitUntilClickable(linksButtonLocator);
		linksButton.click();
	}
	public boolean isLinksFormAppeared() throws Exception {
	    log.info("Checking if links form appeared");
	    boolean isLinksFormOpened = super.isPageLoaded();	     
	    return isLinksFormOpened;
	} 
	public void clickOnHomeButton() {
		log.info("Clicking on home button");
		homeButton.findElement();
		wait.waitUntilClickable(homeButtonLink);
		homeButton.click();
	}	
}
