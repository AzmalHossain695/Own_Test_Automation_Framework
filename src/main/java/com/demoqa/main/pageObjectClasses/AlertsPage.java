package com.demoqa.main.pageObjectClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.demoqa.main.frameworkClasses.BaseElement;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.DriverFactory;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.WaitUtills;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AlertsPage extends BaseForm {
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
	private WaitUtills wait = new WaitUtills();
    private static final Logger log = LogManager.getLogger(AlertsPage.class); 
	private static WebDriver driver = DriverFactory.getInstance();
    private static By alertsButtonLocator = By.xpath("//span[@class='text' and contains(text(), 'Alerts')]");
    private static By alertsFormUniqueLocator = By.xpath("//div[@class='main-header' and contains(text(), 'Alerts')]");
    private static By alertsClickButtonToSeeAlertLocator = By.xpath("//button[@id='alertButton']");
    private static By confirmBoxButtonLocator = By.xpath("//button[@id='confirmButton']");
    private static By confirmResultTextLocator = By.xpath("//span[@id='confirmResult']");
    private static By promptBoxButtonLocator = By.xpath("//button[@id='promtButton']");
    private static By promptResultLocator = By.xpath("//span[@id='promptResult']");
    private ButtonElement alertsButton = new ButtonElement(alertsButtonLocator, "Alerts");
    private ButtonElement clickMeToSeeAlertButton = new ButtonElement(alertsClickButtonToSeeAlertLocator, "Alerts click me button");
    private ButtonElement confirmBoxButton = new ButtonElement(confirmBoxButtonLocator, "Confirm box button");
    private	BaseElement confirmResultUniqueElement = new UniqueElement(confirmResultTextLocator, "Confirm Result Unique Element");
    private ButtonElement promptBoxButton = new ButtonElement(promptBoxButtonLocator, "Prompt box button");
    private BaseElement promptResultUniqueElement = new UniqueElement(promptResultLocator, "Prompt result Unique Element");
    public AlertsPage() {
    	super(new UniqueElement(alertsFormUniqueLocator, "Alerts Form"), "Alerts Form");
    }    
	public void openAlertsForm() {
	 	log.info("Opening Alerts Form page");
		jsMethods.scrolling();
		alertsButton.findElement();
		wait.waitUntilClickable(alertsButtonLocator);
	 	alertsButton.click();
	}
	public boolean isAlertsFormAppeared() throws Exception {	
	    log.info("Checking if Alerts Form Appeared");
	    wait.waitUntilElementIsFound(alertsFormUniqueLocator);
	    boolean isAlertsFormAppeared = super.isPageLoaded();
	    return isAlertsFormAppeared;	    		
	}	
	public void clickOnClickButtonToSeeAlert() {	
		log.info("Opening Alert to get Alert Text");
		clickMeToSeeAlertButton.findElement();
		wait.waitUntilClickable(alertsClickButtonToSeeAlertLocator);
		clickMeToSeeAlertButton.click();	
		wait.waitUntillAlertIsPresent();
	}	
	public boolean isAlertPresent() {	
		log.info("Checking if Alert is Present");
		wait.waitUntillAlertIsNotPresent();
		boolean isAlertPresent = ExpectedConditions.alertIsPresent().apply(driver) != null;
		return isAlertPresent;
	}
	public void clickOnConfirmBoxAlert() {
		log.info("Opening confirm box alert");
		confirmBoxButton.findElement();
		wait.waitUntilClickable(confirmBoxButtonLocator);
		confirmBoxButton.click();
		wait.waitUntillAlertIsPresent();		
	}			
	public String getConfirmBoxTextOnPage() {
		log.info("Getting confirm box text");
		WebElement element = confirmResultUniqueElement.findElement();
		wait.waitUntilElementIsFound(confirmResultTextLocator);
		return element.getText();
	} 
	public void openPromptBoxAlert () {
		log.info("Opening prompt box");
		jsMethods.scrolling();
		promptBoxButton.findElement();
		wait.waitUntilClickable(promptBoxButtonLocator);
		promptBoxButton.click();
		wait.waitUntillAlertIsPresent();		
	}	
	public String getPromptResult() {
		log.info("Get prompt result");
		WebElement element = promptResultUniqueElement.findElement();
		wait.waitUntilElementIsFound(promptResultLocator);
		return element.getText().substring("You entered ".length());
	}	
}
