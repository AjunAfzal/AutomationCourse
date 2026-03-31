package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public WebDriver driver;

	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username") WebElement usernameField;
	@FindBy(name = "password") WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']") WebElement loginButton;
	@FindBy(xpath = "//p[text() = 'Dashboard']") WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']") WebElement pageText;

	public LoginPage enterUsernameOnUsernameField(String userName) 
	{
		usernameField.sendKeys(userName);
		return this;
	}

	// We are staying in the same page. Hence replaced void with Class Name and added return this
	public LoginPage enterPasswordOnPasswordField(String password) 
	{
		passwordField.sendKeys(password);
		return this;
	}

	// Navigating to home page after login. So replaced void with HomePage and added return statement to home page
	public HomePage clickLoginButton() 
	{
		loginButton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed() 
	{
		return dashboard.isDisplayed();
	}
	
	public boolean isLoginPageDisplayed() 
	{
		return pageText.isDisplayed();
	}
	
	public String getPageText() 
	{ 
		return pageText.getText();
	}
}