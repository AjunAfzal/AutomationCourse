package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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