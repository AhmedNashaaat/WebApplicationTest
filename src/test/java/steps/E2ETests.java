package steps;

import org.testng.Assert;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;
import tests.TestBase;

public class E2ETests extends TestBase {
	SearchPage searchpage;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	String productName = "Apple MacBook Pro 13-inch";
	Faker fakdata = new Faker();
	String firstname = fakdata.name().firstName();
	String lastname= fakdata.name().lastName();
	String email = fakdata.internet().emailAddress();
	//String country = fakdata.country().capital();
	String postcode = fakdata.number().digits(5).toString();
	String address = fakdata.address().fullAddress();
	String phone = fakdata.phoneNumber().toString();
	String city = fakdata.address().city();
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		Assert.assertTrue(driver.getCurrentUrl().contains("demo.nopcommerce.com")); 
	}
	@When("he search for {string}")
	public void he_search_for(String productName) {
		searchpage =new SearchPage(driver);
		searchpage.ProductSearchUsingAutoSuggest(productName);
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
		

	}
	@When("choose to buy Two items")
	public void choose_to_buy_two_items() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		productDetails.AddToCart();
		productDetails.NavigateToShopingCartBtn();
		
	}
	@When("moves to checkout cart and enter personal details on checkout page and place the order")
	public void moves_to_checkout_cart_and_enter_personal_details_on_checkout_page_and_place_the_order() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct(firstname, lastname, "Egypt", email, address, postcode, phone, city, productName);
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed()); 
	}
	@Then("he can view the order and download the invoice")
	public void he_can_view_the_order_and_download_the_invoice() {
		System.out.println("Thank You For Watching");
	}
}
