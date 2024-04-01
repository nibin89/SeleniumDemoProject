package nibinMathew.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nibinMathew.pageobjects.CartPage;
import nibinMathew.pageobjects.Orderpage;

public class Abstractcomponent {
	
	WebDriver driver;
	

	public Abstractcomponent(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css = "[routerlink *= 'cart']")
	WebElement cartheader;
	
	@FindBy(css = "[routerlink *= 'myorders']")
	WebElement ordertheader;

	public void waitElementToAppear(By results) {
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	wait.until(ExpectedConditions.visibilityOfElementLocated( results));

}
	
	public void waitforWebElementToAppear(WebElement findby) {
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
	wait.until(ExpectedConditions.visibilityOf( findby));

}
	
	public CartPage gotTocartpage() {
		
		cartheader.click();
		CartPage page = new CartPage(driver);
		return page;
	}
	
	public Orderpage gotToOrderspage() {
		
		ordertheader.click();
		Orderpage  orderpage = new Orderpage(driver);
		return orderpage;
	}
	
	
	public void waitElementToDisappear(WebElement ele) {
		
		// 4 seconds - application to load
		
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));

}	
	
}