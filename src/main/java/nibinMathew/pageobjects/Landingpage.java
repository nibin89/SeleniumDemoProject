package nibinMathew.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import nibinMathew.abstractComponents.Abstractcomponent;

public class Landingpage extends Abstractcomponent {

	WebDriver driver;

	// Page factory

	public Landingpage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "userEmail")
	WebElement UserEmail;
	// WebElement Useremail = driver.findElement(By.id("userEmail"));

	@FindBy(id = "userPassword")
	WebElement passwordelement;
	// driver.findElement(By.id("userPassword"))

	@FindBy(css = "input[id='login']")
	WebElement login;
	// driver.findElement(By.cssSelector("input[id='login']")).click();
	
	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement Errormessage;
	
	//div[aria-label='Incorrect email or password.']

	public ProductCatalog loginApplication(String email, String password) {

		UserEmail.sendKeys(email);
		passwordelement.sendKeys(password);
		login.click();
		ProductCatalog productcat = new ProductCatalog(driver);
		return productcat;
	}
	
	public String Errormessage() {
		
		
		waitforWebElementToAppear(Errormessage);
		return Errormessage.getText();
		
	}

	public void gotopage() {

		driver.get("https://rahulshettyacademy.com/client");
	}

}
