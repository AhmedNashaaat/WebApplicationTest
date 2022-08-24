package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndPropertiesFilTest extends TestBase 
{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginObject;
	
	String fName= LoadProperties.userData.getProperty("firstname");
	String lName= LoadProperties.userData.getProperty("lastname");
	String email= LoadProperties.userData.getProperty("email");
	String password= LoadProperties.userData.getProperty("password");
	
	
	
	@Test(priority = 1,alwaysRun = true)
	public void userCanRegisterSuccssfully() 
	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegestration(fName, lName, email, password);
		Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
		registerobject.userLogOut();
		
	}
	@Test(dependsOnMethods = "userCanRegisterSuccssfully")
	public void RegisteredUseCanlogout() {
		registerobject.userLogOut();
		
	}
	@Test(dependsOnMethods = "RegisteredUseCanlogout")
	public void RegisteredUserCanLogin() {
		homeobject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.setEmail(email, password);
		Assert.assertTrue(registerobject.logOut.getText().contains("Log out"));
		
	}
	

}
