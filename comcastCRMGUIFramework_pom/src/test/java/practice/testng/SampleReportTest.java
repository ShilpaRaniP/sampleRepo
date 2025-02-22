package practice.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {
	public ExtentReports report;
	
	@BeforeSuite
	public void configBS()
	{

		//Spark Report Configuration
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);

		// Add environment information and create test
		report = new ExtentReports();
		report.attachReporter(spark); 
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("BROWSER", "CHROME-132");
		
	}
	
	@AfterSuite
	public void configAS()
	{
		report.flush();
	}
	
	@Test
	public void createContactTest()
	{		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		//take screenshot
		TakesScreenshot eDriver=(TakesScreenshot)driver;
		String filePath=eDriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("createContactTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
			test.addScreenCaptureFromBase64String(filePath,"Error File");
		}	
	}
	@Test
	public void createContactWithOrgTest()
	{		
		ExtentTest test=report.createTest("createContactWithOrgTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HDFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}	
	}
	
	@Test
	public void createContactWithPhoneNoTest()
	{		
		ExtentTest test=report.createTest("createContactWithPhoneNoTest");
		
		test.log(Status.INFO,"login to app");
		test.log(Status.INFO,"navigate to contact page");
		test.log(Status.INFO,"create contact");
		if("HDFC".equals("HFC")) {
			test.log(Status.PASS,"contact is created");
		}else {
			test.log(Status.FAIL,"contact is not created");
		}	
	}
	
}
