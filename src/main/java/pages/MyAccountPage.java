package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {
	 
	

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText = "Change password")
	 public WebElement changePasswordBtn;
	
	@FindBy(id ="OldPassword")
	WebElement OldPasswordTxt;
	
	@FindBy(id= "NewPassword")
	WebElement NewPasswordTxt;
	
	@FindBy (id = "ConfirmNewPassword")
	WebElement ConfirmNewPasswordTxt;
	
	@FindBy(css = "button.button-1.change-password-button")
	WebElement SumitBtn;
	
	@FindBy(css = "p.content")
	public WebElement Passwordwaschanged;
	 @FindBy(css = "span.close")
	 WebElement CloseMassage;
	
	
	
	public void OpenChangePasswordPage() {
		clickBtn(changePasswordBtn);
	}
	public void ChangePassword(String OldPassword,String NewPassword)
	{
		setTextElementText(OldPasswordTxt, OldPassword);
		setTextElementText(NewPasswordTxt, NewPassword);
		setTextElementText(ConfirmNewPasswordTxt, NewPassword);
		clickBtn(SumitBtn);
		
	}
	public void closeMassage() {
		clickBtn(CloseMassage);
		
	}

}
