package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CaptchaPage;
import pageObjects.EmailPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_01_LoginTest extends BaseClass {
	
	@Test(groups= {"sanity", "master"})
	public void verifyLoginTest() {
		try {
		logger.info("******Staring Login Test******");
		HomePage hp = new HomePage(driver);
		hp.clickSignInLink();
		logger.info("Clicked on registeration link");
		
		LoginPage lp = new LoginPage(driver);
		lp.ipLoginID(p.getProperty("email"));
		logger.info("Entered email id");
		lp.ipPassword(p.getProperty("password"));
		logger.info("Entered Password");
		lp.clickSigninBtn();
		logger.info("Clicked sign in button");
		
		
		CaptchaPage cp = new CaptchaPage(driver);
		cp.clickImgText();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Entered captcha");
		cp.clickSubmit();
		logger.info("Logged into rediff");
		
		EmailPage ep = new EmailPage(driver);
		
		if(ep.getTitlee().equals("Rediffmail")) {
			Assert.assertTrue(true);
			logger.info("Test Passed.......");
		}else {
			logger.info("Test failed.....Title not as expected");
			Assert.fail();
		}
		
		}catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("******Finished Login Test******");
	}

}
