package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;

public class WebTablesPage extends BaseForm {	
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
    private static final Logger log = LogManager.getLogger(WebTablesPage.class);
    private static By webTablesButtonLocator = By.xpath("//span[@class='text' and contains(text(), 'Web Tables')]");
    private static By webTablesUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Web Tables')]");    
    private ButtonElement webTablesButton = new ButtonElement(webTablesButtonLocator, "Web Tables");
	
	public WebTablesPage() {
    	super(new UniqueElement(webTablesUniqueLocator, "Web Tables"), "Web Tables");
	}
	public void openWebTablesForm() {
	 	log.info("Opening Web Tables Form page");
		jsMethods.scrolling();		
		webTablesButton.findElement();
		wait.waitUntilClickable(webTablesButtonLocator);
	 	webTablesButton.click();		
	}
	public boolean isWebTablesFormOpen() throws Exception {
		log.info("Checking if web tables form open");
		boolean isWebTablesFormAppeared = super.isPageLoaded();
		return isWebTablesFormAppeared;
	}	
}
