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

	public void enterUsernameOnUsernameField(String userName) 
	{
		usernameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) 
	{
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() 
	{
		loginButton.click();
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