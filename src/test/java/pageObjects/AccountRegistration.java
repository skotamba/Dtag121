package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistration extends BasePage
{
	public AccountRegistration(WebDriver driver) 	
{
	super(driver);
}


@FindBy(xpath="//input[@id='input-firstname']")
WebElement txtFirstName;

@FindBy(xpath="//input[@id='input-lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='input-email']")
WebElement txtemail;

@FindBy(xpath="//input[@id='input-telephone']")
WebElement txtTelephone;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='input-confirm']")
WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']")
WebElement chkPolicy;

//@FindBy(xpath="//label[normalize-space()='No']")

@FindBy(xpath="//input[@value='Continue']")
WebElement btnContinue;

@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;

public void setFirstName(String fname)
{
	txtFirstName.sendKeys(fname);
}
public void setLastName(String lname)
{
	txtLastName.sendKeys(lname);
}
public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setTelephone(String tel)
{
	txtTelephone.sendKeys(tel);
}
public void setPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String pwd)
{
	txtConfirmPassword.sendKeys(pwd);
}
public void setPrivacyPolicy()
{
	chkPolicy.click();
	
}
public void clickContinue()
{
	btnContinue.click();
}
public String msgConfirmation()
{
	try {
		return(msgConfirmation.getText());
	}
		catch(Exception e)
	{
			return(e.getMessage());
	}
	
	}
}


