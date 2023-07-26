package com.demoqa.test.testClasses;

import java.util.List;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.main.pageObjectClasses.MainPage;
import com.demoqa.main.pageObjectClasses.RegistrationFormPage;
import com.demoqa.main.pageObjectClasses.WebTablesPage;
import com.demoqa.main.utillityClasses.TestDataManager;
public class TS_Tables extends BaseTest {
	MainPage mainPage = new MainPage();
	WebTablesPage webTablesPage = new WebTablesPage();
	RegistrationFormPage registrationFormPage = new RegistrationFormPage();
	TestDataManager testDataManager = new TestDataManager();	
	@Test
	public void tablesTest() throws Exception {
		mainPage.openMainPage();
		Assert.assertTrue(mainPage.isMainPageOpen(), "Main Page is not opened");	
		mainPage.clickOnElementsButton();
		webTablesPage.openWebTablesForm();
		Assert.assertTrue(webTablesPage.isWebTablesFormOpen(), "Page with Web Tables form is not opened");
		int numOfUsers = testDataManager.getNumberOfUsers();
		for (int i=0; i<numOfUsers; i++) {
			registrationFormPage.openRegistrationForm();
			Assert.assertTrue(registrationFormPage.isRegistrationFormAppeared(), "Registration Form has not appeared on page");
			registrationFormPage.enterUserData(i);
			registrationFormPage.submitUserData();
			Assert.assertTrue(registrationFormPage.isRegistrationFormClosed(), "Registration Form has not closed");
			JSONObject userData = new JSONObject(testDataManager.getUserDataList().get(String.valueOf(i + 1)).get(0).toString());
			List <String> expectedUserData = registrationFormPage.getExpectedUserData(userData);
			List <String> actualUserData = registrationFormPage.getActualUserData();
			Assert.assertEquals(actualUserData, expectedUserData, "Data of User has not appeared in a table");
			int recordsBeforeDeletion = registrationFormPage.getNumberOfRecordsBeforeDeletion();
			List <String> actualUserDataBeforeDeletion = registrationFormPage.getActualUserData();
			registrationFormPage.deleteUser();
			int recordsAfterDeletion = registrationFormPage.getNumberOfRecordsAfterDeletion();
			Assert.assertNotEquals(recordsBeforeDeletion, recordsAfterDeletion, "Number of records in table has not changed");
			List <String> actualUserDataAfterDeletion = registrationFormPage.getActualUserData();
			Assert.assertNotEquals(actualUserDataBeforeDeletion, actualUserDataAfterDeletion, "Data of user has not been deleted");
		}
	}	
}
