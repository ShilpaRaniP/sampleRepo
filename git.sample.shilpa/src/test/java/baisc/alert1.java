package baisc;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class alert1 {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://testpages.herokuapp.com/styled/alerts/alert-test.html");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='alertexamples']")).click();
		Alert ale=driver.switchTo().alert();
		Thread.sleep(2000);
		ale.accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='confirmexample']")).click();
		Thread.sleep(2000);
		Alert ale2=driver.switchTo().alert();
		String text = ale2.getText();
		ale2.dismiss();
		System.out.println(text);
		

	}

}
