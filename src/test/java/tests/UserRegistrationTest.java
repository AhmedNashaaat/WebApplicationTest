package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase 
{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginObject;
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccssfully() 
	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegestration("Ahmed", "Nashaat", "ahmed5555@gmail.com", "12345678");
		Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(dependsOnMethods = "userCanRegisterSuccssfully")
	public void RegisteredUseCanlogout() {
		registerobject.userLogOut();
		
	}
	@Test(dependsOnMethods = "RegisteredUseCanlogout")
	public void RegisteredUserCanLogin() {
		homeobject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.setEmail("ahmed5555@gmail.com", "12345678");
		Assert.assertTrue(registerobject.logOut.getText().contains("Log out"));
		
	}
	

}
