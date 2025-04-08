package automationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkboxes {
	
	WebDriver driver;
	
	public void checkboxField() {
		List<WebElement> days = driver.findElements(By.id("//div[@class='form-group']/label[@for='days']/following-sibling::div"));
		
	}
	
}
