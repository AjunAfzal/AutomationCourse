package constants;

public class Constant 
{
	// Input File
	public static final String TestDataFile = System.getProperty("user.dir") +"\\src\\test\\resources\\TestData.xlsx";
	// URL of Website being automated
	public static final String ConfigFile = System.getProperty("user.dir") + "\\src\\main\\resources\\config.properties";
	
	public static final String ManageNewsText = "News";
	
	public static final String AdminUsersTitle = "Admin Users";
	
	public static final String LoginPageExpectedText = "7rmart supermarket";
	
	// Assertion Error Messages
	// Login Page
	public static final String ValidLoginCredsError = "User was unable to login with Valid Creds";
	public static final String InvalidLoginPasswordError = "User was able to log in using Invalid Password";
	public static final String InvalidLoginUsernameError = "User was able to log in using Invalid Username";
	public static final String InvalidLoginCredsError = "USer was able to log in with Invalid Creds";
	
	// Logout Page
	public static final String LogoutError = "User was unable to Log Out from the application";
	
	// Admin Users Page
	public static final String AddNewAdminUserError = "User was unable to add a New User";
	public static final String SearchAdminUserError = "User was unable to Search for a User";
	public static final String ResetAdminUserError = "User was unable to reset the Admin User Page";
	
	// Manage News
	public static final String AddNewManageNewsError = "User was unable to add a New News";
	public static final String SearchManageNewsError = "User was unable to Search for a News";
	public static final String ResetManageNewsError = "User was unable to reset the Manage News Page";
}