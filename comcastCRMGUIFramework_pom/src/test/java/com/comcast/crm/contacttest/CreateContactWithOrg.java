package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SelectOrgForContactPage;

public class CreateContactWithOrg 
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
		
		String orgName=eLib.getDataFromExcel("org1", 1, 2) + jLib.getRandomNumber();		
		String LastName=eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();
				
		WebDriver driver=wLib.selectBrowser(BROWSER);
		wLib.maximizeWindow(driver);
		wLib.waitForPageToLoad(driver);
		
		//login
		LoginPage lp=new LoginPage(driver);
		driver.get(URL);
		lp.loginToApp(USERNAME, PASSWORD);
		
		//navigate to organizations module
		Home_Page hp=new Home_Page(driver);
		hp.getOrganizationsLink().click();
		
		//click on create organization button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();
		
		//enter all the details and create new org
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveButton().click();
				
		//verify organization name in the header of the message
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String headerInfo=oip.getHeaderTextInfoRead().getText();
		jLib.ValidateIfContains(headerInfo, orgName);
				
		//verify orgName
		String actOrgName=oip.getOrganizationNameRead().getText();
		jLib.ValidateIfEquals(actOrgName, orgName);
		
		//navigate to contacts module
		hp.getContactsLink().click();
					
		//click on create contact button
		ContactsPage cp=new ContactsPage(driver);
		cp.getCreateNewContactButton().click();
		
		//enter all the details and create new contact
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.getLastNameEdit().sendKeys(LastName);
		cncp.getSelectOrgButton().click();
				
		//switch to child window
		wLib.switchToWindowBasedOnUrl(driver, "module=Accounts");
		SelectOrgForContactPage socp=new SelectOrgForContactPage(driver);	
		socp.getSearchTextEdit().sendKeys(orgName);
		socp.getSearchButton().click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		
		//switch back to parent window
		wLib.switchToWindowBasedOnUrl(driver, "module=Contacts");
		cncp.getSaveButton().click();
		
		//verify header name in the header of the message
		ContactsInfoPage cip=new ContactsInfoPage(driver);
		String headerInfo1=cip.getHeaderTextInfoRead().getText();
		jLib.ValidateIfContains(headerInfo1, LastName);
				
		//verify orgname
		String actOrgName1=cip.getOrganizationRead().getText();
		jLib.ValidateIfEquals(actOrgName1, orgName);		
		
		//logout
		hp.signOut(driver);
		Thread.sleep(1000);
		driver.quit();
	}
}
