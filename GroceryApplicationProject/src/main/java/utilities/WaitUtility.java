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
	 
	/* public void waitUntilElementToBeDisplayed(WebDriver driver, WebElement element) 
	 { 
	 		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ExplicitWait)); 
	 		wait.until(ExpectedConditions.element
	 }*/
}