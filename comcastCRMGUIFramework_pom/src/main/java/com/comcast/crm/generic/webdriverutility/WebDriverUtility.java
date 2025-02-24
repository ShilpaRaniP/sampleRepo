package com.comcast.crm.generic.webdriverutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility 
{
	public WebDriver selectBrowser(String BROWSER) {
		WebDriver driver;
		
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
		
		return driver;
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void waitForParticularUrl(WebDriver driver, String partialUrl) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}
	

	public void waitForParticularTitle(WebDriver driver, String partialTitle) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(partialTitle));
	}

	public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void waitForElementToBeInvisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	
	public void waitForListOfElementsToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
		
	
	public void switchToWindowBasedOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String WindowId=it.next();
			driver.switchTo().window(WindowId);
			String actUrl=driver.getCurrentUrl();
			if(actUrl.contains(partialUrl)) {
				break;
			}
		}
	}
	
	
	public void switchToWindowBasedOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()) {
			String WindowId=it.next();
			driver.switchTo().window(WindowId);
			String actUrl=driver.getTitle();
			if(actUrl.contains(partialTitle)) {
				break;
			}
		}
	}
	
	
	public void switchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	
	public void switchToFrame(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}
	
	
	public void switchToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	
	
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	
	public void select(WebElement element, String text) {
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}

	
	public void select(WebElement element, int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}
	
	
	public void mouseMoveOnElement(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	
	public void dragAndDrop(WebDriver driver, WebElement elementFrom, WebElement elementTo) {
		Actions act=new Actions(driver);
		act.dragAndDrop(elementFrom, elementTo).perform();
	}
	
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	
	public void scrollByAmount(WebDriver driver, int x, int y) {
		Actions act=new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	
	
	public void scrollToElement(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).perform();
	}
	
	
	public void scrollToElementAndClick(WebDriver driver, WebElement element) {
		Actions act=new Actions(driver);
		act.scrollToElement(element).click().perform();
	}
	
	
	public void sendKeysToElement(WebDriver driver, WebElement element, String keys) {
		Actions act=new Actions(driver);
		act.moveToElement(element).click().sendKeys(keys).perform();
	}
	
	
	public void takesScreenShot(WebDriver driver) throws IOException {
		String picsLoc="./ScreenShots/";
		Date d=new Date();
		String d1=d.toString();
		String d2=d1.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(picsLoc+d2+".jpeg");
		FileHandler.copy(src, dst);
	}
	
	
	public void scrollByAmountUsingJSE(WebDriver driver, int x, int y) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public void scrollToElementUsingJSE(WebDriver driver,WebElement element) {
		JavascriptExecutor jse=(JavascriptExecutor) driver;
		int x=element.getLocation().getX();
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
	public void openNewTabWithControlTransfer(WebDriver driver) {
		driver.switchTo().newWindow(WindowType.TAB);
	}
	
	
	public void switchToAlertAndGetText(WebDriver driver) {
		driver.switchTo().alert().getText();
	}
	
	
	public void switchToAlertAndSendKeys(WebDriver driver, String keys) {
		driver.switchTo().alert().sendKeys(keys);
	}
	
	
	public void mouseMoveOnElementAndClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.click(element).perform();
	}
	
}


