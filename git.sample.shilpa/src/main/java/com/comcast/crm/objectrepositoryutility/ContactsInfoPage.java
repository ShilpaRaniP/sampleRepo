package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage {

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderTextInfoRead;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement LastNameRead;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement StartDateRead;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement EndDateRead;
	
	@FindBy(id = "mouseArea_Organization Name")
	private WebElement OrganizationRead;
	
	public WebElement getOrganizationRead() {
		return OrganizationRead;
	}


	public WebElement getLastNameRead() {
		return LastNameRead;
	}


	public WebElement getStartDateRead() {
		return StartDateRead;
	}


	public WebElement getEndDateRead() {
		return EndDateRead;
	}


	public WebElement getHeaderTextInfoRead() {
		return HeaderTextInfoRead;
	}

		
	public ContactsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	
}
