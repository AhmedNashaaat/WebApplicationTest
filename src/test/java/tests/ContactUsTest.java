package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {

	HomePage home;
	ContactUsPage contactPage;
	Faker fakData= new Faker();

	String email = fakData.internet().emailAddress();
	String fullName = fakData.name().fullName();
	String enquiry = "Hello Admin , this is for test";

	@Test
	public void UserCanUseContactUs() {
		home = new HomePage(driver);
		home.openContactUsPage();
		contactPage = new ContactUsPage(driver);
		contactPage.ContactUs(fullName, email, enquiry);
		 Assert.assertTrue(contactPage.successMessage.getText()
				 .contains("Your enquiry has been successfully sent to the store owner."));
		 System.out.println(email+"\t"+fullName);
	}
}
