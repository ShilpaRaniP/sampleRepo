package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SelectOrgForContactPage;

public class CreateContactTest_testng extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Exception {
		// read testScript data from excel file
		String LastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// navigate to contacts module
		Home_Page hp = new Home_Page(driver);
		hp.getContactsLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		// enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameEdit().sendKeys(LastName);
		cncp.getSaveButton().click();

		// verify lastname in the header of the message
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerInfo = cip.getHeaderTextInfoRead().getText();
		boolean state=headerInfo.contains(LastName);
		Assert.assertTrue(state);

		// verify Lastname
		String actLastName = cip.getLastNameRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, LastName);
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws Exception {
		String LastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// navigate to contacts module
		Home_Page hp = new Home_Page(driver);
		hp.getContactsLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		// enter all the details and create new org
		String startDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYMMDD(30);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.CreateNewContactWithDates(LastName, startDate, endDate);

		// verify start date
		ContactsInfoPage cip = new ContactsInfoPage(driver);

		String actStartDate = cip.getStartDateRead().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actStartDate, startDate );

		// verify end date
		String actEndDate = cip.getEndDateRead().getText();
		soft.assertEquals(actEndDate, endDate);
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void createContactWithOrg() throws Exception {
		String orgName = eLib.getDataFromExcel("org1", 1, 2) + jLib.getRandomNumber();
		String LastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// navigate to organizations module
		Home_Page hp = new Home_Page(driver);
		hp.getOrganizationsLink().click();

		// click on create organization button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgButton().click();

		// enter all the details and create new org
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.getOrgNameEdit().sendKeys(orgName);
		cnop.getSaveButton().click();

		// verify organization name in the header of the message
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String headerInfo = oip.getHeaderTextInfoRead().getText();
		boolean status=headerInfo.contains(orgName);
		SoftAssert soft=new SoftAssert();
		Assert.assertTrue(status);
		
		// verify orgName
		String actOrgName = oip.getOrganizationNameRead().getText();
		soft.assertEquals(actOrgName, orgName);

		// navigate to contacts module
		hp.getContactsLink().click();

		// click on create contact button
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateNewContactButton().click();

		// enter all the details and create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.getLastNameEdit().sendKeys(LastName);
		cncp.getSelectOrgButton().click();

		// switch to child window
		wLib.switchToWindowBasedOnUrl(driver, "module=Accounts");
		SelectOrgForContactPage socp = new SelectOrgForContactPage(driver);
		socp.getSearchTextEdit().sendKeys(orgName);
		socp.getSearchButton().click();
		driver.findElement(By.xpath("//a[.='" + orgName + "']")).click();

		// switch back to parent window
		wLib.switchToWindowBasedOnUrl(driver, "module=Contacts");
		cncp.getSaveButton().click();

		// verify header name in the header of the message
		ContactsInfoPage cip = new ContactsInfoPage(driver);
		String headerInfo1 = cip.getHeaderTextInfoRead().getText();
		boolean status1=headerInfo1.contains(LastName);
		Assert.assertTrue(status1);

		// verify orgname
		String actOrgName1 = cip.getOrganizationRead().getText();
		boolean st=actOrgName1.trim().equals(orgName);
		soft.assertTrue(st);
		soft.assertAll();
	}
}
