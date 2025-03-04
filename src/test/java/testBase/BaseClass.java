package testBase;

import java.io.FileReader;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setup(String os, String br)
	{
	
		/*FileReader file=new FileReader("./src//test//resource//config.properties")
				p=new Properties();
		p.load(file);*/
		logger=LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome" : driver= new ChromeDriver(); break;
		case "edge" : driver= new EdgeDriver(); break;
		case "firefox" : driver= new FirefoxDriver(); break;
		default : System.out.println("defalt executing"); return;
		}
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		
		driver.get("https://tutorialsninja.com/demo/");   //reading url from properties file
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
	}

}
