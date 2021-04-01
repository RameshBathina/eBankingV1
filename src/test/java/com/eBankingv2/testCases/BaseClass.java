package com.eBankingv2.testCases;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.eBankingv2.utilities.ReadConfig;
	
public class BaseClass 
{
	ReadConfig readConfig = new ReadConfig();
	
	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String password=readConfig.getPassword(); 
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass	
	public void setup(String bwsr) throws InterruptedException
	{
		logger = Logger.getLogger("eBanking Project");
		PropertyConfigurator.configure("Log4j.properties");
		
		System.out.println(bwsr);
		
		if(bwsr.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
		driver = new ChromeDriver();
		Thread.sleep(2000);
		driver.manage().window().maximize();
				}
		else if(bwsr.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEpath());
			driver = new InternetExplorerDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
				}
		else if(bwsr.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxpath());
			driver = new FirefoxDriver();
			Thread.sleep(2000);
			driver.manage().window().maximize();
				}
	
	//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseURL);
		Thread.sleep(1000);
			}	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
			}	

	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File (System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");		
			}
	
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
			}
	
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(4);
		return (generatedString2);
			}
 }