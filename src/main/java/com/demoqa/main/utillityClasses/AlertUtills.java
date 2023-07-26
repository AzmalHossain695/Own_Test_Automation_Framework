package com.demoqa.main.utillityClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.demoqa.main.frameworkClasses.DriverFactory;

public class AlertUtills {
    private static final Logger log = LogManager.getLogger(AlertUtills.class);
    private WebDriver driver = DriverFactory.getInstance();

	public String getAlertText() {
		log.info("Getting Alert Text");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
	}
	public String getPrmoptBoxAlertText(String inputText) {
		log.info("Getting prompt box text");
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.sendKeys(inputText);
		alert.accept();
		return alertText;
	}
}
