package nibinMathew.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import nibinMathew.abstractComponents.Abstractcomponent;

public class CartPage extends Abstractcomponent {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css= "li[class='totalRow'] button[type='button']")
	WebElement checkoutButton;
	
	@FindBy(css= ".cartSection h3")
	List <WebElement> cartproducts;


public Boolean verifyProductDisplay(String productName) {
	
	Boolean match = cartproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
	return match;
	
}

public Checkoutpage checkout() {
	
	checkoutButton.click();
	return new Checkoutpage(driver);
}
}
