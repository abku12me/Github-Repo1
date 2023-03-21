package Vtigerapplication;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AdvancedSelenium.elementRepository.OpportunityModules;
import AdvancedSelenium.genericLib.BaseClass;
import AdvancedSelenium.genericLib.CommonUtility;
import AdvancedSelenium.genericLib.DataUtility;
@Listeners(AdvancedSelenium.genericLib.ListenerImplementation.class)
public class createopportunitiesTest extends BaseClass{
	
	DataUtility du=new DataUtility();
	CommonUtility cu=new CommonUtility();
	@Test(groups="smoke")
	public void createopp() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.findElement(By.linkText("Opportunities")).click();
		driver.findElement(By.cssSelector("[title='Create Opportunity...']")).click();
		driver.findElement(By.name("potentialname")).sendKeys(du.datafromExcelsheet("Sheet1", 0, 0));
		 
		//handling first window pop-up
		
		driver.findElement(By.xpath("//img[contains(@onclick,'EditView')][1]")).click();
		String mainid=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		for(String id:allid)
		{
			if(!(mainid.equals(id)))
			{
				driver.switchTo().window(id);
			}
			
		}
		
		driver.findElement(By.cssSelector("[href='javascript:window.close();']")).click();
		driver.switchTo().window(mainid);
		
		//handling first Type drop down
		
		WebElement drop1=driver.findElement(By.name("opportunity_type"));
		cu.dropdownhandle(drop1, "Existing Business");
		
		// handle sales stage drop down
		
		WebElement drop2=driver.findElement(By.name("sales_stage"));
		cu.dropdownhandle(drop2, "Needs Analysis");
		
		
		// handle calendar pop 
		
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR,1);
		Date currentdate=cal.getTime();
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String modifiedddate=format.format(currentdate);
		System.out.println(modifiedddate);
		Thread.sleep(2000);
		
		driver.findElement(By.id("jscal_field_closingdate")).sendKeys(modifiedddate);
		
		//description
		driver.findElement(By.name("description")).sendKeys(du.datafromExcelsheet("Sheet1", 1, 1));
		
		
		//save 
		driver.findElement(By.cssSelector("[accesskey='S']")).click();
		
		// save and verify
		
		String expectedresult=driver.findElement(By.className("dvHeaderText")).getText();
		String acutalresult=expectedresult;
		Assert.assertEquals(expectedresult, acutalresult);
		System.out.println("TC is passed");
		
		
	}
	
	

}
