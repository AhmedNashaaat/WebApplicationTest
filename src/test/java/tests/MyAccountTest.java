package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginObject;
	MyAccountPage MyAcountObject;
	String OldPassword = "123456789";
	String NewPassword = "123456";
	String FirstName = "Ahmed";
	String LastName = "Nashaat";
	String email = "test7@gmail.com";


	@Test(priority = 1)
	public void userCanRegisterSuccssfully() 
	{
		homeobject = new HomePage(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.userRegestration(FirstName, LastName,email, OldPassword);
		Assert.assertTrue(registerobject.successMessage.getText().contains("Your registration completed"));
	}
	@Test(priority = 2)
	public void RegisteredUserCanChangePassword() throws InterruptedException
	{
		MyAcountObject = new MyAccountPage(driver);
		registerobject.openMyAccountPage();
		MyAcountObject.OpenChangePasswordPage();
		MyAcountObject.ChangePassword(OldPassword, NewPassword);
		Assert.assertTrue(MyAcountObject.Passwordwaschanged.getText().contains("Password was changed"));
		MyAcountObject.closeMassage(); //Password was changed
		Thread.sleep(1000);
	}
	@Test(priority = 3)
	public void UserCanLogout() {
		registerobject.userLogOut();
	}
	@Test(priority = 4)
	public void UserCanLogin() {
		homeobject.openLoginPage();
		loginObject= new LoginPage(driver);
		loginObject.setEmail(email, NewPassword);
		Assert.assertTrue(registerobject.logOut.isDisplayed());
	}

}
