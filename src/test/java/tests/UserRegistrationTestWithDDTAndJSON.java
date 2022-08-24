package tests;



import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTAndJSON extends TestBase
{
	
	HomePage homeObject ; 
	UserRegistrationPage registerObject ; 
	LoginPage loginObject ; 

	@Test(priority=1,alwaysRun=true)
	public void UserCanRegisterSuccssfully() throws IOException, ParseException 
	{
		JsonDataReader jsonReader = new JsonDataReader(); 
		jsonReader.JsonReader();
		
		homeObject = new HomePage(driver); 
		homeObject.openRegistrationPage();
		registerObject = new UserRegistrationPage(driver); 
		registerObject.userRegestration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
		Assert.assertTrue(registerObject.successMessage.getText().contains("Your registration completed"));
		registerObject.userLogOut();
		homeObject.openLoginPage();
		loginObject = new LoginPage(driver); 
		loginObject.setEmail(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerObject.logOut.getText().contains("Log out"));
		registerObject.userLogOut();
	}

}
