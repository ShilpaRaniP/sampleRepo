package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement HeaderTextInfoRead;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrganizationNameRead;
	
	@FindBy(id = "dtlview_Industry")
	private WebElement IndustryNameRead;
	
	@FindBy(id = "dtlview_Type")
	private WebElement TypeNameRead;
	
	
	@FindBy(id="dtlview_Phone")
	private WebElement PhoneNoRead;
	
	public WebElement getPhoneNoRead() {
		return PhoneNoRead;
	}

	public WebElement getHeaderTextInfoRead() {
		return HeaderTextInfoRead;
	}

	public WebElement getOrganizationNameRead() {
		return OrganizationNameRead;
	}
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getIndustryNameRead() {
		return IndustryNameRead;
	}

	public WebElement getTypeNameRead() {
		return TypeNameRead;
	}
	
}
