package com.demoqa.test.testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.demoqa.main.pageObjectClasses.BrowserWindowsPage;
import com.demoqa.main.pageObjectClasses.LinksFormPage;
import com.demoqa.main.pageObjectClasses.MainPage;
import com.demoqa.main.pageObjectClasses.NewTabSamplePage;
import com.demoqa.main.utillityClasses.BrowserWindowHandler;
public class TS_Handles extends BaseTest {
	MainPage mainPage = new MainPage();
	BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage();
	NewTabSamplePage newTab = new NewTabSamplePage();
	BrowserWindowHandler windowHandler = new BrowserWindowHandler();
	LinksFormPage linksFormPage = new LinksFormPage();	
	@Test
	public void HandlesTest() throws Exception {
		mainPage.openMainPage();
		Assert.assertTrue(mainPage.isMainPageOpen(), "MainPage is not opened");
		mainPage.clickOnAlertsFrameWindowsButton();
		browserWindowsPage.openBrowserWindowsForm();
		Assert.assertTrue(browserWindowsPage.isBrowserWindowsFormAppeared(), "Page with browser windows form is not opened");
		browserWindowsPage.clickOnNewTabButton();
		windowHandler.windowCheck();
		Assert.assertTrue(newTab.isNewTabWithSamplePageOpen(), "New tab with sample page was not opened");
		windowHandler.switchToMainWindow();
		Assert.assertTrue(browserWindowsPage.isBrowserWindowsFormAppeared(), "Page with browser windows form is not opened");
		browserWindowsPage.clickOnElementsButton();
		linksFormPage.openLinksForm();
		Assert.assertTrue(linksFormPage.isLinksFormAppeared(), "Page with Links form is not opened");
		linksFormPage.clickOnHomeButton();
		windowHandler.windowCheck();
		Assert.assertTrue(mainPage.isMainPageOpen(), "New tab with Main page was not opened");
		windowHandler.switchToMainWindow();
		Assert.assertTrue(linksFormPage.isLinksFormAppeared(), "Page with Links form is not opened");
	}		
}
