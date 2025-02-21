package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name") 
	private WebElement userNameEdit;
	
	@FindBy(name="user_password") 
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton") 
	private WebElement submitButton;
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void loginToApp(String username, String password)
	{
		
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitButton.click();
	}
	
}
