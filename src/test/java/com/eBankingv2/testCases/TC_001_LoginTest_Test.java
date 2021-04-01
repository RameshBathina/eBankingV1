package com.eBankingv2.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.eBankingv2.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_001_LoginTest_Test extends BaseClass 
{
	@Test
	public void LoginTest() throws IOException
	{
	logger.info("1st Test Began. Login Test");
		logger.info("URL has been opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Username has been entered");
		
		lp.setPassword(password);
		logger.info("Password has been entered");
		
		lp.clickSubmit();
		logger.info("Login Button has been clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test is Pass!!");
				}
		else
		{
			captureScreen (driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test is Fail.");
				}
	}
}