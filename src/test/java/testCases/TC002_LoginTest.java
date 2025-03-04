package testCases;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	
	@Test
	public void loginTest()
	{
		try {
		
		HomePage hp=new HomePage(driver);
		hp.clickMyaccount();
		hp.linkLogin();
		
		
		LoginPage lp=new LoginPage(driver);
		
		lp.txtEmail("sridevinataraj49@gmail.com");
		lp.txtPassword("SriSonu@#2025");
		lp.btnLogin();
		}
		catch(Exception e)
		{
			 Assert.fail();
		}
		
	}
	
}
