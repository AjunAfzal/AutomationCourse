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
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']") WebElement profileDropdown;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']") WebElement logoutOption;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']") WebElement adminUserPage;
	
	public void clickOnProfileDropdown()
	{
		profileDropdown.click();
	}
	
	public void clickOnLogoutOption()
	{
		logoutOption.click();
	}
	
	//Clicking on MoreInfor of Admin User Tile
	public void clickOnAdminUserOption()
	{
		adminUserPage.click();
	}
}