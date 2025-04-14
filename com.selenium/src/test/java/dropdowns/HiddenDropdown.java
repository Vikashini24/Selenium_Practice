package dropdowns;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HiddenDropdown {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeSuite
	public void initializeDriver() {
		if(driver==null) {
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
	}
	
	@Test (priority=1)
	public void autosuggestiveDropdown() {
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
		loginButton.click();
		WebElement clickPIM = driver.findElement(By.linkText("PIM"));
		clickPIM.click();
		WebElement dropdown = driver.findElement(By.xpath("//label[text()='Job Title']/ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//div/div[@class='oxd-select-text-input']"));
		dropdown.sendKeys("Automation Tester" + Keys.ENTER);
	}
	
	@AfterSuite
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
}
