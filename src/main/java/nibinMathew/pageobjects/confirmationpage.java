package nibinMathew.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nibinMathew.abstractComponents.Abstractcomponent;

public class confirmationpage extends Abstractcomponent {
	WebDriver driver;

	public confirmationpage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css= "td[align='center'] h1")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage() {
		
		return confirmationMessage.getText();
	}

}
