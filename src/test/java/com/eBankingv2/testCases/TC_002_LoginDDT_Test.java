package com.eBankingv2.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.eBankingv2.pageObjects.LoginPage;
import com.eBankingv2.utilities.XLUtils;

public class TC_002_LoginDDT_Test extends BaseClass 
{
	@Test(dataProvider="LoginData")
	public void LoginDDT(String username, String password) throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("2nd Test Began. Data Driven Test");
		logger.info("Username has been entered");
		
		lp.setPassword(password);
		logger.info("Password has been entered");
		
		lp.clickSubmit();
		Thread.sleep(5000);
		
//The below if condition will check for any popup msg box that appears ONLY when the login fails		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close the alert
			driver.switchTo().defaultContent();  //will focus on main page
			Assert.assertTrue(false);
			logger.info("Login failed");
				}
		else
			{
				Assert.assertTrue(true);
				logger.info("Login passed");
				lp.clickLogout();
				Thread.sleep(3000);
				driver.switchTo().alert().accept();
				driver.switchTo().defaultContent();
			}
	}
	
	public boolean isAlertPresent()  //User defined method created to check alert is present or not
	{
		try 
		{
		driver.switchTo().alert();
		return true;
				}
		catch(NoAlertPresentException e)
		{
			return false;
				}
	  }
			
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String xlfilepath=System.getProperty("user.dir") + "/src/test/java/com/eBankingv2/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(xlfilepath, "Sheet1");
		int colcount=XLUtils.getCellCount(xlfilepath, "Sheet1", 1);
		
		String logindata[][] = new String[rownum][colcount]; 
		
		for(int i=1; i<=rownum; i++)
		{
			for (int j=0; j<colcount; j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(xlfilepath, "Sheet1", i, j);   //1 0
					}	
			}
			return logindata;			
		}
	
	}