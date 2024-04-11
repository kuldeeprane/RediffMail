package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="login1")
	WebElement txtLogin;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(name="proceed")
	WebElement btnSignIn;
	
	@FindBy(xpath="//b[contains(text(), 'Wrong username')]")
	WebElement errorbtn;
	
	public void ipLoginID(String id) {
		txtLogin.sendKeys(id);
	}
	
	public void ipPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void clickSigninBtn() {
		btnSignIn.click();
	}
	
	public boolean isErrorocc() {
		try {
		return errorbtn.isDisplayed();
		}catch(Exception e){
			return false;
		}
	}
}
