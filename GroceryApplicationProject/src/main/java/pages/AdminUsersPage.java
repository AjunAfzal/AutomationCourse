package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage 
{
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//For Adding New User
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//input[@id='username']") WebElement newUserField;
	@FindBy(xpath = "//input[@id='password']") WebElement newPasswordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement newUserTypeDropDown;
	@FindBy(xpath = "//button[@name='Create' and @class='btn btn-block-sm btn-danger']") WebElement newUserSaveButton;
	
	//For Searching a User
	@FindBy(xpath = "//a[@href='javascript:void(0)' and @onclick='click_button(2)']") WebElement searchButton;
	@FindBy(id="un") WebElement searchUserField;
	@FindBy(id="ut") WebElement searchUserTypeDropDown;
	@FindBy(xpath ="//button[@name='Search' and @class='btn btn-block-sm btn-danger']") WebElement searchUserButton;
	
	//For Reset Option
	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='btn btn-rounded btn-warning']") WebElement resetButton;
	
	public void newUserCreation()
	{
		newButton.click();
		newUserField.sendKeys("Big");
		newPasswordField.sendKeys("Lebowski");
		newUserTypeDropDown.click();
		Select select=new Select(newUserTypeDropDown);
		select.selectByIndex(2);
		newUserSaveButton.click();		
	}
	
	public void userSearch()
	{
		searchButton.click();
		searchUserField.sendKeys("Big");
		searchUserTypeDropDown.click();
		Select select=new Select(searchUserTypeDropDown);
		select.selectByIndex(2);
		searchUserButton.click();		
	}
	
	public void resetAction()
	{
		resetButton.click();
	}
}