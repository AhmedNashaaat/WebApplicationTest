package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationWithDDTAndDataProviderTest extends TestBase 
{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginObject;
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] 
		{
			{"Ahmed","Nashaat","ahmed1@yahoo.com","12345678"},
			{"Huseen","Nashaat","Huseen@mail.com","1234567"}
			
		};
	}
	@Test(priority = 1,alwaysRun = true,dataProvider = "testData")
	public void userCanRegisterSuccssfully( String fName,String lName,String email,String password) 
	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegestration(fName, lName,email, password);
		Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
		registerobject.userLogOut();
		homeobject.openLoginPage();
		loginObject = new LoginPage(driver);
		loginObject.setEmail(email, password);
		Assert.assertTrue(registerobject.logOut.getText().contains("Log out"));
		registerobject.userLogOut();
	}


	

}
