package com.wbl.JanAutomationFramework.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

//Factory pattern
public class WebUIDriver {

	public static WebDriver getDriver(String browserName) {
		WebDriver driver = null;

		switch (browserName.trim().toLowerCase()) {
		case "firefox":
			System.setProperty("webdriver.firefox.driver", Constants.RESOURCES + "/drivers/firefoxdriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.RESOURCES + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "safari":
			System.setProperty("webdriver.safari.driver", Constants.RESOURCES + "/drivers/safaridriver.exe");
			driver = new SafariDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", Constants.RESOURCES + "/drivers/internetexplorerdriver.exe");
			driver = new InternetExplorerDriver();
			break;

		case "htmlunit":
			driver = new HtmlUnitDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", Constants.RESOURCES + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}

		return driver;
	}

}
