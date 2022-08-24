package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = "td.remove-from-cart")
	WebElement removefromCartBtn;

	@FindBy(name = "updatecart")
	WebElement updateCartBtn;

	@FindBy(css = "input.qty-input valid")
	public WebElement quantityTxt;

	@FindBy(css = "td.subtotal")
	public WebElement totalLbl;

	
	@FindBy(id="checkout")
	WebElement checkoutBtn ; 
	
	@FindBy(id="termsofservice")
	WebElement agreeCheckbox; 
	
	@FindBy(css="button.button-1.checkout-as-guest-button")
	WebElement guestCheckoutBtn ; 

	public void RemoveProductFromCart() {
		clickBtn(removefromCartBtn);
	
	}

	public void UpdateProductQuantityInCart(String quantity) throws InterruptedException {
		//clear quantity textbox
		clearText(quantityTxt);
		setTextElementText(quantityTxt, quantity);
		clickBtn(updateCartBtn);
		Thread.sleep(1000);
	}

	public void openCheckoutPage() 
	{
		clickBtn(agreeCheckbox);
		clickBtn(checkoutBtn);
	}
	
	public void openCheckoutPageAsGuest() 
	{
		clickBtn(agreeCheckbox);
		clickBtn(checkoutBtn);
		clickBtn(guestCheckoutBtn);
	}
}
