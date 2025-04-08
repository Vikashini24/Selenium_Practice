package automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Textboxes {
	
	WebDriver driver;
	
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
	}
	
}
