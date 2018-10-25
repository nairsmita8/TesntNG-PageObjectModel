package com.crm.qa.pageTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.page.calendarPage;
import com.crm.qa.page.casePage;
import com.crm.qa.page.companyPage;
import com.crm.qa.page.contactsPage;
import com.crm.qa.page.dealsPage;
import com.crm.qa.page.homePage;
import com.crm.qa.page.loginPage;
import com.crm.qa.page.tasksPage;
import com.crm.qa.util.testUtil;

public class homePageTest extends testBase {

	loginPage loginPageObject;
	homePage homePageObject;
	calendarPage calendarPageObject;
	contactsPage contactsPageObject;
	dealsPage dealsPageObject;
	tasksPage tasksPageObject;
	casePage casePageObject;
	companyPage companyPageObject;
	
	testUtil util;

	public homePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException {

		initialize();
		util = new testUtil();
		loginPageObject = new loginPage();
		calendarPageObject = new calendarPage();
		companyPageObject = new companyPage();
		contactsPageObject = new contactsPage();
		dealsPageObject = new dealsPage();
		tasksPageObject = new tasksPage();
		casePageObject = new casePage();
		homePageObject = loginPageObject.login(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		
		String homePageTitle = homePageObject.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO");
		
	}
	
	@Test(priority=2)
	public void verifyLoginUserTest() {
		
		util.switchFrame();
		boolean name = homePageObject.verifyLoginUser(prop.getProperty("user"));
		Assert.assertTrue(name, "User "+name+" not found in home page screen.");
		
	}
	
	@Test(priority=3)
	public void checkBrokenlinksTest() throws MalformedURLException, IOException {
		
		homePageObject.checkBrokenlinks();
		
	}
	
	@Test
	public void clickCalendarPageTest() throws IOException {
		
		util.switchFrame();
		calendarPageObject = homePageObject.clickCalendarPage();
	}
	
	@Test
	public void clickCompanyPageTest() throws IOException {
		
		util.switchFrame();
		companyPageObject = homePageObject.clickCompanyPage();
	}
	
	@Test
	public void clickContactPagTest() throws IOException {
		
		util.switchFrame();
		contactsPageObject = homePageObject.clickContactPage();
	}
	
	@Test
	public void clickDealsPageTest() {
		
		util.switchFrame();
		dealsPageObject = homePageObject.clickDealsPage();
	}
	
	@Test
	public void clickTasksPageTest() {
		
		util.switchFrame();
		tasksPageObject = homePageObject.clickTasksPage();
	}
	
	@Test
	public void clickCasePageTest() {
		
		util.switchFrame();
		casePageObject = homePageObject.clickCasePage();
	}
	
	

	@AfterMethod
	public void tearDown() {

		driver.quit();

	}
}
