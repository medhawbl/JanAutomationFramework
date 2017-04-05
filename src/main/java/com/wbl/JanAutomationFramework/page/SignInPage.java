package com.wbl.JanAutomationFramework.page;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.wbl.JanAutomationFramework.helper.WaitUtils;
import com.wbl.JanAutomationFramework.helper.WblBy;

public class SignInPage {
	
	WebDriver driver;
	
	public SignInPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getSignInTitle(){
		return driver.getTitle();
	}

	public String signInInvalid(String uname,String pwd) throws NoSuchElementException{
		WebElement elm = WaitUtils.explicitWaitForSingleElement(driver, 10, "name-email");
		elm.clear();
		elm.sendKeys(uname);
		elm=driver.findElement(WblBy.getBy("name-pwd"));
		elm.clear();
		elm.sendKeys(pwd);
		driver.findElement(WblBy.getBy("xpath-signinBtn")).click();
		return driver.findElement(WblBy.getBy("xpath-alertmsg")).getText();
	}
	
	public String signInValid(){
		driver.findElement(WblBy.getBy("name-email")).sendKeys("a@a.com");
		driver.findElement(WblBy.getBy("name-pwd")).sendKeys("test123");
		driver.findElement(WblBy.getBy("xpath-signinBtn")).click();
		return driver.getTitle();
	}

}
