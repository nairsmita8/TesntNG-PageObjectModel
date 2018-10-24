package com.crm.qa.pageTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.page.homePage;
import com.crm.qa.page.loginPage;

public class loginPageTest extends testBase {

	loginPage loginPageObject;
	homePage homePageObject;

	public loginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {

		initialize();
		loginPageObject = new loginPage();
	}

	@Test(priority=1)
	public void validateLoginPageTitleTest() {

		String loginPageTitle = loginPageObject.validateLoginPageTitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service", loginPageTitle);
	}

	@Test(priority=2)
	public void validateCRMLogoImageTest() {

		boolean flag = loginPageObject.validateCRMLogoImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest() throws IOException {

		String un = prop.getProperty("username");
		String pwd = prop.getProperty("password");
		homePageObject = loginPageObject.login(un, pwd);

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
