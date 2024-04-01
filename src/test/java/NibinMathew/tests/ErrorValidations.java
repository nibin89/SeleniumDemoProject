package NibinMathew.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import NibinMathew.tests.TestComponents.basetest;
import nibinMathew.pageobjects.CartPage;
import nibinMathew.pageobjects.Checkoutpage;
import nibinMathew.pageobjects.Landingpage;
import nibinMathew.pageobjects.ProductCatalog;
import nibinMathew.pageobjects.confirmationpage;

public class ErrorValidations extends basetest {

	public ErrorValidations(WebDriver driver) {
		super(driver);
		
	}

	@Test(groups= {"Error handling"})
	public void LoginErrorValidations() throws IOException, InterruptedException {

		// Invoke Chrome Driver without using System.SetProperty

		String productName = "ZARA COAT 3";
		String country = "Ind";
		ProductCatalog productcat = page.loginApplication("jonu@gmail.com", "Jonu123");
		Assert.assertEquals("Incorrect email or password.", page.Errormessage());

	}
	
	@Test(groups= {"Error handling"})
	public void productErrorvalidations() throws IOException, InterruptedException {

		// Invoke Chrome Driver without using System.SetProperty

		String productName = "ZARA COAT 3";
		String country = "Ind";
		ProductCatalog productcat = page.loginApplication("jonu@gmail.com", "Jonu12345");
		List<WebElement> products = productcat.getproductList();
		productcat.addProductTocart(productName);
		CartPage page = productcat.gotTocartpage();
		
		Boolean match = page.verifyProductDisplay(productName);
		Assert.assertFalse(match);
		
	}


}
