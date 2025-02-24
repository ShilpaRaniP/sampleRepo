package com.comcast.crm.generic.databaseutility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.autocarindia.com/");
		Thread.sleep(2000);
		WebElement ele = driver.findElement(By.xpath("(//img[@class='img-fluid inner-img visual-story-img'])[1]"));
		int x = ele.getLocation().getX();
		int y = ele.getLocation().getY();
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("window.scrollBy("+x+","+y+")");
		//.switchTo().frame(driver.findElement(By.xpath("//img[@alt='Rolls-Royce Spectre front tracking']")));

	}

}
