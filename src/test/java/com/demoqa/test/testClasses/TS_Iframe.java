package com.demoqa.test.testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.main.pageObjectClasses.FramesPage;
import com.demoqa.main.pageObjectClasses.MainPage;
import com.demoqa.main.pageObjectClasses.NestedFramesPage;
import com.demoqa.main.utillityClasses.TestDataManager;
public class TS_Iframe extends BaseTest {
	MainPage mainPage = new MainPage();
	NestedFramesPage nestedFramesPage = new NestedFramesPage();
	FramesPage framesPage = new FramesPage();
	TestDataManager testData = new TestDataManager();	
	@Test
	public void IframeTests() throws Exception {
		mainPage.openMainPage();
		Assert.assertTrue(mainPage.isMainPageOpen(), "Main Page is not opened"); 	
		mainPage.clickOnAlertsFrameWindowsButton();
		nestedFramesPage.openNestedFramesForm();
		Assert.assertTrue(nestedFramesPage.isNestedFramesFormAppeared(), "Nested frames form is not opened");
		String expectedIFramesText = testData.getExpectedIframeText();
		Assert.assertEquals(nestedFramesPage.getIframesText(), expectedIFramesText, "Expected messages are not present on page");
		framesPage.openFramesForm();
		Assert.assertTrue(framesPage.isFramesFormOpen(), "Frames form in not opened");
		Assert.assertEquals(framesPage.getUpperFrameText(), framesPage.getLowerFrameText(), "Message from upper frame is not equal to the message from lower frame");
	}	
}
