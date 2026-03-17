package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HandlingJSExecutor extends Base
{
	public void verifyJSExecutor()
	{
		driver.navigate().to("https://selenium.qabible.in/simple-form-demo.php");
		WebElement button = driver.findElement(By.id("button-one"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
		js.executeScript("window.scrollBy(0,-350)", "");
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingJSExecutor jsExec = new HandlingJSExecutor();
		jsExec.browserLaunch();
		jsExec.verifyJSExecutor();
	}

}
