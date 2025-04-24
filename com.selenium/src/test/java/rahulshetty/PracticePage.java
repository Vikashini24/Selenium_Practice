package rahulshetty;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class PracticePage {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initializeDriver() {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test (priority=1)
	public void radioButton() {
		WebElement button = driver.findElement(By.xpath("//input[@value='radio2']"));
		button.click();
	}
	
	@Test (priority=2)
	public void suggessionClass() {
		WebElement field = driver.findElement(By.id("autocomplete"));
		field.sendKeys("ind");
		List<WebElement> dropdownList = driver.findElements(By.xpath("//ul/li[@class='ui-menu-item']"));
		for(WebElement dropdown : dropdownList) {
			String text = dropdown.getText();
			if(text.equalsIgnoreCase("India")) {
				dropdown.click();
				break;
			}
		}
		System.out.println(field.getDomProperty("value"));
	}
	
	@Test (priority=3)
	public void staticDropdown() {
		WebElement dropdownField = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropdownField);
		
	}
	
	
	
	
	
}
