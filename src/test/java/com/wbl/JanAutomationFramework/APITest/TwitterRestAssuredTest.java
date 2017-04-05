package com.wbl.JanAutomationFramework.APITest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.JanAutomationFramework.base.BaseApiTest;
import com.wbl.JanAutomationFramework.helper.ExcelHelper;
import com.wbl.JanAutomationFramework.pojo.TwitterAccount;

import io.restassured.response.Response;

public class TwitterRestAssuredTest extends BaseApiTest{

	Response response;
	

	@DataProvider(name="post")
	public Object[][] siginData(){
		Object[][] data = ExcelHelper.getExcelData("apiData/api-testdata.xlsx", "accountApi");
		return data;
	}
		
	@Test(priority=0)
	public void testGetBasicAccountSettings(){
		response = rs.get("account/settings.json");
		System.out.println(response.getHeader("status"));
		System.out.println(response.getStatusLine());
		System.out.println("response::"+response.getBody().prettyPrint());
		assertEquals(response.getContentType(),"application/json;charset=utf-8");
		response.then().statusCode(200);		
	}
	
	@Test(priority=0,dependsOnMethods={"testGetBasicAccountSettings"})
	public void testPayloadAccountSettings(){
		assertEquals(response.path("screen_name"),"Medha_7886");	
		assertEquals(response.path("sleep_time.enabled"),true);	
		//List<String> actualLangs=response.path("languages");
	}
	
	
	@Test(priority=1,dataProvider="post")
	public void testPostAccountSettings(String lang,String sleepTimeEnabled,String screenName){
		response = rs.post("account/settings.json?lang="+lang+"&sleep_time_enabled="+sleepTimeEnabled);
		System.out.println("response::"+response.getBody().prettyPrint());
		assertEquals(response.path("screen_name"),screenName);	
		assertNotNull(response.path("sleep_time.enabled"));	
		assertEquals(response.path("language"),lang);	
	}
	
	@Test(priority=1,dataProvider="post")
	public void testPostAccountSettings2(String lang,String sleepTimeEnabled,String screenName){
		//set req body for post using pojo
		Map<String,String> reqData = new HashMap<String,String>();
		reqData.put("lang", lang);
		reqData.put("sleep_time_enabled", sleepTimeEnabled);
		
		//set req body for post using pojo
		TwitterAccount tc = new TwitterAccount();
		tc.setLang(lang);
		tc.setSleepTime(sleepTimeEnabled);
		
		response = rs.body(reqData).post("account/settings.json");
		System.out.println("response::"+response.getBody().prettyPrint());
		assertEquals(response.path("screen_name"),screenName);	
		assertNotNull(response.path("sleep_time.enabled"));	
		assertEquals(response.path("language"),lang);	
	}
}
