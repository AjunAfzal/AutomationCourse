package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends TestNGBase 
{
	HomePage home;
	
	@Test(priority = 1, description = "Validate adding a new User", groups = { "smoke" })
	public void VerifyWhetherUserIsAbleToAddANewUser() throws IOException 
	{

		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		HomePage clickAuthUsersTile = new HomePage(driver);
		clickAuthUsersTile.clickOnAdminUserTile();

		// Create Random Username and Password using Faker
		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassword = faker.createRandomPassword();

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.clickOnNewButton().enterNewUserNameOnUserNameField(newUserName).enterNewPasswordOnPasswordField(newPassword)
		.clickOnNewUserTypeDropDown().selectUserTypeFromUserTypeDropDown().clickOnSaveButtonOfNewUserTypeDropDown();

		boolean newAdminUsersSaveButton = adminUserPage.isNewAdminUsersPageDisplayed();
		Assert.assertTrue(newAdminUsersSaveButton, Constant.AddNewAdminUserError);
	}

	@Test(priority = 2, description = "Validate searching for a User", groups = { "smoke" })
	public void VerifyWhetherUserIsAbleToSearchForAUser() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		HomePage clickAuthUsersOption = new HomePage(driver);
		clickAuthUsersOption.clickOnAdminUserTile();

		String newUserName = ExcelUtility.readStringData(0, 0, "AdminUsersPage");

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.clickOnSearchButton().searchUsingUserName(newUserName).clickOnSearchUserTypeDropDown()
		.selectFromSearchUserTypeDropDown().clickOnSaveButtonOfSearchUserTypeDropDown();

		boolean searchAdminUsersSaveButton = adminUserPage.isSearchAdminUsersPageDisplayed();
		Assert.assertTrue(searchAdminUsersSaveButton, Constant.SearchAdminUserError);
	}

	@Test(priority = 3, description = "Validate resetting the data in Admin Users page")
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName).enterPasswordOnPasswordField(password);
		home=login.clickLoginButton();

		HomePage clickAuthUsersOption = new HomePage(driver);
		clickAuthUsersOption.clickOnAdminUserTile();

		AdminUsersPage adminUserPage = new AdminUsersPage(driver);
		adminUserPage.resetAction();

		boolean newAdminUsersSaveButton = adminUserPage.isNewAdminUsersPageDisplayed();
		boolean searchAdminUsersSaveButton = adminUserPage.isSearchAdminUsersPageDisplayed();
		Assert.assertEquals(!newAdminUsersSaveButton, !searchAdminUsersSaveButton, Constant.ResetAdminUserError);
	}
}