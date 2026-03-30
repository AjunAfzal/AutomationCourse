package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;

public class TestNGBase 
{
	public WebDriver driver;
	Properties prop;
	FileInputStream f;

	@BeforeMethod(alwaysRun = true)
	@Parameters ("browsers")
	public void browserLaunch(String browsers) throws Exception 
	{
		prop = new Properties();
		f = new FileInputStream(Constant.ConfigFile);
		prop.load(f);
		
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (browsers.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browsers.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else 
		{
			throw new Exception("Invalid Browser");
		}
		
		// Direct URL Calling
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		
		// URL called from Config
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		// ImplicitWait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod(alwaysRun = true)
	public void closeAndQuit(ITestResult iTestResult) throws IOException 
	{
		if (iTestResult.getStatus() == ITestResult.FAILURE) 
		{
			ScreenshotUtility screenShot = new ScreenshotUtility();
			screenShot.getScreenshot(driver, iTestResult.getName());
		}
		 driver.quit();
	}
}