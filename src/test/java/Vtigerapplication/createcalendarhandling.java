package Vtigerapplication;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AdvancedSelenium.genericLib.BaseClass;
@Listeners(AdvancedSelenium.genericLib.ListenerImplementation.class)
public class createcalendarhandling extends BaseClass{
	@Test
	public void calendarpop() throws InterruptedException, IOException
	{
		driver.findElement(By.linkText("Calendar")).click();
		driver.findElement(By.xpath("//img[contains(@onclick,'getMiniCal')]")).click();
		
		WebElement monthyear=driver.findElement(By.cssSelector("[Style='text-decoration: none;']"));
		System.out.println(monthyear);
		driver.findElement(By.linkText("8")).click();
		
		// screenshot
		
		
		
		
		}
		
	}
	


