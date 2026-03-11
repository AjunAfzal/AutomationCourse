package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import seleniumbasics.TestNGBase;

public class LoginTest extends TestNGBase
{
	@Test
	public void verifyUserLoginWithValidCredentials()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	
	@Test
	public void verifyUserLoginWithValidUsernameInvalidPassword()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauces");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	
	@Test
	public void verifyUserLoginWitInvalidUsernameValidPassword()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_users");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauce");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials()
	{
		WebElement usernameField = driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_users");
		WebElement passwordField = driver.findElement(By.id("password"));
		passwordField.sendKeys("secret_sauces");
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
	}
}