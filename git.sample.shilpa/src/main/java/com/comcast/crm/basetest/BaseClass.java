package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Home_Page;
import com.comcast.crm.objectrepositoryutility.LoginPage;


public class BaseClass {

	public DataBaseUtility dbLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver=null;
	
	
	@BeforeSuite(alwaysRun = true)
	public void configBS()
	{
		System.out.println("=====connect to DB , Report Config=====");
		System.out.println("======connected======");
		dbLib.getDBConnection();
	}
	
	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC(String browser) throws IOException
	{
		System.out.println("=====Launch the BROWSER=====");
		String BROWSER = browser;
				//fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}	
		else if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
		else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		wLib.maximizeWindow(driver);
	}
		
	@BeforeMethod(alwaysRun = true)
	public void configBM() throws IOException
	{
		System.out.println("=====lOGIN=====");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
	}
	
	@AfterMethod(alwaysRun = true)
	public void configAM()
	{
		System.out.println("=====LOGOUT=====");
		Home_Page hp=new Home_Page(driver);
		hp.signOut(driver);
		System.out.println("=====LOGGED OUT=====");
	}
		
	@AfterClass(alwaysRun = true)
	public void configAC()
	{
		System.out.println("=====close the BROWSER=====");
		driver.quit();
		System.out.println("After class updated =====$$$$");
	}
	
	@AfterSuite(alwaysRun = true)
	public void configAS()
	{
		System.out.println("=====close DB , Report BackUP=====");
		dbLib.closeDBConnection();
	}
	
}
