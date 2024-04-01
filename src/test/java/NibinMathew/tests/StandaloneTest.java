package NibinMathew.tests;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

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

import io.github.bonigarcia.wdm.WebDriverManager;
import nibinMathew.pageobjects.Landingpage;

public class StandaloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Invoke Chrome Driver without using System.SetProperty
		
		
		String productName= "ZARA COAT 3";
		String country= "Ind";

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("jonu@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Jonu12345");
		driver.findElement(By.cssSelector("input[id='login']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4 ")));

		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4 "));

		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink *= cart]")).click();
		List <WebElement> cartproducts = driver.findElements(By.cssSelector("div.cart h3"));
		Boolean match = cartproducts.stream().anyMatch(product-> product.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		/*
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * cssSelector("input[placeholder='Select Country']")));
		 * driver.findElement(By.cssSelector("input[placeholder='Select Country']")).
		 * sendKeys(country);
		 */
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")),country).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.ng-star-inserted")));
		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.cssSelector(".btnn.action__submit")).click();
		String confirmationpage= driver.findElement(By.cssSelector("td[align='center'] h1")).getText();
		confirmationpage.equalsIgnoreCase("THANKYOU FOR THE ORDER.");
		Assert.assertTrue(confirmationpage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
