package NibinMathew.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NibinMathew.tests.TestComponents.basetest;
import nibinMathew.pageobjects.CartPage;
import nibinMathew.pageobjects.Checkoutpage;
import nibinMathew.pageobjects.Orderpage;
import nibinMathew.pageobjects.ProductCatalog;
import nibinMathew.pageobjects.confirmationpage;

public class Submitorder extends basetest {
	
	String productName = "ZARA COAT 3";
	
	public Submitorder(WebDriver driver) {
		super(driver);
	}

	@Test
	public void submitorder() throws IOException, InterruptedException {

		// Invoke Chrome Driver without using System.SetProperty

		
		String country = "Ind";
		ProductCatalog productcat = page.loginApplication("jonu@gmail.com", "Jonu12345");
		List<WebElement> products = productcat.getproductList();
		productcat.addProductTocart(productName);
		CartPage page = productcat.gotTocartpage();
		
		Boolean Match = page.verifyProductDisplay(productName);
		Assert.assertTrue(Match);
		Checkoutpage checkpage = page.checkout();
		checkpage.selectcountry(country);
		confirmationpage cp = checkpage.Submitorder();
		String confirmationMessage = cp.getConfirmationMessage();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

	}
	@Test(dependsOnMethods = {"Submitorder"})
	public void OrderHistory() {
		
		ProductCatalog productcat = page.loginApplication("jonu@gmail.com", "Jonu12345");
		Orderpage orderpage=productcat.gotToOrderspage();
		Assert.assertTrue(orderpage.verifyorderDisplay(productName));
		
	}
	
	@DataProvider
	public Object [][] getdata() {
		
		return new Object[][] {{"jonu@gmail.com"},{"Jonu12345"}};
		
	}

}
