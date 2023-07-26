package com.demoqa.main.utillityClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.demoqa.main.frameworkClasses.DriverFactory;
import com.demoqa.main.frameworkClasses.UniqueElement;

public class IframeUtills {
	private static final Logger log = LogManager.getLogger(AlertUtills.class);
    private WebDriver driver = DriverFactory.getInstance();
    
    public void switchToFrame(By iframeLocator) {
    	log.info("Switching to Iframe");
    	driver.switchTo().frame(new UniqueElement(iframeLocator, "Iframe").findElement());
    }
    public String getIFrameText(By iframeTextLocator) {
		log.info ("Getting frames messages text");
    	String text = new UniqueElement(iframeTextLocator, "Frame Text").findElement().getText();
    	return text;
    }
    public void switchToDeafault() {
    	driver.switchTo().defaultContent();
    }
}
