package seleniumbasics;

import org.openqa.selenium.By;

public class HandlingLocators extends Base
{

	public void verifyLocators()
	{
		driver.findElement(By.id("single-input-field"));
		
		driver.findElement(By.className("form-control"));
		
		driver.findElement(By.tagName("input"));
		
		driver.findElement(By.name("viewport"));
		
		driver.findElement(By.linkText("Radio Buttons Demo"));
		
		driver.findElement(By.partialLinkText("Radio"));
		
		driver.findElement(By.cssSelector("input[id='single-input-field']"));
		
		// /html/body/section/div/div/div[2]/div[1]/div/div[2]/form/button
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
	}

}
