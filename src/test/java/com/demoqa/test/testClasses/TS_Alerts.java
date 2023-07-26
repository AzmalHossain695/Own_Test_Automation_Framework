package com.demoqa.test.testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.main.pageObjectClasses.AlertsPage;
import com.demoqa.main.pageObjectClasses.MainPage;
import com.demoqa.main.utillityClasses.AlertUtills;
import com.demoqa.main.utillityClasses.TestDataManager;

public class TS_Alerts extends BaseTest {
	MainPage mainPage = new MainPage();
	AlertsPage alertsPage = new AlertsPage();
	AlertUtills alertUtills = new AlertUtills();
	TestDataManager testData = new TestDataManager();	
	@Test
	public void alertsTest () throws Exception {		
		mainPage.openMainPage();
		Assert.assertTrue(mainPage.isMainPageOpen(), "Main Page is not opened"); 	
		mainPage.clickOnAlertsFrameWindowsButton();
		alertsPage.openAlertsForm();
		Assert.assertTrue(alertsPage.isAlertsFormAppeared(), "Alerts form not appeared");
		alertsPage.clickOnClickButtonToSeeAlert();
		Assert.assertEquals(alertUtills.getAlertText(), testData.getExpectedAlertTextClickButtonToSeeAlert(), "Alert with expected text not appeared");		
		Assert.assertFalse(alertsPage.isAlertPresent(), "Alert is still present after clicking OK");
		alertsPage.clickOnConfirmBoxAlert();
		Assert.assertEquals(alertUtills.getAlertText(), testData.getExpectedConfirmBoxAlertText(), "Alert with expected text not appeared");
		Assert.assertFalse(alertsPage.isAlertPresent(), "Alert is still present after clicking OK");
		Assert.assertEquals(alertsPage.getConfirmBoxTextOnPage(), testData.getExpectedConfirmBoxTextOnPage(), "Expected text has not appeared on page");
		alertsPage.openPromptBoxAlert();
		String inputText = testData.getRandomText();
		Assert.assertEquals(alertUtills.getPrmoptBoxAlertText(inputText), testData.getExpectedPromptAlertText(), "Alert with expected text not appeared");
		Assert.assertFalse(alertsPage.isAlertPresent(), "Alert is still present after clicking OK");
		Assert.assertEquals(alertsPage.getPromptResult(), inputText, "Expected text has not appeared on page");
	}	
}
