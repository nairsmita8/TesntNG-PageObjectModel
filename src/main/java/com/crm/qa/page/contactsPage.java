package com.crm.qa.page;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.testBase;
import com.crm.qa.util.testUtil;

public class contactsPage extends testBase {

	@FindBy(xpath = "//legend[text()='Contact Information']")
	WebElement NewConatctsLabel;

	@FindBy(name = "title")
	WebElement title;

	@FindBy(name = "first_name")
	WebElement FirstName;

	@FindBy(name = "surname")
	WebElement surname;

	@FindBy(name = "client_lookup")
	WebElement company;

	@FindBy(name = "company_position")
	WebElement CompanyPosition;

	@FindBy(xpath = "//td[@colspan='2']//input[@value='Save']")
	WebElement SaveButton;

	public contactsPage() throws IOException {

		PageFactory.initElements(driver, this);
	}

	public boolean VerifyNewContactsLabel() {

		return NewConatctsLabel.isDisplayed();
	}

	public void addNewContacts(String titleData, String FirstNameData, String surnameData, String companyData,
			String CompanyPositionData) {

		Select select = new Select(title);
		select.selectByValue(titleData);

		FirstName.sendKeys(FirstNameData);

		surname.sendKeys(surnameData);

		company.sendKeys(companyData);

		CompanyPosition.sendKeys(CompanyPositionData);

		SaveButton.click();
	}

	public boolean verifySavedContacts(String name) {
		List<WebElement> page = driver.findElements(By.xpath("//div[@class='pagination']//a"));
		int totalPage = (page.size() / 2) + 1;
		boolean flag = false;
		for (int j = 2; j <= totalPage; j++) {
			
			List<WebElement> list = driver.findElements(By.xpath("//a[@context='contact']"));
			for (int i = 0; i < list.size(); i++) {
				
				if(list.get(i).getText().equals(name)) {
					
					flag = true;
					break;
				}

			}
			
			if(flag = true) {
				
				break;
			}
			
			driver.findElement(By.xpath("//div[@class='pagination']//a[text()='"+j+"'][1]")).click();
		}
		
		return flag;

	}

}
