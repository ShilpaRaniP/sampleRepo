package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	
	
	@FindBy(xpath = "//img[@title='Create Organization...']/../../a")
	private WebElement CreateNewOrgButton;
		
	public WebElement getCreateNewOrgButton() {
		return CreateNewOrgButton;
	}

	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
}
