package AdvancedSelenium.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityModules {
	
	public OpportunityModules(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy()
	private WebElement Opportunitieslink;
	
	public WebElement getclick()
	{
		return Opportunitieslink;
	}
	
	public void clickaction()
	{
		getclick();
	}

}
