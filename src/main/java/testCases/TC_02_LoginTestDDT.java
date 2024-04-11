package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CaptchaPage;
import pageObjects.EmailPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_02_LoginTestDDT extends BaseClass {
	// login data driven test

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verifyLoginTestDDT(String email, String pass, String result) {
		logger.info("******Starting TC_02_LoginTestDDT******");
		try {
			// ****Home Page steps****
			HomePage hp = new HomePage(driver);
			hp.clickSignInLink();

			// ****Login Page Steps
			LoginPage lp = new LoginPage(driver);
			lp.ipLoginID(email);
			lp.ipPassword(pass);
			lp.clickSigninBtn();
			boolean e = lp.isErrorocc();
			System.out.println(e);
			System.out.println(result);
			if (result.equalsIgnoreCase("invalid")) {
				if (e) {
					Assert.assertTrue(true);
				}
			} else {
				// ****Captcha page Steps
				CaptchaPage cp = new CaptchaPage(driver);
				cp.clickImgText();
				Thread.sleep(20000);
				cp.clickSubmit();

				// RediffMail page
				EmailPage ep = new EmailPage(driver);
				Boolean targetPage = ep.verifyIfElePresent();

				// validation Step if login has successfull or not
				if (result.equalsIgnoreCase("valid")) {
					if (targetPage == true) {
						ep.clickLogOut();
						Assert.assertTrue(true);
					} else {
						Assert.assertTrue(false);
					}
				}
				if (result.equalsIgnoreCase("invalid")) {
					if (targetPage == true) {
						ep.clickLogOut();
						Assert.assertTrue(false);
					} else {
						Assert.assertTrue(true);
					}
				}
			}
		} catch (Exception e) {
			Assert.fail("An exception occurred: " + e.getMessage());
		}

		logger.info("******Ended TC_02_LoginTestDDT******");
	}
}
