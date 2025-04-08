package automationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RadioButton {
	
	WebElement driver;
	
	@Test (priority=2)
	public void gender() {
		WebElement female = driver.findElement(By.id("female"));
		if(female.isEnabled()) {
			female.click();
		}
	}
	
}
