package seleniumbasics;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingWebElements extends Base
{

	public void verifyWebElement()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		
		WebElement messageBox= driver.findElement(By.id("single-input-field"));
		messageBox.sendKeys("Sending Test Message");
		
		WebElement showButton=driver.findElement(By.id("button-one"));
		System.out.println(showButton.isDisplayed());
		System.out.println(showButton.isEnabled());
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(showButton));
		
		//Fluent Wait
		Wait<WebDriver> fluent = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5))
		.pollingEvery(Duration.ofSeconds(1))
		.ignoring(NoSuchElementException.class);
		fluent.until(ExpectedConditions.elementToBeClickable(showButton));
		
		showButton.click();
		
		WebElement yourMessage=driver.findElement(By.id("message-one"));
		System.out.println(yourMessage.getText());
		
		messageBox.clear();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingWebElements commands=new HandlingWebElements();
		commands.browserLaunch();
		commands.verifyWebElement();
		commands.closeAndQuit();
	}
}