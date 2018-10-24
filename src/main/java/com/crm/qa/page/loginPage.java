package com.crm.qa.page;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;
import com.crm.qa.util.testUtil;

public class loginPage extends testBase{
	
	testUtil util = new testUtil();
	
	//Page Factory - Object Repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginButton;
	
	@FindBy(className="img-responsive")
	WebElement crmLogo;
	
	@FindBy(linkText="https://www.freecrm.com/register/")
	WebElement SignUp;
	
	
	// Initialize Objects
	public loginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	
	public boolean validateCRMLogoImage() {
		
		return crmLogo.isDisplayed();
		
	}
	
	public homePage login(String un, String pwd) throws IOException {
		
			
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		util.JSClick(driver,loginButton);
		return new homePage();
	}

}
