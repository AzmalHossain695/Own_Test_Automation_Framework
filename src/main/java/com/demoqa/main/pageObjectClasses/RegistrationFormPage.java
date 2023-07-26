package com.demoqa.main.pageObjectClasses;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.demoqa.main.frameworkClasses.BaseForm;
import com.demoqa.main.frameworkClasses.ButtonElement;
import com.demoqa.main.frameworkClasses.InputElement;
import com.demoqa.main.frameworkClasses.UniqueElement;
import com.demoqa.main.utillityClasses.JavaScriptMethods;
import com.demoqa.main.utillityClasses.TestDataManager;
import com.demoqa.main.utillityClasses.WaitUtills;

public class RegistrationFormPage extends BaseForm {
	private TestDataManager testDataManager = new TestDataManager();
	private WaitUtills wait = new WaitUtills();
	private JavaScriptMethods jsMethods = new JavaScriptMethods();
    private static final Logger log = LogManager.getLogger(RegistrationFormPage.class);
	private static By addButtonLocator = By.xpath("//button[@id='addNewRecordButton']");
    private static By registrationFormUniqueLocator = By.xpath("//div[@class='modal-title h4']");
    private static By submitButtonLocator = By.id("submit");
    private static By deleteRecordButton = By.id("delete-record-4");
    private static By notNullElementLocator = By.xpath("//div[@role='row'][(descendant::div[@role='gridcell' and not(string-length(normalize-space()) > 0)])]");
    private ButtonElement addButton = new ButtonElement(addButtonLocator, "Registration Form");
    private ButtonElement submitButton = new ButtonElement(submitButtonLocator, "Submit Button");
    private ButtonElement deleteButton = new ButtonElement(deleteRecordButton, "Delete Button");
    private UniqueElement notNullElements  = new UniqueElement(notNullElementLocator, "Elements with value");
    
    public RegistrationFormPage() {
    	super(new UniqueElement(registrationFormUniqueLocator, "Registration Form"), "Registration Form");
	}
    public void openRegistrationForm() {
		log.info("Clicking on add button");
    	addButton.findElement();
		wait.waitUntilClickable(addButtonLocator);
		addButton.click();
    }
	public boolean isRegistrationFormAppeared() throws Exception {		
		log.info("Checking if Registration form apppeared");
		boolean isRegistrationFormAppeared = super.isPageLoaded();
		return isRegistrationFormAppeared;
	}
	public List<String> getExpectedUserData(JSONObject userData) {
		log.info("Storing user data from testdata file");
	    List<String> expectedData = new ArrayList<>();
	    expectedData.add(userData.getString("first name"));
	    expectedData.add(userData.getString("last name"));
	    expectedData.add(String.valueOf(userData.getInt("age")));
	    expectedData.add(userData.getString("email"));
	    expectedData.add(String.valueOf(userData.getInt("salary")));
	    expectedData.add(userData.getString("department"));
	    return expectedData;
	}
	public void enterUserData(int i) {		
		log.info("Entering user data");	
		JSONObject userData = testDataManager.getUserData(i);
		new InputElement(By.id("firstName"), "first Name").type(userData.getString("first name"));
		new InputElement(By.id("lastName"), "last Name").type(userData.getString("last name"));
		new InputElement(By.id("age"), "age").type(String.valueOf(userData.getInt("age")));
		new InputElement(By.id("userEmail"), "user email").type(userData.getString("email"));
		new InputElement(By.id("salary"), "salary").type(String.valueOf(userData.getInt("salary")));
		new InputElement(By.id("department"), "department").type(userData.getString("department"));	 
	}
	public void submitUserData() {
	    log.info("Submitting user data");
		submitButton.findElement();
	    wait.waitUntilClickable(By.id("submit"));
	    submitButton.click();	        
	}	
	public boolean isRegistrationFormClosed() {
		log.info("Checking if Registration Form is closed");
		return wait.isFormClosed(registrationFormUniqueLocator);
	}
	public List<String> getActualUserData() {
		log.info("Storing user data from website table");
		List<WebElement> rows = new UniqueElement(By.xpath("//div[@role='row']"), "Rows").findElements();
		WebElement row4 = rows.get(4);
		List<WebElement> cells = row4.findElements(By.xpath(".//div[@role='gridcell']"));
		List<String> cellValues = new ArrayList<String>();
		for (int i = 0; i < cells.size() - 1; i++) {
	        WebElement cell = cells.get(i);
	        cellValues.add(cell.getText());
	    }
		return cellValues;
	}
	public int getNumberOfRecordsBeforeDeletion() {
		log.info("Storing number of users before deleting");
		List<WebElement> rows = new UniqueElement(notNullElementLocator, "Elements with value").findElements();
		return rows.size();		
	}
	public void deleteUser() {
		log.info("Deleting the user");
		jsMethods.scrolling();
    	deleteButton.findElement();
		wait.waitUntilClickable(deleteRecordButton);
		deleteButton.click();
	}
	public int getNumberOfRecordsAfterDeletion() {
		log.info("Getting number of records after deletion");
		List<WebElement> rows = notNullElements.findElements();
		return rows.size();
	}	
}
