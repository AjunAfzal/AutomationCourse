package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends TestNGBase
{
	@Test
	public void VerifyWhetherUserIsAbleToAddANewUser() throws IOException
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		HomePage clickAuthUsersOption = new HomePage(driver);
		clickAuthUsersOption.clickOnAdminUserOption();
		
		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.newUserCreation();
		adminUserPage.userSearch();
		adminUserPage.resetAction();	
	}
}