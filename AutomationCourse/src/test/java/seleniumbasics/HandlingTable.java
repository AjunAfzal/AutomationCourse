package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HandlingTable extends Base
{
	public void verifyTable()
	{
		driver.navigate().to("https://money.rediff.com/indices/nse");
		
	/*	WebElement fullTable = driver.findElement(By.id("dataTable"));
		System.out.println(fullTable.getText());
	*/	
		WebElement tableRow =driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[2]"));
		System.out.println(tableRow.getText());
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		HandlingTable table=new HandlingTable();
		table.browserLaunch();
		table.verifyTable();
		table.closeAndQuit();
	}
}