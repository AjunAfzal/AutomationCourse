package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	public static int ExplicitWait = 5;
	public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) 
	{ 
	 	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait)); 
	 	wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	 
	public void waitUntilAlertIsPresent(WebDriver driver, WebElement element) 
	{
		WebDriverWait alert = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		alert.until(ExpectedConditions.alertIsPresent());
	}

	public void waitUntilElementIsSelected(WebDriver driver, WebElement element) 
	{
		WebDriverWait select = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		select.until(ExpectedConditions.elementToBeSelected(element));
	}

	public void waitUntilTextIsLocated(WebDriver driver, WebElement element) 
	{
		WebDriverWait text = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		text.until(ExpectedConditions.textToBePresentInElementValue(element, "News"));
	}

	public void waitUntilTitleIsLocated(WebDriver driver, WebElement element) 
	{
		WebDriverWait title = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait));
		title.until(ExpectedConditions.titleIs("Admin Users"));
	}
}