package tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest  extends TestBase

{
	HomePage objectHome;
	@Test
	public void HoverMenuTest() throws InterruptedException
	{
		objectHome = new HomePage(driver);
		Thread.sleep(1000);
		objectHome.selectNotebooksMenu();
		Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/cell-phones"));
		}
	

}
