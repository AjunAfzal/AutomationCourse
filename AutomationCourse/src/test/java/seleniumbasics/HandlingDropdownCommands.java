package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdownCommands extends Base
{
	public void verifyDropdown()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement dropDown=driver.findElement(By.id("dropdowm-menu-1"));
		
		Select select=new Select(dropDown);
		//select.selectByIndex(2);
		//select.selectByValue("c#");
		select.selectByVisibleText("SQL");
	}
	
	public void verifyCheckBox()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement checkBox=driver.findElement(By.xpath("//input[@value='option-1']"));
		checkBox.click();
		System.out.println(checkBox.isSelected());
	}
	
	public void verifyRadioButton()
	{
		driver.navigate().to("https://www.webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		
		WebElement radioButton=driver.findElement(By.xpath("//input[@value='green']"));
		radioButton.click();
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingDropdownCommands drop=new HandlingDropdownCommands();
		drop.browserLaunch();
		//drop.verifyDropdown();
		drop.verifyCheckBox();
		//drop.verifyRadioButton();
		//drop.closeAndQuit();
	}

}
