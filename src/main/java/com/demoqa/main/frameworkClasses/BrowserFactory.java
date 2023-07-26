package com.demoqa.main.frameworkClasses;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import com.demoqa.main.pageObjectClasses.AlertsPage;
import com.demoqa.main.utillityClasses.ConfigManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	private static ChromeOptions chromeOptions;
	private static FirefoxOptions firefoxOptions;
	private static String browserName;
	private static List<String> chromeArgList;
	private static String firefoxArgs;
    private static final Logger log = LogManager.getLogger(AlertsPage.class); 

	static {
		chromeOptions = new ChromeOptions();
		firefoxOptions = new FirefoxOptions();
		browserName = ConfigManager.getBrowsername();
		chromeArgList = ConfigManager.getChromeArgs();
		firefoxArgs = ConfigManager.getFirefoxArgs();
		
		switch (browserName) {
		case "chrome":
			chromeOptions.addArguments(chromeArgList);
			break;
		case "firefox":
			firefoxOptions.addArguments(firefoxArgs);
		default:
			System.out.println("Invalid Browser Name");				
		} 
	}
	public static ChromeOptions getchromeOptions() {
		return chromeOptions;
	}
	public static FirefoxOptions getfirefoxOptions() {
		return firefoxOptions;
	}
	public static WebDriver getDriver() {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver(chromeOptions);
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver(firefoxOptions);		
		default:
			log.info("Invalid browser name");
			return null;
		}
	}
}
