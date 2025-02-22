package com.comcast.crm.orgtest;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgWithIndustryDD {

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
				
		String orgName=eLib.getDataFromExcel("org1",4,2) + jLib.getRandomNumber();
		String ind=eLib.getDataFromExcel("org1",4,3);
		String type=eLib.getDataFromExcel("org1",4,4);
		
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
		cnop.CreateNewOrgWithIndustryAndType(orgName, ind, type);		
		
		//verify industry 
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String actInd=oif.getIndustryNameRead().getText();
		jLib.ValidateIfEquals(actInd, ind);		
		
		//verify type
		String actType=oif.getTypeNameRead().getText();
		jLib.ValidateIfEquals(actType, type);
				
		//logout
		hp.signOut(driver);
		
		Thread.sleep(1000);
		driver.quit();
	}
}
