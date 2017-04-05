package com.wbl.JanAutomationFramework.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	//dependency injection - HomePage is dependent on WebDriver object and we are injecting that dependency
	//using constructor
	WebDriver driver;
	
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public int navLinks(){
		List<WebElement> links = driver.findElements(By.cssSelector(".header-GlobalEyebrowNav-link"));
		//Getting actual value using webdriver automation.
		return links.size();
	}
	
	
	public String searchBox(){		
		driver.findElement(By.id("global-search-input")).sendKeys("laptop");
		driver.findElement(By.cssSelector(".header-GlobalSearch-submit.btn")).click();
		return driver.getTitle();
	}

	
	public SignInPage signInLink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'My Account')]")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(myAccountElement).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In"))).click();
		
		return new SignInPage(driver);
		
		
	}
	
	public String createAccountLink(){
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement myAccountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'My Account')]")));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(myAccountElement).perform();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Create an Account"))).click();
		
		return driver.getTitle();
		
		
	}
	

}
