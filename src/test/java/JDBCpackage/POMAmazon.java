package JDBCpackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import AdvancedSelenium.elementRepository.AmazonPage;

public class POMAmazon {
	@Test
	public  void auto()
	{
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		// handle auto suggestion
		
		AmazonPage ap=new AmazonPage(driver);
		ap.getautosugg();
		ap.getsugg();
		
		
		
	}

}
