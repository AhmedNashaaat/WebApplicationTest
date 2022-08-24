package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(id = "gender-male")
	WebElement genderRdoBtn;
	
	@FindBy(how = How.ID_OR_NAME , using = "FirstName")
	WebElement fnTxtBox;
	
	@FindBy(id="LastName")
	WebElement lnTxtBox;
	
	@FindBy(id = "Email")
	WebElement emailTxtBox;
	
	@FindBy(id="Password")
	WebElement passwordTxtBox;
	
	@FindBy(id= "ConfirmPassword")
	WebElement confirmPasswordTxtBox;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMessage;
	
	@FindBy(linkText =  "Log out")
	public WebElement logOut;
	
	@FindBy(linkText = "My account")
	WebElement openMyAccountPage;
	
	public void userRegestration(String firstName,String lastName,String email,String password) {
		clickBtn(genderRdoBtn);
		setTextElementText(fnTxtBox, firstName);
		setTextElementText(lnTxtBox, lastName);
		setTextElementText(emailTxtBox, email);
		setTextElementText(passwordTxtBox, password);
		setTextElementText(confirmPasswordTxtBox, password);
		clickBtn(registerBtn);
		
	}
	public void userLogOut() {
		clickBtn(logOut);
		
	}
	public void openMyAccountPage() {
	clickBtn(openMyAccountPage);
	}
}
