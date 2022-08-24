package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(css="strong.current-item")
	public WebElement productNamebreadCrumb; 

	@FindBy(css="input.button-2.email-a-friend-button")
	WebElement emailFriendBtn ; 

	@FindBy(css="span.price-value-4")
	public WebElement productPricelbl ;

	@FindBy(id="add-to-wishlist-button-4")
	WebElement addToWishlistBtn ; 

	@FindBy(linkText="Add your review")
	WebElement addReviewLink; 

	@FindBy(css="button.button-2.add-to-compare-list-button")
	WebElement addToCompareBtn ; 
	
	@FindBy(id="add-to-cart-button-4")
	WebElement addToCartBtn ; 
	
	@FindBy(linkText = "shopping cart")
	WebElement ShopingCartBtn;

	public void openSendEmail() 
	{
		clickBtn(emailFriendBtn);
	}

	public void openAddReviewPage() 
	{
		clickBtn(addReviewLink);
	}

	public void AddProductToWishlist() 
	{
		clickBtn(addToWishlistBtn);
	}

	public void AddProductToCompare() 
	{
		clickBtn(addToCompareBtn);
	}

	public void AddToCart() 
	{
		clickBtn(addToCartBtn);
	}
	
	public void NavigateToShopingCartBtn() {
		clickBtn(ShopingCartBtn);
	}


}
