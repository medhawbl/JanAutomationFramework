package com.wbl.JanAutomationFramework;

import static org.testng.Assert.assertEquals;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.JanAutomationFramework.base.BaseTest;
import com.wbl.JanAutomationFramework.helper.ExcelHelper;
import com.wbl.JanAutomationFramework.page.HomePage;
import com.wbl.JanAutomationFramework.page.SignInPage;

public class HomePageTest extends BaseTest{
	
	HomePage hm;
	static Logger log = LogManager.getLogger(ExcelHelper.class);
	
	@BeforeClass
	public void beforeClass(){
		 hm = new HomePage(driver);
	}
/*	
	@Test(priority=0)
	public void testNavLinks(){
		assertEquals(5, hm.navLinks());
	}*/
	
	@Test(priority=1)
	public void testSignInLink(){
		SignInPage sp = hm.signInLink();
		assertEquals("Lin", sp.getSignInTitle());
	}
	
	/*@Test
	public void testSearchBox(){
		assertEquals("laptop - Walmart.com", hm.searchBox());
	}*/
	
	

}
