package testCases;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	
	//public WebDriver driver;
	
	@Test
	public void verify_account_registration()
	{
		
		logger.info("** Test started TC001_AccountRegistrationTest  ****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		logger.info(" Click My accpount is pass");
		hp.clickRegistration();
		
		AccountRegistration accreg=new AccountRegistration(driver);
		accreg.setFirstName(randomAlpha().toUpperCase());
		accreg.setLastName(randomAlpha().toUpperCase());
		accreg.setEmail(randomAlpha()+"@gmail.com");
		accreg.setTelephone(randomNumber());
		
		String pwd=randomAlbnum();
		accreg.setPassword(pwd);
		accreg.setConfirmPassword(pwd);
		accreg.setPrivacyPolicy();
		accreg.clickContinue();
		String confmsg=accreg.msgConfirmation();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error(" Test Fail........ ");
		}
	
	}

	/*@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();		
	}
	
	@AfterClass
	public void teardown()
	{
	driver.quit();
	}
	
	public String randomAlpha()
	{
		String generateAlpha=RandomStringUtils.randomAlphabetic(5);
		return generateAlpha;
	}
	public String randomNumber()
	{
		String generateNumeric=RandomStringUtils.randomNumeric(10);
		return generateNumeric;
	}
	public String randomAlbnum()
	{
		String generateAlpha=RandomStringUtils.randomAlphabetic(5);
		String generateNumeric=RandomStringUtils.randomNumeric(10);
		return( generateNumeric+generateAlpha);
	}*/

	
	
	
}

