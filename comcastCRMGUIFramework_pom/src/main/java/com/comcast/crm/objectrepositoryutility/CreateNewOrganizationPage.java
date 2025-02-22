package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewOrganizationPage {

	@FindBy(name="accountname")
	private WebElement OrgNameEdit;
	
	@FindBy(xpath="//input[@accesskey='S']")
	private WebElement SaveButton;
	
	@FindBy(name="industry")
	private WebElement IndustryDD;
	
	@FindBy(name="accounttype")
	private WebElement TypeDD;
	
	@FindBy(id="phone")
	private WebElement PhoneNoEdit;
	
	public WebElement getPhoneNoEdit() {
		return PhoneNoEdit;
	}

	public WebElement getIndustryDD() {
		return IndustryDD;
	}

	public WebElement getTypeDD() {
		return TypeDD;
	}

	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public WebElement getOrgNameEdit() {
		return OrgNameEdit;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	public void CreateNewOrgWithIndustryAndType(String orgName, String ind, String type) {
		WebDriverUtility wLib=new WebDriverUtility();
		getOrgNameEdit().sendKeys(orgName);
		wLib.select(getIndustryDD(), ind);				
		wLib.select(getTypeDD(), type);
		getSaveButton().click();
	}
	
	public void CreateNewOrgWithPhoneNo(String orgName, String PhNo) {
		getOrgNameEdit().sendKeys(orgName);
		getPhoneNoEdit().sendKeys(PhNo);
		getSaveButton().click();
	}
	

}
