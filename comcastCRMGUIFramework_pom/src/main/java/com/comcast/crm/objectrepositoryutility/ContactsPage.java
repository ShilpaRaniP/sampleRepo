package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath = "//img[@title='Create Contact...']/../../a")
	private WebElement CreateNewContactButton;
		
	public WebElement getCreateNewContactButton() {
		return CreateNewContactButton;
	}

	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
