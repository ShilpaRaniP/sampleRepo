package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;

public class JavaUtility{
	
	public int getRandomNumber() {
		Random random=new Random();
		int randomNo=random.nextInt(5000);
		return randomNo;
	}
	
	public String getSystemDateYYYYMMDD() {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		return date;
	}
	
	public String getRequiredDateYYYYMMDD(int days) {
		Date dateobj=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
		
	}

	public void ValidateIfContains(String text, String partialText) {
		if(text.contains(partialText))	{
			System.out.println(partialText + "	is Created Successfully=====PASS====");
		}
		else {
			System.out.println(partialText + "	 Creation Failed======FAIL=====");
		}
	}
	
	public void ValidateIfEquals(String str1, String str2) {
		if(str1.trim().contains(str2))	{
			System.out.println(str1 + "	is verified Successfully=====PASS====");
		}
		else {
			System.out.println(str1 + "	 verification Failed======FAIL=====");
		}
	}
	
	
	
}
