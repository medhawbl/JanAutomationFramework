package com.wbl.JanAutomationFramework.helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	
	public static WebElement explicitWaitForSingleElement(WebDriver driver, long timeInSecs, String key){
		WebDriverWait wait = new WebDriverWait(driver,timeInSecs);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(WblBy.getBy(key)));
	}
	
	public static void implicitWait(WebDriver driver, long timeInSecs){
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

}
