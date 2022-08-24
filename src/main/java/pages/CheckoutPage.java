package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "button.button-1.checkout-as-guest-button")
	private WebElement guestBtn;

	@FindBy(id = "BillingNewAddress_FirstName")
	private WebElement fnTxt;

	@FindBy(id = "BillingNewAddress_LastName")
	private WebElement lnTxt;

	@FindBy(id = "BillingNewAddress_Email")
	private WebElement emailTxt;

	@FindBy(id = "BillingNewAddress_CountryId")
	private WebElement countryList;

	@FindBy(id = "BillingNewAddress_PhoneNumber")
	private WebElement phoneTxt;

	@FindBy(id = "BillingNewAddress_City")
	private WebElement cityTxt;

	@FindBy(id = "BillingNewAddress_Address1")
	private WebElement addressTxt;

	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	private WebElement postCodeTxt;

	@FindBy(css =  "button.button-1.new-address-next-step-button") //1
	private WebElement save;
	
	@FindBy(css = "button.button-1.shipping-method-next-step-button")
	private WebElement continueShippingBtn2;
	
	@FindBy(css = "button.button-1.payment-method-next-step-button")
	private WebElement PaymentBtn;
	
	@FindBy(css = "button.button-1.payment-info-next-step-button")
	private WebElement PymentInfoSaveBtn;
	
	@FindBy(css = "button.button-1.confirm-order-next-step-button")
	private WebElement confirmBtn;


	@FindBy(id = "shippingoption_1")
	private WebElement shippingMethodRdo;

	@FindBy(css = "a.product-name")
	public WebElement prodcutName;
	
	@FindBy(css = "h1")
	public WebElement ThankYoulbl;

	@FindBy(css = "div.title")
	private WebElement successMessage;

	@FindBy(linkText = "Click here for order details.")
	private WebElement orderDetailsLink;


	public void RegisteredUserCheckoutProduct(String countryName, String address, 
			String postcode, String phone, String city, String productName) throws InterruptedException {
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickBtn(save);
		clickBtn(shippingMethodRdo);
		clickBtn(continueShippingBtn2);
		Thread.sleep(2000);
		clickBtn(PaymentBtn);
		Thread.sleep(2000);
		clickBtn(PymentInfoSaveBtn);
		clickBtn(confirmBtn);
		
	}
	
	public void confirmOrder() throws InterruptedException 
	{
		clickBtn(confirmBtn);
		Thread.sleep(2000);
	}

	public void viewOrderDetails() {
		clickBtn(orderDetailsLink);
	}


	public void CheckoutProduct(String firstName, String lastName, String countryName,
			String email, String address, String postcode, 
			String phone, String city, String productName) throws InterruptedException {
		setTextElementText(fnTxt, firstName);
		setTextElementText(lnTxt, lastName);
		setTextElementText(emailTxt, email);
		select = new Select(countryList);
		select.selectByVisibleText(countryName);
		setTextElementText(cityTxt, city);
		setTextElementText(addressTxt, address);
		setTextElementText(postCodeTxt, postcode);
		setTextElementText(phoneTxt, phone);
		clickBtn(save);
		clickBtn(shippingMethodRdo);
		clickBtn(continueShippingBtn2);
		Thread.sleep(2000);
		clickBtn(PaymentBtn);
		Thread.sleep(2000);
		clickBtn(PymentInfoSaveBtn);
		Thread.sleep(2000);
		clickBtn(confirmBtn);
		
	}
}
