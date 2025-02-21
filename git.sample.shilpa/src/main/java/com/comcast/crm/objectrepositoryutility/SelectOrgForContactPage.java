package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrgForContactPage {
	
	@FindBy(name = "search_text")
	private WebElement SearchTextEdit;
	
	@FindBy(name="search")
	private WebElement SearchButton;
	
	public WebElement getSearchTextEdit() {
		return SearchTextEdit;
	}

	public WebElement getSearchButton() {
		return SearchButton;
	}

	public SelectOrgForContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
