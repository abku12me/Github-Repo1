package AdvancedSelenium.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener{

	
		
	public void onTestFailure(ITestResult result) {
		 String failed=result.getName();
			
			TakesScreenshot take=(TakesScreenshot)BaseClass.listenerDriver;
			File scr=take.getScreenshotAs(OutputType.FILE);
			File fil=new File("./screenshotfailed/failed.png");
			try {
				FileUtils.copyFile(scr, fil);
			} catch (IOException e) {
				
			}
	}
	
	

}
