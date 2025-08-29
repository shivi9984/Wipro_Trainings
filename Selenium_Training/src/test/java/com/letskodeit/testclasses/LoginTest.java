package com.letskodeit.testclasses;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import base.BaseSetUp;
import base.CheckPoint;
import utilities.Constants;



public class LoginTest extends BaseSetUp {
	
	@AfterMethod
	public void afterMethod() {
		if(nav.isUserLogIn()) {
			nav.logout();
			nav.login();
		}
	}
	@Test
	public void testLogin() {
		nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
		boolean headerResult = nav.verifyHeader();
//		Assert.assertTrue(headerResult);
		CheckPoint.mark("test-01", headerResult, "Header Verification");
		boolean result = nav.verifyHeader();
//		Assert.assertTrue(result);
		CheckPoint.markFinal("test-01", result, "Login Verification");
	}
	
	@Test
	public void testInvalidLogin() {
		nav = login.signInWith("tes@email.com", "abcabc");
		boolean result = nav.isUserLogIn();
		Assert.assertFalse(result);
	}
}
