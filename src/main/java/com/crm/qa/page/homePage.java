package com.crm.qa.page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;

public class homePage extends testBase {

	@FindBy(xpath = "//a[@title='Calendar']")
	WebElement CalenderMenu;

	@FindBy(xpath = "//a[@title='Companies']")
	WebElement CompanyMenu;

	@FindBy(xpath = "//a[@title='Contacts']")
	WebElement ContactMenu;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement NewContact;

	@FindBy(xpath = "//a[@title='Deals']")
	WebElement DealMenu;

	@FindBy(xpath = "//a[@title='Tasks']")
	WebElement TaskMenu;

	@FindBy(xpath = "//a[@title='Cases']")
	WebElement CaseMenu;

	public homePage() throws IOException {

		PageFactory.initElements(driver, this);

	}

	public String verifyHomePageTitle() {

		return driver.getTitle();
	}

	public boolean verifyLoginUser(String name) {

		return driver.findElement(By.xpath("//td[contains(text(),'User: " + name + "')]")).isDisplayed();
	}

	public calendarPage clickCalendarPage() throws IOException {

		CalenderMenu.click();
		return new calendarPage();

	}

	public companyPage clickCompanyPage() throws IOException {

		CompanyMenu.click();
		return new companyPage();

	}

	public contactsPage clickContactPage() throws IOException {

		ContactMenu.click();
		return new contactsPage();

	}
	
	public contactsPage clickNewContact() throws IOException {

		Actions action = new Actions(driver);
		action.moveToElement(ContactMenu).build().perform();
		NewContact.click();
		return new contactsPage();
		
	}

	public dealsPage clickDealsPage() {

		DealMenu.click();
		return new dealsPage();

	}

	public tasksPage clickTasksPage() {

		TaskMenu.click();
		return new tasksPage();

	}

	public casePage clickCasePage() {

		CaseMenu.click();
		return new casePage();

	}

}
