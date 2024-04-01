package nibinMathew.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import nibinMathew.abstractComponents.Abstractcomponent;

public class Orderpage extends Abstractcomponent {
	
	WebDriver driver;
	
	public Orderpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css= "li[class='totalRow'] button[type='button']")
	WebElement checkoutButton;
	
	@FindBy(css= "tr td:nth-child(3)")
	List <WebElement> orderproducts;


public Boolean verifyorderDisplay(String productName) {
	
	Boolean match = orderproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
	return match;
	
}

public Checkoutpage checkout() {
	
	checkoutButton.click();
	return new Checkoutpage(driver);
}
}
