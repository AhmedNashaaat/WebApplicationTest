package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.CheckoutPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

public class GuestCheckoutProductFromCartTest extends TestBase {
	SearchPage searchObject;
	HomePage homeObject;
	ProductDetailsPage productDetails;
	ShoppingCartPage cartObject;
	CheckoutPage checkoutObject;
	ProductDetailsPage orderObject;
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

	@Test(priority=1)
	public void UserCanSearchForProductsWithAutoSuggest() throws InterruptedException {
		searchObject = new SearchPage(driver);
		searchObject.ProductSearchUsingAutoSuggest("MacB");
		productDetails = new ProductDetailsPage(driver);
		Assert.assertTrue(productDetails.productNamebreadCrumb.getText().contains(productName));
	}

	@Test(priority=2)
	public void UserCanAddProductToShoppingCart() throws InterruptedException {
		cartObject = new ShoppingCartPage(driver);
		productDetails.AddToCart();
		Thread.sleep(2000);
		productDetails = new ProductDetailsPage(driver);
		productDetails.NavigateToShopingCartBtn();
		cartObject = new ShoppingCartPage(driver);
		Assert.assertTrue(cartObject.totalLbl.getText().contains("3,600"));	
	}

	@Test(priority=3)
	public void UserCanCheckoutProduct() throws InterruptedException {
		checkoutObject = new CheckoutPage(driver);
		cartObject.openCheckoutPageAsGuest();
		checkoutObject.CheckoutProduct(firstname, lastname, "Egypt", email, address, postcode, phone, city, productName);
	
		Assert.assertTrue(checkoutObject.prodcutName.isDisplayed());
		Assert.assertTrue(checkoutObject.prodcutName.getText().contains(productName));
		checkoutObject.confirmOrder();
		Assert.assertTrue(checkoutObject.ThankYoulbl.isDisplayed());
	}

	@Test(priority=4)
	public void UserCanViewOrderDetails() throws InterruptedException {
		orderObject = new ProductDetailsPage(driver);
		checkoutObject.viewOrderDetails();
		Assert.assertTrue(driver.getCurrentUrl().contains("orderdetails"));
		//		orderObject.DownloadPDFInvoice();
		//		Thread.sleep(3000);
		//		orderObject.PrintOrderDetails();
	}

}
