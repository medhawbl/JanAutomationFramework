package com.wbl.JanAutomationFramework;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wbl.JanAutomationFramework.base.BaseTest;
import com.wbl.JanAutomationFramework.helper.ExcelHelper;
import com.wbl.JanAutomationFramework.page.HomePage;
import com.wbl.JanAutomationFramework.page.SignInPage;

public class SigninPageTest extends BaseTest{
	
	SignInPage sp;
	HomePage hm;
	
	@BeforeClass
	public void beforeClass(){
		 hm = new HomePage(driver);
		 //using homepage signin method to navigate to signin page
		 sp = hm.signInLink();
	}
	
	@DataProvider(name="signin")
	public Object[][] siginData(){
		Object[][] data = ExcelHelper.getExcelData("signin.xlsx", "logindata");
		return data;
	}
	
	@Test(dataProvider="signin")
	public void testSignIn(String uname,String pwd,String expected){
		System.out.println("expected value"+expected);
		String actual = sp.signInInvalid(uname,pwd);
		assertNotNull(actual);
		assertTrue(actual.contains(expected));
	}
	

}
