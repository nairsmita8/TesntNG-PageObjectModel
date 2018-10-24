package com.crm.qa.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.testBase;

public class calendarPage extends testBase {

	@FindBy(xpath = "//table[@class='crmcalendar']")
	WebElement calendarTable;

	public calendarPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyCalenderWidget() {

		return calendarTable.isDisplayed();

	}

	public String verifyDisplayedCurrentDate() {

		Select monthSelect = new Select(driver.findElement(By.xpath("//select[@name='slctMonth']")));
		WebElement monthElement = monthSelect.getFirstSelectedOption();
		String month = monthElement.getText();

		Select yearSelect = new Select(driver.findElement(By.xpath("//select[@name='slctYear']")));
		WebElement yearElement = yearSelect.getFirstSelectedOption();
		String year = yearElement.getText();

		String day = driver.findElement(By.xpath("//td[@class='calendarselected']")).getText().replaceAll("\\s", "");

		return (month + " " + day + " " + year);

	}

}
