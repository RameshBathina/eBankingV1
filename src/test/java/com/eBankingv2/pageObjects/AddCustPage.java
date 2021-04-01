package com.eBankingv2.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustPage 
{
	WebDriver ldriver;
	
	public AddCustPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
			}
	
	//Identify Element Locators
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement LinkNewCust;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup 
	WebElement TxtCustName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement RadGendMale;
	
	@FindBy(how = How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
	@CacheLookup
	WebElement RadGenFemale;
	
	@FindBy(how = How.ID, using="dob")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr")
	@CacheLookup
	WebElement txtAddress;	
		
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement txtCity;
		
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement txtPinNum;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement txtTelephone;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement txtPassword;
		
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement btnSubmit;
	

//Action Methods for the above elements
	public void clickNewCust()
	{
		LinkNewCust.click();
		}
	
	public void setCustName(String cname)
	{
		TxtCustName.sendKeys("Ram");
		}
	
	public void setGendMale(String gender)
	{
		RadGendMale.click();
		}
	
	public void setGendFemale(String gender)
	{
		RadGenFemale.click();
		}
	
	public void setDateOfBirth(String mm, String dd, String yyyy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yyyy);
		}
	
	public void custaddress(String custaddr)
	{
		txtAddress.sendKeys(custaddr);
		}
	
	public void custcity(String city)
	{
		txtCity.sendKeys(city);	
		}
	
	public void custstate(String state)
	{
		txtState.sendKeys(state);
		}
	
	public void custpinnum(String pinno)
	{
		txtPinNum.sendKeys(String.valueOf(pinno));
		}
	
	public void custtelephone(String telno)
	{
		txtTelephone.sendKeys(telno);
		}
	
	public void custemail(String email)
	{
		txtEmail.sendKeys(email);
		}
	
	public void custPassword(String password)
	{
		txtPassword.sendKeys(password);
		}

	public void clickSubmit()
	{
		btnSubmit.click();
		}

}