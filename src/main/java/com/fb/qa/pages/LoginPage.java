package com.fb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fb.qa.base.TestBase;

public class LoginPage extends TestBase{

	// Page Factory - Object Repository
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name= "pass")
	WebElement pass;
	
	@FindBy(name="login")
	WebElement loginbtn;
	
	// following xpath is manualy maid
	@FindBy(xpath = "//img[contains(@class, 'fb_logo _8ilh img')]")
	WebElement fblogo;
	
	// create constructor for page factory
	public LoginPage() {
	
	// this will initialize all the webelements/page objects that we created like email, password loginbtn etc	
		PageFactory.initElements(driver, this);
		
	}
	
	// actions
	
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validatefblogo() {
		return fblogo.isDisplayed();
		
	}
	
	public HomePage login(String eml, String pwd) {
		email.sendKeys(eml);
		pass.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
}
