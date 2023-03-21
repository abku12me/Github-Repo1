package AdvancedSelenium.genericLib;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CommonUtility {
	
	public void logout(WebDriver driver)
	{
		WebElement log=driver.findElement(By.xpath("//td[contains(@onmouseover,'fnDropDownUser')][1]"));
		Actions act=new Actions(driver);
		act.moveToElement(log).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		
	}
	
	public void dropdownhandle(WebElement drop1,String visibletext )
	{
		Select s=new Select(drop1);
		s.selectByVisibleText(visibletext);
		
	}
	
	//public String calendarpop()
	//{
		
		//return modifiedddate;
		
	//}

}
