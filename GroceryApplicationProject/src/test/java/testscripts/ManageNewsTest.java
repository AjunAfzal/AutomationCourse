package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.TestNGBase;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends TestNGBase 
{
	@Test(priority = 1, description = "Validate adding a new News")
	public void VerifyWhetherUserIsAbleToAddANewNews() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickManageNewsTile = new HomePage(driver);
		clickManageNewsTile.clickOnManageNewsTile();

		String newNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		ManageNewsPage manageNPage = new ManageNewsPage(driver);
		manageNPage.clickOnNewButton();
		manageNPage.enterNewNewsOnManageNewsField(newNewsText);
		manageNPage.clickOnSaveButton();
		
		boolean newManageNewsSaveButton = manageNPage.isNewManageNewsPageDisplayed();
		Assert.assertTrue(newManageNewsSaveButton, Constant.AddNewManageNewsError);
	}

	@Test(priority = 2, description = "Validate searching for a News")
	public void VerifyWhetherUserIsAbleToSearchForANews() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickManageNewsTile = new HomePage(driver);
		clickManageNewsTile.clickOnManageNewsTile();

		String searchNewsText = ExcelUtility.readStringData(0, 0, "ManageNewsPage");

		ManageNewsPage manageNPage = new ManageNewsPage(driver);
		manageNPage.clickOnSearchButton();
		manageNPage.searchForANews(searchNewsText);
		manageNPage.clickOnSearchSubmitButton();
		
		boolean searchManageNewsSubmitButton = manageNPage.isSearchManageNewsPagePageDisplayed();
		Assert.assertTrue(searchManageNewsSubmitButton, Constant.SearchManageNewsError);
	}

	@Test(priority = 3, description = "Validate resetting the data in Manage News page")
	public void VerifyWhetherUserIsAbleToResetTheData() throws IOException 
	{
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");

		LoginPage login = new LoginPage(driver);
		login.enterUsernameOnUsernameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage clickManageNewsTile = new HomePage(driver);
		clickManageNewsTile.clickOnManageNewsTile();

		ManageNewsPage manageNPage = new ManageNewsPage(driver);
		manageNPage.resetAction();
		
		boolean searchManageNewsSubmitButton = manageNPage.isSearchManageNewsPagePageDisplayed();
		boolean resetManageNewsTable = manageNPage.isResetManageNewsPagePageDisplayed();
		Assert.assertEquals(!searchManageNewsSubmitButton, resetManageNewsTable, Constant.ResetManageNewsError);
	}
}