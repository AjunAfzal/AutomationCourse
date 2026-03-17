package seleniumbasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MultipleWindowHandling extends Base
{
	public void verifyMultipleWindow()
	{
		driver.navigate().to("https://demo.guru99.com/popup.php");
		String firstWindow = driver.getWindowHandle();
		WebElement clickHere = driver.findElement(By.xpath("//a[text()='Click Here']"));
		clickHere.click();
		Set <String> handleIds = driver.getWindowHandles();
		Iterator <String> it = handleIds.iterator();
		while(it.hasNext())
		{
			String currentId = it.next();
			if(!currentId.equals(firstWindow))
			{
				driver.switchTo().window(currentId);
				WebElement email = driver.findElement(By.name("emailid"));
				email.sendKeys("ajun@gmail.com");
				WebElement button = driver.findElement(By.name("btnLogin"));
				button.click();
			}
		}
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		MultipleWindowHandling multWindow = new MultipleWindowHandling();
		multWindow.browserLaunch();
		multWindow.verifyMultipleWindow();
	}

}
