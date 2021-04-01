package com.eBankingv2.testCases;


import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.eBankingv2.pageObjects.AddCustPage;
import com.eBankingv2.pageObjects.LoginPage;

public class TC_003_AddNewCust_Test extends BaseClass 
{
	@Test
	public void addNewCust() throws InterruptedException, IOException
	{
		LoginPage lp = new LoginPage(driver);
		logger.info("3rd Test Began. Adding New Customer");
		
		lp.setUserName(username);
		logger.info("Username has been entered");
		
		lp.setPassword(password);
		logger.info("Password has been entered");
		
		lp.clickSubmit();
		logger.info("Submit button has been clicked");
		
		Thread.sleep(3000);
				
		//Now Click on "New Customer" link and enter the customer details
		AddCustPage addCust = new AddCustPage(driver);
		
		addCust.clickNewCust();
		
		Thread.sleep(3000);
		
		logger.info("Providing Customer Details....");
		
		addCust.setCustName("Rambo");
		addCust.setGendMale("male");
		addCust.setDateOfBirth("12", "12", "1998");
		addCust.custaddress("123 Newton Rd");
		addCust.custcity("Bambara");
		addCust.custstate("Gauteng");
		addCust.custpinnum("879851");
		addCust.custtelephone("2256639878");
		
		//addCust.custemail("ORTambo@gmail.com");
		String email=randomString() + "@gmail.com";
		addCust.custemail(email);
		addCust.custPassword("abcdef123");
		addCust.clickSubmit();
		
		Thread.sleep(3000);

		boolean result= driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		logger.info("Started Validation...");
		
		if(result==true)
		{
			Assert.assertTrue(true);
			logger.info("Validation Pass");
				}
		else
		{
			captureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
			logger.info("Validation Failed....");
				}
		
	}
}