package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//*[contains(@class, 'moneyicon')]")
	public WebElement moneyLink;
	
	@FindBy(xpath="//a[contains(text(), 'Sign in')]")
	public WebElement signinLink;
	
	public void clickMoneyLink() {
		moneyLink.click();
	}
	
	public void clickSignInLink() {
		signinLink.click();
	}
}
