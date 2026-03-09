 package seleniumbasics; 
  
 import org.openqa.selenium.Alert; 
 import org.openqa.selenium.By; 
 import org.openqa.selenium.WebElement; 
  
 public class HandlingAlerts extends Base 
 { 
 	 
 	public void verifySimpleAlert() 
 	{ 
 		driver.navigate().to(" https://demoqa.com/alerts"); 
 		WebElement simpleAlert = driver.findElement(By.id("alertButton")); 
 		simpleAlert.click(); 
 		Alert al=driver.switchTo().alert(); 
 		al.accept(); 
 	} 
      
 	public void verifyConfirmAlert() 
 	{ 
 		driver.navigate().to(" https://demoqa.com/alerts"); 
 		WebElement confirmAlert= driver.findElement(By.id("confirmButton")); 
 		confirmAlert.click(); 
 		Alert al=driver.switchTo().alert(); 
 		al.dismiss(); 
 	} 
 	 
 	public void verifyPromptAlert() 
 	{ 
 		driver.navigate().to(" https://demoqa.com/alerts"); 
 		WebElement promptAlert= driver.findElement(By.id("promtButton")); 
 		promptAlert.click(); 
 		Alert al=driver.switchTo().alert(); 
 		al.sendKeys("Ajun"); 
 		al.accept(); 		 
 	} 
 	
 	public static void main(String[] args) { 
 		 
 		HandlingAlerts alert= new HandlingAlerts(); 
 		alert.browserLaunch(); 
 		//alert.verifySimpleAlert(); 
 		//alert.verifyConfirmAlert(); 
 		alert.verifyPromptAlert(); 
 	}  
 }