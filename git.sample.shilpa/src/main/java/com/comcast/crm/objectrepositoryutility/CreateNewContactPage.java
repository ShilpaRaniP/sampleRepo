package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateNewContactPage {
	
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement SelectOrgButton;
	
	@FindBy(name = "lastname")
	private WebElement LastNameEdit;

	public WebElement getSelectOrgButton() {
		return SelectOrgButton;
	}
	@FindBy(xpath = "//input[@accesskey='S']")
	private WebElement SaveButton;
	
	@FindBy(name = "support_start_date")
	private WebElement StartDateEdit;
	
	@FindBy(name = "support_end_date")
	private WebElement EndDateEdit;

	public WebElement getLastNameEdit() {
		return LastNameEdit;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public WebElement getStartDateEdit() {
		return StartDateEdit;
	}

	public WebElement getEndDateEdit() {
		return EndDateEdit;
	}
	
	public void CreateNewContactWithDates(String LastName, String startDate, String endDate) {
		
		
		getLastNameEdit().sendKeys(LastName);
		getStartDateEdit().clear();
		getStartDateEdit().sendKeys(startDate);
		getEndDateEdit().clear();
		getEndDateEdit().sendKeys(endDate);
		getSaveButton().click();
				
	}

}
