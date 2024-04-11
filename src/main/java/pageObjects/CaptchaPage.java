package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaptchaPage extends BasePage {

	public CaptchaPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@value='Submit']")
	WebElement submit;
	@FindBy(id="imagetext")
	WebElement imgText;
	
	public void clickSubmit() {
		submit.click();
	}
	
	public void clickImgText() {
		imgText.click();
	}

}
