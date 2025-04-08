package automationTesting;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

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
	
	@Test (priority=1)
	public void textboxElements() {
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("Kanniya");
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("kanniya.mailinator.com");
		WebElement phone = driver.findElement(By.id("phone"));
		phone.sendKeys("9876543210");
		WebElement address = driver.findElement(By.id("textarea"));
		address.sendKeys("Coimbatore");
		System.out.println("Textboxes are filled");
	}
	
	@Test (priority=2)
	public void radioButton() {
		List<WebElement> gender = driver.findElements(By.xpath("//div[@class='form-group']/label[@for='gender']/following-sibling::div"));
		for (WebElement selectGender : gender) {
			String genderName = selectGender.getText();
			if(genderName.equals("Female")) {
				selectGender.click();
				break;
			}
		}
	}
	
	//div[@class='form-group']/label[@for='days']/following-sibling::div
	
//	@AfterSuite
//	public void driverDriver() {
//		if(driver!=null) {
//			driver.quit();
//		}
//	}
	
}
