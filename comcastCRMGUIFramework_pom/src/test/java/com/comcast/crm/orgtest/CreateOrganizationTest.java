package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest 
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
		
		//verify organization name in the header of the message and verify orgname
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String headerInfo=oif.getHeaderTextInfoRead().getText();
		String actOrgName=oif.getOrganizationNameRead().getText();
		jLib.ValidateIfContains(headerInfo, orgName);					
		jLib.ValidateIfEquals(actOrgName, orgName);
		
		//logout
		hp.signOut(driver);
		
		Thread.sleep(1000);
		driver.quit();
	}
}
