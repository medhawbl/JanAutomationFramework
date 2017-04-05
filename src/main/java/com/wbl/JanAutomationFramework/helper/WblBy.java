package com.wbl.JanAutomationFramework.helper;


import java.util.Properties;

import org.openqa.selenium.By;

public class WblBy {
	static Properties prop;
	
	/*static{
	 prop= ConfigUtils.loadProperties("/locators/signInPage-locator.properties");
	}*/
	
	public static void loadProperties(){
		prop= ConfigUtils.loadProperties("locators/signInPage-locator.properties");
	}
	
	public static By getBy(String key){
		String value = prop.getProperty(key);
		By by = null;
		
		if(key.startsWith("name")){
			by = By.name(value);
		}else if(key.startsWith("id")){
			by =By.id(value);
		}else if(key.startsWith("class")){
			by =By.className(value);
		}else if(key.startsWith("css")){
			by = By.cssSelector(value);
		}else if(key.startsWith("xpath")){
			by = By.xpath(value);
		}else if(key.startsWith("link")){
			by = By.linkText(value);
		}else if(key.startsWith("plink")){
			by = By.partialLinkText(value);
		}else if(key.startsWith("tag")){
			by = By.tagName(value);
		}
		return by;
	}

}
