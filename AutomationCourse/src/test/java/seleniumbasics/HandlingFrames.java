package seleniumbasics; 
  
 import java.util.List; 
  
 import org.openqa.selenium.By; 
 import org.openqa.selenium.WebElement; 
  
 public class HandlingFrames extends Base 
 { 
 	 
 	public void verifyFrames() 
 	{ 
 		driver.navigate().to(" https://demoqa.com/frames"); 
 		List<WebElement>totalFrame=driver.findElements(By.tagName("iframe")); 
 		System.out.println(totalFrame.size()); 
 		 
 		WebElement frame= driver.findElement(By.id("frame1")); 
 		driver.switchTo().frame(frame); 
 		WebElement text= driver.findElement(By.id("sampleHeading")); 
 		System.out.println(text.getText()); 
 		driver.switchTo().defaultContent(); 
 	} 
  
 	public static void main(String[] args)
 	{ 
 		HandlingFrames frames= new HandlingFrames(); 
 		frames.browserLaunch(); 
 		frames.verifyFrames(); 		 
 	} 
 }