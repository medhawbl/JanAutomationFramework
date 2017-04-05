package com.wbl.JanAutomationFramework.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.wbl.JanAutomationFramework.helper.ConfigUtils;
import com.wbl.JanAutomationFramework.helper.ScreenshotUtils;
import com.wbl.JanAutomationFramework.helper.WblBy;
import com.wbl.JanAutomationFramework.helper.WebUIDriver;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeTest
	public void beforeTest(){
		WblBy.loadProperties();
		ConfigUtils.loadProperties("config.properties");
		driver=WebUIDriver.getDriver(ConfigUtils.getValue("browser"));
		driver.get(ConfigUtils.getValue("url"));
	}
	
	@AfterMethod
	public void afterMethod(ITestResult rs){
		if(ITestResult.FAILURE==rs.getStatus()){
			ScreenshotUtils.takeScreenShot(rs.getName(), driver);
		}
	}

	@AfterTest
	public void afterTest(){
		driver.close();
	}
}
