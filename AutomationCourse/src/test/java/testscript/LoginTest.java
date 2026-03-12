package testscript;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import seleniumbasics.TestNGBase;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase
{
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		/* WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click(); */
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException
	{
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWitInvalidUsernameValidPassword() throws IOException
	{
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
}