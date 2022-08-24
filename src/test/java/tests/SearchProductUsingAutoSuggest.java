package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductUsingAutoSuggest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	SearchPage SearchObject;
	ProductDetailsPage DetailsObject;
	
	@Test
	public void UserCanSearchWithAutoSuggesr() {
		try {
			SearchObject= new SearchPage(driver);
			SearchObject.ProductSearchUsingAutoSuggest("MacB");
			DetailsObject = new ProductDetailsPage(driver);
			Assert.assertEquals(DetailsObject.productNamebreadCrumb.getText(), productName);
		} catch (Exception e) {
			
			System.out.println("Error occourred "+e.getMessage());
		}
		
		
		
	}
}
