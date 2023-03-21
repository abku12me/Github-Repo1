package AdvancedSelenium.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import AdvancedSelenium.elementRepository.LoginPage;

public class BaseClass {
	public WebDriver driver;
	CommonUtility cu=new CommonUtility();
	DataUtility du=new DataUtility();
	public static WebDriver listenerDriver;
	@Parameters("browser")
	@BeforeClass(alwaysRun=true)
	public void LaunchBrowser(String browser)
	{
		if(browser.contains("chrome"))
		{
		driver=new ChromeDriver();
		listenerDriver=driver;
		}
		else if(browser.contains("Firefox"))
		{
			driver=new FirefoxDriver();
			listenerDriver=driver;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}
	
	@BeforeMethod(alwaysRun=true)
	public void loginapp() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		driver.get(du.datafromprpoerties("url"));
		lp.Logindetails();
		
	}
	@AfterMethod(alwaysRun=true)
	public void logoutapp()
	{
		cu.logout(driver);
		
	}
	@AfterClass(alwaysRun=true)
	public void closebrowser()
	{
		driver.quit();
	}
	

}
