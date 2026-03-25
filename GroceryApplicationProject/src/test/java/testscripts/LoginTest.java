package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends TestNGBase {
	@Test(priority = 1, description = "Validate user login with valid creds", groups = {"smoke"})
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean dashboardDisplayed = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed, "User was unable to login with valid creds");
	}

	@Test(priority = 2, description = "Validate user login with valid username and invalid password")
	public void verifyUserLoginWithValidUsernameInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, "User was able to log in using Invalid Password");
	}

	@Test(priority = 3, description = "Validate user login with invalid username and valid password")
	public void verifyUserLoginWithInvalidUsernameValidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertTrue(loginPageDisplayed, "User was able to log in using Invalid Username");
	}

	@Test(priority = 4, description = "Validate user login with invalid creds", groups = {"smoke"})
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		boolean loginPageDisplayed = login.isLoginPageDisplayed();
		Assert.assertFalse(!loginPageDisplayed, "Logged in with invalid creds");
	}
}