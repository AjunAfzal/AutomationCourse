package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement profileDropdown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logoutOption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUserTile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']") WebElement manageNewsTile;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement pageText;
	
	
	public HomePage clickOnProfileDropdown() 
	{
		profileDropdown.click();
		return this;
	}

	public LoginPage clickOnLogoutOption() 
	{
		logoutOption.click();
		return new LoginPage(driver);
	}

	// Clicking on MoreInfo of Admin User Tile
	public AdminUsersPage clickOnAdminUserTile() 
	{
		adminUserTile.click();
		return new AdminUsersPage(driver);
	}
	
	// Clicking on MoreInfo of Manage News Tile
	public ManageNewsPage clickOnManageNewsTile() 
	{
		manageNewsTile.click();
		return new ManageNewsPage(driver);
	}
}