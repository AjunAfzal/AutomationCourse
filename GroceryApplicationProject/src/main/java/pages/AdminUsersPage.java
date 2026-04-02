package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage 
{
	public WebDriver driver;
	PageUtility page = new PageUtility();

	public AdminUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// For Adding New User
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='username']") WebElement newUserField;
	@FindBy(xpath = "//input[@id='password']") WebElement newPasswordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement newUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Create' and @class='btn btn-block-sm btn-danger']") WebElement newUserSaveButton;

	// For Searching a User
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']") WebElement searchButton;
	@FindBy(id = "un") WebElement searchUserField;
	@FindBy(id = "ut") WebElement searchUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Search' and @class='btn btn-block-sm btn-danger']") WebElement searchUserButton;


	// For Reset Option
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']") WebElement resetButton;

	public AdminUsersPage clickOnNewButton() 
	{
		newButton.click();
		return this;
	}

	public AdminUsersPage enterNewUserNameOnUserNameField(String newUserName) 
	{
		newUserField.sendKeys(newUserName);
		return this;
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPassword) 
	{
		newPasswordField.sendKeys(newPassword);
		return this;
	}

	public AdminUsersPage clickOnNewUserTypeDropDown() 
	{
		newUserTypeDropDown.click();
		return this;
	}

	public AdminUsersPage selectUserTypeFromUserTypeDropDown() 
	{
		page.selectDropdownWithIndex(newUserTypeDropDown, 2);
	//	Select select = new Select(newUserTypeDropDown);
	//	select.selectByIndex(2);
		return this;
	}
	
	public AdminUsersPage clickOnSaveButtonOfNewUserTypeDropDown()
	{
		newUserSaveButton.click();
		return this;
	}

	public AdminUsersPage clickOnSearchButton() 
	{
		searchButton.click();
		return this;
	}

	public AdminUsersPage searchUsingUserName(String newUserName) 
	{
		searchUserField.sendKeys(newUserName);
		return this;
	}

	public AdminUsersPage clickOnSearchUserTypeDropDown() 
	{
		searchUserTypeDropDown.click();
		return this;
	}

	public AdminUsersPage selectFromSearchUserTypeDropDown() 
	{
		Select select = new Select(searchUserTypeDropDown);
		select.selectByIndex(2);
		return this;
	}
	
	public AdminUsersPage clickOnSaveButtonOfSearchUserTypeDropDown()
	{
		searchUserButton.click();
		return this;
	}

	public AdminUsersPage resetAction() 
	{
		resetButton.click();
		return this;
	}

	public boolean isNewAdminUsersPageDisplayed() 
	{
		return newUserSaveButton.isEnabled();
	}

	public boolean isSearchAdminUsersPageDisplayed() 
	{
		return searchUserButton.isEnabled();
	}
}