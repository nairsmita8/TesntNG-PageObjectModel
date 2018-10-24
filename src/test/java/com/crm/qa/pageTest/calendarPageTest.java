package com.crm.qa.pageTest;

import java.io.IOException;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.page.calendarPage;
import com.crm.qa.page.homePage;
import com.crm.qa.page.loginPage;
import com.crm.qa.util.testUtil;

public class calendarPageTest extends testBase {

	loginPage loginPageObject;
	homePage homePageObject;
	calendarPage calendarPageObject;
	testUtil util;

	public calendarPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setUp() throws IOException {

		initialize();
		util = new testUtil();
		loginPageObject = new loginPage();
		homePageObject = loginPageObject.login(prop.getProperty("username"), prop.getProperty("password"));
		util.switchFrame();
		calendarPageObject = homePageObject.clickCalendarPage();

	}

	@Test(priority = 1)
	public void verifyCalenderWidgetTest() {

		boolean flag = calendarPageObject.verifyCalenderWidget();
		Assert.assertTrue(flag, "Calnder Widget is not displayed in the Calender page.");
	}

	@Test(priority = 2)
	public void verifyDisplayedCurrentDateTest() {

		Calendar today = Calendar.getInstance();

		int month = today.get(Calendar.MONTH);
		String[] monthArray = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String monthName = monthArray[month];

		int year = today.get(Calendar.YEAR);

		int day = today.get(Calendar.DATE);

		String expectedDate = monthName + " " + day + "Today " + year;

		Assert.assertEquals(calendarPageObject.verifyDisplayedCurrentDate(), expectedDate);

	}

	@AfterMethod

	public void tearDown() {

		driver.quit();
	}

}
