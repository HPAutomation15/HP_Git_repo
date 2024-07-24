package com.fb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fb.qa.base.TestBase;
import com.fb.qa.pages.HomePage;
import com.fb.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends TestBase{

	LoginPage LoginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		// following code call the parent class construction
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		// create loginpage object and call loginpage constructor
		LoginPage = new LoginPage();
	}
	
	@Test (priority = 1)
	public void loginpagetitletest()
	{
		String title = LoginPage.validateloginpagetitle();
		Assert.assertEquals(title, "Facebook - log in or sign up");
	}
	
	@Test(priority=2)
	public void fblogotest() {
		Boolean tf = LoginPage.validatefblogo();
		Assert.assertTrue(tf);
		
	}
	
	@Test(priority=3)
	public void logintest() {
	homePage = LoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
