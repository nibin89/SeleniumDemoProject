package nibinMathew.pageobjects;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nibinMathew.abstractComponents.Abstractcomponent;

public class ProductCatalog extends Abstractcomponent {

	WebDriver driver;

	// Page factory

	public ProductCatalog(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}

	@FindBy(css = ".mb-3")
	List <WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	// List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4
	// "));

	By productsBy = By.cssSelector(".mb-3");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By ToastMessage = By.cssSelector("#toast-container");

	public List<WebElement> getproductList() {

		waitElementToAppear(productsBy);
	    return products;
	}
	
	public boolean areElementsPresent() {
	System.out.println();
        return !products.isEmpty();
    }
	
	
	public WebElement getProductbyName(String productName) {

		WebElement prod = getproductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;

	}

	public void addProductTocart(String productName) {

		WebElement prod = getProductbyName(productName);

		prod.findElement(addTocart).click();

		waitElementToAppear(ToastMessage);
		waitElementToDisappear(spinner);

	}

}