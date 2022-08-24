package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
	
	

	public SearchPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(id = "small-searchterms")
	WebElement searchTxtBox;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productList;
	
	@FindBy(linkText ="Apple MacBook Pro 13-inch")
	 WebElement ProductTittle;
	
	
	public void productSearch(String productName ) {
		setTextElementText(searchTxtBox, productName);
		clickBtn(searchBtn);
		
	}
	public void OpenProductDetailsPage() {
		clickBtn(ProductTittle);
		
	}
	public void ProductSearchUsingAutoSuggest(String SearchTxt) {
		setTextElementText(searchTxtBox, SearchTxt);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickBtn(productList.get(0));
		
	}
	
	
}
