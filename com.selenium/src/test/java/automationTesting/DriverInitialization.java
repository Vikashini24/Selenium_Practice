package automationTesting;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class DriverInitialization {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://testautomationpractice.blogspot.com/");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	public void closeDriver() {
		if(driver!=null) {
			driver.close();
		}
	}
	
	@AfterSuite
	public void driverDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
