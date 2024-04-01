package nibinMathew.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nibinMathew.abstractComponents.Abstractcomponent;

public class Checkoutpage extends Abstractcomponent {

	WebDriver driver;

	// Page factory

	public Checkoutpage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//body//app-root//button[2]")
	WebElement SelectCountry;
	@FindBy(css = "input[placeholder='Select Country']")
	WebElement Country;
	@FindBy(css = ".btnn.action__submit")
	WebElement submit;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectcountry(String CountryName) {
		
		Actions a = new Actions(driver);
		a.sendKeys(Country,CountryName).build().perform();
		waitElementToAppear(results);
		SelectCountry.click();
		
	}
	
	public confirmationpage Submitorder() {
		
		submit.click();
		return new confirmationpage(driver);
		
	}

}
