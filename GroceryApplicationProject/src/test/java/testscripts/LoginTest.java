package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase 
{
	@Test(priority = 1, description = "Validate user login with valid creds", groups = {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean dashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, Constant.ValidLoginCredsError);
	}

	@Test(priority = 2, description = "Validate user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException 
	{
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.InvalidLoginPasswordError);
	}

	@Test(priority = 3, description = "Validate user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException 
	{
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertTrue(loginPageDisplayed, Constant.InvalidLoginUsernameError);
	}

	@Test(priority = 4, description = "Validate user login with invalid creds", groups = {"smoke"}, dataProvider = "loginProvider")
	public void verifyUserLoginWithInvalidCredentials(String userName, String password) throws IOException 
	{
		//Direct Read from Excel not used now as we are getting data from DataProvider
		//String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertFalse(!loginPageDisplayed, Constant.InvalidLoginCredsError);
	}
	 @DataProvider(name = "loginProvider") 
	 public Object[][] getDataFromDataProvider() throws IOException 
	 {	 
		 //Data provider input values shared by user
	 	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }}; 
	 	//Data provider input values taken from excel sheet
	 	//return new Object[][] { new Object[] {ExcelUtility.readStringData(3, 0, "LoginPage"),ExcelUtility.readStringData(3, 1, "LoginPage")}}; 		
	 }
}