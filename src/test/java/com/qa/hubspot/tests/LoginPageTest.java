package com.qa.hubspot.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BaseTest;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.util.Constants;

public class LoginPageTest extends BaseTest{

	@Test(priority = 2)
	public void verifyLoginPageTitleTest() {
		String titleLoginPage = loginPage.getLoginPageTitle();
		System.out.println("login page title is: " + titleLoginPage);
		Assert.assertEquals(titleLoginPage, Constants.LOGIN_PAGE_TITLE, Constants.LOGIN_TITLE_ERROR_MESSG);
	}

	@Test(priority = 1)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.isSignUpLinkExist(), Constants.SIGNUP_LINK_ERROR_MESSG);
	}

	@Test(priority = 3)
	public void loginTest() {
		HomePage homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}

}
