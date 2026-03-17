package seleniumbasics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingFileUpload extends Base
{

	public void fileUplodUsingSendKeys()
	{
		driver.navigate().to("https://demo.guru99.com/test/upload/");
		WebElement upload = driver.findElement(By.id("uploadfile_0"));
		upload.sendKeys("C:\\Users\\ADMIN\\git\\AutomationCourse\\AutomationCourse\\src\\test\\resources\\file-sample_150kB.pdf");
		WebElement checkBox = driver.findElement(By.id("terms"));
		checkBox.click();
		WebElement button = driver.findElement(By.id("submitbutton"));
		button.click();
	}
	
	public void fileUplodUsingRobot() throws AWTException
	{
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word");
		WebElement fileUpload = driver.findElement(By.id("pickfiles"));
		fileUpload.click();
		StringSelection s = new StringSelection("C:\\Users\\ADMIN\\git\\AutomationCourse\\AutomationCourse\\src\\test\\resources\\file-sample_150kB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		Robot r = new Robot();
		 r.delay(2500); 
	 		r.keyPress(KeyEvent.VK_ENTER); 
	 		r.keyRelease(KeyEvent.VK_ENTER); 
	 		r.keyPress(KeyEvent.VK_CONTROL); 
	 		r.keyPress(KeyEvent.VK_V); 
	 		r.keyRelease(KeyEvent.VK_CONTROL); 
	 		r.keyRelease(KeyEvent.VK_V); 
	 		r.keyPress(KeyEvent.VK_ENTER); 
	 		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingFileUpload file = new HandlingFileUpload();
		file.browserLaunch();
		//file.fileUplodUsingSendKeys();
		try {
			file.fileUplodUsingRobot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
