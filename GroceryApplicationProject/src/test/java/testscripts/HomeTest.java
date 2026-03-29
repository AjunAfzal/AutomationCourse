package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase 
{
	@Test (description = "Validate user is able to logout from the application", retryAnalyzer = retrymechanism.Retry.class)
	public void verifyUserIsAbleToSuccessfullyLogout() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		// For Logout Option
		HomePage logout = new HomePage(driver);
		logout.clickOnProfileDropdown();
		logout.clickOnLogoutOption();
		
		String actualText = login.getPageText();
		String expectedText = "7rmart supermarket";
		Assert.assertEquals(actualText, expectedText, Constant.LogoutError);
	}
}