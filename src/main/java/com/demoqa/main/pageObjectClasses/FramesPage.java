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

public class FramesPage extends BaseForm {
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
	private IframeUtills iframeUtills = new IframeUtills();
    private static final Logger log = LogManager.getLogger(FramesPage.class);
    private static By framesButtonLocator = By.xpath("//SPAN[@class='text'][text()='Frames']");
    private static By framesFormUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Frames')]");
    private static By upperFrameLocator = By.id("frame1");
    private static By lowerFrameLocator = By.id("frame2");
    private static By frameTextLocator = By.id ("sampleHeading");
    private ButtonElement framesButton = new ButtonElement(framesButtonLocator, "Frames");
    
    public FramesPage() {
    	super(new UniqueElement(framesFormUniqueLocator, "Frames Form"), "Frames Form");
	}	   
    public void openFramesForm() {	
		log.info("Opening frames form");
		jsMethods.scrolling();		
		framesButton.findElement();
		wait.waitUntilClickable(framesButtonLocator);
		framesButton.click();
	}
	public boolean isFramesFormOpen() throws Exception {
	    log.info("Checking if frames form open");
	    boolean isframesFormAppeared = super.isPageLoaded();
	    return isframesFormAppeared;	    		
	}       
	public String getUpperFrameText() {
		wait.waitUntilElementIsFound(upperFrameLocator);
		iframeUtills.switchToFrame(upperFrameLocator);
		String upperFrameText = iframeUtills.getIFrameText(frameTextLocator);	
		return upperFrameText;
	}
	public String getLowerFrameText() {
		iframeUtills.switchToDeafault();
		wait.waitUntilElementIsFound(lowerFrameLocator);
		iframeUtills.switchToFrame(lowerFrameLocator);
		String lowerFrameText = iframeUtills.getIFrameText(frameTextLocator);	
		return lowerFrameText;
	}
}
