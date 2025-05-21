package webTables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DynamicWebTables {
	
	WebDriver driver;
	
	@BeforeSuite
	public void initialization() {
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	@Test (priority=1)
	public void Login() {
		driver.findElement(By.className("btn btn-primary")).click();
	}
	
	
	
	
}
