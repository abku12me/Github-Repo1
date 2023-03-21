package Vtigerapplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AdvancedSelenium.genericLib.BaseClass;
import AdvancedSelenium.genericLib.CommonUtility;
import AdvancedSelenium.genericLib.DataUtility;
@Listeners(AdvancedSelenium.genericLib.ListenerImplementation.class)
public class CreateProductModule extends BaseClass{
	CommonUtility cu=new CommonUtility();
	DataUtility du=new DataUtility();
	@Test
	public void producthandle() throws EncryptedDocumentException, IOException
	{
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.cssSelector("[title='Create Product...']")).click();
		// product name
		
		driver.findElement(By.name("productname")).sendKeys(du.datafromExcelsheet("Sheet1", 3, 1));
		// date selection java concept
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,7);
		Date currentdate=cal.getTime();
		SimpleDateFormat fors=new SimpleDateFormat("yyyy-MM-dd");
		String modifieddate=fors.format(currentdate);
		
		
		driver.findElement(By.name("sales_start_date")).sendKeys(modifieddate);
		//save
		driver.findElement(By.cssSelector("[accesskey='S']")).click();
	}
	

}
