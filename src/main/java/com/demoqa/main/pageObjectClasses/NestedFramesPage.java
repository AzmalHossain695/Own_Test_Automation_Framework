package com.demoqa.main.pageObjectClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.IframeUtills;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;

public class NestedFramesPage extends BaseForm {
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
	private IframeUtills iframeUtills = new IframeUtills();
    private static final Logger log = LogManager.getLogger(NestedFramesPage.class);
    private static By nestedFramesButtonLocator = By.xpath("//span[@class='text' and contains(text(), 'Nested Frames')]");
    private static By nestedFramesFormUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Nested Frames')]");
    private static By parentIframeLocator = By.cssSelector("#frame1");
    private static By childIframeLocator = By.cssSelector("body > iframe");
    private static By iframeTextLocator = By.tagName("body");
    private ButtonElement nestedFramesButton = new ButtonElement(nestedFramesButtonLocator, "Nested Frames");
    
	public NestedFramesPage() {
    	super(new UniqueElement(nestedFramesFormUniqueLocator, "Nested Frames Form"), "Nested Frames Form");
	}	
	public void openNestedFramesForm() {	
		log.info("Opening Nested Frames Form");
		jsMethods.scrolling();		
		nestedFramesButton.findElement();
		wait.waitUntilClickable(nestedFramesButtonLocator);
		nestedFramesButton.click();
	}
	public boolean isNestedFramesFormAppeared() throws Exception {
		log.info("Checking if Nested Frames form appeared");
	    boolean isNestedFramesFormAppeared = super.isPageLoaded();
	    return isNestedFramesFormAppeared;	    		
	} 	
	public String getIframesText() {	
		iframeUtills.switchToFrame(parentIframeLocator);
		String parentFrameText = iframeUtills.getIFrameText(iframeTextLocator);
		iframeUtills.switchToFrame(childIframeLocator);
		String childFrameText = iframeUtills.getIFrameText(iframeTextLocator);
		String finalString = parentFrameText + " " + childFrameText;
		iframeUtills.switchToDeafault();
		return finalString;
	}
}
