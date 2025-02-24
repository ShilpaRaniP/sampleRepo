package com.comcast.crm.orgtest;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListImpClass;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;



public class CreateOrgTest_testng extends BaseClass
{
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Exception
	{
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		//read testScript data from excel file
		String orgName=eLib.getDataFromExcel("org1", 1, 2) + jLib.getRandomNumber();
				
		//navigate to organizations module
		UtilityClassObject.getTest().log(Status.INFO, "navigate to organizations page");
		Home_Page hp=new Home_Page(driver);
		hp.getOrganizationsLink().click();
			
		//click on create organization button
		UtilityClassObject.getTest().log(Status.INFO, "navigate to create organizations page");
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();
						
		//enter all the details and create new org
		UtilityClassObject.getTest().log(Status.INFO, "create a org");
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveButton().click();
		
		
		UtilityClassObject.getTest().log(Status.INFO, "====>created new org<====");
		//verify organization name in the header of the message and verify orgname
		OrganizationInfoPage oif=new OrganizationInfoPage(driver);
		String headerInfo=oif.getHeaderTextInfoRead().getText();
		boolean status=headerInfo.contains(orgName);
		Assert.assertTrue(status);
		
		String actOrgName=oif.getOrganizationNameRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actOrgName, orgName);
		soft.assertAll();
	}
	
	@Test(groups = {"regressionTest", "smokeTest"})
	public void createOrgWithIndustryTest() throws Exception
	{				
		String orgName=eLib.getDataFromExcel("org1",4,2) + jLib.getRandomNumber();
		String ind=eLib.getDataFromExcel("org1",4,3);
		String type=eLib.getDataFromExcel("org1",4,4);
		
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
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actInd, ind);	
		
		//verify type
		String actType=oif.getTypeNameRead().getText();
		soft.assertEquals(actType, type);
		soft.assertAll();
	}
	
	@Test(groups = "regressionTest")
	public void createOrgWithPhoneNoTest() throws Exception
	{				
		String orgName=eLib.getDataFromExcel("org1", 7, 2) + jLib.getRandomNumber();
		String PhoneNo=eLib.getDataFromExcel("org1", 7, 3);
		
		//navigate to organizations module
		Home_Page hp=new Home_Page(driver);
		hp.getOrganizationsLink().click();
		
		//click on create organization button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();
		
		//enter all the details and create new org
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.CreateNewOrgWithPhoneNo(orgName, PhoneNo);
						
		//verify phone No
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actPhNo=oip.getPhoneNoRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actPhNo, PhoneNo);	
	}
}
