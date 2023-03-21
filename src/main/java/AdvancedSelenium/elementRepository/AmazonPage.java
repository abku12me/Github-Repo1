package AdvancedSelenium.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class AmazonPage {
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement searchtextboxText;
	@FindBy(id="nav-search-submit-button")
	private WebElement submitBtn;
	@FindBy(xpath="//div[@class='autocomplete-results-container']/div")
	private List<WebElement> autosugg;
	
	public AmazonPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getSearchtextboxText() {
		return searchtextboxText;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public List<WebElement> getAutosugg() {
		return autosugg;
	}
	
	// 
	public void getautosugg()
	{
		searchtextboxText.sendKeys("cricket");
		
	}
	
	public void getsugg() {
		
		for(WebElement all:autosugg)
		{
			String suggestion=all.getText();
			if(suggestion.contains("cricket bat"))
			{
				all.click();
				break;
			}
				
		
		}
		
	}

}
