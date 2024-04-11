package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailPage extends BasePage {

	public EmailPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//li/a/b[contains(text(),'Write mail')]")
	WebElement writeMailEle;
	
	@FindBy(xpath="//a[@class='rd_logout']")
	WebElement logOutBtn;
	
	public String getTitlee() {
		return driver.getTitle();
	}
	
	public boolean verifyIfElePresent() {
		try {
			return writeMailEle.isDisplayed();  //returns true
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogOut() {
		logOutBtn.click();
	}

}
