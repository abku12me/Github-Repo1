package Vtigerapplication;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import AdvancedSelenium.genericLib.BaseClass;
import AdvancedSelenium.genericLib.DataUtility;
@Listeners(AdvancedSelenium.genericLib.ListenerImplementation.class)
public class CreateDocumentsModule extends BaseClass{
	
	DataUtility du=new DataUtility();
	@Test
	public void framehandle() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{
		driver.findElement(By.linkText("Documents")).click();
		driver.findElement(By.cssSelector("[title='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys(du.datafromExcelsheet("Sheet1", 2, 1));
		
		WebElement move=driver.findElement(By.name("filename"));
		Actions act=new Actions(driver);
		act.moveToElement(move).click().build().perform();
		//by using javascript
	
		
		//JavascriptExecutor jse=(JavascriptExecutor)driver;
		//jse.executeScript("arguments[0].scollIntoView(true)",move);
		//move.click();
		
		
		
		
		//upload handle
		Thread.sleep(2000);
		
		//select the path
		StringSelection path=new StringSelection("C:\\Users\\mishr\\OneDrive\\Desktop\\Abhishek\\Test cases\\WARRANTYDETAILS.pdf");
		//copy the path
	  Clipboard	cb=Toolkit.getDefaultToolkit().getSystemClipboard();
	  cb.setContents(path, null);
	  
	  //paste the path
	  
	  Robot r=new Robot();
	  r.keyPress(KeyEvent.VK_CONTROL);
	  r.keyPress(KeyEvent.VK_V);
	  r.keyRelease(KeyEvent.VK_CONTROL);
	  r.keyRelease(KeyEvent.VK_V);
	  r.keyPress(KeyEvent.VK_ENTER);
	 r.keyRelease(KeyEvent.VK_ENTER);
	  
	  // save the changes
	  driver.findElement(By.cssSelector("[accesskey='S']")).click();
		
	}
	
	

}
