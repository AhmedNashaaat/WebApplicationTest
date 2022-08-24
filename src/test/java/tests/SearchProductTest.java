package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage DetailsObject;
	
	@Test
	public void UserCanSearchForProducts() {
		SearchObject = new SearchPage(driver);
		DetailsObject = new ProductDetailsPage(driver);
		SearchObject.productSearch(productName); 
		SearchObject.OpenProductDetailsPage();
		Assert.assertTrue(DetailsObject.productNamebreadCrumb.getText().equalsIgnoreCase(productName));
	}
}
