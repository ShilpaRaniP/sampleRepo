package practice.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelExecutionWithoutSuiteXML {

	
	@Test(invocationCount = 4, threadPoolSize = 4)
	public void createInvoiceTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
	}
}
