package com.wbl.JanAutomationFramework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SerachDetailsPage {

	WebDriver driver;
	
	public SerachDetailsPage(WebDriver driver){
		this.driver=driver;
	}
	
	
	public String getDetailsTitle(){
		return driver.getTitle();
	}
	
	public String resultTitle(){
		WebElement elm = driver.findElement(By.xpath("//*[@class='prod-ProductTitle no-margin heading-a']/div"));
		return elm.getText();
	}
}
