package com.wbl.JanAutomationFramework.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
	static Properties prop ;
	
	public static Properties loadProperties(String fileName){
		prop = new Properties();
		try {
			prop.load(new FileInputStream(Constants.RESOURCES+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	public static String getValue(String key){
		return prop.getProperty(key);
	}

}
