package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.WaitUtills;

public class NewTabSamplePage extends BaseForm {	
	private WaitUtills wait = new WaitUtills();
    private static final Logger log = LogManager.getLogger(NewTabSamplePage.class);    
    private static By newTabUniqueLocator = By.xpath("//h1[@id='sampleHeading' and contains (text(), 'This is a sample page')]");
    
    public NewTabSamplePage() {
    	super(new UniqueElement(newTabUniqueLocator, "New Tab Form"), "New Tab Form");
	}	
    public boolean isNewTabWithSamplePageOpen() throws Exception {
    	log.info("Checking if new tab with sample page is open");
    	wait.waitUntilElementIsFound(newTabUniqueLocator);
    	boolean isNewTabWithSamplePageOpen = super.isPageLoaded();
    	return isNewTabWithSamplePageOpen;
    }
}
