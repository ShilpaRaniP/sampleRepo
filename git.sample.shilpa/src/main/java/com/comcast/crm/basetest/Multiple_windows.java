package com.comcast.crm.basetest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_windows 
{
	public static void main(String[] args) throws InterruptedException 
	{
	
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		 
		String p_wind = driver.getWindowHandle();
		driver.findElement(By.linkText("Facebook")).click();
		Thread.sleep(1000);
		
		Thread.sleep(2000);
		Set<String> c_winds = driver.getWindowHandles();
		
		for(String win:c_winds)
		{
			driver.switchTo().window(win);
			if(driver.getTitle().contains("Facebook"))
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("shilpa@test.com");
				Thread.sleep(1000);
				driver.close();
			}
		}
		driver.switchTo().window(p_wind);
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(By.xpath("//input[@type='text' and @value='Search store']"));
		WebElement ele2 = driver.findElement(By.xpath("//input[@type='submit']"));
		
		ele1.sendKeys("computers");
		Thread.sleep(2000);
		ele2.click();
		
	}
	
}
