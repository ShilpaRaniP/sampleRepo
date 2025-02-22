package com.comcast.crm.contacttest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;

import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class CreateContactTest 
{
	public static void main(String[] args) throws Exception 
	{
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
				
		String BROWSER=fLib.getDataFromPropertiesFile("browser");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
				
		String LastName=eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
				
		WebDriver driver=wLib.selectBrowser(BROWSER);
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		
		//login
		LoginPage lp=new LoginPage(driver);
		driver.get(URL);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//navigate to contacts module
		Home_Page hp=new Home_Page(driver);
		hp.getContactsLink().click();
		
		//click on create contact button
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactButton().click();
		
		//enter all the details and create new contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.getLastNameEdit().sendKeys(LastName);
		cncp.getSaveButton().click();
			
		//verify lastname in the header of the message
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String headerInfo=cip.getHeaderTextInfoRead().getText();
		jLib.ValidateIfContains(headerInfo, LastName);
				
		//verify Lastname
		String actLastName=cip.getLastNameRead().getText();
		jLib.ValidateIfEquals(actLastName, LastName);	
						
		//logout
		hp.getMyPreferencesButton().click();
		wLib.mouseMoveOnElementAndClick(driver, hp.getSignOutLink());
		Thread.sleep(1000);
		driver.quit();
	}
}
