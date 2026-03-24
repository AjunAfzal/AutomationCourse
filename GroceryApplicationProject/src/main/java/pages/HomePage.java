package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileDropdown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logoutOption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
	WebElement adminUserTile;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
	WebElement manageNewsTile;
	
	public void clickOnProfileDropdown() {
		profileDropdown.click();
	}

	public void clickOnLogoutOption() {
		logoutOption.click();
	}

	// Clicking on MoreInfo of Admin User Tile
	public void clickOnAdminUserTile() {
		adminUserTile.click();
	}
	
	// Clicking on MoreInfo of Manage News Tile
	public void clickOnManageNewsTile() {
		manageNewsTile.click();
	}
}