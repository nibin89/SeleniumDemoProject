package NibinMathew.tests.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import nibinMathew.pageobjects.Landingpage;

public class basetest {

	public WebDriver driver;
	public Landingpage page;
	
	  public basetest(WebDriver driver) {
	        this.driver = driver;
	    }


	@BeforeClass
	public WebDriver initializeDriver() throws IOException {

		// properties class

		Properties prop = new Properties();

		// load file as Input stream and set the path dynamically if need to share the
		// file
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//nibinMathew//resources//GlobalData.Properties");
		prop.load(fis);
		// read the file property

		String BrowserName = prop.getProperty("browser");

		// set the browser

		if (BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		}

		else if (BrowserName.equalsIgnoreCase("firefox")) {

			// firefox
		} else if (BrowserName.equalsIgnoreCase("edge")) {

			// edge
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;

	}

	@BeforeMethod(alwaysRun = true)
	public Landingpage launchapplication() throws IOException {
		driver = initializeDriver();
		page = new Landingpage(driver);
		page.gotopage();
		return page;
	}

	@AfterMethod(alwaysRun = true)
	public void teardown() {

		driver.close();
	}

}
