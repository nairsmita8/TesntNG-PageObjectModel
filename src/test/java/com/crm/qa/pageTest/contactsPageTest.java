package com.crm.qa.pageTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.page.contactsPage;
import com.crm.qa.page.homePage;
import com.crm.qa.page.loginPage;
import com.crm.qa.util.testUtil;

public class contactsPageTest extends testBase {

	loginPage loginPageObject;
	homePage homePageObject;
	contactsPage contactsPageObject;
	testUtil util;
	
	String sheetName = "NewContacts";

	public contactsPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initialize();
		loginPageObject = new loginPage();
		contactsPageObject = new contactsPage();
		util = new testUtil();
		homePageObject = loginPageObject.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchFrame();
		contactsPageObject = homePageObject.clickNewContact();
		
	}
	
	@Test(priority=1)
	public void VerifyNewContactsLabelTest() {
		
		boolean flag = contactsPageObject.VerifyNewContactsLabel();
		Assert.assertTrue(flag);
		
	}
	
	@DataProvider
	public Object[][] getContactsTestData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		Object[][] data = util.getExcelTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, dataProvider="getContactsTestData")
	public void addNewContactsTest(String titleData, String FirstNameData, String surnameData, String companyData, String CompanyPositionData) {
		
		contactsPageObject.addNewContacts(titleData, FirstNameData, surnameData, companyData, CompanyPositionData);
	}
	
	@Test(priority=3, dataProvider="getContactsTestData")
	public void verifySavedContactTest(String titleData, String FirstNameData, String surnameData, String companyData, String CompanyPositionData) throws IOException {
		
		homePageObject.clickContactPage();
		String name = FirstNameData+" "+surnameData;
		System.out.println(name);
		boolean flag = contactsPageObject.verifySavedContacts(name);
		Assert.assertEquals(flag, true,"Name "+name+" not found.");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
}
