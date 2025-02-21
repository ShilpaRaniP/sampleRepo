package miscellaneous_topics;

import java.time.Duration;
import java.util.concurrent.CyclicBarrier;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SelectDate {
	
	@Test
	public void selectDate_redBus() throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.redbus.in/");
		
		driver.findElement(By.xpath("//i[@class=\"sc-cSHVUG NyvQv icon icon-datev2\"]")).click();
		driver.findElement(By.xpath("//span[.=21]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class=\"sc-cSHVUG NyvQv icon icon-datev2\"]")).click();
		driver.findElement(By.id("Layer_1")).click();
		driver.findElement(By.xpath("//span[.=14]")).click();
		driver.quit();
	}


@Test
public void selectDate_irctc() throws InterruptedException
{
	ChromeOptions opt=new ChromeOptions();
	opt.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(opt);
	driver.get("https://www.irctc.co.in/nget/train-search");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.findElement(By.xpath("//span[@class='ng-tns-c57-8 ui-autocomplete ui-widget']/input")).sendKeys("Bangalore", Keys.ENTER);
	driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();
	driver.findElement(By.xpath("//span[@class='ng-tns-c57-9 ui-autocomplete ui-widget']/input")).sendKeys("Hyderabad", Keys.ENTER);
	driver.findElement(By.xpath("//ul[@role='listbox']/li")).click();
	driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
	
	driver.findElement(By.xpath("//a[.='21']")).click();
	
	}

	@Test
	public void makemytripSelectDate()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		driver.findElement(By.xpath("//div[.='March 2025']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='18']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
		WebElement nextMonth = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
		while(true) 
		{
			try 
			{
				driver.findElement(By.xpath("//div[.='August 2025']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='18']")).click();
				break;
			}
			catch(Exception E) 
			{
				nextMonth.click();
			}
		}
	}
	
	@Test
	public void airIndiaSelectDate()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.airindia.com/");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		driver.findElement(By.xpath("//input[@id='dpFromDate']")).click();
		
		driver.findElement(By.xpath("//div[@class='ngb-dp-month-name' and text()=' February 2025 ']/ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' 21 ']")).click();
		driver.findElement(By.xpath("//div[@class='ngb-dp-month-name' and text()=' February 2025 ']/ancestor::div[@class='ngb-dp-month']/descendant::div[text()=' 24 ']")).click();
	}
	
	@Test
	public void goIbiboSelectDate()
	{
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']/ancestor::div[@class='sc-12foipm-2 eTBlJr fswFld ']")).click();
		driver.findElement(By.xpath("//div[text()='March 2025']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='3']")).click();
		
	}
		
}