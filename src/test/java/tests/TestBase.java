package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional ("chrome") String browserName) 
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			String chromePath = System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver",chromePath);
			driver = new ChromeDriver();
			
		}else if (browserName.equalsIgnoreCase("firefox")) {
			
			String chromePath = System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe";
			System.setProperty("webdriver.gecko.driver",chromePath);
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		driver.navigate().to("https://demo.nopcommerce.com/");
	}
	@AfterSuite
	public void stopDriver() {
		driver.quit();
	}
}
