package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase {
	@Test(priority = 1)
	public void VerifyWhetherUserIsAbleToAddANewUser() throws IOException {
		
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickAuthUsersTile = new HomePage(driver);
		clickAuthUsersTile.clickOnAdminUserTile();

		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassword = faker.createRandomPassword();	
		//String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");
		//String newPassword = ExcelUtility.readStringData(0, 1, "AdminUsersPage");

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.clickOnNewButton();
		adminUserPage.enterNewUserNameOnUserNameField(newUserName);
		adminUserPage.enterNewPasswordOnPasswordField(newPassword);
		adminUserPage.clickOnNewUserTypeDropDown();
		adminUserPage.selectUserTypeFromUserTypeDropDown();
	}

	@Test(priority = 2)
	public void VerifyWhetherUserIsAbleToSearchForAUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickAuthUsersOption = new HomePage(driver);
		clickAuthUsersOption.clickOnAdminUserTile();

		String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.clickOnSearchButton();
		adminUserPage.searchUsingUserName(newUserName);
		adminUserPage.clickOnSearchUserTypeDropDown();
		adminUserPage.selectFromSearchUserTypeDropDown();
	}

	@Test(priority = 3)
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickAuthUsersOption = new HomePage(driver);
		clickAuthUsersOption.clickOnAdminUserTile();

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.resetAction();
	}
}