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
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="user-name") WebElement usernameField;
	@FindBy(id="password") WebElement passwordField;
	@FindBy(id="login-button") WebElement loginButton;
	
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
}