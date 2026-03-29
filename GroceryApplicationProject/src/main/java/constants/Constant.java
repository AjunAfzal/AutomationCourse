package constants;

public class Constant 
{
	public static final String TestDataFile = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	
	public static final String ValidLoginCredsError = "User was unable to login with valid creds";
	public static final String InvalidLoginPasswordError = "User was able to log in using Invalid Password";
	public static final String InvalidLoginUsernameError = "User was able to log in using Invalid Username";
	public static final String InvalidLoginCredsError = "Logged in with invalid creds";
	
	public static final String LogoutError = "User was unable to log out from the application";
	
	public static final String AddNewAdminUserError = "User was unable to log out from the application";
	public static final String SearchAdminUserError = "User was unable to log out from the application";
	public static final String ResetAdminUserError = "User was unable to log out from the application";
	
	public static final String AddNewManageNewsError = "User was unable to log out from the application";
	public static final String SearchManageNewsError = "User was unable to log out from the application";
	public static final String ResetManageNewsError = "User was unable to log out from the application";
}
