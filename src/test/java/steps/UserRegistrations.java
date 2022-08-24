package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistrationPage;
import tests.TestBase;

public class UserRegistrations extends TestBase {
	HomePage home ;
	UserRegistrationPage registrationObject;
	
	
	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		home =new HomePage(driver);
		home.openRegistrationPage();
	
	}
	@When("I click on register link")
	public void i_click_on_register_link() {
	 Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	@When("I entered {string},{string},{string},{string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		registrationObject = new UserRegistrationPage(driver);
		registrationObject.userRegestration(firstname, lastname, email, password);
	}


	@Then("The registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		registrationObject.userLogOut();
	}
}
