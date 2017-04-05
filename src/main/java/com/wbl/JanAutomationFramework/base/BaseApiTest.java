package com.wbl.JanAutomationFramework.base;


import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;

import com.wbl.JanAutomationFramework.helper.ConfigUtils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseApiTest {
	
	String consumerKey;
	String consumerSecret;
	String token;
	String tokenSecret;
	protected RequestSpecification rs;
	
	@BeforeTest
	public void beforeTest(){	
		ConfigUtils.loadProperties("config-api.properties");
		RestAssured.baseURI=ConfigUtils.getValue("baseURI");
		RestAssured.basePath=ConfigUtils.getValue("basePath");
		consumerKey=ConfigUtils.getValue("consumerKey");
		consumerSecret=ConfigUtils.getValue("consumerSecret");
		token=ConfigUtils.getValue("token");
		tokenSecret=ConfigUtils.getValue("tokenSecret");
		rs=given().auth().oauth(consumerKey, consumerSecret, token, tokenSecret);
	}
	

}