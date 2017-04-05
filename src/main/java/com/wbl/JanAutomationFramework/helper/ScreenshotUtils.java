package com.wbl.JanAutomationFramework.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
	
	public static void takeScreenShot(String fileName, WebDriver driver){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(Constants.PATH+"/screenshots/"+fileName+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
