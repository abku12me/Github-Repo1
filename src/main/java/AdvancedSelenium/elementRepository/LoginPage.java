package AdvancedSelenium.elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AdvancedSelenium.genericLib.DataUtility;

public class LoginPage {
	
	DataUtility du=new DataUtility();
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	@FindBy(name="user_name")
	private WebElement usernameTB;
	
	@FindBy(name="user_password")
	private WebElement passwordTB;
	
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	public WebElement getusername()
	{
		return usernameTB;
	}
	
	public WebElement getpassord()
	{
		
		return passwordTB;
	}
	
	public WebElement getlogin()
	{
		return loginbutton;
	}
	
	
	public void Logindetails() throws IOException
	{
		getusername().sendKeys(du.datafromprpoerties("username"));;
		getpassord().sendKeys(du.datafromprpoerties("password"));;
		getlogin().click();
		
	}
	

}
