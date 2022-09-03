package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage  extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}

	@FindBy(linkText="Register")
	WebElement registerLink ; 

	@FindBy(linkText="Log in")
	WebElement loginLink; 

	@FindBy(linkText="Contact us")
	WebElement contactUsLink ; 

	@FindBy(id="customerCurrency")
	WebElement currencydrl; 

	@FindBy(partialLinkText= "Computers  ")
	WebElement ComputerMenu; 

	@FindBy(partialLinkText =  "Notebooks  ")
	WebElement NotbooksMenu; 
	
	


	public void openRegistrationPage() 
	{
		clickBtn(registerLink);
	}

	public void openLoginPage() 
	{
		clickBtn(loginLink);
	}

	public void openContactUsPage() 

	{
		scrollToBottom();
		clickBtn(contactUsLink);
	}

	public void changeCurrency() 
	{
		select = new Select(currencydrl); 
		select.selectByVisibleText("Euro");
	}

	public void selectNotebooksMenu() 
	{
		action
		.moveToElement(ComputerMenu)
		.moveToElement(NotbooksMenu)
		.click()
		.build().perform();
	}
}
