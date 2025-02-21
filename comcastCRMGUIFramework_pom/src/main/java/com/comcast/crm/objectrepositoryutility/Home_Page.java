package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	@FindBy(xpath = "//a[text()='Organizations']")
	private WebElement OrganizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement MyPreferencesButton;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
		
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getMyPreferencesButton() {
		return MyPreferencesButton;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public WebElement getOrganizationsLink() {
		return OrganizationsLink;
	}
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signOut(WebDriver driver)
	{
		MyPreferencesButton.click();
		Actions act = new Actions(driver);
		act.moveToElement(SignOutLink).click().perform();
	}
	
	
	
}
