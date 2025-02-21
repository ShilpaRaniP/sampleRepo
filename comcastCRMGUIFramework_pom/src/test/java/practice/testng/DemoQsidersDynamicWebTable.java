package practice.testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DemoQsidersDynamicWebTable 
{
	@Test
	public void edit() throws InterruptedException
	{			
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoapps.qspiders.com/ui/table/dynamicTable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/div")).click();
		WebElement nameDD=driver.findElement(By.xpath("//select[@name='name']"));
		Select sel=new Select(nameDD);
		sel.selectByVisibleText("Jackets");
		WebElement Qntity=driver.findElement(By.xpath("//select[@name='quantity']"));
		Select sel1=new Select(Qntity);
		sel1.selectByVisibleText("3");
		driver.findElement(By.id("updatebtn")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//table/tbody/tr[2]/td[last()]/div")).click();
		WebElement nameDD2=driver.findElement(By.xpath("//select[@name='name']"));
		Select sel2=new Select(nameDD2);
		sel2.selectByVisibleText("Apple iPhone");
		WebElement Qntity2=driver.findElement(By.xpath("//select[@name='quantity']"));
		Select sel3=new Select(Qntity2);
		sel3.selectByVisibleText("1");
		driver.findElement(By.id("updatebtn")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[last()]/section")).click();
		driver.findElement(By.xpath("//button[.='Yes']")).click();
		
		Thread.sleep(1000);
		driver.close();
	
				
	}
}
